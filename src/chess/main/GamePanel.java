package chess.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class GamePanel extends JPanel {
    private Board board;
    private BufferedImage backgroundImage;
    private JPanel topPanel;
    private String player1Name;
    private String player2Name;

    public GamePanel(Board board, String player1Name, String player2Name) {
        this.board = board;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        setLayout(null); // 절대 위치 사용

        // 배경 이미지 로드 - 여러 경로 시도
        try {
            // 첫 번째 시도: res 폴더
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/background.png"));
        } catch (Exception e) {
            try {
                // 두 번째 시도: resources 폴더
                backgroundImage = ImageIO.read(getClass().getResourceAsStream("/resources/background.png"));
            } catch (Exception ex) {
                try {
                    // 세 번째 시도: images 폴더
                    backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/background.png"));
                } catch (Exception exc) {
                    try {
                        // 네 번째 시도: jpg 확장자
                        backgroundImage = ImageIO.read(getClass().getResourceAsStream("/background.jpg"));
                    } catch (Exception excx) {
                        System.out.println("배경 이미지를 찾을 수 없습니다: background.png 또는 background.jpg");
                        System.out.println("파일을 다음 위치에 배치하세요:");
                        System.out.println("- src/main/resources/background.png");
                        System.out.println("- 또는 프로젝트의 res 폴더에 background.png");
                    }
                }
            }
        }

        // Board를 투명하게 설정하고 전체 크기로
        board.setOpaque(false);
        board.setBounds(0, 0, 600, 600);
        add(board);

        // 상단 정보 패널을 오버레이로
        createTopPanel();
    }

    private void createTopPanel() {
        topPanel = new JPanel();
        topPanel.setBackground(new Color(50, 50, 50, 200)); // 반투명
        topPanel.setBounds(0, 0, 800, 60);
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

        centerButtons.add(newGameBtn);
        centerButtons.add(menuBtn);

        topPanel.add(player1Label, BorderLayout.WEST);
        topPanel.add(centerButtons, BorderLayout.CENTER);
        topPanel.add(player2Label, BorderLayout.EAST);

        add(topPanel);
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

    public JButton getNewGameButton() {
        return (JButton) ((JPanel)topPanel.getComponent(1)).getComponent(0);
    }

    public JButton getMenuButton() {
        return (JButton) ((JPanel)topPanel.getComponent(1)).getComponent(1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 배경 이미지가 있으면 전체 패널에 맞게 그리기
        if (backgroundImage != null) {
            // 이미지를 패널 크기에 맞게 스케일링하여 그리기
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            // 배경 이미지가 없으면 기본 색상으로 채우기
            g.setColor(new Color(240, 240, 240));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}