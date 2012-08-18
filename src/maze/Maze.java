/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.HashMap;

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
        
    }
    
    public static String returnString(int x, int y){
        return x+" "+y;
    }
}
