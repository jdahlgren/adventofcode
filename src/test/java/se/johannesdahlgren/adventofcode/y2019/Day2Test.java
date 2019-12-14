package se.johannesdahlgren.adventofcode.y2019;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day2Test {

  @Test
  void calculateIntCodeExample1() {
    String filePath = "day2/day2_example1.txt";
    List<Integer> finalState = new Day2(filePath).calculateIntCode();
    assertThat(formatFinalState(finalState), is("2,0,0,0,99"));
  }

  @Test
  void calculateIntCodeExample2() {
    String filePath = "day2/day2_example2.txt";
    List<Integer> finalState = new Day2(filePath).calculateIntCode();
    assertThat(formatFinalState(finalState), is("2,3,0,6,99"));
  }

  @Test
  void calculateIntCodeExample3() {
    String filePath = "day2/day2_example3.txt";
    List<Integer> finalState = new Day2(filePath).calculateIntCode();
    assertThat(formatFinalState(finalState), is("2,4,4,5,99,9801"));
  }

  @Test
  void calculateIntCodeExample4() {
    String filePath = "day2/day2_example4.txt";
    List<Integer> finalState = new Day2(filePath).calculateIntCode();
    assertThat(formatFinalState(finalState), is("30,1,1,4,2,5,6,0,99"));
  }

  @Test
  void calculateIntCode1202Program() {
    String filePath = "day2/baseMemory.txt";
    List<Integer> finalState = new Day2(filePath).calculateIntCode(12, 2);
    assertThat(formatFinalState(finalState),
        is("12490719,12,2,2,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,60,1,19,6,62,1,23,6,64,1,13,27,69,2,13,31,345,1,5,35,346,2,39,13,1730,1,10,43,1734,2,13,47,8670,1,6,51,8672,2,55,13,43360,1,59,10,43364,1,63,10,43368,2,10,67,173472,1,6,71,173474,1,10,75,173478,1,79,9,173481,2,83,6,346962,2,87,9,1040886,1,5,91,1040887,1,6,95,1040889,1,99,9,1040892,2,10,103,4163568,1,107,6,4163570,2,9,111,12490710,1,5,115,12490711,1,10,119,12490715,1,2,123,12490717,1,127,6,0,99,2,14,0,0"));
  }

  @Test
  void calculateNounAndVerbExample() {
    String filePath = "day2/baseMemory.txt";
    List<Integer> finalState = new Day2(filePath).findNounAndVerb(12490719);
    assertThat(formatFinalState(finalState), is("12,2"));
  }

  @Test
  void calculateNounAndVerb() {
    String filePath = "day2/baseMemory.txt";
    List<Integer> finalState = new Day2(filePath).findNounAndVerb(19690720);
    assertThat(formatFinalState(finalState), is("20,3"));
  }

  private String formatFinalState(List<Integer> finalState) {
    return finalState.toString().replace(" ", "")
        .replace("[", "")
        .replace("]", "");
  }
}