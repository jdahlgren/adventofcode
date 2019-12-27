package se.johannesdahlgren.adventofcode2019;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class Day5Test {

  private Day5 day5;

  @Test
  void runDiagnosticCode() {
    day5 = new Day5("day5/day5.txt", 1);
    int integers = day5.runDiagnosticCode();
    assertThat(integers, is(10987514));
  }

  @Test
  void runDiagnosticCodeExample1() {
    int input = 9;
    day5 = new Day5("day5/day5_example1.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers, is(input));
  }

}