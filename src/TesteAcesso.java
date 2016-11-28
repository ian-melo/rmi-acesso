import java.rmi.RemoteException;

public class TesteAcesso {
    
    public static void main(String[] args) throws RemoteException, ConexaoException {
        MensageiroAcesso mensa = new MensageiroImpl();
        MensageiroVerifica mensa2 = new MensageiroImpl();
        
        if(!mensa.sair()) {
            System.out.println("Logout não ocorreu, tá certo!!!");
        } else {
            System.out.println("Problema no logout");
            return;
        }
        
        if(mensa.entrar("admin", "123")) {
            System.out.println("Login efetuado com sucesso!!!");
        } else {
            System.out.println("Problema no login");
            return;
        }
        
        if(mensa2.isUsuarioLogado()) {
            System.out.println("Sucesso na verificação!!!");
        } else {
            System.out.println("Problema na verificação");
            return;
        }
        
        if(mensa.sair()) {
            System.out.println("Logout efetuado com sucesso!!!");
        } else {
            System.out.println("Problema no logout");
            return;
        }
        System.exit(0);
    }
}