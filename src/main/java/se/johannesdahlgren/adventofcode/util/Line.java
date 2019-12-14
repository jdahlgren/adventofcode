package se.johannesdahlgren.adventofcode.util;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Line {

  private List<Point> line = new ArrayList<>();

  public void addPoint(Point p) {
    line.add(p);
  }

  public Point getLastPoint() {
    return line.get(line.size() - 1);
  }
}
