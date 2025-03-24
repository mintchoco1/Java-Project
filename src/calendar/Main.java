package calendar;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,500);
        frame.setLocationRelativeTo(null);//
        frame.getContentPane().setBackground(Color.white);
        frame.setResizable(false);

        JPanel mainPanel = new JPanel(new GridLayout(1,2,0,0));

        mainPanel.add(new Calendar());
        mainPanel.add(new Events());

        frame.getContentPane().add(mainPanel);//프레임의 컨텐츠를 관리
        frame.setVisible(true);
    }
}
