package Data;

import Correction.RangingCorrection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;

public class ItemGroup {
    ArrayList group = new ArrayList<RFItem>();
    double angle = 0.0;
    String fileName;
    private boolean s1 = false;
    private boolean s2 = false;
    private boolean s3 = false;
    private double[] d1 = new double[40];
    private double[] d2 = new double[40];
    private double[] d3 = new double[40];
    Filter filter1 = new Filter();
    Filter filter2 = new Filter();
    Filter filter3 = new Filter();

    private void clear()
    {
        s1 = false;
        s2 = false;
        s3 = false;
        for(int i=0;i<40;i++)
        {
            d1[i] = d2[i] = d3[i] = 0;
        }
    }
    private boolean getStatus()
    {
        if(s1&&s2&&s3)
            return true;
        return false;
    }

    public ItemGroup(String file)
    {
        fileName = file;
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String temp;
            int lastid  = 0;
            int id = 0;
            while((temp = in.readLine()) != null)
            {
                if(temp.contains("R1:"))
                {
                    String[] res = temp.split(":");
                    if(res.length==3) {
                        s1 = true;
                        id  = Integer.valueOf(res[1]);
                        double t = Double.valueOf(res[2]);
                        if(res[2].contains("0.000"))
                        {
                            t = 0;
                        }else
                        {
                            t = RangingCorrection.ComputeRangingCorrectionPolynome(5,1600,t);
                        }
                        d1[id] = t;
                    }
                }
                if(temp.contains("R2:"))
                {
                    String[] res = temp.split(":");
                    if(res.length==3) {
                        s2 = true;
                        id  = Integer.valueOf(res[1]);
                        double t = Double.valueOf(res[2]);
                        if(res[2].contains("0.000"))
                        {
                            t = 0;
                        }else
                        {
                            t = RangingCorrection.ComputeRangingCorrectionPolynome(5,1600,t);
                        }
                        d2[id] = t;
                    }
                }
                if(temp.contains("R3:"))
                {
                    String[] res = temp.split(":");
                    if(res.length==3) {
                        s3 = true;
                        id  = Integer.valueOf(res[1]);
                        double t = Double.valueOf(res[2]);
                        if(res[2].contains("0.000"))
                        {
                            t = 0;
                        }else
                        {
                            t = RangingCorrection.ComputeRangingCorrectionPolynome(5,1600,t);
                        }
                        d3[id] = t;
                        if(s1&&s2&&s3&&(id ==39))
                        {
                            group.add(new RFItem(d1, d2, d3));
                            clear();
                        }
                    }
                }
        }

        }catch (IOException e)
        {

        }
    }
    public int length()
    {
        return group.size();
    }
    public double getDelta21(int i)
    {
        RFItem rfItem = (RFItem) group.get(i);
        return rfItem.getDelta21();
    }
    public double getDelta32(int i)
    {
        RFItem rfItem = (RFItem) group.get(i);
        return rfItem.getDelta32();
    }
    public double getDelta31(int i)
    {
        RFItem rfItem = (RFItem) group.get(i);
        return rfItem.getDelta31();
    }
    public double getD1(int index)
    {
        RFItem rfItem = (RFItem) group.get(index);
        return rfItem.getd1();
    }
    public double getD2(int index)
    {
        RFItem rfItem = (RFItem) group.get(index);
        return rfItem.getd2();
    }
    public double getD3(int index)
    {
        RFItem rfItem = (RFItem) group.get(index);
        return rfItem.getd3();
    }
}
