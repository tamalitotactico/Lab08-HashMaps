package Laboratorio8;

public class Paquete {

	private String name;
	private Double costo;
	private Integer kilos;
	
	public void setName(String nombre) {
		name=nombre;
	}
	public String getName() {
		return name;
	}
	
	public void setCosto(Double costo1) {
		costo=costo1;
	}
	public Double getCosto() {
		return costo;
	}
	
	public void setKilo(Integer kg) {
		kilos=kg;;
	}
	public Integer getKilo() {
		return kilos;
	}
}
