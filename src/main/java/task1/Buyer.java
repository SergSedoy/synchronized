package task1;

public class Buyer {
    private Shop shop;
    public static boolean check = false;
    public static int countProducer;

    public Buyer(Shop shop) {
        this.shop = shop;
    }

    public void isCancel() {
        if (countProducer == 10) {
            check = true;
        }
    }


    public synchronized void receiveCar() {
        try {
            System.out.println("Производитель: идет сборка машины");
            Thread.sleep(shop.ASSEMBLY_CAR);
            shop.getCars().add(new Car());
            System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car buyCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getCars().size() == 0) {
                System.out.println(Thread.currentThread().getName() + " авто нет!");
                wait();
            }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
            Thread.sleep(shop.TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return shop.getCars().remove(0);
    }
}
