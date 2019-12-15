package se.johannesdahlgren.adventofcode.y2019;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import se.johannesdahlgren.adventofcode.util.IntUtil;

@RequiredArgsConstructor
public class Day4 {

  private final int min;
  private final int max;

  public List<Integer> getPasswords() {
    return getAllValidPasswords();
  }

  private List<Integer> getAllValidPasswords() {
    return IntStream.range(min + 1, max).boxed()
        .filter(IntUtil::containsAdjacentDigits)
        .filter(IntUtil::digitsNeverDecreases)
        .collect(Collectors.toList());
  }
}
