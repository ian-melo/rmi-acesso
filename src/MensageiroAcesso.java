public interface MensageiroAcesso {
    /**
     * Entra na conta administrador
     * @param login Login da conta
     * @param senha Senha da conta
     * @return true, caso sucesso<br/>false, caso contrário
     */
    public abstract boolean entrar(String login, String senha);
    /**
     * Sai da conta administrador
     * @return true, caso sucesso<br/>false, caso contrário
     */
    public abstract boolean sair();
}