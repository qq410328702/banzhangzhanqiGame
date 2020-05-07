import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class EnemyObject {
    LinkedList<Player> enemyLinked = new LinkedList<Player>();
    public void render(Graphics g,Maps maps,PlayerObject playerObject) {
        g.setColor(Color.red);
        for(int i = 0; i < enemyLinked.size(); i++){
            Player tempObject = enemyLinked.get(i);
            tempObject.render(g,maps,playerObject,this);
        }
    }

    public void tick() {
        for(int i = 0; i < enemyLinked.size(); i++){
            Player tempObject = enemyLinked.get(i);
             tempObject.tick();
        }
        getCurrentPlayer();
        isMonsterDeath();

    }
    public void isMonsterDeath(){
        for(int i = 0; i < enemyLinked.size(); i++){
            if (enemyLinked.get(i).getHP()<=0){
                enemyLinked.remove(i);
                getcurrentenemy =0;
                JOptionPane.showMessageDialog(null,"Monster Death");
            }
        }
    }
    public void enemyMove(Maps maps,GameStats gameStats,java.awt.event.MouseEvent e,PlayerObject playerObject ,EnemyObject enemyObject,Thread thread) throws InterruptedException {
        for(int i = 0; i < enemyLinked.size(); i++){
            Player tempObject = enemyLinked.get(i);
            tempObject.enemyMove(maps,playerObject,enemyObject);
            //Thread.sleep(1000);
        }
        gameStats.NOWSTATS= gameStats.PLAYERTURN;
        maps.setMsg(Maps.msgenum.playerturn);
        Thread.sleep(2000);
        maps.setMsg(Maps.msgenum.nothing);
        for (int i=0; i<playerObject.playerLinked.size();i++){
            playerObject.playerLinked.get(i).resetPlayerOneTurnStats();
        }
        //JOptionPane.showMessageDialog(null,"玩家的回合");
    }
    public int getcurrentenemy=0;
    public void   getCurrentPlayer(){
        for (int i=0;i< enemyLinked.size();i++){
            if (enemyLinked.get(i).isSeleted()){
                getcurrentenemy =i;
            }
        }
        if (getcurrentenemy>enemyLinked.size()-1){
            getcurrentenemy = enemyLinked.size();
        }
        if (getcurrentenemy<0){
            getcurrentenemy = 0;
        }
    }
    public boolean isHaveEnmeyInHereMouseE(java.awt.event.MouseEvent e,Maps maps){
        for (int i=0;i<enemyLinked.size();i++){
            if (e.getY()/Global.CELL_SIZE==enemyLinked.get(i).getX()+maps.mapsY&&
                    e.getX()/Global.CELL_SIZE==enemyLinked.get(i).getY()+maps.mapsX){

                    enemyLinked.get(i).setHP(enemyLinked.get(i).getHP()-10);
                    System.out.println("attack");

                return true;
            }
        }
        return false;
    }
    public boolean isHaveEnmeyInHere(int x,int y){
        for (int i=0;i<enemyLinked.size();i++){
            if (x==enemyLinked.get(i).getX()&&y==enemyLinked.get(i).getY()){
                return true;
            }
        }
        return false;
    }
    public void addPlayer(Player object){
        this.enemyLinked.add(object);
    }
    public void removePlayer(Player object){
        this.enemyLinked.remove(object);
    }
}

