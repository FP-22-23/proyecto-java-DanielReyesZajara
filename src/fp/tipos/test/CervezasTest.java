package fp.tipos.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.tipos.Cerveza;
import fp.tipos.Cervezas;
import fp.tipos.Color;
import fp.tipos.FactoriaCervezas;

public class CervezasTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Cervezas cvs = FactoriaCervezas.leerCervezas("data\\beers1 (2).csv");
		 //Leer las cervezas
		 System.out.println("Las cervezas son: " + cvs);
		 
		 //Test del metodo del EXISTE
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getCervezaColor");
		 testGetCervezaColor(cvs,Color.RED);
		 
		 //Test del metodo de la media
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getMediaAmarguraDeUnColor");
		 testGetMediaAmarguraDeUnColor(cvs, Color.BLACK);
		 
		 //Test del metodo filtro
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getCervezasPorUnElementoDeSuAtributoLista");
		 testGetCervezasPorCadaElementoDeSuAtributoLista(cvs, "comedy");
		 
		 //Test del metodo de agrupacion
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getListaCervezasPorOunces");
		 testGetListaCervezasPorOunces(cvs);
		 
		 
		 //Test del metodo acumulador
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getSumaTotalDeAbvPorAño");
		 testGetSumaTotalDeAbvPorAnyo(cvs);
	}
	
	private static void testGetSumaTotalDeAbvPorAnyo(Cervezas cvs) {
		Map<Integer,Integer> res = cvs.getSumaTotalDeAbvPorAnyo();
		System.out.println("La suma total de abv de las cervezas por año es:");
		System.out.println(res);
		
	}

	private static void testGetListaCervezasPorOunces(Cervezas cvs) {
		Map<Double, List<Cerveza>> dicc = cvs.getListaCervezasPorOunces();
		System.out.println("La lista de cervezas por ounces es la siguiente:");
		System.out.println(dicc);
		
	}

	private static void testGetCervezasPorCadaElementoDeSuAtributoLista(Cervezas cvs, String string) {
		Set<Cerveza> res = cvs.getCervezasPorUnElementoDeSuAtributoLista(string);
		System.out.println("Las cervezas que tienen el elemento "+ string+ " son:");
		System.out.println(res);
		
	}

	private static void testGetMediaAmarguraDeUnColor(Cervezas cvs, Color co) {
		Double Media = cvs.getMediaAmarguraCervezaDeUnColor(co);
		System.out.println("La media de amargura de las cervezas de color " + co + " es:");
		System.out.println("Media = " + Media);
		
	}

	private static void testGetCervezaColor(Cervezas cvs, Color co) {
		System.out.println("¿Existe alguna cerveza de color "+ co +"?");
		System.out.println(cvs.getCervezaColor(co));
	}

}
