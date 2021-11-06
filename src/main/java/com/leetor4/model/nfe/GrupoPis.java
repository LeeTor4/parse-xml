package com.leetor4.model.nfe;

public enum GrupoPis {

	PISALIQ {
		@Override
		public Object pegarGrupoPis() {
			return new PisAliq();
		}
	},
	PISQTDE {
		@Override
		public Object pegarGrupoPis() {
			return new PisQtde();
		}
	},
	PISNT {
		@Override
		public Object pegarGrupoPis() {
			return new PisNaoTrib();
		}
	},
	PISOUTR {
		@Override
		public Object pegarGrupoPis() {
			return new PisOutr();
		}
	},

	PISST

	{
		@Override
		public Object pegarGrupoPis() {
			return new PisSt();
		}
	};

	public abstract Object pegarGrupoPis();
}
