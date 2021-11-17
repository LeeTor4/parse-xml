package com.leetor4.model.nfe;

import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det;

public class ImpostoICMS {

	private static final String GRP_ICMS00   = "ICMS00";
	private static final String GRP_ICMS10   = "ICMS10";
	private static final String GRP_ICMS20   = "ICMS20";
	private static final String GRP_ICMS30   = "ICMS30";
	private static final String GRP_ICMS40   = "ICMS40";
	private static final String GRP_ICMS41   = "ICMS41";
	private static final String GRP_ICMS50   = "ICMS50";
	private static final String GRP_ICMS51   = "ICMS51";
	private static final String GRP_ICMS60   = "ICMS60";
	private static final String GRP_ICMS70   = "ICMS70";
	private static final String GRP_ICMS90   = "ICMS90";
	private static final String GRP_ICMSPART = "ICMSPART";
	private static final String GRP_ICMSST   = "ICMSST";

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
	
	public Icms impostoICMS(String name, Det det,ImpostoNFE imp) {

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
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupo00.setCst(cstIcms);
		grupo00.setModBC(cstIcms.getmBc());
		grupo00.setvBC(cstIcms.getVlBc());
		grupo00.setAliqImp(cstIcms.getAliqIcms());
		grupo00.setvICMS(cstIcms.getVlIcms());
		tipo.setIcms00(grupo00);
		return tipo;
	}

