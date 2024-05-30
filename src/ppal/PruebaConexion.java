package ppal;

import java.sql.Connection;

import conexion.ConexionBD;

public class PruebaConexion {

	public static void main(String[] args) {
		
		ConexionBD conexion = new ConexionBD();
		System.out.println("Conectando a la base de datos...");
		Connection con = conexion.getConexion();
		
		// Algún procesamiento con la base de datos..

		// Liberamos la conexión
		conexion.desconectar();
	}

}
