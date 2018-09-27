package cl.devap.ict.exception;


/**
 * 
 * Enumeración que permite particularizar una excepción {@link IctException}. 
 * 
 * @author INDRA
 *
 */
public enum IctExceptionEnum {
	
	//Códigos de error de Sistema
	/**
	 * Se ha producido un error de sistema.
	 */
	SIS_0001("message.err.sis.0001"),
	
	/**
	 * Se ha producido con la Base de datos
	 */
	DB_0001("message.err.db.0001"),
	
	/**
	 * Se ha producido un error de validación general
	 */
	GEN_0001("message.err.gen.0001"),
	
	/**
	 * Se ha producido un error de validación general fecha
	 */
	GEN_0002("message.err.gen.0002"),
	
	/**
	 * Valida hijo ya nacido menor a 5 años para beneficio
	 */
	GEN_0003("message.err.gen.0003"),
	
	//Códigos de error de Módulo Atención a Público
	/**
	 * Se ha producido un error de sistema.
	 */
	ATP_0001("message.err.atp.0001"),
	/**
	 * RUT inexistente o clave inválida.
	 */
	ATP_0002("message.err.atp.0001"),
	
	//Código de error del Módulo de Integraciones
	/**
	 * Se ha producido un error desconocido.
	 */
	INT_0001("message.err.integracion.0001"),
	/**
	 * Se ha producido un error al tratar de obtener los datos de configuracion del WS.
	 */
	INT_0002("message.err.integracion.0002"),
	/**
	 * Se ha producido un error con la comunicación con el WS.
	 */
	INT_0003("message.err.integracion.0003"),
	/**
	 * El WS retorno un Codigo de Error.
	 */
	INT_0004("message.err.integracion.0004"),
	/**
	 * El sistema de Clientes no se encuentra disponible para efectuar la consulta, por favor intente de nuevo o más tarde, en caso de persistir, por favor comuníquese con el administrador.
	 */
	INT_0005("message.err.integracion.0005"),
	/**
	 * Se ha producido un error con la comunicación con el WS de Consulta de Causante.
	 */
	INT_0006("message.err.integracion.0006"),
	
	
	//Códigos de Error para la Integración SIAGF
	/**
	 * Error desconocido de SIAGF  {0} {1}
	 */
	SIAGF_0001("message.err.siagf.0001"),
	/**
	 * Error inesperado, reintente más tarde {0}
	 */
	SIAGF_0002("message.err.siagf.0002"),
	/**
	 * Error inesperado, Token inválido {0}
	 */
	SIAGF_0003("message.err.siagf.0003"),
	/**
	 * Error inesperado, No se informaron los parámetros necesarios {0}
	 */
	SIAGF_0004("message.err.siagf.0004"),
	/**
	 * Error inesperado, Documento Invalido enviado a SIAGF {0}
	 */
	SIAGF_0005("message.err.siagf.0005"),
	/**
	 * Error inesperado, Causante ya existe con Reconocimiento Vigente en SIAGF {0}
	 */
	SIAGF_0006("message.err.siagf.0006"),
	/**
	 * Error inesperado, Fecha de Reconocimiento se sobrepone a otro reconocimiento ya extinguido en SIAGF {0}
	 */
	SIAGF_0007("message.err.siagf.0007"),
	/**
	 * Error inesperado, Causante ya existe como Beneficiario {0}
	 */
	SIAGF_0008("message.err.siagf.0008"),
	/**
	 * Error inesperado, Causante no Existen en SIAGF {0}
	 */
	SIAGF_0009("message.err.siagf.0009"),
	/**
	 * Error inesperado, Causante ya se encuentra Extinguido {0}
	 */
	SIAGF_0010("message.err.siagf.0010"),
	
	/** 
	 * El causante no se encuentra acreditado en SIAGF para dicho Beneficiario. Recuerde exigir documentación que lo acredita como carga.
	 */
	SIAGF_0011("message.err.siagf.0011"),
	
	//Error de Integración con la Ficha de Beneficiario
	/**
	 * No se encontro al Beneficiario Requerido.
	 */
	IBE_00001("message.err.integracion.fb.0001"),

	//Error de Integración con la Unidad de Fomento
	/**
	 * No pudo parsear la Unidad Fomento.
	 */
	UF_00001("message.err.integracion.uf.0001"),
	
	//Códigos de error del Módulo de Reportes
	/**
	 * Se ha producido un error al generar el reporte.
	 */
	REP_0001("message.err.rep.0001"),
	/**
	 *La consulta no obtuvo datos para generar el reporte.
	 */
	REP_0002("message.err.rep.0002"),
	/**
	 *El reporte no fue encontrado.
	 */
	REP_0003("message.err.rep.0003"),
	/**
	 * Ocurrió un problema en el modulo de Reportes.
	 */
	REP_0004("message.err.rep.0004"),
	/**
	 * Falla al Generar Archivo Resultado en {0}.
	 */
	REP_0005("message.err.rep.0005"),
	/**
	 * Debe especificar periodo a consultar.
	 */
	REP_0006("message.err.rep.0006"),
	/**
	 * Fecha inicial de proceso debe ser menor a la fecha final de proceso.
	 */
	REP_0007("message.err.rep.0007"),
	/**
	 * Numero de paquete inicial debe ser menor a numero de paquete final.
	 */
	REP_0008("message.err.rep.0008"),
	/**
	 * Error en el formato de rut de empresa ingresado.
	 */
	REP_0009("message.err.rep.0009"),
	
