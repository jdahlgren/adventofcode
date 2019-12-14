package se.johannesdahlgren.adventofcode.util;

public class Point {

  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Point &&
        this.x == ((Point) obj).x &&
        this.y == ((Point) obj).y;
  }
}
