package com.leetor4.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.leetor4.model.nfe.Cofins;
import com.leetor4.model.nfe.ContribuicaoCofins;
import com.leetor4.model.nfe.ContribuicaoPis;
import com.leetor4.model.nfe.Destinatario;
import com.leetor4.model.nfe.Emitente;
import com.leetor4.model.nfe.Icms;
import com.leetor4.model.nfe.Identificacao;
import com.leetor4.model.nfe.ImpostoICMS;
import com.leetor4.model.nfe.ImpostoNFE;
import com.leetor4.model.nfe.NotaFiscal;
import com.leetor4.model.nfe.Pis;
import com.leetor4.model.nfe.Produtos;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det.Imposto.COFINS;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det.Imposto.ICMS;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det.Imposto.PIS;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det.Prod.Rastro;
import com.leetor4.portalfiscal.inf.br.nfe.TNfeProc;

public class ParseNFE {

	private ImpostoICMS              impICMS = new ImpostoICMS();
	private ContribuicaoPis       contribPis = new ContribuicaoPis();
	private ContribuicaoCofins contribCofins = new ContribuicaoCofins();

	public List<NotaFiscal> validaTipoDeParseNFE(File diretorio) throws IOException, JAXBException {
		List<NotaFiscal> notas = new ArrayList<NotaFiscal>();
		File[] arquivos = diretorio.listFiles();
		JAXBContext contexto = JAXBContext.newInstance("com.leetor4.portalfiscal.inf.br.nfe");
		Unmarshaller leituraXML = contexto.createUnmarshaller();
		for (File arquivo : arquivos) {
			File xmlFile = new File(arquivo.toString());
			BufferedReader br = new BufferedReader(new FileReader(xmlFile));
			String line = null;
			while ((line = br.readLine()) != null) {

				// if (line.contains("<Signature")) {}
				if (line.contains("<nfeProc")) {
					parseNFeV3_10(notas, arquivo, leituraXML);
				} else if (line.contains("<NFe")) {
					parseNFeV4_00(notas, arquivo, leituraXML);
				} else {
					System.out.println(line);
				}

			}
			br.close();

		}

		return notas;
	}

