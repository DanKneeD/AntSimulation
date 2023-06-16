import java.awt.Color;
import javax.swing.text.Position;

public class Ant {
  // if (isValidMove(tempI + 1, tempJ)) {
  //   if (Map.phermoneValue[tempI + 1][tempJ][2] > phemoneVal) {
  //     phemoneVal = Map.phermoneValue[tempI][tempJ][2];
  //   }
  // } else if (isValidMove(tempI, tempJ - 1)) {
  //   if (Map.phermoneValue[tempI][tempJ - 1][2] > phemoneVal) {
  //     phemoneVal = Map.phermoneValue[tempI][tempJ][2];
  //   }
  // } else if (isValidMove(tempI + 1, tempJ - 1)) {
  //   if (Map.phermoneValue[tempI + 1][tempJ - 1][2] > phemoneVal) {
  //     phemoneVal = Map.phermoneValue[tempI][tempJ][2];
  //   }
  // }
  private int posI = 0;
  private int posJ = 0;
  public boolean hasFood = false;

  public Ant(int i, int j) {
    posI = i;
    posJ = j;
  }

  //check if next move is outside of array
  private boolean isValidMove(int i, int j) {
    int tempI = posI + i;
    int tempJ = posJ + j;

    return (tempI >= 0 && tempI < Map.SIZE && tempJ >= 0 && tempJ < Map.SIZE);
  }

  // private boolean locatedFood() {
  //   int i = posI;
  //   int j = posJ;
  //   if (Map.phermoneValue[posI][posJ][2] > 0) {}

  //   return false;
  // }

  // private void findNextMove() {
  //   int i = 0;
  //   int j = 0;
  //   int state = 0;

  //   if (Map.grid[posI][posJ] == 1) {
  //     state = 1;

  //     //choosing next random position
  //     i = (int) (Math.random() * 2);
  //     if (i == 0) {
  //       j = -1;
  //     } else {
  //       j = (int) (Math.random() * 2) - 1;
  //     }

  //     //

  //     if (isValidMove(i, j)) {
  //       posI += i;
  //       posJ += j;
  //       if (i + j == -1) {
  //         Map.grid[posI][posJ] = 2;
  //       } else if (i + j == 0) {
  //         Map.grid[posI][posJ] = 1;
  //       } else if (i + j == 1) {
  //         Map.grid[posI][posJ] = 4;
  //       }
  //     }
  //   } else if (Map.grid[posI][posJ] == 2) {
  //     state = 1;

  //     i = (int) (Math.random() * 3) - 1;
  //     j = -1;

  //     if (isValidMove(i, j)) {
  //       posI += i;
  //       posJ += j;
  //       if (i == -1) {
  //         Map.grid[posI][posJ] = 3;
  //       } else if (i == 0) {
  //         Map.grid[posI][posJ] = 2;
  //       } else if (i == 1) {
  //         Map.grid[posI][posJ] = 1;
  //       }
  //     }
  //   } else if (Map.grid[posI][posJ] == 3) {
  //     state = 1;

  //     i = (int) (Math.random() * 2) - 1;

  //     if (i == 0) {
  //       j = -1;
  //     } else {
  //       j = (int) (Math.random() * 2) - 1;
  //     }

  //     if (isValidMove(i, j)) {
  //       posI += i;
  //       posJ += j;
  //       if (i + j == -2) {
  //         Map.grid[posI][posJ] = 3;
  //       } else if (i == -1) {
  //         Map.grid[posI][posJ] = 5;
  //       } else {
  //         Map.grid[posI][posJ] = 2;
  //       }
  //     }
  //   } else if (Map.grid[posI][posJ] == 4) {
  //     i = 1;
  //     j = (int) (Math.random() * 3) - 1;

  //     if (isValidMove(i, j)) {
  //       posI += i;
  //       posJ += j;
  //       if (j == 1) {
  //         Map.grid[posI][posJ] = 6;
  //       } else if (j == 0) {
  //         Map.grid[posI][posJ] = 4;
  //       } else {
  //         Map.grid[posI][posJ] = 1;
  //       }
  //     }
  //   } else if (Map.grid[posI][posJ] == 5) {
  //     i = -1;
  //     j = (int) (Math.random() * 3) - 1;

  //     if (isValidMove(i, j)) {
  //       posI += i;
  //       posJ += j;
  //       if (j == 1) {
  //         Map.grid[posI][posJ] = 8;
  //       } else if (j == 0) {
  //         Map.grid[posI][posJ] = 5;
  //       } else {
  //         Map.grid[posI][posJ] = 3;
  //       }
  //     }
  //   } else if (Map.grid[posI][posJ] == 6) {
  //     i = (int) (Math.random() * 2);

  //     if (i == 0) {
  //       j = 1;
  //     } else {
  //       j = (int) (Math.random() * 2);
  //     }

  //     if (isValidMove(i, j)) {
  //       posI += i;
  //       posJ += j;
  //       if (i + j == 2) {
  //         Map.grid[posI][posJ] = 6;
  //       } else if (j == 0) {
  //         Map.grid[posI][posJ] = 4;
  //       } else {
  //         Map.grid[posI][posJ] = 7;
  //       }
  //     }
  //   } else if (Map.grid[posI][posJ] == 7) {
  //     i = (int) (Math.random() * 3) - 1;
  //     j = 1;

  //     if (isValidMove(i, j)) {
  //       posI += i;
  //       posJ += j;
  //       if (i == -1) {
  //         Map.grid[posI][posJ] = 8;
  //       } else if (i == 0) {
  //         Map.grid[posI][posJ] = 7;
  //       } else {
  //         Map.grid[posI][posJ] = 6;
  //       }
  //     }
  //   } else if (Map.grid[posI][posJ] == 8) {
  //     i = (int) (Math.random() * 2) - 1;

