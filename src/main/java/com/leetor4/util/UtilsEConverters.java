package com.leetor4.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class UtilsEConverters {

	private static DateTimeFormatter formatter = 
			  DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	private static DateTimeFormatter formatter2 = 
			  DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
    public static String getDataParaString2(LocalDate data) {
		
		String dtFormatada = formatter2.format(data);
		//System.out.println(dtFormatada);
		return dtFormatada;
	}
    
	public static LocalDate getStringParaData(String data) {
		TemporalAccessor parse = formatter.parse(data);
		LocalDate from = LocalDate.from(parse);
		//System.out.println(from);
		return from;
	}
	
	public static String convertParaNumeroDecimalBrasil(String formato) {
		String padrao = "###,###.##"; 
        DecimalFormat df = new DecimalFormat(padrao);
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt","Brazil"));
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df = new DecimalFormat(padrao,dfs);
        
        return df.format(formato);
	}
}
