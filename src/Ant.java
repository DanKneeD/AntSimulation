public class Ant {
  private int posI = 0;
  private int posJ = 0;

  public Ant(int i, int j) {
    posI = i;
    posJ = j;
  }

  private boolean isValidMove(int i, int j) {
    int tempI = posI + i;
    int tempJ = posJ + j;

    return (
      tempI >= 0 &&
      tempI < MapCreation.SIZE &&
      tempJ >= 0 &&
      tempJ < MapCreation.SIZE
    );
  }

  public void antMovementTest() {
    MapCreation.numAnts[posI][posJ] -= 1;

    if (MapCreation.numAnts[posI][posJ] <= 0) {
      MapCreation.changeColour(posI, posJ, false);
    }

    int i = 0;
    int j = 0;

    if (MapCreation.grid[posI][posJ] == 1) {
      i = (int) (Math.random() * 2);
      if (i == 0) {
        j = -1;
      } else {
        j = (int) (Math.random() * 2) - 1;
      }

      if (isValidMove(i, j)) {
        posI += i;
        posJ += j;
        if (i + j == -1) {
          MapCreation.grid[posI][posJ] = 2;
        } else if (i + j == 0) {
          MapCreation.grid[posI][posJ] = 1;
        } else if (i + j == 1) {
          MapCreation.grid[posI][posJ] = 4;
        }
      }
    } else if (MapCreation.grid[posI][posJ] == 2) {
      i = (int) (Math.random() * 3) - 1;
      j = -1;

      if (isValidMove(i, j)) {
        posI += i;
        posJ += j;
        if (i == -1) {
          MapCreation.grid[posI][posJ] = 3;
        } else if (i == 0) {
          MapCreation.grid[posI][posJ] = 2;
        } else if (i == 1) {
          MapCreation.grid[posI][posJ] = 1;
        }
      }
    } else if (MapCreation.grid[posI][posJ] == 3) {
      i = (int) (Math.random() * 2) - 1;

      if (i == 0) {
        j = -1;
      } else {
        j = (int) (Math.random() * 2) - 1;
      }

      if (isValidMove(i, j)) {
        posI += i;
        posJ += j;
        if (i + j == -2) {
          MapCreation.grid[posI][posJ] = 3;
        } else if (i == -1) {
          MapCreation.grid[posI][posJ] = 5;
        } else {
          MapCreation.grid[posI][posJ] = 2;
        }
      }
    } else if (MapCreation.grid[posI][posJ] == 4) {
      i = 1;
      j = (int) (Math.random() * 3) - 1;

      if (isValidMove(i, j)) {
        posI += i;
        posJ += j;
        if (j == 1) {
          MapCreation.grid[posI][posJ] = 6;
        } else if (j == 0) {
          MapCreation.grid[posI][posJ] = 4;
        } else {
          MapCreation.grid[posI][posJ] = 1;
        }
      }
    } else if (MapCreation.grid[posI][posJ] == 5) {
      i = -1;
      j = (int) (Math.random() * 3) - 1;

      if (isValidMove(i, j)) {
        posI += i;
        posJ += j;
        if (j == 1) {
          MapCreation.grid[posI][posJ] = 8;
        } else if (j == 0) {
          MapCreation.grid[posI][posJ] = 5;
        } else {
          MapCreation.grid[posI][posJ] = 3;
        }
      }
    } else if (MapCreation.grid[posI][posJ] == 6) {
      i = (int) (Math.random() * 2);

      if (i == 0) {
        j = 1;
      } else {
        j = (int) (Math.random() * 2);
      }

      if (isValidMove(i, j)) {
        posI += i;
        posJ += j;
        if (i + j == 2) {
          MapCreation.grid[posI][posJ] = 6;
        } else if (j == 0) {
          MapCreation.grid[posI][posJ] = 4;
        } else {
          MapCreation.grid[posI][posJ] = 7;
        }
      }
    } else if (MapCreation.grid[posI][posJ] == 7) {
      i = (int) (Math.random() * 3) - 1;
      j = 1;

      if (isValidMove(i, j)) {
        posI += i;
        posJ += j;
        if (i == -1) {
          MapCreation.grid[posI][posJ] = 8;
        } else if (i == 0) {
          MapCreation.grid[posI][posJ] = 7;
        } else {
          MapCreation.grid[posI][posJ] = 6;
        }
      }
    } else if (MapCreation.grid[posI][posJ] == 8) {
      i = (int) (Math.random() * 2) - 1;

      if (i == 0) {
        j = 1;
      } else {
        j = (int) (Math.random() * 2);
      }

      if (isValidMove(i, j)) {
        posI += i;
        posJ += j;
        if (i + j == -1) {
          MapCreation.grid[posI][posJ] = 5;
        } else if (i + j == 1) {
          MapCreation.grid[posI][posJ] = 7;
        } else {
          MapCreation.grid[posI][posJ] = 8;
        }
      }
    } else {
      System.out.println("------NOTHING HAPEND-------");
    }

    //change ant location
    MapCreation.changeColour(posI, posJ, true);
    MapCreation.numAnts[posI][posJ] += 1;
  }
}
