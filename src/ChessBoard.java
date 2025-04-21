import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel {
    final int rows = 8;
    final int cols = 8;

    public ChessBoard() {
        this.
    }

    public void paintcomponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                g2d.setColor((c + r) % 2 == 0 ? Color.white : Color.BLACK);
            }
        }
    }
}
