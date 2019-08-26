import Correction.RangingCorrection;
import Data.ItemGroup;
import Data.RFItem;

public class Main {
    public static void main (String[] argc)
    {
        ItemGroup[] itemGroups = new ItemGroup[19];
        itemGroups[0] = new ItemGroup("0k-3.txt");
        itemGroups[1] = new ItemGroup("10k-3.txt");
        itemGroups[2] = new ItemGroup("20k-3.txt");
        itemGroups[3] = new ItemGroup("30k-3.txt");
        itemGroups[4] = new ItemGroup("40k-3.txt");
        itemGroups[5] = new ItemGroup("50k-3.txt");
        itemGroups[6] = new ItemGroup("60k-3.txt");
        itemGroups[7] = new ItemGroup("70k-3.txt");
        itemGroups[8] = new ItemGroup("80k-3.txt");
        itemGroups[9] = new ItemGroup("90k-3.txt");
        itemGroups[10]= new ItemGroup("100k-3.txt");
        itemGroups[11] = new ItemGroup("110k-3.txt");
        itemGroups[12] = new ItemGroup("120k-3.txt");
        itemGroups[13] = new ItemGroup("130k-3.txt");
        itemGroups[14] = new ItemGroup("140k-3.txt");
        itemGroups[15] = new ItemGroup("150k-3.txt");
        itemGroups[16] = new ItemGroup("160k-3.txt");
        itemGroups[17] = new ItemGroup("170k-3.txt");
        itemGroups[18] = new ItemGroup("180k-3.txt");

          long len = 0;
          double[] avr = new double[19];
          for(int i=0;i<19;i++)
          {
              len = itemGroups[i].length();
              System.out.println("i:"+len);
              double sum = 0;
              int inv = 0;
              for(int j=0;j<len;j++)
              {
                  double t = itemGroups[i].getDelta21(j);
                  if(Math.abs(t)<1) {
                      sum += t;
                  }
                  else
                  {
                      inv ++;
                  }
              }
              sum = sum / (len+inv);
              avr[i] = sum;
          }
        for(int i=0;i<19;i++) {
          System.out.println(""+avr[i]);
        }
    }
}
