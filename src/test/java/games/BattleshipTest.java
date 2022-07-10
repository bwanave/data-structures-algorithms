package games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BattleshipTest {

    @Test
    void playGameTest() {
        Input input = createInput();
        Battleship battleship = new Battleship();
        Output output = battleship.playGame(input);
        char[][] actualPlayer1Grid = output.getPlayer1Grid();
        char[][] expectedPlayer1Grid = createPlayer1ExpectedGrid();
        assertEquals(expectedPlayer1Grid, actualPlayer1Grid);

        char[][] actualPlayer2Grid = output.getPlayer2Grid();
        char[][] expectedPlayer2Grid = createPlayer2ExpectedGrid();
        assertEquals(expectedPlayer2Grid, actualPlayer2Grid);

        Assertions.assertEquals(output.getPlayer1HitCount(), 3);
        Assertions.assertEquals(output.getPlayer2HitCount(), 3);
        Assertions.assertEquals(output.getResult(), "It is a draw");
    }

    private void assertEquals(char[][] expected, char[][] actual) {
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual.length; j++) {
                Assertions.assertEquals(expected[i][j], actual[i][j]);
            }
        }
    }

    private Input createInput() {
        Input input = new Input();
        input.setGridSize(5);
        input.setTotalShips(5);
        input.setPlayer1Ships("1,1 : 2,0 : 2,3 : 3,4 : 4,3");
        input.setPlayer2Ships("0,1 : 2,3 : 3,0 : 3,4 : 4,1");
        input.setTotalShips(5);
        input.setPlayer1MissilePositions("0,1 : 4,3 : 2,3 : 3,1 : 4,1");
        input.setPlayer2MissilePositions("0,1 : 0,0 : 1,1 : 2,3 : 4,3");
        return input;
    }

    private char[][] createPlayer1ExpectedGrid() {
        char[][] grid = new char[5][5];
        for (char[] row : grid)
            Arrays.fill(row, '-');
        grid[0][0] = 'O';
        grid[0][1] = 'O';
        grid[1][1] = 'X';
        grid[2][0] = 'B';
        grid[2][3] = 'X';
        grid[3][4] = 'B';
        grid[4][3] = 'X';
        return grid;
    }

    private char[][] createPlayer2ExpectedGrid() {
        char[][] grid = new char[5][5];
        for (char[] row : grid)
            Arrays.fill(row, '-');
        grid[0][1] = 'X';
        grid[2][3] = 'X';
        grid[3][0] = 'B';
        grid[3][1] = 'O';
        grid[3][4] = 'B';
        grid[4][1] = 'X';
        grid[4][3] = 'O';
        return grid;
    }
}