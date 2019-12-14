package se.johannesdahlgren.adventofcode.util;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileToListUtl {

  public static List<Integer> getIntCode(String filePath) {
    try {
      URL fileUrl = FileToListUtl.class.getClassLoader().getResource(filePath);
      if (fileUrl == null) {
        throw new RuntimeException("Could not find file: " + filePath);
      }

      return getIntCodeFromFile(fileUrl.toURI());

    } catch (URISyntaxException | IOException e) {
      throw new RuntimeException("Could not read file");
    }
  }

  public static List<Integer> getModuleMassFromFile(String filePath) {
    try {
      URL fileUrl = FileToListUtl.class.getClassLoader().getResource(filePath);
      if (fileUrl == null) {
        throw new RuntimeException("Could not find file: " + filePath);
      }

      return getModuleMassFromFile(fileUrl.toURI());

    } catch (URISyntaxException | IOException e) {
      throw new RuntimeException("Could not read file");
    }
  }

  private static List<Integer> getIntCodeFromFile(URI uri) throws IOException {
    String[] intCodeAsString = Files.readString(Paths.get(uri)).split(",");
    return List.of(intCodeAsString).stream()
        .map(Integer::valueOf)
        .collect(Collectors.toList());
  }

  private static List<Integer> getModuleMassFromFile(URI uri) throws IOException {
    return Files.readAllLines(Paths.get(uri))
        .stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}