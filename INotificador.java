package pubSub;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface INotificador extends Remote {
    public void seguir(String topico, String id) throws RemoteException;
}
