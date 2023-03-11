package fp.tipos.test;

import java.time.LocalDate;

import fp.tipos.Cerveza;

public class CervezaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CONSTRUCTORES
				Cerveza c = new Cerveza(1,0.33,3.5,44,"APA","Amber",12.1,true,LocalDate.of(2010,02,13));
				Cerveza c2 = new Cerveza(4.6,"DOUBLE IPA","APA");
				
				System.out.println(c);
				System.out.println(c2);
				
				//GET Y SET
				System.out.println("GET Y SET");
				System.out.println(c.getNum());
				c.setName("IPA");
				System.out.println(c.getName());
				
				//DERIVADA
				System.out.println("DERIVADA");
				System.out.println(c.getMes());
				
				//EQUALS
				System.out.println("EQUALS");
				System.out.println(c.equals(c2));
				
				//COMPARE TO
				System.out.println("COMPARE TO");
				System.out.println(c.compareTo(c2));
				
				//COMPROBACION DE RESTRICION
				System.out.println("RESTRICCION");
				c.setAbv(-0.1);
				System.out.println(c2.getAbv());
	}

}
