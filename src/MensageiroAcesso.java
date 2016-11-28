public interface MensageiroAcesso {
    /**
     * 
     * @param login
     * @param senha
     * @return 
     */
    public abstract boolean entrar(String login, String senha);
    /**
     * 
     * @return 
     */
    public abstract boolean sair();
}