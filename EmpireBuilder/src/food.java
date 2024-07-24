import java.rmi.activation.ActivationGroup_Stub;

public class food extends Resources{
    public static int foodAmount = 50;
    public static int foodStorage = 100;
    static int getFoodStorage(){
        return foodStorage;
    }
    static void setFoodStorage(int changeAmount){
        foodStorage = foodStorage + changeAmount;
    }

    static int getFood(){
        return foodAmount;
    }
    static int setFood(int changeAmount){
        foodAmount = foodAmount + changeAmount;
        return foodAmount;
    }

}
