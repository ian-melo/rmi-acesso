import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerAcesso {
    /**
     * Principal método de execução do servidor de acesso
     * @param args Argumentos
     */
    public static void main(String[] args) {
        try {
            MensageiroAcesso menAcesso = new MensageiroImpl();
            MensageiroVerifica menVerifica = new MensageiroImpl();
            //Registro de MensageiroAcesso
            LocateRegistry.createRegistry(14001);
            Naming.rebind("rmi://localhost:14001/MensageiroAcesso", menAcesso);
            //Registro de MensageiroVerifica
            LocateRegistry.createRegistry(14002);
            Naming.rebind("rmi://localhost:14002/MensageiroVerifica", menVerifica);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex);
            System.exit(1);
        }
        System.out.println("Servidor de acesso ativo...");
    }
}