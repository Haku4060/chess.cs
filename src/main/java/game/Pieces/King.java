package main.java.game.Pieces;

import java.util.ArrayList;
import java.util.List;

import main.java.game.Board;

public class King extends Piece {

    Position currentPosition = this.getPosition();
    private Board board;

    public King(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public List<Position> getLegalMove(Board Board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLegalMove'");
    }

    @Override
    public void move(Position newPosition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }
}
