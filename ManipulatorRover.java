/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3nesne;

import java.util.Scanner;

/**
 *
 * @author mrk1w
 */
public class ManipulatorRover extends Rover{
    //hareketten maniplatore gecerken bir sabitlenme suresi olacak bu sureyi biz mi atayacağız
    //haritaya robotun sabitlendigi yer icin yeni bir renk ekle ve sabitlenen konum icin degisken
    //engel olup olmama hikayesi 
    //engel gecme suresi icin neyi baz alacagız 
    //!!! Roverin metodları ve degerleri buna gecti 
    protected int loadCapacity; 
    protected int armLenght;
    protected int usedArmlenght;
    protected int carrySpeed; 
    protected int settlementTime;
    protected boolean isSettled;
    
    public int settlementX; // bunların hepsine encapsulation uygulanabilir 
    public int settlementY;
    
    public int[] armAxis = new int[2];
    //protected double time; -> BUNA ZATEN ERISIMIMIZ VAR
    // gezgin manipulatorde kolu engele takılacak sekilde ayarla 
    // kontrolleri bu classtamı alt classtamı yapmalıyım
    // override sınıfın scopını kaybettirmez herhalde ??
    private boolean trapped;
    //int loadAmount,int loadCapacity,int armLenght,int motorCount,int carrySpeed,int x,int y
    //int motorCount,int tireCount,int loadAmount,int movSpeed,int x,int y
    public ManipulatorRover(int loadAmount,int loadCapacity,int armLenght,int motorCount,int movSpeed,int carrySpeed,int x,int y){
        this.type = "Manipulator Rover";
        this.isSettled = false;
        this.canOver = true;
        this.loadAmount = loadAmount;
        this.loadCapacity = loadCapacity;
        this.motorCount = motorCount;
        this.movSpeed = movSpeed;
        this.carrySpeed = carrySpeed;
        this.armLenght = armLenght;
        this.axis[0] = x;this.axis[1] = y;
        this.initX = x;
        this.initY = y;
        while (this.loadCapacity < this.loadAmount) {
            System.out.print("bu Manipulator Rover bu LOADı cekmez yeni deger gir ");
            Scanner scan = new Scanner(System.in);
            this.loadAmount = scan.nextInt();
        }
        
    }     
    
    public void setObsOverTime(double obsOvertime){
        this.obsOverTime = obsOvertime;
    }
    
    public double getObsOverTime(){
        return this.obsOverTime;
    }
    
    
    
        @Override //siftah
        public void moveSeq(boolean[][] masks){
            int i;
            Scanner seqMove = new Scanner(System.in);
            while(true){
                System.out.println("yukarı: u asagı:d sag:r sol:l sabitle:s bitis:e ");
                System.out.print("Hareket yönü ");
                char tmp = seqMove.next().charAt(0);
                if (tmp == 'e') {
                    break;
                }
                if (tmp == 's') {
                    this.isSettled = true;
                    break;
                }            
                //System.out.println("okunan char "  + "'"+tmp +"'" );
                System.out.print("kac kare ");
                int tmpi = seqMove.nextInt();
                this.trapped = false;
                for (i = 0; i < tmpi; i++) {
                    if(trapped){
                        break;
                    }
                    moveOneGrid(tmp,masks);
                }
                System.out.println("X -> " + this.axis[0] + " Y -> " + this.axis[1]);
            }
            if (this.isSettled) {
                System.out.println("settled X -> " + this.axis[0] + " Y -> " + this.axis[1]);
                this.settlementX = this.axis[0];
                this.settlementY = this.axis[1];
                reachSeq();
            }
    }
        
    public void reachSeq(){
        int i;
        boolean armCheck = true;
        Scanner seqReach = new Scanner(System.in);
        this.armAxis[0] = this.settlementX;
        this.armAxis[1] = this.settlementY;
        
        System.out.println("X -> " + this.armAxis[0] + " Y -> " + this.armAxis[1]);
        System.out.println("X -> " + this.axis[0] + " Y -> " + this.axis[1]);
        while(armCheck){
            System.out.println("yukarı: u asagı:d sag:r sol:l sabitle:s bitis:e");
            System.out.print("Kol yönü ");
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
            System.out.println("X -> " + this.armAxis[0] + " Y -> " + this.armAxis[1]);
            
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
        public void printAttr(){
        System.out.println(
        "\nID: " + this.ID +
        "\ntype: " + this.type +
        "\nmotor count: " + this.motorCount +
        "\narm len: " + this.armLenght +   
        "\nload cap: " + this.loadCapacity +
        "\nload amount: " + this.loadAmount +
        "\nmov speed: " + this.movSpeed +
        "\ncarry speed: " + this.carrySpeed +
        "\nX -> " + this.axis[0] + " Y -> " + this.axis[1] + 
        "\ntime -> " + this.time
		);
    }

}
