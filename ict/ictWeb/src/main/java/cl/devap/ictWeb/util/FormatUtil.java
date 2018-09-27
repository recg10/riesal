package cl.devap.ictWeb.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class FormatUtil {

	 private static DecimalFormat decimalFormat ;
	 private static NumberFormat formato = NumberFormat.getNumberInstance(new Locale("es","CL"));
	
	 public static String llenarCeros(String numero, int largoRequerido) {
			StringBuffer filler = new StringBuffer();

			numero = numero.trim();
		    boolean negativo = false;
		    if (numero.length()>0)
			   negativo = numero.charAt(0) == '-';
			
			if(negativo) {
				largoRequerido--;
				numero = numero.substring(1);
			}

			for(int i=0;i < largoRequerido; i++)
				filler.append('0');

			filler.append(numero);

			String result = filler.substring(filler.length()-largoRequerido, filler.length());
			if(negativo)
				result = "-"+result;
			return result;
		}
	 
	 
//	public static String llenarCerosDelante(String texto, int largoTotalTexto) {
//		StringBuffer st = new StringBuffer();
//		for (int i = 0; i < (largoTotalTexto-texto.length()); i++) {
//			st.append("0");
//		}
//		st.append(texto);
//		return st.toString(); 
//		
//		
//	}
	
	public static String desformateaRut (String rut) {
		StringBuffer st = new StringBuffer();
		for (int i = 0; i < rut.length(); i++) {
			char digito = rut.charAt(i);
			if ((digito != '.') && (digito != '-'))
				st.append(digito);
		}
		return st.toString();
	}
	
	public static String formateaRut (String rut) {
		
		String formateado = llenarCeros(rut,12);
		String digito = formateado.substring(formateado.length()-1, formateado.length());
		formateado = formateado.substring(2, 4)+"."+formateado.substring(4, 7)+"."+formateado.substring(7, 10)+"-"+digito;
		
		return formateado;
	}
	
	//ENTREGA N�MERO SIN DECIMALES
    public static String formatearNumeroSinDecimales(String datos) {
        if (datos.trim().length() == 0){
            return "0";
        }
        decimalFormat = (DecimalFormat)formato;
        decimalFormat.applyPattern("###,###,###,###");
        return decimalFormat.format(Double.parseDouble(datos));
    }
    
 // A PARTIR DE UN RUT, SIN FORMATO Y CON DV, LO FORMATEA AGREGANDO PUNTOS Y GUI�N.
    public static String formatearRut(String rutConDV) {

    	String rut = Long.toString(Long.parseLong(rutConDV.substring(0,rutConDV.length()-1))) + rutConDV.substring(rutConDV.length()-1,rutConDV.length());
    	
    	String invertido = "";

        for (int i = (rut.length() - 1); i >= 0; i--)
            invertido = invertido + rut.charAt(i);

        String dtexto = "";
        dtexto = dtexto + invertido.charAt(0);

        if (dtexto != "") {
            dtexto = dtexto + '-';
        }

        int cnt = 0;

        for (int i = 1; i < rut.length(); i++) {

            if (cnt == 3) {
                dtexto = dtexto.concat(".");
                dtexto = dtexto + invertido.charAt(i);
                cnt = 1;
            } 
            else {
                dtexto = dtexto + invertido.charAt(i);
                cnt++;
            }
        }

        invertido = "";

        for (int i = (dtexto.length() - 1); i >= 0; i--)
            invertido = invertido + dtexto.charAt(i);

        return invertido;

    }
    
    public static String formatearFolio(String numero){
    	if(numero== null ||numero.length()<6)
    		return numero;
    	return numero.substring(0, 3)+"-"+numero.substring(3, 6)+"-"+numero.substring(6, numero.length());
    }
    
    public static String formatearCtaCteBice(String numero){
    	if(numero== null ||numero.length()<8)
    		return numero;
    	return numero.substring(0, 2)+"-"+numero.substring(2, 7)+"-"+numero.substring(7, 8);
    }
    
    public static String formatearFecha(Date fechaIn, String formatoOut) {

        SimpleDateFormat df1 = new java.text.SimpleDateFormat(formatoOut);
        return df1.format(fechaIn);


    }
    
    public static String completarConValor(String texto, int largoRequerido, String valor){
		StringBuffer st = new StringBuffer();
		for (int i = 0; i < (largoRequerido-texto.length()); i++) {
			st.append(valor);
		}		
		return st.toString(); 
	}
    
    public static String eliminaCaracterdeCadena (String cadena, char caracterEliminar){
    	String nuevaCadena="";
		for(int i=0; i<cadena.length(); i++){
			if (cadena.charAt( i ) != caracterEliminar)			
				nuevaCadena = nuevaCadena + cadena.charAt( i );	
		}
		return nuevaCadena;
	}

   	public static boolean validarRut(String rut) {
    	if (rut == null) {
    		return false;
    	}
    	rut = llenarCeros(rut, 9);
    	int longitud = rut.length();
    	String dv = rut.substring(longitud - 1, longitud);
    	if (digitoParaRut(rut.substring(0, longitud - 1)).equalsIgnoreCase(dv)) {
    		return true;
    	}
    		return false;
    	}

    	/**
    	* Para un rut ingresado, se retorna el d�gito validador correspondiente
    	*
    	* @param rut Ingresar sin d�gito verificador, ni puntos.
    	*
    	* @return D�gito buscado
    	*/
    	public static String digitoParaRut(String rut) {
    	if (rut == null) {
    		return null;
    	}
    	int mul = 2;
    	int suma = 0;
    	int dig;
    	int resto;
    	int longitud = rut.length();
    	String ldv;
    	for (int i = longitud - 1;i >= 0;i--) {
	    	dig = Integer.parseInt(String.valueOf(rut.charAt(i)));
	    	suma += dig * mul;
	    	if (mul == 7) {
	    		mul = 2;
	    	} else {
	    		mul++;
	    	}
    	}
    	resto = suma % 11;
    	if (resto == 0) {
    		return "0";
    	}
    	if (resto == 1) {
    		return "K";
    	}
    	dig = 11 - resto;
    	return Integer.toString(dig);
    	}


}
