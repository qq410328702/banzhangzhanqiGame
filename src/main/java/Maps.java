import java.awt.*;

public class Maps {
    static int map[][] = {
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},//1
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//2
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//3
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//4
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//5
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
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//56
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//57
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//58
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},//59
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}//60
    };
    public  enum msgenum{
        nothing,
        playerturn ,
        enemyturn,
        playerAttck,
        enemyAttck,
        playerDeath,
        monsterDeath,
    }
    public int mapsWidth = map[0].length*Global.CELL_SIZE;
    public  int mapsHight = map.length*Global.CELL_SIZE;
    public int mapsX;
    public int mapsY;
    public  int stageWidth = Global.GAMEWIDTH;
    public  int stageHight = Global.GAMEHEIGHT;

    public static int[][] getMap() {
        return map;
    }

    private msgenum msg = msgenum.nothing;

    public msgenum getMsg() {
        return msg;
    }

    public void setMsg(msgenum msg) {
        this.msg = msg;
    }

    public void render(Graphics g, PlayerObject playerObject, EnemyObject enemyObject, GameStats gameStats) {
        if (gameStats.NOWSTATS==gameStats.PLAYERTURN){
            if (playerObject.playerLinked.get(playerObject.getcurrentplayer).getX()*Global.CELL_SIZE<=stageHight/2){
                mapsY=0;
            }else if (playerObject.playerLinked.get(playerObject.getcurrentplayer).getX()*Global.CELL_SIZE>=mapsHight-stageHight/2){
                mapsY= stageHight-mapsHight;
            }else {
                mapsY= stageHight/2-playerObject.playerLinked.get(playerObject.getcurrentplayer).getX()*Global.CELL_SIZE;
            }
            if (playerObject.playerLinked.get(playerObject.getcurrentplayer).getY()*Global.CELL_SIZE<=stageWidth/2){
                mapsX=0;
            }else if (playerObject.playerLinked.get(playerObject.getcurrentplayer).getY()*Global.CELL_SIZE>=mapsWidth-stageWidth/2){
                mapsX= stageWidth-mapsWidth;
            }else {
                mapsX= stageWidth/2-playerObject.playerLinked.get(playerObject.getcurrentplayer).getY()*Global.CELL_SIZE;
            }
        }else if (gameStats.NOWSTATS==gameStats.ENEMYTURN){
            if (enemyObject.enemyLinked.get(enemyObject.getcurrentenemy).getX()*Global.CELL_SIZE<=stageHight/2){
                mapsY=0;
            }else if (enemyObject.enemyLinked.get(enemyObject.getcurrentenemy).getX()*Global.CELL_SIZE>=mapsHight-stageHight/2){
                mapsY= stageHight-mapsHight;
            }else {
                mapsY= stageHight/2-enemyObject.enemyLinked.get(enemyObject.getcurrentenemy).getX()*Global.CELL_SIZE;
            }
            if (enemyObject.enemyLinked.get(enemyObject.getcurrentenemy).getY()*Global.CELL_SIZE<=stageWidth/2){
                mapsX=0;
            }else if (enemyObject.enemyLinked.get(enemyObject.getcurrentenemy).getY()*Global.CELL_SIZE>=mapsWidth-stageWidth/2){
                mapsX= stageWidth-mapsWidth;
            }else {
                mapsX= stageWidth/2-enemyObject.enemyLinked.get(enemyObject.getcurrentenemy).getY()*Global.CELL_SIZE;
            }

        }

        for (int i=0;i<map.length;i++){
            for (int j= 0;j<map[i].length;j++)
                if (map[i][j]==1){
                    g.setColor(Color.GREEN);
                    g.fill3DRect(mapsX+j*Global.CELL_SIZE,
                            mapsY+i*Global.CELL_SIZE,
                            Global.CELL_SIZE,Global.CELL_SIZE,true);
                    Image image = Toolkit.getDefaultToolkit().getImage("image/地图/冰水深明星.png");
                    g.drawImage(image,mapsX+j*Global.CELL_SIZE,
                            mapsY+i*Global.CELL_SIZE,
                            Global.CELL_SIZE,Global.CELL_SIZE,null);
                }else if (map[i][j]==2){
                    g.setColor(Color.red);
                    g.fill3DRect(mapsX+j*Global.CELL_SIZE,
                            mapsY+i*Global.CELL_SIZE,
                            Global.CELL_SIZE,Global.CELL_SIZE,true);
                    Image image = Toolkit.getDefaultToolkit().getImage("image/地图/金属圆角.png");
                    g.drawImage(image,mapsX+j*Global.CELL_SIZE,
                            mapsY+i*Global.CELL_SIZE,
                            Global.CELL_SIZE,Global.CELL_SIZE,null);
                }
        }
        Player tempPlayer=null;
        if (gameStats.NOWSTATS==gameStats.PLAYERTURN){
            tempPlayer =playerObject.playerLinked.get(playerObject.getcurrentplayer);
        }else if (gameStats.NOWSTATS==gameStats.ENEMYTURN){
            tempPlayer =enemyObject.enemyLinked.get(enemyObject.getcurrentenemy);
        }
        g.setColor(Color.ORANGE);
        g.fill3DRect(0,0,Global.CELL_SIZE*3,Global.CELL_SIZE,true);
        Font font = new Font("宋体",Font.BOLD,30);
        g.setFont(font);
        g.drawImage(tempPlayer.getImageFace(),0,0,Global.CELL_SIZE,Global.CELL_SIZE,null);
        g.setColor(Color.red);
        g.drawString("姓名："+tempPlayer.getName(),90,30);
        g.drawString("HP:"+tempPlayer.getHP()+"/"+tempPlayer.getMaxHP(),90,60);
        if (getMsg()==msgenum.playerturn){
            g.setColor(Color.ORANGE);
            Image msg = Toolkit.getDefaultToolkit().getImage("image/地图/msg.png");
            Font font1 = new Font("宋体",Font.BOLD,msg.getHeight(null)/2);
            g.setFont(font1);
            g.drawImage(msg,0,Global.GAMEHEIGHT-msg.getHeight(null)-Global.CELL_SIZE/2+30,Global.GAMEWIDTH,msg.getHeight(null),null);
            g.drawString("玩家的回合",Global.CELL_SIZE*2,Global.GAMEHEIGHT-msg.getHeight(null)/2-20+30);
        }else
        if (getMsg()==msgenum.enemyturn){
            g.setColor(Color.ORANGE);
            Image msg = Toolkit.getDefaultToolkit().getImage("image/地图/msg.png");
            Font font1 = new Font("宋体",Font.BOLD,msg.getHeight(null)/2);
            g.setFont(font1);
            g.drawImage(msg,0,Global.GAMEHEIGHT-msg.getHeight(null)-Global.CELL_SIZE/2+30,Global.GAMEWIDTH,msg.getHeight(null),null);
            g.drawString("敌人的回合",Global.CELL_SIZE*2,Global.GAMEHEIGHT-msg.getHeight(null)/2-20+30);
        }else
        if (getMsg()==msgenum.enemyAttck){
            g.setColor(Color.ORANGE);
            Image msg = Toolkit.getDefaultToolkit().getImage("image/地图/msg.png");
            Font font1 = new Font("宋体",Font.BOLD,msg.getHeight(null)/2);
            g.setFont(font1);
            g.drawImage(msg,0,Global.GAMEHEIGHT-msg.getHeight(null)-Global.CELL_SIZE/2+30,Global.GAMEWIDTH,msg.getHeight(null),null);
            g.drawString("敌人的攻击:"+playerObject.playerLinked.get(playerObject.getcurrentplayer).getName(),Global.CELL_SIZE*2,Global.GAMEHEIGHT-msg.getHeight(null)/2-20+30);
        }else
        if (getMsg()==msgenum.playerAttck){
            g.setColor(Color.ORANGE);
            Image msg = Toolkit.getDefaultToolkit().getImage("image/地图/msg.png");
            Font font1 = new Font("宋体",Font.BOLD,msg.getHeight(null)/2);
            g.setFont(font1);
            g.drawImage(msg,0,Global.GAMEHEIGHT-msg.getHeight(null)-Global.CELL_SIZE/2+30,Global.GAMEWIDTH,msg.getHeight(null),null);
            g.drawString("玩家的攻击:"+enemyObject.enemyLinked.get(enemyObject.getcurrentenemy).getName(),Global.CELL_SIZE*2,Global.GAMEHEIGHT-msg.getHeight(null)/2-20+30);

        }

    }
}
