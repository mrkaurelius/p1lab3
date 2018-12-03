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


public class Robot {
    private static int robotCount = 0; 
    protected int ID;     //neyi inherit edip etmeyeceğime karar ver 
    protected int loadAmount;  
    protected int motorCount;
    protected String type = "Robot";
    public int initX;       // !!! farklı yerde oldugu icin
    public int initY;  
    //constructorlarda tipe dikkat mi etsek yoksa baska bir yolu varmıdır (üstüne yazma gibi)
    //public int initX;
    //public int initY;
    // koordinatlar oopye gore nasıl olmalı 
    public Robot(){
        this.ID = ++robotCount;               
    }

    public void setMotorCount(int motorCount){
        this.motorCount = motorCount;
    }
    
    public int getMotorCount(){
        return this.motorCount;
    }
    
    public void setLoadAmount(int loadAmount){
        this.motorCount = loadAmount;
    }
    
    public int getLoadAmount(){
        return this.loadAmount;
    }
    
    public void setID(int id){
        this.ID = id;
    }

    public int getID(){
        return this.ID;
    }
    
}


