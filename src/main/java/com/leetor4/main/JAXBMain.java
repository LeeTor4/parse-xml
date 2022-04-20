package com.leetor4.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBException;

import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.leetor4.handler.ParseDocXML;
import com.leetor4.model.system.RelacaoNotasFiscais;


public class JAXBMain {

	public static void main(String[] args) throws JAXBException, IOException {
		
		
		File diretorio  = new File("E:\\XML");
		Path dirDest    = Paths.get("E:\\xml-servidor");
		String dest     = "E:\\Matriz_201512_serie2.xlsx";
		
		ParseDocXML parse = new ParseDocXML();
		
		SXSSFWorkbook workbook = new SXSSFWorkbook(10000);
		SXSSFSheet  sheet = workbook.createSheet("Notas Saidas");
        RelacaoNotasFiscais relacao = new RelacaoNotasFiscais();
        //relacao.relacaoNotasFiscais(diretorio);
        String operacao = "S";
       
        relacao.exporaNotasFiscais(relacao.relacaoNotasFiscais(diretorio,operacao), workbook, sheet, dest);
        
        String cnpj = "";
        String codItem = "";
        String orig = "";
        String cst  = "";
        String numDoc = "";
        String cfop = "5101";
       
         //Individual
         //relacao.getParse().filtrarNotasFiscais(diretorio, dirDest,cnpj,codItem,cfop,orig,cst,numDoc);
        
//        String[] arrayString = new String[] {"7219","7224","7234","7264","7273","7282","7286","7288"};
// 
//        for (int i = 0; i < arrayString.length; i++){
//        	
//        	 relacao.getParse().filtrarNotasFiscais(diretorio, dirDest,cnpj,codItem,cfop,orig,cst,arrayString[i]);
//        }
        
        
        
        
        
        
        
        
        

	}

}
