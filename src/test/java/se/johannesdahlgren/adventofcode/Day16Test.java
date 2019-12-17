package se.johannesdahlgren.adventofcode;

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

  @Test
  void FlawedFrequencyTransmissionExample2() {
    String input = "80871224585914546619083218645595";
    int phases = 100;
    String output = day16.flawedFrequencyTransmission(input, phases);
    assertThat(output, is("24176176"));
  }

  @Test
  void FlawedFrequencyTransmissionExample3() {
    String input = "19617804207202209144916044189917";
    int phases = 100;
    String output = day16.flawedFrequencyTransmission(input, phases);
    assertThat(output, is("73745418"));
  }

  @Test
  void FlawedFrequencyTransmissionExample4() {
    String input = "69317163492948606335995924319873";
    int phases = 100;
    String output = day16.flawedFrequencyTransmission(input, phases);
    assertThat(output, is("52432133"));
  }

  @Test
  void FlawedFrequencyTransmission() {
    String input = "59727310424796235189476878806940387435291429226818921130171187957262146115559932358924341808253400617220924411865224341744614706346865536561788244183609411225788501102400269978290670307147139438239865673058478091682748114942700860895620690690625512670966265975462089087644554004423208369517716075591723905075838513598360188150158989179151879406086757964381549720210763972463291801513250953430219653258827586382953297392567981587028568433943223260723561880121205475323894070000380258122357270847092900809245133752093782889315244091880516672127950518799757198383131025701009960944008679555864631340867924665650332161673274408001712152664733237178121872";
    int phases = 100;
    String output = day16.flawedFrequencyTransmission(input, phases);
    assertThat(output, is("68317988"));
  }

  @Test
  void FlawedFrequencyTransmissionOutputInsideMessageExample1() {
    String input = "03036732577212944063491565474664".repeat(10000);
    int messageOffset = Integer.parseInt(input.substring(0, 7));
    String output = day16.flawedFrequencyTransmission(input, 100, messageOffset);
    assertThat(output, is("84462026"));
  }

  @Test
  void FlawedFrequencyTransmissionOutputInsideMessageExample2() {
    String input = "02935109699940807407585447034323".repeat(10000);
    int messageOffset = Integer.parseInt(input.substring(0, 7));
    String output = day16.flawedFrequencyTransmission(input, 100, messageOffset);
    assertThat(output, is("78725270"));
  }

  @Test
  void FlawedFrequencyTransmissionOutputInsideMessageExample3() {
    String input = "03081770884921959731165446850517".repeat(10000);
    int messageOffset = Integer.parseInt(input.substring(0, 7));
    String output = day16.flawedFrequencyTransmission(input, 100, messageOffset);
    assertThat(output, is("53553731"));
  }

  @Test
  void FlawedFrequencyTransmissionOutputInsideMessage() {
    String input = "59727310424796235189476878806940387435291429226818921130171187957262146115559932358924341808253400617220924411865224341744614706346865536561788244183609411225788501102400269978290670307147139438239865673058478091682748114942700860895620690690625512670966265975462089087644554004423208369517716075591723905075838513598360188150158989179151879406086757964381549720210763972463291801513250953430219653258827586382953297392567981587028568433943223260723561880121205475323894070000380258122357270847092900809245133752093782889315244091880516672127950518799757198383131025701009960944008679555864631340867924665650332161673274408001712152664733237178121872"
        .repeat(10000);
    int messageOffset = Integer.parseInt(input.substring(0, 7));
    String output = day16.flawedFrequencyTransmission(input, 100, messageOffset);
    assertThat(output, is("53850800"));
  }
}