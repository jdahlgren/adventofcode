package se.johannesdahlgren.adventofcode2019.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import se.johannesdahlgren.adventofcode2019.util.IntUtil;

public class NeverDecreasesMatcher extends BaseMatcher<Integer> {

  public static Matcher<Integer> digitsNeverDecreases() {
    return new NeverDecreasesMatcher();
  }

  @Override
  public boolean matches(Object o) {
    return IntUtil.digitsNeverDecreases((Integer) o);
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("Digits never decreases");
  }
}
