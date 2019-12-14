package se.johannesdahlgren.adventofcode.y2019;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day1Test {

  private Day1 day1;

  @BeforeEach
  void setUp() {
    day1 = new Day1();
  }

  @Test
  void requiredFuelForModule1() throws IOException, URISyntaxException {
    String filePath = "day1_example1.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel, is(2));
  }

  @Test
  void requiredFuelForModule2() throws IOException, URISyntaxException {
    String filePath = "day1_example2.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel, is(2));
  }

  @Test
  void requiredFuelForModule3() throws IOException, URISyntaxException {
    String filePath = "day1_example3.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel, is(654));
  }

  @Test
  void requiredFuelForModule4() throws IOException, URISyntaxException {
    String filePath = "day1_example4.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel, is(33583));
  }

  @Test
  void requiredFuelForAllModules() throws IOException, URISyntaxException {
    String filePath = "day1_examples.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel, is(2 + 2 + 654 + 33583));
  }

  @Test
  void requiredFuelForAllModulesWithExampleInput() throws IOException, URISyntaxException {
    String filePath = "day1_examples.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel, is(2 + 2 + 654 + 33583));
  }

  @Test
  void requiredFuelForAllModulesWithRealInput() throws IOException, URISyntaxException {
    String filePath = "day1.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel, is(3342946));
  }

  @Test
  void requiredFuelForModule2AndItsOwnFuel() throws IOException, URISyntaxException {
    String filePath = "day1_example2.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel, is(2));
  }

  @Test
  void requiredFuelForModule3AndItsOwnFuel() throws IOException, URISyntaxException {
    String filePath = "day1_example3.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel, is(966));
  }

  @Test
  void requiredFuelForModule4AndItsOwnFuel() throws IOException, URISyntaxException {
    String filePath = "day1_example4.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel, is(50346));
  }

  @Test
  void requiredFuelForAllModulesAndItsOwnFuelWithExampleInput() throws IOException, URISyntaxException {
    String filePath = "day1_examples.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel, is(2 + 2 + 966 + 50346));
  }

  @Test
  void requiredFuelForAllModulesAndItsOwnFuelWithRealInput() throws IOException, URISyntaxException {
    String filePath = "day1.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel, is(5011553));
  }
}