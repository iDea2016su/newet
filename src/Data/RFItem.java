package Data;

import com.sun.source.tree.ReturnTree;

public class RFItem {
    private double [] ad1 = new double[40];
    private double [] ad2 = new double[40];
    private double [] ad3 = new double[40];
    private double d1 = 0;
    private double d2 = 0;
    private double d3 =0;
    public RFItem(double[] d1,double[] d2, double[] d3) {
      for(int i=0;i<40;i++) {
            this.ad1[i] = d1[i];
        }
        for(int i=0;i<40;i++) {
            this.ad2[i] = d2[i];
        }
        for(int i=0;i<40;i++) {
            this.ad3[i] = d3[i];
        }
        double[] temp = new double[40];
        for(int i=0;i<40;i++)
        {
            temp[i] = 0;
        }
        int valid = 0;
        for(int i=0;i<40;i++)
        {
            temp[i] = ad1[i];
        }
        for(int i=0;i<40;i++)
        {
            for (int j = i + 1; j < 40; j++)
            {
                if (temp[i] < temp[j]) {
                    double t = temp[i];
                    temp[i] = temp[j];
                    temp[j] = t;
                }
            }
        }
        for(int i=0;i<40;i++)
        {
            if(temp[i]>0.1)
            {
                valid++;
            }
        }
        this.d1 = temp[valid/2];
        for(int i=0;i<40;i++)
        {
            temp[i] = 0;
        }
        valid = 0;
        for(int i=0;i<40;i++)
        {
            temp[i] = ad2[i];
        }
        for(int i=0;i<40;i++)
        {
            for (int j = i + 1; j < 40; j++)
            {
                if (temp[i] < temp[j]) {
                    double t = temp[i];
                    temp[i] = temp[j];
                    temp[j] = t;
                }
            }
        }
        for(int i=0;i<40;i++)
        {
            if(temp[i]>0.1)
            {
                valid++;
            }
        }
        this.d2 = temp[valid/2];
        for(int i=0;i<40;i++)
        {
            temp[i] = 0;
        }
        valid = 0;
        for(int i=0;i<40;i++)
        {
            temp[i] = ad3[i];
        }
        for(int i=0;i<40;i++)
        {
            for (int j = i + 1; j < 40; j++)
            {
                if (temp[i] < temp[j]) {
                    double t = temp[i];
                    temp[i] = temp[j];
                    temp[j] = t;
                }
            }
        }
        for(int i=0;i<40;i++)
        {
            if(temp[i]>0.1)
            {
                valid++;
            }
        }
        this.d3 = temp[valid/2];

    }
    public double getDelta21()
    {
        return d2-d1;
    }
    public double getDelta32()
    {
        return d3-d2;
    }
    public double getDelta31()
    {
        return d3-d1;
    }
    public double getd1(){
        return d1;
    }
    public double getd2(){
        return d2;
    }
    public double getd3(){
        return d3;
    }
}
