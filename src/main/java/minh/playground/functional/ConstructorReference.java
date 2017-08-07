package minh.playground.functional;

public class ConstructorReference {

    public static void main(String[] args) {
        PersonFactory factory = (firstName, lastName) -> new Person(firstName, lastName);

        System.out.println(factory.create("John", "Doe").toString());

        PersonFactory f1 = Person::new;
        System.out.println(f1.create("Johana", "Doe").toString());
    }

    interface PersonFactory {
        Person create (String firstName, String lastName);
    }

    static class Person {
        String firstName;
        String lastName;

        Person() {}

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }
}
