/**
 * 
 */
package cl.devap.facol;

import java.io.Serializable;

/**
 * @author rcastro
 *
 */
public class ProductoDTO implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String descripcion;	
	private int stock;
	private int stockMinimo;
	private int valor;
	
	public ProductoDTO() {
		super();
	}
	
	public ProductoDTO(String codigo, String descripcion, int stock, int stockMinimo, int valor) {		
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.stockMinimo = stockMinimo;
		this.valor = valor;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "ProductoDTO [codigo=" + codigo + ", descripcion=" + descripcion + ", stock=" + stock + ", stockMinimo="
				+ stockMinimo + ", valor=" + valor + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + stock;
		result = prime * result + stockMinimo;
		result = prime * result + valor;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoDTO other = (ProductoDTO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (stock != other.stock)
			return false;
		if (stockMinimo != other.stockMinimo)
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}
	
}
