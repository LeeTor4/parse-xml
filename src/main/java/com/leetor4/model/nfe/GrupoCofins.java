package com.leetor4.model.nfe;

public enum GrupoCofins {

	COFINSALIQ {
		@Override
		public Object pegarGrupoCofins() {
			return new CofinsAliq();
		}
	},
	COFINSQTDE {
		@Override
		public Object pegarGrupoCofins() {
			return new CofinsQtde();
		}
	},
	COFINSNT {
		@Override
		public Object pegarGrupoCofins() {
			return new CofinsNaoTrib();
		}
	},
	COFINSOUTR {
		@Override
		public Object pegarGrupoCofins() {
			return new CofinsOutr();
		}
	},

	COFINSST

	{
		@Override
		public Object pegarGrupoCofins() {
			return new CofinsSt();
		}
	};

	public abstract Object pegarGrupoCofins();
}
