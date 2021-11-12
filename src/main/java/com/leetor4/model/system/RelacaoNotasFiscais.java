package com.leetor4.model.system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.bind.JAXBException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.leetor4.handler.ParseNFE;
import com.leetor4.model.nfe.NotaFiscal;
import com.leetor4.model.nfe.Produtos;
import com.leetor4.util.UtilsEConverters;

public class RelacaoNotasFiscais {
    
	private ParseNFE parse = new ParseNFE();
	
	public Map<Integer, Object[]>  relacaoNotasFiscais(File diretorio, String operacao) throws IOException, JAXBException {
		int id=0;
		int indice = 1;

	    //Create a blank sheet
	    //This data needs to be written (Object[])
	    Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
	    data.put(indice, 
	    new Object[]
	    {"ID","OPERACAO","CHAVE","UF","COD_NF","NAT_OPERAÇÃO","MODELO_DOC","SERIE","NUM_DOC","DT_EMISSAO",
	    "CNPJ_EMIT","NOME_EMIT", "CNPJ_DEST","NOME_DEST","IE_DEST",
	    "NUM_ITEM","COD_ITEM","DESCRIÇAO","NCM","CFOP","ORIG","CST_ICMS","MOD_BC","VL_BC","ALIQ_ICMS","VL_ICMS","MOD_BC_ST","CST_PIS","CST_COFINS","UND_COMERCIAL","QTD_COMERCIAL","VL_UND_COMERCIAL","VL_PRODUTO",
	    "COD_EAN_TRIB","UND_TRIB","QTD_TRIB","VL_UNID_TRIB","IND_TOT","NUM_LOTE","QTDE_LOTE","FAB_LOTE","VAL_LOTE",
	    "VL_BC","VL_ICMS","VL_ICMS_DESON","VL_FCP","VL_BC_CST","VL_ST","VL_FCP_ST","VL_FCP_ST_RET","VL_PROD","VL_FRETE","VL_SEG","VL_DESC","VL_II",
	    "VL_IPI","VL_IPI_DEVOL","VL_PIS","VL_COFINS","VL_OUTROS","VL_NF"});		
		ParseNFE parse = new ParseNFE();
		for(NotaFiscal n : parse.validaTipoDeParseNFE(diretorio)){
			for(Produtos p: n.getProds()){
				id++;
				indice++;
//				System.out.println(
//						id + "|"+
//						n.getIdent().getChaveeletronica() +"|"+ 
//						n.getIdent().getCodigoUF() +"|"+ 
//						n.getIdent().getCodigoNF() +"|"+ 
//						n.getIdent().getNaturezaOperacao() +"|"+ 
//						n.getIdent().getModeloDoc() +"|"+ 
//						n.getIdent().getSerie() +"|"+
//						n.getIdent().getNumDoc() +"|"+ 
//						n.getEmitente().getCnpj() +"|"+ 
//						n.getEmitente().getNome() +"|"+ 
//						n.getDestinatario().getCnpj() +"|"+ 
//						n.getDestinatario().getNome() +"|"+
//						n.getDestinatario().getIe() +"|"+
//				        p.getNumItem() + "|"+ 
//					    p.getCodItem()  +"|"+ 
//				        p.getDescricao()+"|"+
//				        p.getNcm() +"|"+ 
//				        p.getCfop() +"|"+
//				        p.getOrig() +"|"+
//				        p.getCst() +"|"+
//				        p.getModBc() +"|"+
//				        p.getCstPis() +"|"+
//				        p.getCstCofins() +"|"+
//				        p.getUndComercial() +"|"+
//				        p.getQtdComercial() +"|"+
//				        p.getVlUnComerial()+"|"+
//				        p.getVlProduto()+"|"+
//				        p.getCodEanTrib()+"|"+
//				        p.getUndTrib() +"|"+
//				        p.getQtdTrib() +"|"+
//				        p.getVlUnTrib() +"|"+
//				        p.getIndTot() +"|"+
//				        p.getRastro().getNumLote()+"|"+
//				        p.getRastro().getQtdLote()+"|"+
//				        p.getRastro().getDtFab()+"|"+
//				        p.getRastro().getDtVal()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlBc()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlIcms()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlIcmsDeson()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlFCP()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlBCST()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlST()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlFCPST()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlFCPSTRet()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlProd()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlFrete()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlSeg()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlDesc()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlII()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlIPI()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlIPIDevol()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlPIS()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlCOFINS()+"|"+
//				        n.getTotal().getIcmsTot().getVlOutro()+"|"+ 
//				        n.getTotal().getIcmsTot().getVlNF()
//				        
//				      );
				
				
				
				data.put(indice, 
						  
		        new Object[]{id, operacao,n.getIdent().getChaveeletronica(),
		        		 n.getIdent().getCodigoUF(),
		        		 n.getIdent().getCodigoNF(),
		        		 n.getIdent().getNaturezaOperacao(),
		        		 n.getIdent().getModeloDoc(),
		        		 n.getIdent().getSerie(),
		        		 n.getIdent().getNumDoc() ,
		        		 UtilsEConverters.getStringParaData(n.getIdent().getDataEmissao()),
		        		 n.getEmitente().getCnpj(),
		        		 n.getEmitente().getNome(),
		        		 n.getDestinatario().getCnpj(),
		        		 n.getDestinatario().getNome(),
		        		 n.getDestinatario().getIe(),
		        		 p.getNumItem(), 
		        		 p.getCodItem(),
		        		 p.getDescricao(),
		        		 p.getNcm(),
		        		 p.getCfop(), 
		        		 p.getOrig(),
		        		 p.getCst(),
		        		 p.getModBc(),
		        		 (p.getVlBc()==null?"0,00":p.getVlBc().replace(".",",")),
		        		 (p.getAliqIcms()==null?"0,00":p.getAliqIcms().replace(".",",")),
		        		 (p.getVlIcms()==null?"":p.getVlIcms().replace(".",",")),
		        		 p.getModBcST(),
		        		 p.getCstPis() ,
		        		 p.getCstCofins(),
		        		 p.getUndComercial(), 
		        		 p.getQtdComercial().replace(".",","),
		        		 p.getVlUnComerial().replace(".",","),
		        		 p.getVlProduto().replace(".",","),
		        		 p.getCodEanTrib(), 
		        		 p.getUndTrib().replace(".",","), 
		        		 p.getQtdTrib().replace(".",","),
		        		 p.getVlUnTrib().replace(".",","), 
		        		 p.getIndTot(), 
		        		 p.getRastro().getNumLote(), 
		        		 (p.getRastro().getQtdLote() == null ? "" : p.getRastro().getQtdLote().replace(".",",")),
		        		 p.getRastro().getDtFab(),
		        		 p.getRastro().getDtVal(),
		        		 n.getTotal().getIcmsTot().getVlBc().replace(".",","),
 				         n.getTotal().getIcmsTot().getVlIcms().replace(".",","),
 				         (n.getTotal().getIcmsTot().getVlIcmsDeson()==null?"":n.getTotal().getIcmsTot().getVlIcmsDeson().replace(".",",")),
 				         (n.getTotal().getIcmsTot().getVlFCP() == null ?"": n.getTotal().getIcmsTot().getVlFCP().replace(".",",")),
 				         n.getTotal().getIcmsTot().getVlBCST().replace(".",","),
 				         n.getTotal().getIcmsTot().getVlST().replace(".",","), 
 				         (n.getTotal().getIcmsTot().getVlFCPST() == null?"": n.getTotal().getIcmsTot().getVlFCPST().replace(".",",")), 
 				         (n.getTotal().getIcmsTot().getVlFCPSTRet() == null?"": n.getTotal().getIcmsTot().getVlFCPSTRet().replace(".",",")), 
 				         (n.getTotal().getIcmsTot().getVlProd()==null?"":n.getTotal().getIcmsTot().getVlProd().replace(".",",")), 
 				         n.getTotal().getIcmsTot().getVlFrete().replace(".",","), 
 				         n.getTotal().getIcmsTot().getVlSeg().replace(".",","), 
 				         n.getTotal().getIcmsTot().getVlDesc().replace(".",","), 
 				         n.getTotal().getIcmsTot().getVlII().replace(".",","), 
 				         (n.getTotal().getIcmsTot().getVlIPI() == null ? "" : n.getTotal().getIcmsTot().getVlIPI().replace(".",",")), 
 				         (n.getTotal().getIcmsTot().getVlIPIDevol()==null?"": n.getTotal().getIcmsTot().getVlIPIDevol().replace(".",",")), 
 				         (n.getTotal().getIcmsTot().getVlPIS()==null?"":n.getTotal().getIcmsTot().getVlPIS().replace(".",",")), 
 				         (n.getTotal().getIcmsTot().getVlCOFINS().replace(".",",")),
 				         (n.getTotal().getIcmsTot().getVlOutro()==null?"":n.getTotal().getIcmsTot().getVlOutro().replace(".",",")), 
 				         (n.getTotal().getIcmsTot().getVlNF()==null?"":n.getTotal().getIcmsTot().getVlNF().replace(".",","))});
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
	            else if (obj instanceof LocalDate) 
	            {
	                cell.setCellValue((LocalDate) obj);
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
