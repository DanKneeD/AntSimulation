import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class App {

  public static void main(String[] args) throws Exception {
    int numOfAnts = 50;
    List<Ant> ants = new ArrayList<>();

    new MapCreation(); //create grid

    for (int i = 0; i < numOfAnts; i++) { // Create ants and add them to the list
      Ant ant = new Ant(50, 50);
      MapCreation.numAnts[50][50] += 1;
      ants.add(ant);
    }

    for (int x = 0; x < 100; x++) { //time loop
      for (Ant ant : ants) {
        ant.antMovementTest();
        try {
          Thread.sleep(3); // pause 0.1 second
        } catch (InterruptedException e) {}
      }
    }
  }
}
