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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.leetor4.handler.ParseDocXML;
import com.leetor4.model.nfe.DocumentoFiscalEltronico;
import com.leetor4.model.nfe.Produtos;
import com.leetor4.util.UtilsEConverters;

public class RelacaoNotasFiscais {
    
	private ParseDocXML parse = new ParseDocXML();
	
	public Map<Integer, Object[]>  relacaoNotasFiscais(File diretorio, String operacao) throws IOException, JAXBException {
		int id=0;
		int indice = 1;
        
		
		
		
	    //Create a blank sheet
	    //This data needs to be written (Object[])
	    Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
	    data.put(indice, 
	    new Object[]
	    {"ID","OPERACAO","CHAVE","UF","COD_DOC","NAT_OPERAÇÃO","MODELO_DOC","SERIE","NUM_DOC","DT_EMISSAO","DT_ENTSAI","TIPO_DOC","ID_DEST","COD_MUN_FG","TP_IMP","TP_EMI","C_DV","TP_AMB","FIN_EMI","PROC_EMI","VER_PROC",
	    "CNPJ_EMIT","NOME_EMIT","LOGRADOURO_EMIT","NUM_EMIT","BAIRRO_EMIT","CODIGO_EMIT","MUNICIPIO_EMIT","UF_EMIT","CEP_EMIT","CODPAIS_EMIT","FONE_EMIT","IE_EMIT", 
	    "CNPJ_DEST","NOME_DEST","LOGRADOURO_DEST","NUM_DEST","BAIRRO_DEST","CODIGO_DEST","MUNICIPIO_DEST","UF_DEST","CEP_DEST","CODPAIS_DEST","FONE_DEST","IE_DEST",
	    "NUM_ITEM","COD_ITEM","DESCRIÇAO","NCM","CFOP","ORIG","CST_ICMS",
	    "ALIQ_CRED_SN","VL_CRED_ICMSSN","MOD_BC","ALIQ_RED_BC","VL_BC","ALIQ_ICMS","VL_ICMS","MOD_BC_ST","ALIQ_MVAST","ALIQ_RED_BC_ST","VL_BC_ST","ALIQ_ICMS_ST","VL_ICMS_ST","VL_ICMS_DESON","MOT_DESON_ICMS",
	    "CST_PIS","CST_COFINS",
	    "UND_COMERCIAL","QTD_COMERCIAL","VL_UND_COMERCIAL","VL_PRODUTO",
	    "COD_EAN_TRIB","UND_TRIB","QTD_TRIB","VL_UNID_TRIB","IND_TOT","NUM_LOTE","QTDE_LOTE","FAB_LOTE","VAL_LOTE",
	    "VL_BC","VL_ICMS","VL_ICMS_DESON","VL_FCP","VL_BC_CST","VL_ST","VL_FCP_ST","VL_FCP_ST_RET","VL_PROD","VL_FRETE","VL_SEG","VL_DESC","VL_II",
	    "VL_IPI","VL_IPI_DEVOL","VL_PIS","VL_COFINS","VL_OUTROS","VL_NF"});		
		ParseDocXML parse = new ParseDocXML();
		for(DocumentoFiscalEltronico n : parse.validaTipoDeParseNFE(diretorio)){
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
			  
				 LocalDate dtEmi;
				 if(n.getIdent().getDataEmissao().length() == 8) {
					 dtEmi =  UtilsEConverters.getStringParaData3(n.getIdent().getDataEmissao());
				 }else {
					 dtEmi =  UtilsEConverters.getStringParaData(n.getIdent().getDataEmissao());
				 }
				 data.put(indice, 
						  
		        new Object[]{id, operacao,n.getIdent().getChaveeletronica(),
		        		 n.getIdent().getCodigoUF(),
		        		 n.getIdent().getCodigoNF(),
		        		 n.getIdent().getNaturezaOperacao(),
		        		 n.getIdent().getModeloDoc(),
		        		 n.getIdent().getSerie(),
		        		 n.getIdent().getNumDoc() ,
		        		
		        		 dtEmi,
		        		 (n.getIdent().getDataEntSai()==null?"":UtilsEConverters.getStringParaData(n.getIdent().getDataEntSai())),
		        		
		        		 n.getIdent().getTipoNF(),
		        		 n.getIdent().getIdDest(),
		        		 n.getIdent().getCodigoMunFG(),
		        		 n.getIdent().getTipoImp(),
		        		 n.getIdent().getTipoEmissao(),
		        		 n.getIdent().getDigVerifChaveAcesso(),
		        		 n.getIdent().getTipoAmbiente(),
		        		 n.getIdent().getFinalidadeEmissao(),
		        		 n.getIdent().getProcessoEmissao(),
		        		 n.getIdent().getVersaoProcesso(),
		        		 n.getEmitente().getCnpj(),
		        		 n.getEmitente().getNome(),
		        		 n.getEmitente().getEnd().getLogradouro(),
		        		 n.getEmitente().getEnd().getNumero(),
		        		 n.getEmitente().getEnd().getBairro(),
		        		 n.getEmitente().getEnd().getCodMun(),
		        		 n.getEmitente().getEnd().getDescMun(),
		        		 n.getEmitente().getEnd().getUf(),
		        		 n.getEmitente().getEnd().getCep(),
		        		 n.getEmitente().getEnd().getCodPais(),
		        		 n.getEmitente().getEnd().getFone(),
		        		 n.getEmitente().getIe(),
		        		 n.getDestinatario().getCnpj(),
		        		 n.getDestinatario().getNome(),
		        		 n.getDestinatario().getEnd().getLogradouro(),
		        		 n.getDestinatario().getEnd().getNumero(),
		        		 n.getDestinatario().getEnd().getBairro(),
		        		 n.getDestinatario().getEnd().getCodMun(),
		        		 n.getDestinatario().getEnd().getDescMun(),
		        		 n.getDestinatario().getEnd().getUf(),
		        		 n.getDestinatario().getEnd().getCep(),
		        		 n.getDestinatario().getEnd().getCodPais(),
		        		 n.getDestinatario().getEnd().getFone(),
		        		 n.getDestinatario().getIe(),
		        		 p.getNumItem(), 
		        		 p.getCodItem(),
		        		 p.getDescricao(),
		        		 p.getNcm(),
		        		 p.getCfop(), 
		        		 p.getOrig(),
		        		 p.getCst(),
		        		 (p.getAliqCredSN()==null?"":Double.valueOf(p.getAliqCredSN())),
		        		 (p.getvCredICMSSN()==null?"":Double.valueOf(p.getvCredICMSSN())),
		        		 p.getModBc(),
		        		 (p.getAliqRedBc()==null?"":Double.valueOf(p.getAliqRedBc())),
		        		 (p.getVlBc()==null?"":Double.valueOf(p.getVlBc())),
		        		 (p.getAliqIcms()==null?"":Double.valueOf(p.getAliqIcms())),
		        		 (p.getVlIcms()==null?"": Double.valueOf(p.getVlIcms())),
		        		 p.getModBcST(),
		        		 (p.getAliqMVAST()==null?"":Double.valueOf(p.getAliqMVAST())),
		        		 (p.getAliqRedBCST()==null?"":Double.valueOf(p.getAliqRedBCST())),
		        		 (p.getVlBcST()==null?"":Double.valueOf(p.getVlBcST())),
		        		 (p.getAliqIcmsST()==null?"":Double.valueOf(p.getAliqIcmsST())),
		        		 (p.getVlIcmsST()==null?"":Double.valueOf(p.getVlIcmsST())),
		        		 (p.getVlIcmsDeson()==null?"":Double.valueOf(p.getVlIcmsDeson())),
		        		 p.getMotDesICMS(),
		        		 p.getCstPis() ,
		        		 p.getCstCofins(),
		        		 p.getUndComercial(), 
		        		 (p.getQtdComercial()==null?"":Double.valueOf(p.getQtdComercial())),
		        		 (p.getQtdComercial()==null?"":Double.valueOf(p.getVlUnComerial())),
		        		 (p.getVlProduto()==null?"":Double.valueOf(p.getVlProduto())),
		        		 p.getCodEanTrib(), 
		        		 (p.getUndTrib()==null?"":Double.valueOf(p.getUndTrib())), 
		        		 (p.getQtdTrib()==null?"":Double.valueOf(p.getQtdTrib())),
		        		 (p.getVlUnTrib()==null?"":Double.valueOf(p.getVlUnTrib())), 
		        		 p.getIndTot(), 
		        		 p.getRastro().getNumLote(), 
		        		 (p.getRastro().getQtdLote() == null ? "" :Double.valueOf( p.getRastro().getQtdLote())),
		        		 p.getRastro().getDtFab(),
		        		 p.getRastro().getDtVal(),
		        		 (n.getTotal().getIcmsTot().getVlBc()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlBc())),
 				         ( n.getTotal().getIcmsTot().getVlIcms()==null?"":Double.valueOf( n.getTotal().getIcmsTot().getVlIcms())),
 				         (n.getTotal().getIcmsTot().getVlIcmsDeson()==null?"": Double.valueOf(n.getTotal().getIcmsTot().getVlIcmsDeson())),
 				         (n.getTotal().getIcmsTot().getVlFCP() == null ?"": Double.valueOf(n.getTotal().getIcmsTot().getVlFCP())),
 				         (n.getTotal().getIcmsTot().getVlBCST()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlBCST())),
 				         (n.getTotal().getIcmsTot().getVlST()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlST())), 
 				         (n.getTotal().getIcmsTot().getVlFCPST() == null?"": Double.valueOf(n.getTotal().getIcmsTot().getVlFCPST())), 
 				         (n.getTotal().getIcmsTot().getVlFCPSTRet() == null?"": Double.valueOf(n.getTotal().getIcmsTot().getVlFCPSTRet())), 
 				         (n.getTotal().getIcmsTot().getVlProd()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlProd())), 
 				         (n.getTotal().getIcmsTot().getVlFrete()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlFrete())), 
 				         (n.getTotal().getIcmsTot().getVlSeg()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlSeg())), 
 				         (n.getTotal().getIcmsTot().getVlDesc()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlDesc())), 
 				         (n.getTotal().getIcmsTot().getVlII()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlII())), 
 				         (n.getTotal().getIcmsTot().getVlIPI() == null ? "" : Double.valueOf(n.getTotal().getIcmsTot().getVlIPI())), 
 				         (n.getTotal().getIcmsTot().getVlIPIDevol()==null?"": Double.valueOf(n.getTotal().getIcmsTot().getVlIPIDevol())), 
 				         (n.getTotal().getIcmsTot().getVlPIS()==null?"": Double.valueOf(n.getTotal().getIcmsTot().getVlPIS())), 
 				         (n.getTotal().getIcmsTot().getVlCOFINS()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlCOFINS())),
 				         (n.getTotal().getIcmsTot().getVlOutro()==null?"": Double.valueOf(n.getTotal().getIcmsTot().getVlOutro())), 
 				         (n.getTotal().getIcmsTot().getVlNF()==null?"":Double.valueOf(n.getTotal().getIcmsTot().getVlNF()))});
			}
			

		}
		
		return data;
	}
	
	public void exporaNotasFiscais(Map<Integer, Object[]> data,XSSFWorkbook workbook,XSSFSheet sheet,
			     String path) {
		
		
		DataFormat format = workbook.createDataFormat();
		CellStyle cs = workbook.createCellStyle();
		CellStyle csNum = workbook.createCellStyle();
		XSSFDataFormat df = workbook.createDataFormat();
		cs.setDataFormat(df.getFormat("dd/mm/yyyy"));
		
		csNum.setDataFormat(format.getFormat("0.0"));
		
		
		
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
	            else if (obj instanceof Double) 
	            {
	    	        cell.setCellValue((Double) obj);
	            }
	            else if (obj instanceof LocalDate) 
	            {
	            	cell.setCellStyle(cs);
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

	public ParseDocXML getParse() {
		return parse;
	}
	
	
}
