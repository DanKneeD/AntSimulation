import java.awt.Color;
import javax.swing.text.Position;

public class Ant {
  private int posX = 0;
  private int posY = 0;
  private int[] nextPosition = new int[2]; //for x and y
  private int state = (int) (Math.random() * 8) + 1;
  public boolean hasFood = false;
  private int phermoneVal = 255;

  public Ant(int x, int y) {
    posX = x;
    posY = y;
  }

  public void moveAnt() {
    // holds new cords and new stateVal;

    if (!phermoneDirection()) {
      randomDirection();
    }
    //no phermones  found

    //move ant, create phermone trails
    changeState(nextPosition);
  }

  //check if next move is outside of array
  private boolean isValidMove(int x, int y) {
    int tempX = posX + x;
    int tempY = posY + y;

    return (tempX >= 0 && tempX < Map.SIZE && tempY >= 0 && tempY < Map.SIZE);
  }

  //change ant location
  public boolean phermoneDirection() {
    int x = 0;
    int y = 0;
    int tempX = posX;
    int tempY = posY;
    int bestPhermone = 0;
    int phType = 2; //2 is green

    if (hasFood) {
      phType = 1;
    }

    switch (state) {
      case 1:
        if (
          isValidMove(tempX + 1, tempY) &&
          Map.phermoneValue[tempX + 1][tempY][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX + 1][tempY][phType];
          x = 1;
          y = 0;
          state = 4;
        }
        if (
          isValidMove(tempX + 1, tempY - 1) &&
          Map.phermoneValue[tempX + 1][tempY - 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX + 1][tempY - 1][phType];
          x = 1;
          y = -1;
          state = 1;
        }
        if (
          isValidMove(tempX, tempY - 1) &&
          Map.phermoneValue[tempX][tempY - 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX][tempY - 1][phType];
          x = 0;
          y = -1;
          state = 2;
        }
        break;
      case 2:
        if (
          isValidMove(tempX + 1, tempY - 1) &&
          Map.phermoneValue[tempX + 1][tempY - 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX + 1][tempY - 1][phType];
          x = 1;
          y = -1;
          state = 1;
        }
        if (
          isValidMove(tempX, tempY - 1) &&
          Map.phermoneValue[tempX][tempY - 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX][tempY - 1][phType];
          x = 0;
          y = -1;
          state = 2;
        }
        if (
          isValidMove(tempX - 1, tempY - 1) &&
          Map.phermoneValue[tempX - 1][tempY - 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX - 1][tempY - 1][phType];
          x = -1;
          y = -1;
          state = 3;
        }
        break;
      case 3:
        if (
          isValidMove(tempX, tempY - 1) &&
          Map.phermoneValue[tempX][tempY - 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX][tempY - 1][phType];
          x = 0;
          y = -1;
          state = 2;
        }
        if (
          isValidMove(tempX - 1, tempY - 1) &&
          Map.phermoneValue[tempX - 1][tempY - 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX - 1][tempY - 1][phType];
          x = -1;
          y = -1;
          state = 3;
        }

        if (
          isValidMove(tempX - 1, tempY) &&
          Map.phermoneValue[tempX - 1][tempY][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX - 1][tempY][phType];
          x = -1;
          y = 0;
          state = 5;
        }
        break;
      case 4:
        if (
          isValidMove(tempX + 1, tempY + 1) &&
          Map.phermoneValue[tempX + 1][tempY + 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX + 1][tempY + 1][phType];
          x = 1;
          y = 1;
          state = 6;
        }
        if (
          isValidMove(tempX + 1, tempY) &&
          Map.phermoneValue[tempX + 1][tempY][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX + 1][tempY][phType];
          x = 1;
          y = 0;
          state = 4;
        }

        if (
          isValidMove(tempX + 1, tempY - 1) &&
          Map.phermoneValue[tempX + 1][tempY - 1][phType - 1] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX + 1][tempY - 1][phType];
          x = 1;
          y = -1;
          state = 1;
        }
        break;
      case 5:
        if (
          isValidMove(tempX - 1, tempY - 1) &&
          Map.phermoneValue[tempX - 1][tempY - 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX - 1][tempY - 1][phType];
          x = -1;
          y = -1;
          state = 3;
        }
        if (
          isValidMove(tempX - 1, tempY) &&
          Map.phermoneValue[tempX - 1][tempY][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX - 1][tempY][phType];
          x = -1;
          y = 0;
          state = 5;
        }

        if (
          isValidMove(tempX - 1, tempY + 1) &&
          Map.phermoneValue[tempX - 1][tempY + 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX - 1][tempY + 1][phType];
          x = -1;
          y = 1;
          state = 8;
        }
        break;
      case 6:
        if (
          isValidMove(tempX, tempY + 1) &&
          Map.phermoneValue[tempX][tempY + 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX][tempY + 1][phType];
          x = 0;
          y = 1;
          state = 7;
        }
        if (
          isValidMove(tempX + 1, tempY + 1) &&
          Map.phermoneValue[tempX + 1][tempY + 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX + 1][tempY + 1][phType];
          x = 1;
          y = 1;
          state = 6;
        }

        if (
          isValidMove(tempX + 1, tempY) &&
          Map.phermoneValue[tempX + 1][tempY][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX + 1][tempY][phType];
          x = 1;
          y = 0;
          state = 4;
        }
        break;
      case 7:
        if (
          isValidMove(tempX - 1, tempY + 1) &&
          Map.phermoneValue[tempX - 1][tempY + 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX - 1][tempY + 1][phType];
          x = -1;
          y = 1;
          state = 8;
        }
        if (
          isValidMove(tempX, tempY + 1) &&
          Map.phermoneValue[tempX][tempY + 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX][tempY + 1][phType];
          x = 0;
          y = 1;
          state = 7;
        }

        if (
          isValidMove(tempX + 1, tempY + 1) &&
          Map.phermoneValue[tempX + 1][tempY + 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX + 1][tempY + 1][phType];
          x = 1;
          y = 1;
          state = 6;
        }
        break;
      case 8:
        if (
          isValidMove(tempX - 1, tempY) &&
          Map.phermoneValue[tempX - 1][tempY][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX - 1][tempY][phType];
          x = -1;
          y = 0;
          state = 5;
        }
        if (
          isValidMove(tempX - 1, tempY + 1) &&
          Map.phermoneValue[tempX - 1][tempY + 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX - 1][tempY + 1][phType];
          x = -1;
          y = 1;
          state = 8;
        }

        if (
          isValidMove(tempX + 1, tempY) &&
          Map.phermoneValue[tempX][tempY + 1][phType] > bestPhermone
        ) {
          bestPhermone = Map.phermoneValue[tempX][tempY + 1][phType];
          x = 0;
          y = 1;
          state = 7;
        }
        break;
    }

