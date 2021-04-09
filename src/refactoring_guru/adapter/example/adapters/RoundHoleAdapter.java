package refactoring_guru.adapter.example.adapters;

import refactoring_guru.adapter.example.round.RoundHole;
import refactoring_guru.adapter.example.square.SquarePeg;

public class RoundHoleAdapter extends SquarePeg {
    public RoundHoleAdapter(RoundHole roundHole) {
        super(Math.sqrt(Math.pow(roundHole.getRadius(), 2) / 2));
    }

    public boolean canInsert(SquarePeg squarePeg) {
        return squarePeg.getWidth() <= this.getWidth();
    }
}
