package automat3d;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Automat3DForm extends javax.swing.JFrame {

    static final int size_x = 500;
    static final int size_y = 300;
    double dT = 0;
    HandlerClass handler = new HandlerClass();
    Thread t;
    Grain boardGrain[][];
    boolean simLoop;
    private Board board;
    private boolean mC;
    private MonteCarlo monteCarlo;

    public Automat3DForm() {
        monteCarlo = new MonteCarlo();
        mC = false;
        board = new Board(size_x, size_y);
        boardGrain = new Grain[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();
            }
        }
        initComponents();
        this.jPanel5.setVisible(false);
        this.jPanel6.setVisible(false);
        this.jPanel7.setVisible(false);
        this.jPanel8.setVisible(false);
        this.jProgressBar1.setValue(0);
        jLabel9.setText("" + board.getCountGrainsCristal());
        canvas1.addMouseListener(handler);
        canvas1.addMouseMotionListener(handler);
        jLabel11.setText(jSlider1.getValue() + " %");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        StartButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();
        RandomButton = new javax.swing.JButton();
        BCsButton = new javax.swing.JToggleButton();
        ClearButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        randomCombo = new javax.swing.JComboBox();
        recrystalButton = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
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

        jPanel9.setLayout(new java.awt.GridBagLayout());

        jProgressBar1.setForeground(new java.awt.Color(102, 204, 255));
        jProgressBar1.setValue(50);
        jProgressBar1.setStringPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 5);
        jPanel9.add(jProgressBar1, gridBagConstraints);

        jLabel7.setText("Postęp:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Ilość ziaren");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 2);
        jPanel9.add(jLabel8, gridBagConstraints);

        jLabel9.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel9, gridBagConstraints);

        jLabel10.setText("Rekrystalizje: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel10, gridBagConstraints);

        jLabel11.setText("0 %");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel11, gridBagConstraints);

        jSlider1.setMinimumSize(new java.awt.Dimension(100, 16));
        jSlider1.setPreferredSize(new java.awt.Dimension(100, 16));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        jPanel9.add(jSlider1, gridBagConstraints);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSeparator2.setMinimumSize(new java.awt.Dimension(1, 20));
        jSeparator2.setPreferredSize(new java.awt.Dimension(1, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel9.add(jSeparator2, gridBagConstraints);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSeparator1.setMinimumSize(new java.awt.Dimension(1, 20));
        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel9.add(jSeparator1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(jPanel9, gridBagConstraints);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(StartButton, gridBagConstraints);

        StopButton.setText("Stop");
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(StopButton, gridBagConstraints);

        RandomButton.setText("Generuj");
        RandomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RandomButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        jPanel2.add(RandomButton, gridBagConstraints);

        BCsButton.setText("P");
        BCsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
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
        gridBagConstraints.gridx = 6;
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
        gridBagConstraints.gridx = 3;
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
        gridBagConstraints.gridx = 4;
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
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        jPanel2.add(recrystalButton, gridBagConstraints);

        jToggleButton1.setText("B");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jToggleButton1, gridBagConstraints);

        jToggleButton2.setText("R");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jToggleButton2, gridBagConstraints);

        jToggleButton3.setText("MC");
        jToggleButton3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButton3StateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jToggleButton3, gridBagConstraints);

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
        boardGrain = board.clear();
        boardGrain = board.randomBoard(randomCombo.getSelectedIndex(),
                Integer.parseInt(countXText.getText()),
                Integer.parseInt(countYText.getText()),
                Integer.parseInt(randomSizeText.getText()),
                Integer.parseInt(ringSizeField.getText()),
                Integer.parseInt(amountRingsField.getText()));
        canvas1.setGrains(boardGrain);
        canvas1.repaint();
        jLabel9.setText("" + board.getCountGrainsCristal());
    }//GEN-LAST:event_RandomButtonActionPerformed

    private void BCsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCsButtonActionPerformed
        board.changePeriodic();
    }//GEN-LAST:event_BCsButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        boardGrain = board.clear();
        canvas1.setGrains(boardGrain);
        canvas1.repaint();
        jLabel9.setText("" + board.getCountGrainsCristal());
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

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        jLabel11.setText(jSlider1.getValue() + " %");
        board.setRecrystalPercent(jSlider1.getValue());
    }//GEN-LAST:event_jSlider1StateChanged

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        canvas1.changeShowEdge();
        canvas1.repaint();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        board.changeContentGrains();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButton3StateChanged
        mC =!mC;
    }//GEN-LAST:event_jToggleButton3StateChanged

    private void sim() {

        if (mC) {
            boardGrain = monteCarlo.randomBoard();
            canvas1.setGrains(boardGrain);
            canvas1.repaint();
        } else {
            this.jProgressBar1.setValue(0);
            simLoop = true;
            double progress = 0;
            jProgressBar1.setForeground(Color.red);
            while (simLoop) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Automat3DForm.class.getName()).log(Level.SEVERE, null, ex);
                }
