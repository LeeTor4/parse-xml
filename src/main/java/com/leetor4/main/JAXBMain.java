package com.leetor4.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.leetor4.handler.CopiarArquivosXMLDePastaOrigDest;
import com.leetor4.handler.ParseNFE;
import com.leetor4.model.nfe.Icms;
import com.leetor4.model.nfe.NotaFiscal;
import com.leetor4.model.nfe.Produtos;
import com.leetor4.model.system.RelacaoNotasFiscais;


public class JAXBMain {

	public static void main(String[] args) throws JAXBException, IOException {
		
		
		File diretorio  = new File("D:\\XML");
		Path dirDest    = Paths.get("D:\\xml-servidor");
		String dest     = "D:\\Relacao_Saidas.xlsx";
		
		ParseNFE parse = new ParseNFE();
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Notas Proprias");
        RelacaoNotasFiscais relacao = new RelacaoNotasFiscais();
        //relacao.relacaoNotasFiscais(diretorio);
        //relacao.exporaNotasFiscais(relacao.relacaoNotasFiscais(diretorio), workbook, sheet, dest);
        
        String cnpj = "";
        String codItem = "";
        String orig = "";
        String cst  = "10";
        String numDoc = "";
        relacao.getParse().filtrarNotasFiscais(diretorio, dirDest,cnpj,codItem,orig,cst,numDoc);
        
     
	}

}
