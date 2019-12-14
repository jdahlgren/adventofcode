package se.johannesdahlgren.adventofcode.y2019;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class Day3Test {

  @Test
  void findDistanceToClosestIntersection() {
    Day3 day3 = new Day3("day3/day3_example1.txt");
    int distance = day3.findDistanceToClosestIntersection();
    assertThat(distance, is(6));
  }
}