	private void parseNFeV3_10(List<NotaFiscal> notas, File arquivo, Unmarshaller leituraXML) throws JAXBException {

		// sb.append(LocalDate.parse(nfe.getIde().getDhEmi(),
		// DateTimeFormatter.ISO_OFFSET_DATE_TIME));

		TNfeProc nfe = leituraXML.unmarshal(new StreamSource(arquivo), TNfeProc.class).getValue();

		NotaFiscal nf = new NotaFiscal();
		Identificacao ident = new Identificacao();
		if (nfe.getNFe().getInfNFe() != null) {
			ident.setChaveeletronica(nfe.getNFe().getInfNFe().getId().substring(3));
			ident.setChaveeletronica(nfe.getNFe().getInfNFe().getId().substring(3));
			ident.setCodigoUF(nfe.getNFe().getInfNFe().getIde().getCUF());
			ident.setCodigoNF(nfe.getNFe().getInfNFe().getIde().getCNF());
			ident.setNaturezaOperacao(nfe.getNFe().getInfNFe().getIde().getNatOp());
			ident.setModeloDoc(nfe.getNFe().getInfNFe().getIde().getMod());
			ident.setSerie(nfe.getNFe().getInfNFe().getIde().getSerie());
			ident.setNumDoc(nfe.getNFe().getInfNFe().getIde().getNNF());
			ident.setDataEmissao(nfe.getNFe().getInfNFe().getIde().getDhEmi());
			ident.setDataEntSai(nfe.getNFe().getInfNFe().getIde().getDhSaiEnt());
			ident.setTipoNF(nfe.getNFe().getInfNFe().getIde().getTpNF());
			ident.setIdDest(nfe.getNFe().getInfNFe().getIde().getIdDest());
			ident.setCodigoMunFG(nfe.getNFe().getInfNFe().getIde().getCMunFG());
			ident.setTipoImp(nfe.getNFe().getInfNFe().getIde().getTpImp());
			ident.setTipoEmissao(nfe.getNFe().getInfNFe().getIde().getTpEmis());
			ident.setDigVerifChaveAcesso(nfe.getNFe().getInfNFe().getIde().getCDV());
			ident.setTipoAmbiente(nfe.getNFe().getInfNFe().getIde().getTpAmb());
			ident.setFinalidadeEmissao(nfe.getNFe().getInfNFe().getIde().getFinNFe());
			ident.setProcessoEmissao(nfe.getNFe().getInfNFe().getIde().getProcEmi());
			ident.setVersaoProcesso(nfe.getNFe().getInfNFe().getIde().getVerProc());

			Emitente emit = new Emitente();

			emit.setCnpj(nfe.getNFe().getInfNFe().getEmit().getCNPJ());
			emit.setNome(nfe.getNFe().getInfNFe().getEmit().getXNome());

			Destinatario dest = new Destinatario();

			dest.setCnpj(nfe.getNFe().getInfNFe().getDest().getCNPJ());
			dest.setNome(nfe.getNFe().getInfNFe().getDest().getXNome());
			dest.setIe(nfe.getNFe().getInfNFe().getDest().getIE());

			nf.setIdent(ident);
			nf.setEmitente(emit);
			nf.setDestinatario(dest);

			for (Det det : nfe.getNFe().getInfNFe().getDet()) {
				Produtos prod = new Produtos();
				ImpostoNFE imp = new ImpostoNFE();

				prod.setNumItem(det.getNItem());
				prod.setCodItem(det.getProd().getCProd());
				prod.setEan(det.getProd().getCEAN());
				prod.setDescricao(det.getProd().getXProd());
				prod.setNcm(det.getProd().getNCM());
				prod.setCfop(det.getProd().getCFOP());
				prod.setUndComercial(det.getProd().getUCom());
				prod.setQtdComercial(det.getProd().getQCom());
				prod.setVlUnComerial(det.getProd().getVUnCom());
				prod.setVlProduto(det.getProd().getVProd());
				prod.setCodEanTrib(det.getProd().getCEANTrib());
				prod.setUndTrib(det.getProd().getVUnTrib());
				prod.setQtdTrib(det.getProd().getQTrib());
				prod.setVlUnTrib(det.getProd().getVUnTrib());
				prod.setIndTot(det.getProd().getIndTot());

				ICMS icms = det.getImposto().getIcms();
				Field[] fieldsICMS = icms.getClass().getDeclaredFields();
				for (Field field : fieldsICMS) {

					Icms grp_icms = impICMS.impostoICMS(field.getName(), det, imp);
					if (!grp_icms.getCstA().isBlank()) {
						prod.setOrig(grp_icms.getCstA());
					}
					if (!grp_icms.getCstB().isBlank()) {
						prod.setCst(grp_icms.getCstB());
					}

					prod.getImps().setIcms(grp_icms);
				}
				PIS pis = det.getImposto().getPis();
				Field[] fieldsPIS = pis.getClass().getDeclaredFields();
				for (Field field : fieldsPIS) {

					Pis grp_pis = contribPis.contribuicaoPis(field.getName(), det, imp);
					if (!grp_pis.getCst().isBlank()) {
						prod.setOrig(grp_pis.getCst());
					}

					prod.getImps().setPis(grp_pis);
				}
				for (Rastro rastro : det.getProd().getRastro()) {

					prod.getRastro().setNumLote(rastro.getNLote());
					prod.getRastro().setQtdLote(rastro.getQLote());
					prod.getRastro().setDtFab(rastro.getDFab());
					prod.getRastro().setDtVal(rastro.getDVal());

				}

				nf.adicionarProdutos(prod);
			}

			nf.getTotal().getIcmsTot().setVlBc(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVBC());
			nf.getTotal().getIcmsTot().setVlIcms(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVICMS());
			nf.getTotal().getIcmsTot().setVlIcmsDeson(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVICMSDeson());
			nf.getTotal().getIcmsTot().setVlFCP(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVFCP());
			nf.getTotal().getIcmsTot().setVlBCST(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVBCST());
			nf.getTotal().getIcmsTot().setVlST(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVST());
			nf.getTotal().getIcmsTot().setVlFCPST(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVFCPST());
			nf.getTotal().getIcmsTot().setVlFCPSTRet(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVFCPSTRet());
			nf.getTotal().getIcmsTot().setVlProd(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVProd());
			nf.getTotal().getIcmsTot().setVlFrete(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVFrete());
			nf.getTotal().getIcmsTot().setVlSeg(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVSeg());
			nf.getTotal().getIcmsTot().setVlDesc(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVDesc());
			nf.getTotal().getIcmsTot().setVlII(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVII());
			nf.getTotal().getIcmsTot().setVlIPIDevol(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVIPIDevol());
			nf.getTotal().getIcmsTot().setVlPIS(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVPIS());
			nf.getTotal().getIcmsTot().setVlCOFINS(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVCOFINS());
			nf.getTotal().getIcmsTot().setVlOutro(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVOutro());
			nf.getTotal().getIcmsTot().setVlNF(nfe.getNFe().getInfNFe().getTotal().getICMSTot().getVNF());
			notas.add(nf);
		}
	}

