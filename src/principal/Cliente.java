package principal;

import interfaces.InterfaceServ;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Cliente extends Application {
    private InterfaceServ server;
    private InterfaceClienteImpl interfaceCliente;
    Button button;
    static Cliente cliente;

    public Cliente(String path) {
        try {
            System.setProperty("java.security.policy", "file:java.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            // cria a interface do cliente
            interfaceCliente = new InterfaceClienteImpl();
            // procuro o servico de nomes
            Registry locate = LocateRegistry.getRegistry("localhost", 10000);
            // procuro a interface do servidor
            server = (InterfaceServ) locate.lookup("Server");
        } catch (RemoteException | NotBoundException e) {
        }
    }

    public Cliente() {
    }

    public static void main(String[] args) {
        cliente = new Cliente("/");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tittle of the window");
        button = new Button();
        button.setText("Click me!");
        button.setOnAction((ActionEvent t) -> {
            cliente.consultaPassagem();
        });
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    public void consultaPassagem() {
        try {
            Trip trip = new Trip();
            List<Trip> result = new ArrayList<>();
            trip.setNumberOfAirfares(5);
            result = server.searchAirfare(trip);
            Trip a = new Trip();
            a = result.get(0);
            System.out.println(a.getNumberOfAirfares());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    // cancela o interrese em um arquivo
    /* public void cancelar() {
     * Scanner scan = new Scanner(System.in);
     * System.out.println("Digite o arquivo desejado: ");
     * String arq = scan.nextLine();
     * try {
     * server.cancelarRegistro(arq, this.interfaceCliente);
     * System.out.println("Comando concluido com sucesso");
     * } catch (RemoteException e) {
     * }
     * }
     *
     * // baixa o arquivo desejado no servidor
     * public void download() {
     * Scanner scan = new Scanner(System.in);
     * System.out.println("Digite o arquivo desejado: ");
     * String arq = scan.nextLine();
     * try {
     * byte[] arquivo = server.download(arq);
     * if (arquivo == null) {
     * System.out.println("Arquivo não encontrado");
     * return;
     * }
     * System.out.println("Comando concluido com sucesso");
     * } catch (RemoteException e) {
     * }
     * }
     *
     * // envia um arquivo ao servidor
     * public void upload() {
     * Scanner scan = new Scanner(System.in);
     * System.out.println("Digite o arquivo desejado: ");
     * String arq = scan.nextLine();
     * try {
     * System.out.println("Comando concluido com sucesso");
     * } catch (Exception e) {
     * }
     * }
     *
     * /**
     * asdasd
     */
 /* public void registrar() {
     * Scanner scan = new Scanner(System.in);
     * int min;
     * System.out.println("Digite o arquivo desejado: ");
     * String arq = scan.nextLine();
     * System.out.println("Digite quantos minutos esse interrese é valido: ");
     * min = scan.nextInt();
     * try {
     * Date dataValidade = new Date();
     * dataValidade.setMinutes(dataValidade.getMinutes() + min);
     * server.registrarInteresse(arq, this.interfaceCliente, dataValidade);
     * System.out.println("Comando concluido com sucesso");
     * } catch (RemoteException e) {
     * }
     * } */
    /**
     * consulta os arquivos disponiveis no Server
     */
    /* public void consultar() {
     * ArrayList<String> lista = null;
     * try {
     * lista = server.consultar();
     * } catch (RemoteException e) {
     * System.out.println("problemas ao se conectar ao Server: " + e.getMessage());
     * }
     * if (lista == null || lista.isEmpty()) {
     * System.out.println("Nenhum arquivo disponivel");
     * return;
     * }
     * System.out.println("Arquivos disponiveis: ");
     * for (String s : lista) {
     * System.out.println(s);
     * }
     * } */
}
