package Main;
import Class.ConectorDB;
import UI.FromPrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author jara
 */
public class java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FromPrincipal ui = new FromPrincipal();
        ui.setVisible(true);
    }

}