	//Código de error de Solicitud
	/**
	 * Se ha producido un error al grabar la Solicitud.
	 */
	SOL_0001("message.err.solicitud.0001"),
	/**
	 * Se ha producido un error al actualizar la Solicitud.
	 */
	SOL_0002("message.err.solicitud.0002"),
	/**
	 * Solicitud inexistente {0}.
	 */
	SOL_0003("message.err.solicitud.0003"),
	/**
	 * Se ha producido un error al actualizar la Solicitud.
	 */
	SOL_0004("message.err.solicitud.0004"),
	/**
	 * Se ha producido un error al obtener la Solicitud {0}.
	 */
	SOL_0005("message.err.solicitud.0005"),
	/**
	 * Se ha producido un error al {0} la Solicitud.
	 */
	SOL_0006("message.err.solicitud.0006"),
	/**
	 * No puede crear una Solicitud, ya que para esta Empresa el Beneficiario es {0}
	 */
	SOL_0007("message.err.solicitud.0007"),
	/**
	 * No puede generar la Solicitud para este Rut de Carga {0}, ya que no es una carga valida para el Beneficiario {1}
	 */
	SOL_0008("message.err.solicitud.0008"),
	/**
	 * Error al obtener las Solicitudes por Beneficiario
	 */
	SOL_0009("message.err.solicitud.0009"),
	/**
	 * Error al obtener el Historico de Solicitudes por Carga.
	 */
	SOL_0010("message.err.solicitud.0010"),
	/**
	 * Error al tratar de Eliminar la Solicitud {0}.
	 */
	SOL_0011("message.err.solicitud.0011"),
	/**
	 * Error al tratar de Cambiar el Estado a la Solicitud {0}.
	 */
	SOL_0012("message.err.solicitud.0012"),
	/**
	 * Error al tratar de Generar la Solicitud.
	 */
	SOL_0013("message.err.solicitud.0013"),
	/**
	 * Error al tratar de Obtener las Solicitudes por Criterio.
	 */
	SOL_0014("message.err.solicitud.0014"),
	/**
	 * Error cuando las Busqueda no trae ningun Resultado.
	 */
	SOL_0015("message.err.solicitud.0015"),
	/**
	 * Rut de Empresa ingresado no esta asociado a beneficiario.
	 */
	SOL_0016("message.err.solicitud.0016"),
	/**
	 * Error al actualizar los Datos Bancarios del beneficiario.
	 */
	SOL_0017("message.err.solicitud.0017"),
	/**
	 * Advertencia: El beneficiario no tiene registro de Datos Bancarios.
	 */
	SOL_0018("message.err.solicitud.0018"),
	/**
	 * La solicitud no está asociada a la cuenta de usuario actual.
	 */
	SOL_0019("message.err.solicitud.0019"),
	/**
	 * No es posible Grabar una Solicitud con Datos Bancarios {0}.
	 */
	SOL_0020("message.err.solicitud.0020"),
	/**
	 * La Solicitud no puede ser Eliminda ya que esta en Estado Terminada.
	 */
	SOL_0021("message.err.solicitud.0021"),
	/**
	 *  No fue Posible Cancelar la Solicitud.
	 */
	SOL_0022("message.err.solicitud.0022"),
	/**
	 *  No fue Posible Aprobar la Solicitud ya que no Contiene Detalles.
	 */
	SOL_0023("message.err.solicitud.0023"),
	/**
	 *  No fue Posible Aprobar la Solicitud ya que no Contiene Detalles.
	 */
	SOL_0024("message.err.solicitud.0024"),
	//Código de error de Beneficios
	/**
	 * Error al crear la solicitud, la vigencia de días es excedida.
	 */
	BEN_0001("message.err.beneficio.0001"),
	/**
	 * Error al generar la Solicitud. Datos incompletos en el formulario o la vigencia de días al beneficio fue excedida.
	 */
	BEN_0002("message.err.beneficio.0002"),
	/**
	 * Error al generar el Pago.
	 */
	BEN_0003("message.err.beneficio.0003"),
	/**
	 * El causante no se encuentra acreditado en SIAGF para dicho Beneficiario, recuerde exigir documentación que lo acredita como carga.
	 */
	BEN_0004("message.err.beneficio.0004"),
	/**
	 * El causante no se encuentra acreditado.
	 */
	BEN_0005("message.err.beneficio.0005"),
	/**
	 * Esta solicitud debe ser aprobada por un supervisor.
	 */
	BEN_0006("message.err.beneficio.0006"),
	/**
	 * El plazo para presentar la solicitud está vencido.
	 */
	BEN_0007("message.err.beneficio.0007"),
	/**
	 * Error al obtener los Beneficios por Beneficiario.
	 */
	BEN_0008("message.err.beneficio.0008"),
	/**
	 * Ocurrió un error al obtener beneficios por período y tipo de solicitud.
	 */
	BEN_0009("message.err.beneficio.0009"),
	
	//Códigos de error de Extincion
	/**
	 * El RUT del Causante ingresado no está asociado al Beneficiario
	 */
	EXT_0001("message.err.extincion.0001"),
	/**
	 * El RUT del Causante ingresado ya está agregado
	 */
	EXT_0002("message.err.extincion.0002"),
	/**
	 * La Causal de Extinción no existe o no se aplica por este canal
	 */
	EXT_0003("message.err.extincion.0003"),
	/**
	 * El RUT del Causante ingresado no está en estado vigente
	 */
	EXT_0004("message.err.extincion.0004"),
	/**
	 * El RUT del Causante ingresado no está en estado vigente en SIAGF
	 */
	EXT_0005("message.err.extincion.0005"),
	/**
	 * La Solicitud no contiene cargas para extinguir.
	 */
	EXT_0006("message.err.extincion.0006"),
	/**
	 * La Solicitud no corresponde a una Solicitud de Extinción.
	 */
	EXT_0007("message.err.extincion.0007"),
	/**
	 * Ocurrió un error desconocido al tratar de Acreditar la Extinción.
	 */
	EXT_0008("message.err.extincion.0008"),
	/**
	 * Ocurrió un error en el modulo de Extinción.
	 */
	EXT_0009("message.err.extincion.0009"),
	/**
	 * Ocurrió un error al Tratar de Obtener las Extinciones por Solicitud.
	 */
	EXT_0010("message.err.extincion.0010"),
	/**
	 * Ocurrió un error al Tratar de Extinguir las Cargas.
	 */
	EXT_0011("message.err.extincion.0011"),
	/**
	 * Ocurrió un error al Tratar de generar el Detalle de la Extinción.
	 */
	EXT_0012("message.err.extincion.0012"),
	
	/**
	 * El Causante NO pertenece a la Empresa Seleccionada.
	 */
	EXT_0013("message.err.extincion.0013"),
	
	/**
	 * Debe selecionar una Razón Social.
	 */
	EXT_0014("message.err.extincion.0014"),
	
	/**
	 * El beneficiario no tiene cargas para extinguir.
	 */
	EXT_0015("message.err.extincion.0015"),
	
	/**
	 * la fecha de Extincion NO puede ser menor que la fecha de inicio beneficio.
	 */
	EXT_0019("message.err.extincion.0019"),
	
