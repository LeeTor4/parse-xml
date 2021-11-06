package com.leetor4.model.nfe;

import com.leetor4.portalfiscal.inf.br.nfe.TNFe.InfNFe.Det;

public class ContribuicaoCofins {

	private static final String GRP_COFINSALIQ   = "COFINSALIQ";
	private static final String GRP_COFINSQTDE   = "COFINSQTDE";
	private static final String GRP_COFINSNT     = "COFINSNT";
	private static final String GRP_COFINSOUTR   = "COFINSOUTR";
	
	
	public Cofins contribuicaoPis(String name, Det det,ImpostoNFE imp) {
		Cofins tipo = null;
		
		switch (name.toUpperCase()) {
		   case GRP_COFINSALIQ:
			    GrupoCofins g1 = GrupoCofins.valueOf(GrupoCofins.class, name.toUpperCase());
				Object obj1 = g1.pegarGrupoCofins();
				tipo = getCofinsAliq(det, obj1);
				imp.setCofins(tipo);
			   break;
		   case GRP_COFINSQTDE:
			   GrupoCofins g2 = GrupoCofins.valueOf(GrupoCofins.class, name.toUpperCase());
				Object obj2 = g2.pegarGrupoCofins();
				tipo = getCofinsQtde(det, obj2);
				imp.setCofins(tipo);
			   break;
		   case GRP_COFINSNT:
			   GrupoCofins g3 = GrupoCofins.valueOf(GrupoCofins.class, name.toUpperCase());
				Object obj3 = g3.pegarGrupoCofins();
				tipo = getCofinsNaoTrib(det, obj3);
				imp.setCofins(tipo);
			   break;
		   case GRP_COFINSOUTR:
			   GrupoCofins g4 = GrupoCofins.valueOf(GrupoCofins.class, name.toUpperCase());
				Object obj4 = g4.pegarGrupoCofins();
				tipo = getCofinsOut(det, obj4);
				imp.setCofins(tipo);
			   break;
		}
		
		
		return tipo;
	}
	
	private Cofins getCofinsAliq(Det det, Object obj1) {
		CofinsAliq pisAliq = (CofinsAliq) obj1;
		CstPisCofins cst = getCstCofinsAliq(det);
		Cofins tipo = new Cofins(cst.getCodigo());
		tipo.setCofinsAliq(pisAliq);
		return tipo;
	}
	
	private Cofins getCofinsQtde(Det det, Object obj1) {
		CofinsQtde cofinsQtde = (CofinsQtde) obj1;
		CstPisCofins cst = getCstCofinsQtde(det);
		Cofins tipo = new Cofins(cst.getCodigo());
		tipo.setCofinsQtde(cofinsQtde);
		return tipo;
	}
	
	private Cofins getCofinsOut(Det det, Object obj1) {
		CofinsOutr cofinsNT = (CofinsOutr) obj1;
		CstPisCofins cst = getCstCofinsOutr(det);
		Cofins tipo = new Cofins(cst.getCodigo());
		tipo.setCofinsOutr(cofinsNT);
		return tipo;
	}
	
	
	private Cofins getCofinsNaoTrib(Det det, Object obj1) {
		CofinsNaoTrib cofinsAliq = (CofinsNaoTrib) obj1;
		CstPisCofins cst = getCstCofinsNaoTrib(det);
		Cofins tipo = new Cofins(cst.getCodigo());
		tipo.setCofinsNT(cofinsAliq);
		return tipo;
	}
	
	private CstPisCofins getCstCofinsAliq(Det det) {
		CstPisCofins cst = new CstPisCofins();
		if (det.getImposto().getCofins().getCOFINSAliq() == null) {
			cst.setCodigo("");
			
		} else {
			cst.setCodigo(det.getImposto().getCofins().getCOFINSAliq().getCST());
			
		}
		return cst;
	}

	
	private CstPisCofins getCstCofinsQtde(Det det) {
		CstPisCofins cst = new CstPisCofins();
		if (det.getImposto().getCofins().getCOFINSQtde() == null) {
			cst.setCodigo("");
			
		} else {
			cst.setCodigo(det.getImposto().getCofins().getCOFINSQtde().getCST());
			
		}
		return cst;
	}
	
	private CstPisCofins getCstCofinsOutr(Det det) {
		CstPisCofins cst = new CstPisCofins();
		if (det.getImposto().getCofins().getCOFINSOutr() == null) {
			cst.setCodigo("");
		} else {
			cst.setCodigo(det.getImposto().getCofins().getCOFINSOutr().getCST());			
		}
		return cst;
	}
	
	private CstPisCofins getCstCofinsNaoTrib(Det det) {
		CstPisCofins cst = new CstPisCofins();
		if (det.getImposto().getCofins().getCOFINSNT() == null) {
			cst.setCodigo("");
		} else {
			cst.setCodigo(det.getImposto().getCofins().getCOFINSNT().getCST());			
		}
		return cst;
	}
	
	
}
