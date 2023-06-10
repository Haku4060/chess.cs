package main.java.game.Pieces;

import java.util.ArrayList;
import java.util.List;

import main.java.game.Board;

public class Queen extends Piece {

    Position currentPosition = this.getPosition();
    private Board board;
    
    public Queen(Position position, boolean isWhite){
        super(position, isWhite);
    }

    @Override
    public List<Position> getLegalMove(Board Board) {
        
        List<Position> legalMove = new ArrayList<>();

        //Move up
        for(int i = currentPosition.getRow(); i >= 0; i--){
            Position potentialPosition = new Position(i, currentPosition.getColumn());
            if(!Board.isPositionEmpty(potentialPosition) || Board.getPosition(potentialPosition).getIsWhite() != this.getIsWhite()){
                legalMove.add(potentialPosition);
            }
        };

        //Move down
        for(int i = currentPosition.getRow(); i < 8; i++){
            Position potentialPosition = new Position(i, currentPosition.getColumn());
            if(!Board.isPositionEmpty(potentialPosition) || Board.getPosition(potentialPosition).getIsWhite() != this.getIsWhite()){
                legalMove.add(potentialPosition);
            }
        };

        //Move left
        for(int i = currentPosition.getColumn(); i >= 0; i--){
            Position potentialPosition = new Position(currentPosition.getRow(), i);
            if(!Board.isPositionEmpty(potentialPosition) || Board.getPosition(potentialPosition).getIsWhite() != this.getIsWhite()){
                legalMove.add(potentialPosition);
            }
        };

        //Move right
        for(int i = currentPosition.getColumn(); i < 8; i++){
            Position potentialPosition = new Position(currentPosition.getRow(), i);
            if(!Board.isPositionEmpty(potentialPosition) || Board.getPosition(potentialPosition).getIsWhite() != this.getIsWhite()){
                legalMove.add(potentialPosition);
            }
        }

        //Move up-left
        for(int i = 1; i <= Math.min(currentPosition.getRow(), currentPosition.getColumn()); i++){
            Position potentialPosition = new Position(currentPosition.getRow() - i, currentPosition.getColumn() - i);
            if(!Board.isPositionEmpty(potentialPosition) || Board.getPosition(potentialPosition).getIsWhite() != this.getIsWhite()){
                legalMove.add(potentialPosition);
            }
        }

        //Move up-right
        for(int i = 1; i <= Math.min(currentPosition.getRow(), 7-currentPosition.getColumn()); i++){
            Position potentialPosition = new Position(currentPosition.getRow() - i, currentPosition.getColumn() + i);
            if(!Board.isPositionEmpty(potentialPosition) || Board.getPosition(potentialPosition).getIsWhite() != this.getIsWhite()){
                legalMove.add(potentialPosition);
            }
        }

        //Move down-left
        for(int i = 1; i <= Math.min(7-currentPosition.getRow(), currentPosition.getColumn()); i++){
            Position potentialPosition = new Position(currentPosition.getRow() + i, currentPosition.getColumn() - i);
            if(!Board.isPositionEmpty(potentialPosition) || Board.getPosition(potentialPosition).getIsWhite() != this.getIsWhite()){
                legalMove.add(potentialPosition);
            }
        }

        //Move down-right
        for(int i = 1; i <= Math.min(7-currentPosition.getRow(), 7-currentPosition.getColumn()); i++){
            Position potentialPosition = new Position(currentPosition.getRow() + i, currentPosition.getColumn() + i);
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
