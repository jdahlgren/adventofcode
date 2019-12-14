package se.johannesdahlgren.adventofcode.util;

import java.util.ArrayList;
import java.util.List;

public class Line {

  private List<Point> line = new ArrayList<>();

  public List<Point> getLine() {
    return line;
  }

  public void addPoint(Point p) {
    line.add(p);
  }

  public Point getLastPoint() {
    return line.get(line.size() - 1);
  }
}
