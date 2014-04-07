/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import maze.builder.RandomMazeBuilder;
import maze.controller.MazeController;
import maze.viewer.MazeJFrame2;

/**
 *
 * @author Rob
 */
public class Maze {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String i = returnString( 1, 2);
        String j = returnString( 1, 2);
        if (i == j) {
            System.out.println("i == j");
        } else {
            System.out.println("i != j");
        }
        HashMap<String,String> hm = new HashMap<>();
        hm.put(i, "i 1 2");
        //hm.put(j, "j 1 2");
        System.out.println(hm.get(i));
        System.out.println(hm.get(j));
        
        final MazeJFrame2 mjf2 = new MazeJFrame2();
        //TODO: What is the model?
        final MazeController controller = new MazeController(mjf2);
        
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                mjf2.setVisible(true);
//                controller.start();
            }
        });
        
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("controller.start");
				controller.start();
			}
		});

    }
    
    public static String returnString(int x, int y){
        return x+" "+y;
    }
}
