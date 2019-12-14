package se.johannesdahlgren.adventofcode.util;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileToListUtil {

  public static List<Integer> getIntCode(String filePath) {
    return getListFromFile(filePath, FileToListUtil::getIntCodeFromFile);
  }

  public static List<Integer> getModuleMassFromFile(String filePath) {
    return getListFromFile(filePath, FileToListUtil::getModuleMassFromFile);
  }

  public static List<String> getLinePathFromFile(String filePath) {
    return getListFromFile(filePath, FileToListUtil::getLinePathFromFile);
  }

  private static <T> List<T> getListFromFile(String filePath, CheckedFunction<URI, List<T>> function) {
    try {
      URL fileUrl = FileToListUtil.class.getClassLoader().getResource(filePath);
      if (fileUrl == null) {
        throw new RuntimeException("Could not find file: " + filePath);
      }

      return function.apply(fileUrl.toURI());

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

  private static List<String> getLinePathFromFile(URI uri) throws IOException {
    return Files.readAllLines(Paths.get(uri));
  }
}