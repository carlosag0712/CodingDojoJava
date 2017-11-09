package codingDojo.JAVA_OOP.Pokemon;

public abstract class AbstractClass implements PokeInterface {

    @Override
    public Pokemon createPokemon(String name, int health, String type) {
        return new Pokemon(name,health,type);
    }

    @Override
    public void attackPokemon(Pokemon p) {
        int currentHealth = p.getHealth() -10;
        p.setHealth(currentHealth);

    }
}
