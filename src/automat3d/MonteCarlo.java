package automat3d;

import java.util.ArrayList;
import java.util.Random;

public class MonteCarlo {

    private final int size_x;
    private final int size_y;
    private Grain boardGrain[][];
    private int n;
    private Random rand;
    private boolean perio;
    ArrayList<BoardPoint> grains;

    public MonteCarlo(int size_x, int size_y, int n) {
        grains = new ArrayList<BoardPoint>();
        perio = false;
        rand = new Random();
        this.size_x = size_x;
        this.size_y = size_y;
        this.n = n;
        boardGrain = new Grain[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();
            }
        }
    }

    public MonteCarlo() {
        grains = new ArrayList<BoardPoint>();
        perio = false;
        rand = new Random();
        this.size_x = 500;
        this.size_y = 300;
        this.n = 50;
        boardGrain = new Grain[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();
            }
        }

    }

    public Grain[][] randomBoard() {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j].setId(rand.nextInt(n) + 1);
            }
        }
        return boardGrain;
    }

    public Grain[][] calculate() {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                grains.add(new BoardPoint(i,j,0,boardGrain[i][j].getId()));
            }
        }
        int id = 0;
        
        while(id<size_x*size_y){
            //zmiana wartości ziarna...
            id++;
        }
        
        return boardGrain;
    }

    private int[][] createArea(int i, int j) {
        int tmp[][] = new int[3][3];

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int l_x = (size_x + (i - 1 + k)) % size_x;
                int l_y = (size_y + (j - 1 + l)) % size_y;
                tmp[k][l] = boardGrain[l_x][l_y].getId();
            }
        }

        if (!perio) {
            if (i == 0) {
                for (int k = 0; k < 3; k++) {
                    tmp[0][k] = 0;
                }
            }
            if (j == 0) {
                for (int k = 0; k < 3; k++) {
                    tmp[k][0] = 0;
                }
            }
            if (i == size_x - 1) {
                for (int k = 0; k < 3; k++) {
                    tmp[2][k] = 0;
                }
            }
            if (j == size_y - 1) {
                for (int k = 0; k < 3; k++) {
                    tmp[k][2] = 0;
                }
            }
        }

        return tmp;
    }

    private int area(int[][] tab) {

        ArrayList<BoardPoint> once = new ArrayList<BoardPoint>();
        int power = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (tab[i][j] == tab[k][l]) {
                            power++;
                        }
                    }
                }
            }
        }

        return power - 9;
    }

    private int getRandomNeighbor(int[][] tab) {
        int id = rand.nextInt(8);
        id = id > 3 ? id + 1 : id;
        return tab[id / 3][id % 3];
    }

}
