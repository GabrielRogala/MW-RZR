package automat3d;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Canvas extends JComponent{
    private int tab[][];
    private Grain grains[][];
    private boolean b = false; 
    private final int size_x = 500;
    private final int size_y = 300;
    private final int max_x = 500;
    private final int max_y = 300;
    private boolean showEdge;

    public void changeShowEdge() {
        showEdge = !showEdge;
    }
       
    public Canvas(){
        grains = new Grain[size_x][size_y];
        for(int i=0;i<size_x;i++){
            for(int j=0;j<size_y;j++){
                grains[i][j] = new Grain();
            } 
        }  
        showEdge = false;
    }
    
    public void setGrains(Grain[][] grains){
        this.grains = grains;
    }
        
    public void paint(Graphics g){
        for(int j=0;j<size_y;j++){
            for(int i=0;i<size_x;i++){
                if(grains[i][j].getId() == 0 || (grains[i][j].isB() && showEdge) ){
                    g.setColor(Color.BLACK);
                }else{
                    int R=0;
                    int G=0;
                    int B=0;
                    int grain = grains[i][j].getId();
                    switch(grain%3){
                        case 0:
                            R=(grain*10+100)%254;
                            G=(grain*5+100)%254;
                            B=(grain*2+100)%254;
                            break;
                        case 1:
                            R=(grain*2+100)%254;
                            G=(grain*10+100)%254;
                            B=(grain*5+100)%254;
                            break;
                        case 2:
                            R=(grain*5+100)%254;
                            G=(grain*2+100)%254;
                            B=(grain*10+100)%254;
                            break;
                        default:
                            break;
                    }
                    
                    g.setColor(new Color(R,G,B));
                }
                g.fillRect(Math.round((max_x/size_x)*i),Math.round((max_y/size_y)*j),Math.round(max_x/size_x),Math.round(max_y/size_y));
            } 
        }
    }
}
