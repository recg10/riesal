package cl.devap.ict.enums;

public enum Parametro {
	NO_EXISTE(0, "NO Existe"),
	MAIL(1, "Mail")
	;
	
	
	private Parametro (int id, String nombre) {
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

	public static Parametro getDocumentoById(String id) {
		int idInt = Integer.parseInt(id);
		Parametro docReturn = null;
		for (Parametro documento: values()) {
			if (documento.getId() == idInt) {
				docReturn = documento;
				break;
			}
		}
		return docReturn;
	}
}