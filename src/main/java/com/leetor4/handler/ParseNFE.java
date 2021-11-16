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
import java.time.LocalDate;
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
import com.leetor4.model.nfe.Icms00;
import com.leetor4.model.nfe.Icms10;
import com.leetor4.model.nfe.Icms20;
import com.leetor4.model.nfe.Icms40_41_50;
import com.leetor4.model.nfe.Icms60;
import com.leetor4.model.nfe.Icms70;
import com.leetor4.model.nfe.Icms90;
import com.leetor4.model.nfe.IcmsCSOSN101;
import com.leetor4.model.nfe.IcmsCSOSN102_103_300_400;
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
import com.leetor4.util.UtilsEConverters;

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
					System.out.println("Não Importada");
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
			ident.setCodigoUF(nfe.getNFe().getInfNFe().getIde().getCUF());
			ident.setCodigoNF(nfe.getNFe().getInfNFe().getIde().getCNF());
			ident.setNaturezaOperacao(nfe.getNFe().getInfNFe().getIde().getNatOp());
			ident.setModeloDoc(nfe.getNFe().getInfNFe().getIde().getMod());
			ident.setSerie(nfe.getNFe().getInfNFe().getIde().getSerie());
			ident.setNumDoc(nfe.getNFe().getInfNFe().getIde().getNNF());
			
			//Tag ajustada na classe TNFe , pois é da versão 2.00
			if(nfe.getNFe().getInfNFe().getIde().getDhEmi() != null) {
				ident.setDataEmissao(nfe.getNFe().getInfNFe().getIde().getDhEmi());
			}else if(nfe.getNFe().getInfNFe().getIde().getDEmi() != null) {
				ident.setDataEmissao(nfe.getNFe().getInfNFe().getIde().getDEmi());
			}
			
            if(nfe.getNFe().getInfNFe().getIde().getDhSaiEnt() != null) {
            	ident.setDataEntSai(nfe.getNFe().getInfNFe().getIde().getDhSaiEnt());
            }else if(nfe.getNFe().getInfNFe().getIde().getDSaiEnt() != null) {
            	ident.setDataEntSai(nfe.getNFe().getInfNFe().getIde().getDSaiEnt());
            	
            }
			
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

					 if(field.getName() != null) {
							
						    Icms00       addICMS00 = addICMS00(field, grp_icms);
							Icms10       addICMS10 = addICMS10(field, grp_icms);
							Icms40_41_50 addICMS40 = addICMS40(field, grp_icms);
							Icms60       addICMS60 = addICMS60(field, grp_icms);
							Icms70       addICMS70 = addICMS70(field, grp_icms);
							Icms90       addICMS90 = addICMS90(field, grp_icms);
							IcmsCSOSN102_103_300_400 addCSOSN102_103_300_40 = addCSOSN102_103_300_400(field, grp_icms);
							IcmsCSOSN101  addCSOSN101  = addCSOSN101(field, grp_icms);
							Icms20          addICMS20  = addICMS20(field, grp_icms);
							if(addICMS00.getCst().getCstA() != null && addICMS00.getCst().getCstB() != null) {
								prod.setOrig(addICMS00.getCst().getCstA());
								prod.setCst(addICMS00.getCst().getCstB());
								prod.setModBc(addICMS00.getModBC());
								prod.setVlBc(addICMS00.getvBC());
								prod.setAliqIcms(addICMS00.getAliqImp());
								prod.setVlIcms(addICMS00.getvICMS());
							}else if(addICMS10.getCst().getCstA() != null && addICMS10.getCst().getCstB() != null) {
								prod.setOrig(addICMS10.getCst().getCstA());
								prod.setCst(addICMS10.getCst().getCstB());
								prod.setModBc(addICMS10.getModBC());
								prod.setVlBc(addICMS10.getvBC());
								prod.setAliqIcms(addICMS10.getAliqImp());
								prod.setVlIcms(addICMS10.getvICMS());
							}else if(addICMS20.getCst().getCstA() != null && addICMS20.getCst().getCstB() != null) {
								prod.setOrig(addICMS20.getCst().getCstA());
								prod.setCst(addICMS20.getCst().getCstB());
								prod.setModBc(addICMS20.getModBC());
							
								
							}else if(addICMS90.getCst().getCstA() != null && addICMS90.getCst().getCstB() != null) {
								prod.setOrig(addICMS90.getCst().getCstA());
								prod.setCst(addICMS90.getCst().getCstB());
								prod.setModBc(addICMS90.getModBC());
								prod.setVlBc(addICMS90.getvBC());
								prod.setAliqIcms(addICMS90.getAliqICMS());
								prod.setVlIcms(addICMS90.getvICMS());
							}else if(addCSOSN101.getCst().getCstA() != null && 
									addCSOSN101.getCst().getCSOSN() != null) {
								prod.setOrig(addCSOSN101.getCst().getCstA());
								prod.setCst( addCSOSN101.getCst().getCSOSN());
								prod.setAliqCredSN(addCSOSN101.getAliqpCredSN());
								prod.setvCredICMSSN(addCSOSN101.getvCredICMSSN());
							}else if(addCSOSN102_103_300_40.getCst().getCstA() != null &&
									addCSOSN102_103_300_40.getCst().getCSOSN() != null) {
								prod.setOrig(addCSOSN102_103_300_40.getCst().getCstA());
								prod.setCst( addCSOSN102_103_300_40.getCst().getCSOSN());
							}
							
							
							if( addICMS40.getCst().getCstA() != null && addICMS40.getCst().getCstB() != null) {
								prod.setOrig( addICMS40.getCst().getCstA());
								prod.setCst( addICMS40.getCst().getCstB());
								prod.setVlIcms(addICMS40.getvICMS());
								prod.setMotDeso(addICMS40.getMotDesICMS());							
							}
							
							if( addICMS60.getCst().getCstA() != null && addICMS60.getCst().getCstB() != null) {
								prod.setOrig(addICMS60.getCst().getCstA());
								prod.setCst( addICMS60.getCst().getCstB());
								prod.setVlBcSTRet(addICMS60.getvBCSTRet());
								prod.setVlIcmsSTRet(addICMS60.getvICMSSTRet());
													
							}
							if( addICMS70.getCst().getCstA() != null && addICMS70.getCst().getCstB() != null) {
								prod.setOrig(addICMS70.getCst().getCstA());
								prod.setCst( addICMS70.getCst().getCstB());
								prod.setModBc(addICMS70.getModBC());
								prod.setAliqRedBc(addICMS70.getAliqRedBC());	
								prod.setVlBc(addICMS70.getvBC());
								prod.setAliqIcms(addICMS70.getAliqICMS());
								prod.setVlIcms(addICMS70.getvICMS());
								prod.setModBcST(addICMS70.getModBCST());
								prod.setAliqMVAST(addICMS70.getAliqMVAST());
								prod.setAliqRedBCST(addICMS70.getAliqRedBCST());
								prod.setVlBcST(addICMS70.getvBCST());								
								prod.setAliqIcmsST(addICMS70.getAliqICMSST());
								prod.setVlIcmsST(addICMS70.getvICMSST());
								prod.setVlIcmsDeson(addICMS70.getvICMSDeson());
								prod.setMotDesICMS(addICMS70.getMotDesICMS());
							}
							//System.out.println(field.getName() +"|" + addCSOSN102_103_300_40.getCst().getCSOSN());
					 }
				
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
				Field[] fieldsICMS = icms.getClass().getDeclaredFields();
				for (Field field : fieldsICMS) {
					Icms grp_icms = impICMS.impostoICMS(field.getName(), det, imp);

					
                     if(field.getName() != null) {
						
                    	    Icms00       addICMS00 = addICMS00(field, grp_icms);
							Icms10       addICMS10 = addICMS10(field, grp_icms);
							Icms40_41_50 addICMS40 = addICMS40(field, grp_icms);
							Icms60       addICMS60 = addICMS60(field, grp_icms);
							Icms70       addICMS70 = addICMS70(field, grp_icms);
							Icms90       addICMS90 = addICMS90(field, grp_icms);
							IcmsCSOSN102_103_300_400 addCSOSN102_103_300_40 = addCSOSN102_103_300_400(field, grp_icms);
							IcmsCSOSN101  addCSOSN101  = addCSOSN101(field, grp_icms);
							Icms20          addICMS20  = addICMS20(field, grp_icms);
							
							if(addICMS00.getCst().getCstA() != null && addICMS00.getCst().getCstB() != null) {
								prod.setOrig(addICMS00.getCst().getCstA());
								prod.setCst(addICMS00.getCst().getCstB());
								prod.setModBc(addICMS00.getModBC());
								prod.setVlBc(addICMS00.getvBC());
								prod.setAliqIcms(addICMS00.getAliqImp());
								prod.setVlIcms(addICMS00.getvICMS());
							}else if(addICMS10.getCst().getCstA() != null && addICMS10.getCst().getCstB() != null) {
								prod.setOrig(addICMS10.getCst().getCstA());
								prod.setCst(addICMS10.getCst().getCstB());
								prod.setModBc(addICMS10.getModBC());
								prod.setVlBc(addICMS10.getvBC());
								prod.setAliqIcms(addICMS10.getAliqImp());
								prod.setVlIcms(addICMS10.getvICMS());
							}else if(addICMS20.getCst().getCstA() != null && addICMS20.getCst().getCstB() != null) {
								prod.setOrig(addICMS20.getCst().getCstA());
								prod.setCst(addICMS20.getCst().getCstB());
								prod.setModBc(addICMS20.getModBC());
							
								
							}else if(addICMS90.getCst().getCstA() != null && addICMS90.getCst().getCstB() != null) {
								prod.setOrig(addICMS90.getCst().getCstA());
								prod.setCst(addICMS90.getCst().getCstB());
								prod.setModBc(addICMS90.getModBC());
								prod.setVlBc(addICMS90.getvBC());
								prod.setAliqIcms(addICMS90.getAliqICMS());
								prod.setVlIcms(addICMS90.getvICMS());
							}else if(addCSOSN101.getCst().getCstA() != null && 
									addCSOSN101.getCst().getCSOSN() != null) {
								prod.setOrig(addCSOSN101.getCst().getCstA());
								prod.setCst( addCSOSN101.getCst().getCSOSN());
							
								prod.setAliqCredSN(addCSOSN101.getAliqpCredSN());
								prod.setvCredICMSSN(addCSOSN101.getvCredICMSSN());		
								
							}else if(addCSOSN102_103_300_40.getCst().getCstA() != null &&
									addCSOSN102_103_300_40.getCst().getCSOSN() != null) {
								prod.setOrig(addCSOSN102_103_300_40.getCst().getCstA());
								prod.setCst( addCSOSN102_103_300_40.getCst().getCSOSN());
							}
						
							if( addICMS40.getCst().getCstA() != null && addICMS40.getCst().getCstB() != null) {
								prod.setOrig( addICMS40.getCst().getCstA());
								prod.setCst( addICMS40.getCst().getCstB());
								prod.setVlIcms(addICMS40.getvICMS());
								prod.setMotDeso(addICMS40.getMotDesICMS());							
							}
							
							if( addICMS60.getCst().getCstA() != null && addICMS60.getCst().getCstB() != null) {
								prod.setOrig(addICMS60.getCst().getCstA());
								prod.setCst( addICMS60.getCst().getCstB());
								prod.setVlBcSTRet(addICMS60.getvBCSTRet());
								prod.setVlIcmsSTRet(addICMS60.getvICMSSTRet());
													
							}
							
							if( addICMS70.getCst().getCstA() != null && addICMS70.getCst().getCstB() != null) {
								prod.setOrig(addICMS70.getCst().getCstA());
								prod.setCst( addICMS70.getCst().getCstB());
								prod.setModBc(addICMS70.getModBC());
								prod.setAliqRedBc(addICMS70.getAliqRedBC());	
								prod.setVlBc(addICMS70.getvBC());
								prod.setAliqIcms(addICMS70.getAliqICMS());
								prod.setVlIcms(addICMS70.getvICMS());
								prod.setModBcST(addICMS70.getModBCST());
								prod.setAliqMVAST(addICMS70.getAliqMVAST());
								prod.setAliqRedBCST(addICMS70.getAliqRedBCST());
								prod.setVlBcST(addICMS70.getvBCST());								
								prod.setAliqIcmsST(addICMS70.getAliqICMSST());
								prod.setVlIcmsST(addICMS70.getvICMSST());
								prod.setVlIcmsDeson(addICMS70.getvICMSDeson());
								prod.setMotDesICMS(addICMS70.getMotDesICMS());
							}
					
							//System.out.println(field.getName() +"|" + addCSOSN102_103_300_40.getCst().getCSOSN());
					 }
					
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

	public List<NotaFiscal> filtrarNotasFiscais(File diretorio, Path destino, String cnpj, String codItem,String cfop ,String orig,
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
						|| line.contains("<nNF>".concat(numDoc).concat("</nNF>"))
						|| line.contains("<CFOP>".concat(cfop).concat("</CFOP>"))) {

					
			
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
	

	private Icms00 addICMS00(Field field,Icms grp_icms) {
		
		Icms00 icms00 = new Icms00();
		if(field.getName().equals( grp_icms.getIcms00().getReg())) {
		    
			if(!grp_icms.getIcms00().getCst().getCstA().isBlank()) {
				icms00.getCst().setCstA(grp_icms.getIcms00().getCst().getCstA());
			}
			if(!grp_icms.getIcms00().getCst().getCstB().isBlank()) {
				icms00.getCst().setCstB(grp_icms.getIcms00().getCst().getCstB());
			}
			if(!grp_icms.getIcms00().getModBC().isBlank()) {
				icms00.setModBC(grp_icms.getIcms00().getModBC());;
			}		
			if(!grp_icms.getIcms00().getvBC().isBlank()) {
				icms00.setvBC(grp_icms.getIcms00().getvBC());
			}
			if(!grp_icms.getIcms00().getAliqImp().isBlank()) {
				icms00.setAliqImp(grp_icms.getIcms00().getAliqImp());
			}
			if(!grp_icms.getIcms00().getvICMS().isBlank()) {
				icms00.setvICMS(grp_icms.getIcms00().getvICMS());
			}
			
		}
       
		return icms00;
	}
	
	private Icms10 addICMS10(Field field,Icms grp_icms) {
		Icms10 icms10 = new Icms10();
		if (field.getName().equals(grp_icms.getIcms10().getReg())) {
			
			if (!grp_icms.getIcms10().getCst().getCstA().isBlank()) {
				icms10.getCst().setCstA(grp_icms.getIcms10().getCst().getCstA());			
			}
			
			if (!grp_icms.getIcms10().getCst().getCstB().isBlank()) {
				icms10.getCst().setCstB(grp_icms.getIcms10().getCst().getCstB());
			}
			
			if (!grp_icms.getIcms10().getModBC().isBlank()) {
				icms10.setModBC(grp_icms.getIcms10().getModBC());
			}
			
			if (!grp_icms.getIcms10().getvBC().isBlank()) {
				icms10.setvBC(grp_icms.getIcms10().getvBC());
			}
			
			if (!grp_icms.getIcms10().getAliqImp().isBlank()) {
				icms10.setAliqImp(grp_icms.getIcms10().getAliqImp());
			}
			
			if (!grp_icms.getIcms10().getvICMS().isBlank()) {
				icms10.setvICMS(grp_icms.getIcms10().getvICMS());
			}
			
			if (grp_icms.getIcms10().getModBCST() == null) {
				icms10.setModBCST(grp_icms.getIcms10().getModBCST());
			}
            if (grp_icms.getIcms10().getvBCST() == null) {
            	icms10.setvBCST(grp_icms.getIcms10().getvBCST());
			}
            if (grp_icms.getIcms10().getAliqICMSST() == null) {
            	icms10.setAliqICMSST(grp_icms.getIcms10().getAliqICMSST());
            }
			if (grp_icms.getIcms10().getvICMSST() == null) {
				icms10.setvICMSST(grp_icms.getIcms10().getvICMSST());
			}
		}
		
		return icms10;
	}
	
	private Icms20 addICMS20(Field field,Icms grp_icms) {
		Icms20 icms20 = new Icms20();
		
		if (field.getName().equals(grp_icms.getIcms20().getReg())) {
			if (!grp_icms.getIcms20().getCst().getCstA().isBlank()) {
				icms20.getCst().setCstA(grp_icms.getIcms20().getCst().getCstA());
			}
			
			if (!grp_icms.getIcms20().getCst().getCstB().isBlank()) {
				icms20.getCst().setCstB(grp_icms.getIcms20().getCst().getCstB());
				
			}
			//Verificar outros e deixar igual
			if(grp_icms.getIcms20().getModBC() != null) {
				if(!grp_icms.getIcms20().getModBC().isBlank()) {
					icms20.setModBC(grp_icms.getIcms20().getModBC());
			
				}
			}
				
			
			if(grp_icms.getIcms20().getAliqRedBC() == null) {
				icms20.setAliqRedBC(grp_icms.getIcms20().getAliqRedBC());
			}
			
			if(grp_icms.getIcms20().getvBC() == null) {
				icms20.setvBC(grp_icms.getIcms20().getvBC());
			}
			
			if(grp_icms.getIcms20().getAliqICMS() == null) {
				icms20.setAliqICMS(grp_icms.getIcms20().getAliqICMS());
			}
			
			if(grp_icms.getIcms20().getvICMS() == null) {
				icms20.setvICMS(grp_icms.getIcms20().getvICMS());
			}
		}
		
		
		return icms20;
	}
	private Icms40_41_50 addICMS40(Field field,Icms grp_icms) {
		Icms40_41_50 icms40_41_50 = new Icms40_41_50();
		if (field.getName().equals(grp_icms.getIcms40_41_50().getReg())) {
			
			if (!grp_icms.getIcms40_41_50().getCst().getCstA().isBlank()) {
				icms40_41_50.getCst().setCstA(grp_icms.getIcms40_41_50().getCst().getCstA());
			}
			
			if (!grp_icms.getIcms40_41_50().getCst().getCstB().isBlank()) {
				icms40_41_50.getCst().setCstB(grp_icms.getIcms40_41_50().getCst().getCstB());
				
			}
			
			if (grp_icms.getIcms40_41_50().getvICMS() == null) {
				icms40_41_50.setvICMS(grp_icms.getIcms40_41_50().getvICMS());
			}
			
            if (grp_icms.getIcms40_41_50().getMotDesICMS() == null) {
            	icms40_41_50.setMotDesICMS(grp_icms.getIcms40_41_50().getMotDesICMS());		
			}
		}
		return icms40_41_50;
	}
	private Icms60 addICMS60(Field field,Icms grp_icms) {
		Icms60 icms60 = new Icms60();
		if (field.getName().equals(grp_icms.getIcms60().getReg())) {

			if (!grp_icms.getIcms60().getCst().getCstA().isBlank()) {
				icms60.getCst().setCstA(grp_icms.getIcms60().getCst().getCstA());
			}
			if (!grp_icms.getIcms60().getCst().getCstB().isBlank()) {
				icms60.getCst().setCstB(grp_icms.getIcms60().getCst().getCstB());
			}

			if (grp_icms.getIcms60().getvBCSTRet() == null) {
                icms60.setvBCSTRet(grp_icms.getIcms60().getvBCSTRet());
			}

			if (grp_icms.getIcms60().getvICMSSTRet() == null) {
				icms60.setvICMSSTRet(grp_icms.getIcms60().getvICMSSTRet());
			}

		}
        return icms60;
	}
	
	private Icms70 addICMS70(Field field,Icms grp_icms) {
		Icms70 icms70 = new Icms70();
		
		if(field.getName().equals( grp_icms.getIcms70().getReg())) {
			
			if(!grp_icms.getIcms70().getCst().getCstA().isBlank()) {
				icms70.getCst().setCstA(grp_icms.getIcms70().getCst().getCstA());
			}
			if(!grp_icms.getIcms70().getCst().getCstB().isBlank()) {
				icms70.getCst().setCstB(grp_icms.getIcms70().getCst().getCstB());
			}
			
			if(grp_icms.getIcms70().getModBC() != null) {
				if(!grp_icms.getIcms70().getModBC().isBlank()) {
					icms70.setModBC(grp_icms.getIcms70().getModBC());				
				}
			}
			
            if(grp_icms.getIcms70().getAliqRedBC() != null) {
            	if(!grp_icms.getIcms70().getAliqRedBC().isBlank()) {
            		icms70.setAliqRedBC(grp_icms.getIcms70().getAliqRedBC());            	
            	}
			}
            
            if(grp_icms.getIcms70().getvBC() != null) {
            	 if(!grp_icms.getIcms70().getvBC().isBlank()) {
            		 icms70.setvBC(grp_icms.getIcms70().getvBC());
            	 }
			}
            
            if(grp_icms.getIcms70().getAliqICMS() != null) {
            	 if(!grp_icms.getIcms70().getAliqICMS().isBlank()) {
            		 icms70.setAliqICMS(grp_icms.getIcms70().getAliqICMS());
            	 }
			}
            
            if(grp_icms.getIcms70().getvICMS() != null) {
            	 if(!grp_icms.getIcms70().getvICMS().isBlank()) {
            		 icms70.setvICMS(grp_icms.getIcms70().getvICMS());
            	 }
			}
            
            if(grp_icms.getIcms70().getModBCST() != null) {
            	 if(!grp_icms.getIcms70().getModBCST().isBlank()) {
            		 icms70.setModBCST(grp_icms.getIcms70().getModBCST());
            	 }
			}
            
            if(grp_icms.getIcms70().getAliqMVAST() != null) {
            	 if(!grp_icms.getIcms70().getAliqMVAST().isBlank()) {
            		 icms70.setAliqMVAST(grp_icms.getIcms70().getAliqMVAST()); 
            	 }
			}
            
            if(grp_icms.getIcms70().getAliqRedBCST() != null) {
            	 if(!grp_icms.getIcms70().getAliqRedBCST().isBlank()) {
            		 icms70.setAliqRedBCST(grp_icms.getIcms70().getAliqRedBCST());
            	 }
			}
            if(grp_icms.getIcms70().getvBCST() != null) {
            	 if(!grp_icms.getIcms70().getvBCST().isBlank()) {
            		 icms70.setvBCST(grp_icms.getIcms70().getvBCST());
            	 }
			}
            if(grp_icms.getIcms70().getAliqICMSST() != null) {
            	 if(!grp_icms.getIcms70().getAliqICMSST().isBlank()) {
            		 icms70.setAliqICMSST(grp_icms.getIcms70().getAliqICMSST());
            	 }
			}
            if(grp_icms.getIcms70().getvICMSST() != null) {
            	 if(!grp_icms.getIcms70().getvICMSST().isBlank()) {
            		 icms70.setvICMSST(grp_icms.getIcms70().getvICMSST());
            	 }
			}
            if(grp_icms.getIcms70().getvICMSDeson() != null) {
            	if(!grp_icms.getIcms70().getvICMSDeson().isBlank()) {
            		icms70.setvICMSDeson(grp_icms.getIcms70().getvICMSDeson());;
            	}
			}
            if(grp_icms.getIcms70().getMotDesICMS() != null) {
            	if(!grp_icms.getIcms70().getMotDesICMS().isBlank()) {
            		icms70.setMotDesICMS(grp_icms.getIcms70().getMotDesICMS());            	
                }
			}
			
		}
		
		return icms70;
	}

	private Icms90 addICMS90(Field field,Icms grp_icms) {
		
	    Icms90 icms90 = new Icms90();
		if(field.getName().equals( grp_icms.getIcms90().getReg())) {
			
			if(!grp_icms.getIcms90().getCst().getCstA().isBlank()) {
				icms90.getCst().setCstA(grp_icms.getIcms90().getCst().getCstA());
			}
			if(!grp_icms.getIcms90().getCst().getCstB().isBlank()) {
				icms90.getCst().setCstB(grp_icms.getIcms90().getCst().getCstB());
			}
			if(grp_icms.getIcms90().getModBC() != null) {
				if(!grp_icms.getIcms90().getModBC().isBlank()) {
					icms90.setModBC(grp_icms.getIcms90().getModBC());
				}
			}
			if(grp_icms.getIcms90().getvBC() != null) {	
				if(!grp_icms.getIcms90().getvBC().isBlank()) {
					icms90.setvBC(grp_icms.getIcms90().getvBC());
				}
			}
			if(grp_icms.getIcms90().getAliqICMS() != null) {
				if(!grp_icms.getIcms90().getAliqICMS().isBlank()) {
					icms90.setAliqICMS(grp_icms.getIcms90().getAliqICMS());
				}
			}
			if(grp_icms.getIcms90().getvICMS() != null) {	
				if(!grp_icms.getIcms90().getvICMS().isBlank()) {
					icms90.setvICMS(grp_icms.getIcms90().getvICMS());
				}	
			}
				
			
			
			if(grp_icms.getIcms90().getModBCST() == null) {
				 icms90.setModBCST(grp_icms.getIcms90().getModBCST());
			}
			if(grp_icms.getIcms90().getvBCST() == null) {
				icms90.setvBCST(grp_icms.getIcms90().getvBCST());
			}
			if(grp_icms.getIcms90().getAliqICMSST() == null) {
				icms90.setAliqICMSST(grp_icms.getIcms90().getAliqICMSST());
			}
			if(grp_icms.getIcms90().getvICMSST() == null) {
				icms90.setvICMSST(grp_icms.getIcms90().getvICMSST());
			}
			
		}
		return icms90;
	}
	
	private IcmsCSOSN101 addCSOSN101(Field field,Icms grp_icms) {
		IcmsCSOSN101 grupo = new IcmsCSOSN101();
		
		if(field.getName().equals( grp_icms.getIcmsCSOSN102_103_300_400().getReg1())) {
			
			if(!grp_icms.getIcmsCSOSN101().getCst().getCstA().isBlank()) {
				grupo.getCst().setCstA(grp_icms.getIcmsCSOSN101().getCst().getCstA());
			}
			
			if(!grp_icms.getIcmsCSOSN101().getCst().getCSOSN().isBlank()) {
				grupo.getCst().setCSOSN(grp_icms.getIcmsCSOSN101().getCst().getCSOSN());
				
			}
			
			if(grp_icms.getIcmsCSOSN101().getAliqpCredSN() != null) {
				if(!grp_icms.getIcmsCSOSN101().getAliqpCredSN().isBlank()) {
					grupo.setAliqpCredSN(grp_icms.getIcmsCSOSN101().getAliqpCredSN());
				}
			}
			
			if(grp_icms.getIcmsCSOSN101().getvCredICMSSN() != null) {
				if(!grp_icms.getIcmsCSOSN101().getvCredICMSSN().isBlank()) {
					grupo.setvCredICMSSN(grp_icms.getIcmsCSOSN101().getvCredICMSSN());				
				}
			}
			
		}
		
		return grupo;
	}
	private IcmsCSOSN102_103_300_400 addCSOSN102_103_300_400(Field field,Icms grp_icms) {
		IcmsCSOSN102_103_300_400 grupo = new  IcmsCSOSN102_103_300_400();
		
        if(field.getName().equals( grp_icms.getIcmsCSOSN102_103_300_400().getReg2())) {
			
			if(!grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCstA().isBlank()) {
				grupo.getCst().setCstA(grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCstA());
			}
			
			if(!grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCSOSN().isBlank()) {
				grupo.getCst().setCSOSN(grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCSOSN());
				
			}
		}
        
        if(field.getName().equals( grp_icms.getIcmsCSOSN102_103_300_400().getReg3())) {
			
			if(!grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCstA().isBlank()) {
				grupo.getCst().setCstA(grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCstA());
			}
			
			if(!grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCSOSN().isBlank()) {
				grupo.getCst().setCSOSN(grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCSOSN());
				
			}
		}
        
        if(field.getName().equals( grp_icms.getIcmsCSOSN102_103_300_400().getReg4())) {
			
			if(!grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCstA().isBlank()) {
				grupo.getCst().setCstA(grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCstA());
			}
			
			if(!grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCSOSN().isBlank()) {
				grupo.getCst().setCSOSN(grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCSOSN());
				
			}
		}
        
        if(field.getName().equals( grp_icms.getIcmsCSOSN102_103_300_400().getReg5())) {
			
			if(!grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCstA().isBlank()) {
				grupo.getCst().setCstA(grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCstA());
			}
			
			if(!grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCSOSN().isBlank()) {
				grupo.getCst().setCSOSN(grp_icms.getIcmsCSOSN102_103_300_400().getCst().getCSOSN());
				
			}
		}
		
		return grupo;
	}
}
