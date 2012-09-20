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
 * @author Rob.Erwin@gmail.com
 */
public class BeaconWall implements MazePiece, Wall {

    MazePiece beaconwall = new RunsEastWestWall();
    Color color = Color.RED;

    @Override
    public MazePiece getNorth() {
        return beaconwall.getNorth();
    }

    @Override
    public void setNorth(MazePiece piece) {
        beaconwall.setNorth(piece);
    }

    @Override
    public MazePiece getSouth() {
        return beaconwall.getSouth();
    }

    @Override
    public void setSouth(MazePiece piece) {
        beaconwall.setSouth(piece);
    }

    @Override
    public MazePiece getEast() {
        return beaconwall.getEast();
    }

    @Override
    public void setEast(MazePiece piece) {
        beaconwall.setEast(piece);
    }

    @Override
    public MazePiece getWest() {
        return beaconwall.getWest();
    }

    @Override
    public void setWest(MazePiece piece) {
        beaconwall.setWest(piece);
    }

    @Override
    public double getWidth() {
        return beaconwall.getWidth();
    }

    @Override
    public double getHeight() {
        return beaconwall.getHeight();
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

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
