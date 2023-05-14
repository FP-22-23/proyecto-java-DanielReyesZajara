package fp.common;

import java.util.Objects;

import fp.utiles.Checkers;

public record CervezaRecord(Integer abv, String name, String style) implements Comparable<CervezaRecord> {
	
	public CervezaRecord{
		Checkers.check("abv debe ser mayor a 0", abv>0);
		Checkers.check("El name no puede estar vacio", name != "");
	}
	
	public String getCadenaFormato() {
		return name() + " del estilo: " + style() + " tiene un abv de " + abv();
	}

	
	public int hashCode() {
		return Objects.hash(abv, name, style);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CervezaRecord other = (CervezaRecord) obj;
		return Objects.equals(abv, other.abv) && Objects.equals(name, other.name) && Objects.equals(style, other.style);
	}


	public int compareTo(CervezaRecord o) {
		int r = this.name().compareTo(o.name());
		if(r==0) {
			r= this.style().compareTo(o.style());
			if(r==0) {
				r = this.abv().compareTo(o.abv());
			}
		}
		return r;
	}
	
	

}
