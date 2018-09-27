package cl.devap.ict.enums;

public enum TipoMaterial {

	MATERIAL(0, "Material"),
	MO(1, "Mano Obra")	
	;
	
	
	private TipoMaterial (int id, String nombre) {
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

	public static TipoMaterial getDocumentoById(String id) {
		int idInt = Integer.parseInt(id);
		TipoMaterial docReturn = null;
		for (TipoMaterial documento: values()) {
			if (documento.getId() == idInt) {
				docReturn = documento;
				break;
			}
		}
		return docReturn;
	}
}