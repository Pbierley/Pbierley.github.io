public class Storage {
    public static int storageChecker(int count, int increaseAmount, int storage, int consumption){
        if (count + increaseAmount - consumption > storage){
            if(count - consumption > storage) {
                return storage - count + People.getFoodComsumption();
            }
            else if (count + increaseAmount > storage) {
                return storage - count + People.getFoodComsumption();
            }
            {
                return increaseAmount;
            }
        }
        else if (count + increaseAmount == storage) {
            return increaseAmount;

        } else
        {
            return increaseAmount;
        }
    }
}
