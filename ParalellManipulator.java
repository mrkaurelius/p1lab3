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
public class ParalellManipulator extends Manipulator{
    //
    public ParalellManipulator (int loadAmount,int loadCapacity,int armLenght,int motorCount,int carrySpeed,int x,int y){
        //paralel olusturmadan seri olusmaz once seri olusturmasına karsı atlatma yaz 
        // load > cap yeniden cap iste
        //seri en gucsuz paralelden mi gucsuz  olmalı yoksa en guclu parelelden mi gucsuz olmalı
        this.type = "Parallel Manipulator";
        this.motorCount = motorCount;
        this.armLenght = armLenght;
        this.carrySpeed = carrySpeed;
        this.loadCapacity = loadCapacity;
        this.loadAmount = loadAmount;
        
        if(this.loadCapacity >  ParalellManipulator.parallelLoadMAX){
           ParalellManipulator.parallelLoadMAX = this.loadCapacity; 
        }
        if(this.carrySpeed > ParalellManipulator.parallelSpeedMAX){
           ParalellManipulator.parallelSpeedMAX = this.carrySpeed; 
        }  
        
        while (this.loadCapacity < this.loadAmount) {
            System.out.print("bu Manipulator bu LOADı cekmez yeni deger gir ");
            Scanner scan = new Scanner(System.in);
            this.loadAmount = scan.nextInt();
        }
        this.time = 0;
        this.armAxis[0] = x;this.armAxis[1] = y;
        this.initX = armAxis[0];
        this.initY = armAxis[1];
    } 
    
    public void printAttr(){
        System.out.println(
        "\nID: " + this.ID +
        "\ntype: " + this.type +
        "\nmotor count: " + this.motorCount +
        "\narm len: " + this.armLenght +   
        "\nload cap: " + this.loadCapacity +
        "\nload amount: " + this.loadAmount +
        "\ncarry speed: " + this.carrySpeed +
        "\nX -> " + this.armAxis[0] + " Y -> " + this.armAxis[1] + 
        "\ntime -> " + this.time
		);
    }
}