	/**
	 * se debe ingresar tipo de extincion antes que la fecha de extincion.
	 */
	EXT_0020("message.err.extincion.0020"),
	
	
	/**
	 * se debe ingresar todos los documentos.
	 */
	EXT_0021("message.err.extincion.0021"),
	
	/**
	 * no tiene permiso para este tipo de extincion.
	 */
	EXT_0022("message.err.extincion.0022"),
	/**
	 * Ocurrio un error al Extinguir al Causante
	 */
	EXT_0024("message.err.extincion.0024"),
	
	/**
	 * Fecha de de Beneficio debe ser mayor a la de extincion
	 */
	EXT_0028("message.err.extincion.0028"),
	//Códigos de Error de la Ficha Beneficiario
	/**
	 * Introduzca un rut.
	 */
	FBE_0001("message.err.ficha.0001"),
	/**
	 * Introduzca un rut con formato correcto.
	 */
	FBE_0002("message.err.ficha.0002"),
	/**
	 * El carácter '-' debe separar el rut del dígito validador.
	 */
	FBE_0003("message.err.ficha.0003"),
	/**
	 * El rut y el dígito validador deben ir separados por '-'.
	 */
	FBE_0004("message.err.ficha.0004"),
	/**
	 * El dígito validador debe tener 1 dígito.
	 */
	FBE_0005("message.err.ficha.0005"),
	/**
	 * El rut debe ser numérico.
	 */
	FBE_0006("message.err.ficha.0006"),
	/**
	 * Error al Obtener los Datos del Beneficiario.
	 */
	FBE_0007("message.err.ficha.0007"),
	/**
	 * Error al Obtener los Datos de la Empresa.
	 */
	FBE_0008("message.err.ficha.0008"),
	/**
	 * El Digito Verificador no Corresponde al Rut, Rut Incorrecto.
	 */
	FBE_0009("message.err.ficha.0009"),
	/**
	 * Beneficiario no Existe en Caja los Andes.
	 */
	FBE_0010("message.err.ficha.0010"),
	/**
	 * Empresa no Existe en Caja los Andes.
	 */
	FBE_0011("message.err.ficha.0011"),
	/**
	 * No se actualizaron datos.
	 */
	FBE_0012("message.err.ficha.0012"),
	/**
	 * Rut formato incorrecto.
	 */
	FBE_0016("message.err.ficha.0016"),
	
	/**
	 * Ya existe una Empresa con Vigencia  para el Beneficiario.
	 */
	FBE_0013("message.err.ficha.0013"),
	
	/**
	 * NO Pueden haber 2 Contratos para de la misma Empresa en el Período
	 */
	FBE_0014("message.err.ficha.0014"),
	
	/**
	 * La Fecha del Nuevo contrato debe ser Posterior al del termino del que ya existe.
	 */
	FBE_0015("message.err.ficha.0015"),
	/**
	 * No Existen Datos en el Histórico de Solicitudes..
	 */
	FBE_0017("message.err.ficha.0017"),
	/**
	 * No Existen Datos en el Histórico de Solicitudes..
	 */
	FBE_0018("message.err.ficha.0018"),
	/**
	 * No es Posible crear un Beneficiario sin Contrato
	 */
	FBE_0019("message.err.ficha.0019"),
	/**
	 * El rut del Beneficiario es el mismo rut que el Solicitante
	 */
	FBE_0020("message.err.ficha.0020"),
	/**
	 * No fue posible realizar la notificación vía e-mail al beneficiario
	 */
	FBE_0021("message.err.ficha.0021"),
	//Códigos de error de Documentos
	/**
	 * Se ha producido un error al obtener los documentos.
	 */
	DOC_0001("message.err.doc.0001"),
	/**
	 * Se ha producido un error al subir los documentos.
	 */
	DOC_0002("message.err.doc.0002"),
	/**
	 * Se ha producido un error al guardar los documentos.
	 */
	DOC_0003("message.err.doc.0003"),
	/**
	 * Se ha producido un error al eliminar el documento.
	 */
	DOC_0004("message.err.doc.0004"),
	/**
	 * Debe ingresar un valor numérico.
	 */
	DOC_0005("message.err.doc.0005"),
	/**
	 * Sólo archivos de tipo JPG, GIF, PNG y XML son aceptados.
	 */
	DOC_0006("message.err.doc.0006"),
	/**
	 * El archivo excede el tamaño máximo permitido de 1540Kb.
	 */
	DOC_0007("message.err.doc.0007"),
	/**
	 * Sólo archivos de tipo CSV son aceptados.
	 */
	DOC_0008("message.err.doc.0008"),
	/**
	 * El archivo excede el tamaño máximo permitido de 1540Kb.
	 */
	DOC_0009("message.err.doc.0009"),
	/**
	 * Ocurrió un problema en el modulo de documentos.
	 */
	DOC_0010("message.err.doc.0010"),
	
	//Código de Error para los datos de configuración (DET_DOMINIO)
	/**
	 * No encontró {0} en la tabla de {1}, o encontró más de 1 coincidencia.
	 */
	DOM_0001("message.error.dom.0001"),
	
	//Códigos de Error para los Tipos de Causante.
	/**
	 * No Se encontro un Tipo de Causante
	 */
	TCA_0001("message.err.tca.0001"),
	/**
	 * Se encontro más de 1 Tipo de Causante.
	 */
	TCA_0002("message.err.tca.0002"),
	/**
	 * No encontro un rango de Edad para el Causante.
	 */
	TCA_0003("message.err.tca.0003"),
	/**
	 * Sin descripción.
	 */
	TCA_0004("message.err.tca.0004"),
	/**
	 * Ocurrió un problema en el modulo de Causantes.
	 */
	TCA_0005("message.err.tca.0005"),
	/**
	 * La Fecha de Inicio de Beneficio supera los 60 meses retroactivos.
	 */
	TCA_0006("message.err.tca.0006"),
	
