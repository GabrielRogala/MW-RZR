package automat3d;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Automat3DForm extends javax.swing.JFrame {

    static final int size_x = 500;
    static final int size_y = 300;
    static final double reA = 86710969050178.5;
    static final double reB = 9.41268203527779;
    static final double roMax = 28105600.95;
    double dT = 0;
    double ro = 0;
    double roSr = 0;
    static int n = 0;
    Random rand = new Random();
    HandlerClass handler = new HandlerClass();
    boolean perio;
    Thread t;
    Grain boardGrain[][];
//    int board[][];
    int board_tmp[][];
    Grain boardGrain_tmp[][];
    int area = 0;
    int _r = 0;
    boolean simLoop;

    public Automat3DForm() {
        perio = false;
//        board = new int[size_x][size_y];

        boardGrain = new Grain[size_x][size_y];
        boardGrain_tmp = new Grain[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();
                boardGrain_tmp[i][j] = new Grain();
            }
        }

        board_tmp = new int[size_x][size_y];
        initComponents();
        this.jPanel5.setVisible(false);
        this.jPanel6.setVisible(false);
        this.jPanel7.setVisible(false);
        this.jPanel8.setVisible(false);
        canvas1.addMouseListener(handler);
        canvas1.addMouseMotionListener(handler);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        StartButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();
        RandomButton = new javax.swing.JButton();
        BCsButton = new javax.swing.JToggleButton();
        ClearButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        randomCombo = new javax.swing.JComboBox();
        recrystalButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        canvas1 = new automat3d.Canvas();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        countXText = new javax.swing.JTextField();
        countYText = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        randomSizeText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        colorValueLabel = new javax.swing.JLabel();
        colorPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        ringSizeField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        amountRingsField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        radiusText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(StartButton, gridBagConstraints);

        StopButton.setText("Stop");
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(StopButton, gridBagConstraints);

        RandomButton.setText("Generuj");
        RandomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RandomButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel2.add(RandomButton, gridBagConstraints);

        BCsButton.setText("P");
        BCsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(BCsButton, gridBagConstraints);

        ClearButton.setText("Czyść");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(ClearButton, gridBagConstraints);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Moore'a", "von Neumann'a", "Hexagonalne (lewe)", "Hexagonalne (prawe)", "Hexagonalne (losowe)", "Pentagonalne", "Losowe", "Losowe (po promieniu)" }));
        jComboBox1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(jComboBox1, gridBagConstraints);

        randomCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Losowe", "Stała odległość", "Stała ilość ziaren", "Po okręgu" }));
        randomCombo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                randomComboPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(randomCombo, gridBagConstraints);

        recrystalButton.setText("Rekrystalizacja");
        recrystalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recrystalButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        jPanel2.add(recrystalButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel3.setMinimumSize(new java.awt.Dimension(500, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 300));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        canvas1.setPreferredSize(new java.awt.Dimension(500, 300));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        jPanel3.add(canvas1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("X:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Y:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel6.add(jLabel2, gridBagConstraints);

        countXText.setText("10");
        countXText.setMinimumSize(new java.awt.Dimension(40, 22));
        countXText.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(countXText, gridBagConstraints);

        countYText.setText("10");
        countYText.setMinimumSize(new java.awt.Dimension(40, 22));
        countYText.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel6.add(countYText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel1.add(jPanel6, gridBagConstraints);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Ilość ziaren:");
        jPanel5.add(jLabel3, new java.awt.GridBagConstraints());

        randomSizeText.setText("10");
        randomSizeText.setMinimumSize(new java.awt.Dimension(40, 22));
        randomSizeText.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel5.add(randomSizeText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel1.add(jPanel5, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        idLabel.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(idLabel, gridBagConstraints);

        colorValueLabel.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        colorValueLabel.setText("(0,0,0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(colorValueLabel, gridBagConstraints);

        colorPanel.setMinimumSize(new java.awt.Dimension(70, 25));
        colorPanel.setPreferredSize(new java.awt.Dimension(70, 25));
        colorPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(colorPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jPanel4, gridBagConstraints);

        jPanel7.setLayout(new java.awt.GridBagLayout());

        ringSizeField.setText("5");
        ringSizeField.setMinimumSize(new java.awt.Dimension(40, 22));
        ringSizeField.setName(""); // NOI18N
        ringSizeField.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 5, 5);
        jPanel7.add(ringSizeField, gridBagConstraints);

        jLabel4.setText("Promień:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel7.add(jLabel4, gridBagConstraints);

        amountRingsField.setText("5");
        amountRingsField.setMinimumSize(new java.awt.Dimension(40, 22));
        amountRingsField.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel7.add(amountRingsField, gridBagConstraints);

        jLabel5.setText("Ilość pkt:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 2, 5);
        jPanel7.add(jLabel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jPanel1.add(jPanel7, gridBagConstraints);

        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Promień:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel8.add(jLabel6, gridBagConstraints);

        radiusText.setText("10");
        radiusText.setMinimumSize(new java.awt.Dimension(40, 22));
        radiusText.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel8.add(radiusText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        jPanel1.add(jPanel8, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        if (t != null) {
            t.stop();
        }
        _r = Integer.parseInt(radiusText.getText());
        area = jComboBox1.getSelectedIndex();
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                sim();
            }
        });
        t.start();
    }//GEN-LAST:event_StartButtonActionPerformed

    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonActionPerformed
        if (t != null) {
            t.stop();
        }
    }//GEN-LAST:event_StopButtonActionPerformed

    private void RandomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RandomButtonActionPerformed
        clear();
        randomBoard();
    }//GEN-LAST:event_RandomButtonActionPerformed

    private void BCsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCsButtonActionPerformed
        perio = !perio;
    }//GEN-LAST:event_BCsButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        clear();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void randomComboPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_randomComboPopupMenuWillBecomeInvisible
        switch (randomCombo.getSelectedIndex()) {
            case 0:
                this.jPanel5.setVisible(false);
                this.jPanel6.setVisible(false);
                this.jPanel7.setVisible(false);
                break;
            case 2:
                this.jPanel5.setVisible(true);
                this.jPanel6.setVisible(false);
                this.jPanel7.setVisible(false);
                break;
            case 1:
                this.jPanel5.setVisible(false);
                this.jPanel6.setVisible(true);
                this.jPanel7.setVisible(false);
                break;
            case 3:
                this.jPanel5.setVisible(false);
                this.jPanel6.setVisible(false);
                this.jPanel7.setVisible(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_randomComboPopupMenuWillBecomeInvisible

    private void jComboBox1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox1PopupMenuWillBecomeInvisible
        switch (jComboBox1.getSelectedIndex()) {
            case 7:
                this.jPanel8.setVisible(true);
                break;
            default:
                this.jPanel8.setVisible(false);
                break;
        }
    }//GEN-LAST:event_jComboBox1PopupMenuWillBecomeInvisible

    private void recrystalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recrystalButtonActionPerformed
        if (t != null) {
            t.stop();
        }

        t = new Thread(new Runnable() {
            @Override
            public void run() {
                reSim();
            }
        });
        t.start();
    }//GEN-LAST:event_recrystalButtonActionPerformed

    private void sim() {
        simLoop = true;
        while (simLoop) {
            simLoop = false;
            calculate();
            canvas1.setB(false);
            canvas1.setGrains(boardGrain);
            canvas1.repaint();
            try {
                t.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Automat3DForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!simLoop) {
                canvas1.setB(true);
                b();
                t.stop();
            }
        }
    }

    private void reSim() {
        simLoop = true;
        while (simLoop) {
            dT += 0.001;
            simLoop = false;
            reCalculate();
            canvas1.setGrains(boardGrain);
            canvas1.repaint();

            try {
                t.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Automat3DForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!simLoop) {
                b();
                t.stop();
            }
        }
    }

    /**
     * Ustawianie granic ziaren
     */
    private void b() {
        for (int i = 1; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].getId() != boardGrain[i - 1][j].getId()) {
                    boardGrain[i][j].setB(true);
                }
            }
        }

        for (int i = 0; i < size_x; i++) {
            for (int j = 1; j < size_y; j++) {
                if (boardGrain[i][j].getId() != boardGrain[i][j - 1].getId()) {
                    boardGrain[i][j].setB(true);
                }
            }
        }

        canvas1.setGrains(boardGrain);
        canvas1.repaint();

    }

    private void randomBoard() {
        if (t != null) {
            t.stop();
        }
        Thread rT = new Thread(new Runnable() {
            @Override
            public void run() {
                switch (randomCombo.getSelectedIndex()) {
                    case 0:

                        for (int i = 0; i < size_x; i++) {
                            for (int j = 0; j < size_y; j++) {
                                if (rand.nextInt(1000) > 998) {
                                    n++;
//                                    board[i][j] = n;
                                    boardGrain[i][j].setId(n);
                                }
                            }
                        }

                        break;
                    case 1:

                        for (int i = Integer.parseInt(countXText.getText()); i < size_x; i += Integer.parseInt(countXText.getText())) {
                            for (int j = Integer.parseInt(countYText.getText()); j < size_y; j += Integer.parseInt(countYText.getText())) {
                                n++;
//                                board[i][j] = n;
                                boardGrain[i][j].setId(n);
                            }
                        }

                        break;
                    case 2:

                        for (int i = 0; i < Integer.parseInt(randomSizeText.getText()); i++) {
                            n++;
//                            board[rand.nextInt(size_x)][rand.nextInt(size_y)] = n;
                            boardGrain[rand.nextInt(size_x)][rand.nextInt(size_y)].setId(n);
                        }

                        break;
                    case 3:
                        int rings = Integer.parseInt(ringSizeField.getText());
                        int amount = Integer.parseInt(amountRingsField.getText());

                        ArrayList<BoardPoint> points = new ArrayList<>();

                        for (int i = 0; i < amount; i++) {
                            System.out.println("i: " + i);
                            int spr = 0;
                            int randX = rand.nextInt(size_x);
                            int randY = rand.nextInt(size_y);
                            boolean findOk = false;
                            while (spr < 100) {
                                spr++;
                                findOk = true;
                                System.out.println("wylosowano: " + randX + " : " + randY);
                                for (BoardPoint p : points) {
                                    findOk = true;
                                    System.out.println("sprawdzam: " + p.getX() + " : " + p.getY());
                                    if (!p.point2point(randX, randY, rings)) {
                                        findOk = false;
                                        System.out.println("ERROR");
                                        randX = rand.nextInt(size_x);
                                        randY = rand.nextInt(size_y);
                                        break;
                                    }
                                }
                                if (findOk) {
                                    n++;
                                    System.out.println("OK: " + randX + " : " + randY + " = " + n);
                                    points.add(new BoardPoint(randX, randY, 0, n));
                                    break;
                                }
                            }
                        }
                        System.out.println("znaleziono : " + points.size());
                        for (BoardPoint p : points) {
                            boardGrain[p.getX()][p.getY()].setId(p.getId());
                        }

                        break;
                    default:
                        break;
                }
            }
        });
        rT.start();
        canvas1.setGrains(boardGrain);
        canvas1.repaint();
    }

    private void calculate() {

        int tmp[][] = new int[3][3];

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
//                board_tmp[i][j] = board[i][j];
                board_tmp[i][j] = boardGrain[i][j].getId();
            }
        }

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].getId() == 0) {
                    simLoop = true;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            int l_x = (size_x + (i - 1 + k)) % size_x;
                            int l_y = (size_y + (j - 1 + l)) % size_y;
//                            tmp[k][l] = board[l_x][l_y];
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
                    int tmp_area = area;
                    boolean _rand = true;
                    while (_rand) {
                        switch (tmp_area) {
                            case 0: //moor
                                _rand = false;
                                break;
                            case 1: //neumann
                                tmp[0][0] = 0;
                                tmp[2][0] = 0;
                                tmp[0][2] = 0;
                                tmp[2][2] = 0;
                                _rand = false;
                                break;
                            case 2: //hex L
                                tmp[0][2] = 0;
                                tmp[2][0] = 0;
                                _rand = false;
                                break;
                            case 3: //hex P
                                tmp[0][0] = 0;
                                tmp[2][2] = 0;
                                _rand = false;
                                break;
                            case 4: //hex R
                                if (rand.nextBoolean()) {
                                    tmp[0][2] = 0;
                                    tmp[2][0] = 0;
                                } else {
                                    tmp[0][0] = 0;
                                    tmp[2][2] = 0;
                                }
                                _rand = false;
                                break;
                            case 5: //pen L
                                int r = rand.nextInt(4);
                                if (r == 0) {
                                    for (int k = 0; k < 3; k++) {
                                        tmp[0][k] = 0;
                                    }
                                } else if (r == 1) {
                                    for (int k = 0; k < 3; k++) {
                                        tmp[k][0] = 0;
                                    }
                                } else if (r == 2) {
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
                            case 6: //rand
                                tmp_area = rand.nextInt(5);
                                break;
                            case 7:

                                board_tmp[i][j] = randomArea(i, j, _r);

                                _rand = false;
                                break;
                            default:
                                _rand = false;
                                break;
                        }
                    }
                    if (tmp_area < 7) {
                        board_tmp[i][j] = area(tmp);
                    }
                }
            }
        }

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
//                board[i][j] = board_tmp[i][j];
                boardGrain[i][j].setId(board_tmp[i][j]);
            }
        }
    }

    private void reCalculate() {
        /*
         1 przestrzeń wypełniona ziarnami
         2 obliczenie gestosci dyslokacji (a/b + 1-...(t).) t<- krok czasowy 0.001 ,0.002 ...
         3 rozlosowanie odpowiedniczh paczek do pol
         4 ro se = ro z wszystkich / ilosc pixeli
         5 ro na granicach  ro wewnątrz       
         6 --- sprawdzamy czy ro w danej kom przekroczyło 
         mogo rekrystalizowac tylko te ne granicy (po rektyst ro = 0)
         jezeli sasiad zrekrystalizował w poprzednim kroku to tez rekrystalizuje
         */
        
        ro = reA / reB + (1 - (reA / reB)) * Math.exp(-1 * reB * dT);
        roSr = ro / (size_x * size_y);
        System.out.println("czas :"+dT+" : "+ro+" : "+roSr);
        simLoop = false;
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain[i][j].isB()) {
                    boardGrain[i][j].addRo(roSr * (1.2 + rand.nextDouble() * 0.6));
                    System.out.println("ro : "+boardGrain[i][j].getRo());
                    if (boardGrain[i][j].getRo() > roMax) {
                        System.out.println("max : ["+i+"]["+j+"] = "+boardGrain[i][j].getRo());
                        n++;
                        boardGrain[i][j].setId(n);
                        boardGrain[i][j].setB(false);
                        boardGrain[i][j].setR(true);
                        boardGrain[i][j].setRo(0);
                        simLoop = true;
                    }
                } else {
                    boardGrain[i][j].addRo(roSr * (rand.nextDouble() * 0.3));
                    simLoop = true;
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

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int l_x = (size_x + (i - 1 + k)) % size_x;
                        int l_y = (size_y + (j - 1 + l)) % size_y;
                        if (boardGrain[l_x][l_y].isR()) {
                            tmp[k][l] = boardGrain[l_x][l_y].getId();
                        } else {
                            tmp[k][l] = 0;
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
                simLoop = true;
                //----------------------------
                boardGrain_tmp[i][j].setId(area(tmp));
            }
        }

        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                if (boardGrain_tmp[i][j].getId() > 0) {
                    boardGrain[i][j].setId(boardGrain_tmp[i][j].getId());
                    boardGrain[i][j].setB(false);
                    boardGrain[i][j].setR(true);
                    boardGrain[i][j].setRo(0);
                    simLoop = true;
                }

            }
        }

    }

    public int randomArea(int _x, int _y, int _r) {
        int tmp[][];
        tmp = new int[2 * _r + 1][2 * _r + 1];

        for (int i = 0; i < 2 * _r + 1; i++) {
            for (int j = 0; j < 2 * _r + 1; j++) {
                float r_tmp = (float) (Math.sqrt(Math.pow(_r - i, 2) + Math.pow(_r - j, 2)));
                if (_r < r_tmp) {
                    tmp[i][j] = 0;
                } else {
                    int xl = (_x - _r + i) % size_x;
                    xl = xl < 0 ? size_x - 1 : xl;

                    int yl = (_y - _r + j) % size_y;
                    yl = yl < 0 ? size_y - 1 : yl;

                    if (perio) {
                        tmp[i][j] = boardGrain[xl][yl].getId();
                    } else {
                        if ((_x - _r + i) >= 0 && (_x - _r + i) < size_x && (_y - _r + j) >= 0 && (_y - _r + j) < size_y) {
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

        for (int i = 0; i < 2 * _r + 1; i++) {
            for (int j = 0; j < 2 * _r + 1; j++) {
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

    private void clear() {
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

        canvas1.setGrains(boardGrain);
        canvas1.paint(jPanel3.getGraphics());
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

    public class HandlerClass implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            mouseC(e.getX(), e.getY());
        }

        int xPres, yPres;

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mauseM(e.getX(), e.getY());
        }

    }

    private void mauseM(int i, int j) {

        int R = 0;
        int G = 0;
        int B = 0;
        int grain = boardGrain[i][j].getId();
        switch (grain % 3) {
            case 0:
                R = (grain * 10 + 100) % 254;
                G = (grain * 5 + 100) % 254;
                B = (grain * 2 + 100) % 254;
                break;
            case 1:
                R = (grain * 2 + 100) % 254;
                G = (grain * 10 + 100) % 254;
                B = (grain * 5 + 100) % 254;
                break;
            case 2:
                R = (grain * 5 + 100) % 254;
                G = (grain * 2 + 100) % 254;
                B = (grain * 10 + 100) % 254;
                break;
            default:
                break;
        }
//        idLabel.setText("" + board[i][j]);
        idLabel.setText("" + boardGrain[i][j].getId());
        colorValueLabel.setText("(" + R + "," + G + "," + B + ")");
        colorPanel.setBackground(new Color(R, G, B));
    }

    private void mouseC(int x, int y) {
        int xp = (int) Math.floor(x / (500 / size_x));
        int yp = (int) Math.floor(y / (300 / size_y));
        n++;
//        board[xp][yp] = n;
        boardGrain[xp][yp].setId(n);
//        canvas1.setTab(board);
        canvas1.setGrains(boardGrain);
        canvas1.repaint();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Automat3DForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Automat3DForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Automat3DForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Automat3DForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Automat3DForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BCsButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton RandomButton;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton StopButton;
    private javax.swing.JTextField amountRingsField;
    private automat3d.Canvas canvas1;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JLabel colorValueLabel;
    private javax.swing.JTextField countXText;
    private javax.swing.JTextField countYText;
    private javax.swing.JLabel idLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField radiusText;
    private javax.swing.JComboBox randomCombo;
    private javax.swing.JTextField randomSizeText;
    private javax.swing.JButton recrystalButton;
    private javax.swing.JTextField ringSizeField;
    // End of variables declaration//GEN-END:variables
}
