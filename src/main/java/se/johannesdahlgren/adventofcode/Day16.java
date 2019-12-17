package se.johannesdahlgren.adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day16 {

  private final List<Integer> basePattern = List.of(0, 1, 0, -1);

  public String flawedFrequencyTransmission(String input, int phases) {
    if (phases == 0) {
      return input.substring(0, 8);
    }
    List<Integer> inputList = input.chars().boxed().map(Character::getNumericValue).collect(Collectors.toList());

    StringBuilder output = new StringBuilder();
    for (int outputIndex = 0; outputIndex < inputList.size(); outputIndex++) {
      int outputAtIndex = 0;
      List<Integer> pattern = getPatternForOutputIndex(outputIndex);

      for (int inputIndex = 0; inputIndex < inputList.size(); inputIndex++) {
        Integer patternValue = pattern.get((inputIndex + 1) % pattern.size());
        outputAtIndex += inputList.get(inputIndex) * patternValue;
      }
      String outputAtIndexAsString = String.valueOf(outputAtIndex);
      output.append(outputAtIndexAsString, outputAtIndexAsString.length() - 1, outputAtIndexAsString.length());
    }

    return flawedFrequencyTransmission(output.toString(), phases - 1);
  }

  public String flawedFrequencyTransmission(String input, int phases, int offset) {
    if (phases == 0) {
      return input.substring(offset, offset + 8);
    }
    List<Integer> inputList = input.chars().boxed().map(Character::getNumericValue).collect(Collectors.toList());

    var result = 0;
    for (int inputIndex = inputList.size() - 1; inputIndex > offset - 1; inputIndex--) {
      result += inputList.get(inputIndex);
      result = Math.abs(result % 10);
      inputList.set(inputIndex, result);
    }
    String output = inputList.stream().map(String::valueOf).collect(Collectors.joining(""));
    return flawedFrequencyTransmission(output, phases - 1, offset);
  }

  private List<Integer> getPatternForOutputIndex(int outputIndex) {
    int repeats = outputIndex + 1;
    List<Integer> pattern = new ArrayList<>();
    for (Integer integer : basePattern) {
      for (int j = 0; j < repeats; j++) {
        pattern.add(integer);
      }
    }
    return pattern;
  }
}
