package se.johannesdahlgren.adventofcode2019;

import java.util.List;
import se.johannesdahlgren.adventofcode2019.util.Deck;
import se.johannesdahlgren.adventofcode2019.util.FileToListUtil;

public class Day22 {

  private static final String DEAL_WITH_INCREMENT = "deal with increment ";
  private static final String DEAL_INTO_NEW_STACK = "deal into new stack";
  private static final String CUT = "cut ";
  private final List<String> shuffleTechnique;

  public Day22(String filePath) {
    shuffleTechnique = FileToListUtil.getLinePathFromFile(filePath);
  }

  public void shuffle(Deck deck) {
    for (String technique : shuffleTechnique) {
      if (technique.startsWith(DEAL_WITH_INCREMENT)) {
        int increment = Integer.parseInt(technique.substring(DEAL_WITH_INCREMENT.length()));
        deck.deal(increment);
      } else if (technique.equals(DEAL_INTO_NEW_STACK)) {
        deck.dealIntoNewStack();
      } else if (technique.startsWith(CUT)) {
        int numberOfCardsToCut = Integer.parseInt(technique.substring(CUT.length()));
        deck.cut(numberOfCardsToCut);
      }
    }
  }
}
