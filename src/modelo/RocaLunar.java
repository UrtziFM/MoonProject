package modelo;
/**
 * RocaLunar
 * @author 
 *
 */

public class RocaLunar {
	//
	private int codigo;
	private String tipo;
	private int recuento;
	
	
	//Constructor
	public RocaLunar(int codigo, String tipo) {
		
		this.codigo = codigo;
		this.tipo = tipo;
		 recuento=0;
		
	}
	public RocaLunar() {
		// TODO Auto-generated constructor stub
		this.codigo = -1;
		this.tipo = "";
	}
	
	//M�todos de acceso	
	public String getTipo() {
		return tipo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setRecuento(int r) {
		recuento = r;
	}
	public String toString() {
		
		return new String("Roca lunar : Tipo :"+this.tipo+":codigo :"+this.codigo+":recuento:"+this.recuento);
		
	}
	
}
