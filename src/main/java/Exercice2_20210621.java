import java.sql.*;
import java.util.Scanner;
public class Exercice2_20210621 {
	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/isikabd","root","");
		Statement stmt = con.createStatement();		
		
		Scanner lect = new Scanner(System.in);
		System.out.println("Quel est le libellé ?");
		String libelle_valeur = lect.nextLine();		
		stmt.executeUpdate("insert into groupe(libelle) values('"+libelle_valeur+"')");		
		
		ResultSet rs = stmt.executeQuery("select id, libelle from groupe");		
		
		while(rs.next()) {			
			int id = rs.getInt("id");
			String libelle = rs.getString("libelle");
			System.out.println(id+ " "+libelle);
			}
			
			System.out.println("Fin du traitement");	
	}
}