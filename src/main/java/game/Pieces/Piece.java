package main.java.game.Pieces;

import java.util.*;

import main.java.game.Board;

public abstract class Piece {
    
    protected Position position;
    protected boolean isWhite;

    public Piece(Position position, boolean isWhite){
        this.position = position;
        this.isWhite = isWhite;
    }

    public Position getPosition(){
        return this.position;
    }

    public boolean getIsWhite(){
        return this.isWhite;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public abstract List<Position> getLegalMove(Board Board);

    public abstract void move(Position newPosition);

}
