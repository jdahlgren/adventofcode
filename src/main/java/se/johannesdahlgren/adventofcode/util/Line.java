package se.johannesdahlgren.adventofcode.util;

import java.util.List;

public class Line {

  private List<Point> line;

  public Line(List<Point> line) {
    this.line = line;
  }

  public List<Point> getLine() {
    return line;
  }
}