	//Códigos de error para Reconocimiento
	/**
	 * El Rut ingresado existe como beneficiario Activo.
	 */
	REC_0001("message.err.rec.0001"),
	/**
	 * El Rut ingresado ya esta reconocido para este Beneficiario en {0}.
	 */
	REC_0002("message.err.rec.0002"),
	/**
	 * El Rut ingresado ya esta reconocido por otro Beneficiario en {0}.
	 */
	REC_0003("message.err.rec.0003"),
	/**
	 * No puede ingresar un Maternal con un Rut distinto al de la Conyugue o Beneficiaria.
	 */
	REC_0004("message.err.rec.0004"),
	/**
	 * No puede ingresar un Maternal con el Rut del Beneficiario (Masculino).
	 */
	REC_0005("message.err.rec.0005"),
	/**
	 * No puede ingresar un Maternal Para un Rut no Existente.
	 */
	REC_0006("message.err.rec.0006"),
	/**
	 * No puede ingresar un Maternal de Hijo ya nacido, sino tiene ninguna carga como hijo acreditada.
	 */
	REC_0007("message.err.rec.0007"),
	/**
	 * No puede ingresar una actualización para una Carga Familiar que no existe en Caja los Andes.
	 */
	REC_0008("message.err.rec.0008"),
	/**
	 * No puede hacer una actualización para un causante que no tenga Estudios.
	 */
	REC_0009("message.err.rec.0009"),
	/**
	 * El Rut ingresado pertenece a un Beneficiario con Cargas Activas en SIAGF.
	 */
	REC_0010("message.err.rec.0010"),
	/**
	 * La Solicitud no contiene cargas para Acreditar.
	 */
	REC_0011("message.err.rec.0011"),
	/**
	 * La Solicitud no corresponde a una Solicitud de Reconocimiento.
	 */
	REC_0012("message.err.rec.0012"),
	/**
	 * Actualmente existe una Carga Maternal Vigente en {0}.
	 */
	REC_0013("message.err.rec.0013"),
	/**
	 * No encontro la Empresa del Beneficiario para la Acreditación.
	 */
	REC_0014("message.err.rec.0014"),
	/**
	 * Ocurrió un error desconocido en la Acreditación.
	 */
	REC_0015("message.err.rec.0015"),
	/**
	 * Ocurrió un problema al tratar de generar el Detalle de la Solicitud de Reconocimiento.
	 */
	REC_0016("message.err.rec.0016"),
	/**
	 * Ocurrió un problema al tratar de generar la Solicitud de Reconocimiento.
	 */
	REC_0017("message.err.rec.0017"),
	/**
	 * Ocurrió un problema al tratar de Reconocer las Cargas de un Trabajador.
	 */
	REC_0018("message.err.rec.0018"),
	/**
	 * Ocurrió un problema al tratar de obtener los Reconocimientos por Solicitud.
	 */
	REC_0019("message.err.rec.0019"),
	/**
	 * El rut ingresado como carga ya existe en el listado.
	 */
	REC_0020("message.err.rec.0020"),
	/**
	 * El ingreso de la solicitud de reconocimiento maternal debe ser de 5to mes segun fecha concepción.
	 */
	REC_0021("message.err.rec.0021"),
	/**
	 * El rut ingresado el estado es no vigente.
	 */
	REC_0022("message.err.rec.0022"),
	/**
	 * La beneficiaria, no puede reconocer a tipo causante conyuge mujer.
	 */
	REC_0023("message.err.rec.0023"),
	/**
	 * Debe cargar tipo causante (debe seleccionar todos los elementos).
	 */
	REC_0024("message.err.rec.0024"),
	/**
	 * El Rut de la carga no puede ser el mismo que el Rut del Beneficiario.
	 */
	REC_0025("message.err.rec.0025"),
	/**
	 * El Rut ingresado de la carga ya esta vigente.
	 */
	REC_0026("message.err.rec.0026"),
	/**
	 * La fecha de causa es superior a 180 días de la fecha de reconocimiento.
	 */
	REC_0027("message.err.rec.0027"),
	/**
	 * Debe seleccionar una Empresa.
	 */
	REC_0028("message.err.rec.0028"),
	/**
	 * No puede ingresar un maternal ya que run no corresponde al de una cónyuge activa.
	 */
	REC_0029("message.err.rec.0029"),
	/**
	 * No existen cargas que califiquen para otorgarles beneficio.
	 */
	REC_0030("message.err.rec.0030"),
	/**
	 * El RUN ingresado se encuentra como beneficiario en estado vigente en {0}. RUN Beneficiario: {1}, RUT Empresa: {2}. 
	 */
	REC_0031("message.err.rec.0031"),
	/**
	 * La fecha desde no pude ser mayor a la del dia de hoy. 
	 */
	REC_0032("message.err.rec.0032"),
	/**
	 * La fecha hasta no pude ser mayor a la del dia de hoy. 
	 */
	REC_0033("message.err.rec.0033"),
	/**
	 * La fecha no pude ser mayor a la del dia de hoy. 
	 */
	REC_0034("message.err.rec.0034"),
	/**
	 * La fecha de Causa para un Actualizacion de reconocimiento debe ser mayor a feha de extincion 
	 */
	REC_0035("message.err.rec.0035"),
	/**
	 * La fecha de Inicio de derecho para un Actualizacion de reconocimiento debe ser mayor a feha de extincion 
	 */
	REC_0036("message.err.rec.0036"),
	//Código de error para la busqueda de Cargas Familiares por Rut
	/**
	 * La Consulta Por Rut de Carga Familiar retorna más de 1 Registro encontrado!.
	 */
	CFA_0001("message.err.cfa.0001"),
	/**
	 * Ocurrió un problema al tratar de crear la Nueva Carga Familiar.
	 */
	CFA_0002("message.err.cfa.0002"),
	/**
	 * No encontró la Carga Familiar con el ID {0}.
	 */
	CFA_0003("message.err.cfa.0003"),
	/**
	 * Ocurrió un problema al tratar de actualizar la Carga Familiar.
	 */
	CFA_0004("message.err.cfa.0004"),
	/**
	 * No se encontró Causante con el Rut ingresado.
	 */
	CFA_0005("message.err.cfa.0005"),
	/**
	 * La Consulta para el Causante no Obtuvo Datos.
	 */
	CFA_0006("message.err.cfa.0006"),
	
	/**
	 * el Rut de la empresa de Traspaso no Existe en caja de los Andes.
	 */
	CFA_0007("message.err.cfa.0007"),
	
