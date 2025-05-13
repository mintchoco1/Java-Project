package chess.pieces;

import chess.ChessBoard;

import javax.imageio.ImageIO;//이미지 파일을 읽거나 저장할 수 있게 해주는 유틸리티 클래스
import java.awt.*;
import java.awt.image.BufferedImage;//이미지를 메모리에 불러와서 처리할 수 있게 해주는 클래스
import java.io.File;//이미지 파일을 읽다가 오류가 날 수 있기 때문에 try-catch에서 예외 처리할 때 필요
import java.io.IOException;

public class Piece {
    public int col;
    public int row;

    public boolean isWhite;
    public String name;
    public int value;

    //jbutton 에 글자가 아니라 말 그림 아이콘을 넣고 싶을 때
    BufferedImage sheet;
    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("Chess_Pieces_Sprite.syg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Image sprite;

    ChessBoard board;

    public Piece(ChessBoard board){
        this.board = board;
    }
}
