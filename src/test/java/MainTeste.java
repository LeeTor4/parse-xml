import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.leetor4.handler.ParseDocXML;
import com.leetor4.model.nfe.DocumentoFiscalEltronico;
import com.leetor4.model.nfe.Produtos;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det;
import com.leetor4.portalfiscal.inf.br.nfe.TNfeProc;

public class MainTeste {

	public static void main(String[] args) throws JAXBException, IOException {
		
		String ano = "2015";
		String emp = "SELLENE";
		String estab = "MATRIZ";
		String cnpj  = "05329222000176";
		
		String anomes1  = ano.concat("01").concat(".txt");
		
		Path xP1 = Paths.get("E:\\EMPRESAS".concat("\\").concat(emp).concat("\\").concat(estab).concat("\\SPED").concat("\\").concat(ano).concat("\\XML").concat("\\").concat("Proprios").concat("\\").concat("\\jan"));
        Path xT1 = Paths.get("E:\\EMPRESAS".concat("\\").concat(emp).concat("\\").concat(estab).concat("\\SPED").concat("\\").concat(ano).concat("\\XML").concat("\\").concat("Terceiros").concat("\\").concat("\\jan"));
	    Path p1  = Paths.get("E:\\EMPRESAS".concat("\\").concat(emp).concat("\\").concat(estab).concat("\\SPED").concat("\\").concat(ano).concat("\\").concat(anomes1));
		
		
		File diretorio = xP1.toFile();
		File[] arquivos = diretorio.listFiles();
		JAXBContext contexto = JAXBContext.newInstance("com.leetor4.portalfiscal.inf.br.nfe");
		Unmarshaller leituraXML = contexto.createUnmarshaller();
		
//		for (File arquivo : arquivos) {
//			TNFe    nfe4 = leituraXML.unmarshal(new StreamSource(arquivo), TNFe.class).getValue();
//			
//			TNfeProc nfe = leituraXML.unmarshal(new StreamSource(arquivo), TNfeProc.class).getValue();
//			
//			if(nfe.getNFe() != null) {
//				
//				 System.out.println("1|"+ nfe.getNFe().getInfNFe().getIde().getNNF() + "|" + nfe.getNFe().getInfNFe().getIde().getDhEmi()
//						 +"|"+ nfe.getNFe().getInfNFe().getIde().getDEmi());
//				 
//			}else if(nfe4.getInfNFe() != null) {
//				
////				 System.out.println("2|"+nfe4.getInfNFe().getIde().getNNF()+"|"+nfe4.getInfNFe().getIde().getDhEmi()
////						 +"|"+nfe4.getInfNFe().getIde().getDEmi());
//			
//			     for(Det det : nfe4.getInfNFe().getDet()){
//			    	 System.out.println(det.getNItem());
//			     }
//
//			}
//		   
////			File xmlFile = new File(arquivo.toString());
////			BufferedReader br = new BufferedReader(new FileReader(xmlFile));
////			String line = null;
////			while ((line = br.readLine()) != null) {
////				
////				if (line.contains("versao=\"3.00\"") || line.contains("versao=\"2.00\"")) {
////			           System.out.println(line);		
////				}
////			}
//		
//		}
		
//		String versao = "versao=\"3.10\"";
//		System.out.println(versao);
		
		
		ParseDocXML parse = new ParseDocXML();
		
		List<DocumentoFiscalEltronico> validaTipoDeParseNFE = parse.validaTipoDeParseNFE(diretorio);
		
		for(DocumentoFiscalEltronico doc : validaTipoDeParseNFE){

			for(Produtos p : doc.getProds()){
				System.out.println(doc.getIdent().getNumDoc()+"|"+doc.getIdent().getSerie()+"|"+doc.getIdent().getDataEmissao()	+"|"+ doc.getIdent().getSerie()
						+"|"+ p.getCodItem()+"|"+ p.getNumItem());
			}

		}
		
 
	}

}
