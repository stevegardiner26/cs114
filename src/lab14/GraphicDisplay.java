package lab14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class GraphicDisplay extends Application {
	public void start(Stage primaryStage) {
	    Scanner scanner = new Scanner(System.in);
        City[] vertices = {new City("Seattle", 75, 50), new City("San Francisco", 50, 210), new City("Los Angeles", 75, 275),
                new City("Denver", 275, 175), new City("Kansas City", 400, 245), new City("Chicago", 450, 100), new City("Boston", 700, 80), new City("New York", 675, 120),
                new City("Atlanta", 575, 295), new City("Miami", 600, 400), new City("Dallas", 408, 325), new City("Houston", 450, 360)};

        int[][] edges = {{0, 1}, {1, 0}, {1, 2}, {1, 3}, {2, 1},
                {2, 3}, {2, 4}, {2, 10}, {3, 1}, {3, 2}, {3, 4},
                {3, 5}, {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8},
                {4, 10}, {5, 3}, {5, 4}, {5, 6}, {5, 7}, {6, 5},
                {6, 7}, {7, 4}, {7, 5}, {7, 6}, {7, 8}, {8, 4},
                {8, 7}, {8, 9}, {8, 10}, {8, 11}, {9, 8}, {9, 11},
                {10, 2}, {10, 4}, {10, 8}, {10, 11}, {11, 8},
                {11, 9}, {11, 10}};

        String cities = "";
        for(int i = 0; i < vertices.length; i++) {
            cities += vertices[i].name + ",";
        }
        System.out.println("Vertices of City: " + cities);
        System.out.println("Enter a starting city: ");
        String starting_input = scanner.nextLine();
        System.out.println("Enter an ending city: ");
        String ending_input = scanner.nextLine();
        UnweightedGraphWithGetPath unweightedGraphWithGetPath = new UnweightedGraphWithGetPath(vertices, edges);
        System.out.println(unweightedGraphWithGetPath.getPath(0, 5));
    }
    
    static class City
    {
    private double x,y;
    private String name;
    
    City(String name, double x, double y)
     {
       this.name = name;
       this.x=x;
       this.y=y;
     }
    
    public double getX() { return x;}
    
    public double getY()  {return y;}
    
    public String getName() {return name;}
  }
 
}