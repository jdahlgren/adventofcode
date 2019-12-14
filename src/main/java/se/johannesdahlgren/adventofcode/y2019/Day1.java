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
    int requiredFuel = 0;
    for (int mass : masses) {
      requiredFuel += calculateRequiredFuelForMass(mass);
    }
    return requiredFuel;
  }

  public int calculateRequiredFuelForMass(String filePath) throws IOException, URISyntaxException {
    URL fileUrl = this.getClass().getClassLoader().getResource(filePath);
    if (fileUrl == null) {
      return 0;
    }

    List<Integer> masses = Files.readAllLines(Paths.get(fileUrl.toURI()))
        .stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    return calculateRequiredFuelForMass(masses);
  }
}