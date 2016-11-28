public class Usuario {
    //ATRIBUTOS
    /**
     * Nome de login
     */
    private String login;
    /**
     * Senha
     */
    private String senha;

    //GETTER SETTER
    /**
     * Retorna nome de login
     * @return Nome de login
     */
    public String getLogin() {
        return login;
    }
    /**
     * Define nome de login
     * @param login Nome de login
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Retorna senha
     * @return Senha
     */
    public String getSenha() {
        return senha;
    }
    /**
     * Define senha
     * @param senha Senha 
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}