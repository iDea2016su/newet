package Correction;

public class RangingCorrectionPolynomes_t {
    public static final int  NUMBER_OF_FACTORS_PER_SFBW = 160;
    public final int  MAX_POLYNOME_ORDER = 10;
    public int order;
    public double[] coefficients = new double[MAX_POLYNOME_ORDER];
    public RangingCorrectionPolynomes_t()
    {

    }
    public RangingCorrectionPolynomes_t(int order, double[] coefficients)
    {
        this.order = order;
        for(int i=0;i<coefficients.length;i++)
        {
            this.coefficients[i] = coefficients[i];
        }
    }
}
