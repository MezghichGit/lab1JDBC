
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/

import java.sql.*;

public class Principale {

	public static void main(String[] args) throws SQLException {
		//System.out.println("Hello JDBC");
		
		// STEP 1: on établit une connexion avec la base de données mysql
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isikabd","root","");
		//System.out.println(con);
		
		// STEP 2: Création d'un objet statement pour écrire les commandes SQL
		Statement stmt = con.createStatement();
		
		// STEP 3: Création objet ResultSET(table en mémoire) dont le rôle est de stocker le résultat d'une requete select
		ResultSet rs = stmt.executeQuery("select id, nom, age from candidat");
		
		// STEP 4: On fait le parcours du ResultSet et on affiche son contenu
		while(rs.next()) {
			
		int id = rs.getInt("id");
		String nom = rs.getString("nom");
		int age = rs.getInt("age");
		System.out.println(id+ " "+nom +" "+age);
		}
		
		System.out.println("Fin du traitement");
	}

}
