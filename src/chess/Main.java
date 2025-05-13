package chess;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(680, 680);
        frame.setLocationRelativeTo(null);//가운데 배치

        ChessBoard board = new ChessBoard();
        frame.add(board);



        frame.setVisible(true);
    }
}
