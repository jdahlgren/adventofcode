package se.johannesdahlgren.adventofcode2019.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntCodeComputer {

  private static final int OP_CODE_ADD = 1;
  private static final int OP_CODE_MULTIPLY = 2;
  private static final int OP_CODE_SET_VALUE = 3;
  private static final int OP_CODE_VIEW_VALUE = 4;
  private static final int OP_CODE_JUMP_IF_TRUE = 5;
  private static final int OP_CODE_JUMP_IF_FALSE = 6;
  private static final int OP_CODE_LESS_THAN = 7;
  private static final int OP_CODE_EQUALS = 8;
  private static final int OP_CODE_HALT = 99;

  private static final int POSITION_MODE = 0;
  private static final int IMMEDIATE_MODE = 1;

  private static final int NOUN_POSITION = 1;
  private static final int VERB_POSITION = 2;

  private final List<Integer> defaultIntCode;
  private List<Integer> currentIntCode;
  private int currentIndex;
  private LinkedList<Integer> inputList;
  private int output;

  public IntCodeComputer(List<Integer> intCode) {
    this(intCode, List.of());
  }

  public IntCodeComputer(List<Integer> intCode, List<Integer> input) {
    this.inputList = new LinkedList<>(input);
    defaultIntCode = List.copyOf(intCode);
    initMemory(defaultIntCode.get(NOUN_POSITION), defaultIntCode.get(VERB_POSITION));
  }

  public void initMemory(int nounValue, int verbValue) {
    currentIndex = 0;
    currentIntCode = new ArrayList<>(defaultIntCode);
    currentIntCode.set(NOUN_POSITION, nounValue);
    currentIntCode.set(VERB_POSITION, verbValue);
  }

  public List<Integer> run() {
    String opCodeInstruction = getNextOpCodeInstruction();
    int opCode = getOpCode(opCodeInstruction);

    while (opCode != OP_CODE_HALT) {
      processOpCode(opCode, opCodeInstruction);
      opCodeInstruction = getNextOpCodeInstruction();
      opCode = getOpCode(opCodeInstruction);
    }

    return currentIntCode;
  }

  public int getOutput() {
    return output;
  }

  private String getNextOpCodeInstruction() {
    int instruction = currentIntCode.get(currentIndex);
    return getPaddedInstruction(instruction);
  }

  private int getOpCode(String opCodeInstruction) {
    return Integer.parseInt(opCodeInstruction.substring(3, 5));
  }

  private void processOpCode(int opCode, String opCodeInstruction) {
    if (OP_CODE_ADD == opCode) {
      int newValue = addValues(opCodeInstruction);
      setNewValueInIntCode(newValue, opCodeInstruction);
      currentIndex += 4;
      return;
    } else if (OP_CODE_MULTIPLY == opCode) {
      int newValue = multiplyValues(opCodeInstruction);
      setNewValueInIntCode(newValue, opCodeInstruction);
      currentIndex += 4;
      return;
    } else if (OP_CODE_SET_VALUE == opCode) {
      int index = getIndexByParameterMode(1, opCodeInstruction);
      Integer input = inputList.poll();
      currentIntCode.set(index, input);
      log.info("Saved {} on pos {}", input, index);
      currentIndex += 2;
      return;
    } else if (OP_CODE_VIEW_VALUE == opCode) {
      int index = getIndexByParameterMode(1, opCodeInstruction);
      output = currentIntCode.get(index);
      log.info("Output is {}", output);
      currentIndex += 2;
      return;
    } else if (OP_CODE_JUMP_IF_TRUE == opCode) {
      int index = getIndexByParameterMode(1, opCodeInstruction);
      if (currentIntCode.get(index) != 0) {
        currentIndex = currentIntCode.get(getIndexByParameterMode(2, opCodeInstruction));
        log.info("Jumping to index {}", currentIndex);
      } else {
        currentIndex += 3;
      }
      return;
    } else if (OP_CODE_JUMP_IF_FALSE == opCode) {
      int index = getIndexByParameterMode(1, opCodeInstruction);
      if (currentIntCode.get(index) == 0) {
        currentIndex = currentIntCode.get(getIndexByParameterMode(2, opCodeInstruction));
        log.info("Jumping to index {}", currentIndex);
      } else {
        currentIndex += 3;
      }
      return;
    } else if (OP_CODE_LESS_THAN == opCode) {
      int param1 = getIndexByParameterMode(1, opCodeInstruction);
      int param2 = getIndexByParameterMode(2, opCodeInstruction);
      if (currentIntCode.get(param1) < currentIntCode.get(param2)) {
        setNewValueInIntCode(1, opCodeInstruction);
      } else {
        setNewValueInIntCode(0, opCodeInstruction);
      }
      currentIndex += 4;
      return;
    } else if (OP_CODE_EQUALS == opCode) {
      int param1 = getIndexByParameterMode(1, opCodeInstruction);
      int param2 = getIndexByParameterMode(2, opCodeInstruction);
      if (currentIntCode.get(param1).equals(currentIntCode.get(param2))) {
        setNewValueInIntCode(1, opCodeInstruction);
      } else {
        setNewValueInIntCode(0, opCodeInstruction);
      }
      currentIndex += 4;
      return;
    }
    throw new RuntimeException("Unsupported OP CODE: " + opCode);
  }

  private void setNewValueInIntCode(int newValue, String opCodeInstruction) {
    int index = getIndexByParameterMode(3, opCodeInstruction);
    currentIntCode.set(index, newValue);
    log.info("Saved {} on pos {}", newValue, index);
  }

  private String getPaddedInstruction(int instruction) {
    return String.format("%05d", instruction);
  }

  private int addValues(String opCodeInstruction) {
    int param1 = getIndexByParameterMode(1, opCodeInstruction);
    int param2 = getIndexByParameterMode(2, opCodeInstruction);
    Integer v1 = currentIntCode.get(param1);
    Integer v2 = currentIntCode.get(param2);
    log.info("Adding {} + {} from positions {}, {}", v1, v2, param1, param2);
    return v1 + v2;
  }

  private int multiplyValues(String opCodeInstruction) {
    int param1 = getIndexByParameterMode(1, opCodeInstruction);
    int param2 = getIndexByParameterMode(2, opCodeInstruction);
    Integer v1 = currentIntCode.get(param1);
    Integer v2 = currentIntCode.get(param2);
    log.info("Multiplying {} * {} from positions {}, {}", v1, v2, param1, param2);
    return v1 * v2;
  }

  private int getIndexByParameterMode(int indexOffset, String opCodeInstruction) {
    int index = currentIndex + indexOffset;
    int mode = Character.getNumericValue(opCodeInstruction.charAt(3 - indexOffset));
    if (POSITION_MODE == mode) {
      return currentIntCode.get(index);
    } else if (IMMEDIATE_MODE == mode) {
      return index;
    }
    throw new RuntimeException("Unsupported parameter mode");
  }
}