    if (x == 0 && y == 0) {
      return false;
    }
    nextPosition[0] = x;
    nextPosition[1] = y;
    return true;
  }

  public void randomDirection() {
    int x = 0;
    int y = 0;
    int randomDirection = (int) (Math.random() * 3);

    // randomly select direction based on last state
    switch (state) {
      case 1:
        switch (randomDirection) {
          case 0:
            x = 1;
            y = 0;
            state = 4;
            break;
          case 1:
            x = 1;
            y = -1;
            state = 1;
            break;
          case 2:
            x = 0;
            y = -1;
            state = 2;
            break;
        }
        break;
      case 2:
        switch (randomDirection) {
          case 0:
            x = 1;
            y = -1;
            state = 1;
            break;
          case 1:
            x = 0;
            y = -1;
            state = 2;
            break;
          case 2:
            x = -1;
            y = -1;
            state = 3;
            break;
        }
        break;
      case 3:
        switch (randomDirection) {
          case 0:
            x = 0;
            y = -1;
            state = 2;
            break;
          case 1:
            x = -1;
            y = -1;
            state = 3;
            break;
          case 2:
            x = -1;
            y = 0;
            state = 5;
            break;
        }
        break;
      case 4:
        switch (randomDirection) {
          case 0:
            x = 1;
            y = 1;
            state = 6;
            break;
          case 1:
            x = 1;
            y = 0;
            state = 4;
            break;
          case 2:
            x = 1;
            y = -1;
            state = 1;
            break;
        }
        break;
      case 5:
        switch (randomDirection) {
          case 0:
            x = -1;
            y = -1;
            state = 3;
            break;
          case 1:
            x = -1;
            y = 0;
            state = 5;
            break;
          case 2:
            x = -1;
            y = 1;
            state = 8;
            break;
        }
        break;
      case 6:
        switch (randomDirection) {
          case 0:
            x = 0;
            y = 1;
            state = 7;
            break;
          case 1:
            x = 1;
            y = 1;
            state = 6;
            break;
          case 2:
            x = 1;
            y = 0;
            state = 4;
            break;
        }
        break;
      case 7:
        switch (randomDirection) {
          case 0:
            x = -1;
            y = 1;
            state = 8;
            break;
          case 1:
            x = 0;
            y = 1;
            state = 7;
            break;
          case 2:
            x = 1;
            y = 1;
            state = 6;
            break;
        }
        break;
      case 8:
        switch (randomDirection) {
          case 0:
            x = -1;
            y = 0;
            state = 5;
            break;
          case 1:
            x = -1;
            y = 1;
            state = 8;
            break;
          case 2:
            x = 0;
            y = 1;
            state = 7;
            break;
        }
        break;
    }

    if (isValidMove(x, y)) {
      nextPosition[0] = x;
      nextPosition[1] = y;
    } else {
      nextPosition[0] = 0;
      nextPosition[1] = 0;
    }
  }

  public void changeState(int[] nextPosition) {
    //create phermones at current position (deletes ant)
    Map.reduceAntAt(posX, posY); // reduce number of ants at position
    if (!Map.isAntAt(posX, posY)) { //if another ant at position dont change anything
      if (hasFood) {
        Map.phermoneValue[posX][posY][2] = phermoneVal;
      } else {
        Map.phermoneValue[posX][posY][1] = phermoneVal;
      }
    }

    //update position to new position
    phermoneVal -= 1;
    posX += nextPosition[0];
    posY += nextPosition[1];
    Map.createAntAt(posX, posY);
  }
}
