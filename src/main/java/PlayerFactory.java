import java.awt.*;

public class PlayerFactory {
    public Player getPlayerType3(Point point){
        Player tempPlayer = new Player(point.x,point.y,Color.magenta, "image/哆啦A梦/哆啦美.png");
        tempPlayer.setMoveType(2);
        tempPlayer.setAttackType(2);
        return  tempPlayer;
    }
    public Player getPlayerType4(Point point){
        Player tempPlayer = new Player(point.x,point.y,Color.magenta, "image/哆啦A梦/哆啦美.png");
        tempPlayer.setMoveType(3);
        tempPlayer.setAttackType(3);
        return  tempPlayer;
    }
    public Player getPlayerType5(Point point){
        Player tempPlayer = new Player(point.x,point.y,Color.magenta, "image/哆啦A梦/哆啦美.png");
        tempPlayer.setMoveType(4);
        tempPlayer.setAttackType(4);
        return  tempPlayer;
    }
}
