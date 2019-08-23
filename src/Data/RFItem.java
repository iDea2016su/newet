package Data;

public class RFItem {
    private double d1 = 0;
    private double d2 = 0;
    private double d3 = 0;
    private double d4 = 0;

    public RFItem(double d1,double d2, double d3, double d4) {
       this.d1 = d1;
       this.d2 = d2;
       this.d3 = d3;
       this.d4 = d4;
    }
    public double getDelta21()
    {
        return d2-d1;
    }
    public double getDelta41()
    {
        return d4-d1;
    }
    public double getDelta32()
    {
        return d3-d2;
    }
    public double getDelta31()
    {
        return d3-d1;
    }
}
