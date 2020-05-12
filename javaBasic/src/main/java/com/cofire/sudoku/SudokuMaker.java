package com.cofire.sudoku;/**
 * @author hardy
 * @date 2020/04/20
 **/

import java.util.Random;

/**
 * @Description
 * @ClassName SudokuMaker
 * @Author Ly
 * @date 2020.04.20 12:48
 */
public class SudokuMaker {
    int total = 0;
    private int[][] Arr;//临时数组
    private int[][] Sudoku;
    private int[][] Answer;//答案
    private int[][] Game;
    //深度优先搜索寻找
    //绝对有很多种解法，但是我们只需要第一个解出来的
    private boolean flag = false;//判断是否不再求解

    public SudokuMaker() {
        this.Arr = new int[9][9];
        this.Sudoku = new int[9][9];
        this.Answer = new int[9][9];
        rand();
        DFS(Arr, 0, false);
        diger();
        DevTools.showGame(Game);
        DevTools.showAnswer(Answer);
    }

    //判断该数字填写的地方是否符合数独规则
    public static boolean isTrue(int arr[][], int x, int y, int num) {//数字横坐标；数字纵坐标；数字数值
        //判断中单元格（3*3）
        for (int i = (y / 3) * 3; i < (y / 3 + 1) * 3; ++i) {
            for (int j = (x / 3) * 3; j < (x / 3 + 1) * 3; ++j) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }
        //判断横竖
        for (int i = 0; i < 9; ++i) {
            if ((arr[i][x] == num || arr[y][i] == num)) {
                return false;
            }
        }
        return true;
    }

    private void rand() {
        int t = 0;
        int x, y, num;
        //先往数组里面随机丢t个数
        while (t < 15) {//t不宜多，否则运行起来耗费时间；t也不宜少，否则生成的游戏看起来一点也不随机
            x = new Random().nextInt(9);
            y = new Random().nextInt(9);
            num = new Random().nextInt(9) + 1;
            if (Arr[y][x] == 0) {
                if (isTrue(Arr, x, y, num) == true) {
                    Arr[y][x] = num;
                    ++t;
                }
            }
        }
    }

    private void DFS(int arr[][], int n, boolean all) {//arr是数独数组，n是探索深度（一共81个格子，深度为81,n为0~80），是否要求全部解
        //n/9为格子的纵坐标，n%9为格子的横坐标
        if (n < 81) {
            //如果已经求出了一种解，终止递归就行了，不用继续求下去了
            if (flag == true && all == false) {
                return;
            }

            if (arr[n / 9][n % 9] == 0) {
                for (int i = 1; i < 10; ++i) {
                    if (isTrue(arr, n % 9, n / 9, i) == true) {
                        arr[n / 9][n % 9] = i;
                        DFS(arr, n + 1, all);
                        arr[n / 9][n % 9] = 0;
                    }
                }
            } else {
                DFS(arr, n + 1, all);
            }

        } else {
            if (all == false) {
                flag = true;
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; ++j) {
                        Sudoku[i][j] = arr[i][j];
                        Answer[i][j] = arr[i][j];
                    }
                }
            } else {
                for (int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; ++j) {
                        if (arr[i][j] != Answer[i][j]) {
                            Game[i][j] = Answer[i][j];
                            i = 10;
                            j = 10;
                            break;
                        }
                    }
                }
            }
        }
    }

    //给数独挖空
    //保证仅有一解
    private void diger() {
        int t = 55;
        Game = new int[9][9];
        while (t > 0) {
            int x = new Random().nextInt(9);
            int y = new Random().nextInt(9);
            if (Sudoku[y][x] != 0) {
                Sudoku[y][x] = 0;
                --t;
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                Game[i][j] = Sudoku[i][j];
            }
        }

        DFS(Sudoku, 0, true);
    }

    //获取最终数独
    public int[][] getArr() {
        return this.Game;
    }

    //获取数独答案
    public int[][] getAnswer() {
        return this.Answer;
    }
}

//开发工具包
class DevTools {

    public static void showAnswer(int arr[][]) {
        System.out.println("\n答案：");
        for (int i[] : arr) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showGame(int arr[][]) {
        System.out.println("\n题目：");
        int total = 0;
        for (int i[] : arr) {
            for (int j : i) {
                System.out.print(j);
                if (j == 0) {
                    ++total;
                }
            }
            System.out.println();
        }
        System.out.println("挖空数：" + total);
    }
}
