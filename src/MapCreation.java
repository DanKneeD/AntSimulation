import java.awt.*;
import javax.swing.*;

public class MapCreation extends JFrame {
  public static final int SIZE = 100;
  private static final int GRID_SIZE = 10;
  private static final int WINDOW_SIZE = 1000;
  public static int[][] grid;
  public static JLabel[][] labels;
  public static int[][] numAnts;

  public MapCreation() {
    System.out.println("Map Created");
    setLayout(new GridLayout(SIZE, SIZE));

    grid = new int[SIZE][SIZE];
    labels = new JLabel[SIZE][SIZE];
    numAnts = new int[SIZE][SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        grid[i][j] = 1;
        numAnts[i][j] = 0;

        labels[i][j] = new JLabel();
        labels[i][j].setPreferredSize(new Dimension(GRID_SIZE, GRID_SIZE));
        labels[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
        labels[i][j].setOpaque(true);
        add(labels[i][j]);
      }
    }

    setSize(WINDOW_SIZE, WINDOW_SIZE);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void changeColour(int i, int j, boolean isAnt) {
    if (isAnt) {
      labels[i][j].setBackground(Color.BLACK);
    } else {
      labels[i][j].setBackground(new Color(255, 0, 0, 200)); // Red with 0 alpha
    }
  }
}
