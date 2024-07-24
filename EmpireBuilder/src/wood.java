public class wood extends Resources{
    public static int woodAmount = 100;
    public static int woodStorage = 100;

    static int getWood(){
        return woodAmount;
    }
    static void setWood(int changeAmount){
        woodAmount = woodAmount + changeAmount;
    }
    static int getWoodStorage(){
        return woodStorage;
    }
    static int setWoodStorage(int changeAmount){
        woodStorage += changeAmount;
        return woodStorage;
    }
}
