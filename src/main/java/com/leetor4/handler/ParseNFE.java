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

import com.leetor4.model.nfe.CstIcms;
import com.leetor4.model.nfe.Emitente;
import com.leetor4.model.nfe.GrupoIcms;
import com.leetor4.model.nfe.ICMSPartilha;
import com.leetor4.model.nfe.Icms;
import com.leetor4.model.nfe.Icms00;
import com.leetor4.model.nfe.Icms10;
import com.leetor4.model.nfe.Icms20;
import com.leetor4.model.nfe.Icms30;
import com.leetor4.model.nfe.Icms40_41_50;
import com.leetor4.model.nfe.Icms51;
import com.leetor4.model.nfe.Icms60;
import com.leetor4.model.nfe.Icms70;
import com.leetor4.model.nfe.Icms90;
import com.leetor4.model.nfe.IcmsCSOSN101;
import com.leetor4.model.nfe.IcmsCSOSN102_103_300_400;
import com.leetor4.model.nfe.IcmsCSOSN201;
import com.leetor4.model.nfe.IcmsCSOSN202_203;
import com.leetor4.model.nfe.IcmsCSOSN500;
import com.leetor4.model.nfe.IcmsCSOSN900;
import com.leetor4.model.nfe.IcmsSt;
import com.leetor4.model.nfe.Identificacao;
import com.leetor4.model.nfe.ImpostoNFE;
import com.leetor4.model.nfe.NotaFiscal;
import com.leetor4.model.nfe.Produtos;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det;
import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det.Imposto.ICMS;
import com.leetor4.portalfiscal.inf.br.nfe.TNfeProc;

public class ParseNFE {

	private static final String GRP_ICMS00 = "ICMS00";
	private static final String GRP_ICMS10 = "ICMS10";
	private static final String GRP_ICMS20 = "ICMS20";
	private static final String GRP_ICMS30 = "ICMS30";
	private static final String GRP_ICMS40 = "ICMS40";
	private static final String GRP_ICMS41 = "ICMS41";
	private static final String GRP_ICMS50 = "ICMS50";
	private static final String GRP_ICMS51 = "ICMS51";
	private static final String GRP_ICMS60 = "ICMS60";
	private static final String GRP_ICMS70 = "ICMS70";
	private static final String GRP_ICMS90 = "ICMS90";
	private static final String GRP_ICMSPART = "ICMSPART";
	private static final String GRP_ICMSST = "ICMSST";

	private static final String GRP_ICMSSN101 = "ICMSSN101";
	private static final String GRP_ICMSSN102 = "ICMSSN102";
	private static final String GRP_ICMSSN103 = "ICMSSN103";
	private static final String GRP_ICMSSN201 = "ICMSSN201";
	private static final String GRP_ICMSSN202 = "ICMSSN202";
	private static final String GRP_ICMSSN203 = "ICMSSN203";
	private static final String GRP_ICMSSN300 = "ICMSSN300";
	private static final String GRP_ICMSSN400 = "ICMSSN400";
	private static final String GRP_ICMSSN500 = "ICMSSN500";
	private static final String GRP_ICMSSN900 = "ICMSSN900";

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

			nf.setIdent(ident);
			nf.setEmitente(emit);

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

				Field[] fields = icms.getClass().getDeclaredFields();
				for (Field field : fields) {

						Icms   grp_icms   = impostoICMS(field.getName(), det,imp);
						
						

						if(!grp_icms.getCstA().isBlank()) {
							prod.setOrig(grp_icms.getCstA());
						}
						if(!grp_icms.getCstB().isBlank()) {
							prod.setCst(grp_icms.getCstB());						
						}
						
						prod.getImps().setIcms(grp_icms);
				}

