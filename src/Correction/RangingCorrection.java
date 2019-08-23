package Correction;

public class RangingCorrection {
    private static final int LORA_SF5 = 5;
    private static final int LORA_SF6 = 6;
    private static final int LORA_SF7 = 7;
    private static final int LORA_SF8 = 8;
    private static final int LORA_SF9 = 9;
    private static final int LORA_SF10 = 10;
    private static final int LORA_SF11 = 11;
    private static final int LORA_SF12 = 12;

    private static final int LORA_BW_0200 = 200;
    private static final int LORA_BW_0400 = 400;
    private static final int LORA_BW_0800 = 800;
    private static final int LORA_BW_1600 = 1600;


    private double GetRangingCorrectionPerSfBwGain(int sf,  int bw, int gain)
    {
        int sf_index = 0, bw_index = 0;

        switch(sf){
            case LORA_SF5:
                sf_index = 0;
                break;
            case LORA_SF6:
                sf_index = 1;
                break;
            case LORA_SF7:
                sf_index = 2;
                break;
            case LORA_SF8:
                sf_index = 3;
                break;
            case LORA_SF9:
                sf_index = 4;
                break;
            case LORA_SF10:
                sf_index = 5;
                break;
        }
        switch(bw){
            case LORA_BW_0400:
                bw_index = 0;
                break;
            case LORA_BW_0800:
                bw_index = 1;
                break;
            case LORA_BW_1600:
                bw_index = 2;
                break;
        }
        double correction = RangingCorrectionPerSfBwGain.run(sf_index,bw_index,gain);
        return correction;
    }
    public static  double ComputeRangingCorrectionPolynome(int sf, int bw, double median)
    {
        int sf_index = 0, bw_index = 0;
        switch(sf){
            case LORA_SF5:
                sf_index = LORA_SF5;
                break;
            case LORA_SF6:
                sf_index = LORA_SF6;
                break;
            case LORA_SF7:
                sf_index = LORA_SF7;
                break;
            case LORA_SF8:
                sf_index = LORA_SF8;
                break;
            case LORA_SF9:
                sf_index = LORA_SF9;
                break;
            case LORA_SF10:
                sf_index = LORA_SF10;
                break;
        }
        switch(bw){
            case LORA_BW_0400:
                bw_index = LORA_BW_0400;
                break;
            case LORA_BW_0800:
                bw_index = LORA_BW_0800;
                break;
            case LORA_BW_1600:
                bw_index = LORA_BW_1600;
                break;
        }
        RangingCorrectionPolynomes_t polynome = RangingCorrectionPerSfBwGain.ploy(sf_index,bw_index);
        double correctedValue = 0.0;
        double correctionCoeff = 0;
        for(int order = 0; order < polynome.order; order++){
            correctionCoeff = polynome.coefficients[order] * Math.pow(median, polynome.order - order - 1);
            correctedValue += correctionCoeff;
        }
        return correctedValue;
    }

}
