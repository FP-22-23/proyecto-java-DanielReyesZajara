package fp.tipos;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Cerveza implements Comparable<Cerveza>{
	//BASICAS
		private Integer num;
		private Integer abv;
		private Double ibu;
		private Integer id;
		private String name;
		private String style;
		private Double ounces;
		private Boolean booleano;
		private LocalDate fecha;
		private List<String> lista;
		private Color color;
		
		//getters setters
		public Integer getNum() {
			return num;
		}
		public void setNum(Integer num) {
			this.num = num;
		}
		public Integer getAbv() {
			return abv;
		}
		public void setAbv(Integer abv) {
			checkAbv(abv);
			this.abv = abv;
		}
		public Double getIbu() {
			return ibu;
		}
		public void setIbu(Double ibu) {
			this.ibu = ibu;
		}
		public Double getOunces() {
			return ounces;
		}
		public void setOunces(Double ounces) {
			this.ounces = ounces;
		}
		public LocalDate getFecha() {
			return fecha;
		}
		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
		public Integer getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			checkName(name);
			this.name = name;
		}
		public String getStyle() {
			return style;
		}
		public Boolean getBooleano() {
			return booleano;
		}
		public List<String> getLista(){
			return lista;
		}
		public Color getColor() {
			return color;
		}
		//constructores
		public Cerveza(Integer num, Integer abv, Double ibu, Integer id, String name, String style, Double ounces,
				Boolean booleano, LocalDate fecha, List<String> lista, Color color) {
			checkName(name);
			checkAbv(abv);
			this.num = num;
			this.abv = abv;
			this.ibu = ibu;
			this.id = id;
			this.name = name;
			this.style = style;
			this.ounces = ounces;
			this.booleano = booleano;
			this.fecha = fecha;
			this.lista = lista;
			this.color = color;
		}
		
		public Cerveza(Integer abv, String name, String style) {
			checkName(name);
			checkAbv(abv);
			this.abv = abv;
			this.name = name;
			this.style = style;
		}
		
		
		//DERIVADA
		public Integer getMes() {
			return fecha.getMonthValue();
		}
		
		//toString
		public String toString() {
			return "Cerveza [num=" + num + ", abv=" + abv + ", ibu=" + ibu + ", id=" + id + ", name=" + name + ", style="
					+ style + ", ounces=" + ounces + ", booleano=" + booleano + ", fecha=" + fecha + ", lista="+ lista + ", Color=" + color +"]";
		}
		
		//HashCode Equals
		public int hashCode() {
			return Objects.hash(abv, booleano, fecha, ibu, id, name, num, ounces, style, lista, color);
		}
		
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cerveza other = (Cerveza) obj;
			return Objects.equals(abv, other.abv) && Objects.equals(booleano, other.booleano)
					&& Objects.equals(fecha, other.fecha) && Objects.equals(ibu, other.ibu) && Objects.equals(id, other.id)
					&& Objects.equals(name, other.name) && Objects.equals(num, other.num)
					&& Objects.equals(ounces, other.ounces) && Objects.equals(style, other.style)
					&& Objects.equals(lista, other.lista) && Objects.equals(color, other.color);
		}
		//COMPARE TO
		public int compareTo(Cerveza c) {
			int r;
			r = getAbv().compareTo(c.getAbv());
			if(r == 0) {
				r = getName().compareTo(c.getName());
				if(r==0) {
					r = getStyle().compareTo(c.getStyle());
				}
			}
			return r;
		}
		
		//RESTRICCIONES
		private void checkAbv(Integer abv) {
			if(abv<0) {
				throw new IllegalArgumentException("El abv no puede ser menor que 0");
			}
		}
		
		private void checkName(String name) {
			if(name.equals("")) {
				throw new IllegalArgumentException("El nombre no puede ser vacio");
			}
		}
}
