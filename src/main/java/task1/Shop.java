package task1;

import java.util.*;

public class Shop {
    Buyer buyer = new Buyer(this);
    private List<Car> cars = new ArrayList<>();
    public final int ASSEMBLY_CAR = 500;
    public final int TIMEOUT = 500;


    public Car buyCar() {
        return buyer.buyCar();
    }

    public void acceptCar() {
        while(!buyer.check) {
            buyer.receiveCar();
            buyer.countProducer++;
            buyer.isCancel();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
