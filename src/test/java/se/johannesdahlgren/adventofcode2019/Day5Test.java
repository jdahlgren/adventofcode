package se.johannesdahlgren.adventofcode2019;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day5Test {

  private Day5 day5;

  @Test
  void runDiagnosticCode() {
    day5 = new Day5("day5/day5.txt");
    List<Integer> integers = day5.runDiagnosticCode(1);
    assertThat(integers, is(2));
  }

  @Test
  void runDiagnosticCodeExample1() {
    day5 = new Day5("day5/day5_example1.txt");
    int input = 9;
    List<Integer> integers = day5.runDiagnosticCode(input);
    assertThat(integers, is(input));
  }

  @Test
  void runDiagnosticCodeExample2() {
    day5 = new Day5("day5/day5_example2.txt");
    List<Integer> integers = day5.runDiagnosticCode(-1);
    assertThat(integers, is(0));
  }

}