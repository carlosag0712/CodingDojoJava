package codingDojo.JAVA_OOP.ObjectMaster_PartOne;

public class HumanTest {
    public static void main(String[] args) {

        Human ninja = new Ninja();
        Wizard wizard = new Wizard();
        Samurai samurai = new Samurai();


        ninja.attack(wizard);
        samurai.attack(wizard);


    }
}
