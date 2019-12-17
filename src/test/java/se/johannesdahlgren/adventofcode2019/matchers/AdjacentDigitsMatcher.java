package se.johannesdahlgren.adventofcode2019.matchers;

import static se.johannesdahlgren.adventofcode2019.util.IntUtil.containsAdjacentDigits;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class AdjacentDigitsMatcher extends BaseMatcher<Integer> {

  public static Matcher<Integer> containsAtLeastTwoAdjacentDigits() {
    return new AdjacentDigitsMatcher();
  }

  @Override
  public boolean matches(Object o) {
    return containsAdjacentDigits((Integer) o);
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("At least two adjacent digits");
  }
}
