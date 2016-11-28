public class MensageiroImpl implements MensageiroAcesso, MensageiroVerifica {
    //IMPLEMENTADOS
    @Override
    public boolean entrar(String login, String senha) {
            return false;
    }
    @Override
    public boolean sair() {
            return false;
    }
    @Override
    public boolean isUsuarioLogado() {
            return false;
    }
    
    //METODOS
    /**
     * Criptografa o texto (senha), utilizando MD5
     * @param texto Texto a ser criptografado
     * @return Texto criptografado
     */
    private String criptografar(String texto) {
            return null;
    }
}