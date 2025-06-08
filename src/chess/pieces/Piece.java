package chess.pieces;

import chess.Board;

import javax.imageio.ImageIO;//이미지 파일을 읽거나 저장할 수 있게 해주는 유틸리티 클래스
import java.awt.*;
import java.awt.image.BufferedImage;//이미지를 메모리에 불러와서 처리할 수 있게 해주는 클래스
import java.io.IOException;

public abstract class Piece {
    public int col;
    public int row;
    public int xpos;
    public int ypos;

    protected boolean isWhite;
    protected String name;//말 이름
    protected int value;//체스말 점수

    protected final int titlesize = 80;

    protected static int Sheet_Scale;
    protected static BufferedImage Sheet;
    static {
        try {
            Sheet = ImageIO.read(Piece.class.getResourceAsStream("/piece.png"));
            Sheet_Scale = Sheet.getWidth() / 6;
        } catch (IOException e) { throw new RuntimeException(e); }
    }

    protected Image sprite;

    Board board;

    public Piece(Board board, int row, int col, boolean isWhite){
        this.board = board;
        this.col = col;
        this.row = row;
        this.isWhite = isWhite;
    }

    public Piece(Board board){
        this.board = board;
    }

    public void paint(Graphics2D g2d){
        g2d.drawImage(sprite, xpos, ypos, null);
    }
}
