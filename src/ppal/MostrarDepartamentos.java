package ppal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.ConexionBD;

public class MostrarDepartamentos {

	public static void main(String[] args) {
		
		ConexionBD conexion = new ConexionBD();
		
		
		
		
		System.out.println("Conectando a la base de datos...");
		// Paso 1. Obtener la conexión
		Connection con = conexion.getConexion();
		
		// Objetos necesarios para hacer una consulta
		Statement sentencia= null;
		ResultSet resultado = null;
		
		// Algún procesamiento con la base de datos..
		try {
			// Paso 2. Obtener el Statement
			sentencia = con.createStatement();
			
			// Paso 3. Ejecutar la sentencia
			resultado=sentencia.executeQuery("select * from departamentos");
			System.out.println("Cod. Departamento\tCod. Centro\tCod. Director\tTipo Dirección\tPresupuesto\tCod. Depto Jefe\tNombre");
			// Paso 4. Recorrer el resultado
			while(resultado.next()) {
				int codDepartamento = resultado.getInt("cod_departamento");
				int codCentro = resultado.getInt("cod_centro");
				int codDirector = resultado.getInt("cod_director");
				String tipoDir =resultado.getString("tipo_dir");
				int presupuesto = resultado.getInt("presupuesto");
				int codDptoJefe = resultado.getInt("cod_dpto_jefe");
				String nombre =resultado.getString("nombre");
				
				System.out.println(codDepartamento+"\t\t"+codCentro+"\t\t"+codCentro+"\t\t"+codDirector+"\t\t"+tipoDir+"\t\t"+presupuesto+"\t\t"+codDptoJefe+"\t\t"+nombre);	
			}
			
		} catch (SQLException e) {
			System.out.println("Error al consultar los datos. "
		       +e.getMessage());
		} finally {
			try {
				resultado.close();
				sentencia.close();
			} catch (SQLException e) {
				System.out.println("Error al liberar los recursos");
			}
		}
		

		// Liberamos la conexión
		System.out.println("Desconectando de la base de datos");
		conexion.desconectar();
	}

}