	private void parseNFeV4_00(List<NotaFiscal> notas, File arquivo, Unmarshaller leituraXML) throws JAXBException {

		TNFe nfe = leituraXML.unmarshal(new StreamSource(arquivo), TNFe.class).getValue();

		NotaFiscal nf = new NotaFiscal();
		Identificacao ident = new Identificacao();

		if (nfe.getInfNFe() != null) {
			ident.setChaveeletronica(nfe.getInfNFe().getId().substring(3));

			ident.setCodigoUF(nfe.getInfNFe().getIde().getCUF());
			ident.setCodigoNF(nfe.getInfNFe().getIde().getCNF());
			ident.setNaturezaOperacao(nfe.getInfNFe().getIde().getNatOp());
			ident.setModeloDoc(nfe.getInfNFe().getIde().getMod());
			ident.setSerie(nfe.getInfNFe().getIde().getSerie());
			ident.setNumDoc(nfe.getInfNFe().getIde().getNNF());
			ident.setDataEmissao(nfe.getInfNFe().getIde().getDhEmi());
			ident.setDataEntSai(nfe.getInfNFe().getIde().getDhSaiEnt());
			ident.setTipoNF(nfe.getInfNFe().getIde().getTpNF());
			ident.setIdDest(nfe.getInfNFe().getIde().getIdDest());
			ident.setCodigoMunFG(nfe.getInfNFe().getIde().getCMunFG());
			ident.setTipoImp(nfe.getInfNFe().getIde().getTpImp());
			ident.setTipoEmissao(nfe.getInfNFe().getIde().getTpEmis());
			ident.setDigVerifChaveAcesso(nfe.getInfNFe().getIde().getCDV());
			ident.setTipoAmbiente(nfe.getInfNFe().getIde().getTpAmb());
			ident.setFinalidadeEmissao(nfe.getInfNFe().getIde().getFinNFe());
			ident.setProcessoEmissao(nfe.getInfNFe().getIde().getProcEmi());
			ident.setVersaoProcesso(nfe.getInfNFe().getIde().getVerProc());

			Emitente emit = new Emitente();

			emit.setCnpj(nfe.getInfNFe().getEmit().getCNPJ());
			emit.setNome(nfe.getInfNFe().getEmit().getXNome());

			Destinatario dest = new Destinatario();

			dest.setCnpj(nfe.getInfNFe().getDest().getCNPJ());
			dest.setNome(nfe.getInfNFe().getDest().getXNome());
			dest.setIe(nfe.getInfNFe().getDest().getIE());

			nf.setIdent(ident);
			nf.setEmitente(emit);
			nf.setDestinatario(dest);

			for (Det det : nfe.getInfNFe().getDet()) {
				Produtos prod = new Produtos();
				ImpostoNFE imp = new ImpostoNFE();
				prod.setNumItem(det.getNItem());
				prod.setCodItem(det.getProd().getCProd());
				prod.setEan(det.getProd().getCEAN());
				prod.setDescricao(det.getProd().getXProd());
				prod.setNcm(det.getProd().getNCM());
				prod.setCfop(det.getProd().getCFOP());
				prod.setUndComercial(det.getProd().getUCom());
				prod.setQtdComercial(det.getProd().getQCom());
				prod.setVlUnComerial(det.getProd().getVUnCom());
				prod.setVlProduto(det.getProd().getVProd());
				prod.setCodEanTrib(det.getProd().getCEANTrib());
				prod.setUndTrib(det.getProd().getVUnTrib());
				prod.setQtdTrib(det.getProd().getQTrib());
				prod.setVlUnTrib(det.getProd().getVUnTrib());
				prod.setIndTot(det.getProd().getIndTot());

				ICMS icms = det.getImposto().getIcms();
				Field[] fields = icms.getClass().getDeclaredFields();
				for (Field field : fields) {

					Icms grp_icms = impICMS.impostoICMS(field.getName(), det, imp);

					if (!grp_icms.getCstA().isBlank()) {
						prod.setOrig(grp_icms.getCstA());
					}
					if (!grp_icms.getCstB().isBlank()) {
						prod.setCst(grp_icms.getCstB());
					}

					prod.getImps().setIcms(grp_icms);

				}
				PIS pis = det.getImposto().getPis();
				Field[] fieldsPIS = pis.getClass().getDeclaredFields();
				for (Field field : fieldsPIS) {

					Pis grp_pis = contribPis.contribuicaoPis(field.getName(), det, imp);
					if (!grp_pis.getCst().isBlank()) {
						prod.setCstPis(grp_pis.getCst());
					}

					prod.getImps().setPis(grp_pis);
				}
				
				
				
				COFINS cofins = det.getImposto().getCofins();
				Field[] fieldsCofins = cofins.getClass().getDeclaredFields();
				for (Field field : fieldsCofins) {
					
				   Cofins grp_cofins = contribCofins.contribuicaoPis(field.getName(), det, imp);
				   if(!grp_cofins.getCst().isBlank()) {
					   prod.setCstCofins(grp_cofins.getCst());
				   }
				   
				   prod.getImps().setCofins(grp_cofins);
				}
				
				for (Rastro rastro : det.getProd().getRastro()) {

					prod.getRastro().setNumLote(rastro.getNLote());
					prod.getRastro().setQtdLote((rastro.getQLote()));
					prod.getRastro().setDtFab(rastro.getDFab());
					prod.getRastro().setDtVal(rastro.getDVal());

				}

				nf.adicionarProdutos(prod);

			}
			nf.getTotal().getIcmsTot().setVlBc(nfe.getInfNFe().getTotal().getICMSTot().getVBC());
			nf.getTotal().getIcmsTot().setVlIcms(nfe.getInfNFe().getTotal().getICMSTot().getVICMS());
			nf.getTotal().getIcmsTot().setVlIcmsDeson(nfe.getInfNFe().getTotal().getICMSTot().getVICMSDeson());
			nf.getTotal().getIcmsTot().setVlFCP(nfe.getInfNFe().getTotal().getICMSTot().getVFCP());
			nf.getTotal().getIcmsTot().setVlBCST(nfe.getInfNFe().getTotal().getICMSTot().getVBCST());
			nf.getTotal().getIcmsTot().setVlST(nfe.getInfNFe().getTotal().getICMSTot().getVST());
			nf.getTotal().getIcmsTot().setVlFCPST(nfe.getInfNFe().getTotal().getICMSTot().getVFCPST());
			nf.getTotal().getIcmsTot().setVlFCPSTRet(nfe.getInfNFe().getTotal().getICMSTot().getVFCPSTRet());
			nf.getTotal().getIcmsTot().setVlProd(nfe.getInfNFe().getTotal().getICMSTot().getVProd());
			nf.getTotal().getIcmsTot().setVlFrete(nfe.getInfNFe().getTotal().getICMSTot().getVFrete());
			nf.getTotal().getIcmsTot().setVlSeg(nfe.getInfNFe().getTotal().getICMSTot().getVSeg());
			nf.getTotal().getIcmsTot().setVlDesc(nfe.getInfNFe().getTotal().getICMSTot().getVDesc());
			nf.getTotal().getIcmsTot().setVlII(nfe.getInfNFe().getTotal().getICMSTot().getVII());
			nf.getTotal().getIcmsTot().setVlIPIDevol(nfe.getInfNFe().getTotal().getICMSTot().getVIPIDevol());
			nf.getTotal().getIcmsTot().setVlPIS(nfe.getInfNFe().getTotal().getICMSTot().getVPIS());
			nf.getTotal().getIcmsTot().setVlCOFINS(nfe.getInfNFe().getTotal().getICMSTot().getVCOFINS());
			nf.getTotal().getIcmsTot().setVlOutro(nfe.getInfNFe().getTotal().getICMSTot().getVOutro());
			nf.getTotal().getIcmsTot().setVlNF(nfe.getInfNFe().getTotal().getICMSTot().getVNF());
			notas.add(nf);
		}
	}

