public class Farmer extends People{
    private static int farmerCount = 0;
    static int farmerRate = 2;
    static int totalRate = farmerCount * farmerRate;

    public static void setFarmerCount(int changeAmount) {
        farmerCount = farmerCount + changeAmount;
    }

    public static int getCount() {
        return farmerCount;
    }
    public static int createNew(){
        farmerCount++;
        return farmerCount;
    }
    public static int getRate(){
        return farmerRate;
    }
    //returns total amount being harvested every interval
    public static int getTotalRate(){
        totalRate = farmerCount * farmerRate;
        return totalRate;
    }

}
