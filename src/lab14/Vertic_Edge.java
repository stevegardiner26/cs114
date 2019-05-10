package lab14;

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Vertic_Edge
{
  //public String[] vertices = new String[12];
  public static String[] vertices = { "Seattle", "San Francisco", "Los Angeles", "Denver",
        "Kansas City", "Chicago", "Boston", "New York", "Atlanta", "Miami",
        "Dallas", "Houston" };

  public static int[][] edges = {{ 0, 1 }, { 0, 3 }, { 0, 5 }, { 1, 0 }, { 1, 2 },
        { 1, 3 }, { 2, 1 }, { 2, 3 }, { 2, 4 }, { 2, 10 }, { 3, 0 }, { 3, 1 },
        { 3, 2 }, { 3, 4 }, { 3, 5 }, { 4, 2 }, { 4, 3 }, { 4, 5 }, { 4, 7 },
        { 4, 8 }, { 4, 10 }, { 5, 0 }, { 5, 3 }, { 5, 4 }, { 5, 6 }, { 5, 7 },
        { 6, 5 }, { 6, 7 }, { 7, 4 }, { 7, 5 }, { 7, 6 }, { 7, 8 }, { 8, 4 },
        { 8, 7 }, { 8, 9 }, { 8, 10 }, { 8, 11 }, { 9, 8 }, { 9, 11 },
        { 10, 2 }, { 10, 4 }, { 10, 8 }, { 10, 11 }, { 11, 8 }, { 11, 9 },
        { 11, 10 } };

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Vertices of City: ");
      for (int i = 0; i < vertices.length; i++) {
          System.out.print(vertices[i] + ", ");
      }
      System.out.println(" ");
      System.out.println("Enter a starting city: ");
      String starting_input = scanner.nextLine();
      System.out.println("Enter an ending city: ");
      String ending_input = scanner.nextLine();
      int start = -1;
      int end = -1;
      for (int v = 0; v < vertices.length; v++) {
          if (starting_input.equals(vertices[v])) {
              start = v;
          }
          if (ending_input.equals(vertices[v])) {
              end = v;
          }
      }
      if (start == -1 || end == -1) {
          System.out.println("Sorry you did not enter a proper city!");
      } else {
          UnweightedGraphWithGetPath unweightedGraphWithGetPath = new UnweightedGraphWithGetPath(vertices, edges);
          System.out.println(unweightedGraphWithGetPath.getPath(start, end));
      }
  }
  
   public Vertic_Edge()
   { }

}