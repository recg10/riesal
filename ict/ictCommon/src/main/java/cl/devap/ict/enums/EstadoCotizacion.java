package cl.devap.ict.enums;

public enum EstadoCotizacion {

	INGRESADO(0, "Ingresado"),
	FINALIZADO(1, "Finalizado")	
	;
	
	
	private EstadoCotizacion (int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	private int id;
	private String nombre;
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

	public static EstadoCotizacion getDocumentoById(String id) {
		int idInt = Integer.parseInt(id);
		EstadoCotizacion docReturn = null;
		for (EstadoCotizacion documento: values()) {
			if (documento.getId() == idInt) {
				docReturn = documento;
				break;
			}
		}
		return docReturn;
	}
}