package se.johannesdahlgren.adventofcode.y2019;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

  public int calculateRequiredFuelForMass(int mass) {
    return (int) (Math.floor(mass / 3.0f) - 2);
  }

  public int calculateRequiredFuelForMass(List<Integer> masses) {
    return masses.stream()
        .map(this::calculateRequiredFuelForMassOfModuleAndItsFuel)
        .mapToInt(value -> value).sum();
  }

  public int calculateRequiredFuelForMass(String filePath) throws IOException, URISyntaxException {
    List<Integer> masses = getModuleMassFromFile(filePath);
    return calculateRequiredFuelForMass(masses);
  }

  public int calculateRequiredFuelForMassOfModuleAndItsFuel(int moduleMass) {
    int requiredFuel = calculateRequiredFuelForMass(moduleMass);
    if (requiredFuel <= 0) {
      return 0;
    }
    return requiredFuel + calculateRequiredFuelForMassOfModuleAndItsFuel(requiredFuel);
  }

  private int calculateRequiredFuelForMassOfModuleAndItsFuel(List<Integer> masses) {
    return masses.stream()
        .map(this::calculateRequiredFuelForMassOfModuleAndItsFuel)
        .mapToInt(value -> value).sum();
  }

  public int calculateRequiredFuelForMassOfModuleAndItsFuel(String filePath) throws URISyntaxException, IOException {
    List<Integer> masses = getModuleMassFromFile(filePath);
    return calculateRequiredFuelForMassOfModuleAndItsFuel(masses);
  }

  private List<Integer> getModuleMassFromFile(String filePath) throws IOException, URISyntaxException {
    URL fileUrl = this.getClass().getClassLoader().getResource(filePath);
    if (fileUrl == null) {
      return List.of();
    }

    return Files.readAllLines(Paths.get(fileUrl.toURI()))
        .stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}