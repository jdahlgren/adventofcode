package se.johannesdahlgren.adventofcode.y2019;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day16Test {

  private Day16 day16;

  @BeforeEach
  void setUp() {
    day16 = new Day16();
  }

  @Test
  void FlawedFrequencyTransmissionExample1Phase1() {
    String input = "12345678";
    int phases = 1;
    String output = day16.flawedFrequencyTransmission(input, phases);
    assertThat(output, is("48226158"));
  }

  @Test
  void FlawedFrequencyTransmissionExample1Phase2() {
    String input = "48226158";
    int phases = 1;
    String output = day16.flawedFrequencyTransmission(input, phases);
    assertThat(output, is("34040438"));
  }

  @Test
  void FlawedFrequencyTransmissionExample1Phase3() {
    String input = "34040438";
    int phases = 1;
    String output = day16.flawedFrequencyTransmission(input, phases);
    assertThat(output, is("03415518"));
  }

  @Test
  void FlawedFrequencyTransmissionExample1Phase4() {
    String input = "03415518";
    int phases = 1;
    String output = day16.flawedFrequencyTransmission(input, phases);
    assertThat(output, is("01029498"));
  }

  @Test
  void FlawedFrequencyTransmissionExample1() {
    String input = "12345678";
    int phases = 4;
    String output = day16.flawedFrequencyTransmission(input, phases);
    assertThat(output, is("01029498"));
  }
}