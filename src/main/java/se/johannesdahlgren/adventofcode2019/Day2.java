package se.johannesdahlgren.adventofcode2019;

import java.util.List;
import se.johannesdahlgren.adventofcode2019.util.FileToListUtil;
import se.johannesdahlgren.adventofcode2019.util.IntCodeComputer;

public class Day2 {

  private final IntCodeComputer intCodeComputer;

  public Day2(String filePath) {
    intCodeComputer = new IntCodeComputer(FileToListUtil.getIntCode(filePath));
  }

  public List<Integer> calculateIntCode() {
    return intCodeComputer.run();
  }

  public List<Integer> calculateIntCode(int nounValue, int verbValue) {
    intCodeComputer.initMemory(nounValue, verbValue);
    return intCodeComputer.run();
  }

  public List<Integer> findNounAndVerb(int result) {
    for (int noun = 0; noun < 100; noun++) {
      for (int verb = 0; verb < 100; verb++) {
        intCodeComputer.initMemory(noun, verb);
        Integer code = intCodeComputer.run().get(0);
        if (code == result) {
          return List.of(noun, verb);
        }
      }
    }
    throw new RuntimeException("No noun/verb combo match result: " + result);
  }

}
