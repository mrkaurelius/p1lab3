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
public class SerialManipulator extends Manipulator{
    /*
    protected int loadCapacity; //paralel > seri  loadcapacity buyuk olursa yeniden iste
    protected int carrySpeed; // paralel > seri bunun kontrolu
    */
    public SerialManipulator(int loadAmount,int loadCapacity,int armLenght,int motorCount,int carrySpeed,int x,int y){
        this.type = "Serial Manipulator";
        this.armLenght = armLenght;
        this.carrySpeed = carrySpeed;
        this.motorCount = motorCount;
        this.loadCapacity = loadCapacity;
        this.loadAmount = loadAmount;
        //ortada hic paralel yoksa nasıl bir atlatma yapmamız lazım 
        while(this.loadCapacity >= Manipulator.parallelLoadMAX){
            System.out.print("bu Serial bu LOADCAPı alamaz yeni deger gir ");
            Scanner scan = new Scanner(System.in);
            this.loadCapacity = scan.nextInt();
        }            

        while(this.carrySpeed >= Manipulator.parallelSpeedMAX){
            System.out.print("bu Serial bu HIZI alamaz yeni deger gir ");
            Scanner scan = new Scanner(System.in);
            this.carrySpeed = scan.nextInt();
        }     
        
        while (this.loadCapacity < this.loadAmount) {
            System.out.print("bu Serial bu sikleti cekmez yeni deger gir ");
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
        "\nmotor count:" + this.motorCount +
        "\narm len: " + this.armLenght +   
        "\nload cap: " + this.loadCapacity +
        "\nload amount: " + this.loadAmount +
        "\ncarry speed: " + this.carrySpeed +
        "\nX -> " + this.armAxis[0] + " Y -> " + this.armAxis[1] + 
        "\ntime -> " + this.time
		);
    }
    
    
}
