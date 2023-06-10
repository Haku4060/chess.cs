package main.java.game.Pieces;

import java.util.ArrayList;
import java.util.List;

import main.java.game.Board;

public class Pawn extends Piece {

    Position currentPosition = this.getPosition();
    private boolean hasMoved = false;
    private Board board;

    public Pawn(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public List<Position> getLegalMove(Board Board) {
        
        List<Position> legalMove = new ArrayList<>();

        int direction = isWhite ? -1 : 1;
        int[] directionOfEnemies = {-1, 1};
        Position potentialPosition = new Position(currentPosition.getRow() + direction, currentPosition.getColumn());

        if(!Board.isPositionEmpty(potentialPosition) || Board.getPosition(potentialPosition).getIsWhite() != this.getIsWhite()){
            legalMove.add(potentialPosition);
        }

        if(!hasMoved){
            Position InitialPotentialPosition = new Position(currentPosition.getRow() + 2*direction, currentPosition.getColumn());
            if(!Board.isPositionEmpty(InitialPotentialPosition) || Board.getPosition(InitialPotentialPosition).getIsWhite() != this.getIsWhite()){
                legalMove.add(InitialPotentialPosition);
            }
        }

        for(int directionToAttack : directionOfEnemies){
            Position attackPotentialPosition = new Position(currentPosition.getRow() + direction, currentPosition.getColumn() + directionToAttack);
            
        }

        return legalMove;

    }

    @Override
    public void move(Position newPosition) {
        if(getLegalMove(board).contains(newPosition)){
            board.movePiece(currentPosition, newPosition);
            hasMoved = true;
        }
    }
    


}
