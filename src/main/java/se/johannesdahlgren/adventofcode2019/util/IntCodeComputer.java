package se.johannesdahlgren.adventofcode2019.util;

import java.util.ArrayList;
import java.util.List;

public class IntCodeComputer {

  private static final int OP_CODE_ADD = 1;
  private static final int OP_CODE_MULTIPLY = 2;
  private static final int OP_CODE_SET_VALUE = 3;
  private static final int OP_CODE_VIEW_VALUE = 4;
  private static final int OP_CODE_HALT = 99;

  private static final int POSITION_MODE = 0;
  private static final int IMMEDIATE_MODE = 1;

  private static final int NOUN_POSITION = 1;
  private static final int VERB_POSITION = 2;

  private final List<Integer> defaultIntCode;
  private List<Integer> currentIntCode;
  private List<Integer> parameterMode = List.of(0, 0, 0);
  private int currentIndex;

  public IntCodeComputer(String filePath) {
    defaultIntCode = List.copyOf(FileToListUtil.getIntCode(filePath));
    initMemory(defaultIntCode.get(NOUN_POSITION), defaultIntCode.get(VERB_POSITION));
  }

  public void initMemory(int nounValue, int verbValue) {
    currentIndex = 0;
    currentIntCode = new ArrayList<>(defaultIntCode);
    currentIntCode.set(NOUN_POSITION, nounValue);
    currentIntCode.set(VERB_POSITION, verbValue);
  }

  public List<Integer> run() {
    int opCode = getNextOpCode();

    while (opCode != OP_CODE_HALT) {
      processOpCode(opCode);
      setNextOpCodeIndex();
      opCode = getNextOpCode();
    }

    return currentIntCode;
  }

  private int getNextOpCode() {
    int instruction = currentIntCode.get(currentIndex);
    setParameterMode(instruction);
    return getOpCodeFromInstruction(instruction);
  }

  private void processOpCode(int opCode) {
    if (OP_CODE_ADD == opCode) {
      int newValue = addValues();
      setNewValueInIntCode(newValue);
      return;
    } else if (OP_CODE_MULTIPLY == opCode) {
      int newValue = multiplyValues();
      setNewValueInIntCode(newValue);
      return;
    }
    throw new RuntimeException("Unsupported OP CODE: " + opCode);
  }

  private void setNewValueInIntCode(int newValue) {
    int index = getIndexByParameterMode(3);
    currentIntCode.set(index, newValue);
  }

  private void setNextOpCodeIndex() {
    currentIndex = currentIndex + parameterMode.size() + 1;
  }

  private void setParameterMode(int instruction) {
    String stringInstruction = String.valueOf(instruction);
    int instructionLength = stringInstruction.length();
    String hundreds = instructionLength < 3 ?
        "0" : stringInstruction.substring(instructionLength - 3, instructionLength - 2);
    String thousands = instructionLength < 4 ?
        "0" : stringInstruction.substring(instructionLength - 4, instructionLength - 3);
    String tenThousands = instructionLength < 5 ?
        "0" : stringInstruction.substring(instructionLength - 5, instructionLength - 4);

    parameterMode = List.of(Integer.parseInt(hundreds), Integer.parseInt(thousands), Integer.parseInt(tenThousands));
  }

  private int getOpCodeFromInstruction(int instruction) {
    String stringInstruction = String.valueOf(instruction);
    int instructionLength = stringInstruction.length();
    String opCode = instructionLength == 1 ?
        stringInstruction : stringInstruction.substring(instructionLength - 2, instructionLength);
    return Integer.parseInt(opCode);
  }

  private int addValues() {
    return currentIntCode.get(getIndexByParameterMode(1)) + currentIntCode.get(getIndexByParameterMode(2));
  }

  private int multiplyValues() {
    return currentIntCode.get(getIndexByParameterMode(1)) * currentIntCode.get(getIndexByParameterMode(2));
  }

  private int getIndexByParameterMode(int indexOffset) {
    int index = currentIndex + indexOffset;
    int mode = getParameterMode(index);
    if (POSITION_MODE == mode) {
      return currentIntCode.get(index);
    } else if (IMMEDIATE_MODE == mode) {
      return index;
    }
    throw new RuntimeException("Unsupported parameter mode");
  }

  private int getParameterMode(int i) {
    return parameterMode.get(i % parameterMode.size());
  }
}
