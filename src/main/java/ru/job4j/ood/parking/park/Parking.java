package ru.job4j.ood.parking.park;
public class Parking extends AbstractParking {
    public Parking(int sizeForPassenger, int sizeForCargo) {
        super(sizeForPassenger, sizeForCargo);
    }
}
/*класс наследует класс AbstractParking и вызывает его конструктор*/