import interfaces.InterfaceServ;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cliente {
    private InterfaceServ server;
    private InterfaceClienteImpl interfaceCliente;

    public Cliente(String path) {
        System.setProperty("java.security.policy", "file:java.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // cria a interface do cliente
            interfaceCliente = new InterfaceClienteImpl();
            // procuro o servico de nomes
            Registry locate = LocateRegistry.getRegistry("localhost", 10000);
            // procuro a interface do servidor
            server = (InterfaceServ) locate.lookup("Server");
        } catch (RemoteException | NotBoundException e) {
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("digite o nome da pasta: ");
        String a = scan.nextLine();
        Cliente cliente = new Cliente("arquivos/" + a);
        cliente.loop();
    }

    // essa funcao fica em loop recebendo os comandos do usuario
    private void loop() {
        if (this.server == null) {
            return;
        }
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        while (flag) {
            System.out.println("Digite um comando: ");
            String comando = scan.nextLine();
            if (comando.equalsIgnoreCase("SAIR")) {
                break;
            }
            if (comando.equalsIgnoreCase("CONSULTAR")) {
                consultar();
            }
            if (comando.equalsIgnoreCase("REGISTRAR")) {
                registrar();
            }
            if (comando.equalsIgnoreCase("DOWNLOAD")) {
                download();
            }
            if (comando.equalsIgnoreCase("UPLOAD")) {
                upload();
            }
            if (comando.equalsIgnoreCase("CANCELAR")) {
                cancelar();
            }
        }
        System.out.println("fim: ");
    }

    // cancela o interrese em um arquivo
    public void cancelar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o arquivo desejado: ");
        String arq = scan.nextLine();
        try {
            server.cancelarRegistro(arq, this.interfaceCliente);
            System.out.println("Comando concluido com sucesso");
        } catch (RemoteException e) {
        }
    }

    // baixa o arquivo desejado no servidor
    public void download() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o arquivo desejado: ");
        String arq = scan.nextLine();
        try {
            byte[] arquivo = server.download(arq);
            if (arquivo == null) {
                System.out.println("Arquivo não encontrado");
                return;
            }
            System.out.println("Comando concluido com sucesso");
        } catch (RemoteException e) {
        }
    }

    // envia um arquivo ao servidor
    public void upload() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o arquivo desejado: ");
        String arq = scan.nextLine();
        try {
            System.out.println("Comando concluido com sucesso");
        } catch (Exception e) {
        }
    }

    /**
     * asdasd
     */
    public void registrar() {
        Scanner scan = new Scanner(System.in);
        int min;
        System.out.println("Digite o arquivo desejado: ");
        String arq = scan.nextLine();
        System.out.println("Digite quantos minutos esse interrese é valido: ");
        min = scan.nextInt();
        try {
            Date dataValidade = new Date();
            dataValidade.setMinutes(dataValidade.getMinutes() + min);
            server.registrarInteresse(arq, this.interfaceCliente, dataValidade);
            System.out.println("Comando concluido com sucesso");
        } catch (RemoteException e) {
        }
    }

    /**
     * consulta os arquivos disponiveis no Server
     */
    public void consultar() {
        ArrayList<String> lista = null;
        try {
            lista = server.consultar();
        } catch (RemoteException e) {
            System.out.println("problemas ao se conectar ao Server: " + e.getMessage());
        }
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum arquivo disponivel");
            return;
        }
        System.out.println("Arquivos disponiveis: ");
        for (String s : lista) {
            System.out.println(s);
        }
    }

}
