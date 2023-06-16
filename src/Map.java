import java.awt.*;
import javax.swing.*;

public class Map extends JFrame {
  public static final int SIZE = 100;
  private static final int GRID_SIZE = 1;
  private static final int WINDOW_SIZE = 1000;

  public static int[][] grid;
  public static JLabel[][] labels;
  public static int[][] numAnts;
  public static int[][][] phermoneValue;

  public Map() {
    System.out.println("Map Created");
    setLayout(new GridLayout(SIZE, SIZE));

    grid = new int[SIZE][SIZE];
    labels = new JLabel[SIZE][SIZE];
    numAnts = new int[SIZE][SIZE];
    phermoneValue = new int[SIZE][SIZE][3];

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        grid[i][j] = 4;
        numAnts[i][j] = 0;
        phermoneValue[i][j][1] = 0;

        //grid creation
        labels[i][j] = new JLabel();
        labels[i][j].setPreferredSize(new Dimension(GRID_SIZE, GRID_SIZE));
        // labels[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
        labels[i][j].setOpaque(true);
        labels[i][j].setBackground(new Color(0, 0, 0, 0));
        add(labels[i][j]);
      }
    }

    setSize(WINDOW_SIZE, WINDOW_SIZE);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void changePanel(int i, int j, Color col) {
    labels[i][j].setBackground(col);
  }

  public static void updatePhermones() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (phermoneValue[i][j][1] > 0) {
          phermoneValue[i][j][1] -= 3;
          labels[i][j].setBackground(
              new Color(phermoneValue[i][j][1], 0, 0, phermoneValue[i][j][1])
            );
        }
      }
    }

    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (phermoneValue[i][j][2] > 0) {
          phermoneValue[i][j][2] -= 3;
          labels[i][j].setBackground(
              new Color(0, phermoneValue[i][j][2], 0, phermoneValue[i][j][2])
            );
        }
      }
    }
    // Repaint the JFrame to update the visual state of the GUI
    JFrame.getFrames()[0].repaint();
  }

  public static void reduceAntAt(int i, int j) {
    numAnts[i][j] -= 1;
  }

  public static boolean isAntAt(int i, int j) {
    if (Map.numAnts[i][j] > 0) {
      return true;
    }
    return false;
  }

  public static void createAntAt(int i, int j, int state) {
    changePanel(i, j, Color.black);
    numAnts[i][j] += 1;
    grid[i][j] = state;
    System.out.println(state);
    // Map.phermoneValue[posI][posJ][1] = -1; idk about this one
  }
}
