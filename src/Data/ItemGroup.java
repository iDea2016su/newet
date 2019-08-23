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
    private double d1 = 0;
    private double d2 = 0;
    private double d3 = 0;
    Filter filter1 = new Filter();
    Filter filter2 = new Filter();
    Filter filter3 = new Filter();

    private void clear()
    {
        s1 = false;
        s2 = false;
        s3 = false;
        d1 = 0;
        d2 = 0;
        d3 = 0;
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
            while((temp = in.readLine()) != null)
            {
                if(temp.contains("1:"))
                {
                    String[] res = temp.split(":");
                    if(res.length==2) {
                        s1 = true;
                        d1 = filter1.get(d1);
                        d1 = Double.valueOf(res[1]);
                    }
                }
                if(temp.contains("2:"))
                {
                    String[] res = temp.split(":");
                    if(res.length==2) {
                        s2 = true;
                        d2 = filter1.get(d2);
                        d2 = Double.valueOf(res[1]);
                    }
                }
                if(temp.contains("3:"))
                {
                    String[] res = temp.split(":");
                    if(res.length==2) {
                        s3 = true;
                        d3 = filter3.get(d1);
                        d3 = Double.valueOf(res[1]);
                        if (d1 > 0.1 && d3 > 0.1) {
                            if ((Math.abs(d2 - d1) < 30)) {
                                group.add(new RFItem(d1, d2, d3, 0));
                            }
                        }
                    }
                    clear();
                }
           // System.out.println(temp);
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
}
