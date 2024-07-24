public class Multithread extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < i + 10; i++) {
            System.out.println(i);
            People.gatherResources();
            People.eat();
            Main.updateResources();
            System.out.println(food.getFood());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
