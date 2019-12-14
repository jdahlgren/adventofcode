package se.johannesdahlgren.adventofcode.y2019;

import java.util.List;
import se.johannesdahlgren.adventofcode.util.FileToListUtl;

public class Day1 {

  public int calculateRequiredFuelForMass(String filePath) {
    List<Integer> moduleMasses = FileToListUtl.getModuleMassFromFile(filePath);
    return calculateRequiredFuelForMass(moduleMasses);
  }

  public int calculateRequiredFuelForMassOfModuleAndItsFuel(String filePath) {
    List<Integer> moduleMasses = FileToListUtl.getModuleMassFromFile(filePath);
    return calculateRequiredFuelForMassOfModuleAndItsFuel(moduleMasses);
  }

  private int calculateRequiredFuelForMass(List<Integer> masses) {
    return masses.stream()
        .map(this::calculateRequiredFuelForMass)
        .mapToInt(value -> value).sum();
  }

  private int calculateRequiredFuelForMass(int mass) {
    return (int) (Math.floor(mass / 3.0f) - 2);
  }

  private int calculateRequiredFuelForMassOfModuleAndItsFuel(List<Integer> masses) {
    return masses.stream()
        .map(this::calculateRequiredFuelForMassOfModuleAndItsFuel)
        .mapToInt(value -> value).sum();
  }

  private int calculateRequiredFuelForMassOfModuleAndItsFuel(int moduleMass) {
    int requiredFuel = calculateRequiredFuelForMass(moduleMass);
    if (requiredFuel <= 0) {
      return 0;
    }
    return requiredFuel + calculateRequiredFuelForMassOfModuleAndItsFuel(requiredFuel);
  }
}