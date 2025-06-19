package chess.main;

import chess.pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    public int titlesize = 80;
    final int rows = 8;
    final int cols = 8;

    ArrayList<Piece> PieceList = new ArrayList<>();

    Mouse mouse = new Mouse(this);

    public Piece selectedPiece;

    public CheckScanner checkScanner = new CheckScanner(this);

    public int enPassantTile = -1;

    public Board() {
        this.setPreferredSize(new Dimension(cols * titlesize, rows * titlesize));//내가 원하는 사이즈로 설정

        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);

        addPiece();
    }

    public Piece getPiece(int col, int row) {

        for (Piece piece : PieceList) {
            if (piece.col == col && piece.row == row){
                return piece;
            }
        }

        return null;
    }

    public void makeMove(Move move) {
        if(move.piece.name.equals("Pawn")){
            movePawn(move);
        }else if(move.piece.name.equals("King")) {
            moveKing(move);
        }
            move.piece.col = move.newCol;
            move.piece.row = move.newRow;
            move.piece.xpos = move.newCol * titlesize;
            move.piece.ypos = move.newRow * titlesize;

            move.piece.isFirstMove = false;

            capture(move.capture);

    }

    private void moveKing(Move move) {
        if (Math.abs(move.piece.col - move.newCol) == 2) {
            Piece rook;
            if (move.piece.col < move.newCol) {
                rook = getPiece(7, move.piece.row);
                rook.col = 5;
            } else {
                rook = getPiece(0, move.piece.row);
                rook.col = 3;
            }
            rook.xpos = rook.col * titlesize;
        }
    }

    private void movePawn(Move move) {
        //en passant
        int colorIndex = move.piece.isWhite ? 1 : -1;

        if(getTileNum(move.newCol, move.newRow) == enPassantTile){
            move.capture = getPiece(move.newCol, move.newRow + colorIndex);
        }
        if(Math.abs(move.piece.row - move.newRow) == 2){
            enPassantTile = getTileNum(move.newCol, move.newRow + colorIndex);
        }else {
            enPassantTile = -1;
        }

        //promotions
        colorIndex = move.piece.isWhite ? 0 : 7;
        if(move.newRow == colorIndex){
            promotePawn(move);
        }

    }

    private void promotePawn(Move move) {
        PieceList.add(new Queen(this, move.newCol, move.newRow, move.piece.isWhite));
        capture(move.piece);
    }

    public void capture(Piece piece) {
        PieceList.remove(piece);
    }

    public boolean isValidMove(Move move) {

        if(sameteam(move.piece, move.capture)) {
            return false;
        }
        if(!move.piece.isValidMovement(move.newCol, move.newRow)) {
            return false;
        }
        if(move.piece.moveCollideswithPiece(move.newCol, move.newRow)) {
            return false;
        }
        if(checkScanner.isKingChecked(move)){
            return false;
        }
        return true;
    }

    public boolean sameteam(Piece p1, Piece p2) {
        if((p1 == null || p2 == null)){
            return false;
        }
        return p1.isWhite == p2.isWhite;
    }

    public int getTileNum(int col, int row){
        return row * rows + col;
    }


    public Piece findKing(boolean isWhite) {
        for(Piece piece : PieceList) {
            if(isWhite == piece.isWhite && piece.name.equals("King")){
                return piece;
            }
        }
        return null;
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

        PieceList.add(new Rook(this, 0, 7, true));
        PieceList.add(new Knight(this, 1, 7, true));
        PieceList.add(new Bishop(this, 2, 7, true));
        PieceList.add(new Queen(this, 3, 7, true));
        PieceList.add(new King(this, 4, 7, true));
        PieceList.add(new Bishop(this, 5, 7, true));
        PieceList.add(new Knight(this, 6, 7, true));
        PieceList.add(new Rook(this, 7, 7, true));

        PieceList.add(new Pawn(this, 0, 6, true));
        PieceList.add(new Pawn(this, 1, 6, true));
        PieceList.add(new Pawn(this, 2, 6, true));
        PieceList.add(new Pawn(this, 3, 6, true));
        PieceList.add(new Pawn(this, 4, 6, true));
        PieceList.add(new Pawn(this, 5, 6, true));
        PieceList.add(new Pawn(this, 6, 6, true));
        PieceList.add(new Pawn(this, 7, 6, true));
    }

    //paintComponent 메소드는 jpanel 등에서 화면을 그릴 때 자동으로 호출
    //Graphics g 는 그림을 그릴 도구이고 2d 그래픽ㅣ능을 사용하려고 캐스팅함
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//이전 그려진 배경이 남을 수 있음. 없으면 잔상이 남을 수 있음
        Graphics2D g2d = (Graphics2D) g;

        //보드 색
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                g2d.setColor((c + r) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
                g2d.fillRect(c * titlesize, r * titlesize, titlesize, titlesize);
            }
        }

        //기물 거리 하이라이트
        if(selectedPiece!= null) {
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (isValidMove(new Move(this, selectedPiece, c, r))) {
                        g2d.setColor(new Color(68, 180, 57, 190));
                        g2d.fillRect(c * titlesize, r * titlesize, titlesize, titlesize);
                    }
                }
            }
        }

        for (Piece piece : PieceList) {
            piece.paint(g2d);
        }
    }
}
