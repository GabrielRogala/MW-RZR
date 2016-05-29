package automat3d;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Rogala
 */
public class Board {

    private final int size_x;
    private final int size_y;
    private Grain boardGrain[][];
    private Grain boardGrain_tmp[][];
    private int board_tmp[][];

    private int countGrainsCristal = 0;
    private int countGrainsRecristal = 0;

    private int n;
    private Random rand = new Random();
    private boolean perio;
    private boolean endSimulation;

    private final double reA = 86710969050178.5;
    private final double reB = 9.41268203527779;
    private final double roMax = 28105600.95;
    double ro = 0;
    double roSr = 0;

    public int getCountGrainsRecristal() {
        return countGrainsRecristal;
    }

    public int getCountGrainsCristal() {
        return countGrainsCristal;
    }

    public boolean isEndSimulation() {
        return endSimulation;
    }

    public Board(int size_x, int size_y) {
        endSimulation = false;
        perio = false;
        this.size_x = size_x;
        this.size_y = size_y;
        n = 0;
        boardGrain = new Grain[size_x][size_y];
        boardGrain_tmp = new Grain[size_x][size_y];
        board_tmp = new int[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();
                boardGrain_tmp[i][j] = new Grain();
            }
        }
    }

    public Board() {
        endSimulation = false;
        perio = false;
        this.size_x = 500;
        this.size_y = 300;
        n = 0;
        boardGrain = new Grain[size_x][size_y];
        boardGrain_tmp = new Grain[size_x][size_y];
        board_tmp = new int[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();
                boardGrain_tmp[i][j] = new Grain();
            }
        }
    }

    public void changePeriodic() {
        perio = !perio;
    }

    public Grain[][] randomBoard(int randomSetup, int countX, int countY, int randomSize, int ringSize, int countRing) {
        switch (randomSetup) {
            case 0:

                for (int i = 0; i < size_x; i++) {
                    for (int j = 0; j < size_y; j++) {
                        if (rand.nextInt(1000) > 998) {
                            n++;
                            boardGrain[i][j].setId(n);
                        }
                    }
                }

                break;
            case 1:

                for (int i = countX; i < size_x; i += countX) {
                    for (int j = countY; j < size_y; j += countY) {
                        n++;
                        boardGrain[i][j].setId(n);
                    }
                }

                break;
            case 2:

                for (int i = 0; i < randomSize; i++) {
                    n++;
                    boardGrain[rand.nextInt(size_x)][rand.nextInt(size_y)].setId(n);
                }

                break;
            case 3:

                ArrayList<BoardPoint> points = new ArrayList<>();

                for (int i = 0; i < countRing; i++) {
                    int spr = 0;
                    int randX = rand.nextInt(size_x);
                    int randY = rand.nextInt(size_y);
                    boolean findOk = false;
                    while (spr < 100) {
                        spr++;
                        findOk = true;

                        for (BoardPoint p : points) {
                            findOk = true;

                            if (!p.point2point(randX, randY, ringSize)) {
                                findOk = false;
                                randX = rand.nextInt(size_x);
                                randY = rand.nextInt(size_y);
                                break;
                            }
                        }
                        if (findOk) {
                            n++;
                            points.add(new BoardPoint(randX, randY, 0, n));
                            break;
                        }
                    }
                }
                for (BoardPoint p : points) {
                    boardGrain[p.getX()][p.getY()].setId(p.getId());
                }

                break;
            default:
                break;
        }
        countGrainsCristal = n;
        return boardGrain;
    }

    public Grain[][] clear() {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j].setId(0);
            }
        }
        for (int i = 0; i < size_x; i++) {
            for (int j = 1; j < size_y; j++) {
                boardGrain[i][j].setB(false);
            }
        }
        n = 0;
        return boardGrain;
    }

    public Grain[][] edge() {
        for (int i = 1; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].getId() != boardGrain[i - 1][j].getId() && !boardGrain[i][j].isB()) {
                    boardGrain[i][j].setB(true);
                }
            }
        }
        for (int i = 0; i < size_x; i++) {
            for (int j = 1; j < size_y; j++) {
                if (boardGrain[i][j].getId() != boardGrain[i][j - 1].getId() && !boardGrain[i][j].isB()) {
                    boardGrain[i][j].setB(true);
                }
            }
        }
        return boardGrain;
    }

    public Grain[][] addGrain(int i, int j) {
        n++;
        boardGrain[i][j].setId(n);
        countGrainsCristal = n;
        return boardGrain;
    }

    public int recrystal() {
        int sum = 0;
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].isR()) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public int crystal() {
        int sum = 0;
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].getId() > 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public void clearRecrystal() {
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j].setR(false);
                boardGrain[i][j].setRo(0);
            }
        }
        countGrainsRecristal = 0;
    }
    
    //-------wielowątkowo----------------V
    public Grain[][] THcalculate(int areaSetup, int r) {
        int thread_pool = 4;

        WorkerThread[] wt = new WorkerThread[thread_pool];
        for (int i = 0; i < thread_pool; i++) {
            wt[i] = new WorkerThread(thread_pool, size_x, size_y, boardGrain, i, perio, areaSetup, r);
            wt[i].start();
        }
        
        for (int i = 0; i < thread_pool; i++) {
            try {
                wt[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (int id = 0; id < thread_pool; id++) {
            
            board_tmp = wt[id].getBoard_tmp();
            
            int pocz = (size_x / thread_pool) * id;
            int kon = (size_x / thread_pool) * (id + 1);
            for (int i = pocz; i < kon; i++) {
                for (int j = 0; j < size_y; j++) {
                    boardGrain[i][j].setId(board_tmp[i][j]);
                }
            }
        }

        return boardGrain;
    }

    //--------jednowątkowo---------------V
    public Grain[][] calculate(int areaSetup, int r) {
        endSimulation = true;
        int tmp[][] = new int[3][3];

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                board_tmp[i][j] = boardGrain[i][j].getId();
            }
        }

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].getId() == 0) {
                    endSimulation = false;
                    if (areaSetup == 7) {
                        board_tmp[i][j] = randomArea(i, j, r);
                    } else {
                        tmp = createArea(i, j, areaSetup, false);
                        board_tmp[i][j] = area(tmp);
                    }
                }
            }
        }

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j].setId(board_tmp[i][j]);
            }
        }

        return boardGrain;
    }

    public Grain[][] reCalculate(int areaSetup, double dT) {
        endSimulation = true;
        ro = reA / reB + (1 - (reA / reB)) * Math.exp(-1 * reB * dT);
        roSr = ro / (size_x * size_y);

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].isB() && !boardGrain[i][j].isR()) {
                    if (rand.nextDouble() > 0.9) { // zwiększa ro tylko 10% ziaren
                        boardGrain[i][j].addRo(roSr * (1.2 + rand.nextDouble() * 0.6));
                        endSimulation = false;
                    }
                    if (boardGrain[i][j].getRo() > roMax) {
                        n++;
                        boardGrain[i][j].setId(n);
                        boardGrain[i][j].setB(false);
                        boardGrain[i][j].setR(true);
                        boardGrain[i][j].setRo(0);
                        countGrainsRecristal++;
                        endSimulation = false;
                    }
                } else {
                    boardGrain[i][j].addRo(roSr * (rand.nextDouble() * 0.3));
                }
            }
        }

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain_tmp[i][j].setId(boardGrain[i][j].getId());
            }
        }

        int tmp[][] = new int[3][3];

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (!boardGrain[i][j].isR()){
                    if (areaSetup == 7) {
                        tmp = createArea(i, j, 6, true);
                        board_tmp[i][j] = area(tmp);
                    } else {
                        tmp = createArea(i, j, areaSetup, true);
                        board_tmp[i][j] = area(tmp);
                    }
                    boardGrain_tmp[i][j].setId(board_tmp[i][j]);
                }
            }
        }

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain_tmp[i][j].getId() > 0) {

                    endSimulation = false;
                    boardGrain[i][j].setId(boardGrain_tmp[i][j].getId());
                    boardGrain[i][j].setB(false);
                    boardGrain[i][j].setR(true);
                    boardGrain[i][j].setRo(0);
                }
            }
        }

        return boardGrain;

    }
    
    private int randomArea(int x, int y, int r) {
        int tmp[][];
        tmp = new int[2 * r + 1][2 * r + 1];

        for (int i = 0; i < 2 * r + 1; i++) {
            for (int j = 0; j < 2 * r + 1; j++) {
                float r_tmp = (float) (Math.sqrt(Math.pow(r - i, 2) + Math.pow(r - j, 2)));
                if (r < r_tmp) {
                    tmp[i][j] = 0;
                } else {
                    int xl = (x - r + i) % size_x;
                    xl = xl < 0 ? size_x - 1 : xl;

                    int yl = (y - r + j) % size_y;
                    yl = yl < 0 ? size_y - 1 : yl;

                    if (perio) {
                        tmp[i][j] = boardGrain[xl][yl].getId();
                    } else {
                        if ((x - r + i) >= 0 && (x - r + i) < size_x && (y - r + j) >= 0 && (y - r + j) < size_y) {
                            tmp[i][j] = boardGrain[xl][yl].getId();
                        } else {
                            tmp[i][j] = 0;
                        }
                    }

                }
            }
        }

        ArrayList<BoardPoint> areas = new ArrayList<BoardPoint>();
        ArrayList<BoardPoint> maxAreas = new ArrayList<BoardPoint>();
        int max = 0;
        boolean find = false;

        for (int i = 0; i < 2 * r + 1; i++) {
            for (int j = 0; j < 2 * r + 1; j++) {
                if (tmp[i][j] != 0) {

                    find = false;
                    for (int l = 0; l < areas.size(); l++) {
                        if (tmp[i][j] == areas.get(l).getId()) {
                            areas.get(l).valueUp();
                            find = true;
                            max = max < areas.get(l).getValue() ? areas.get(l).getValue() : max;
                            break;
                        }
                    }

                    if (!find) {
                        areas.add(new BoardPoint(i, j, 1, tmp[i][j]));
                        max = max < 1 ? 1 : max;
                    }
                }
            }
        }

        if (max == 0) {
            return 0;
        } else {
            for (int l = 0; l < areas.size(); l++) {
                if (max == areas.get(l).getValue()) {
                    maxAreas.add(areas.get(l));
                }
            }
            return maxAreas.get(new Random().nextInt(maxAreas.size())).getId();
        }

    }
    
    private int[][] createArea(int i, int j, int areaSetup, boolean recrystal) {
        int tmp[][] = new int[3][3];

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                int l_x = (size_x + (i - 1 + k)) % size_x;
                int l_y = (size_y + (j - 1 + l)) % size_y;
                if (recrystal) {
                    if (boardGrain[l_x][l_y].isR()) {
                        tmp[k][l] = boardGrain[l_x][l_y].getId();
                    } else {
                        tmp[k][l] = 0;
                    }
                } else {
                    tmp[k][l] = boardGrain[l_x][l_y].getId();
                }
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

        int tmp_area = areaSetup;
        boolean _rand = true;
        while (_rand) {
            switch (tmp_area) {
                case 0: //moor
                {
                    _rand = false;
                    break;
                }
                case 1: //neumann
                {
                    tmp[0][0] = 0;
                    tmp[2][0] = 0;
                    tmp[0][2] = 0;
                    tmp[2][2] = 0;
                    _rand = false;
                    break;
                }
                case 2: //hex L
                {
                    tmp[0][2] = 0;
                    tmp[2][0] = 0;
                    _rand = false;
                    break;
                }
                case 3: //hex P
                {
                    tmp[0][0] = 0;
                    tmp[2][2] = 0;
                    _rand = false;
                    break;
                }
                case 4: //hex R
                {
                    if (rand.nextBoolean()) {
                        tmp[0][2] = 0;
                        tmp[2][0] = 0;
                    } else {
                        tmp[0][0] = 0;
                        tmp[2][2] = 0;
                    }
                    _rand = false;
                    break;
                }
                case 5: //pen L
                {
                    int randPent = rand.nextInt(4);
                    if (randPent == 0) {
                        for (int k = 0; k < 3; k++) {
                            tmp[0][k] = 0;
                        }
                    } else if (randPent == 1) {
                        for (int k = 0; k < 3; k++) {
                            tmp[k][0] = 0;
                        }
                    } else if (randPent == 2) {
                        for (int k = 0; k < 3; k++) {
                            tmp[2][k] = 0;
                        }
                    } else {
                        for (int k = 0; k < 3; k++) {
                            tmp[k][2] = 0;
                        }
                    }
                    _rand = false;
                    break;
                }
                case 6: //rand
                {
                    tmp_area = rand.nextInt(5);
                    break;
                }
                default:
                    _rand = false;
                    break;
            }
        }

        return tmp;
    }
    
    private int area(int[][] tab) {
        int areas[][] = new int[3][3];
        ArrayList<BoardPoint> max_l = new ArrayList<BoardPoint>();
        int max_x = 0;
        int max_y = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (tab[k][l] != 0) {
                            if (tab[i][j] == tab[k][l]) {
                                areas[i][j]++;
                            }
                        }
                    }
                }

                if (areas[i][j] > areas[max_x][max_y]) {
                    max_x = i;
                    max_y = j;
                }

            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (areas[i][j] == areas[max_x][max_y]) {
                    max_l.add(new BoardPoint(i, j, areas[i][j]));
                }
            }
        }
        int max = rand.nextInt(max_l.size());

        return tab[max_l.get(max).getX()][max_l.get(max).getY()];
    }
    
    
}
