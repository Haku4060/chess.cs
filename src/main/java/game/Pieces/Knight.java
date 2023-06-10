package main.java.game.Pieces;

import java.util.ArrayList;
import java.util.List;

import main.java.game.Board;

public class Knight extends Piece {

    Position currentPosition = this.getPosition();
    private Board board;

    private int[][] legalMoveOffsets = { 
        //up-left
        {-2, -1},
        //up-right
        {-2, 1},
        //down-left
        {2, -1},
        //down-right
        {2, 1},
        //left-up
        {-1, -2},
        //left-down
        {1, -2},
        //right-up
        {-1, 2},
        //right-down
        {-1, 2}
     };

    public Knight(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public List<Position> getLegalMove(Board Board) {
        
        List<Position> legalMove = new ArrayList<>();
        for(int[] offset : legalMoveOffsets){
            
            Position potentialPosition = new Position(currentPosition.getRow() + offset[0], currentPosition.getColumn() + offset[1]);
        
            if(!Board.isPositionEmpty(potentialPosition) || Board.getPosition(potentialPosition).getIsWhite() != this.getIsWhite()){
                legalMove.add(potentialPosition);
            }

        }

        return legalMove;
    }

    @Override
    public void move(Position newPosition) {
        if(getLegalMove(board).contains(newPosition)){
            board.movePiece(currentPosition, newPosition);
        }
    }
    
}
