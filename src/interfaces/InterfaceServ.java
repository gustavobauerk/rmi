package interfaces;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface InterfaceServ extends Remote {

	public ArrayList<String> consultar() throws RemoteException;

	public byte[] download(String nomeArq) throws RemoteException;

	public int upload(byte[] f, String nome) throws RemoteException;;

	public void registrarInteresse(String nomeArq, InterfaceCliente cliente, Date dataValidade) throws RemoteException;

	public void cancelarRegistro(String nomeArq, InterfaceCliente cliente) throws RemoteException;
}
