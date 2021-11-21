package com.leetor4.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBException;

import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.leetor4.handler.CopiarArquivosXMLDePastaOrigDest;
import com.leetor4.handler.ParseDocXML;
import com.leetor4.model.nfe.Icms;
import com.leetor4.model.nfe.DocumentoFiscalEltronico;
import com.leetor4.model.nfe.Produtos;
import com.leetor4.model.system.RelacaoNotasFiscais;


public class JAXBMain {

	public static void main(String[] args) throws JAXBException, IOException {
		
		
		File diretorio  = new File("D:\\XML");
		Path dirDest    = Paths.get("D:\\xml-servidor");
		String dest     = "D:\\Matriz_Saidas_202106.xlsx";
		
		ParseDocXML parse = new ParseDocXML();
		
		SXSSFWorkbook workbook = new SXSSFWorkbook(10000);
		SXSSFSheet  sheet = workbook.createSheet("Notas Saidas");
        RelacaoNotasFiscais relacao = new RelacaoNotasFiscais();
        //relacao.relacaoNotasFiscais(diretorio);
        String operacao = "S";
       
        relacao.exporaNotasFiscais(relacao.relacaoNotasFiscais(diretorio,operacao), workbook, sheet, dest);
        
        String cnpj = "";
        String codItem = "103420";
        String orig = "";
        String cst  = "";
        String numDoc = "";
        String cfop = "";
        //relacao.getParse().filtrarNotasFiscais(diretorio, dirDest,cnpj,codItem,cfop,orig,cst,numDoc);
        
     
	}

}
