package com.leetor4.model.system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.JAXBException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.leetor4.handler.ParseNFE;
import com.leetor4.model.nfe.Icms;
import com.leetor4.model.nfe.ImpostoNFE;
import com.leetor4.model.nfe.NotaFiscal;
import com.leetor4.model.nfe.Produtos;

public class RelacaoNotasFiscais {
    
	private ParseNFE parse = new ParseNFE();
	
	public Map<Integer, Object[]>  relacaoNotasFiscais(File diretorio) throws IOException, JAXBException {
		int id=0;
		int indice = 1;

	    //Create a blank sheet
	    //This data needs to be written (Object[])
	    Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
	    data.put(indice, 
	    new Object[]
	    {"ID","CHAVE","UF","COD_NF","NAT_OPERAÇÃO","MODELO_DOC","SERIE","NUM_DOC",
	    "CNPJ_EMITENTE","NOME_EMITENTE",
	    "NUM_ITEM","COD_ITEM","DESCRIÇAO","NCM","CFOP","ORIG","CST_ICMS","UND_COMERCIAL","QTD_COMERCIAL","VL_UND_COMERCIAL","VL_PRODUTO",
	    "COD_EAN_TRIB","UND_TRIB","QTD_TRIB","VL_UNID_TRIB","IND_TOT"});		
		ParseNFE parse = new ParseNFE();
		for(NotaFiscal n : parse.validaTipoDeParseNFE(diretorio)){
			//System.out.println(n.getIdent().getChaveeletronica());
			for(Produtos p: n.getProds()){
				id++;
				indice++;
				System.out.println(
						id + "|"+
						n.getIdent().getChaveeletronica() +"|"+ 
						n.getIdent().getCodigoUF() +"|"+ 
						n.getIdent().getCodigoNF() +"|"+ 
						n.getIdent().getNaturezaOperacao() +"|"+ 
						n.getIdent().getModeloDoc() +"|"+ 
						n.getIdent().getSerie() +"|"+
						n.getIdent().getNumDoc() +"|"+ 
						n.getEmitente().getCnpj() +"|"+ 
						n.getEmitente().getNome() +"|"+ 
				        p.getNumItem() + "|"+ 
					    p.getCodItem()  +"|"+ 
				        p.getDescricao()+"|"+
				        p.getNcm() +"|"+ 
				        p.getCfop() +"|"+
				        p.getOrig() +"|"+
				        p.getCst() +"|"+
				        p.getUndComercial() +"|"+
				        p.getQtdComercial() +"|"+
				        p.getVlUnComerial()+"|"+
				        p.getVlProduto()+"|"+
				        p.getCodEanTrib()+"|"+
				        p.getUndTrib() +"|"+
				        p.getQtdTrib() +"|"+
				        p.getVlUnTrib() +"|"+
				        p.getIndTot()
				      );
				      
				  
				        
				  data.put(indice, 
						  
			        new Object[]{id, n.getIdent().getChaveeletronica(),n.getIdent().getCodigoUF(),n.getIdent().getCodigoNF(),n.getIdent().getNaturezaOperacao(),
			        		n.getIdent().getModeloDoc(),n.getIdent().getSerie(),n.getIdent().getNumDoc() ,n.getEmitente().getCnpj(),n.getEmitente().getNome(),
			        		 p.getNumItem(), p.getCodItem(), p.getDescricao(), p.getNcm(),p.getCfop(), p.getOrig(), p.getCst() ,p.getUndComercial(), 
			        		 p.getQtdComercial().replace(".",","), p.getVlUnComerial().replace(".",","), p.getVlProduto().replace(".",","),p.getCodEanTrib(), p.getUndTrib().replace(".",","), p.getQtdTrib().replace(".",","),
			        		 p.getVlUnTrib().replace(".",","), p.getIndTot()});
			}
			

		}
		
		return data;
	}
	
	public void exporaNotasFiscais(Map<Integer, Object[]> data,XSSFWorkbook workbook,XSSFSheet sheet,
			     String path) {
		
		 //Iterate over data and write to sheet
	    Set<Integer> keyset = data.keySet();

	    int rownum = 0;
	    for (Integer key : keyset) 
	    {
	        //create a row of excelsheet
	        Row row = sheet.createRow(rownum++);

	        //get object array of prerticuler key
	        Object[] objArr = data.get(key);

	        int cellnum = 0;

	        for (Object obj : objArr) 
	        {
	            Cell cell = row.createCell(cellnum++);
	            if (obj instanceof String) 
	            {
	                cell.setCellValue((String) obj);
	            }
	            else if (obj instanceof Integer) 
	            {
	                cell.setCellValue((Integer) obj);
	            }
	        }
	    }
	    try 
	    {
	        //Write the workbook in file system
	        FileOutputStream out = new FileOutputStream(new File(path));
	        workbook.write(out);
	        out.close();
	        System.out.println("written successfully on disk.");
	    } 
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	}

	public ParseNFE getParse() {
		return parse;
	}
	
	
}