	//Código de error al obtener las Prestaciones
	/**
	 * Ocurrió un error en el Modulo de Prestaciones.
	 */
	PRE_0000("message.err.pre.0000"),
	/**
	 * Ocurrió un error al obtener las Prestaciones
	 */
	PRE_0001("message.err.pre.0001"),
	/**
	 * La Prestación {0} No pertenece al Tipo de Solicitud.
	 */
	PRE_0002("message.err.pre.0002"),
	/**
	 * La Prestación {0} No esta Vigente.
	 */
	PRE_0003("message.err.pre.0003"),
	/**
	 * La Prestación {0} No tiene parametros definidos.
	 */
	PRE_0004("message.err.pre.0004"),
	/**
	 * La Prestación {0} No esta habilitada para el tipo de Beneficiario.
	 */
	PRE_0005("message.err.pre.0005"),
	/**
	 * La Prestación {0} No esta habilitada para el Canal.
	 */
	PRE_0006("message.err.pre.0006"),
	/**
	 * La Prestación {0} No esta habilitada para el Año {1}.
	 */
	PRE_0007("message.err.pre.0007"),
	/**
	 * La Prestación {0} No esta habilitada para el Tipo de Beneficiario, Canal y Año.
	 */
	PRE_0008("message.err.pre.0008"),
	/**
	 * La Prestación {0} tiene más de una configuración habilitada para el Tipo de Beneficiario, Canal y Año.
	 */
	PRE_0009("message.err.pre.0009"),
	/**
	 * La Prestación {0} No tiene parametros Vigentes definidos.
	 */
	PRE_0010("message.err.pre.0010"),
	/**
	 * La Prestación {0} No tiene habilitada la Forma de Pago indicada.
	 */
	PRE_0011("message.err.pre.0011"),
	/**
	 * La Prestación {0} No esta habilitada dentro del Periodo de Vigencia {0} y {1}.
	 */
	PRE_0012("message.err.pre.0012"),
	/**
	 * La Prestación {0} Solo puede ser Tramitada con {0} días posterior a la Fecha del Evento.
	 */
	PRE_0013("message.err.pre.0013"),
	/**
	 * La Prestación {0} Solo puede ser Tramitada por Cargas Acreditadas, y la Carga {1} no esta acreditada en {2}.
	 */
	PRE_0014("message.err.pre.0014"),
	/**
	 * La Prestación {0} Solo puede ser Tramitada por Cargas Acreditadas, y la Carga {1} no esta acreditada en {2}.
	 */
	PRE_0015("message.err.pre.0015"),

	//Códigos de error de Activiti
	/**
	 * Ocurrió un error al Iniciar la actividad de Workflow. 
	 */
	ACT_0001("message.err.act.0001"),
	/**
	 * No se encontró la Tarea asociada a la Solicitud.
	 */
	ACT_0002("message.err.act.0002"),
	/**
	 * Ocurrió un error al tratar de buscar una Tarea.
	 */
	ACT_0003("message.err.act.0003"),
	/**
	 * Ocurrió un problema al Asignar la Tarea.
	 */
	ACT_0004("message.err.act.0004"),
	/**
	 * Ocurrió un problema al tratar de Completar la Tarea.
	 */
	ACT_0005("message.err.act.0005"),
	/**
	 * La tarea no tiene una solicitud de Workflow asociado.
	 */
	ACT_0006("message.err.act.0006"),
	/**
	 * Ocurrio un problema al obtener los candidatos.
	 */
	ACT_0007("message.err.act.0007"),
	
	//Códigos de error de Auditoría
	/**
	 * Ocurrió un error al grabar en mensaje de la Auditoría
	 */
	AUD_0001("message.err.aud.0001"),
	/**
	 * Ocurrió un error al grabar en mensaje de error de la Auditoría
	 */
	AUD_0002("message.err.aud.0002"),

	//Códigos de error de Becas
	/**
	 *  Ocurrió un error durante el cálculo de puntaje.
	 */
	BEC_0001("message.err.beca.0001"),
	/**
	 * El proceso de asignación de becas requiere que el periodo de postulación se encuentre cerrado.
	 */
	BEC_0002("message.err.beca.0002"),
	/**
	 * Las siguientes becas se encuentran pendientes, deben ser anuladas o aprobadas antes de procesar la asignación.
	 */
	BEC_0003("message.err.beca.0003"),
	/**
	 * No existen becas en estado 'EN_TRAMITACION' o el proceso ya fue realizado.
	 */
	BEC_0004("message.err.beca.0004"),
	/**
	 * El período de postulación a becas está cerrado.
	 */
	BEC_0005("message.err.beca.0005"),
	/**
	 * Existe una Solicitud de Beca pendiente para el postulante y beneficiario ingresado.
	 */
	BEC_0006("message.err.beca.0006"),
	/**
	 * Postulante inválido.
	 */
	BEC_0007("message.err.beca.0007"),
	/**
	 * El postulante no es una carga válida, debe regularizar su situación.
	 */
	BEC_0008("message.err.beca.0008"),
	/**
	 * Ocurrió un problema al tratar de realizar la Asignación de las Becas.
	 */
	BEC_0009("message.err.beca.0009"),
	/**
	 * Ocurrió un problema al tratar de obtener los Periodos de Postulación.
	 */
	BEC_0010("message.err.beca.0010"),
	/**
	 * Ocurrió un problema al Obtener el Informe de Becas Asignadas.
	 */
	BEC_0011("message.err.beca.0011"),
	/**
	 * Ocurrió un problema al Obtener el Detalle de Asignación de Becas.
	 */
	BEC_0012("message.err.beca.0012"),
	/**
	 * La nota ingresada es menor a la nota mínima para obtener puntaje.
	 */
	BEC_0013("message.err.beca.0013"),
	/**
	 * Ocurrio un problema al grabar la Solicitud.
	 */
	BEC_0014("message.err.beca.0014"),

