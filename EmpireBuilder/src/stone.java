public class stone extends Resources{
    public static int stoneAmount = 100;
    public static int stoneStorage = 100;
    static int getStone(){
        return stoneAmount;
    }
    static void setStone(int changeAmount){
        stoneAmount = stoneAmount + changeAmount;
    }

    public static int getStoneStorage() {
        return stoneStorage;
    }

    public static void setStoneStorage(int change) {
        stoneStorage +=  change;
    }
}
