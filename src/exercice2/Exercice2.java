/**
 * @Author : N'ZO LAGOU
 * Exercice 2 : Opération DELETE
 * Instructions
 * Dans cet exercice, vous utiliserez l'instruction DELETE pour supprimer n'importe quel enregistrement, puis récupérerez
 * et afficherez les enregistrements restants de la table COMPANY à l'aide de PostgreSQL JDBC.
 *
 * Créez une connexion de base de données au serveur PostgreSQL.
 *
 * Créez un objet Statement.
 *
 * Exécuter une instruction pour supprimer des enregistrements
 *
 * DELETE from COMPANY where ID = 2;
 * Fermez la connexion à la base de données.
 */

package exercice2;

import database.Connexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercice2 {
    public static int deleteData() {
        final String SQL = """
                    DELETE FROM company
                    WHERE id = 2
                """;
        int affectedRow = 0;

        try {
            Connection connection = new Connexion().getConnecion();
            Statement statement = connection.createStatement();
            affectedRow = statement.executeUpdate(SQL);

            if (affectedRow == 0) {
                System.out.println("Aucune ligne supprimée!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return affectedRow;
    }
}
