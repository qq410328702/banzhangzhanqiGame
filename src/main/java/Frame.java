import javax.swing.*;
import java.awt.*;

public class Frame extends Canvas {
    public Frame(int width, int height, String title, Canvas canvas) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(canvas);
        frame.setLayout(null);
        frame.setVisible(true);
        Button overBtn = new Button();
        overBtn.setLabel("结束");
        overBtn.setBounds(Global.CELL_SIZE,0,Global.CELL_SIZE,Global.CELL_SIZE);
        frame.add(overBtn);
    }
}
