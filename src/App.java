import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class App {
  private static List<Ant> ants = new ArrayList<>();
  private static int numOfAnts = 1;
  private static int timeDelay = 1;

  public static void main(String[] args) throws Exception {
    new Map(); //create grid
    new Phermones();

    createAnts();
    simulateAnts();
  }

  private static void createAnts() {
    for (int i = 0; i < numOfAnts; i++) { // Create ants and add them to the list
      Ant ant = new Ant(50, 50);
      if ((int) (Math.random() * 2) == 0) {
        ant.hasFood = true;
      }
      Map.numAnts[50][50] += 1;
      ants.add(ant);
    }
  }

  private static void simulateAnts() {
    int simulationDuration = 1000;

    // Create a timer that fires an action event every timeDelay milliseconds
    Timer timer = new Timer(timeDelay, null);

    timer.addActionListener(
      new ActionListener() {
        private int ticksElapsed = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
          // On each tick, move the ants and update pheromones
          for (Ant ant : ants) {
            ant.moveAnt();
          }
          Map.updatePhermones();

          // If the simulation duration has been reached, stop the timer
          if (++ticksElapsed >= simulationDuration) {
            ((Timer) e.getSource()).stop();

            System.exit(0);
          }
        }
      }
    );

    // Start the timer
    timer.start();
  }
}
