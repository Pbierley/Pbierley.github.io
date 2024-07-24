public class Lumberjack extends People{
    static int lumberjackCount = 0;
    static int lumberjackRate = 2;
    static int totalRate = lumberjackRate * lumberjackCount;
    public static int getCount() {
        return lumberjackCount;
    }

    public static void setLumberjackCount(int changeAmount) {
        lumberjackCount = lumberjackCount + changeAmount;
    }

    public static int createNew(){
        return lumberjackCount++;
    }
    public static int getRate(){return lumberjackRate;}
    public static int getTotalRate(){
        return lumberjackRate * lumberjackCount;
    }
}
