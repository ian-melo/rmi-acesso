public class MensageiroImpl implements MensageiroAcesso, MensageiroVerifica {
    /**
     * 
     * @param login
     * @param senha
     * @return 
     */
    @Override
    public boolean entrar(String login, String senha) {
            return false;
    }
    /**
     * 
     * @return 
     */
    @Override
    public boolean sair() {
            return false;
    }
    /**
     * 
     * @param texto
     * @return 
     */
    private String criptografar(String texto) {
            return null;
    }
    /**
     * 
     * @return 
     */
    @Override
    public boolean isUsuarioLogado() {
            return false;
    }
}