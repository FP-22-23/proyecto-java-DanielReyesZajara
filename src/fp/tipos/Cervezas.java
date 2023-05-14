package fp.tipos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
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
	
	
	/*TRATAMIENTOS SECUENCIALES CON STREAM*/
	
	//Exite(Stream)
	public Boolean getCervezaColorStream(Color co) {
		return cervezas.stream()
				.anyMatch(c -> c.getColor().equals(co));
	}
	
	//Media(Stream)
	public Double getMediaCervezaArmaguraDeUnColorSt(Color co) {
		OptionalDouble opt = cervezas.stream()
				.filter(c -> c.getColor().equals(co))
				.mapToDouble(c -> c.getIbu())
				.average();
		return opt.orElse(0.);
	}
	
	//Filtrado(Stream)
	public Set<Cerveza> getCervezasPorElementoDeSuAtributoListaSt(String gen){
		return cervezas.stream()
				.filter(c -> c.getLista().contains(gen))
				.collect(Collectors.toSet());
	}
	
	//Max + Filtrado
	public Cerveza getCervezaMayorAbvDadoUnAño(Integer a) {
		Optional<Cerveza> opt = cervezas.stream()
				.filter(c -> Integer.valueOf(c.getFecha().getYear()).equals(a))
				.max(Comparator.comparing(c -> c.getAbv()));
		
		return opt.orElse(null);
	}
	
	// Selecccion + filtrado + ordenacion
	public SortedSet<String> getNombresCervezasOrdenadosAlfabeticamenteDadoUnBool(Boolean x){
		return cervezas.stream()
				.filter(c -> c.getBooleano().equals(x))
				.map(Cerveza::getName)
				.sorted()
				.collect(Collectors.toCollection(TreeSet::new));
	}
	
	//metodo 4 con stream
	public Map<Double,List<Cerveza>> getCervezaPorOuncesStream() {
		return cervezas.stream()
				.collect(Collectors.groupingBy(Cerveza::getOunces));
	}
	
	//Collectors mapping
	public Map<Color,List<String>> getEstiloCervezaPorColor(){
		
		return cervezas.stream()
				.collect(
						Collectors.groupingBy(
								Cerveza::getColor,
								Collectors.mapping(Cerveza::getStyle,
										Collectors.toList())));
		
	}
	
	//metodo clave atributo y valor max/min
	public Map<Boolean,Double> getMinimoIbuPorBooleano() {
		Map<Boolean, List<Cerveza>> aux = cervezas.stream()
				.collect(Collectors.groupingBy(
						Cerveza::getBooleano,
						Collectors.toList()));
		
		return aux.entrySet().stream()
				.collect(Collectors.toMap(
						e->e.getKey(),
						e->min(e.getValue())));
		
		
	}
	
	private static Double min(Collection<Cerveza> c) {
		Comparator<Cerveza> cmp = Comparator.comparing(Cerveza::getIbu);
 		return c.stream()
				.min(cmp)
				.map(Cerveza::getIbu)
				.orElse(0.0);
						
	}

	
	//SortedMap y valores n mejores de un atributo
	
	public SortedMap<Integer, Set<Integer>> getTopNDeAbvPorMes(Integer n){
		return  cervezas.stream()
				.collect(Collectors.groupingBy(
						Cerveza::getMes,
						TreeMap::new,
						Collectors.collectingAndThen(
								Collectors.toSet(),
								e->nMejores(e,n))));
		
	}
	
	private static Set<Integer> nMejores(Collection<Cerveza> x, Integer n) {
		return x.stream()
				.sorted(Comparator.comparing(Cerveza::getAbv))
				.limit(n)
				.map(Cerveza::getAbv)
				.collect(Collectors.toSet());
	}
	
	
	//Map devuelve la clave del max/min del valor del todo el Map
	
	public Map<Boolean, Double> getBooleanoConMenorIbu(){
		Map<Boolean, Double> aux = getMinimoIbuPorBooleano();
		
		Map.Entry<Boolean, Double> res = Collections.min(aux.entrySet(), Comparator.comparing(Map.Entry::getValue));
		
		
		return Map.of(res.getKey(),res.getValue());
	}
}
	
	 
	
	 
	 
	 

