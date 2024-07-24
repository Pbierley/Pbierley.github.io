public class Unemployed extends People{
    static int unemployedCount = 5;
    public static int getCount() {
        return unemployedCount;
    }

    public static void setUnemployedCount(int changeAmount) {
        unemployedCount = unemployedCount + changeAmount;
    }

    public static int createNew(){
        People.increaseCount();
        unemployedCount++;
        return unemployedCount;
    }
    public static int employCitizen(){
        unemployedCount--;
        return unemployedCount;
    }
}
