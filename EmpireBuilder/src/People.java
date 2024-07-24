public class People {
    static int count = 5;
    static int foodComsumption = count;
    static int foodChange = Farmer.getTotalRate() - foodComsumption;

    //used to get the total change + or - for an interval for food
    public static int getFoodChange() {
        foodChange = Farmer.getTotalRate() - foodComsumption;
        return foodChange;
    }
    public static int getFoodComsumption(){
        foodComsumption = count;
        return foodComsumption;
    }
    public static void eat(){
        food.setFood(-foodComsumption);
    }
    public static int increaseCount(){
        count++;
        foodComsumption = count;
        return count;
    }

    public static int getCount() {
        return count;
    }
    static void gatherResources(){
        // foodNum either outputs the total food produced for that interval or the max storage
        int foodNum = Storage.storageChecker(food.getFood(), Farmer.getTotalRate(), food.getFoodStorage(), People.getFoodComsumption());
        System.out.println("foodnum" +foodNum);
        if (count > 0 && 0 > food.setFood(foodNum)) {
            starveCitizen();
        }
        stone.setStone(gatherStone());
        wood.setWood(gatherWood());
    }
    public static int gatherStone(){
        if (stone.getStone() + Miner.getTotalRate() > stone.getStoneStorage()){
            return stone.getStoneStorage() - stone.getStone();
        }
        else {
            return Miner.getTotalRate();
        }
    }
    public static int gatherWood() {
        if (wood.getWood() + Lumberjack.getTotalRate() > wood.getWoodStorage()) {
            return wood.getWoodStorage() - wood.getWood();
        } else {
            return Lumberjack.getTotalRate();
        }
    }
    public static void starveCitizen(){
        count--;
        if (Unemployed.getCount() > 0) {
            Unemployed.setUnemployedCount(-1);
        } else if (Farmer.getCount() > 0) {
            Farmer.setFarmerCount(-1);
        } else if (Miner.getCount() > 0) {
            Miner.setMinerCount(-1);
        } else if (Lumberjack.getCount() > 0) {
            Lumberjack.setLumberjackCount(-1);
        }
    }
}
