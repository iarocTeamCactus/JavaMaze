package maze.controller;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

import maze.builder.RandomMazeBuilder;
import maze.pieces.EmptySpace;
import maze.pieces.MazePiece;
import maze.solver.MazeSolver;
import maze.viewer.MazeJFrame2;

public class MazeController implements Observer{
	
	RandomMazeBuilder rmb = new RandomMazeBuilder();
	MazeSolver solver = new MazeSolver();
	MazeJFrame2 mMazeJFrame;
	MazePiece mFirstPiece = null;  // This will be the model
	int mEastMost, mWestMost, mSouthMost, mNorthMost = 0;
	private MazePiece mCurrentPiece;
	
	public MazeController(MazeJFrame2 mjf) {
		mMazeJFrame = mjf;
		rmb.addObserver(this);
		solver.addObserver(this);
	}
	
	public void start() {
		System.out.println("MazeController.start");
		mFirstPiece = rmb.buildRandomMaze();
        MazePiece startingSpot = rmb.getSouthMostPiece();
        solveMaze(startingSpot);
	}

	public MazePiece getFirstPiece() {
		return mFirstPiece;
	}
	
	private void solveMaze(MazePiece startingSpot) {
		solver.solveMaze(startingSpot, (new HashSet<MazePiece>()));
        solver.highlightSolution();
	}

	@Override
	public void update(Observable o, Object arg) {
//		System.out.println("Maze Controller Notified");
		if (o instanceof RandomMazeBuilder) {
			rmb = ((RandomMazeBuilder)o);
			mFirstPiece = rmb.getStartingPiece();
			mCurrentPiece = rmb.getCurrentPiece();
			setEastMost(); setWestMost(); setNorthMost(); setSouthMost();
			sendEastWestSize(); sendNorthSouthSize();
			mMazeJFrame.setStartingPiece(mFirstPiece);
			mMazeJFrame.repaint();
		}
		if (o instanceof MazeSolver) {
			mMazeJFrame.repaint();
		}
	}

	private boolean couldResizeMaze( MazePiece mp) {
		return mCurrentPiece != null && mCurrentPiece instanceof EmptySpace;
	}
	
	private void setWestMost() {
		if (couldResizeMaze(mCurrentPiece)) {
			mWestMost = Math.min(mWestMost, ((EmptySpace)mCurrentPiece).getGridLocation().getXLocation());
			mMazeJFrame.setWestMostLoc(mWestMost);
		}
	}

	private void setNorthMost() {
		if (couldResizeMaze(mCurrentPiece)) {
			mNorthMost = Math.min(mNorthMost, ((EmptySpace)mCurrentPiece).getGridLocation().getYLocation());
			mMazeJFrame.setNorthMostLoc(mNorthMost);
		}
	}

	private void setSouthMost() {
		if (couldResizeMaze(mCurrentPiece)) {
			mSouthMost = Math.max(mSouthMost, ((EmptySpace)mCurrentPiece).getGridLocation().getYLocation());
			mMazeJFrame.setSouthMostLoc(mSouthMost);
		}
	}

	private void setEastMost() {
		if (couldResizeMaze(mCurrentPiece)) {
			mEastMost = Math.max(mEastMost, ((EmptySpace)mCurrentPiece).getGridLocation().getXLocation());
			mMazeJFrame.setEastMostLoc(mEastMost);
		}
	}
	
	public void sendEastWestSize() {
		mMazeJFrame.setEastWestSize(mEastMost - mWestMost + 1);
		System.out.println(mEastMost + " " + mWestMost + " = " + ( mEastMost - mWestMost + 1 ));
	}
	
	public void sendNorthSouthSize() {
		mMazeJFrame.setNorthSouthSize(mSouthMost - mNorthMost + 1);
		System.out.println(mSouthMost + " " + mNorthMost + " = " + ( mSouthMost - mNorthMost + 1 ));
	}
}
