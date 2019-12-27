package se.johannesdahlgren.adventofcode2019.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {

  private List<Integer> deck;

  public Deck(int size) {
    deck = IntStream.range(0, size).boxed().collect(Collectors.toList());
  }

  public void dealIntoNewStack() {
    Collections.reverse(deck);
  }

  public void cut(int numberOfCardsToCut) {
    if (numberOfCardsToCut < 0) {
      numberOfCardsToCut = deck.size() - Math.abs(numberOfCardsToCut);
    }

    List<Integer> cut = deck.stream().mapToInt(Integer::intValue).limit(numberOfCardsToCut).boxed()
        .collect(Collectors.toList());
    List<Integer> newDeck = deck.stream().mapToInt(Integer::intValue).skip(numberOfCardsToCut).boxed()
        .collect(Collectors.toList());
    newDeck.addAll(cut);
    deck = new ArrayList<>(newDeck);
  }

  public void deal(int increment) {
    Integer[] newDeck = new Integer[deck.size()];
    for (int j = 0; j < deck.size(); j++) {
      newDeck[(j * increment) % deck.size()] = deck.get(j);
    }
    deck = Arrays.asList(newDeck);
  }

  public List<Integer> getCards() {
    return deck;
  }

}
