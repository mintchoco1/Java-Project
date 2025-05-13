package chess;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel {
    final int titlesize = 85;
    final int rows = 8;
    final int cols = 8;

    public ChessBoard() {
        //GUI의 패널 크기 설정
        this.setPreferredSize(new Dimension(cols * titlesize, rows * titlesize));
        this.setBackground(Color.green);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);//이전 그려진 배경이 남을 수 있음
        Graphics2D g2d = (Graphics2D) g;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                g2d.setColor((c + r) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
                g2d.fillRect(c * titlesize, r * titlesize, titlesize, titlesize);
            }
        }
    }
}
