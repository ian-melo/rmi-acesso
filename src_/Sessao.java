import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sessao {
    //ATRIBUTOS
    /**
     * Data e hora de entrada
     */
    private static java.util.Date dataHoraEnt;
    /**
     * Data e hora da última saída
     */
    private static java.util.Date dataHoraSai;
    /**
     * Usuário
     */
    private static Usuario usuario = null;

    //METODOS
    /**
     * Entra com uma conta de administrador
     * @param u Usuário administrador
     * @throws AcessoException 
     */
    public static void entrar(Usuario u) throws AcessoException {
        //Impede de mais de um administrador
        if(usuario != null) {
            throw new AcessoException("Administrador já está logado.");
        }
        //Verifica os dados
        usuario = u;
        validar();
        //Define data e hora de entrada
        dataHoraEnt = new java.util.Date();
    }
    /**
     * Sai da conta de administrador
     * @throws AcessoException
     */
    public static void sair() throws AcessoException {
        //Impede de mais de um administrador
        if(usuario == null) {
            throw new AcessoException("O administrador não está logado.");
        }
        //Saída
        usuario = null;
        //Define data e hora de saída
        dataHoraSai = new java.util.Date();
    }
    /**
     * Valida os dados do administrador
     * @throws AcessoException
     */
    private static void validar() throws AcessoException {
        BancoDados bd = new BancoDados();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        
        try {
            //Define String
            sql = "SELECT * FROM Usuario WHERE Login=? AND Senha=? AND XDEAD=FALSE";
            //Prepara gatilho
            ps = bd.abrirConexao().prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            //Executa e puxa a busca
            rs = ps.executeQuery();
            //Caso não foi encontrado, informa de erro, e anula admin
            if(!rs.next()){
                usuario = null;
                throw new AcessoException("Usuário não encontrado.");
            }
            //Fecha conexão
            bd.fecharConexao();
        } catch(SQLException ex) {
            throw new AcessoException("Erro de SQL: " + ex.getMessage() + ".");
        } catch(ConexaoException ex) {
            throw new AcessoException("Erro de conexão: " + ex.getMessage() + ".");
        }
    }
    /**
     * Verifica se administrador está logado
     * @return true, caso sim<br/>false, caso não
     */
    public static boolean isUsuarioLogado() {
        return (Sessao.usuario != null);
    }
}