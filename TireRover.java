/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab3nesne;

/**
 *
 * @author mrk1w
 */

// ENGEL GECME SURESI DEGERINE BURDAN BIR METODLAMI CONSTRUCTORLAMI UZERINE YAZICAM 

public class TireRover extends Rover {
    private int tireCount; // protected or private ???
    protected double obsOverTime;

    public void setTireCount(int tireCount){
        this.tireCount = tireCount;
    }
    
    public int getTireCount(){
        return this.tireCount;
    }

    public double getObsOverTime(){
        return this.obsOverTime;
    }
    
    public TireRover (){
        this.type = "Tire rover"; 
        this.canOver = true;
        this.obsOverTime = this.motorCount * 0.5;
    }
    
    public TireRover (int motorCount,int tireCount,int loadAmount,int movSpeed,int x,int y){
        this.type = "Tire rover"; 
        this.motorCount = motorCount;
        this.tireCount = tireCount;
        this.loadAmount = loadAmount;
        this.movSpeed = movSpeed;
        this.canOver = true;
        this.obsOverTime = this.motorCount * 0.5;
        this.axis[0] = x;this.axis[1]=y;
        this.time = 0;
        this.initX = this.axis[0];
        this.initY = this.axis[1];         
    }
    
    public void printAttr(){
        System.out.println(
        "\nID: " + this.ID +
        "\ntype: " + this.type +
        "\nmotor count:" + this.motorCount +
        "\ntire count: " + this.tireCount +
        "\nload amount: " + this.loadAmount +
        "\nmov speed: " + this.movSpeed +
        "\ncan over: " + this.canOver +
        "\nobsovertime: " + this.obsOverTime +
        "\nX -> " + this.axis[0] + " Y -> " + this.axis[1] +
        "\ntime -> " + this.time        
              
		);
    }
}
