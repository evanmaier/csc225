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
    while (!neighbours.isEmpty()) {
      PixelVertex next = neighbours.poll();
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
    // Create a vector to track visited nodes
    Vector<PixelVertex> visited = new Vector<PixelVertex>();
    // Create a queue to store nodes to visit
    LinkedList<PixelVertex> queue = new LinkedList<PixelVertex>();
    // Add current node to queue
    queue.add(v);

    while (!queue.isEmpty()) {
      // Dequeue a node, colour it, and mark as visited
      v = queue.poll();
      writer.setPixel(v.getX(), v.getY(), fillColour);
      visited.add(v);
      // Get neighbours of v
      LinkedList<PixelVertex> neighbours = v.getNeighbours();
      while (!neighbours.isEmpty()) {
        // Enqueue unvisited neighbours
        PixelVertex next = neighbours.poll();
        if (!visited.contains(next)) {
          queue.add(next);
        }
      }
    }
  }
}