package se.johannesdahlgren.adventofcode.y2019;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

  public int calculateRequiredFuelForModuleMass(int moduleMass) {
    return (int) (Math.floor(moduleMass / 3.0f) - 2);
  }

  public int calculateRequiredFuelForModuleMass(List<Integer> moduleMass) {
    int requiredFuel = 0;
    for (int mass : moduleMass) {
      requiredFuel += calculateRequiredFuelForModuleMass(mass);
    }
    return requiredFuel;
  }

  public int calculateRequiredFuelForModuleMass(String filePath) throws IOException, URISyntaxException {
    URL fileUrl = this.getClass().getClassLoader().getResource(filePath);
    if (fileUrl == null) {
      return 0;
    }

    List<Integer> massForAllModules = Files.readAllLines(Paths.get(fileUrl.toURI()))
        .stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    return calculateRequiredFuelForModuleMass(massForAllModules);
  }
}