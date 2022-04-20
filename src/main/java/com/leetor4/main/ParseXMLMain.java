package com.leetor4.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.leetor4.handler.ParseDocXML;
import com.leetor4.model.nfe.DocumentoFiscalEltronico;

public class ParseXMLMain {


	public static List<DocumentoFiscalEltronico> getDocumentosEletronicos(String file,ParseDocXML parseDocXML) {
		File f = new File(file);
		List<DocumentoFiscalEltronico> retorno = null;
		try {
			retorno = parseDocXML.validaTipoDeParseNFE(f);
		} catch (IOException | JAXBException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		
		  String ano = "2017";
		  String emp = "SELLENE";
		  String estab = "SAO_MATEUS";
		  String cnpj  = "05329222000761";
		 
		  Path x5 =  Paths.get("E:\\EMPRESAS".concat("\\").concat(emp).concat("\\").concat(estab).concat("\\SPED").concat("\\").concat(ano).concat("\\XML").concat("\\").concat("Proprios").concat("\\").concat("\\mai"));
		  Path x10 = Paths.get("E:\\EMPRESAS".concat("\\").concat(emp).concat("\\").concat(estab).concat("\\SPED").concat("\\").concat(ano).concat("\\XML").concat("\\out"));
		  ParseDocXML parseDocXML = new ParseDocXML();
		  String file = "E:\\XML";
		  //getDocumentosEletronicos(x10.toString(),parseDocXML);
		  int cont = 0;
		  for(DocumentoFiscalEltronico lista :  getDocumentosEletronicos(x5.toString(),parseDocXML)){
			  cont++;
			  System.out.println(cont + "->" + lista.getIdent().getChaveeletronica());
		  }
		
	}

}
