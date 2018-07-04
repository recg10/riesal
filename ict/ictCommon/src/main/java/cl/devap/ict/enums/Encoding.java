package cl.devap.ict.enums;

public enum Encoding {
	
	ISO_8859_1("ISO-8859-1"),
	UTF_8("UTF-8");
	
	private String charset;
	
	private Encoding(String charset){
		this.charset = charset;
	}
	
	public String getCharset(){
		return this.charset;
	}
}