	//Códigos de error de Declaraciones
	/**
	 * La suma de las columnas a), b), c), d) y e) difiere de la columna f) para el período {0}.
	 */
	DEC_0001("message.err.dec.0001"),
	/**
	 * En el período {0} el total de la columna {1} difiere de los valores ingresados para dicha columna.
	 */
	DEC_0002("message.err.dec.0002"),
	/**
	 * Deben existir meses con ingreso.
	 */
	DEC_0003("message.err.dec.0003"),
	/**
	 * Ocurrió un Problema al Guardar la Declaración.
	 */
	DEC_0004("message.err.dec.0004"),
	/**
	 * Ocurrió un Problema al obtener la Declaración.
	 */
	DEC_0005("message.err.dec.0005"),
	/**
	 * Ocurrió un Problema al Aprobar la Declaración.
	 */
	DEC_0006("message.err.dec.0006"),
	/**
	 * Ocurrio un Problema al tratar de Guardar el Detalle de la Declaración Recolectada por el Sistema
	 */
	DEC_0007("message.err.dec.0007"),
	/**
	 * Ocurrio un Problema al tratar de Guardar el Tramo Obtenido con los totales de la Caja
	 */
	DEC_0008("message.err.dec.0008"),
	/**
	 *No Puede Ingresar mas de 2 Declaraciones por Beneficiario
	 */
	DEC_0010("message.err.dec.0010"),
	/**
	 *Se obtuvieron múltiples Ingresos Promedio que calzan con el criterio de búsqueda.
	 */
	DEC_0011("message.err.dec.0011"),
	/**
	 *No se obtuvo Ingreso Promedio que calce con el criterio de búsqueda.
	 */
	DEC_0012("message.err.dec.0012"),
	/**
	 *La suma de las columnas a), b), c), d) y e) difiere de la columna f).
	 */
	DEC_0013("message.err.dec.0013"),
	/**
	 *El valor promedio ingresado difiere del calculado con la suma de las columnas a), b), c), d) y e) dividido por el número de meses.
	 */
	DEC_0014("message.err.dec.0014"),
	/**
	 *Debe ingresar un valor mayor que 0 para el número de meses en la fila {0}.
	 */
	DEC_0015("message.err.dec.0015"),
	/**
	 *No puede aprobar la declaración ya que aún no ha finalizado su proceso de validación.
	 */
	DEC_0016("message.err.dec.0016"),
	/**
	 *Ocurrió un problema al validar la Declaración. 
	 */
	DEC_0017("message.err.dec.0017"),
	//Códigos de error de Becas
	/**
	 * Ocurrió un problema al obtener la asignación de beca.
	 */
	ASIGBEC_0001("message.err.asignacion.beca.0001"),

	//Códigos de error para Resoluciones
	/**
	 * Se ha producido un error al tratar de generar una Resolución.
	 */
	RES_0001("message.err.res.0001"),
	
	/**
	 * No existen Resultados de acuerdo a los criterios de Búsqueda Entregados.
	 */
	RES_0002("message.err.res.0002"),
	
	//Códigos de error al obtener parametros de Sistemas
	/**
	 * Parámetro de Sistema NO definido {0}
	 */
	PARAM_SIST_0001("message.err.param.sist.0001"),
	/**
	 * Existe más de 1 parámetro definido para la key {0}
	 */
	PARAM_SIST_0002("message.err.param.sist.0002"),
	/**
	 * Ocurrió un problema en el Módulo de Parámetros de Sistema.
	 */
	PARAM_SIST_0003("message.err.param.sist.0003"),
	
	//Códigos de error al obtener parámetros de Prestación
	/**
	 * No se encuentran parámetros vigentes para la prestación
	 */
	PARAM_PREST_0001("message.err.param.prest.0001"),
	/**
	 * Existen dos parametrizaciones vigentes para una sola prestación
	 */
	PARAM_PREST_0002("message.err.param.prest.0002"),
	/**
	 * Ocurrió un problema en el Módulo de Parámetros de Sistema.
	 */
	PARAM_PREST_0003("message.err.param.prest.0003"),

	/**
	 * Ocurrio un problema al obtener el Pago.
	 */
	PAGO_0001("message.err.pago.0001"),
	/**
	 * Ocurrio un problema al modificar el estado del pago.
	 */
	PAGO_0002("message.err.pago.0002"),
	/**
	 * El Estado del Pago ya habia sido modificado.
	 */
	PAGO_0003("message.err.pago.0003"),
	
	//Códigos de error para parsear el archivo CSV
	/**
	 * No pudo Parsear el Archivo CSV.
	 */
	CSV_0001("message.err.csv.0001"),
	
	//Códigos de error para el manejor de Archivos
	/**
	 * No pudo Abrir el Archivo {0}.
	 */
	FILE_0001("message.err.file.0001"),
	/**
	 * No pudo Cerrar el Archivo {0}.
	 */
	FILE_0002("message.err.file.0002"),
	/**
	 * Error al Crear el Archivo {0}.
	 */
	FILE_0003("message.err.file.0003"),
	
	/**
	 * Excede tiempo de espera del WS beneficiario.
	 */
	AFCA_0001("message.err.acfa.0001"),
	
	//Códigos de error para los Procesos Batch
	/**
	 * Ocurrió un Problema al Procesar el Archivo {0}
	 */
	BAT_0001("message.err.bat.0001"),
	
	//Códigos de error para los Procesos Batch
	/**
	 * Ocurrió un Problema al Procesar el Archivo validar data correcta
	 */
	BAT_0002("message.err.bat.0002"),

	//Códigos de error para la conversión de JPA to DTO
	/**
	 * Ocurrió un Problema al Procesar el Archivo {0}
	 */
	JPA_DTO_0001("message.err.jpa.dto.0001"),

	//Códigos de error para la conversión de DTO to JPA
	/**
	 * Ocurrió un problema al Convertir el Objeto DTO to JPA.
	 */
	DTO_JPA_0001("message.err.dto.jpa.0001"),

	//Códigos de error de Módulo de Catálogos
	/**
	 * Ocurrió un problema en el módulo de Catálogos.
	 */
	CAT_0001("message.err.cat.0001"),

	//Códigos de error de Módulo de Cotizaciones
	/**
	 * Ocurrió un error en el Módulo de Cotizaciones
	 */
	COT_0001("message.err.cot.0001"),

	/**
	 * Rango de fechas invalido
	 */
	COT_0002("message.err.cot.0002"),

	/**
	 * El valor de {0} no coincide
	 */
	COT_0003("message.err.cot.0003"),
	
	/**
	 * Ocurrió un Error Servicio NO Disponible.
	 */
	COT_0004("message.err.cot.0004"),
	
	/**
	 * Ocurrió un Error Relación Empresa y Sucursal NO EXISTE.
	 */
	COT_0005("message.err.cot.0005"),
	
	/**
	 * El Beneficiario NO tiene estado Vigente en Caja Los Andes
	 */
	COT_0006("message.err.cot.0006"),
	
	/**
	 * El tipo de cotizacion a procesar debe estar en estado CARGADO o CORREGIDO.
	 */
	COT_0007("message.err.cot.0007"),
	/**
	 * No existe un periodo de Cotizaciones abierto, revisar Calendario de Cotizaciones.
	 */
	COT_0008("message.err.cot.0008"),
	/**
	 * No es posible realizar el registro de la cotización en este momento por problemas técnicos, 
	 * por favor vuelva a intentarlo. Si este mensaje persiste por favor comuníquese con el administrador del sistema para reportar el problema.
	 */
	COT_0009("message.err.cot.0009"),
	
