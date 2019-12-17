package se.johannesdahlgren.adventofcode2019;

import java.util.List;
import se.johannesdahlgren.adventofcode2019.util.IntCodeComputer;

public class Day5 {

  private IntCodeComputer intCodeComputer;

  public Day5(String filePath) {
    intCodeComputer = new IntCodeComputer(filePath);
  }

  public List<Integer> runDiagnosticCode(int input) {
    return intCodeComputer.run();
  }
}
