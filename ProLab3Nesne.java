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
public class ProLab3Nesne {

    /**
     * @param args the command line arguments
     */
    static void spider(){
        SpiderRover spiderRover = new SpiderRover(2,2,1000,20,5,5);
        spiderRover.printAttr();
        GraphMap gmap1 = new GraphMap();
        gmap1.setObs(9, 5);
        gmap1.setObs(4, 2);
        gmap1.setObs(3, 2);
        gmap1.setObs(4, 1);
        gmap1.setObs(3, 5);
        spiderRover.moveSeq(gmap1.getMask());
        spiderRover.printAttr();
        gmap1.drawMap(spiderRover.axis,spiderRover.initX,spiderRover.initY);
        gmap1.showMap();
    }
    
    static void tire(){
        TireRover tireRover = new TireRover(2,2,1000,20,5,5);
        tireRover.printAttr();
        GraphMap gmap1 = new GraphMap();
        gmap1.setObs(9, 5);
        gmap1.setObs(4, 2);
        gmap1.setObs(3, 2);
        gmap1.setObs(4, 1);
        gmap1.setObs(3, 5);
        tireRover.moveSeq(gmap1.getMask());
        tireRover.printAttr();
        gmap1.drawMap(tireRover.axis,tireRover.initX,tireRover.initY);
        gmap1.showMap();
    }
    
    static void track(){
        TrackRover trackRover = new TrackRover(2,2,1000,20,5,5);
        trackRover.printAttr();
        GraphMap gmap1 = new GraphMap();
        gmap1.setObs(8, 5);
        gmap1.setObs(4, 2);
        gmap1.setObs(3, 2);
        gmap1.setObs(4, 1);
        gmap1.setObs(3, 5);
        trackRover.moveSeq(gmap1.getMask());
        trackRover.printAttr();
        gmap1.drawMap(trackRover.axis,trackRover.initX,trackRover.initY);
        gmap1.showMap();
    }
    
    static void manipulator(){
    // !!! DOKUMANDA MANIPULATORLER ICIN ENGELDEN BAHSEDOLMIYOR
    //int loadAmount,int loadCapacity,int armLenght,int motorCount,int carrySpeed,int x,int y        
        GraphMap gmap = new GraphMap();
        ParalellManipulator pm1 = new ParalellManipulator(1000,500,10,20,4,3,4);
        pm1.printAttr();
        pm1.reachSeq();
        pm1.printAttr();
        gmap.drawMap(pm1.armAxis, pm1.initX, pm1.initY);
        gmap.showMap();
        GraphMap gmap1 = new GraphMap();
        SerialManipulator sm1 = new SerialManipulator(200, 501, 10, 20,2, 3, 7);
        // atlatmayı yazdıktan sonra burayı tamamla yada hocalara sorduktan sonra
    }
    
    public static void main(String[] args) {
        //!!!checkPositionDegerlerini degistirmeyi unutma!
        //birden fazla engel icin metod yaz
        //interface icin metod kullanımı usenmezsem yapılabilir
        //haritanın kutularının ustune koordinat yerine baska sey yazabilirm
        //kapsamlı test yapılmadı rover subclass bitti
        //kapsamlı test yapılmadı rover subclass bitti        
        //int loadAmount,int loadCapacity,int armLenght,int motorCount,int movSpeed,int carrySpeed,int x,int y
        GraphMap gmap1 = new GraphMap();
        ManipulatorRover mr1 = new ManipulatorRover(50,100,5,4,10,20,4,4);
        mr1.setObsOverTime(29);
        //System.out.println("DEBUG1 ->" + mr1.obsOverTime); çalışıyor
        mr1.printAttr();
        gmap1.setObs(3, 4);
        mr1.moveSeq(gmap1.getMask());
        //int[] robotAxis,int initX,int initY,int stX,int stY
        gmap1.drawMap(mr1.axis, mr1.initX,mr1.initY,mr1.settlementX,mr1.settlementY,mr1.armAxis );
        gmap1.showMap();
        mr1.printAttr();
    }
}

