package stocksystemcompleted;

import domein.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockSystem {

    //private StockServiceController controller = new StockServiceController();
    //private Scanner choose = new Scanner(System.in);

    public static void main(String[] args) {
        new StockSystem().run();
    }

    private void run() {
        /*String action = askAction();
        String mes;
        while (!action.equalsIgnoreCase("end")) {
            //mes = controller.voerOpdrachtUit(action.split(" "));
            mes = controller.executeAction(action.split(" "));
            System.out.print(mes);
            action = askAction();
        }
        choose.close();*/
        registerStockService();
    }
    
    private void registerStockService() {
        try{
            Registry registry = LocateRegistry.createRegistry(1099);
            IRemoteStockService service = new StockServiceController();
            registry.rebind("stockservice", service);
            System.out.println("RemoteStockSystem service running");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

/*
    private String askAction() {
        System.out.println("");
        System.out.println("-------------Usage:StockSystem    TaskName Arguments. Enter end to quit------------");
        //System.out.println("Tasks:");
        System.out.println("Commands:");
        System.out.println("   createProduct productname quantity");
        System.out.println("   updateQuantity productname quantity");
        System.out.println("   shipProduct productname");
        System.out.println("   showStock");
        //System.out.println("Enter task :");
        System.out.println("Enter command :");
        return choose.nextLine();
    }*/
}