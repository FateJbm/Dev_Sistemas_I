/*
 * Juliano Bernardi - Todos os direitos reservados
 */
package ifrs_devsistemas1;

import telas.Login;
import telas.CadastroAgenda;
import vo.ClienteVO;
import dao.ClienteDAO;

/**
 * Trabalho de Desenvolvimento de Sistemas 1
 *
 * @author Juliano Bernardi
 */
public class IFRS_devsistemas1 {

    /**
     * Método main - Inicia o frame Login()
     * @param args não utilizados/implementados
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login menu = new Login();
        menu.setVisible(true);

    }

}
