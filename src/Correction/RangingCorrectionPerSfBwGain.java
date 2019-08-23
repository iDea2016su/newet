package Correction;

import Correction.Gain.*;

public  class RangingCorrectionPerSfBwGain {
    static public double run(int sf, int bw, int gain)
    {
        double res = 0.0;
       if(bw == 400)
       {
           switch (sf)
           {
               case  5:res = RangingCorrectionSF5BW0400.run(gain);break;
               case  6:res = RangingCorrectionSF6BW0400.run(gain);break;
               case  7:res = RangingCorrectionSF7BW0400.run(gain);break;
               case  8:res = RangingCorrectionSF8BW0400.run(gain);break;
               case  9:res = RangingCorrectionSF9BW0400.run(gain);break;
               case 10:res = RangingCorrectionSF10BW0400.run(gain);break;
               default:res = 0.0;break;
           }
       }
       else if(bw == 800)
       {
           switch (sf)
           {
               case  5:res = RangingCorrectionSF5BW0800.run(gain);break;
               case  6:res = RangingCorrectionSF6BW0800.run(gain);break;
               case  7:res = RangingCorrectionSF7BW0800.run(gain);break;
               case  8:res = RangingCorrectionSF8BW0800.run(gain);break;
               case  9:res = RangingCorrectionSF9BW0800.run(gain);break;
               case 10:res = RangingCorrectionSF10BW0800.run(gain);break;
               default:res = 0.0;break;
           }
       }
       else if(bw == 1600)
       {
           switch (sf)
           {
               case  5:res = RangingCorrectionSF5BW1600.run(gain);break;
               case  6:res = RangingCorrectionSF6BW1600.run(gain);break;
               case  7:res = RangingCorrectionSF7BW1600.run(gain);break;
               case  8:res = RangingCorrectionSF8BW1600.run(gain);break;
               case  9:res = RangingCorrectionSF9BW1600.run(gain);break;
               case 10:res = RangingCorrectionSF10BW1600.run(gain);break;
               default:res = 0.0;break;
           }
       }
       return res;
    }
    static public RangingCorrectionPolynomes_t ploy(int sf, int bw)
    {
        RangingCorrectionPolynomes_t res = new RangingCorrectionPolynomes_t();
        if(bw == 400)
        {
            switch (sf)
            {
                case  5:res = RangingCorrectionSF5BW0400.getPolynomes_t();break;
                case  6:res = RangingCorrectionSF6BW0400.getPolynomes_t();break;
                case  7:res = RangingCorrectionSF7BW0400.getPolynomes_t();break;
                case  8:res = RangingCorrectionSF8BW0400.getPolynomes_t();break;
                case  9:res = RangingCorrectionSF9BW0400.getPolynomes_t();break;
                case 10:res = RangingCorrectionSF10BW0400.getPolynomes_t();break;
                default:break;
            }
        }
        else if(bw == 800)
        {
            switch (sf)
            {
                case  5:res = RangingCorrectionSF5BW0800.getPolynomes_t();break;
                case  6:res = RangingCorrectionSF6BW0800.getPolynomes_t();break;
                case  7:res = RangingCorrectionSF7BW0800.getPolynomes_t();break;
                case  8:res = RangingCorrectionSF8BW0800.getPolynomes_t();break;
                case  9:res = RangingCorrectionSF9BW0800.getPolynomes_t();break;
                case 10:res = RangingCorrectionSF10BW0800.getPolynomes_t();break;
                default:break;
            }
        }
        else if(bw == 1600)
        {
            switch (sf)
            {
                case  5:res = RangingCorrectionSF5BW1600.getPolynomes_t();break;
                case  6:res = RangingCorrectionSF6BW1600.getPolynomes_t();break;
                case  7:res = RangingCorrectionSF7BW1600.getPolynomes_t();break;
                case  8:res = RangingCorrectionSF8BW1600.getPolynomes_t();break;
                case  9:res = RangingCorrectionSF9BW1600.getPolynomes_t();break;
                case 10:res = RangingCorrectionSF10BW1600.getPolynomes_t();break;
                default:break;
            }
        }
        return res;
    }
}
