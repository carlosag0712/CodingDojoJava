package codingDojo.JAVA_OOP.Pokemon;

public interface PokeInterface {
    Pokemon createPokemon(String name,int health,String type);
    void attackPokemon(Pokemon pokemon);
    String pokemoninfo(Pokemon pokemon);
}
