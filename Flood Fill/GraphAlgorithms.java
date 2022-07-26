/*
	Name:
	Student ID: 
*/

import java.awt.Color;
import java.util.*;

public class GraphAlgorithms {

  /*
   * FloodFillDFS(v, writer, fillColour)
   * Traverse the component the vertex v using DFS and set the colour
   * of the pixels corresponding to all vertices encountered during the
   * traversal to fillColour.
   * 
   * To change the colour of a pixel at position (x,y) in the image to a
   * colour c, use
   * writer.setPixel(x,y,c);
   */
  public static void FloodFillDFS(PixelVertex v, PixelWriter writer, Color fillColour) {
    Vector<PixelVertex> visited = new Vector<PixelVertex>();
    FloodFillDFSRecursive(v, writer, fillColour, visited);
  }

  private static void FloodFillDFSRecursive(PixelVertex v, PixelWriter writer, Color fillColour,
      Vector<PixelVertex> visited) {
    // fill v
    writer.setPixel(v.getX(), v.getY(), fillColour);
    // Label v as visited
    visited.add(v);
    // Visit unvisited neighboors of v
    LinkedList<PixelVertex> neighbours = v.getNeighbours();
    while (neighbours.size() > 0) {
      PixelVertex next = neighbours.removeFirst();
      if (!visited.contains(next)) {
        FloodFillDFSRecursive(next, writer, fillColour, visited);
      }
    }
  }

  /*
   * FloodFillBFS(v, writer, fillColour)
   * Traverse the component the vertex v using BFS and set the colour
   * of the pixels corresponding to all vertices encountered during the
   * traversal to fillColour.
   * 
   * To change the colour of a pixel at position (x,y) in the image to a
   * colour c, use
   * writer.setPixel(x,y,c);
   */
  public static void FloodFillBFS(PixelVertex v, PixelWriter writer, Color fillColour) {
    writer.setPixel(v.getX(), v.getY(), fillColour);
    // TODO: implement this method
  }

}