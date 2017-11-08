package codingDojo.JAVA_OOP.ObjectMaster_PartTwo;

//The Samurai class should have a default health of 200; a method called deathBlow that attacks an object and decreases
// its health to 0, but also halves the Samurai's health; a method called meditate which heals the Samurai back to full
// health; and a method called howMany that returns the current number of Samurai.



public class Samurai extends Human {

    public static int samuraiCount;

    public Samurai(){
        this.health = 200;
        this.name = "Samurai";
        samuraiCount++;

    }

    public void deathBlow(Human human){


        if(this.health >=1){
            human.health = 0;
            this.health = (this.health/2);
            System.out.println(human.name+" health is now "+ human.health);
            System.out.println("Samurai's health after such attack is "+this.health);
        }else{
            System.out.println("Samurai doesn't have power to go on, must meditate");
        }
    }

    public void meditate(){
        this.health = 200;
        System.out.println("Samurai back to full health of: "+this.health);
    }

    public static void howMany(){
        System.out.println("There are "+samuraiCount+" samurais");
    }
}
