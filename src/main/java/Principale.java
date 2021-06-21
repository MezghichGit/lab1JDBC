
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/

import java.sql.*;
import java.util.Scanner;

public class Principale {

	public static void main(String[] args) throws SQLException {
		//System.out.println("Hello JDBC");
		
		// STEP 1: on établit une connexion avec la base de données mysql
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isikabd","root","");
		//System.out.println(con);
		
		// STEP 2: Création d'un objet statement pour écrire les commandes SQL
		Statement stmt = con.createStatement();
		
		// Code d'ajout d'un nouveau candidat
		Scanner lect = new Scanner(System.in);
		/*
		System.out.println("Donner notre nom");
		String nom_value = lect.next();
		
		System.out.println("Donner notre age");
		int age_value = lect.nextInt();*/
		
		
		//int result = stmt.executeUpdate("insert into candidat(nom,age) values('"+nom_value+"', "+age_value+")");
		//System.out.println(result); // 1
		
		// fin code ajout
		
		
		// Code de mise à jour d'un candidat existant
		

		System.out.println("Quel est l'id du candidat dont vous souhaitez modifier le nom");
		int idd = lect.nextInt();
		
		System.out.println("Quel est le nouveau nom");
		String name = lect.next();
		
		int result = stmt.executeUpdate("update candidat set nom='"+name+"' where id="+idd+"");
		
		 ///int result = stmt.executeUpdate("update candidat set nom='Alain' where id=5");
		//System.out.println(result); // 1
		
		
		// Code de suppression d'un candidat existant
		//stmt.executeUpdate("delete from candidat where id=5");
	    //System.out.println(result); // 1
		
		// fin code ajout
		
	
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
