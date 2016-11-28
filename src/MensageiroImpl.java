import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MensageiroImpl extends UnicastRemoteObject
implements MensageiroAcesso, MensageiroVerifica {
    //CONSTRUTOR
    public MensageiroImpl() throws RemoteException {
        super();
    }
    
    //IMPLEMENTADOS
    @Override
    public boolean entrar(String login, String senha) throws RemoteException {
        Usuario usu = new Usuario();
        usu.setLogin(login);
        usu.setSenha(criptografar(senha));
        
        try {
            Sessao.entrar(usu);
            return true;
        } catch (AcessoException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    @Override
    public boolean sair() throws RemoteException {
        try {
            Sessao.sair();
            return true;
        } catch (AcessoException ex) {
            return false;
        }
    }
    @Override
    public boolean isUsuarioLogado() throws RemoteException {
        return Sessao.isUsuarioLogado();
    }
    
    //METODOS
    /**
     * Criptografa o texto (senha), utilizando MD5
     * @param texto Texto a ser criptografado
     * @return Texto criptografado
     */
    private String criptografar(String texto) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(texto.getBytes(),0,texto.length());
            return (new BigInteger(1,md.digest()).toString(16));
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Não existe o algoritmo MD5!");
            return null;
        }
    }
}