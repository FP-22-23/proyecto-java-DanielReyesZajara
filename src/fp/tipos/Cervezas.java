package fp.tipos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cervezas {
	 private List<Cerveza> cervezas;
	 
	 //Constructores
	 public Cervezas() {
		 this.cervezas = new ArrayList<Cerveza>();
	 }
	 
	 public Cervezas(List<Cerveza> c) {
		 this.cervezas = c;
	 }
	 
	 public Cervezas(Stream <Cerveza> stream) {
		 this.cervezas = stream.collect(Collectors.toList());
	 }
	 
	//equals 
	public int hashCode() {
		return Objects.hash(cervezas);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cervezas other = (Cervezas) obj;
		return Objects.equals(cervezas, other.cervezas);
	}

	// toString
	public String toString() {
		return "Cervezas [cervezas=" + cervezas + "]";
	}
	
	//Obtener el numero de elementos
	public Integer getNumeroCervezas() {
		return cervezas.size();
	}
	
	//Añadir un elemento
	public void agregarCerveza(Cerveza c) {
		cervezas.add(c);
	}
	
	//Añade una lista
	 public void agregarListaCervezas(List<Cerveza> lc) {
		 cervezas.addAll(lc);
	 }
	
	//Elimina Cerveza
	 public void elminaCerveza(Cerveza c) {
		 cervezas.remove(c);
	 }
	 
	//TRATAMIENTOS SECUENCIALES(CON BUCLES)
	
	//Existe
	public Boolean getCervezaColor(Color co) {
		Boolean res = false;
		for(Cerveza c:cervezas) {
			if(c.getColor().equals(co)) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	//Media
	public Double getMediaAmarguraCervezaDeUnColor(Color co) {
		Double suma= 0.0;
		Integer cont = 0;
		for(Cerveza c:cervezas) {
			if(c.getColor().equals(co)) {
				suma += c.getIbu();
				cont +=1;
			}
		}
		Double res;
		if(cont!=0) {
			res = Double.valueOf(suma/cont);
		}else {
			res = null;
		}
		return res;
	}
	
	// filtro
	
	public Set<Cerveza> getCervezasPorUnElementoDeSuAtributoLista(String gen){
		Set<Cerveza> res = new HashSet<>();
		for(Cerveza c:cervezas) {
			if(c.getLista().contains(gen)) {
				res.add(c);
			}
		}
		return res;
	}
	
	// Agrupar (Map)
	public Map<Double,List<Cerveza>> getListaCervezasPorOunces(){
		Map<Double,List<Cerveza>> res = new HashMap<>();
		for(Cerveza c:cervezas) {
			Double key = c.getOunces();
			if(res.containsKey(key)) {
				res.get(key).add(c);
			}else {
				List<Cerveza> valor = new ArrayList<>();
				valor.add(c);
				res.put(key, valor);
			}
		}
		return res;
	}
	
	//acumulador(Map)
	public Map<Integer, Integer> getSumaTotalDeAbvPorAnyo(){
		Map<Integer,Integer> res = new HashMap<>();
		for(Cerveza c:cervezas) {
			Integer key = c.getFecha().getYear();
			if(res.containsKey(key)) {
				Integer value = c.getAbv();
				value+=c.getAbv();
				res.put(key, value);
			}else {
				Integer value = c.getAbv();
				res.put(key, value);
			}
		}
		return res;
	}
	
}
	
	 
	
	 
	 
	 

