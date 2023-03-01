/**
 * @Author : N'ZO LAGOU
 * Exercice 1 : Opération UPDATE
 * Instructions
 * Dans cet exercice, vous utiliserez l'instruction UPDATE pour mettre à jour n'importe quel enregistrement, puis récupérer
 * et afficher les enregistrements mis à jour de la table COMPANY à l'aide de PostgreSQL JDBC.
 *
 * Créez une connexion de base de données au serveur PostgreSQL.
 *
 * Créez un objet Statement.
 *
 * Exécuter une instruction pour mettre à jour les enregistrements
 *
 * UPDATE COMPANY set SALARY = 25000.00 where ID=1;
 * Fermez la connexion à la base de données.
 */


package exercice1;

import database.Connexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercice1 {
    public static int updateData() {
        final String SQL = """
                    UPDATE company
                    SET salary = 25000.00
                    WHERE id = 1
                """;
        int affectedRow = 0;

        try {
            Connection connection = new Connexion().getConnecion();
            Statement statement = connection.createStatement();
            affectedRow = statement.executeUpdate(SQL);

            if (affectedRow == 0) {
                System.out.println("Aucune ligne modifiée!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return affectedRow;
    }
}
