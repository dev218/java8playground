package minh.test.method.reference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Car {

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car anotherCar) {
        System.out.println("Collide to " + anotherCar.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public void follow(final Car anotherCar) {
        System.out.println(this.toString() + " following " + anotherCar.toString());
    }

    public static void main(String[] args) {
        Car car = Car.create(Car::new);

        System.out.println(car.toString());

        List<Car> cars = Arrays.asList(car, Car.create(Car::new));

        // reference to static method
        cars.forEach(Car::collide);

        // reference to instance method of arbitrary object
        cars.forEach(Car::repair);

        // reference to instance method of particular class instance the syntax instance::method
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);
    }
}
