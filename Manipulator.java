/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mrk1w
 */
package prolab3nesne;
import java.util.Scanner;

public class Manipulator extends Robot {
    protected int loadCapacity; //paralel > seri  loadcapacity buyuk olursa yeniden iste
    protected int armLenght;
    protected int usedArmlenght;
    protected int carrySpeed; // paralel > seri bunun kontrolu 
    public static int parallelLoadMAX = 0;
    protected static int parallelSpeedMAX = 0;
    public int[] armAxis = new int[2];
    protected double time;
    // gezgin manipulatorde kolu engele takılacak sekilde ayarla 
    // kontrolleri bu classtamı alt classtamı yapmalıyım
    private boolean trapped;
            
    public void reachSeq(){
        int i;
        boolean armCheck = true;
        Scanner seqReach = new Scanner(System.in);
        while(armCheck){
            System.out.println("yukarı: u asagı:d sag:r sol:l e: bitis");
            System.out.print("Yön ");
            char tmp = seqReach.next().charAt(0);
            if (tmp == 'e') {
                break;
            }
            System.out.print("kac kare ");
            int tmpi = seqReach.nextInt();
            this.trapped = false;
            for (i = 0; i < tmpi; i++) {
                if(trapped){
                    break;
                }
                if(usedArmlenght == this.armLenght) {
                    System.out.println("Kolun sonu");    
                    armCheck = false;
                    break;
                }              
                reachOneGrid(tmp); 
            }
            System.out.println("kolun koordinatı X -> " + this.armAxis[0] + " Y -> " + this.armAxis[1]);
            
        }
    }

    public void reachOneGrid(char moveDir){
        boolean posCheck;
        boolean obsCheck; //buna gerek varmı
        
        switch(moveDir){ 
            case 'u': this.armAxis[0]--;
                if (!(posCheck = checkPosition(this.armAxis[0],this.armAxis[1]))) {
                    System.out.println("Oraya ulaşamaz harita dışı!");
                    this.armAxis[0]++;
                    this.trapped = true;
                } 
                else {
                    this.time += 10.0/(double)carrySpeed;
                    this.usedArmlenght++;
                }
            break;
                
            case 'd': this.armAxis[0]++;
                if (!(posCheck = checkPosition(this.armAxis[0],this.armAxis[1]))) {
                    System.out.println("Oraya ulaşamaz harita dışı!");
                    this.armAxis[0]--;
                    this.trapped = true;
                } 
                else {
                    this.time += 10.0/(double)carrySpeed;
                    this.usedArmlenght++;
                }
            break;
                
            case 'l': this.armAxis[1]--;
                if (!(posCheck = checkPosition(this.armAxis[0],this.armAxis[1]))) {
                    System.out.println("Oraya ulaşamaz harita dışı!");
                    this.armAxis[1]++;
                    this.trapped = true;
                } 
                else {
                    this.time += 10.0/(double)carrySpeed;
                    this.usedArmlenght++;
                }
            break;
                
            case 'r': this.armAxis[1]++;
                if (!(posCheck = checkPosition(this.armAxis[0],this.armAxis[1]))) {
                    System.out.println("Oraya ulaşamaz harita dışı!");
                    this.armAxis[1]--;
                    this.trapped = true;
                } 
                else {
                    this.time += 10.0/(double)carrySpeed;
                    this.usedArmlenght++;
                }
            break;
            default: System.out.println("HATALI GIRDI!");
        }
    }


    public boolean checkPosition(int x,int y){
        if (x > 9 || x < 0) {
            return false;
        }
        else if (y > 9 || y < 0) {
            return false;
        }
        return true;
    }
    
    public Manipulator(){
        this.type = "Manipulator";
        
    }
    
}
