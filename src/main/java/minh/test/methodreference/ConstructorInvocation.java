package minh.test.methodreference;

import java.util.function.Supplier;

public class ConstructorInvocation {
    public static void main(String[] args) {
        DogFactory generator = Dog::new;
        Dog dog = generator.create("Fulffy");
        System.out.println(dog.name);

        Supplier<Dog> dogSupplier = Dog::new;
        Dog otherDog = dogSupplier.get();
        System.out.println(otherDog.name);
    }
}

class Dog {
    String name;

    public Dog() {
        name = "Alpha Dog";
    }

    public Dog(String name) {
        this.name = name;
    }
}

@FunctionalInterface
interface DogFactory<D extends Dog> {
    D create(String name);
}