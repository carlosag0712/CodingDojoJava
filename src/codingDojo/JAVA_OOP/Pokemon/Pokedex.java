package codingDojo.JAVA_OOP.Pokemon;

public class Pokedex extends AbstractClass {

    @Override
    public String pokemoninfo(Pokemon pokemon) {
        return "Name"+pokemon.getName()+", Type: "+pokemon.getType()+", Health: "+pokemon.getHealth();
    }
}
