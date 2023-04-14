package fp.tipos.test;

import fp.tipos.Cervezas;
import fp.tipos.FactoriaCervezas;

public class FactoriaCervezaTest {
	public static void main(String[] args) {
		testLeerCervezas("data\\beers1 (2).csv");
	}

	
	private static void testLeerCervezas(String fichero) {
		System.out.println("\nTestLeerCervezas");
		Cervezas c = FactoriaCervezas.leerCervezas(fichero); 
		System.out.println("   Cervezas: "+ c);
}

}

