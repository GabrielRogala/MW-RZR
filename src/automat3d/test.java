package automat3d;

import java.util.ArrayList;
import java.util.Random;

public class test {

    static int[][] board;
    static int tmp[][];
    static int size_x;
    static int size_y;
    static boolean perio = false;

    public static void main(String[] args) {

        size_x = 30;
        size_y = 30;
        int r = 8;

        board = new int[size_x][size_y];

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                board[i][j] = new Random().nextInt(3) + 1;
            }
        }
        print(board, size_x);

        System.out.println("wynik: " + randomArea(9, 9, r));
        print(tmp, 2 * r + 1);

    }

    public static int randomArea(int _x, int _y, int _r) {
        int tmp[][]; // tymczasowa tablica lokalna przechowująca sąsiadów
        tmp = new int[2 * _r + 1][2 * _r + 1]; // o rozmiarze kradratu opisanego na kole

        
        //przechodze po kazdym elemencie kwadratu i sprawdzam ktory sasiad jest w okregu (jest = wartosc, nie jest = 0)
        for (int i = 0; i < 2 * _r + 1; i++) {
            for (int j = 0; j < 2 * _r + 1; j++) {
                float r_tmp = (float)( Math.sqrt(Math.pow(_r - i, 2) + Math.pow(_r - j, 2)));
                if (_r < r_tmp) { // jeżeli po za okręgiem
                    tmp[i][j] = 0;
                } else { // jeżeli w okręgu
                    int xl = (_x - _r + i) % size_x; //size_x rozmiar globalnej tablicy (ekranu)
                    xl = xl < 0 ? size_x - 1 : xl;

                    int yl = (_y - _r + j) % size_y; //size_y rozmiar globalnej tablicy (ekranu)
                    yl = yl < 0 ? size_y - 1 : yl;

                    if (perio) { // jeżeli periodyczne to bierze wszystkich
                        tmp[i][j] = board[xl][yl]; // board - gloablna tablica tzrymająca początkowy stan
                    } else { // jeżeli nie perio to bierze tylko do krawędzi
                        if ((_x - _r + i) >= 0 && (_x - _r + i) < size_x && (_y - _r + j) >= 0 && (_y - _r + j) < size_y) {
                            tmp[i][j] = board[xl][yl];
                        } else {
                            tmp[i][j] = 0;
                        }
                    }

                }
            }
        }
        // boardPoint - punkt na tablicy posiada:
        //              pozycje x i y z tab globalnej
        //              ilość wystąpień
        //              identyfikator
        ArrayList<BoardPoint> areas = new ArrayList<BoardPoint>(); // niepowtarzalni sąsiedzi
        ArrayList<BoardPoint> maxAreas = new ArrayList<BoardPoint>(); // sasiedzi z max ilością wystąpień
        int max = 0;
        boolean find = false;
        
        // przechodze po kazdym elemencie tablicy i szukam niepowtarzalnych punktow i zbieram ich ilość
        for (int i = 0; i < 2 * _r + 1; i++) {
            for (int j = 0; j < 2 * _r + 1; j++) {
                if (tmp[i][j] != 0) {

                    find = false;
                    for (int l = 0; l < areas.size(); l++) {
                        if (tmp[i][j] == areas.get(l).getId()) {
                            areas.get(l).valueUp(); // zwiększam wystąpienie o 1
                            find = true;
                            max = max < areas.get(l).getValue() ? areas.get(l).getValue(): max;
                            break;
                        }
                    }

                    if (!find) {
                        areas.add(new BoardPoint(i, j, 1, tmp[i][j])); // dodaje nowy punkt który wcześniej nie wystąpił
                        max = max < 1 ? 1 : max;
                    }
                }
            }
        }      
        
        // zbieram wszystkie punkty(ziarna) o ilości wystąpień = max
        if(max == 0){
            return 0;
        }else{
            for (int l = 0; l < areas.size(); l++) {
                if (max == areas.get(l).getValue()) {
                    maxAreas.add(areas.get(l));
                }
            }
            return maxAreas.get(new Random().nextInt(maxAreas.size())).getId(); // zwracam losowe ziarno o max ilosci wystąpień
        }
        
    }

    public static void print(int[][] t, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("" + t[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n\n");
    }

}
