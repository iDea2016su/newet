import Correction.RangingCorrection;
import Data.ItemGroup;
import Data.RFItem;

public class Main {
    public static void main (String[] argc)
    {
        ItemGroup[] itemGroups = new ItemGroup[19];
        itemGroups[0] = new ItemGroup("0i-3.txt");
        itemGroups[1] = new ItemGroup("10i-3.txt");
        itemGroups[2] = new ItemGroup("20i-3.txt");
        itemGroups[3] = new ItemGroup("30i-3.txt");
        itemGroups[4] = new ItemGroup("40i-3.txt");
        itemGroups[5] = new ItemGroup("50i-3.txt");
        itemGroups[6] = new ItemGroup("60i-3.txt");
        itemGroups[7] = new ItemGroup("70i-3.txt");
        itemGroups[8] = new ItemGroup("80i-3.txt");
        itemGroups[9] = new ItemGroup("90i-3.txt");
        itemGroups[10]= new ItemGroup("100i-3.txt");
        itemGroups[11] = new ItemGroup("110i-3.txt");
        itemGroups[12] = new ItemGroup("120i-3.txt");
        itemGroups[13] = new ItemGroup("130i-3.txt");
        itemGroups[14] = new ItemGroup("140i-3.txt");
        itemGroups[15] = new ItemGroup("150i-3.txt");
        itemGroups[16] = new ItemGroup("160i-3.txt");
        itemGroups[17] = new ItemGroup("170i-3.txt");
        itemGroups[18] = new ItemGroup("180i-3.txt");

          long len = 0;
          double[] avr = new double[19];
          for(int i=0;i<19;i++)
          {
              len = itemGroups[i].length();
              System.out.println("i:"+len);
              double sum = 0;
              for(int j=0;j<len;j++)
              {
                  double t = itemGroups[i].getDelta32(j)/2;
//
               //   System.out.println(""+t);
                  sum += t;
              }
              sum = sum / len;
              avr[i] = sum;
          }
        for(int i=0;i<19;i++) {
          System.out.println(""+avr[i]);
        }
    }
}
