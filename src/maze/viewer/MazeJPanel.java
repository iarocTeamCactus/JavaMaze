/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.viewer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import maze.Direction;
import maze.MazeConstants;
import maze.pieces.EmptySpace;
import maze.pieces.MazePiece;
import maze.pieces.UndefinedMazePiece;
import maze.pieces.Wall;

/**
 *
 * @author Rob.Erwin@gmail.com
 */
public class MazeJPanel extends javax.swing.JPanel implements Observer {

    private final MazePiece startingPiece;
    private double currX, currY;
    private List<Rectangle> rectList = new ArrayList<>();
    private Set<MazePiece> drawnPieces = new HashSet<>();
    private double totalHeight, totalWidth;

    /**
     * Creates new form MazeJPanel
     */
    public MazeJPanel(MazePiece piece) {
        startingPiece = piece;
        System.out.println(getWidth() + " " + getHeight());
        this.setSize(500, 500);
        //createRectList(startingPiece, getWidth() / 2.0 - startingPiece.getWidth() / 2.0, getHeight() / 2.0 - startingPiece.getHeight() / 2.0);
        initComponents();
    }

    private void createRectList(MazePiece piece, MazePiece originalPiece, double x, double y) {
        if (piece != UndefinedMazePiece.getInstance()) {
            //System.out.println("createRectList " + piece.getWidth());
            boolean add = rectList.add(new Rectangle((int) x, (int) y, (int) piece.getWidth(), (int) piece.getHeight()));
            if (piece instanceof EmptySpace) {
                MazePiece nextPiece = piece.getSouth();
                if (nextPiece != originalPiece && nextPiece != UndefinedMazePiece.getInstance()) {
                    createRectList(piece.getSouth(), piece, x, y + piece.getHeight());
                }

                nextPiece = piece.getNorth();
                if (nextPiece != originalPiece && nextPiece != UndefinedMazePiece.getInstance()) {
                    createRectList(piece.getNorth(), piece, x, y - piece.getNorth().getHeight());
                }

                nextPiece = piece.getEast();
                if (nextPiece != originalPiece && nextPiece != UndefinedMazePiece.getInstance()) {
                    createRectList(piece.getEast(), piece, x + piece.getWidth(), y);
                }

                nextPiece = piece.getWest();
                if (nextPiece != originalPiece && nextPiece != UndefinedMazePiece.getInstance()) {
                    createRectList(piece.getWest(), piece, x - piece.getWest().getWidth(), y);
                }
            }
        }
    }

    private void createRectList(MazePiece currentPiece, double x, double y) {
        //draw the current piece
        if (!(currentPiece instanceof UndefinedMazePiece)) {
            boolean add = rectList.add(new Rectangle((int) x, (int) y, (int) currentPiece.getWidth(), (int) currentPiece.getHeight()));
            drawnPieces.add(currentPiece);
        }

        //draw all empty spaces first
        MazePiece adjacentPiece;
        for (Direction direction : MazeConstants.DIRECTIONS) {
            adjacentPiece = currentPiece.getDirection(direction);
            if (adjacentPiece instanceof EmptySpace && !drawnPieces.contains(adjacentPiece)) {
                // works here because all pieces are same size
                createRectList(adjacentPiece, x + direction.getXdiff() * adjacentPiece.getWidth(), y + direction.getYdiff() * adjacentPiece.getHeight());
            }
        }

        //then draw all walls
        for (Direction direction : MazeConstants.DIRECTIONS) {
            adjacentPiece = currentPiece.getDirection(direction);
            if (adjacentPiece instanceof Wall && !drawnPieces.contains(adjacentPiece)) {
                if (direction == MazeConstants.NORTH) {
                    createRectList(adjacentPiece, x + direction.getXdiff() * currentPiece.getWidth(), y + direction.getYdiff() * currentPiece.getHeight());
                } else if (direction == MazeConstants.EAST) {
                    createRectList(adjacentPiece, x + direction.getXdiff() * currentPiece.getWidth(), y + direction.getYdiff() * currentPiece.getHeight());
                } else if (direction == MazeConstants.WEST) {
                    createRectList(adjacentPiece, x + direction.getXdiff() * adjacentPiece.getWidth(), y + direction.getYdiff() * adjacentPiece.getHeight());
                } else {
                    createRectList(adjacentPiece, x + direction.getXdiff() * adjacentPiece.getWidth(), y + direction.getYdiff() * adjacentPiece.getHeight());
                }
            }
        }

    }

