public class Miner extends People{
    static int minerCount = 0;
    static int minerRate = 2;
    public static int getCount() {
        return minerCount;
    }

    public static void setMinerCount(int changeAmount) {
        minerCount = minerCount + changeAmount;
    }

    public static int createNew(){
        minerCount++;
        return minerCount;
    }
    public static int getRate(){
        return minerRate;
    }
    public static int getTotalRate(){
        return minerRate * minerCount;
    }
}
