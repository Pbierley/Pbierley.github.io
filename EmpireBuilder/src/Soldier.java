public class Soldier extends People{
    static int soldierCount = 10;
    static int enemyArmySize = 10;
    static int winningsMultiplier = 100;
    public static int getEnemyArmySize(){
        return enemyArmySize;
    }
    public static void incEnemyArmySize(){
        enemyArmySize = enemyArmySize * 2;
    }
    public static int getCount() {
        return soldierCount;
    }

    public static void createNew() {
        Soldier.soldierCount++;
    }
    public static void changeArmySize(int changeAmount){
        soldierCount = soldierCount + changeAmount;
    }

    public static int getWinningsMultiplier() {
        return winningsMultiplier;
    }

    public static void incWinningsMultiplier() {
        winningsMultiplier = winningsMultiplier * 2;
    }
}
