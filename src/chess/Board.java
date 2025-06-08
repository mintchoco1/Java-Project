package chess;

import chess.pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    public int titlesize = 80;
    final int rows = 8;
    final int cols = 8;

    ArrayList<Piece> PieceList = new ArrayList<>();

    public Board() {
        this.setPreferredSize(new Dimension(cols * titlesize, rows * titlesize));//내가 원하는 사이즈로 설정
        addPiece();
    }

    public void addPiece(){
        PieceList.add(new Rook(this, 0, 0, false));
        PieceList.add(new Knight(this, 1, 0, false));
        PieceList.add(new Bishop(this, 2, 0, false));
        PieceList.add(new Queen(this, 3, 0, false));
        PieceList.add(new King(this, 4, 0, false));
        PieceList.add(new Bishop(this, 5, 0, false));
        PieceList.add(new Knight(this, 6, 0, false));
        PieceList.add(new Rook(this, 7, 0, false));

        PieceList.add(new Pawn(this, 0, 1, false));
        PieceList.add(new Pawn(this, 1, 1, false));
        PieceList.add(new Pawn(this, 2, 1, false));
        PieceList.add(new Pawn(this, 3, 1, false));
        PieceList.add(new Pawn(this, 4, 1, false));
        PieceList.add(new Pawn(this, 5, 1, false));
        PieceList.add(new Pawn(this, 6, 1, false));
        PieceList.add(new Pawn(this, 7, 1, false));
    }

    //paintComponent 메소드는 jpanel 등에서 화면을 그릴 때 자동으로 호출
    //Graphics g 는 그림을 그릴 도구이고 2d 그래픽ㅣ능을 사용하려고 캐스팅함
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//이전 그려진 배경이 남을 수 있음. 없으면 잔상이 남을 수 있음
        Graphics2D g2d = (Graphics2D) g;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                g2d.setColor((c + r) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
                g2d.fillRect(c * titlesize, r * titlesize, titlesize, titlesize);
            }
        }

        for (Piece piece : PieceList) {
            piece.paint(g2d);
        }
    }
}