  //     if (i == 0) {
  //       j = 1;
  //     } else {
  //       j = (int) (Math.random() * 2);
  //     }

  //     if (isValidMove(i, j)) {
  //       posI += i;
  //       posJ += j;
  //       if (i + j == -1) {
  //         Map.grid[posI][posJ] = 5;
  //       } else if (i + j == 1) {
  //         Map.grid[posI][posJ] = 7;
  //       } else {
  //         Map.grid[posI][posJ] = 8;
  //       }
  //     }
  //   } else {
  //     System.out.println("------NOTHING HAPEND-------");
  //   }
  // }

  // private void actuallyMove(int oldI, int oldJ) {
  //   if (oldI != posI || oldJ != posJ) {
  //     Map.numAnts[oldI][oldJ] -= 1;
  //     if (Map.numAnts[oldI][oldJ] <= 0) { //if another ant at position dont change anything
  //       if (hasFood) {
  //         Map.phermoneValue[oldI][oldJ][2] = 255;
  //         Phermones.foodPheromones(oldI, oldJ);
  //       } else {
  //         Phermones.nestPheromones(oldI, oldJ);
  //         Map.phermoneValue[oldI][oldJ][1] = 255;
  //       }
  //     }
  //   }
  // }

  // public void antMovementTest() {
  //   int oldI = posI;
  //   int oldJ = posJ;

  //   if (!locatedFood()) {
  //     findNextMove();
  //   }

  //   actuallyMove(oldI, oldJ);

  //   Map.changePanel(posI, posJ, Color.black); // move ant to new position
  //   Map.numAnts[posI][posJ] += 1;

  //   Map.phermoneValue[posI][posJ][1] = -1;
  // }

  //change ant location

  public void moveAnt() {
    int state = Map.grid[posI][posJ];
    int[] nextPosition; // holds new cords and new stateVal;

    nextPosition = locatePhermone(state);

    //phermone not found
    if (nextPosition[0] == 0 && nextPosition[1] == 0) {
      nextPosition = randomDirection(state);
    }

    //move ant, create phermone trails
    changeState(nextPosition);
  }

  public int[] locatePhermone(int state) {
    int[] position = new int[3];

    return position;
  }

  public int[] randomDirection(int state) {
    int[] position = new int[3];
    int i = 0;
    int j = 0;

    // randomly select direction based on last direct(state)
    switch (state) {
      case 1:
        i = (int) (Math.random() * 2);
        j = i == 0 ? -1 : (int) (Math.random() * 2) - 1;
        switch (i + j) { // cacluating next state
          case -1:
            position[2] = 2;
            break;
          case 0:
            position[2] = 1;
            break;
          case 1:
            position[2] = 4;
            break;
        }
        break;
      case 2:
        i = (int) (Math.random() * 3) - 1;
        j = -1;
        switch (i + j) { // cacluating next state
          case -2:
            position[2] = 3;
            break;
          case -1:
            position[2] = 2;
            break;
          case 0:
            position[2] = 1;
            break;
        }
        break;
      case 3:
        i = (int) (Math.random() * 2) - 1;
        j = i == 0 ? -1 : (int) (Math.random() * 2) - 1;
        switch (i + j) { // cacluating next state
          case -2:
            position[2] = 3;
            break;
          default:
            position[2] = (i == -1) ? 5 : 2;
            break;
        }
        break;
      case 4:
        i = 1;
        j = (int) (Math.random() * 3) - 1;
        switch (i + j) { // cacluating next state
          case 2:
            position[2] = 6;
            break;
          case 1:
            position[2] = 4;
            break;
          case 0:
            position[2] = 1;
            break;
        }
        break;
      case 5:
        i = -1;
        j = (int) (Math.random() * 3) - 1;
        switch (i + j) { // cacluating next state
          case 0:
            position[2] = 8;
            break;
          case -1:
            position[2] = 5;
            break;
          case -2:
            position[2] = 3;
            break;
        }
        break;
      case 6:
        i = (int) (Math.random() * 2);
        j = i == 0 ? 1 : (int) (Math.random() * 2);
        position[2] = 6;
        switch (i + j) { // cacluating next state
          case 2:
            position[2] = 6;
            break;
          default:
            position[2] = (i == 1) ? 4 : 7;
            break;
        }
        break;
      case 7:
        i = (int) (Math.random() * 3) - 1;
        j = 1;
        switch (i + j) { // cacluating next state
          case 0:
            position[2] = 8;
            break;
          case 1:
            position[2] = 7;
            break;
          case 2:
            position[2] = 6;
            break;
        }
        break;
      case 8:
        i = (int) (Math.random() * 2) - 1;
        j = i == 0 ? 1 : (int) (Math.random() * 1);
        switch (i + j) { // cacluating next state
          case -1:
            position[2] = 5;
            break;
          case 0:
            position[2] = 8;
            break;
          case 1:
            position[2] = 7;
            break;
        }
        break;
    }

    if (isValidMove(i, j)) {
      position[0] = i;
      position[1] = j;
    }

    return position;
  }

  public void changeState(int[] nextPosition) {
    //create phermones at current position (deletes ant)
    Map.reduceAntAt(posI, posJ); // reduce number of ants at position
    if (!Map.isAntAt(posI, posJ)) { //if another ant at position dont change anything
      if (hasFood) {
        Map.phermoneValue[posI][posJ][2] = 255;
        Phermones.createFoodPheromone(posI, posJ);
      } else {
        Map.phermoneValue[posI][posJ][1] = 255;
        Phermones.createNestPheromone(posI, posJ);
      }
    }

    //update position to new position
    posI += nextPosition[0];
    posJ += nextPosition[1];
    Map.createAntAt(posI, posJ, nextPosition[2]);
  }
}