	public List<NotaFiscal> filtrarNotasFiscais(File diretorio, Path destino, String cnpj, String codItem, String orig,
			String cst, String numDoc) throws IOException, JAXBException {
		List<NotaFiscal> notas = new ArrayList<NotaFiscal>();
		File[] arquivos = diretorio.listFiles();

		for (File arquivo : arquivos) {
			File xmlFile = new File(arquivo.toString());
			BufferedReader br = new BufferedReader(new FileReader(xmlFile));
			String line = null;
			while ((line = br.readLine()) != null) {

				if (line.contains("<CNPJ>".concat(cnpj).concat("</CNPJ>"))
						|| line.contains("<cProd>".concat(codItem).concat("</cProd>"))
						|| line.contains("<orig>".concat(orig).concat("</orig>"))
						|| line.contains("<CST>".concat(cst).concat("</CST>"))
						|| line.contains("<nNF>".concat(numDoc).concat("</nNF>"))) {

					Path pOrig = Paths.get(xmlFile.getPath());
					Path pDest = Paths.get(destino.toString().concat("\\").concat(xmlFile.getName()));

					Files.copy(pOrig, pDest, StandardCopyOption.REPLACE_EXISTING);

					System.out.println("Arquivo movido com sucesso!!!");
				}
			}
			br.close();

		}

		return notas;
	}

}
