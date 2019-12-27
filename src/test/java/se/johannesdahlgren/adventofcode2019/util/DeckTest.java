package se.johannesdahlgren.adventofcode2019.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInRelativeOrder.containsInRelativeOrder;

import org.junit.jupiter.api.Test;

class DeckTest {

  @Test
  void getCards() {
    Deck deck = new Deck(10);
    assertThat(deck.getCards(), containsInRelativeOrder(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
  }

  @Test
  void dealIntoNewStack() {
    Deck deck = new Deck(10);
    deck.dealIntoNewStack();
    assertThat(deck.getCards(), containsInRelativeOrder(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
  }

  @Test
  void cut() {
    Deck deck = new Deck(10);
    deck.cut(3);
    assertThat(deck.getCards(), containsInRelativeOrder(3, 4, 5, 6, 7, 8, 9, 0, 1, 2));
  }

  @Test
  void negativeCut() {
    Deck deck = new Deck(10);
    deck.cut(-4);
    assertThat(deck.getCards(), containsInRelativeOrder(6, 7, 8, 9, 0, 1, 2, 3, 4, 5));
  }

  @Test
  void deal() {
    Deck deck = new Deck(10);
    deck.deal(3);
    assertThat(deck.getCards(), containsInRelativeOrder(0, 7, 4, 1, 8, 5, 2, 9, 6, 3));
  }
}