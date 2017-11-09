package codingDojo.JAVA_OOP.ZooKeeperII;

import codingDojo.JAVA_OOP.ZooKeeper.Mammal;

public class Dragon extends Mammal {

    public Dragon(){
        this.energyLevel = 300;
    }

    public void fly(){
        System.out.println("Dragon is flying");
        this.energyLevel -= 50;

    }

    public void eatHumans(){
        System.out.println("Dragon ate human");
        this.energyLevel -= 25;

    }

    public void attackTown(){
        System.out.println("Dragon attacking town");
        this.energyLevel -= 100;

    }
}
