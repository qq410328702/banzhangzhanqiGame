
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class Game0917 extends Canvas implements Runnable,MouseListener {
    public static final float	UPDATE_RATE		= 60.0f;
    public static final float	UPDATE_INTERVAL	= Time.SECOND / UPDATE_RATE;
    public static final long	IDLE_TIME		= 1;
    GameStats gameStats;
    Thread thread;
    PlayerObject playerObject ;
    EnemyObject enemyObject;
    Maps maps = new Maps();
    Frame frame = new Frame(Global.GAMEWIDTH, Global.GAMEHEIGHT, "棋盘游戏",this);

    static int playerorenmeylist[][] = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public Game0917() {
        this.setBounds(0,0,Global.GAMEWIDTH, Global.GAMEHEIGHT);
        Button overBtn = new Button();
        overBtn.setLabel("结束");
        overBtn.setBounds(Global.CELL_SIZE,0,Global.CELL_SIZE,Global.CELL_SIZE);

        playerObject = new PlayerObject();
        enemyObject = new EnemyObject();
        gameStats= new GameStats();
        this.addMouseListener(this);

        for (int i=0;i<playerorenmeylist.length;i++){
            for (int j=0; j<playerorenmeylist[0].length;j++ ){
                if (playerorenmeylist[i][j]==2){
                    playerObject.addPlayer(new Player(i,j,Color.BLACK, "image/rpg3.png"));
                }
                else if (playerorenmeylist[i][j]==3){
                    enemyObject.addPlayer(new Player(i,j,Color.magenta, "image/rpgmove2.png"));
                }
            }
        }
        enemyObject.enemyLinked.get(0).setImagePath("image/哆啦A梦/哆啦A梦动作.png");
        enemyObject.enemyLinked.get(0).setName("哆啦A梦");
        playerObject.playerLinked.get(0).setMoveType(0);
        playerObject.playerLinked.get(1).setMoveType(1);
        playerObject.playerLinked.get(2).setMoveType(2);
        //playerObject.playerLinked.get(3).setMoveType(3);
        playerObject.playerLinked.get(0).setImagePath("image/玩家/r3.png");
        playerObject.playerLinked.get(1).setImagePath("image/玩家/r2.png");
        playerObject.playerLinked.get(2).setImagePath("image/玩家/r1.png");
       // playerObject.playerLinked.get(3).setImagePath("image/玩家/npc4.png");
        playerObject.playerLinked.get(0).setImageFace("image/玩家/face3.png");
        playerObject.playerLinked.get(1).setImageFace("image/玩家/face2.png");
        playerObject.playerLinked.get(2).setImageFace("image/玩家/face1.png");
      //  playerObject.playerLinked.get(3).setImageFace("image/玩家/face1.png");
        playerObject.playerLinked.get(0).setName("玩家1");
        playerObject.playerLinked.get(1).setName("玩家2");
        playerObject.playerLinked.get(2).setName("玩家3");
      //  playerObject.playerLinked.get(3).setName("玩家4");
        start();
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
        g.fillRect(0, 0, Global.GAMEWIDTH, Global.GAMEHEIGHT);
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
        new Game0917();
    }
    public void mouseClicked(java.awt.event.MouseEvent e) {
//        for (int i =0 ;i<playerObject.playerLinked.size();i++){
//            if (e.getY()/Global.CELL_SIZE==playerObject.playerLinked.get(i).getX()&&
//                    e.getX()/Global.CELL_SIZE==playerObject.playerLinked.get(i).getY() ){
//                playerObject.playerLinked.get(i).setShowHP(true);
//            }else {
//                playerObject.playerLinked.get(i).setShowHP(false);
//            }
//        }
//        for (int j=0;j<enemyObject.enemyLinked.size();j++){
//            if (e.getY()/Global.CELL_SIZE==enemyObject.enemyLinked.get(j).getX()&&
//                    e.getX()/Global.CELL_SIZE==enemyObject.enemyLinked.get(j).getY() ){
//                enemyObject.enemyLinked.get(j).setShowHP(true);
//            }else {
//                enemyObject.enemyLinked.get(j).setShowHP(false);
//            }
//        }
    }
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (gameStats.getNOWSTATS()==gameStats.PLAYERTURN){

            playerObject.playerMove(e,gameStats,playerObject,enemyObject,maps);
            if (e.getX()>0&&e.getX()<Global.CELL_SIZE&&e.getY()>0&&e.getY()<Global.CELL_SIZE){
                for (int i= 0;i<playerObject.playerLinked.size();i++){
                    playerObject.playerLinked.get(i).setSeleted(false);
                    playerObject.playerLinked.get(i).setMove(false);
                    playerObject.playerLinked.get(i).setAttack(false);
                }
                playerObject.playerLinked.get((playerObject.getcurrentplayer+1)%playerObject.playerLinked.size()).setSeleted(true);
            }
        }else {
            try {
                enemyObject.enemyMove(maps,gameStats,e, playerObject,enemyObject,thread);
               // thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        }
    }
    public void mouseReleased(java.awt.event.MouseEvent e) { }
    public void mouseEntered(java.awt.event.MouseEvent e) { }
    public void mouseExited(java.awt.event.MouseEvent e) { }
}
