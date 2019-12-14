package se.johannesdahlgren.adventofcode.y2019;

public class Day1 {

  public int calculateRequiredFuelForModuleMass(int moduleMass) {
    return (int) (Math.floor(moduleMass / 3.0f) - 2);
  }

  public int calculateRequiredFuelForModuleMass(int... moduleMass) {
    int requiredFuel = 0;
    for (int mass : moduleMass) {
      requiredFuel += calculateRequiredFuelForModuleMass(mass);
    }
    return requiredFuel;
  }
}