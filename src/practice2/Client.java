package practice2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.getRegistry(8080);
            Equation stub = (Equation) registry.lookup("Equation");
            stub.CalcEquation(2,3,-5);
        }   catch (Exception e){
            System.err.println("Client exception: "+ e.toString());
            e.printStackTrace();
        }
    }
}