package main.java.game.Pieces;

import java.util.Objects;

public class Position {
    
    private int row;
    private int col;

    public Position(int row, int col){
        if(row < 0 || row > 7 || col < 0 || col > 7){
            throw new IllegalArgumentException("Invalid value: Row and Column need to be 0 to 7");
        }

        this.row = row;
        this.col = col;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.col;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode(){
        return Objects.hash(row, col);
    }
}
