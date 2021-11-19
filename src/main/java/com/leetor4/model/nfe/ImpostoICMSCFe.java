package com.leetor4.model.nfe;

import com.leetor4.portalfiscal.inf.br.cfe.EnvTeste.CFe.InfCFe.Det;

public class ImpostoICMSCFe {

	private static final String GRP_ICMS00   = "ICMS00";
	private static final String GRP_ICMS40   = "ICMS40";
	private static final String GRP_ICMSSN102 = "ICMSSN102";
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
		case GRP_ICMS40:
			GrupoIcms g5 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj5 = g5.pegarGrupoIcms();
			tipo = getIcms40_41_50(det, obj5);
			imp.setIcms(tipo);
			break;
		case GRP_ICMSSN102:
			GrupoIcms g15 = GrupoIcms.valueOf(GrupoIcms.class, name.toUpperCase());
			Object obj15 = g15.pegarGrupoIcms();
			tipo = getIcmsSN102_103_300_400(det, obj15);
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


	// verificar o comportamento desse metodo
	private Icms getIcmsSN102_103_300_400(Det det, Object obj12) {
		IcmsCSOSN102_103_300_400 grupoSN = (IcmsCSOSN102_103_300_400) obj12;
		CstIcms cstIcms = getCstIcmsSN102_103_300_400(det);
		Icms tipo = new Icms(cstIcms.getCstA(),cstIcms.getCSOSN());
		grupoSN.setCst(cstIcms);
		tipo.setIcmsCSOSN102_103_300_400(grupoSN);
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
		if (det.getImposto().getICMS().getICMS00() == null) {
			cst.setCstA("");
			cst.setCstB("");
			cst.setmBc("");
			cst.setVlBc("");
			cst.setAliqIcms("");
			cst.setVlIcms("");
		} else {
			cst.setCstA(det.getImposto().getICMS().getICMS00().getOrig());
			cst.setCstB(det.getImposto().getICMS().getICMS00().getCST());
			cst.setAliqIcms(det.getImposto().getICMS().getICMS00().getPICMS());
			cst.setVlIcms(det.getImposto().getICMS().getICMS00().getVICMS());
		}
		return cst;
	}


	private CstIcms getCstIcms40(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getICMS().getICMS40() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getICMS().getICMS40().getOrig());
			cst.setCstB(det.getImposto().getICMS().getICMS40().getCST());

		}
		return cst;
	}

	private CstIcms getCstIcmsSN102_103_300_400(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getICMS().getICMSSN102() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getICMS().getICMSSN102().getOrig());
			cst.setCstB(det.getImposto().getICMS().getICMSSN102().getCSOSN());
			
		}
		return cst;
	}


	private CstIcms getCstIcmsSN900(Det det) {
		CstIcms cst = new CstIcms();
		if (det.getImposto().getICMS().getICMSSN900() == null) {
			cst.setCstA("");
			cst.setCstB("");
		} else {
			cst.setCstA(det.getImposto().getICMS().getICMSSN900().getOrig());
			cst.setCstB(det.getImposto().getICMS().getICMSSN900().getCSOSN());
			cst.setAliqIcms(det.getImposto().getICMS().getICMSSN900().getPICMS());
			cst.setVlIcms(det.getImposto().getICMS().getICMSSN900().getVICMS());

		}
		return cst;
	}
	
}
