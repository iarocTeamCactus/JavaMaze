/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.pieces;

import java.awt.Color;
import maze.Direction;
import maze.MazeConstants;

/**
 *
 * @author Rob
 */
public class UndefinedMazePiece implements MazePiece{
    
    private UndefinedMazePiece() {
    }
    
    public static UndefinedMazePiece getInstance() {
        return UndefinedMazePieceHolder.INSTANCE;
    }

    @Override
    public double getWidth() {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }

    @Override
    public double getHeight() {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }

    @Override
    public Color getColor() {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze trying to getColor().  This is an undefined Maze Piece.");
    }

    private static class UndefinedMazePieceHolder {

        private static final UndefinedMazePiece INSTANCE = new UndefinedMazePiece();
    }

    @Override
    public MazePiece getNorth() {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }

    @Override
    public void setNorth(MazePiece piece) {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }

    @Override
    public MazePiece getSouth() {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }

    @Override
    public void setSouth(MazePiece piece) {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }

    @Override
    public MazePiece getEast() {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }

    @Override
    public void setEast(MazePiece piece) {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }

    @Override
    public MazePiece getWest() {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }

    @Override
    public void setWest(MazePiece piece) {
        throw new UnsupportedOperationException("You have somehow wandered out of the maze.  This is an undefined Maze Piece");
    }
    
    @Override
    public MazePiece getDirection(Direction direction) {
        MazePiece piece = null;

        if (direction == MazeConstants.NORTH) {
            piece = getNorth();
        } else if (direction == MazeConstants.EAST) {
            piece = getEast();
        } else if (direction == MazeConstants.SOUTH) {
            piece = getSouth();
        } else if (direction == MazeConstants.WEST) {
            piece = getWest();
        } else {
            throw new IndexOutOfBoundsException("a direction " + direction + " does not map to NORTH SOUTH EAST WEST");
        }
        return piece;
    }

    @Override
    public void setDirection(MazePiece piece, Direction direction) {
        if (direction == MazeConstants.NORTH) {
            setNorth(piece);
        } else if (direction == MazeConstants.EAST) {
            setEast(piece);
        } else if (direction == MazeConstants.SOUTH) {
            setSouth(piece);
        } else if (direction == MazeConstants.WEST) {
            setWest(piece);
        } else {
            throw new IndexOutOfBoundsException("a direction " + direction + " does not map to NORTH SOUTH EAST WEST");
        }
    }
    
}
