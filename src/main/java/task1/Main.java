package task1;

public class Main {
    public static void main(String[] args) {
        final Shop shop = new Shop();

        for (int i = 0; i < 5; i++) {
            new Thread(null, shop::buyCar, "Vasya").start();
            new Thread(null, shop::buyCar, "Oleg").start();
        }

        new Thread(null, shop::acceptCar, "Toyota").start();
    }
}
