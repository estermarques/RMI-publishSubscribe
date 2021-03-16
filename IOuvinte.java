package pubSub;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface IOuvinte extends Remote {
    public void notificar( String dados, String topico ) throws RemoteException;
}
