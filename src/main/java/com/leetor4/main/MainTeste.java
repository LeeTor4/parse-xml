package com.leetor4.main;

import com.leetor4.model.nfe.GrupoIcms;
import com.leetor4.model.nfe.Icms60;

public class MainTeste {

	public static void main(String[] args) {
		
		

		GrupoIcms v = GrupoIcms.valueOf(GrupoIcms.class,"ICMS60");
		Object i =  v.pegarGrupoIcms();
		
		Icms60 g60 = (Icms60) i; 
		g60.setvBCSTRet("10");
		System.out.println(g60.getvBCSTRet());
		
		
	}

}
