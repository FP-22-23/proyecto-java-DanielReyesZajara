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
		 
		 //Test del Existe + Stream
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getCervezaColorStream");
		 testGetCervezaColorStream(cvs, Color.BLACK);
		 
		 //Test del media + stream
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getMediaCervezaAmarguraDeUnColorSt");
		 testGetMediaCervezaAmarguraDeUnColorSt(cvs, Color.GOLD);
		 
		 //Test filtrado + stream
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getCervezasPorUnElementoDeSuAtributoListaSt");
		 testGetCervezasPorElementoDeSuAtributoListaSt(cvs, "crime");
		 
		 //Test max + stream
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getCervezaMayorAbvDadoUnAño");
		 testGetCervezaMayorAbvDadoUnAño(cvs, 2022);
		 
		 //Test filtrado + ordenacion + Seleccion
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getNombresCervezasOrdenadosAlfabeticamenteDadoUnBool");
		 testGetNombresCervezasOrdenadosAlfabeticamenteDadoUnBool(cvs, true);
		 
		 //Test Agrupacion + Stream
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getCervezasPorOuncesStream");
		 testGetCervezaPorOuncesStream(cvs);
		 
		 //Test mapping
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getEstiloCervezaPorColor");
		 testGetEstiloCervezaPorColor(cvs);
		 
		 //Test clave/atributo y valor max/min
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getMinimoIbuPorBooleano");
		 testGetMinimoIbuPorBooleano(cvs);
		 
		 //Test SortedMap y valores n mejores de un atributo
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getTopNDeAbvPorMes");
		 testGetTopNDeAbvPorMes(cvs, 3);
		 
		 //Test de Map devuelve la clave del max/min del valor del todo el Map
		 System.out.println("--------------------------------------------------");
		 System.out.println("Test de getBooleanoConMenorIbu");
		 testGetBooleanoConMenorIbu(cvs);

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
	
	private static void testGetCervezaColorStream(Cervezas cvs, Color co) {
		System.out.println("¿Existe alguna cervza de color "+co+"?");
		System.out.println(cvs.getCervezaColorStream(co));
	}
	
	private static void testGetMediaCervezaAmarguraDeUnColorSt(Cervezas cvs, Color co) {
		System.out.println("La media de amargura de las cervezas de color " + co + " es :");
		System.out.println(cvs.getMediaCervezaArmaguraDeUnColorSt(co));
	}
	
	private static void testGetCervezasPorElementoDeSuAtributoListaSt(Cervezas cvs, String gen) {
		System.out.println("Las cervezas que tienen el elementom"+ gen + "en su lista son: ");
		System.out.println(cvs.getCervezasPorElementoDeSuAtributoListaSt(gen));
	}
	
	private static void testGetCervezaMayorAbvDadoUnAño(Cervezas cvs, Integer a) {
		System.out.println("La cerveza con mayor abv del año " + a + "es: ");
		System.out.println(cvs.getCervezaMayorAbvDadoUnAño(a));
	}
	
	private static void testGetNombresCervezasOrdenadosAlfabeticamenteDadoUnBool(Cervezas cvs, Boolean b) {
		System.out.println("Los nombres de las cervezas ordenadas alfabeticamente por nombre que contiene un "+ b +" en su atributos son: ");
		System.out.println(cvs.getNombresCervezasOrdenadosAlfabeticamenteDadoUnBool(b));
	}
	
	private static void testGetCervezaPorOuncesStream(Cervezas cvs) {
		System.out.println("Las cervezas por cada numero de ounces de la cerveza son: ");
		System.out.println(cvs.getCervezaPorOuncesStream());
	}
	
	private static void testGetEstiloCervezaPorColor(Cervezas cvs) {
		System.out.println("Los estilos de cervezas por cada color de cerveza son los siguientes: ");
		System.out.println(cvs.getEstiloCervezaPorColor());
	}
	
	private static void testGetMinimoIbuPorBooleano(Cervezas cvs) {
		System.out.println("Los menores ibus de cervezas por cada booleano son: ");
		System.out.println(cvs.getMinimoIbuPorBooleano());
	}
	
	private static void testGetTopNDeAbvPorMes(Cervezas cvs, Integer n) {
		System.out.println("El TOP "+n+" de abv de cervezas por cada mes es: ");
		System.out.println(cvs.getTopNDeAbvPorMes(n));
	} 
	
	private static void testGetBooleanoConMenorIbu(Cervezas cvs) {
		System.out.println("El booleano con menor ibu de todos es: ");
		System.out.println(cvs.getBooleanoConMenorIbu());
	}

}
