package chess.main;

import javax.swing.*;
import java.awt.*;

public class ChessApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Board board;
    private MainMenuPanel mainMenuPanel;
    private PlayerSetupPanel playerSetupPanel;
    private String player1Name = "Player 1";
    private String player2Name = "Player 2";

    public ChessApp() {
        setTitle("Chess Master");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // CardLayout 설정
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // 패널들 초기화
        mainMenuPanel = new MainMenuPanel();
        playerSetupPanel = new PlayerSetupPanel();
        board = new Board();

        // 게임 보드를 포함하는 패널 생성
        JPanel gamePanel = createGamePanel();

        // CardLayout에 패널들 추가
        mainPanel.add(mainMenuPanel, "MENU");
        mainPanel.add(playerSetupPanel, "SETUP");
        mainPanel.add(gamePanel, "GAME");

        // 이벤트 리스너 설정
        setupListeners();

        // 프레임 설정
        add(mainPanel);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // 메인 메뉴 표시
        cardLayout.show(mainPanel, "MENU");
    }

    private JPanel createGamePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // 상단 정보 패널
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(50, 50, 50));
        topPanel.setPreferredSize(new Dimension(800, 60));
        topPanel.setLayout(new BorderLayout());

        // 플레이어 정보
        JLabel player1Label = new JLabel(" " + player1Name + " (White)");
        player1Label.setForeground(Color.WHITE);
        player1Label.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel player2Label = new JLabel(player2Name + " (Black) ");
        player2Label.setForeground(Color.WHITE);
        player2Label.setFont(new Font("Arial", Font.BOLD, 16));

        // 중앙 버튼들
        JPanel centerButtons = new JPanel();
        centerButtons.setOpaque(false);

        JButton newGameBtn = createGameButton("New Game");
        JButton menuBtn = createGameButton("Menu");

        newGameBtn.addActionListener(e -> {
            board.startNewGame(true);
        });

        menuBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "MENU");
        });

        centerButtons.add(newGameBtn);
        centerButtons.add(menuBtn);

        topPanel.add(player1Label, BorderLayout.WEST);
        topPanel.add(centerButtons, BorderLayout.CENTER);
        topPanel.add(player2Label, BorderLayout.EAST);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(board, BorderLayout.CENTER);

        return panel;
    }

    private JButton createGameButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100, 30));
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(80, 80, 80));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(100, 100, 100));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(80, 80, 80));
            }
        });

        return button;
    }

    private void setupListeners() {
        // 메인 메뉴 리스너
        mainMenuPanel.addLocalButtonListener(e -> {
            cardLayout.show(mainPanel, "SETUP");
        });

        mainMenuPanel.addMultiButtonListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Multiplayer mode is not implemented yet!",
                    "Coming Soon",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        mainMenuPanel.addExitButtonListener(e -> {
            System.exit(0);
        });

        // 플레이어 설정 리스너
        playerSetupPanel.addStartButtonListener(e -> {
            player1Name = playerSetupPanel.getPlayer1Name();
            player2Name = playerSetupPanel.getPlayer2Name();

            // 게임 패널 업데이트
            remove(mainPanel);
            mainPanel.remove(2); // 기존 게임 패널 제거
            mainPanel.add(createGamePanel(), "GAME", 2);
            add(mainPanel);

            board.startNewGame(true);
            cardLayout.show(mainPanel, "GAME");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessApp::new);
    }
}