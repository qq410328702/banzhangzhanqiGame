
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;

public class AStar {
    private AStarMap aMap = new AStarMap();
    private int[][] aStarMap ;

    @Override
    public String toString() {
        return "AStar{" +
                "aStarMap=" + Arrays.toString(aStarMap) +
                '}';
    }

    private LinkedList<AStarStruct>  openList = new LinkedList<AStarStruct>();
    private LinkedList<AStarStruct>  closeList = new LinkedList<AStarStruct>();
    private AStarStruct startPoint = new AStarStruct();
    private AStarStruct endPoint= new AStarStruct();



    public LinkedList<AStarStruct> AStartest(int enemyX,int enemY,int playerX,int playerY,PlayerObject playerObject ,EnemyObject enemyObject){
        aStarMap = aMap.getAStarMap(playerObject,enemyObject);
        aStarMap[playerY][playerX]=1;

        startPoint.setX(enemyX);
        startPoint.setY(enemY);
        startPoint.setH(0);
        startPoint.setParentPoint(null);
        endPoint.setX(playerX);
        endPoint.setY(playerY);
        openList.add(startPoint);
        int maxCloseListSize = aStarMap.length*aStarMap[0].length-openList.size()-playerObject.playerLinked.size()-enemyObject.enemyLinked.size();
        while (getGValue(startPoint.getX(),startPoint.getY(),endPoint.getX(),endPoint.getY())!=0&&maxCloseListSize>closeList.size()) {
            if (startPoint.getX()+1<aStarMap[0].length&&aStarMap[startPoint.getY()][startPoint.getX()+1]==1&&
                    notInCloseList(startPoint.getX()+1,startPoint.getY())
                    &&notInOpenList(startPoint.getX()+1,startPoint.getY())){
                AStarStruct tempPoint = new AStarStruct();
                tempPoint.setX(startPoint.getX()+1);
                tempPoint.setY(startPoint.getY());
                tempPoint.setH(startPoint.getH()+1);
                tempPoint.setParentPoint(new Point(startPoint.getX(),startPoint.getY()));
                tempPoint.setG(getGValue(tempPoint.getX(),tempPoint.getY(),endPoint.getX(),endPoint.getY()));
                tempPoint.setF(tempPoint.getH()+tempPoint.getG());
                openList.add(tempPoint);
               // System.out.println("[startPoint.getY()][startPoint.getX()+1]");
            }
            if (startPoint.getX()-1>=0&&aStarMap[startPoint.getY()][startPoint.getX()-1]==1&&
                    notInCloseList(startPoint.getX()-1,startPoint.getY())
                    &&notInOpenList(startPoint.getX()-1,startPoint.getY())){
                AStarStruct tempPoint = new AStarStruct();
                tempPoint.setX(startPoint.getX()-1);
                tempPoint.setY(startPoint.getY());
                tempPoint.setH(startPoint.getH()+1);
                tempPoint.setParentPoint(new Point(startPoint.getX(),startPoint.getY()));
                tempPoint.setG(getGValue(tempPoint.getX(),tempPoint.getY(),endPoint.getX(),endPoint.getY()));
                tempPoint.setF(tempPoint.getH()+tempPoint.getG());
                openList.add(tempPoint);
                //System.out.println("[startPoint.getY()][startPoint.getX()-1]");
            }
            if (startPoint.getY()+1<aStarMap.length&&aStarMap[startPoint.getY()+1][startPoint.getX()]==1&&
                    notInCloseList(startPoint.getX(),startPoint.getY()+1)
                    &&notInOpenList(startPoint.getX(),startPoint.getY()+1)){
                AStarStruct tempPoint = new AStarStruct();
                tempPoint.setX(startPoint.getX());
                tempPoint.setY(startPoint.getY()+1);
                tempPoint.setH(startPoint.getH()+1);
                tempPoint.setParentPoint(new Point(startPoint.getX(),startPoint.getY()));
                tempPoint.setG(getGValue(tempPoint.getX(),tempPoint.getY(),endPoint.getX(),endPoint.getY()));
                tempPoint.setF(tempPoint.getH()+tempPoint.getG());
                openList.add(tempPoint);
                //System.out.println("[startPoint.getY()+1][startPoint.getX()]");
            }
            if (startPoint.getY()-1>=0&&aStarMap[startPoint.getY()-1][startPoint.getX()]==1&&
                    notInCloseList(startPoint.getX(),startPoint.getY()-1)
                    &&notInOpenList(startPoint.getX(),startPoint.getY()-1)){
                AStarStruct tempPoint = new AStarStruct();
                tempPoint.setX(startPoint.getX());
                tempPoint.setY(startPoint.getY()-1);
                tempPoint.setH(startPoint.getH()+1);
                tempPoint.setParentPoint(new Point(startPoint.getX(),startPoint.getY()));
                tempPoint.setG(getGValue(tempPoint.getX(),tempPoint.getY(),endPoint.getX(),endPoint.getY()));
                tempPoint.setF(tempPoint.getH()+tempPoint.getG());
                openList.add(tempPoint);
                //System.out.println("[startPoint.getY()-1][startPoint.getX()]");
            }
            closeList.add(startPoint);

            for (int i=0;i<openList.size();i++){
                if (openList.get(i).equals(startPoint)){
                    //System.out.println("openList.remove:"+i+openList.get(i).toString());
                    openList.remove(i);
                }
            }

            int tempf=999;
            for (int i=0;i<openList.size();i++){

                if (openList.get(i).getF()<tempf){
                    tempf= openList.get(i).getF();
                    startPoint =openList.get(i);
                   // System.out.println("tempf:"+tempf);
                }

            }
            //System.out.println(startPoint.toString());
        }
        System.out.println("###################################");
        LinkedList<AStarStruct> shortWay = new LinkedList<AStarStruct>();
        while (startPoint.getF()>=1){
            for (int i =0;i<closeList.size();i++){
                if (startPoint.getF()>=1){
                    if (closeList.get(i).getX()==startPoint.getParentPoint().getX()&&
                            closeList.get(i).getY()==startPoint.getParentPoint().getY()){

                        startPoint = closeList.get(i);
                        shortWay.add(startPoint);

                        System.out.println("openList"+startPoint.toString());
                    }
                }
            }
        }
        System.out.println("###################################");
        return  shortWay;
    }
    private int getGValue(int startX,int startY,int endX,int endY){
        return Math.abs(endX-startX)+Math.abs(endY-startY);
    }
    private boolean notInCloseList(int jugeX,int jugeY){
        boolean notInCloseList =true;
        for (int i =0;i<closeList.size();i++){
            if (closeList.get(i).getX()==jugeX&&closeList.get(i).getY()==jugeY){
                notInCloseList=  false;
            }
        }
        return notInCloseList;
    }
    private boolean notInOpenList(int jugeX,int jugeY){
        boolean notInCloseList =true;
        for (int i =0;i<openList.size();i++){
            if (openList.get(i).getX()==jugeX&&openList.get(i).getY()==jugeY){
                notInCloseList=  false;
            }
        }
        return notInCloseList;
    }
}
