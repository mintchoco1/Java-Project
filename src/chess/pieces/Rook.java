package chess.pieces;

import chess.main.Board;

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

        this.sprite = Sheet.getSubimage(4 * Sheet_Scale, isWhite ? 0 : Sheet_Scale,
                Sheet_Scale, Sheet_Scale).getScaledInstance(board.titlesize, board.titlesize,
                BufferedImage.SCALE_SMOOTH);
    }

    public boolean isValidMovement(int col, int row){
        return this.col == col || this.row == row;
    }

    public boolean moveCollidesWithPiece(int col, int row){

        //left
        if(this.col > col){
            for(int c = this.col - 1; c > col; c--){
                if(board.getPiece(c, this.row) != null){
                    return true;
                }
            }
        }

        //right
        if(this.col < col){
            for(int c = this.col + 1; c < col; c++){
                if(board.getPiece(c, this.row) != null){
                    return true;
                }
            }
        }

        //up
        if(this.row > row){
            for(int r = this.row - 1; r > col; r--){
                if(board.getPiece(this.col, r) != null){
                    return true;
                }
            }
        }

        //down
        if(this.row < row){
            for(int r = this.row + 1; r < row; r++){
                if(board.getPiece(this.col, r) != null){
                    return true;
                }
            }
        }
        return false;
    }
}