	private Icms getIcms10(Det det, Object obj2) {
		Icms10 grupo10 = (Icms10) obj2;
		CstIcms cstIcms = getCstIcms10(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupo10.setCst(cstIcms);
		
		grupo10.setModBC(cstIcms.getmBc());
		grupo10.setvBC(cstIcms.getVlBc());
		grupo10.setAliqImp(cstIcms.getAliqIcms());
		grupo10.setvICMS(cstIcms.getVlIcms());
		
		grupo10.setModBCST(cstIcms.getmBcST());
		grupo10.setAliqMVAST(cstIcms.getAliqIcmsST());
		grupo10.setAliqRedBCST(cstIcms.getAliqRedBCST());
		grupo10.setvBCST(cstIcms.getVlBcST());
		grupo10.setAliqICMSST(cstIcms.getAliqIcmsST());
		grupo10.setvICMSST(cstIcms.getVlIcmsST());;
		tipo.setIcms10(grupo10);
		return tipo;
	}

	private Icms getIcms20(Det det, Object obj3) {
		Icms20 grupo20 = (Icms20) obj3;
		CstIcms cstIcms = getCstIcms20(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupo20.setCst(cstIcms);
		grupo20.setModBC(cstIcms.getmBc());
		grupo20.setAliqRedBC(cstIcms.getAliqRedBC());
		grupo20.setvBC(cstIcms.getVlBc());
		grupo20.setAliqICMS(cstIcms.getAliqIcms());
		grupo20.setvICMS(cstIcms.getVlIcms());
		tipo.setIcms20(grupo20);
		return tipo;
	}

	private Icms getIcms30(Det det, Object obj4) {
		Icms30 grupo30 = (Icms30) obj4;
		CstIcms cstIcms = getCstIcms30(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		tipo.setIcms30(grupo30);
		return tipo;
	}

	private Icms getIcms40_41_50(Det det, Object obj5) {
		Icms40_41_50 grupo40_41_50 = (Icms40_41_50) obj5;
		CstIcms cstIcms = getCstIcms40(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupo40_41_50.setCst(cstIcms);
		grupo40_41_50.setvICMS(cstIcms.getVlIcms());
		grupo40_41_50.setMotDesICMS(cstIcms.getMotDeso());
		tipo.setIcms40_41_50(grupo40_41_50);
		return tipo;
	}

	private Icms getIcms51(Det det, Object obj6) {
		Icms51 grupo51 = (Icms51) obj6;
		CstIcms cstIcms = getCstIcms51(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		tipo.setIcms51(grupo51);
		return tipo;
	}

	private Icms getIcms60(Det det, Object obj7) {
		Icms60 grupo60 = (Icms60) obj7;
		CstIcms cstIcms = getCstIcms60(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupo60.setCst(cstIcms);
		grupo60.setvBCSTRet(cstIcms.getVlBcSTRet());
		grupo60.setvICMSSTRet(cstIcms.getVlIcmsSTRet());
		tipo.setIcms60(grupo60);
		return tipo;
	}

	private Icms getIcms70(Det det, Object obj8) {
		Icms70 grupo70 = (Icms70) obj8;
		CstIcms cstIcms = getCstIcms70(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupo70.setCst(cstIcms);
		grupo70.setModBC(cstIcms.getmBc());
		grupo70.setAliqRedBC(cstIcms.getAliqRedBC());
		grupo70.setvBC(cstIcms.getVlBc());
		grupo70.setAliqICMS(cstIcms.getAliqIcms());
		grupo70.setvICMS(cstIcms.getVlIcms());
		grupo70.setModBCST(cstIcms.getmBcST());
		grupo70.setAliqMVAST(cstIcms.getAliqMVAST());
		grupo70.setAliqRedBCST(cstIcms.getAliqRedBCST());
		grupo70.setvBCST(cstIcms.getVlBcST());
		grupo70.setAliqICMSST(cstIcms.getAliqIcmsST());
		grupo70.setvICMSST(cstIcms.getVlIcmsST());
		grupo70.setvICMSDeson(cstIcms.getvICMSDeson());
		grupo70.setMotDesICMS(cstIcms.getMotDesICMS());
		tipo.setIcms70(grupo70);
		return tipo;
	}

	private Icms getIcms90(Det det, Object obj9) {
		Icms90 grupo90 = (Icms90) obj9;
		CstIcms cstIcms = getCstIcms90(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupo90.setCst(cstIcms);
		grupo90.setModBC(cstIcms.getmBc());
		grupo90.setvBC(cstIcms.getVlBc());
		grupo90.setAliqICMS(cstIcms.getAliqIcms());
		grupo90.setvICMS(cstIcms.getVlIcms());
		
		grupo90.setModBCST(cstIcms.getmBcST());
		grupo90.setvBCST(cstIcms.getVlBcST());
		grupo90.setAliqICMSST(cstIcms.getAliqIcmsST());
		grupo90.setvICMSST(cstIcms.getVlIcmsST());
		
		tipo.setIcms90(grupo90);
		return tipo;
	}

	private Icms getIcmsPartilha(Det det, Object obj10) {
		ICMSPartilha grupoPartilha = (ICMSPartilha) obj10;
		CstIcms cstIcms = getCstIcmsPart(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		tipo.setIcmsPartilha(grupoPartilha);
		return tipo;
	}

	private Icms getIcmsSt(Det det, Object obj10) {
		IcmsSt grupoIcmsSt = (IcmsSt) obj10;
		CstIcms cstIcms = getCstIcmsSt(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		tipo.setIcmsSt(grupoIcmsSt);
		return tipo;
	}

	private Icms getIcmsSN101(Det det, Object obj11) {
		IcmsCSOSN101 grupoSN = (IcmsCSOSN101) obj11;
		CstIcms cstIcms = getCstIcmsSN101(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCSOSN());
		grupoSN.setCst(cstIcms);
		grupoSN.setAliqpCredSN(cstIcms.getAliqCredSN());
		grupoSN.setvCredICMSSN(cstIcms.getvCredICMSSN());
		tipo.setIcmsCSOSN101(grupoSN);
		return tipo;
	}

	// verificar o comportamento desse metodo
	private Icms getIcmsSN102_103_300_400(Det det, Object obj12) {
		IcmsCSOSN102_103_300_400 grupoSN = (IcmsCSOSN102_103_300_400) obj12;
		CstIcms cstIcms = getCstIcmsSN102_103_300_400(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCSOSN());
		grupoSN.setCst(cstIcms);
		tipo.setIcmsCSOSN102_103_300_400(grupoSN);
		return tipo;
	}

	private Icms getIcmsSN201(Det det, Object obj13) {
		IcmsCSOSN201 grupoSN201 = (IcmsCSOSN201) obj13;
		CstIcms cstIcms = getCstIcmsSN201(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupoSN201.setModBCST(cstIcms.getmBcST());
		grupoSN201.setAliqMVAST(cstIcms.getAliqMVAST());
		grupoSN201.setAliqRedBCST(cstIcms.getAliqRedBC());		
		grupoSN201.setvBCST(cstIcms.getVlBcST());
		grupoSN201.setAliqCredSN(cstIcms.getAliqCredSN());
		grupoSN201.setvCredICMSSN(cstIcms.getvCredICMSSN());
		tipo.setIcmsCSOSN201(grupoSN201);
		return tipo;
	}

	private Icms getIcmsSN202_203(Det det, Object obj14) {
		IcmsCSOSN202_203 grupoSN = (IcmsCSOSN202_203) obj14;
		CstIcms cstIcms = getCstIcmsSN202_203(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		tipo.setIcmsCSOSN102_203(grupoSN);
		return tipo;
	}

	private Icms getIcmsSN500(Det det, Object obj15) {
		IcmsCSOSN500 grupoSN500 = (IcmsCSOSN500) obj15;
		CstIcms cstIcms = getCstIcmsSN500(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupoSN500.setCst(cstIcms);
		grupoSN500.setvBCSTRet(cstIcms.getVlBcSTRet());
		grupoSN500.setvICMSSTRet(cstIcms.getVlIcmsSTRet());
		tipo.setIcmsCSOSN500(grupoSN500);
		return tipo;
	}

	private Icms getIcmsSN900(Det det, Object obj16) {
		IcmsCSOSN900 grupoSN90 = (IcmsCSOSN900) obj16;
		CstIcms cstIcms = getCstIcmsSN900(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCstB());
		grupoSN90.setCst(cstIcms);
		grupoSN90.setModBC(cstIcms.getmBc());
		grupoSN90.setvBC(cstIcms.getVlBc());
		grupoSN90.setAliqRedBC(cstIcms.getAliqRedBC());
		grupoSN90.setAliqICMS(cstIcms.getAliqIcms());
		grupoSN90.setvICMS(cstIcms.getVlIcms());
		grupoSN90.setModBCST(cstIcms.getmBcST());
		grupoSN90.setAliqMVAST(cstIcms.getAliqMVAST());
		grupoSN90.setAliqRedBCST(cstIcms.getAliqRedBC());		
		grupoSN90.setvBCST(cstIcms.getVlBcST());
		grupoSN90.setAliqIcmsST(cstIcms.getAliqIcmsST());
		grupoSN90.setVlIcmsST(cstIcms.getVlIcmsST());
		grupoSN90.setAliqCredSN(cstIcms.getAliqCredSN());
		grupoSN90.setvCredICMSSN(cstIcms.getvCredICMSSN());
		
		tipo.setIcmsCSOSN900(grupoSN90);
		return tipo;
	}

	private CstIcms getCstIcms00(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS00() == null) {
			cst.setCstA("");
			cst.setCstB("");
			cst.setmBc("");
			cst.setVlBc("");
			cst.setAliqIcms("");
			cst.setVlIcms("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS00().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS00().getCST());
			cst.setmBc(det.getImposto().getIcms().getICMS00().getModBC());
			cst.setVlBc(det.getImposto().getIcms().getICMS00().getVBC());
			cst.setAliqIcms(det.getImposto().getIcms().getICMS00().getPICMS());
			cst.setVlIcms(det.getImposto().getIcms().getICMS00().getVICMS());
		}
		return cst;
	}

	private CstIcms getCstIcms10(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS10() == null) {
			cst.setCstA("");
			cst.setCstB("");
			cst.setmBc("");
			cst.setVlBc("");
			cst.setAliqIcms("");
			cst.setVlIcms("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS10().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS10().getCST());
			
			cst.setmBc(det.getImposto().getIcms().getICMS10().getModBC());
			cst.setVlBc(det.getImposto().getIcms().getICMS10().getVBC());
			cst.setAliqIcms(det.getImposto().getIcms().getICMS10().getPICMS());
			cst.setVlIcms(det.getImposto().getIcms().getICMS10().getVICMS());
			
			cst.setmBcST(det.getImposto().getIcms().getICMS10().getModBCST());
			cst.setVlBcST(det.getImposto().getIcms().getICMS10().getVBCST());
			cst.setAliqIcmsST(det.getImposto().getIcms().getICMS10().getPICMSST());
			cst.setVlIcmsST(det.getImposto().getIcms().getICMS10().getVICMSST());
		}
		return cst;
	}

	private CstIcms getCstIcms20(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS20() == null) {
			cst.setCstA("");
			cst.setCstB("");
			cst.setmBc("");
			cst.setAliqRedBC("");
			cst.setVlBc("");
			cst.setAliqIcms("");
			cst.setVlIcms("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS20().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS20().getCST());			
			cst.setmBc(det.getImposto().getIcms().getICMS20().getModBC());
			cst.setAliqRedBC(det.getImposto().getIcms().getICMS20().getPRedBC());
			cst.setVlBc(det.getImposto().getIcms().getICMS20().getVBC());
			cst.setAliqIcms(det.getImposto().getIcms().getICMS20().getPICMS());
			cst.setVlIcms(det.getImposto().getIcms().getICMS20().getVICMS());
			

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
			
			cst.setmBcST(det.getImposto().getIcms().getICMS30().getModBCST());
			cst.setAliqMVAST(det.getImposto().getIcms().getICMS30().getPMVAST());
			cst.setAliqRedBCST(det.getImposto().getIcms().getICMS30().getPRedBCST());	  
			cst.setVlBcST(det.getImposto().getIcms().getICMS30().getVBCST());	
			cst.setAliqIcmsST(det.getImposto().getIcms().getICMS30().getPICMSST());
			cst.setVlIcmsST(det.getImposto().getIcms().getICMS30().getVICMSST());
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
			cst.setMotDeso(det.getImposto().getIcms().getICMS40().getVICMSDeson());
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
			cst.setmBc(det.getImposto().getIcms().getICMS51().getModBC());
			cst.setAliqRedBC(det.getImposto().getIcms().getICMS51().getPRedBC());
			cst.setVlBc(det.getImposto().getIcms().getICMS51().getVBC());
			cst.setAliqIcms(det.getImposto().getIcms().getICMS51().getPICMS());
			cst.setVlIcms(det.getImposto().getIcms().getICMS51().getVICMS());
		}
		return cst;
	}

	private CstIcms getCstIcms60(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS60() == null) {
			cst.setCstA("");
			cst.setCstB("");
			cst.setVlBcSTRet("");
			cst.setVlIcmsSTRet("");;
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS60().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS60().getCST());
			cst.setVlBcSTRet(det.getImposto().getIcms().getICMS60().getVBCSTRet());
			cst.setVlIcmsSTRet(det.getImposto().getIcms().getICMS60().getVICMSSTRet());
			
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
			cst.setmBc(det.getImposto().getIcms().getICMS70().getModBC());
			cst.setAliqRedBC(det.getImposto().getIcms().getICMS70().getPRedBC());
			cst.setVlBc(det.getImposto().getIcms().getICMS70().getVBC());
			cst.setAliqIcms(det.getImposto().getIcms().getICMS70().getPICMS());
			cst.setVlIcms(det.getImposto().getIcms().getICMS70().getVICMS());
			cst.setmBcST(det.getImposto().getIcms().getICMS70().getModBCST());
			cst.setAliqMVAST(det.getImposto().getIcms().getICMS70().getPMVAST());
			cst.setAliqRedBCST(det.getImposto().getIcms().getICMS70().getPRedBCST());	  
			cst.setVlBcST(det.getImposto().getIcms().getICMS70().getVBCST());	
			cst.setAliqIcmsST(det.getImposto().getIcms().getICMS70().getPICMSST());
			cst.setVlIcmsST(det.getImposto().getIcms().getICMS70().getVICMSST());
			cst.setvICMSDeson(det.getImposto().getIcms().getICMS70().getVICMSDeson());
			cst.setMotDesICMS(det.getImposto().getIcms().getICMS70().getMotDesICMS());
		}
		return cst;
	}

	private CstIcms getCstIcms90(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMS90() == null) {
			cst.setCstA("");
			cst.setCstB("");
			cst.setmBc("");
			cst.setVlBc("");
			cst.setAliqIcms("");
			cst.setVlIcms("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMS90().getOrig());
			cst.setCstB(det.getImposto().getIcms().getICMS90().getCST());
			cst.setmBc(det.getImposto().getIcms().getICMS90().getModBC());
			cst.setVlBc(det.getImposto().getIcms().getICMS90().getVBC());
			cst.setAliqIcms(det.getImposto().getIcms().getICMS90().getPICMS());
			cst.setVlIcms(det.getImposto().getIcms().getICMS90().getVICMS());
			
			cst.setmBcST(det.getImposto().getIcms().getICMS90().getModBCST());
			cst.setVlBcST(det.getImposto().getIcms().getICMS90().getVBCST());
			cst.setAliqIcmsST(det.getImposto().getIcms().getICMS90().getPICMSST());
			cst.setVlIcmsST(det.getImposto().getIcms().getICMS90().getVICMSST());
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
			
			cst.setmBc(det.getImposto().getIcms().getICMSPart().getModBC());
			cst.setAliqRedBC(det.getImposto().getIcms().getICMSPart().getPRedBC());
			cst.setVlBc(det.getImposto().getIcms().getICMSPart().getVBC());
			cst.setAliqIcms(det.getImposto().getIcms().getICMSPart().getPICMS());
			cst.setVlIcms(det.getImposto().getIcms().getICMSPart().getVICMS());
			cst.setmBcST(det.getImposto().getIcms().getICMSPart().getModBCST());
			cst.setAliqMVAST(det.getImposto().getIcms().getICMSPart().getPMVAST());
			cst.setAliqRedBCST(det.getImposto().getIcms().getICMSPart().getPRedBCST());	  
			cst.setVlBcST(det.getImposto().getIcms().getICMSPart().getVBCST());	
			cst.setAliqIcmsST(det.getImposto().getIcms().getICMSPart().getPICMSST());
			cst.setVlIcmsST(det.getImposto().getIcms().getICMSPart().getVICMSST());
			
			cst.setAliqBCOp(det.getImposto().getIcms().getICMSPart().getPBCOp());
			//verificar aqui a variavel tUF
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
			
			cst.setVlBcSTRet(det.getImposto().getIcms().getICMSST().getVBCSTRet());
			cst.setVlIcmsSTRet(det.getImposto().getIcms().getICMSST().getVICMSSTRet());
			
			cst.setVlBcSTDest(det.getImposto().getIcms().getICMSST().getVBCSTDest());
			cst.setVlIcmsSTDest(det.getImposto().getIcms().getICMSST().getVICMSSTDest());
		}
		return cst;
	}

	private CstIcms getCstIcmsSN101(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSSN101() == null) {
			cst.setCstA("");
			cst.setCSOSN("");
			cst.setAliqCredSN("");
			cst.setvCredICMSSN("");		
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSSN101().getOrig());
			cst.setCSOSN(det.getImposto().getIcms().getICMSSN101().getCSOSN());
			cst.setAliqCredSN(det.getImposto().getIcms().getICMSSN101().getPCredSN());
			cst.setvCredICMSSN(det.getImposto().getIcms().getICMSSN101().getVCredICMSSN());
	    }
		return cst;
	}

	private CstIcms getCstIcmsSN102_103_300_400(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getIcms().getICMSSN102() == null) {
			cst.setCstA("");
			cst.setCSOSN("");
		} else {
			cst.setCstA(det.getImposto().getIcms().getICMSSN102().getOrig());
			cst.setCSOSN(det.getImposto().getIcms().getICMSSN102().getCSOSN());
			
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
			
			cst.setmBcST(det.getImposto().getIcms().getICMSSN201().getModBCST());
			cst.setAliqMVAST(det.getImposto().getIcms().getICMSSN201().getPMVAST());
			cst.setAliqRedBCST(det.getImposto().getIcms().getICMSSN201().getPRedBCST());
			cst.setVlBcST(det.getImposto().getIcms().getICMSSN201().getVBCST());
			cst.setVlIcmsST(det.getImposto().getIcms().getICMSSN201().getVICMSST());
			cst.setAliqCredSN(det.getImposto().getIcms().getICMSSN201().getPCredSN());
			cst.setvCredICMSSN(det.getImposto().getIcms().getICMSSN201().getVCredICMSSN());
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
			cst.setmBcST(det.getImposto().getIcms().getICMSSN202().getModBCST());
			cst.setAliqMVAST(det.getImposto().getIcms().getICMSSN202().getPMVAST());
			cst.setAliqRedBCST(det.getImposto().getIcms().getICMSSN202().getPRedBCST());
			cst.setVlBcST(det.getImposto().getIcms().getICMSSN202().getVBCST());
			cst.setVlIcmsST(det.getImposto().getIcms().getICMSSN202().getVICMSST());
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
			cst.setVlBcSTRet(det.getImposto().getIcms().getICMSSN500().getVBCSTRet());
			cst.setVlIcmsSTRet(det.getImposto().getIcms().getICMSSN500().getVICMSSTRet());
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
			cst.setmBc(det.getImposto().getIcms().getICMSSN900().getModBC());
			cst.setVlBc(det.getImposto().getIcms().getICMSSN900().getVBC());
			cst.setAliqRedBC(det.getImposto().getIcms().getICMSSN900().getPRedBC());
			cst.setAliqIcms(det.getImposto().getIcms().getICMSSN900().getPICMS());
			cst.setVlIcms(det.getImposto().getIcms().getICMSSN900().getVICMS());
			cst.setmBcST(det.getImposto().getIcms().getICMSSN900().getModBCST());
			cst.setAliqMVAST(det.getImposto().getIcms().getICMSSN900().getPMVAST());
			cst.setAliqRedBCST(det.getImposto().getIcms().getICMSSN900().getPRedBCST());
			cst.setVlBcST(det.getImposto().getIcms().getICMSSN900().getVBCST());
			cst.setVlIcmsST(det.getImposto().getIcms().getICMSSN900().getVICMSST());
			cst.setAliqCredSN(det.getImposto().getIcms().getICMSSN900().getPCredSN());
			cst.setvCredICMSSN(det.getImposto().getIcms().getICMSSN900().getVCredICMSSN());
		}
		return cst;
	}
}
