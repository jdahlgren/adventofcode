package se.johannesdahlgren.adventofcode.y2019;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

  private static final int OP_CODE_ADD = 1;
  private static final int OP_CODE_MULTIPLY = 2;
  private static final int OP_CODE_HALT = 99;

  private List<Integer> intCode;
  private int currentIndex;

  public Day2(String filePath) {
    this.intCode = getIntCode(filePath);
    this.currentIndex = 0;
  }

  public List<Integer> calculateIntCode() {
    int opCode = getNextOpCode();

    while (opCode != OP_CODE_HALT) {
      int newValue = calculateNewValue(opCode);
      setNewValueInIntCode(newValue);
      setNextOpCodeIndex();
      opCode = getNextOpCode();
    }

    return intCode;
  }

  private int getNextOpCode() {
    return intCode.get(currentIndex);
  }

  private int calculateNewValue(int opCode) {
    if (OP_CODE_ADD == opCode) {
      return addValues();
    } else if (OP_CODE_MULTIPLY == opCode) {
      return multiplyValues();
    }
    return -1;
  }

  private void setNewValueInIntCode(int newValue) {
    int index = getInsertPosition();
    intCode.set(index, newValue);
  }

  private void setNextOpCodeIndex() {
    currentIndex = currentIndex + 4;
  }

  private int addValues() {
    return intCode.get(getFirstValuePos()) + intCode.get(getSecondValuePos());
  }

  private int multiplyValues() {
    return intCode.get(getFirstValuePos()) * intCode.get(getSecondValuePos());
  }

  private int getInsertPosition() {
    return intCode.get(currentIndex + 3);
  }

  private int getFirstValuePos() {
    return intCode.get(currentIndex + 1);
  }

  private int getSecondValuePos() {
    return intCode.get(currentIndex + 2);
  }

  private List<Integer> getIntCode(String filePath) {
    URL fileUrl = this.getClass().getClassLoader().getResource(filePath);
    if (fileUrl == null) {
      return List.of();
    }

    try {
      String[] intCodeAsString = Files.readString(Paths.get(fileUrl.toURI())).split(",");
      return List.of(intCodeAsString).stream()
          .map(Integer::valueOf)
          .collect(Collectors.toList());
    } catch (IOException | URISyntaxException e) {
      return List.of();
    }
  }
}