	/**
	 * Fecha ingresada no es válida para una Cotización DYNP
	 */
	COT_0010("message.err.cot.0010"),
	/**
	 * Fecha de afiliación debe ser anterior a la fecha de declaración de  la Cotización
	 */
	COT_0011("message.err.cot.0011"),
	/**
	 * Hubo un Problema en la Inserción de la Cotización en la BD.
	 */
	COT_0012("message.err.cot.0012"),
	/**
	 *  Debe ingresar el id de la cotización.
	 */
	COT_0013("message.err.cot.0013"),
	/**
	 *  El número de cotización ingresada no existe.
	 */
	COT_0014("message.err.cot.0014"),
	
	//Códigos de error de Módulo de Establecimientos
	/** 
	 * Ocurrió un error en el Módulo de Establecimientos
	 */
	INS_0001("message.err.ins.0001"),
	
	//Códigos de error de MÃ³dulo de Establecimientos
	/** 
	 * no encontro colegio con esa descripcion o Establecimientos
	 */
	INS_0002("message.err.ins.0002"),
	
	
	//Códigos de error de Módulo de Estados
	/**
	 * Ocurrió un error en el Módulo de Estados.
	 */
	EST_0001("message.err.est.0001"),

	//Códigos de error de Módulo de Excepciones
	/**
	 * Ocurrió un error en el Módulo de Excepciones.
	 */
	EXC_0001("message.err.exc.0001"),

	//Códigos de error de Módulo de Mantenedores
	/**
	 * Ocurrió un error en el Módulo de Mantenedor de {0}.
	 */
	MAN_0001("message.err.man.0001"),

	/**
	 * Periodo existente. 
	 */
	MAN_0002("message.err.man.0002"),
	
	//Códigos de error de Módulo de Querys
	/**
	 * Ocurrió un error al realizar la Consulta.
	 */
	QUERY_0001("message.err.query.0001"),

	//Códigos de error de Módulo de Reclamos
	/**
	 * Ocurrió un error en el módulo de Reclamos.
	 */
	RECLAMO_0001("message.err.reclamo.0001"),

	//Códigos de error de Tramos
	/**
	 * Ocurrió un problema al Obtener el Tramo
	 */
	TRAMO_0001("message.err.tramo.0001"),
	
	/**
	 * No encontro la fecha indicada, dentro del historico de Tramos.
	 */
	TRAMO_0002("message.err.tramo.0002"),
	
	//Códigos de error de Traspasos
	/**
	 * Se ha producido un error al ejecutar el proceso el traspaso
	 */
	TRA_0001("message.err.tra.0001"),
	/**
	 * Se ha producido un error al generar el archivo de resultados del traspaso
	 */
	TRA_0002("message.err.tra.0002"),
	/**
	 * Se ha producido un error al descargar el archivo de resultados del traspaso
	 */
	TRA_0003("message.err.tra.0003"),
	/**
	 * Tipo de traspaso inexistente
	 */
	TRA_0004("message.err.tra.0004"),
	/**
	 * Empresa no vigente
	 */
	TRA_0005("message.err.tra.0005"),
	/**
	 * Empresa sin casa matriz. 
	 */
	TRA_0006("message.err.tra.0006"),
	
	/**
	 * Archivo columnas inválidas. 
	 */
	TRA_0007("message.err.tra.0007"),
	
	/**
	 * Ocurrio un error al generar las cuotas para Cesantia. 
	 */
	CUO_0001("message.err.cuo.0001"),
	
	/**
	 * El WS de Cesantia indica que el Beneficiario no es Cesante
	 */
	CUO_0002("message.err.cuo.0002"),

	/**
	 * Ocurrio un error al generar las Afas Autorizadas.
	 */
	AFA_0001("message.err.afa.0001"),

	/**
	 * Ocurrio un error al consultar las Afas Autorizadas
	 */
	AFA_0002("message.err.afa.0002"),

	/**
	 * El Beneficiario tiene tramos distintos en las Afas Autorizadas.
	 */
	AFA_0003("message.err.afa.0003"),
	
	/**
	 * Ocurrio un problema al modificar el estado de las Afas Autorizadas.
	 */
	AFA_0004("message.err.afa.0004"),
	
	/**
	 * Afa sin movimientos.
	 */
	AFA_0005("message.err.afa.0005"),
	
	/**
	 * Afa no tiene estado para permitir modificaciones.
	 */
	AFA_0006("message.err.afa.0006"),
	
	/**
	 * Tipo de movimiento no vigente para los reintegros
	 */
	REINT_0001("message.err.reint.0001"),
	/**
	 * Reintegro sin dias compensados en el periodo
	 */
	REINT_0002("message.err.reint.0002"),
	/**
	 * Error al modificar pago de reintegro
	 */
	REINT_0003("message.err.reint.0003"),
	
	/**
	 * Reintegro sin dias compensados en el periodo
	 */
	RET_0003("message.err.ret.0003"),
	/**
	 * Reintegro sin dias compensados en el periodo
	 */
	RET_0002("message.err.ret.0002"),
	
	/**
	 * Reintegro sin dias compensados en el periodo
	 */
	RET_0001("message.err.ret.0001"),
	
	/**
	 * Reintegro sin dias compensados en el periodo
	 */
	RET_0004("message.err.ret.0004"),
	
	/**
	 * Valida que al menos tengo un elemente selecionado
	 */
	RET_0005("message.err.ret.0005"),
	
	/**
	 * Valida que al menos tengo un elemente selecionado
	 */
	RET_0006("message.err.ret.0006"),
	
	/**
	 * Cambio Estado
	 */
	DEV_0001("message.err.dev.0001"),
	
	/**
	 * No se Puedo Mostar el Detalle de Las Cotizaciones
	 */
	DEV_0002("message.err.dev.0002"),
	
	/**
	 * error en el Buscador2 al cargar la Grilla
	 */
	DEV_0003("message.err.dev.0003"),
	
	/**
	 * error en el Buscador2 al cargar la Grilla
	 */
	DEV_0004("message.err.dev.0004"),
	
	/**
	 * no hay datos para cargar grilla
	 */
	DEV_0005("message.err.dev.0005"),
	
	/**
	 * no hay datos para cargar grilla
	 */
	DEV_0006("message.err.dev.0006"),
	
