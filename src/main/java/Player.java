import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private int playerOneTurnMaxMoveTime =1;
    private int playerOneTurnMoveTime =1;
    private int playerOneTurnMaxAttackTime =1;
    private int playerOneTurnAttackTime =1;

    public int getPlayerOneTurnMaxAttackTime() {
        return playerOneTurnMaxAttackTime;
    }

    public void setPlayerOneTurnMaxAttackTime(int playerOneTurnMaxAttackTime) {
        this.playerOneTurnMaxAttackTime = playerOneTurnMaxAttackTime;
    }

    public int getPlayerOneTurnAttackTime() {
        return playerOneTurnAttackTime;
    }

    public void setPlayerOneTurnAttackTime(int playerOneTurnAttackTime) {
        this.playerOneTurnAttackTime = playerOneTurnAttackTime;
    }

    private int x;
    public int getPlayerOneTurnMaxMoveTime() {
        return playerOneTurnMaxMoveTime;
    }
    public void setPlayerOneTurnMaxMoveTime(int playerOneTurnMaxMoveTime) {
        this.playerOneTurnMaxMoveTime = playerOneTurnMaxMoveTime;
    }
    public int getPlayerOneTurnMoveTime() {
        return playerOneTurnMoveTime;
    }
    public void setPlayerOneTurnMoveTime(int playerOneTurnMoveTime) {
        this.playerOneTurnMoveTime = playerOneTurnMoveTime;
    }
    public void resetPlayerOneTurnStats(){
        setPlayerOneTurnMoveTime(getPlayerOneTurnMaxMoveTime());
        setPlayerOneTurnAttackTime(getPlayerOneTurnMaxAttackTime());
    }
    private int y;
    private int minX=0;
    private int minY=0;
    private int maxY=map[0].length;
    private int maxX=map.length;
    public void getMixorMaxAttactRanger(EnemyObject enemyObject){
//        for (int i=0;i<enemyObject.enemyLinked.size();i++){
//            if (getY()==enemyObject.enemyLinked.get(i).getY()){
//                if (getX()>enemyObject.enemyLinked.get(i).getX()){
//                    minX=enemyObject.enemyLinked.get(i).getX();
//                }else if(getX()<enemyObject.enemyLinked.get(i).getX()){
//                    maxX=enemyObject.enemyLinked.get(i).getX();
//                }
//            }else if (getY()==enemyObject.enemyLinked.get(i).getX()){
//                if (getY()>enemyObject.enemyLinked.get(i).getY()){
//                    minY=enemyObject.enemyLinked.get(i).getY();
//                }else if(getY()<enemyObject.enemyLinked.get(i).getY()){
//                    maxY=enemyObject.enemyLinked.get(i).getY();
//                }
//            }
//        }
    }
    private boolean isSeleted =false;
    private boolean isMove =false;
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    private boolean isAttack =false;
    private String imagePath;
    private boolean isShowHP =false;
    private int moveType;
    static int map[][] =Maps.getMap();
    public int getMoveType() {
        return moveType;
    }
    public void setMoveType(int moveType) {
        this.moveType = moveType;
    }
    private int MaxHP =100;

    public int getMaxHP() {
        return MaxHP;
    }

    private int HP =MaxHP;
    public int facesouth =0;
    public int facewest =1;
    public int faceeast =2;
    public int facenorth =3;
    public  int face =facenorth;
    private  int playermovestats=0;
    public void updatePlayerMoveStats() {
        playermovestats = (playermovestats + 1) % 4;
    }
    public boolean isShowHP() {
        return isShowHP;
    }
    public void setShowHP(boolean showHP) {
        isShowHP = showHP;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public boolean isAttack() {
        return isAttack;
    }
    public void setAttack(boolean attack) {
        isAttack = attack;
    }
    private Color color;
    public boolean isMove() {
        return isMove;
    }
    public void setMove(boolean move) {
        isMove = move;
    }
    public boolean isSeleted() {
        return isSeleted;
    }
    public void setSeleted(boolean seleted) {
        isSeleted = seleted;
    }
    public Player(int x, int y,Color color,String imagePath) {
        this.x = x;
        this.y = y;
        this.color=color;
        this.imagePath= imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    private Image imageFace;

    public void setImageFace(String imageFace1) {
        imageFace = Toolkit.getDefaultToolkit().getImage(imageFace1);

        this.imageFace = imageFace;
    }

    public Image getImageFace() {
        return imageFace;
    }

    private MoveRanger moveRanger =new MoveRanger();
    private AttackRanger attackRanger =new AttackRanger();
    public Point canMoveorAttackPoint[][] =null;
    public int canMoveRanger[][] =null;
    private int attackType;

    public int getAttackType() {
        return attackType;
    }

    public void setAttackType(int attackType) {
        this.attackType = attackType;
    }

    public int canAttackRanger[][] = attackRanger.getAttackRanger[getAttackType()];
    public Point[][] getMoveorAttackPoint(){
        canMoveorAttackPoint = new Point[][]{
                {new Point(getX()-3,getY()-3),new Point(getX()-2,getY()-3),new Point(getX()-1,getY()-3),new Point(getX(),getY()-3),new Point(getX()+1,getY()-3),new Point(getX()+2,getY()-3),new Point(getX()+3,getY()-3)},
                {new Point(getX()-3,getY()-2),new Point(getX()-2,getY()-2),new Point(getX()-1,getY()-2),new Point(getX(),getY()-2),new Point(getX()+1,getY()-2),new Point(getX()+2,getY()-2),new Point(getX()+3,getY()-2)},
                {new Point(getX()-3,getY()-1),new Point(getX()-2,getY()-1),new Point(getX()-1,getY()-1),new Point(getX(),getY()-1),new Point(getX()+1,getY()-1),new Point(getX()+2,getY()-1),new Point(getX()+3,getY()-1)},
                {new Point(getX()-3,getY()),new Point(getX()-2,getY()),new Point(getX()-1,getY()),new Point(getX(),getY()),new Point(getX()+1,getY()),new Point(getX()+2,getY()),new Point(getX()+3,getY())},
                {new Point(getX()-3,getY()+1),new Point(getX()-2,getY()+1),new Point(getX()-1,getY()+1),new Point(getX(),getY()+1),new Point(getX()+1,getY()+1),new Point(getX()+2,getY()+1),new Point(getX()+3,getY()+1)},
                {new Point(getX()-3,getY()+2),new Point(getX()-2,getY()+2),new Point(getX()-1,getY()+2),new Point(getX(),getY()+2),new Point(getX()+1,getY()+2),new Point(getX()+2,getY()+2),new Point(getX()+3,getY()+2)},
                {new Point(getX()-3,getY()+3),new Point(getX()-2,getY()+3),new Point(getX()-1,getY()+3),new Point(getX(),getY()+3),new Point(getX()+1,getY()+3),new Point(getX()+2,getY()+3),new Point(getX()+3,getY()+3)}
        };
        return canMoveorAttackPoint;
    }
    private int count=0;
    public void tick() {
        count++;
        if (count>=20){
            updatePlayerMoveStats();
            count=0;
        }
        getMoveorAttackPoint();
        canMoveRanger = moveRanger.getMoveranger[getMoveType()];
    }
    public void isAttackFunction(java.awt.event.MouseEvent e,GameStats gameStats,EnemyObject enemyObject,PlayerObject playerObject,Maps maps){
        int eY= e.getX()/Global.CELL_SIZE;
        int eX= e.getY()/Global.CELL_SIZE;
        for (int i =0;i<canMoveorAttackPoint.length;i++){
            for (int j =0;j<canMoveorAttackPoint[0].length;j++){
                if (canAttackRanger[i][j]==1&&
                        canMoveorAttackPoint[i][j].x+maps.mapsY/Global.CELL_SIZE==e.getY()/Global.CELL_SIZE&&
                        canMoveorAttackPoint[i][j].y+maps.mapsX/Global.CELL_SIZE==e.getX()/Global.CELL_SIZE){
                    for (int z=0; z<enemyObject.enemyLinked.size();z++){
                        if (eX==enemyObject.enemyLinked.get(z).getX()+maps.mapsY/Global.CELL_SIZE&&
                                eY==enemyObject.enemyLinked.get(z).getY()+maps.mapsX/Global.CELL_SIZE){

                            maps.setMsg(Maps.msgenum.playerAttck);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                            maps.setMsg(Maps.msgenum.nothing);
                            setPlayerOneTurnAttackTime(getPlayerOneTurnMoveTime()-1);
                            //JOptionPane.showMessageDialog(null,"敌人收到攻击");
                            enemyObject.enemyLinked.get(z).setHP(enemyObject.enemyLinked.get(z).getHP()-new Random().nextInt(100));
                        }
                    }

                }
            }
            setAttack(false);
        }
    }
    public boolean isCanMoveWest(PlayerObject playerObject ,EnemyObject enemyObject){
        boolean iscanmovewest= true;
        for (int i=0;i<playerObject.playerLinked.size();i++){
            if (getY()-1==playerObject.playerLinked.get(i).getY()&&getX()==playerObject.playerLinked.get(i).getX()){
                iscanmovewest= false;
            }
        }
        for (int i=0;i<enemyObject.enemyLinked.size();i++){
            if (getY()-1==enemyObject.enemyLinked.get(i).getY()&&getX()==enemyObject.enemyLinked.get(i).getX()){
                iscanmovewest= false;
            }
        }
        return  iscanmovewest;
    }
    public boolean isCanMoveEast(PlayerObject playerObject ,EnemyObject enemyObject){
        boolean iscanmoveeast= true;
        for (int i=0;i<playerObject.playerLinked.size();i++){
            if (getY()+1==playerObject.playerLinked.get(i).getY()&&getX()==playerObject.playerLinked.get(i).getX()){
                iscanmoveeast= false;
            }
        }
        for (int i=0;i<enemyObject.enemyLinked.size();i++){
            if (getY()+1==enemyObject.enemyLinked.get(i).getY()&&getX()==enemyObject.enemyLinked.get(i).getX()){
                iscanmoveeast= false;
            }
        }
        return  iscanmoveeast;
    }
    public boolean isCanMoveNorth(PlayerObject playerObject ,EnemyObject enemyObject){
        boolean iscanmovenorth= true;
        for (int i=0;i<playerObject.playerLinked.size();i++){
            if (getY()==playerObject.playerLinked.get(i).getY()&&getX()-1==playerObject.playerLinked.get(i).getX()){
                iscanmovenorth=false;
            }
        }
        for (int i=0;i<enemyObject.enemyLinked.size();i++){
            if (getY()==enemyObject.enemyLinked.get(i).getY()&&getX()-1==enemyObject.enemyLinked.get(i).getX()){
                iscanmovenorth=false;
            }
        }
        return  iscanmovenorth;
    }
    public boolean isCanMoveSouth(PlayerObject playerObject ,EnemyObject enemyObject){
        boolean iscanmovesouth= true;
        for (int i=0;i<playerObject.playerLinked.size();i++){
            if (getY()==playerObject.playerLinked.get(i).getY()&&getX()+1==playerObject.playerLinked.get(i).getX()){
                iscanmovesouth= false;
            }
        }
        for (int i=0;i<enemyObject.enemyLinked.size();i++){
            if (getY()==enemyObject.enemyLinked.get(i).getY()&&getX()+1==enemyObject.enemyLinked.get(i).getX()){
                iscanmovesouth= false;
            }
        }
        return  iscanmovesouth;
    }
    public boolean isPlayerCanMove(java.awt.event.MouseEvent e,PlayerObject playerObject,EnemyObject enemyObject,Maps maps){
        int screenY = getX()+maps.mapsY/Global.CELL_SIZE;
        int screenX = getY()+maps.mapsX/Global.CELL_SIZE;
        boolean isplayercanmove =false;
        for (int i=0;i<enemyObject.enemyLinked.size();i++){
            if (e.getX()/Global.CELL_SIZE==enemyObject.enemyLinked.get(i).getY()+maps.mapsX/Global.CELL_SIZE&&e.getY()/Global.CELL_SIZE==enemyObject.enemyLinked.get(i).getX()+maps.mapsY/Global.CELL_SIZE){
                isplayercanmove= true;
            }
        }
        for (int i=0;i<playerObject.playerLinked.size();i++){
            if (e.getX()/Global.CELL_SIZE==playerObject.playerLinked.get(i).getY()+maps.mapsX/Global.CELL_SIZE&&e.getY()/Global.CELL_SIZE==playerObject.playerLinked.get(i).getX()+maps.mapsY/Global.CELL_SIZE){
                isplayercanmove= true;
            }
        }
        return isplayercanmove;
    }
    public int getPlayerNumber(PlayerObject playerObject){
        int playerNumber=999;
        for (int i= 0;i<playerObject.playerLinked.size();i++){
            if (getY()-1==playerObject.playerLinked.get(i).getY()&&getX()==playerObject.playerLinked.get(i).getX()){
                playerNumber=i;
            }else if (getY()+1==playerObject.playerLinked.get(i).getY()&&getX()==playerObject.playerLinked.get(i).getX()){
                playerNumber=i;
            }else if (getY()==playerObject.playerLinked.get(i).getY()&&getX()+1==playerObject.playerLinked.get(i).getX()){
                playerNumber=i;
            }else if (getY()==playerObject.playerLinked.get(i).getY()&&getX()-1==playerObject.playerLinked.get(i).getX()){
                playerNumber=i;
            }
        }
        return  playerNumber;
    }
    public boolean isHavePlayer(PlayerObject playerObject){
        boolean ishaveplayer = false;
        for (int i=0;i<playerObject.playerLinked.size();i++){
            if (getY()+1==playerObject.playerLinked.get(i).getY()&&getX()==playerObject.playerLinked.get(i).getX()||
                    getY()-1==playerObject.playerLinked.get(i).getY()&&getX()==playerObject.playerLinked.get(i).getX()||
                    getY()==playerObject.playerLinked.get(i).getY()&&getX()+1==playerObject.playerLinked.get(i).getX()||
                    getY()==playerObject.playerLinked.get(i).getY()&&getX()-1==playerObject.playerLinked.get(i).getX()
                    ){
                ishaveplayer= true;
            }
        }
        return ishaveplayer;
    }
    //Thread thread = new Thread();
    public  void enemyMove(Maps maps,PlayerObject playerObject ,EnemyObject enemyObject) throws InterruptedException {
        Player tempPlayer =null;
        int tempCount = 9999;
        for (int i=0;i<playerObject.playerLinked.size();i++){
            if ((Math.abs(playerObject.playerLinked.get(i).getX()-getX())+Math.abs(playerObject.playerLinked.get(i).getY()-getY()))<tempCount){
                tempCount= Math.abs(playerObject.playerLinked.get(i).getX()-getX())+Math.abs(playerObject.playerLinked.get(i).getY()-getY());
                tempPlayer = playerObject.playerLinked.get(i);
            }
        }
        Thread.sleep(Global.ENEMYTIME);
        if (tempPlayer.getX()>getX()){
            face =facesouth;
        }else if (tempPlayer.getX()<getX()){
            face =facenorth;
        }else if (tempPlayer.getY()>getY()){
            face =faceeast;
        }else if (tempPlayer.getY()<getY()){
            face =facewest;
        }
        if (isHavePlayer(playerObject)){
            Thread.sleep(Global.ENEMYTIME);
            setAttack(true);
            Thread.sleep(Global.ENEMYTIME);
            setAttack(false);
            playerObject.playerLinked.get(getPlayerNumber(playerObject)).setHP(playerObject.playerLinked.get(getPlayerNumber(playerObject)).getHP()-new Random().nextInt(100));

            maps.setMsg(Maps.msgenum.enemyAttck);
            //JOptionPane.showMessageDialog(null,"攻击玩家");
        }else {
            isHavePlayer(playerObject);
            setSeleted(true);
            Thread.sleep(Global.ENEMYTIME);
            setSeleted(false);
            setMove(true);
            Thread.sleep(Global.ENEMYTIME);
            setMove(false);
            LinkedList<AStarStruct> bestshortway = new AStar().AStartest(getX(),getY(),
                    tempPlayer.getX(),tempPlayer.getY(),playerObject,enemyObject);
            for (int step =0;step<bestshortway.size();step++){
                for (int i= 0;i<bestshortway.size();i++){
                    if (bestshortway.get(i).getH()==step){
                        for (int w =0;w<canMoveorAttackPoint.length;w++){
                            for (int d=0;d<canMoveorAttackPoint[0].length;d++){
                                if (canMoveorAttackPoint[w][d].x==bestshortway.get(i).getX()&&
                                        canMoveorAttackPoint[w][d].y==bestshortway.get(i).getY()){
                                    if (canMoveRanger[w][d]==1){
                                        if (bestshortway.get(i).getX()>getX()){
                                            face =facesouth;
                                        }else if (bestshortway.get(i).getX()<getX()){
                                            face =facenorth;
                                        }else if (bestshortway.get(i).getY()>getY()){
                                            face =faceeast;
                                        }else if (bestshortway.get(i).getY()<getY()){
                                            face =facewest;
                                        }
                                        setX(bestshortway.get(i).getX());
                                        setY(bestshortway.get(i).getY());

                                        System.out.println(step);
                                        if (isHavePlayer(playerObject)){
                                            if (tempPlayer.getX()>getX()){
                                                face =facesouth;
                                            }else if (tempPlayer.getX()<getX()){
                                                face =facenorth;
                                            }else if (tempPlayer.getY()>getY()){
                                                face =faceeast;
                                            }else if (tempPlayer.getY()<getY()){
                                                face =facewest;
                                            }
                                            setAttack(true);
                                            setAttack(false);
                                            playerObject.playerLinked.get(getPlayerNumber(playerObject)).setHP(playerObject.playerLinked.get(getPlayerNumber(playerObject)).getHP()-new Random().nextInt(100));
                                            maps.setMsg(Maps.msgenum.enemyAttck);
                                            break;
//                                            Thread.sleep(1000);
//                                            maps.setMsg(Maps.msgenum.nothing);
                                            //JOptionPane.showMessageDialog(null,"攻击玩家");
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        Thread.sleep(300);
        if (tempPlayer.getX()>getX()){
            face =facesouth;
        }else if (tempPlayer.getX()<getX()){
            face =facenorth;
        }else if (tempPlayer.getY()>getY()){
            face =faceeast;
        }else if (tempPlayer.getY()<getY()){
            face =facewest;
        }

    }

    public void playMove(java.awt.event.MouseEvent e,GameStats gameStats,PlayerObject playerObject,EnemyObject enemyObject,Maps maps){
        int screenY = getX()+maps.mapsY/Global.CELL_SIZE;
        int screenX = getY()+maps.mapsX/Global.CELL_SIZE;
        getMixorMaxAttactRanger(enemyObject);
        if (true/*e.getX()/60>=0&&e.getX()/60<Maps.map[0].length&&e.getY()/60>=0&&e.getY()/60<Maps.map.length*/){
            if (isMove()&&getPlayerOneTurnMoveTime()>0) {
                for (int i =0;i<canMoveorAttackPoint.length;i++){
                    for (int j =0;j<canMoveorAttackPoint[0].length;j++){
                        if (canMoveRanger[i][j]==1&&e.getY()/Global.CELL_SIZE ==canMoveorAttackPoint[i][j].x+maps.mapsY/Global.CELL_SIZE
                                &&e.getX() / Global.CELL_SIZE ==canMoveorAttackPoint[i][j].y+maps.mapsX/Global.CELL_SIZE){
                            if (isPlayerCanMove(e,playerObject,enemyObject,maps)==false){
                                int posX= e.getY()/Global.CELL_SIZE;
                                int posY= e.getX()/Global.CELL_SIZE;

                                if (screenY==posX){
                                    if (posY>screenX){
                                        face = faceeast;
                                    }else {
                                        face = facewest;
                                    }
                                }else if (screenX==posY){
                                    if (posX>screenY){
                                        face =facesouth;
                                    }else {
                                        face = facenorth;
                                    }
                                } else if (posX<screenY){
                                    if (posY>screenX){
                                        if (posY-screenX>screenY-posX){
                                            face = faceeast;
                                        }else {
                                            face =facenorth;
                                        }
                                    }else if (posY<screenX){
                                        if (screenX-posY>screenY-posX){
                                            face= facewest;
                                        }else {
                                            face =facenorth;
                                        }
                                    }
                                }else if (posX>screenY){
                                    if (posY>screenX){
                                        if (posY-screenX>posX-screenY){
                                            face =faceeast;
                                        }else {
                                            face =facesouth;
                                        }
                                    }else if (posY<screenX){
                                        if (screenX-posY>posX-screenY){
                                            face =facewest;
                                        }else {
                                            face =facesouth;
                                        }
                                    }
                                }
                                setY(getY()+(e.getX()/Global.CELL_SIZE -screenX));
                                setX(getX()+(e.getY()/Global.CELL_SIZE-screenY));
                                setMove(false);
                                setPlayerOneTurnMoveTime(getPlayerOneTurnMoveTime()-1);
                            }

                        }
                    }
                }
            }
            if (isAttack&&getPlayerOneTurnAttackTime()>0){
                isAttackFunction(e,gameStats,enemyObject,playerObject,maps);
            }
            if (isSeleted){
                if (e.getX()/Global.CELL_SIZE==screenX-1&&e.getY()/Global.CELL_SIZE==screenY+1){
                    setMove(true);
                    setSeleted(false);
                }else if (e.getX()/Global.CELL_SIZE==screenX+1&&e.getY()/Global.CELL_SIZE==screenY+1){
                    gameStats.NOWSTATS= gameStats.ENEMYTURN;
                    setSeleted(false);
                    setMove(false);
                    maps.setMsg(Maps.msgenum.enemyturn);
                    //JOptionPane.showMessageDialog(null,"敌人回合");
                }else if (e.getX()/Global.CELL_SIZE==screenX&&e.getY()/Global.CELL_SIZE==screenY+1){
                    setAttack(true);
                    setSeleted(false);
                }
            }
            playerObject.seletPlayer(e,maps);
        }
    }
    public boolean isCanAttackEnemy(EnemyObject enemyObject){
        for (int i =0;i<canMoveorAttackPoint.length;i++){
            for (int j =0;j<canMoveorAttackPoint[0].length;j++){
                if (canMoveorAttackPoint[i][j].x>minX&&canMoveorAttackPoint[i][j].y>minY
                        &&canMoveorAttackPoint[i][j].x<maxX&&canMoveorAttackPoint[i][j].y<maxY
                        &&canAttackRanger[i][j]==1){
                    for (int z=0; z<enemyObject.enemyLinked.size();z++){
                        if (canMoveorAttackPoint[i][j].x==enemyObject.enemyLinked.get(z).getX()&&
                                canMoveorAttackPoint[i][j].y==enemyObject.enemyLinked.get(z).getY()){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public void render(Graphics g,Maps maps,PlayerObject playerObject,EnemyObject enemyObject) {
        Image image1 = Toolkit.getDefaultToolkit().getImage("image/move.png");
        Image image2 = Toolkit.getDefaultToolkit().getImage("image/attack.png");
        Image image3 = Toolkit.getDefaultToolkit().getImage("image/over.png");


        if (isAttack()&&isCanAttackEnemy(enemyObject)&&getPlayerOneTurnAttackTime()>0){
            g.setColor(new Color(237, 67, 90,150));
            for (int i =0;i<canMoveorAttackPoint.length;i++){
                for (int j =0;j<canMoveorAttackPoint[0].length;j++){
                    if (canMoveorAttackPoint[i][j].x>minX&&canMoveorAttackPoint[i][j].y>minY
                            &&canMoveorAttackPoint[i][j].x<maxX&&canMoveorAttackPoint[i][j].y<maxY
                            &&canAttackRanger[i][j]==1){
                        g.fillRect(canMoveorAttackPoint[i][j].y*Global.CELL_SIZE+maps.mapsX,canMoveorAttackPoint[i][j].x*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE);
                    }
                }
            }
        }
        if (isSeleted){
            g.setColor(new Color(33, 18, 143,100));
            if (getPlayerOneTurnMoveTime()>0){
                g.fillRect((getY()-1)*Global.CELL_SIZE+maps.mapsX,(getX()+1)*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE);
                g.drawImage(image1,(getY()-1)*Global.CELL_SIZE+maps.mapsX,(getX()+1)*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE,null);
            }

            if (isCanAttackEnemy(enemyObject)&&getPlayerOneTurnAttackTime()>0){
                g.fillRect(getY()*Global.CELL_SIZE+maps.mapsX,(getX()+1)*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE);
                g.drawImage(image2,(getY())*Global.CELL_SIZE+maps.mapsX,(getX()+1)*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE,null);
            }
            g.fillRect((getY()+1)*Global.CELL_SIZE+maps.mapsX,(getX()+1)*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE);
            g.drawImage(image3,(getY()+1)*Global.CELL_SIZE+maps.mapsX,(getX()+1)*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE,null);
        }
        if (isMove&&getPlayerOneTurnMoveTime()>0){
            getMixorMaxAttactRanger(enemyObject);
            g.setColor(new Color(237, 67, 90,100));
            for (int i =0;i<canMoveorAttackPoint.length;i++){
                for (int j =0;j<canMoveorAttackPoint[0].length;j++){
                    if (canMoveorAttackPoint[i][j].x>minX&&canMoveorAttackPoint[i][j].y>minY
                            &&canMoveorAttackPoint[i][j].x<maxX&&canMoveorAttackPoint[i][j].y<maxY
                            &&canMoveRanger[i][j]==1&&playerObject.isHaveplayerInHere(canMoveorAttackPoint[i][j].x,canMoveorAttackPoint[i][j].y)==false
                            &&enemyObject.isHaveEnmeyInHere(canMoveorAttackPoint[i][j].x,canMoveorAttackPoint[i][j].y)==false){
                        g.fill3DRect(canMoveorAttackPoint[i][j].y*Global.CELL_SIZE+maps.mapsX,canMoveorAttackPoint[i][j].x*Global.CELL_SIZE+maps.mapsY,
                                Global.CELL_SIZE,Global.CELL_SIZE,true);
                    }
                }
            }
        }
        if (isShowHP()){
            g.setColor(Color.BLUE);
            g.fillRect(3*Global.CELL_SIZE,1*Global.CELL_SIZE,Global.CELL_SIZE,Global.CELL_SIZE);
            Image image = Toolkit.getDefaultToolkit().getImage(imagePath);
            g.drawImage(image,3*Global.CELL_SIZE,1*Global.CELL_SIZE,Global.CELL_SIZE,Global.CELL_SIZE,null);
            g.fill3DRect(4*Global.CELL_SIZE,1*Global.CELL_SIZE,6*Global.CELL_SIZE,Global.CELL_SIZE,true);
            g.setColor(Color.red);
            g.fill3DRect(4*Global.CELL_SIZE,1*Global.CELL_SIZE,6*getHP()*Global.CELL_SIZE,Global.CELL_SIZE,true);
        }
        if (true){
            g.setColor(color);
            Image image = Toolkit.getDefaultToolkit().getImage(imagePath);
            image.getHeight(null);
            image.getWidth(null);
            g.drawImage(image,y*Global.CELL_SIZE+maps.mapsX,x*Global.CELL_SIZE+maps.mapsY,
                    (y+1)*Global.CELL_SIZE+maps.mapsX,(x+1)*Global.CELL_SIZE+maps.mapsY,
                    image.getWidth(null)/4*(playermovestats),image.getHeight(null)/4*(face),
                    image.getWidth(null)/4*(playermovestats+1),image.getHeight(null)/4*(face+1),null);
        }

        if (getPlayerOneTurnMoveTime()<1){
            g.setColor(new Color(255, 202, 44,80));
            g.fill3DRect(getY()*Global.CELL_SIZE+maps.mapsX,getX()*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE,true);
        }
        if (getPlayerOneTurnAttackTime()<1){
            g.setColor(new Color(237, 67, 90,80));
            g.fill3DRect(getY()*Global.CELL_SIZE+maps.mapsX,getX()*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE,true);
        }
        if (getPlayerOneTurnMoveTime()<1&&getPlayerOneTurnAttackTime()<1){
            g.setColor(new Color(255, 0, 37,150));
            g.fill3DRect(getY()*Global.CELL_SIZE+maps.mapsX,getX()*Global.CELL_SIZE+maps.mapsY,Global.CELL_SIZE,Global.CELL_SIZE,true);
        }

    }

}
