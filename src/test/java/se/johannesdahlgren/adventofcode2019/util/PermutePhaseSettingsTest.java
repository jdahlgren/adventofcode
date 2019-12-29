package se.johannesdahlgren.adventofcode2019.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class PermutePhaseSettingsTest {

  @Test
  void permute1() {
    PermutePhaseSettings permutePhaseSettings = new PermutePhaseSettings();
    List<List<Integer>> permutations = permutePhaseSettings.permute(List.of(1));
    assertThat(permutations.size(), is(1));
    assertThat(permutations.get(0).size(), is(1));
    assertThat(permutations.get(0).get(0), is(1));
  }

  @Test
  void permute2() {
    PermutePhaseSettings permutePhaseSettings = new PermutePhaseSettings();
    List<List<Integer>> permutations = permutePhaseSettings.permute(Arrays.asList(1, 2));
    assertThat(permutations.size(), is(2));
    assertThat(permutations.get(0).size(), is(2));
    assertThat(permutations.get(0), containsInRelativeOrder(1, 2));
    assertThat(permutations.get(1).size(), is(2));
    assertThat(permutations.get(1), containsInRelativeOrder(2, 1));
  }
}