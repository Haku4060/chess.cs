package main.java.game;

import java.util.HashMap;
import java.util.Map;

import main.java.game.Pieces.Bishop;
import main.java.game.Pieces.King;
import main.java.game.Pieces.Knight;
import main.java.game.Pieces.Pawn;
import main.java.game.Pieces.Queen;
import main.java.game.Pieces.Rook;

import main.java.game.Pieces.Piece;
import main.java.game.Pieces.Position;

public class Board {
    
    private Map<Position, Piece> board;

    // initialize the positions
    public Board(){
        board = new HashMap<>();
        setupInitialPieces();
    }

    private void setupInitialPieces(){
        Position w_BishopPositionLeft = new Position(0, 2);
        Position w_BishopPositionRight = new Position(0, 5);
        Position b_BishopPositionLeft = new Position(7, 2);
        Position b_BishopPositionRight = new Position(7, 5);

        Position w_KnightPositionLeft = new Position(0, 1);
        Position w_KnightPositionRight = new Position(0, 6);
        Position b_KnightPositionLeft = new Position(7, 1);
        Position b_KnightPositionRight = new Position(7, 6);

        Position w_RookPositionLeft = new Position(0, 0);
        Position w_RookPositionRight = new Position(0, 7);
        Position b_RookPositionLeft = new Position(7, 0);
        Position b_RookPositionRight = new Position(7, 7);

        Position w_KingPosition = new Position(0, 4);
        Position b_KingPosition = new Position(7, 4);

        Position w_QueenPosition = new Position(0, 3);
        Position b_QueenPosition = new Position(7, 3);


        for(int i = 0; i<8; i++){
            Position w_pawnPosition = new Position(1, i);
            Position b_pawnPosition = new Position(6, i);
            board.put(w_pawnPosition, new Pawn(w_pawnPosition, true));
            board.put(b_pawnPosition, new Pawn(b_pawnPosition, false));
        }

        board.put(w_BishopPositionLeft, new Bishop(w_BishopPositionLeft, true));
        board.put(w_BishopPositionRight, new Bishop(w_BishopPositionRight, true));
        board.put(b_BishopPositionLeft, new Bishop(b_BishopPositionLeft, false));
        board.put(b_BishopPositionRight, new Bishop(b_BishopPositionRight, false));

        board.put(w_KnightPositionLeft, new Knight(w_KnightPositionLeft, true));
        board.put(w_KnightPositionRight, new Knight(w_KnightPositionRight, true));
        board.put(b_KnightPositionLeft, new Knight(b_KnightPositionLeft, false));
        board.put(b_KnightPositionRight, new Knight(b_KnightPositionRight, false));
        
        board.put(w_RookPositionLeft, new Rook(w_RookPositionLeft, true));
        board.put(w_RookPositionRight, new Rook(w_RookPositionRight, true));
        board.put(b_RookPositionLeft, new Rook(b_RookPositionLeft, false));
        board.put(b_RookPositionRight, new Rook(b_RookPositionRight, false));

        board.put(w_KingPosition, new King(w_KingPosition, true));
        board.put(b_KingPosition, new King(b_KingPosition, false));

        board.put(w_QueenPosition, new Queen(w_QueenPosition, true));
        board.put(b_QueenPosition, new Queen(b_QueenPosition, false));


    }

    public Piece getPosition(Position position){
        return board.get(position);
    }

    public void movePiece(Position before, Position after){
        Piece piece = board.remove(before);
        board.put(after, piece);
    } 

    public boolean isPositionEmpty(Position position){
        return !board.containsKey(position);
    }

}
