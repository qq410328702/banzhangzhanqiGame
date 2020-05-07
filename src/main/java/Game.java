
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable,MouseListener {
    public static final float	UPDATE_RATE		= 60.0f;
    public static final float	UPDATE_INTERVAL	= Time.SECOND / UPDATE_RATE;
    public static final long	IDLE_TIME		= 1;
    GameStats gameStats;
    Thread thread;
    PlayerObject playerObject ;
    EnemyObject enemyObject;
    Maps maps = new Maps();

    public Game() {
        this.setBounds(0,0,Global.GAMEWIDTH, Global.GAMEHEIGHT);
        playerObject = new PlayerObject();
        enemyObject = new EnemyObject();
        gameStats= new GameStats();
        this.addMouseListener(this);
        new Frame(Global.GAMEWIDTH, Global.GAMEHEIGHT, "棋盘游戏", this);
        start();
        playerObject.addPlayer(new Player(5,5,Color.yellow, "image/rpg3.png"));
        playerObject.addPlayer(new Player(4,5,Color.yellow, "image/rpg3.png"));
        playerObject.addPlayer(new Player(3,5,Color.yellow, "image/rpg3.png"));
        enemyObject.addPlayer(new Player(6,5,Color.BLACK,"image/rpg3.png"));
        enemyObject.addPlayer(new Player(7,5,Color.cyan,"image/rpg3.png"));
        enemyObject.addPlayer(new Player(5,10,Color.MAGENTA,"image/rpg3.png"));
        enemyObject.addPlayer(new Player(6,10,Color.PINK,"image/rpg3.png"));

    }

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

    public synchronized void stop() {
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, 1080, 720);

        maps.render(g,playerObject,enemyObject,gameStats);
        enemyObject.render(g,maps,playerObject);
        playerObject.render(g,maps,enemyObject);

        g.dispose();
        bs.show();
    }

    private void tick() {
        playerObject.tick();
        enemyObject.tick();
    }


    public static void main(String args[]) {
        new Game();
    }


    public void mouseClicked(java.awt.event.MouseEvent e) {
        for (int i =0 ;i<playerObject.playerLinked.size();i++){
            if (e.getY()/Global.CELL_SIZE==playerObject.playerLinked.get(i).getX()&&
                    e.getX()/Global.CELL_SIZE==playerObject.playerLinked.get(i).getY() ){
                playerObject.playerLinked.get(i).setShowHP(true);
            }else {
                playerObject.playerLinked.get(i).setShowHP(false);
            }
        }
        for (int j=0;j<enemyObject.enemyLinked.size();j++){
            if (e.getY()/Global.CELL_SIZE==enemyObject.enemyLinked.get(j).getX()&&
                    e.getX()/Global.CELL_SIZE==enemyObject.enemyLinked.get(j).getY() ){
                enemyObject.enemyLinked.get(j).setShowHP(true);
            }else {
                enemyObject.enemyLinked.get(j).setShowHP(false);
            }
        }
    }

   public int tempmber=0;
    public void mousePressed(java.awt.event.MouseEvent e) {
//        if (gameStats.getNOWSTATS()==gameStats.PLAYERTURN){
//            playerObject.playerMove(e,gameStats,playerObject,enemyObject);
//        }else {
//            try {
//                enemyObject.enemyMove(gameStats,e, playerObject,enemyObject);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
//
//        }
        playerObject.playerLinked.get(0).setX((tempmber+1)%Maps.map.length);
    }


    public void mouseReleased(java.awt.event.MouseEvent e) {

    }


    public void mouseEntered(java.awt.event.MouseEvent e) {

    }


    public void mouseExited(java.awt.event.MouseEvent e) {

    }
}
