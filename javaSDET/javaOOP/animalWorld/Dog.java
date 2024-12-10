package javaOOP.animalWorld;

public class Dog extends Annimals {
    public static void main(String[] args) {
        Dog dog = new Dog();

        System.out.println("Age : "+dog.animalAge);

        dog.setAnnimalName("Husky");
        System.out.println("Name : "+dog.getAnnimalName());
    }
}
