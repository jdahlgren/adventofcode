package se.johannesdahlgren.adventofcode.y2019;

import java.util.List;
import se.johannesdahlgren.adventofcode.util.FileToListUtil;

public class Day2 {

  private static final int OP_CODE_ADD = 1;
  private static final int OP_CODE_MULTIPLY = 2;
  private static final int OP_CODE_HALT = 99;

  private List<Integer> intCode;
  private int currentIndex;

  public Day2(String filePath) {
    this.intCode = FileToListUtil.getIntCode(filePath);
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
}
