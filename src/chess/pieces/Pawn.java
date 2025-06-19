package chess.pieces;

import chess.main.Board;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{

    public Pawn(Board board, int col, int row, boolean isWhite){
        super(board);
        this.col = col;
        this.row = row;
        this.xpos = col * board.titlesize;
        this.ypos = row * board.titlesize;

        this.isWhite = isWhite;
        this.name = "Pawn";

        this.sprite = Sheet.getSubimage(5 * Sheet_Scale, isWhite ? 0 : Sheet_Scale,
                Sheet_Scale, Sheet_Scale).getScaledInstance(board.titlesize, board.titlesize,
                BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col, int row){

        int colorIndex = isWhite ? 1 : -1;

        //push pawn 1
        if(this.col == col && row == this.row - colorIndex && board.getPiece(col, row) == null){
            return true;
        }
        //push pawn 2
        if(isFirstMove && this.col == col && row == this.row - colorIndex * 2 && board.getPiece(col, row) == null && board.getPiece(col, row + colorIndex) == null){
            return true;
        }
        //capture left
        if(col == this.col - 1 && row == this.row - colorIndex && board.getPiece(col, row) != null){
            return true;
        }
        //capture right
        if(col == this.col + 1 && row == this.row - colorIndex && board.getPiece(col, row) != null){
            return true;
        }

        //en passant left
        if(board.getTileNum(col, row) == board.enPassantTile && col == this.col - 1 && row == this.row - colorIndex && board.getPiece(col, row + colorIndex) != null){
            return true;
        }
        //en passant right
        if(board.getTileNum(col, row) == board.enPassantTile && col == this.col + 1 && row == this.row - colorIndex && board.getPiece(col, row + colorIndex) != null){
            return true;
        }

        return false;
    }

}