// -----------------------------------------------------------------------  
// -----------------------Na jednym wątku ----------------------------------
//            boardGrain = board.calculate(jComboBox1.getSelectedIndex(),
//                    Integer.parseInt(radiusText.getText()));
// -----------------------------------------------------------------------
// -----------------------------------------------------------------------  
// -----------------------Na wielu wątkach ----------------------------------
                boardGrain = board.THcalculate(jComboBox1.getSelectedIndex(),
                        Integer.parseInt(radiusText.getText()));
// -----------------------------------------------------------------------
                progress = (double) board.crystal() / (size_x * size_y) * 100;

                jProgressBar1.setValue((int) Math.round(progress));
                simLoop = board.crystal() != (size_x * size_y);
//            canvas1.setB(false);
                canvas1.setGrains(boardGrain);
                canvas1.repaint();

                if (!simLoop) {
//                canvas1.setB(true);
                    boardGrain = board.edge();
                    jLabel9.setText("" + board.getCountGrainsCristal());
                    jProgressBar1.setForeground(Color.green);
                    t.stop();
                }
            }
            jProgressBar1.setForeground(Color.green);
        }

    }

    private void reSim() {
        this.jProgressBar1.setValue(0);
        simLoop = true;
        double progress = 0;
        jProgressBar1.setForeground(Color.red);
        while (simLoop) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Automat3DForm.class.getName()).log(Level.SEVERE, null, ex);
            }

            dT += 0.001;
            boardGrain = board.reCalculate(jComboBox1.getSelectedIndex(), dT);
            progress = (double) board.recrystal() / (size_x * size_y) * 100;
            jProgressBar1.setValue((int) Math.round(progress));
            simLoop = board.recrystal() != (size_x * size_y);
            canvas1.setGrains(boardGrain);
            canvas1.repaint();
            jLabel9.setText("" + board.getCountGrainsRecristal());
            if (!simLoop) {

//                canvas1.setB(true);
                boardGrain = board.edge();
                board.clearRecrystal();
                jProgressBar1.setForeground(Color.green);
                t.stop();
            }
        }

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
        idLabel.setText("" + boardGrain[i][j].getId());
        colorValueLabel.setText("(" + R + "," + G + "," + B + ")");
        colorPanel.setBackground(new Color(R, G, B));
    }

    private void mouseC(int x, int y) {
        int xp = (int) Math.floor(x / (500 / size_x));
        int yp = (int) Math.floor(y / (300 / size_y));
        boardGrain = board.addGrain(xp, yp);
        canvas1.setGrains(boardGrain);
        canvas1.repaint();
        jLabel9.setText("" + board.getCountGrainsCristal());
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
            java.util.logging.Logger.getLogger(Automat3DForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Automat3DForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Automat3DForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Automat3DForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JTextField radiusText;
    private javax.swing.JComboBox randomCombo;
    private javax.swing.JTextField randomSizeText;
    private javax.swing.JButton recrystalButton;
    private javax.swing.JTextField ringSizeField;
    // End of variables declaration//GEN-END:variables
}
