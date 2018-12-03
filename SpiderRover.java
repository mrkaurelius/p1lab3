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
public class SpiderRover extends Rover {
        private int legCount; // protected or private ???
        protected boolean halted; // bunun kapsama alnanından emin ol 
     

    public void setLegCount(int legCount){
        this.legCount = legCount;
    }
    
    public int getLegCount(){
        return this.legCount;
    }
    
    public SpiderRover (){
        this.type = "Spider rover"; 
        this.canOver = false;
    }
    
    public SpiderRover (int motorCount,int legCount,int loadAmount,int movSpeed,int x,int y){
        this.type = "Spider rover"; 
        this.motorCount = motorCount;
        this.legCount = legCount;
        this.loadAmount = loadAmount;
        this.movSpeed = movSpeed;
        this.canOver = false;
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
        "\nleg count: " + this.legCount +
        "\nload amount: " + this.loadAmount +
        "\nmov speed: " + this.movSpeed +
        "\ncan over: " + this.canOver +
        "\nX -> " + this.axis[0] + " Y -> " + this.axis[1] + 
        "\ntime -> " + this.time
		);
    }

}