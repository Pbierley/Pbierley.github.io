public class land extends Storage{
    private static int land = 100;
    public static int getLand() {
        return land;
    }
    public static int setLand(int num) {
        land+= num;
        return land;
    }
}
