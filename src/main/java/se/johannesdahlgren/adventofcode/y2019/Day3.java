package se.johannesdahlgren.adventofcode.y2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import se.johannesdahlgren.adventofcode.util.FileToListUtil;
import se.johannesdahlgren.adventofcode.util.Line;
import se.johannesdahlgren.adventofcode.util.Point;

public class Day3 {

  private static final String RIGHT = "R";
  private static final String UP = "U";
  private static final String LEFT = "L";
  private static final String DOWN = "D";

  private final List<String> pathCommandsForLines;
  private List<Line> lines;

  public Day3(String filePath) {
    pathCommandsForLines = FileToListUtil.getLinePathFromFile(filePath);
    lines = new ArrayList<>();
  }

  public int findDistanceToClosestIntersection() {
    convertPathCommandsToLines();
    List<Point> intersectingPoints = getIntersectingPoints();
    return getSmallestManhattanDistance(intersectingPoints);
  }

  private void convertPathCommandsToLines() {
    for (String pathCommandsForLine : pathCommandsForLines) {
      createLine(pathCommandsForLine);
    }
  }

  private void createLine(String pathCommandsForLine) {
    Line line = new Line();
    Point start = new Point(0, 0);
    line.addPoint(start);

    String[] pathCommand = pathCommandsForLine.split(",");
    for (String step : pathCommand) {
      createPointFromStep(step, line);
    }
    lines.add(line);
  }

  private void createPointFromStep(String step, Line line) {
    String direction = step.substring(0, 1);
    int amount = Integer.parseInt(step.substring(1));
    for (int i = 0; i < amount; i++) {
      Point lastPoint = line.getLastPoint();
      Point nextPoint = getNewPointInDirection(direction, lastPoint);
      line.addPoint(nextPoint);
    }
  }

  private Point getNewPointInDirection(String direction, Point lastPoint) {
    switch (direction) {
      case UP:
        return new Point(lastPoint.getX(), lastPoint.getY() + 1);
      case RIGHT:
        return new Point(lastPoint.getX() + 1, lastPoint.getY());
      case DOWN:
        return new Point(lastPoint.getX(), lastPoint.getY() - 1);
      case LEFT:
        return new Point(lastPoint.getX() - 1, lastPoint.getY());
    }
    throw new RuntimeException("Unknown direction");
  }

  private List<Point> getIntersectingPoints() {
    Point ignore = new Point(0, 0);
    HashSet<Point> firstLineWithoutDuplicates = new HashSet<>(lines.get(0).getLine());
    HashSet<Point> secondLineWithoutDuplicates = new HashSet<>(lines.get(1).getLine());
    firstLineWithoutDuplicates.retainAll(secondLineWithoutDuplicates);
    firstLineWithoutDuplicates.remove(ignore);

    return new ArrayList<>(firstLineWithoutDuplicates);
  }

  private int getSmallestManhattanDistance(List<Point> intersectingPoints) {
    int minDistance = 99999999;
    for (Point point : intersectingPoints) {
      int distance = calculateManhattanDistance(point);
      if (minDistance > distance) {
        minDistance = distance;
      }
    }
    return minDistance;
  }

  private int calculateManhattanDistance(Point point) {
    return Math.abs(point.getX()) + Math.abs(point.getY());
  }
}
