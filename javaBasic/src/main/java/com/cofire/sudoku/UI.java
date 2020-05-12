package com.cofire.sudoku;/**
 * @author hardy
 * @date 2020/04/20
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Description
 * @ClassName SudokuUI
 * @Author Ly
 * @date 2020.04.20 12:51
 */
public class UI {
    private JFrame gameUI;
    private JLabel gameGrid;//数独81宫格
    private SudokuMaker game;//数独
    private JLabel[][] smallGrid;//数独小格子
    private UserEvents[][] mouseListen;//监听器


    public UI() {
        gameUI = new JFrame();

        gameUI.setVisible(true);
        gameUI.setLayout(null);
        gameUI.setSize(600, 430);
        gameUI.setResizable(false);//不允许窗口最大化
        gameUI.setLocationRelativeTo(null);

        JButton bt1 = new JButton("生成新数独");
        gameUI.add(bt1);
        bt1.setBounds(400, 10, 100, 20);
        bt1.addActionListener(new OtherGameEvent());

        JButton bt2 = new JButton("显示答案");
        gameUI.add(bt2);
        bt2.setBounds(400, 110, 100, 20);
        bt2.addActionListener(new ShowAnswer());


        gameGrid = new JLabel();
        gameGrid.setBounds(10, 10, 365, 365);
        gameUI.add(gameGrid);
//        java.net.URL imgURL = Main.class.getResource("/img/Grid.jpg");
//        gameGrid.setIcon(new ImageIcon(imgURL));
        gameGrid.setOpaque(true);

        Font font = new Font("宋体", Font.BOLD, 25);

        smallGrid = new JLabel[9][9];
        mouseListen = new UserEvents[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                smallGrid[i][j] = new JLabel("", JLabel.CENTER);
                gameGrid.add(smallGrid[i][j]);
                mouseListen[i][j] = new UserEvents(smallGrid[i][j], i, j, false);
                smallGrid[i][j].setFont(font);
                smallGrid[i][j].setBounds(j * 40 + 1, i * 40 + 1, 40, 40);
                smallGrid[i][j].addMouseListener(mouseListen[i][j]);
            }
        }
        newGame();
    }

    //新游戏
    private void newGame() {

        game = new SudokuMaker();
        int[][] gameArr = game.getArr();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (gameArr[i][j] != 0) {
                    smallGrid[i][j].setText(gameArr[i][j] + "");
                    mouseListen[i][j].setUse(false);
                    smallGrid[i][j].setForeground(Color.black);
                } else {
                    smallGrid[i][j].setText(null);
                    mouseListen[i][j].setUse(true);
                }
            }
        }
    }

    private class ShowAnswer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (mouseListen[i][j].getUse() == true) {
                        smallGrid[i][j].setText(game.getAnswer()[i][j] + "");
                        smallGrid[i][j].setForeground(Color.BLUE);
                        mouseListen[i][j].setUse(false);
                    }
                }
            }
        }

    }

    private class OtherGameEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            newGame();
        }
    }

    private class UserEvents implements MouseListener {

        private JTextArea jta;
        private JLabel focus;//聚焦
        private int gridX;
        private int gridY;
        private boolean isUse;//是否开启事件


        public UserEvents(JLabel f, int y, int x, boolean u) {
            focus = f;
            gridX = x;
            gridY = y;
            isUse = u;

            jta = new JTextArea();
            jta.setBounds(5, 5, 30, 30);
            jta.setVisible(false);
            jta.setOpaque(false);
            jta.setFont(new Font("宋体", Font.BOLD, 25));
            focus.add(jta);
        }

        @Override
        public void mouseClicked(MouseEvent arg0) {
            // TODO Auto-generated method stub
            if (isUse == true) {

                focus.setBorder(BorderFactory.createLineBorder(Color.red, 5));
                jta.setVisible(true);
                focus.setText(null);
            }
        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub
            int X = arg0.getX(), Y = arg0.getY();
            if (isUse == true) {
                if (X <= 0 || X >= 40 || Y <= 0 || Y >= 40) {
                    focus.setBorder(BorderFactory.createLineBorder(Color.red, 0));
                    try {
                        int t = new Integer(jta.getText());
                        if (t > 0 && t < 10) {
                            game.getArr()[gridY][gridX] = 0;
                            if (SudokuMaker.isTrue(game.getArr(), gridX, gridY, t) == true) {
                                focus.setForeground(Color.green);
                            } else {
                                focus.setForeground(Color.red);
                            }
                            game.getArr()[gridY][gridX] = t;
                        }
                        focus.setText(jta.getText());
                    } catch (Exception e) {
                        jta.setText(null);
                    }
                    jta.setVisible(false);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub
            if (this.isUse == true) {
                focus.setBorder(BorderFactory.createLineBorder(Color.red, 5));
            }
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub
        }

        public boolean getUse() {
            return isUse;
        }

        public void setUse(boolean u) {
            this.isUse = u;
            if (u == true) {
                jta.setText(null);
            } else {
                focus.setBorder(BorderFactory.createLineBorder(Color.red, 0));
            }
        }

    }
}
