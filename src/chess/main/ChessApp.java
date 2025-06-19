package chess.main;

import javax.swing.*;
import java.awt.*;

public class ChessApp extends JFrame {
    private final Board board = new Board();

    public ChessApp() {
        setTitle("Java Chess");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        /* ── 상단 컨트롤 패널 ── */
        JPanel ui = new JPanel();

        JButton btnPlay   = new JButton("Play / Restart");
        JRadioButton rbW  = new JRadioButton("White first", true);
        JRadioButton rbB  = new JRadioButton("Black first");
        ButtonGroup  g    = new ButtonGroup();
        g.add(rbW); g.add(rbB);

        ui.add(btnPlay);
        ui.add(rbW);
        ui.add(rbB);

        // 버튼 누르면 새 게임
        btnPlay.addActionListener(e -> board.startNewGame(rbW.isSelected()));

        add(ui,    BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);

        pack();                 // Board가 원하는 크기로 맞춤
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
