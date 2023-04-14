package fp.tipos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import fp.utiles.Checkers;

public class FactoriaCervezas {
	public static Cervezas leerCervezas(String fichero){
		Cervezas res= null;
		try {
			Stream<Cerveza>datos=Files.lines(Paths.get(fichero))
					.skip(1)
					.map(FactoriaCervezas::parsearCerveza);
			 res= new Cervezas(datos);
			
			}catch(IOException e) {
			e.printStackTrace();
			}
		return res;
	}
	
	private static Cerveza parsearCerveza(String linea) {
		//Split por separador
		String[] trozos = linea.split(",");
		
		//Restricciones
		checkNombre(trozos[4].trim());
		checkNombre(trozos[5].trim());
		Checkers.check("El número de trozos debe ser 11",trozos.length ==11 );
		
		//Asignaciones
		Integer num = Integer.valueOf(trozos[0].trim());
		Integer abv = Integer.valueOf(trozos[1].trim());
		Double ibu = Double.valueOf(trozos[2].trim());
		Integer id = Integer.valueOf(trozos[3].trim());
		String name = trozos[4].trim();
		String style = trozos[5].trim();
		Double ounces = Double.valueOf(trozos[6].trim());
		Boolean booleano = parseaBoolean(trozos[7].trim());
		LocalDate fecha = LocalDate.parse(trozos[8].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		List<String> lista = parsearLista(trozos[9].trim());
		Color color = parseaColor(trozos[10].trim());
		
		return new Cerveza(num,abv,ibu,id,name,style,ounces,booleano,fecha,lista,color);
	}

	private static List<String> parsearLista(String cad) {
		String limpia = cad.replace("[","").replace("'", "")
				.replaceAll(" ", "");
		String[] trozos = limpia.split(";");
		
		List<String> res = new ArrayList<>();
		for(String trozo: trozos) {
			res.add(trozo);
		}
		return res;
	}

	private static Boolean parseaBoolean(String cadena) {
		Boolean res = null;
		cadena = cadena.toUpperCase();
		if(cadena.equals("TRUE")) {
			res = true;
		}
		else {
			res = false;
		}
		return res;
	}

	private static void checkNombre(String n) {
		if(n.equals("")) {
			throw new IllegalArgumentException("El nombre no puede ser vacio");
		}
	}
	
	private static Color parseaColor(String c) {
		Color res = Color.RED;
		if(c.equals("Black")) {
			res = Color.BLACK;
		}else if(c.equals("Gold")){
			res = Color.GOLD;
		}
		return res;
	}
}

