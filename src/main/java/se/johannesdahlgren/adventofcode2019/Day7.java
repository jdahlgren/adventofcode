package se.johannesdahlgren.adventofcode2019;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import se.johannesdahlgren.adventofcode2019.util.FileToListUtil;
import se.johannesdahlgren.adventofcode2019.util.IntCodeComputer;
import se.johannesdahlgren.adventofcode2019.util.PermutePhaseSettings;

@Slf4j
public class Day7 {

  private final List<Integer> intCode;

  public Day7(String filePath) {
    this.intCode = FileToListUtil.getIntCode(filePath);
  }

  public int tryThrusterSignal(List<Integer> phaseSettingSequence) {
    int output = 0;
    for (int phaseSetting : phaseSettingSequence) {
      IntCodeComputer intCodeComputer = new IntCodeComputer(intCode, List.of(phaseSetting, output));
      intCodeComputer.run();
      output = intCodeComputer.getOutput();
    }
    log.info("Thruster signal is {} for phase setting {}", output, phaseSettingSequence);
    return output;
  }

  public int findMaxThrusterSignal() {
    int max = Integer.MIN_VALUE;
    List<List<Integer>> phaseSettings = new PermutePhaseSettings().permute(Arrays.asList(0, 1, 2, 3, 4));
    for (List<Integer> phaseSetting : phaseSettings) {
      int thrusterSignal = tryThrusterSignal(phaseSetting);
      if (thrusterSignal > max) {
        max = thrusterSignal;
      }
    }
    return max;
  }

}
