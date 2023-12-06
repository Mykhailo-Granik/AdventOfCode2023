package solutions.dec2;

import java.util.List;
import java.util.Objects;


public class Game {

    private final List<SetOfCubes> setsOfCubes;
    private final int id;

    public Game(List<SetOfCubes> setsOfCubes, int id) {
        this.setsOfCubes = setsOfCubes;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<SetOfCubes> getSetsOfCubes() {
        return setsOfCubes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && Objects.equals(setsOfCubes, game.setsOfCubes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(setsOfCubes, id);
    }

    @Override
    public String toString() {
        return "Game{" +
                "setsOfCubes=" + setsOfCubes +
                ", id=" + id +
                '}';
    }
}
