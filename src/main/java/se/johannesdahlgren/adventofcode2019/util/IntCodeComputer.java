package se.johannesdahlgren.adventofcode2019.util;

import java.util.ArrayList;
import java.util.List;

public class IntCodeComputer {

  private static final int OP_CODE_ADD = 1;
  private static final int OP_CODE_MULTIPLY = 2;
  private static final int OP_CODE_HALT = 99;

  private static final int NOUN_POSITION = 1;
  private static final int VERB_POSITION = 2;

  private final List<Integer> defaultIntCode;
  private List<Integer> currentIntCode;
  private int currentIndex;
  private int valuesInInstruction = 4;

  public IntCodeComputer(String filePath) {
    defaultIntCode = List.copyOf(FileToListUtil.getIntCode(filePath));
    initMemory(defaultIntCode.get(NOUN_POSITION), defaultIntCode.get(VERB_POSITION));
  }

  public List<Integer> run() {
    int opCode = getNextOpCode();

    while (opCode != OP_CODE_HALT) {
      int newValue = calculateNewValue(opCode);
      setNewValueInIntCode(newValue);
      setNextOpCodeIndex();
      opCode = getNextOpCode();
    }

    return currentIntCode;
  }

  public void initMemory(int nounValue, int verbValue) {
    currentIndex = 0;
    currentIntCode = new ArrayList<>(defaultIntCode);
    currentIntCode.set(NOUN_POSITION, nounValue);
    currentIntCode.set(VERB_POSITION, verbValue);
  }

  private int getNextOpCode() {
    return currentIntCode.get(currentIndex);
  }

  private int calculateNewValue(int opCode) {
    if (OP_CODE_ADD == opCode) {
      return addValues();
    } else if (OP_CODE_MULTIPLY == opCode) {
      return multiplyValues();
    }
    return -1;
  }

  private int addValues() {
    return currentIntCode.get(getFirstValuePos()) + currentIntCode.get(getSecondValuePos());
  }

  private int multiplyValues() {
    return currentIntCode.get(getFirstValuePos()) * currentIntCode.get(getSecondValuePos());
  }

  private int getFirstValuePos() {
    return currentIntCode.get(currentIndex + 1);
  }

  private int getSecondValuePos() {
    return currentIntCode.get(currentIndex + 2);
  }

  private void setNewValueInIntCode(int newValue) {
    int index = getInsertPosition();
    currentIntCode.set(index, newValue);
  }

  private int getInsertPosition() {
    return currentIntCode.get(currentIndex + 3);
  }

  private void setNextOpCodeIndex() {
    currentIndex = currentIndex + valuesInInstruction;
  }
}
