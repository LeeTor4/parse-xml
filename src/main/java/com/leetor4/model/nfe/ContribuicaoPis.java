package com.leetor4.model.nfe;

import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det;

public class ContribuicaoPis {

	private static final String GRP_PISALIQ   = "PISALIQ";
	private static final String GRP_PISQTDE   = "PISQTDE";
	private static final String GRP_PISNT     = "PISNT";
	private static final String GRP_PISOUTR   = "PISOUTR";
	
	
	public Pis contribuicaoPis(String name, Det det,ImpostoNFE imp) {
		Pis tipo = null;
		
		switch (name.toUpperCase()) {
		   case GRP_PISALIQ:
			    GrupoPis g1 = GrupoPis.valueOf(GrupoPis.class, name.toUpperCase());
				Object obj1 = g1.pegarGrupoPis();
				tipo = getPisAliq(det, obj1);
				imp.setPis(tipo);
			   break;
		   case GRP_PISQTDE:
			    GrupoPis g2 = GrupoPis.valueOf(GrupoPis.class, name.toUpperCase());
				Object obj2 = g2.pegarGrupoPis();
				tipo = getPisQtde(det, obj2);
				imp.setPis(tipo);
			   break;
		   case GRP_PISNT:
			    GrupoPis g3 = GrupoPis.valueOf(GrupoPis.class, name.toUpperCase());
				Object obj3 = g3.pegarGrupoPis();
				tipo = getPisNT(det, obj3);
				imp.setPis(tipo);
			   break;
		   case GRP_PISOUTR:
			    GrupoPis g4 = GrupoPis.valueOf(GrupoPis.class, name.toUpperCase());
				Object obj4 = g4.pegarGrupoPis();
				tipo = getPisOut(det, obj4);
				imp.setPis(tipo);
			   break;
		}
		
		
		return tipo;
	}
	
	private Pis getPisAliq(Det det, Object obj1) {
		PisAliq pisAliq = (PisAliq) obj1;
		CstPisCofins cst = getCstPisAliq(det);
		Pis tipo = new Pis(cst.getCodigo());
		pisAliq.setCst(cst);
		pisAliq.setvBC(cst.getVlBc());
		pisAliq.setAliqPIS(cst.getAliqPis());
		pisAliq.setvPIS(cst.getVlPis());
		tipo.setPisAliq(pisAliq);
		return tipo;
	}
	
	private Pis getPisQtde(Det det, Object obj1) {
		PisQtde pisAliq = (PisQtde) obj1;
		CstPisCofins cst = getCstPisQtde(det);
		Pis tipo = new Pis(cst.getCodigo());
		tipo.setPisQtde(pisAliq);
		return tipo;
	}
	
	private Pis getPisNT(Det det, Object obj1) {
		PisNaoTrib pisAliq = (PisNaoTrib) obj1;
		CstPisCofins cst = getCstPisNT(det);
		Pis tipo = new Pis(cst.getCodigo());
		tipo.setPisNT(pisAliq);
		return tipo;
	}
	
	
	private Pis getPisOut(Det det, Object obj1) {
		PisOutr pisAliq = (PisOutr) obj1;
		CstPisCofins cst = getCstPisOutr(det);
		Pis tipo = new Pis(cst.getCodigo());
		tipo.setPisOutr(pisAliq);
		return tipo;
	}
	
	private CstPisCofins getCstPisAliq(Det det) {
		CstPisCofins cst = new CstPisCofins();
		if (det.getImposto().getPis().getPISAliq() == null) {
			cst.setCodigo("");
			
		} else {
			cst.setCodigo(det.getImposto().getPis().getPISAliq().getCST());
			cst.setVlBc(det.getImposto().getPis().getPISAliq().getVBC());
			cst.setAliqPis(det.getImposto().getPis().getPISAliq().getPPIS());
			cst.setVlPis(det.getImposto().getPis().getPISAliq().getVPIS());
			
		}
		return cst;
	}

	
	private CstPisCofins getCstPisQtde(Det det) {
		CstPisCofins cst = new CstPisCofins();
		if (det.getImposto().getPis().getPISQtde() == null) {
			cst.setCodigo("");
			
		} else {
			cst.setCodigo(det.getImposto().getPis().getPISQtde().getCST());
			
		}
		return cst;
	}
	
	private CstPisCofins getCstPisNT(Det det) {
		CstPisCofins cst = new CstPisCofins();
		if (det.getImposto().getPis().getPISNT() == null) {
			cst.setCodigo("");
		} else {
			cst.setCodigo(det.getImposto().getPis().getPISNT().getCST());
			
		}
		return cst;
	}
	
	private CstPisCofins getCstPisOutr(Det det) {
		CstPisCofins cst = new CstPisCofins();
		if (det.getImposto().getPis().getPISOutr() == null) {
			cst.setCodigo("");
		} else {
			cst.setCodigo(det.getImposto().getPis().getPISOutr().getCST());			
		}
		return cst;
	}
	
	
}
