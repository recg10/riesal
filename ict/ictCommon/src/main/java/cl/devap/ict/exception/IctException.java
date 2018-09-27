package cl.devap.ict.exception;

/**
 * Excepción genérica para el manejo de errores en el Sistema PP.FF.
 * 
 * @author INDRA
 *
 */
public class IctException extends Exception {

	
	private static final long serialVersionUID = 2421027664609354257L;

	private IctExceptionEnum ppffExceptionEnum;
	private Object[] parameters;

	public IctException(String mensaje) {
		super (mensaje);
	}
	
	/**
	 * Constructor de la excepción.
	 * 
	 * @param ppffExceptionEnum Enumeración que particulariza la excepción a lanzar.
	 */
	public IctException(IctExceptionEnum ppffExceptionEnum) {
		super(ppffExceptionEnum.name());
		this.ppffExceptionEnum = ppffExceptionEnum; 
	}
	
	/**
	 * Constructor de la excepción.
	 * 
	 * @param ppffExceptionEnum Enumeración que particulariza la excepción a lanzar.
	 * @param parameters Parámetros opcionales que especifican el mensaje de error a desplegar al 
	 * producirse la excepción.
	 */
	public IctException(IctExceptionEnum ppffExceptionEnum, String... parameters) {
		super();
		this.ppffExceptionEnum = ppffExceptionEnum;
		this.parameters = parameters;
	}

	/**
	 * Constructor de la excepción.
	 * 
	 * @param ppffExceptionEnum Enumeración que particulariza la excepción a lanzar.
	 * @param cause Excepción que fue la causa original que ameritó lanzar esta excepción.
	 */
	public IctException(IctExceptionEnum ppffExceptionEnum, Throwable cause) {
		super(cause);
		this.ppffExceptionEnum = ppffExceptionEnum; 
	}
	
	/**
	 * 
	 * Constructor de la excepción.
	 * 
	 * @param ppffExceptionEnum Enumeración que particulariza la excepción a lanzar.
	 * @param cause Excepción que fue la causa original que ameritó lanzar esta excepción.
	 * @param parameters Parámetros opcionales que permiten especificar el mensaje de error a desplegar al 
	 * producirse la excepción.
	 */
	public IctException(IctExceptionEnum ppffExceptionEnum, Throwable cause, String... parameters) {
		super(cause);
		this.ppffExceptionEnum = ppffExceptionEnum; 
		this.parameters = parameters;
	}
	
	/**
	 * Método que retorna la enumeración que tipifica la excepción.
	 * 
	 * @return La enumeración que tipifica la excepción.
	 */
	public IctExceptionEnum getPpffExceptionEnum() {
		return ppffExceptionEnum;
	}

	/**
	 * Método que retorna los parámetros opcionales que permiten especificar el mensaje de error a desplegar al 
	 * producirse la excepción.
	 * 
	 * @return Los parámetros opcionales.
	 */
	public Object[] getParameters() {
		return parameters;
	}	
	
}