    private void drawMaze(MazePiece currentPiece, double x, double y, Graphics2D g2) {
        //draw the current piece
        if (!(currentPiece instanceof UndefinedMazePiece)) {
            Rectangle r = new CenteredRectangle((int) x, (int) y, (int) currentPiece.getWidth(), (int) currentPiece.getHeight());
            g2.setPaint(currentPiece.getColor());
            //Random rand = new Random();
            //g2.setPaint(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
            g2.fill(r);
            drawnPieces.add(currentPiece);
        }

        //draw all empty spaces first
        MazePiece adjacentPiece;
        for (Direction direction : MazeConstants.DIRECTIONS) {
            adjacentPiece = currentPiece.getDirection(direction);
            if (adjacentPiece instanceof EmptySpace && !drawnPieces.contains(adjacentPiece)) {
                // works here because all pieces are same size
                drawMaze(adjacentPiece,
                        x + direction.getXdiff() * currentPiece.getWidth() / 2.0 + direction.getXdiff() * adjacentPiece.getWidth() / 2.0,
                        y + direction.getYdiff() * currentPiece.getHeight() / 2.0 + direction.getYdiff() * adjacentPiece.getHeight() / 2.0,
                        g2);
            }
        }
        //then draw all walls
        for (Direction direction : MazeConstants.DIRECTIONS) {
            adjacentPiece = currentPiece.getDirection(direction);
            if (adjacentPiece instanceof Wall && !drawnPieces.contains(adjacentPiece)) {
// THIS CODE WAS FROM BEFORE USING CenteredRectangle
//                if (direction == MazeConstants.NORTH) {
//                    drawMaze(adjacentPiece, x + direction.getXdiff() * currentPiece.getWidth(), y + direction.getYdiff() * currentPiece.getHeight() * .5, g2);
//                } else if (direction == MazeConstants.EAST) {
//                    drawMaze(adjacentPiece, x + direction.getXdiff() * currentPiece.getWidth() - .5 * adjacentPiece.getWidth(), y + direction.getYdiff() * currentPiece.getHeight(), g2);
//                } else if (direction == MazeConstants.WEST) {
//                    drawMaze(adjacentPiece, x + direction.getXdiff() * adjacentPiece.getWidth() * .5, y + direction.getYdiff() * adjacentPiece.getHeight(), g2);
//                } else {
//                    drawMaze(adjacentPiece, x + direction.getXdiff() * adjacentPiece.getWidth(), y + direction.getYdiff() * adjacentPiece.getHeight() * .5, g2);
//                }
                drawMaze(adjacentPiece,
                        x + direction.getXdiff() * currentPiece.getWidth() / 2.0,
                        y + direction.getYdiff() * currentPiece.getHeight() / 2.0,
                        g2);

            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        currX = w / 2.0;
        currY = h / 2.0;
        drawnPieces.clear();  // clear the list of drawn pieces on each redraw.
        drawMaze(startingPiece, currX, currY, g2);
//        ListIterator<Rectangle> li = rectList.listIterator();
//        Random rand = new Random();
//        {
//            Rectangle r;
//            Color c;
//            while (li.hasNext()) {
//                r = li.next();
//                if (r.getWidth() < 5.0 || r.getHeight() < 5.0) {
//                    // presumably a wall
//                    g2.setPaint(Color.WHITE);
//                } else {
//                    // presumably a space
//                    //g2.setPaint(Color.GRAY);
//                    g2.setPaint(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
//                }
//                g2.fill(r);
//            }
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        //who called us and what did they send?
        System.out.println("View      : Observable is " + o.getClass() + ", object passed is " + arg.getClass());
    }
}
