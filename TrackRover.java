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
public class TrackRover extends Rover {
    private int trackCount; // protected or private ???
    protected double obsOverTime;

    
    public void setTrackCount(int trackCount){
        this.trackCount = trackCount;
    }
    
    public int getTrackCount(){
        return this.trackCount;
    }

    public double getObsOverTime(){
        return this.obsOverTime;
    }
    
    public TrackRover (){
        this.type = "Track rover"; 
        this.canOver = true;
        this.obsOverTime = this.motorCount * 0.5;
    }
    
    public TrackRover (int motorCount,int trackCount,int loadAmount,int movSpeed,int x,int y){
        this.type = "Track rover"; 
        this.motorCount = motorCount;
        this.trackCount = trackCount;
        this.loadAmount = loadAmount;
        this.movSpeed = movSpeed;
        this.canOver = true;
        this.obsOverTime = this.motorCount * 3;
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
        "\ntrack count: " + this.trackCount +
        "\nload amount: " + this.loadAmount +
        "\nmov speed: " + this.movSpeed +
        "\ncan over: " + this.canOver +
        "\nobsovertime: " + this.obsOverTime +
        "\nX -> " + this.axis[0] + " Y -> " + this.axis[1] +
        "\ntime -> " + this.time                
		);
    }
}