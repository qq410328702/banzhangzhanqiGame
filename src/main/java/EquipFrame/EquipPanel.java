package EquipFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EquipPanel extends JPanel implements Runnable ,MouseListener{
    public static final float	UPDATE_RATE		= 60.0f;
    public static final float	UPDATE_INTERVAL	= Time.SECOND / UPDATE_RATE;
    public static final long	IDLE_TIME		= 1;
    private static int mapPanel[][] = {
            {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
            {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2}
    };
    Thread thread;


    public EquipPanel() {
        JFrame equipframe = new JFrame("人物选择界面");
        equipframe .setLayout(null);
        equipframe .setPreferredSize(new Dimension(Global.GAMEWIDTH, Global.GAMEHEIGHT));
        equipframe .setMaximumSize(new Dimension(Global.GAMEWIDTH, Global.GAMEHEIGHT));
        equipframe .setMinimumSize(new Dimension(Global.GAMEWIDTH, Global.GAMEHEIGHT));
        equipframe .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        equipframe .setResizable(false);
        equipframe .setLocationRelativeTo(null);
        equipframe .setVisible(true);
       // this.addMouseListener(this);
        this.setBounds(0,0,Global.GAMEWIDTH,Global.GAMEWIDTH);
        Container container =equipframe .getContentPane();
        int count = 1;
        for (int i=0;i<mapPanel.length;i++){
            for (int j=0;j<mapPanel[0].length;j++){
                if (mapPanel[i][j]==0){
                    ImageIcon imageIcon = new ImageIcon("image/人物选择界面/傲大喵/"+count+".gif");
                    JButton overBtn = new JButton();
                    overBtn.setIcon(imageIcon);
                    overBtn.setBounds(j*Global.CELL_SIZE,i*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE);
                    container.add(overBtn);
                    count++;
                    overBtn.addMouseListener(this);
                }
            }
        }

        start();

        container.add(this);
    }
    public static void main(String args[]) {
        new EquipPanel();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        long count = 0;
        float delta = 0;
        long lastTime = Time.get();
        while (true) {
            long now = Time.get();
            long elapsedTime = now - lastTime;
            lastTime = now;
            count += elapsedTime;
            boolean render = false;
            delta += (elapsedTime / UPDATE_INTERVAL);
            while (delta > 1) {
                this.tick();
                this.render();
                delta--;
                if (render) {
                } else {
                    render = true;
                }
            }

            if (render) {
            } else {
                try {
                    Thread.sleep(IDLE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (count >= Time.SECOND) {
                count = 0;
            }

        }
    }
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,Global.GAMEWIDTH, Global.GAMEHEIGHT);
        Image image = Toolkit.getDefaultToolkit().getImage("image/人物选择界面/status_bg.png");
        g.drawImage(image, (int) (Global.GAMEWIDTH-image.getWidth(null)*1.5), (int) (Global.GAMEHEIGHT-image.getHeight(null)*1.5)/2, (int) (image.getWidth(null)*1.5), (int) (image.getHeight(null)*1.5),null);
    }

    public synchronized void stop() {
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void render() {

    }

    private void tick() {

    }
}
