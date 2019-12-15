package se.johannesdahlgren.adventofcode.y2019;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static se.johannesdahlgren.adventofcode.y2019.matchers.AdjacentDigitsMatcher.containsAtLeastTwoAdjacentDigits;
import static se.johannesdahlgren.adventofcode.y2019.matchers.NeverDecreasesMatcher.digitsNeverDecreases;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day4Test {

  private Day4 day4;
  private int minValue = 248345;
  private int maxValue = 746315;

  @BeforeEach
  void setUp() {
    day4 = new Day4(minValue, maxValue);
  }

  @Test
  void atLeastOnePassword() {
    List<Integer> passwords = day4.getPasswords();
    assertThat(passwords, is(not(empty())));
  }

  @Test
  void exactly6Digits() {
    List<Integer> passwords = day4.getPasswords();
    for (Integer password : passwords) {
      assertThat(String.valueOf(password).length(), is(6));
    }
  }

  @Test
  void withinRange() {
    List<Integer> passwords = day4.getPasswords();
    for (Integer password : passwords) {
      assertThat(password, greaterThan(minValue));
      assertThat(password, lessThan(maxValue));
    }
  }

  @Test
  void atLeastTwoAdjacentDigits() {
    List<Integer> passwords = day4.getPasswords();
    for (Integer password : passwords) {
      assertThat(password, containsAtLeastTwoAdjacentDigits());
    }
  }

  @Test
  void neverDecreases() {
    List<Integer> passwords = day4.getPasswords();
    for (Integer password : passwords) {
      assertThat(password, digitsNeverDecreases());
    }
  }

  @Test
  void howManyValidPasswords() {
    List<Integer> passwords = day4.getPasswords();
    assertThat(passwords.size(), is(1019));
  }

}