				nf.adicionarProdutos(prod);

			}

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

			nf.setIdent(ident);
			nf.setEmitente(emit);

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
		
					
					Icms   grp_icms   = impostoICMS(field.getName(), det,imp);

					if(!grp_icms.getCstA().isBlank()) {
						prod.setOrig(grp_icms.getCstA());
					}
					if(!grp_icms.getCstB().isBlank()) {
						prod.setCst(grp_icms.getCstB());						
					}
					
					prod.getImps().setIcms(grp_icms);
				}
                
				
				
				nf.adicionarProdutos(prod);
               
			}

			notas.add(nf);
		}
	}

	public List<NotaFiscal> filtrarNotasFiscais(File diretorio, Path destino, String cnpj, String codItem, String orig, String cst,
			String numDoc) throws IOException, JAXBException {
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

	private Icms impostoICMS(String name, Det det,ImpostoNFE imp) {

		Icms tipo = null;
		switch (name.toUpperCase()) {
		case GRP_ICMS00:
			GrupoIcms g1 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj1 = g1.pegarGrupoIcms();
			tipo = getIcms00(det, obj1);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS10:
			GrupoIcms g2 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj2 = g2.pegarGrupoIcms();
			tipo = getIcms10(det, obj2);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS20:
			GrupoIcms g3 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj3 = g3.pegarGrupoIcms();
			tipo = getIcms20(det, obj3);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS30:
			GrupoIcms g4 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj4 = g4.pegarGrupoIcms();
			tipo = getIcms30(det, obj4);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS40:
			GrupoIcms g5 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj5 = g5.pegarGrupoIcms();
			tipo = getIcms40_41_50(det, obj5);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS41:
			GrupoIcms g6 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj6 = g6.pegarGrupoIcms();
			tipo = getIcms40_41_50(det, obj6);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS50:
			GrupoIcms g7 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj7 = g7.pegarGrupoIcms();
			tipo = getIcms40_41_50(det, obj7);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS51:
			GrupoIcms g8 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj8 = g8.pegarGrupoIcms();
			tipo = getIcms51(det, obj8);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS60:
			GrupoIcms g9 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj9 = g9.pegarGrupoIcms();
			tipo = getIcms60(det, obj9);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS70:
			GrupoIcms g10 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj10 = g10.pegarGrupoIcms();
			tipo = getIcms70(det, obj10);
			imp.setIcms(tipo);
			break;
		case GRP_ICMS90:
			GrupoIcms g11 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj11 = g11.pegarGrupoIcms();
			tipo = getIcms90(det, obj11);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSPART:
			GrupoIcms g12 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj12 = g12.pegarGrupoIcms();
			tipo = getIcmsPartilha(det, obj12);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSST:
			GrupoIcms g13 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj13 = g13.pegarGrupoIcms();
			tipo = getIcmsSt(det, obj13);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN101:
			GrupoIcms g14 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj14 = g14.pegarGrupoIcms();
			tipo = getIcmsSN101(det, obj14);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN102:
			GrupoIcms g15 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj15 = g15.pegarGrupoIcms();
			tipo = getIcmsSN102_103_300_400(det, obj15);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN103:
			GrupoIcms g16 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj16 = g16.pegarGrupoIcms();
			tipo = getIcmsSN102_103_300_400(det, obj16);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN201:
			GrupoIcms g17 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj17 = g17.pegarGrupoIcms();
			tipo = getIcmsSN201(det, obj17);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN202:
			GrupoIcms g18 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj18 = g18.pegarGrupoIcms();
			tipo = getIcmsSN202_203(det, obj18);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN203:
			GrupoIcms g19 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj19 = g19.pegarGrupoIcms();
			tipo = getIcmsSN202_203(det, obj19);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN300:
			GrupoIcms g20 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj20 = g20.pegarGrupoIcms();
			tipo = getIcmsSN102_103_300_400(det, obj20);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN400:
			GrupoIcms g21 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj21 = g21.pegarGrupoIcms();
			tipo = getIcmsSN102_103_300_400(det, obj21);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN500:
			GrupoIcms g22 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj22 = g22.pegarGrupoIcms();
			tipo = getIcmsSN500(det, obj22);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN900:
			GrupoIcms g23 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj23 = g23.pegarGrupoIcms();
			tipo = getIcmsSN900(det, obj23);
			imp.setIcms(tipo);
			break;
		}

		return tipo;
	}

	private Icms getIcms00(Det det, Object obj1) {
		Icms00 grupo00 = (Icms00) obj1;
		CstIcms cstIcms = getCstIcms00(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcms00(grupo00);
		return tipo;
	}

	private Icms getIcms10(Det det, Object obj2) {
		Icms10 grupo10 = (Icms10) obj2;
		CstIcms cstIcms = getCstIcms10(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcms10(grupo10);
		return tipo;
	}

	private Icms getIcms20(Det det, Object obj3) {
		Icms20 grupo20 = (Icms20) obj3;
		CstIcms cstIcms = getCstIcms20(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcms20(grupo20);
		return tipo;
	}

	private Icms getIcms30(Det det, Object obj4) {
		Icms30 grupo30 = (Icms30) obj4;
		CstIcms cstIcms = getCstIcms30(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcms30(grupo30);
		return tipo;
	}

	private Icms getIcms40_41_50(Det det, Object obj5) {
		Icms40_41_50 grupo40_41_50 = (Icms40_41_50) obj5;
		CstIcms cstIcms = getCstIcms40(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcms40_41_50(grupo40_41_50);
		return tipo;
	}

	private Icms getIcms51(Det det, Object obj6) {
		Icms51 grupo51 = (Icms51) obj6;
		CstIcms cstIcms = getCstIcms51(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcms51(grupo51);
		return tipo;
	}

	private Icms getIcms60(Det det, Object obj7) {
		Icms60 grupo60 = (Icms60) obj7;
		CstIcms cstIcms = getCstIcms60(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcms60(grupo60);
		return tipo;
	}

	private Icms getIcms70(Det det, Object obj8) {
		Icms70 grupo70 = (Icms70) obj8;
		CstIcms cstIcms = getCstIcms70(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcms70(grupo70);
		return tipo;
	}

	private Icms getIcms90(Det det, Object obj9) {
		Icms90 grupo90 = (Icms90) obj9;
		CstIcms cstIcms = getCstIcms90(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcms90(grupo90);
		return tipo;
	}

	private Icms getIcmsPartilha(Det det, Object obj10) {
		ICMSPartilha grupoPartilha = (ICMSPartilha) obj10;
		CstIcms cstIcms = getCstIcmsPart(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcmsPartilha(grupoPartilha);
		return tipo;
	}

	private Icms getIcmsSt(Det det, Object obj10) {
		IcmsSt grupoIcmsSt = (IcmsSt) obj10;
		CstIcms cstIcms = getCstIcmsSt(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcmsSt(grupoIcmsSt);
		return tipo;
	}

	private Icms getIcmsSN101(Det det, Object obj11) {
		IcmsCSOSN101 grupoSN = (IcmsCSOSN101) obj11;
		CstIcms cstIcms = getCstIcmsSN101(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcmsCSOSN101(grupoSN);
		return tipo;
	}

	// verificar o comportamento desse metodo
	private Icms getIcmsSN102_103_300_400(Det det, Object obj12) {
		IcmsCSOSN102_103_300_400 grupoSN = (IcmsCSOSN102_103_300_400) obj12;
		CstIcms cstIcms = getCstIcmsSN102_103_300_400(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcmsCSOSN102_103_300_400(grupoSN);
		return tipo;
	}

	private Icms getIcmsSN201(Det det, Object obj13) {
		IcmsCSOSN201 grupoSN = (IcmsCSOSN201) obj13;
		CstIcms cstIcms = getCstIcmsSN201(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcmsCSOSN201(grupoSN);
		return tipo;
	}

	private Icms getIcmsSN202_203(Det det, Object obj14) {
		IcmsCSOSN202_203 grupoSN = (IcmsCSOSN202_203) obj14;
		CstIcms cstIcms = getCstIcmsSN202_203(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcmsCSOSN102_203(grupoSN);
		return tipo;
	}

	private Icms getIcmsSN500(Det det, Object obj15) {
		IcmsCSOSN500 grupoSN = (IcmsCSOSN500) obj15;
		CstIcms cstIcms = getCstIcmsSN500(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcmsCSOSN500(grupoSN);
		return tipo;
	}

	private Icms getIcmsSN900(Det det, Object obj16) {
		IcmsCSOSN900 grupoSN = (IcmsCSOSN900) obj16;
		CstIcms cstIcms = getCstIcmsSN900(det);
		Icms tipo = new Icms(cstIcms.getCstA(), cstIcms.getCstB());
		tipo.setIcmsCSOSN900(grupoSN);
		return tipo;
	}

	private CstIcms getCstIcms00(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS00() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS00().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS00().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcms10(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS10() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS10().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS10().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcms20(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS20() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS20().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS20().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcms30(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS30() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS30().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS30().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcms40(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS40() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS40().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS40().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcms51(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS51() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS51().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS51().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcms60(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS60() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS60().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS60().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcms70(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS70() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS70().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS70().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcms90(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS90() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS90().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS90().getCST());
			
		}
		return cst;
	}

	private CstIcms getCstIcmsPart(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSPart() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSPart().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMSPart().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcmsSt(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSST() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSST().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMSST().getCST());
		}
		return cst;
	}

	private CstIcms getCstIcmsSN101(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSSN101() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSSN101().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMSSN101().getCSOSN());
		}
		return cst;
	}

	private CstIcms getCstIcmsSN102_103_300_400(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSSN102() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSSN102().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMSSN102().getCSOSN());
		}
		return cst;
	}

	private CstIcms getCstIcmsSN201(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSSN201() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSSN201().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMSSN201().getCSOSN());
		}
		return cst;
	}

	private CstIcms getCstIcmsSN202_203(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSSN202() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSSN202().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMSSN202().getCSOSN());
		}
		return cst;
	}

	private CstIcms getCstIcmsSN500(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSSN500() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSSN500().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMSSN500().getCSOSN());
		}
		return cst;
	}

	private CstIcms getCstIcmsSN900(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSSN900() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSSN900().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMSSN900().getCSOSN());
		}
		return cst;
	}
}
