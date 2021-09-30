package practice2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends EquationI {
    public static void main(String[] args){
        try{
            EquationI obj = new EquationI();

            Equation stub = (Equation) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(8080);

            registry.bind("Equation", stub);
            System.err.println("Server ready");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (Exception e){
            System.err.println("Server exception " + e.toString());
            e.printStackTrace();
        }
    }
}