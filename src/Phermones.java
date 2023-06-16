import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import javax.swing.JLabel;

public class Phermones {

  public Phermones() {
 
  }


  public static void updatePhermones() {}

  public static void createNestPheromone(int i, int j) { //create tail to nest
    Map.changePanel(i, j, Color.RED);
  }

  public static void createFoodPheromone(int i, int j) { //create tail to nest
    Map.changePanel(i, j, Color.GREEN);
  }
}