	/**
	 * No existen cotizaciones disponibles según criterios de búsqueda ingresados
	 */
	DEV_0007("message.err.dev.0007"),
	
	
	/**
	 * Valida que al menos tengo un elemente selecionado
	 */
	INGPROM_0001("message.err.ingProm.0001"),
	/**
	 * Valida formato de archivo cargado
	 */
	LISTCAU_0001("message.err.listaCau.0001"),
	/**
	 * Valida formato de archivo cargado
	 */
	LISTCAU_0002("message.err.listaCau.0002"),
	/**
	 * Valida formato de archivo cargado
	 */
	LISTCAU_0003("message.err.listaCau.0003"),
	 
	//Codigos de error para Extincion por Perdida de Requisitos
	/**
	 * Valida tipo  de archivo cargado
	 */
	EXTINCION_0013("message.err.Extincion.0013"),
	
	/**
	 * El Log se Genero con Exito.
	 */
	EXTINCION_0014("message.err.Extincion.0014"),
	
	/**
	 * No Hay Datos para Generar el Log.
	 */
	EXTINCION_0015("message.err.Extincion.0015"),
	
	/**
	 * Error en la generacion del log
	 */
	EXTINCION_0016("message.err.Extincion.0016"),
	
	/**
	 * Ocurrio un error al Procesar el Archivo.
	 */
	EXTINCION_0017("message.err.extincion.0023"),
	
	/**
	 * Revisar que el archivo en Excel este como Texto.
	 */
	EXTINCION_0018("message.err.Extincion.0018"),
	/**
	 * Fecha de extinción debe ser menor a la anterior que existe en el sistema.
	 */
	EXTINCION_0025("message.err.Extincion.0025"),
	
	/**
	 * Error en formto Archivo.
	 */
	EXTINCION_0026("message.err.Extincion.0026"),
	
	/**
	 * Error al descargar el Archivo.
	 */
	EXTINCION_0027("message.err.Extincion.0027"),
	
	//Codigos error para Solicitud de Beneficios.
	/**
	 * No Puede Optar al Beneficio Solicitado No cumple Los Requisitos Necesarios
	 */
	BENEFICIO_0001("message.err.Beneficio.0010"),
	
	/**
	 * Validar si ya tubo el beneficio
	 */
	BENEFICIO_0002("message.err.Beneficio.0011"),
	
	/**
	 * Error al Consultar si el beneficiario a tenido el beneficio
	 */
	BENEFICIO_0003("message.err.Beneficio.0012"),
	
	/**
	 * Valida que el  beneficiario  este en el Minvu
	 */
	BENEFICIO_0004("message.err.Beneficio.0013"),
	/**
	 * El Beneficiario ingresado No cumple con los Requisitos para el Beneficio.
	 */
	BENEFICIO_0005("message.err.beneficio.0014"),
	/**
	 * El Causante ingresado No cumple con los Requisitos para el Beneficio.
	 */
	BENEFICIO_0006("message.err.beneficio.0015"),
//	/**
//	 *Beneficio de natalidad ya fue otorgado.
//	 */
//	BENEFICIO_0016("message.err.beneficio.0016"),
//	/**
//	 * Beneficio de Nupcialidad ya fue otorgado.
//	 */
//	BENEFICIO_0017("message.err.beneficio.0017"),
//	/**
//	 * Beneficio de Educacion superior ya fue otorgado.
//	 */
//	BENEFICIO_0018("message.err.beneficio.0018"),
	/**
	 * Prestacion para el causante no fue encontrada
	 */
	BENEFICIO_0019("message.err.beneficio.0019"),
	/**
	 * El el Run del causante ingresado no corresponde a la conyugue.
	 */
	BENEFICIO_0020("message.err.beneficio.0020"),
	/**
	 * El Run del Causante ingresado no está en estado vigente.
	 */
	BENEFICIO_0021("message.err.beneficio.0021"),
	/**
	 * La fecha de nacimiento del causante excede los 180 dias.  
	 */
	BENEFICIO_0023("message.err.beneficio.0023"),
	
	// Codigos Error Normalizacion.
	/**
	 * Valida que el  beneficiario  este vigente
	 */
	NORMALIZACION_0001("message.err.normalizacion.0001"),
	/**
	 * Valida que hallan datos para mostrar
	 */
	NORMALIZACION_0002("message.err.normalizacion.0002"),
	/**
	 * Beneficiario no registra cotizaciones.
	 */
	HIST_COT_0001("message.err.historico.cotizaciones.0001"),

	//Retenedores
	/**
	 * No se encuentra carga válida con el rut ingresado.
	 */
	RETEN_0001("message.err.retenedores.0001"),
	/**
	 * La carga ya se encuentra en la lista.
	 */
	RETEN_0002("message.err.retenedores.0002"),
	/**
	 * Debe seleccionar un registro a procesar.
	 */
	REEM_0001("message.err.reemision.0001"),
	/**
	 * Error al descargar archivo fonasa.
	 */
	FONASA_0001("message.err.f21"),
	
	CAL_0001("message.err.cal.0001"),
	CAL_0002("message.err.cal.0002"),
	CAL_0003("message.err.cal.0003"),
	CAL_0004("message.err.cal.0004"),
	CAL_0005("message.err.cal.0005"),
	CAL_0006("message.err.cal.0006"),	
	CAL_0007("message.err.cal.0007"),
	CAL_0008("message.err.cal.0008"),
	//Códigos de error de Módulo de Establecimientos
	/** 
	 * Ocurrió un error en el Módulo de Codigo Respuesta Siagf
	 */
	REGCAU_0001("message.err.reg.0001"),
	
	/**
	 * Beneficiario se encuentra en estado NO VIGENTE.
	 */
	DEJUR_0001("message.err.dejur.0001"),
	DEJUR_0002("message.err.dejur.0002"),
	DEJUR_0003("message.err.dejur.0003"),
	;
	
	
	private final String msgProperty;
	

	/**
	 * Constructor de la enumeración.
	 * 
	 * @param msgProperty Corresponde a la clave del archivo de recursos que contiene los mensajes de error asociado a cada valor de la enumeración.
	 */
	IctExceptionEnum(String msgProperty) {
		this.msgProperty = msgProperty;
	}

	
	/**
	 * Sobreescribe el método.
	 */
	@Override
	public String toString() {
		return this.msgProperty;
	}

}
