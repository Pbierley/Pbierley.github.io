public class House extends Storage{
    private static int housingSpace = 5;

    public static int getHousingSpace() {
        return housingSpace;
    }
    public static void addHousingSpace(int amount){
        housingSpace = housingSpace + amount;
    }
}
