

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

public class ConectDataBase {

   public static void main(String[] args) {
         // Create the CqlSession object:
         try (CqlSession session = CqlSession.builder()
            .withCloudSecureConnectBundle(Paths.get("URL_ZIP"))
            .withAuthCredentials("Your credencials astra has")
            .build()) {
            // Select the release_version from the system.local table:
            String keyspace = "pepes";
            ResultSet rs = session.execute("USE " + keyspace+";");
            rs = session.execute("select * from mock;");
            Row row = rs.one();
            
            while ((row = rs.one()) != null) {
                int id = row.getInt("id");
                String email = row.getString("email");
                String firstName = row.getString("first_name");
                String gender = row.getString("gender");
                String ipAddress = row.getString("ip_address");
                String lastName = row.getString("last_name");

                // Imprimir los valores de cada fila
                System.out.println("ID: " + id);
                System.out.println("Email: " + email);
                System.out.println("First Name: " + firstName);
                System.out.println("Gender: " + gender);
                System.out.println("IP Address: " + ipAddress);
                System.out.println("Last Name: " + lastName);
                System.out.println("-------------------------");
}
         }
         System.exit(0);
   }
}