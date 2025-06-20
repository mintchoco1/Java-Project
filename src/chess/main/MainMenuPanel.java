package chess.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MainMenuPanel extends JPanel {
    private JButton localButton;
    private JButton multiButton;
    private JButton exitButton;
    private BufferedImage backgroundImage;

    @SuppressWarnings("unused")
    public MainMenuPanel() {
        setLayout(new BorderLayout());

        // 배경 이미지 로드
        try {
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("/background.png"));
        } catch (Exception e) {
            try {
                backgroundImage = ImageIO.read(getClass().getResourceAsStream("/resources/background.png"));
            } catch (Exception ex) {
                try {
                    backgroundImage = ImageIO.read(getClass().getResourceAsStream("/images/background.png"));
                } catch (Exception exc) {
                    try {
                        backgroundImage = ImageIO.read(getClass().getResourceAsStream("/background.jpg"));
                    } catch (Exception excx) {
                        System.out.println("메인메뉴 배경 이미지를 찾을 수 없습니다");
                    }
                }
            }
        }

        // 패널을 투명하게 설정 (배경 이미지를 보이게 하기 위해)
        setOpaque(false);

        // 상단 타이틀
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel1 = new JLabel("Chess");
        titleLabel1.setFont(new Font("Arial", Font.BOLD, 72));
        titleLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel1.setForeground(Color.WHITE); // 텍스트를 흰색으로

        JLabel titleLabel2 = new JLabel("Master");
        titleLabel2.setFont(new Font("Arial", Font.PLAIN, 60));
        titleLabel2.setForeground(Color.LIGHT_GRAY); // 약간 밝은 회색으로
        titleLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(Box.createVerticalStrut(80));
        titlePanel.add(titleLabel1);
        titlePanel.add(titleLabel2);

/*        // 중앙 킹 이미지 (플레이스홀더)
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        JLabel kingIcon = new JLabel("♚");
        kingIcon.setFont(new Font("Arial", Font.PLAIN, 120));
        kingIcon.setForeground(Color.WHITE); // 킹 아이콘도 흰색으로
        centerPanel.add(kingIcon);*/

        // 하단 버튼 패널
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

        // 버튼 스타일 설정
        Dimension buttonSize = new Dimension(150, 50);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);

        localButton = createStyledButton("Local", buttonSize, buttonFont);
        multiButton = createStyledButton("Multi", buttonSize, buttonFont);
        exitButton = createStyledButton("Exit", buttonSize, buttonFont);
        exitButton.setBackground(new Color(100, 100, 100));

        buttonPanel.add(localButton);
        buttonPanel.add(multiButton);

        JPanel exitPanel = new JPanel();
        exitPanel.setOpaque(false);
        exitPanel.add(exitButton);

        // 전체 레이아웃 구성
        add(titlePanel, BorderLayout.NORTH);
        //add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(buttonPanel);
        bottomPanel.add(exitPanel);
        bottomPanel.add(Box.createVerticalStrut(50));

        add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 배경 이미지가 있으면 전체 패널에 맞게 그리기
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            // 배경 이미지가 없으면 기본 색상으로 채우기
            g.setColor(new Color(240, 240, 240));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    private JButton createStyledButton(String text, Dimension size, Font font) {
        JButton button = new JButton(text);
        button.setPreferredSize(size);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 70, 70));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // 호버 효과
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(button.getBackground().brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (text.equals("Exit")) {
                    button.setBackground(new Color(100, 100, 100));
                } else {
                    button.setBackground(new Color(70, 70, 70));
                }
            }
        });

        return button;
    }

    public void addLocalButtonListener(ActionListener listener) {
        localButton.addActionListener(listener);
    }

    public void addMultiButtonListener(ActionListener listener) {
        multiButton.addActionListener(listener);
    }

    public void addExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }
}