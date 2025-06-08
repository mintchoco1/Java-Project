package chess.pieces;

import chess.Board;

import java.awt.image.BufferedImage;

public class Rook extends Piece{

    public Rook(Board board, int col, int row, boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.xpos = col * board.titlesize;
        this.ypos = row * board.titlesize;

        this.isWhite = isWhite;
        this.name = "Rook";

        this.sprite = Sheet.getSubimage(3 * Sheet_Scale, isWhite ? 0 : Sheet_Scale,
                Sheet_Scale, Sheet_Scale).getScaledInstance(board.titlesize, board.titlesize,
                BufferedImage.SCALE_SMOOTH);
    }
}
