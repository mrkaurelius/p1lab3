/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3nesne;

import javax.swing.*; 
import java.awt.*;        // Uses AWT's Layout Managers

/**
 *
 * @author mrk1w
 */
public class GraphMap extends JFrame {
    //!!!BURADAKI ISIMLERI EDITLE
    public static final int GRID_SIZE = 10;
    public static final int CELL_SIZE = 50;
    public static final int CANVAS_WIDTH  = CELL_SIZE * GRID_SIZE;
    public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE;
    private JTextField[][] tfCells = new JTextField[GRID_SIZE][GRID_SIZE];
 
    public static final Color SARI = Color.YELLOW;
    //public static final Color OPEN_CELL_TEXT_YES = new Color(0, 255, 0);  // RGB
    public static final Color KIRMIZI = Color.RED;
    public static final Color CLOSED = new Color(240, 240, 240); // RGB
    public static final Color SIYAH = Color.BLACK;
    public static final Color MAVI = Color.BLUE;
    
    public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 14);

    private boolean[][] masks = {
          {false, false, false, false, false, false, false, false, false, false},
          {false, false, false, false, false, false, false, false, false, false},
          {false, false, false, false, false, false, false, false, false, false},
          {false, false, false, false, false, false, false, false, false, false},
          {false, false, false, false, false, false, false, false, false, false},
          {false, false, false, false, false, false, false, false, false, false},
          {false, false, false, false, false, false, false, false, false, false},
          {false, false, false, false, false, false, false, false, false, false},
          {false, false, false, false, false, false, false, false, false, false},
          {false, false, false, false, false, false, false, false, false, false}
          };
    
    public boolean[][] getMask(){
        return this.masks;
    }
     
    public void setObs(int x, int y){
        this.masks[x][y] = true;
    } 
    
    public boolean getObsEnt(int x,int y){
       return masks[x][y];
   }
    
    public void showMap(){
        setVisible(true);
    }
    
    public void drawMap(int[] robotAxis,int initX,int initY,int stX,int stY,int[] armAxis){
          Container cp = getContentPane();
          cp.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));  // 9x9 GridLayout

          // Construct 9x9 JTextFields and add to the content-pane
          for (int row = 0; row < GRID_SIZE; ++row) {
             for (int col = 0; col < GRID_SIZE; ++col) {
                tfCells[row][col] = new JTextField(); // Allocate element of array
                cp.add(tfCells[row][col]);            // ContentPane adds JTextField                                        
                tfCells[row][col].setEditable(false); //son hali getirecegiz degistirilebilir olmasına gerek varmı
                 if (initX == row && initY == col) {
                    tfCells[row][col].setText(row+","+col);
                    tfCells[row][col].setBackground(SIYAH);
                 }      
                 else if(stX == row && stY == col){
                    tfCells[row][col].setText(row+","+col);
                    tfCells[row][col].setBackground(MAVI);
                 }
                 else if (armAxis[0] == row && armAxis[1] == col) {
                    tfCells[row][col].setText(row+","+col);
                    tfCells[row][col].setBackground(KIRMIZI);
                 }
                 else if (masks[row][col]) {
                    tfCells[row][col].setText(row+","+col);
                    tfCells[row][col].setBackground(SARI);
                } else {
                   tfCells[row][col].setText(row+","+col);
                   //tfCells[row][col].setText( "");
                   tfCells[row][col].setEditable(false);
                   tfCells[row][col].setBackground(CLOSED);
                   //tfCells[row][col].setForeground(SIYAH);

                }
                // Beautify all the cells
                tfCells[row][col].setHorizontalAlignment(JTextField.CENTER);
                tfCells[row][col].setFont(FONT_NUMBERS);
             }
          }

          // Set the size of the content-pane and pack all the components
          //  under this container.
          cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
          pack();

          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
          setTitle("GraphMap");
        }
        
    public void drawMap(int[] robotAxis,int initX,int initY){
              Container cp = getContentPane();
      cp.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));  // 9x9 GridLayout

      // Construct 9x9 JTextFields and add to the content-pane
      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
            tfCells[row][col] = new JTextField(); // Allocate element of array
            cp.add(tfCells[row][col]);            // ContentPane adds JTextField                                        
            tfCells[row][col].setEditable(false); //son hali getirecegiz degistirilebilir olmasına gerek varmı
             if (initX == row && initY == col) {
                tfCells[row][col].setText(row+","+col);
                tfCells[row][col].setBackground(SIYAH);
             }             
             else if (robotAxis[0] == row && robotAxis[1] == col) {
                tfCells[row][col].setText(row+","+col);
                tfCells[row][col].setBackground(KIRMIZI);
             }
             else if (masks[row][col]) {
                tfCells[row][col].setText(row+","+col);
                tfCells[row][col].setBackground(SARI);
            } else {
               tfCells[row][col].setText(row+","+col);
               //tfCells[row][col].setText( "");
               tfCells[row][col].setEditable(false);
               tfCells[row][col].setBackground(CLOSED);
               //tfCells[row][col].setForeground(SIYAH);
              
            }
            // Beautify all the cells
            tfCells[row][col].setHorizontalAlignment(JTextField.CENTER);
            tfCells[row][col].setFont(FONT_NUMBERS);
         }
      }
 
      // Set the size of the content-pane and pack all the components
      //  under this container.
      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      pack();
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
      setTitle("GraphMap");
    }
    
    public GraphMap() {

    }

}
