
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class DaFang extends Canvas implements Runnable,MouseListener {
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
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},//1
            {2,1,1,1,1,1,1,1,1,1,1,1,1,7,3,3,3,7,1,1,1,1,1,1,1,1,1,1,1,2},//2
            {2,1,1,1,1,1,1,1,1,1,1,1,1,7,3,5,3,7,1,1,1,1,1,1,1,1,1,1,1,2},//3
            {2,1,1,1,1,1,1,1,1,1,1,1,1,7,3,3,3,7,1,1,1,1,1,1,1,1,1,1,1,2},//4
            {2,1,1,1,1,1,1,1,1,1,1,1,1,7,7,7,7,7,1,1,1,1,1,1,1,1,1,1,1,2},//5
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//6
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//7
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//8
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//9
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//10
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//11
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//12
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//13
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//14
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//15
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//16
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//17
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//18
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//19
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//20
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//21
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//22
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//23
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//24
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//25
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//26
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//27
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//28
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//29
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//30
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//31
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//32
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//33
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//34
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//35
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//36
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//37
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//38
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//39
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//40
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//41
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//42
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//43
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//44
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//45
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//46
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//47
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//48
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//49
//            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//50
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//51
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//52
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//53
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//54
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//55
            {2,1,1,1,1,1,1,1,1,1,1,1,1,8,8,8,8,8,1,1,1,1,1,1,1,1,1,1,1,2},//56
            {2,1,1,1,1,1,1,1,1,1,1,1,1,8,4,4,4,8,1,1,1,1,1,1,1,1,1,1,1,2},//57
            {2,1,1,1,1,1,1,1,1,1,1,1,1,8,4,6,4,8,1,1,1,1,1,1,1,1,1,1,1,2},//58
            {2,1,1,1,1,1,1,1,1,1,1,1,1,8,4,4,4,8,1,1,1,1,1,1,1,1,1,1,1,2},//59
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}//60
    };

    public DaFang() {
        this.setBounds(0,0,Global.GAMEWIDTH, Global.GAMEHEIGHT);
        Button overBtn = new Button();
        overBtn.setLabel("结束");
        overBtn.setBounds(Global.CELL_SIZE,0,Global.CELL_SIZE,Global.CELL_SIZE);

        playerObject = new PlayerObject();
        enemyObject = new EnemyObject();
        gameStats= new GameStats();
        this.addMouseListener(this);
/**
 * 3 代表 防御敌人兵 4 代表 玩家 防御兵
 */
        for (int i=0;i<playerorenmeylist.length;i++){
            for (int j=0; j<playerorenmeylist[0].length;j++ ){
                if (playerorenmeylist[i][j]==4){
                    Player tempPlayer = new Player(i,j,Color.BLACK, "image/曹操传/NPC/木兵/木兵.png");
                    tempPlayer.setMoveType(0);
                    tempPlayer.setAttackType(0);
                    playerObject.addPlayer(tempPlayer);

                }else
                if (playerorenmeylist[i][j]==6){
                    Player tempPlayer = new Player(i,j,Color.BLACK, "image/哆啦A梦/哆啦A梦动作.png");
                    tempPlayer.setMoveType(1);
                    tempPlayer.setAttackType(1);
                    playerObject.addPlayer(tempPlayer);
                }
                else if (playerorenmeylist[i][j]==3){
                    Player tempPlayer = new Player(i,j,Color.magenta, "image/曹操传/NPC/木人/木人.png");
                    tempPlayer.setMoveType(0);
                    tempPlayer.setAttackType(0);
                    enemyObject.addPlayer(tempPlayer);
                }     else if (playerorenmeylist[i][j]==5){
                    Player tempPlayer = new Player(i,j,Color.magenta, "image/曹操传/吴-人物/孙尚香/孙尚香.png");
                    tempPlayer.setMoveType(1);
                    tempPlayer.setAttackType(1);
                    enemyObject.addPlayer(tempPlayer);
                }
            }
        }
        for (int i=0;i<enemyObject.enemyLinked.size();i++){
            enemyObject.enemyLinked.get(i).face = enemyObject.enemyLinked.get(i).facesouth;
            enemyObject.enemyLinked.get(i).setName("敌人："+i+"号");
        }
        for (int i=0;i<playerObject.playerLinked.size();i++){
            playerObject.playerLinked.get(i).face = playerObject.playerLinked.get(i).facenorth;
            playerObject.playerLinked.get(i).setName("玩家："+i+"号");
        }


        start();
    }

    public Point getEnemySummonPoint(){
        Point tempPoint =null;
        for (int i=0;i<playerorenmeylist.length;i++){
            for (int j=0; j<playerorenmeylist[0].length;j++ ){
                if (playerorenmeylist[i][j]==7){
                    for (int z =0;z<enemyObject.enemyLinked.size();z++){
                        if (enemyObject.enemyLinked.get(z).getX()!=i&&enemyObject.enemyLinked.get(z).getY()!=j){
                            tempPoint = new Point(i,j);
                            break;
                        }
                    }
                }
            }
        }
        return  tempPoint;
    }
    public Point getPlayerSummonPoint(){
        Point tempPoint =null;
        for (int i=0;i<playerorenmeylist.length;i++){
            for (int j=0; j<playerorenmeylist[0].length;j++ ){
                if (playerorenmeylist[i][j]==8){
                    for (int z =0;z<playerObject.playerLinked.size();z++){
                        if (playerObject.playerLinked.get(z).getX()!=i&&playerObject.playerLinked.get(z).getY()!=j){
                            tempPoint = new Point(i,j);
                            break;
                        }
                    }
                }
            }
        }
        return  tempPoint;
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
        new DaFang();
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
    private int turnCounn=0;
    private boolean playerSummon = true;
    private boolean enemySummon =false;
    PlayerFactory playerFactory = new PlayerFactory();
    public void mousePressed(java.awt.event.MouseEvent e) {

        if (gameStats.getNOWSTATS()==gameStats.PLAYERTURN){
            if (playerSummon==true){

                Point playerPoint = getPlayerSummonPoint();
                Player tempPlayer = null;
                switch (turnCounn%3){
                    case 0:
                        tempPlayer =playerFactory.getPlayerType3(playerPoint);
                        tempPlayer.setImagePath("image/曹操传/蜀-人物/关羽/关羽.png");
                        break;
                    case 1:
                        tempPlayer =playerFactory.getPlayerType4(playerPoint);
                        tempPlayer.setImagePath("image/曹操传/蜀-人物/张飞/张飞.png");
                        break;
                    case 2:
                        tempPlayer =playerFactory.getPlayerType5(playerPoint);
                        tempPlayer.setImagePath("image/曹操传/蜀-人物/赵云/赵云.png");
                        break;
                }
                tempPlayer.face = tempPlayer.facenorth;
                turnCounn++;
                tempPlayer.setName("玩家："+turnCounn+"号");
                playerObject.addPlayer(tempPlayer);
                playerSummon =false;
                enemySummon =true;
            }
            playerObject.playerMove(e,gameStats,playerObject,enemyObject,maps);
            if (e.getX()>0&&e.getX()<Global.CELL_SIZE&&e.getY()>0&&e.getY()<Global.CELL_SIZE){
                for (int i= 0;i<playerObject.playerLinked.size();i++){
                    playerObject.playerLinked.get(i).setSeleted(false);
                    playerObject.playerLinked.get(i).setMove(false);
                    playerObject.playerLinked.get(i).setAttack(false);
                }
                playerObject.playerLinked.get((playerObject.getcurrentplayer+1)%playerObject.playerLinked.size()).setSeleted(true);
            }

        }else if (gameStats.getNOWSTATS()==gameStats.ENEMYTURN){
            if (enemySummon==true){
                playerSummon=true;
                Point enemyPoint = getEnemySummonPoint();
                Player tempPlayer = null;
                switch (turnCounn%3){
                    case 0:
                        tempPlayer =playerFactory.getPlayerType3(enemyPoint);
                        tempPlayer.setImagePath("image/哆啦A梦/哆啦咪子.png");
                        break;
                    case 1:
                        tempPlayer =playerFactory.getPlayerType4(enemyPoint);
                        tempPlayer.setImagePath("image/哆啦A梦/哆啦利钮.png");
                        break;
                    case 2:
                        tempPlayer =playerFactory.getPlayerType5(enemyPoint);
                        tempPlayer.setImagePath("image/哆啦A梦/哆啦美.png");
                        break;
                }
                tempPlayer.face = tempPlayer.facesouth;
                turnCounn++;
                tempPlayer.setName("敌人："+turnCounn+"号");
                enemyObject.addPlayer(tempPlayer);
                enemySummon =false;
            }

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
