package se.johannesdahlgren.adventofcode2019.util;

import java.util.ArrayList;
import java.util.List;

public class PermutePhaseSettings {

  private List<List<Integer>> allPhaseSettings = new ArrayList<>();

  public List<List<Integer>> permute(List<Integer> input) {
    calculateAllPermutations(input.size(), input);
    return allPhaseSettings;
  }

  private void calculateAllPermutations(int n, List<Integer> elements) {
    if (n == 1) {
      savePermutation(elements);
    } else {
      for (int i = 0; i < n - 1; i++) {
        calculateAllPermutations(n - 1, elements);
        if (n % 2 == 0) {
          swap(elements, i, n - 1);
        } else {
          swap(elements, 0, n - 1);
        }
      }
      calculateAllPermutations(n - 1, elements);
    }
  }

  private void swap(List<Integer> input, int a, int b) {
    Integer tmp = input.get(a);
    input.set(a, input.get(b));
    input.set(b, tmp);
  }

  private void savePermutation(List<Integer> input) {
    List<Integer> permutation = new ArrayList<>(input);
    allPhaseSettings.add(permutation);
  }
}
