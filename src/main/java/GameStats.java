public class GameStats {
    public int PLAYERTURN = 0;
    public int ENEMYTURN= 1;
    public int NOWSTATS ;

    public GameStats() {
        setNOWSTATS(PLAYERTURN);
    }

    public int getNOWSTATS() {
        return NOWSTATS;
    }

    public void setNOWSTATS(int NOWSTATS) {
        this.NOWSTATS = NOWSTATS;
    }
}
