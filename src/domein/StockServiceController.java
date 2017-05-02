package domein;

//public class DomeinController {

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StockServiceController extends UnicastRemoteObject implements IRemoteStockService{
      
    private StockService stockService = new StockService();

    public StockServiceController() throws RemoteException{
    }
    
    
       
    public String executeAction(String[] args) {
        return CommandFactory.createCommand(args, stockService).execute();
    }
    
}
