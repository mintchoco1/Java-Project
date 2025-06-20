package chess.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlayerSetupPanel extends JPanel {
    private JTextField player1Field;
    private JTextField player2Field;
    private JButton startButton;

    public PlayerSetupPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));

        // 중앙 패널
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new GridBagLayout());

        // 체스보드 미리보기 (작은 크기)
        JPanel boardPreview = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int size = 30;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        g.setColor((i + j) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
                        g.fillRect(j * size, i * size, size, size);
                    }
                }
            }
        };
        boardPreview.setPreferredSize(new Dimension(240, 240));

        // 플레이어 입력 패널
        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        // Player 1
        JPanel player1Panel = createPlayerInputPanel("Player 1", Color.WHITE);
        player1Field = new JTextField("Player 1", 15);
        player1Field.setFont(new Font("Arial", Font.PLAIN, 16));
        player1Panel.add(player1Field);

        // Player 2
        JPanel player2Panel = createPlayerInputPanel("Player 2", Color.BLACK);
        player2Field = new JTextField("Player 2", 15);
        player2Field.setFont(new Font("Arial", Font.PLAIN, 16));
        player2Panel.add(player2Field);

        inputPanel.add(player1Panel);
        inputPanel.add(Box.createVerticalStrut(20));
        inputPanel.add(player2Panel);
        inputPanel.add(Box.createVerticalStrut(40));

        // Start 버튼
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(150, 50));
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(new Color(70, 140, 70));
        startButton.setFocusPainted(false);
        startButton.setBorderPainted(false);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // 호버 효과
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButton.setBackground(new Color(90, 160, 90));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButton.setBackground(new Color(70, 140, 70));
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(startButton);

        inputPanel.add(buttonPanel);

        // GridBagLayout 설정
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 20, 0, 40);
        centerPanel.add(boardPreview, gbc);

        gbc.gridx = 1;
        centerPanel.add(inputPanel, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }

    private JPanel createPlayerInputPanel(String label, Color pieceColor) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel playerLabel = new JLabel(label);
        playerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        playerLabel.setPreferredSize(new Dimension(100, 30));

        panel.add(playerLabel);

        return panel;
    }

    public String getPlayer1Name() {
        return player1Field.getText().trim().isEmpty() ? "Player 1" : player1Field.getText().trim();
    }

    public String getPlayer2Name() {
        return player2Field.getText().trim().isEmpty() ? "Player 2" : player2Field.getText().trim();
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }
}