package chess.pieces;

import chess.Board;

public class Pawn extends Piece{

    public Pawn(Board board, int col, int row, boolean isWhite){
        super(board);
        this.isWhite = isWhite;
        this.col = col;
        this.row = row;
        this.name = "Pawn";
    }

    //규칙
}
