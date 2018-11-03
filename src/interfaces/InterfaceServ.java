package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import principal.Hotel;
import principal.Trip;

public interface InterfaceServ extends Remote {
    /**
     * Retorna uma lista de passagens
     * @param query filtro da pesquisa
     * @return lista de passagens
     * @throws RemoteException
     */
    public List<Trip> searchAirfare(Trip query) throws RemoteException;

    /**
     * Compra uma passagem
     * @param query
     * @throws RemoteException
     */
    public void buyAirfare(Trip query) throws RemoteException;

    public List<Hotel> searchHotel(Hotel query) throws RemoteException;

    public void buyHotel(Hotel query) throws RemoteException;

    public void registerInterest(String event, InterfaceCliente client, String destination, Integer price) throws RemoteException;

    public void cancelRegister(String event, InterfaceCliente client, String destination, Integer price) throws RemoteException;

}
