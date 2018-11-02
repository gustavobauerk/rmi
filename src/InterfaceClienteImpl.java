import interfaces.InterfaceCliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InterfaceClienteImpl extends UnicastRemoteObject implements InterfaceCliente {
    protected InterfaceClienteImpl() throws RemoteException {
        super();
    }

    /**
     * Notifica o usuário que a viagem interessada está disponivel
     * @param nomeArq
     */
    @Override
    public void notificar(String nomeArq) {
        System.out.println("Viagem " + nomeArq + " disponivel");
    }

}
