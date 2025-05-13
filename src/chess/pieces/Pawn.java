package chess.pieces;

public class Pawn extends Piece{

    public Pawn(boolean isWhite, int col, int row, String name){
        super(isWhite);
        this.col = col;
        this.row = row;
        this.name = "Pawn";
    }

    @Override
    public boolean canMove() {

    }
}
