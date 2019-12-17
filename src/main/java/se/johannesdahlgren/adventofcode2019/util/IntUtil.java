package se.johannesdahlgren.adventofcode2019.util;

public class IntUtil {

  public static boolean containsAdjacentDigits(Integer i) {
    char previous = 'a';
    char[] chars = String.valueOf(i).toCharArray();
    for (char c : chars) {
      if (c == previous) {
        return true;
      }
      previous = c;
    }
    return false;
  }

  public static boolean digitsNeverDecreases(Integer i) {
    int previous = 0;
    char[] chars = String.valueOf(i).toCharArray();
    for (char c : chars) {
      if (c < previous) {
        return false;
      }
      previous = c;
    }
    return true;
  }
}
