package se.johannesdahlgren.adventofcode2019;

import se.johannesdahlgren.adventofcode2019.util.IntCodeComputer;

public class Day5 {

  private IntCodeComputer intCodeComputer;

  public Day5(String filePath, int input) {
    intCodeComputer = new IntCodeComputer(filePath, input);
  }

  public int runDiagnosticCode() {
    intCodeComputer.run();
    return intCodeComputer.getOutput();
  }
}
