package calendar;

import javax.swing.*;
import java.awt.*;

public class Calendar extends JPanel {

    private static final long serialVersionUID = 1L;

    public Calendar() {

        setLayout(new BorderLayout(30,30));
        setBorder(BorderFactory.createEmptyBorder(40, 20, 30 ,20));
        setBackground(Color.WHITE);

        JPanel top = new JPanel(new BorderLayout(10,10));
        top.setBackground(null);

        JLabel date = new JLabel("March 2025");
        date.setHorizontalAlignment(JLabel.CENTER);//컴포넌트의 텍스트나 이미지의 수평 정렬을 설정
        date.setFont(new Font("Helvetica", Font.BOLD, 39));
        date.setForeground(Color.decode("#0ecf78"));
        top.add(date, BorderLayout.CENTER);

        JLabel left = new JLabel(new ImageIcon("src/resource/icons/right.png"));
        //setCursor는 커서의 모양을 설정. Cursor 객체를 통해 해당 컴포넌트 위로 마우스 포인터가 올라갔을 때 보여질 커서의 모양을 정할 수 있음
        //new Cursor는 Hand_Cursor 상수는 손 모양의 포인터를 나타냄
        //해당 요소가 클릭 가능함을 시각적으로 표현
        left.setCursor(new Cursor(Cursor.HAND_CURSOR));
        top.add(left, BorderLayout.EAST);

        JLabel right = new JLabel(new ImageIcon("src/resource/icons/left.png"));
        right.setCursor(new Cursor(Cursor.HAND_CURSOR));
        top.add(right, BorderLayout.WEST);

        add(top, BorderLayout.NORTH);

        JPanel days = new JPanel(new GridLayout(7,7));
        days.setBackground(null);//컴포넌트 배경 설정

        for(int i = 0; i < 49; i++){
            JLabel lb = new JLabel(i + "");
            lb.setHorizontalAlignment(JLabel.CENTER);
            lb.setFont(new Font("Helvetica", Font.BOLD, 20));
            lb.setOpaque(true);
            lb.setBackground(Color.decode("#f0f0f0"));
            lb.setForeground(Color.BLACK);
            lb.setCursor(new Cursor(Cursor.HAND_CURSOR));
            days.add(lb);
        }

        add(days, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);
    }
}
