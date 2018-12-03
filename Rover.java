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

public class Rover extends Robot {
    protected int movSpeed;
    protected boolean canOver;
    protected double time; //bunu robota koyabilirm 
    private boolean trapped; //haritanın sonuna geldiyse birdaha hareket gonderme 
    protected double obsOverTime; //manipulator icin
    public int[] axis = new int[2]; // bunu nasıl refactor ederim 
    
    public void moveSeq(boolean[][] masks){
        int i;
        Scanner seqMove = new Scanner(System.in);
        while(true){
            System.out.println("yukarı: u asagı:d sag:r sol:l e: bitis");
            System.out.print("Yön ");
            char tmp = seqMove.next().charAt(0);
            if (tmp == 'e') {
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
    }
    
    public void moveOneGrid(char moveDir,boolean[][] masks){
        boolean posCheck;
        boolean obsCheck; //buna gerek varmı
        
        switch(moveDir){ 
            case 'u': this.axis[0]--;
                if (!(posCheck = checkPosition(this.axis[0],this.axis[1]))) {
                    System.out.println("Oraya gidemez harita dışı!");
                    this.axis[0]++;
                    this.trapped = true;
                } 
                else if(masks[this.axis[0]][this.axis[1]]){
                    if (!this.canOver) {
                        System.out.println("Oraya gidemez Engelvar!");
                        this.axis[0]++;
                        this.trapped = true;                    
                    } else {
                        //System.out.println("DEBUG " + this.type + "Motorcount" + this.motorCount );
                        if(this.type.equals("Track rover")){
                            //System.out.println("");
                            this.time += (this.motorCount * 3);
                            //System.out.println("DEBUG1 " + this.type);
                        } else if (this.type.equals("Tire rover")){
                            this.time += (this.motorCount * 0.5);
                            //System.out.println("DEBUG2" + this.type);
                        }else {
                            this.time += this.obsOverTime;
                        }
                        this.time += 10.0/(double)movSpeed;
                    }
                }
                else {
                    this.time += 10.0/(double)movSpeed;
                }
            break;
                
            case 'd': this.axis[0]++;
                if (!(posCheck = checkPosition(this.axis[0],this.axis[1]))) {
                    System.out.println("Oraya gidemez harita dışı!");
                    this.axis[0]--;
                    this.trapped = true;
                } 
                else if(masks[this.axis[0]][this.axis[1]]){
                    if (!this.canOver) {
                        System.out.println("Oraya gidemez Engelvar!");
                        this.axis[0]--;
                        this.trapped = true;                    
                    } else {
                        //System.out.println("DEBUG " + this.type + "Motorcount" + this.motorCount );
                        if(this.type.equals("Track rover")){
                            //System.out.println("");
                            this.time += (this.motorCount * 3);
                            //System.out.println("DEBUG1 " + this.type);
                        } else if (this.type.equals("Tire rover")){
                            this.time += (this.motorCount * 0.5);
                            //System.out.println("DEBUG2" + this.type);
                        }else {
                            this.time += this.obsOverTime;
                        }
                        this.time += 10.0/(double)movSpeed;
                    }
                }
                else {
                    this.time += 10.0/(double)movSpeed;
                }
            break;
                
            case 'l': this.axis[1]--;
                if (!(posCheck = checkPosition(this.axis[0],this.axis[1]))) {
                    System.out.println("Oraya gidemez harita dışı!");
                    this.axis[1]++;
                    this.trapped = true;
                } 
                else if(masks[this.axis[0]][this.axis[1]]){
                    if (!this.canOver) {
                        System.out.println("Oraya gidemez Engelvar!");
                        this.axis[1]++;
                        this.trapped = true;                    
                    } else {
                        //System.out.println("DEBUG " + this.type + "Motorcount" + this.motorCount );
                        if(this.type.equals("Track rover")){
                            //System.out.println("");
                            this.time += (this.motorCount * 3);
                            //System.out.println("DEBUG1 " + this.type);
                        } else if (this.type.equals("Tire rover")){
                            this.time += (this.motorCount * 0.5);
                            //System.out.println("DEBUG2" + this.type);
                        }else {
                            this.time += this.obsOverTime;
                        }
                        this.time += 10.0/(double)movSpeed;
                    }
                }
                else {
                    this.time += 10.0/(double)movSpeed;
                }
            break;
                
            case 'r': this.axis[1]++;
                if (!(posCheck = checkPosition(this.axis[0],this.axis[1]))) {
                    System.out.println("Oraya gidemez harita dışı!");
                    this.axis[1]--;
                    this.trapped = true;
                } 
                else if(masks[this.axis[0]][this.axis[1]]){
                    if (!this.canOver) {
                        System.out.println("Oraya gidemez Engelvar!");
                        this.axis[1]--;
                        this.trapped = true;                    
                    } else {
                        //System.out.println("DEBUG " + this.type + "Motorcount" + this.motorCount );
                        if(this.type.equals("Track rover")){
                            //System.out.println("");
                            this.time += (this.motorCount * 3);
                            //System.out.println("DEBUG1 " + this.type);
                        } else if (this.type.equals("Tire rover")){
                            this.time += (this.motorCount * 0.5);
                            //System.out.println("DEBUG2" + this.type);
                        }else {
                            this.time += this.obsOverTime;
                        }
                        this.time += 10.0/(double)movSpeed;
                    }
                }
                else {
                    this.time += 10.0/(double)movSpeed;
                }
            break;
            default: System.out.println("HATALI GIRDI!");
        }
        // engeldemiyim kontrol et spider ise cıkma degil ise zaman a ekle 
        // if koordinat == engel koordinat engeldeyim ama bu sınıf engeli nasıl görecek
        // matrisi nasıl global yaparım 
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
    
    public void setmovSpeed(int movSpeed){
        this.movSpeed = movSpeed;
    }
    
    public int getmovSpeed(){
        return this.movSpeed;
    }
    
    public Rover(){
        this.type = "Rover";
    }

}
