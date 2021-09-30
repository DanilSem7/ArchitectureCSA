package practice2;

import java.rmi.RemoteException;

import static java.lang.Math.sqrt;

public class EquationI implements Equation {
    @Override
    public void CalcEquation(int a, int b, int c) throws RemoteException {
        int Discriminant = b*b - 4 * a * c;
        if(Discriminant > 0){
            double x1 = (-b + sqrt(Discriminant))/(2*a);
            double x2 = (-b - sqrt(Discriminant))/(2*a);
            System.out.println("Первый корень уравнения: " + x1 + "\n"
                    + "Второй корень уравнения: " + x2);
        } else if(Discriminant == 0){
            double x1 = -b/(2*a);
            System.out.println("Корень уравнения: " + x1);
        } else {
            System.out.println("Корней нет");
        }

    }
}