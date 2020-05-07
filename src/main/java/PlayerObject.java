import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class PlayerObject {
    LinkedList<Player> playerLinked = new LinkedList<Player>();
    public void render(Graphics g,Maps maps,EnemyObject enemyObject) {
        g.setColor(Color.red);
        for(int i = 0; i < playerLinked.size(); i++){
            Player tempObject = playerLinked.get(i);
            tempObject.render(g,maps,this,enemyObject);
        }
    }

    public void tick() {
        for(int i = 0; i < playerLinked.size(); i++){
            Player tempObject = playerLinked.get(i);
             tempObject.tick();
        }
        isPlayerDeath();
        getCurrentPlayer();
    }
    public void playerMove(java.awt.event.MouseEvent e,GameStats gameStats,PlayerObject playerObject,EnemyObject enemyObject,Maps maps) {
        for(int i = 0; i < playerLinked.size(); i++){
            Player tempObject = playerLinked.get(i);
            tempObject.playMove(e,gameStats,playerObject,enemyObject,maps);
        }
    }
    public void isPlayerDeath(){
        for(int i = 0; i < playerLinked.size(); i++){
            if (playerLinked.get(i).getHP()<=0){
                playerLinked.remove(i);
                getcurrentplayer=0;
                //JOptionPane.showMessageDialog(null,"Player Death");
            }
        }
    }
    public boolean isHavePlayerBeingSelected(){
        for (int i=0;i<playerLinked.size();i++){
            if (playerLinked.get(i).isSeleted()||playerLinked.get(i).isAttack()||playerLinked.get(i).isMove()){
                return true;
            }
        }
        return false;
    }
    public void seletPlayer(java.awt.event.MouseEvent e,Maps maps){
//        if (e.getX()/Global.CELL_SIZE==playerLinked.get(getcurrentplayer).getY()+maps.mapsX/Global.CELL_SIZE&&
//                e.getY()/Global.CELL_SIZE==playerLinked.get(getcurrentplayer).getX()+maps.mapsY/Global.CELL_SIZE){
//            if (playerLinked.get(getcurrentplayer).isSeleted()){
//                playerLinked.get(getcurrentplayer).setSeleted(false);
//            }else {
//                playerLinked.get(getcurrentplayer).setMove(false);
//                playerLinked.get(getcurrentplayer).setAttack(false);
//                playerLinked.get(getcurrentplayer).setSeleted(true);
//            }
//        }else{
//            for (int i=0;i<playerLinked.size();i++){
//            if (e.getX()/Global.CELL_SIZE==playerLinked.get(i).getY()+maps.mapsX/Global.CELL_SIZE&&
//                    e.getY()/Global.CELL_SIZE==playerLinked.get(i).getX()+maps.mapsY/Global.CELL_SIZE){
//                for (int z= 0;z<playerLinked.size();z++){
//                    playerLinked.get(z).setSeleted(false);
//                    playerLinked.get(z).setMove(false);
//                    playerLinked.get(z).setAttack(false);
//                    }
//                   getcurrentplayer=i;
//                   playerLinked.get(getcurrentplayer).setSeleted(true);
//                   break;
//            }
//          }
//        }

        for (int i=0;i<playerLinked.size();i++){
            if (e.getX()/Global.CELL_SIZE==playerLinked.get(i).getY()+maps.mapsX/Global.CELL_SIZE&&
                    e.getY()/Global.CELL_SIZE==playerLinked.get(i).getX()+maps.mapsY/Global.CELL_SIZE){
                if (playerLinked.get(i).isSeleted()){
                    playerLinked.get(i).setSeleted(false);
                    break;
                }
                if (isHavePlayerBeingSelected()==false&&playerLinked.get(i).isSeleted()==false){
                    playerLinked.get(i).setSeleted(true);
                    break;
                }
            }
        }
    }
    public boolean isHaveplayerInHereMouseE(java.awt.event.MouseEvent e,Maps maps){
        for (int i=0;i<playerLinked.size();i++){
            if (e.getY()/Global.CELL_SIZE==playerLinked.get(i).getX()+maps.mapsY&&
                    e.getX()/Global.CELL_SIZE==playerLinked.get(i).getY()+maps.mapsX){
                return true;
            }
        }
        return false;
    }
    public boolean isHaveplayerInHere(int x,int y){
        for (int i=0;i<playerLinked.size();i++){
            if (x==playerLinked.get(i).getX()&&y==playerLinked.get(i).getY()){
                return true;
            }
        }
        return false;
    }
    public  int getcurrentplayer=0;
    public void   getCurrentPlayer(){
        for (int i=0;i< playerLinked.size();i++){
            if (playerLinked.get(i).isSeleted()){
                getcurrentplayer =i;
            }
        }
    }
    public void addPlayer(Player object){
        this.playerLinked.add(object);
    }
    public void removePlayer(Player object){
        this.playerLinked.remove(object);
    }
}

