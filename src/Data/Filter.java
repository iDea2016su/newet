package Data;

public class Filter {
    double Q = 0.1;
    double R = 10;

    double A = 1;
    double C = 1;
    double X_pre = 0;
    double P_pre = 0;
    double Xkf_k1 = 8;
    double P_k1 = 1;
    double Kg = 0;

    public double get(double z)
    {
        X_pre = A*Xkf_k1;
        P_pre = P_k1+Q;
        Kg = P_pre/(P_pre+R);
        Xkf_k1 = X_pre+Kg*(z-C*X_pre);
        P_k1 = (1-Kg*C)*P_pre;
        return Xkf_k1;
    }
}
