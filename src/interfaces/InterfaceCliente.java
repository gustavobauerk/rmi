package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCliente extends Remote {
    public void notificar(String nomeArq) throws RemoteException;

}
