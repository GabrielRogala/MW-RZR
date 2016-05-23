package automat3d;

public class Grain {

    private int id = 0;
    private double ro = 0;
    private boolean b = false;
    private boolean r = false;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRo() {
        return ro;
    }

    public void setRo(double ro) {
        this.ro = ro;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }
    
    public void addRo(double ro){
        this.ro +=ro;
    }
    
    
    
}
