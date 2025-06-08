package chess.move;

import chess.Board;
import chess.pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Event extends MouseAdapter {

    Board board;

    public Event(Board board) {
        this.board = board;
    }

    //기물 선택. 마우스 버튼을 누르는 순간 호출
    @Override
    public void mousePressed(MouseEvent e) {
        //마우스 좌표 -> 체스판 좌표로 변경
        //체스판의 한 칸 크기로 나누어 칸 인덱스로 변환
        int col = e.getX() / board.titlesize;
        int row = e.getY() / board.titlesize;

        Piece piecexy = board.getPiece(col, row);

        //선택한 말이 있다면, 원래 좌표 기억
        if(piecexy != null) {
            board.seletedPiece = piecexy;
        }
    }

    //기물 놓고 마우스를 뗀 위치가 말을 이동시킬지 결정
    //해당 위치가 유요한 이동이라면 board에 반영하여 말을 이동
    @Override
    public void mouseReleased(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }
}
