package com.leetor4.model.nfe;

public enum GrupoIcms {

	ICMS00 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms00();
		}
	},
	ICMS10 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms10();
		}
	},
	ICMS20 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms20();
		}
	},
	ICMS30 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms30();
		}
	},
	ICMS40 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms40_41_50();
		}
	},
	ICMS41 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms40_41_50();
		}
	},
	ICMS50 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms40_41_50();
		}
	},
	ICMS51 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms51();
		}
	},
	ICMS60 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms60();
		}
	},
	ICMS70 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms70();
		}
	},
	ICMS90 {
		@Override
		public Object pegarGrupoIcms() {

			return new Icms90();
		}
	},
	ICMSPART {
		@Override
		public Object pegarGrupoIcms() {

			return new ICMSPartilha();
		}
	},
	ICMSST {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsSt();
		}
	},
	ICMSSN101 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN101();
		}
	},
	ICMSSN102 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN102_103_300_400();
		}
	},
	ICMSSN103 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN102_103_300_400();
		}
	},
	ICMSSN201 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN201();
		}
	},
	ICMSSN202 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN202_203();
		}
	},
	ICMSSN203 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN202_203();
		}
	},
	ICMSSN300 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN102_103_300_400();
		}
	},
	ICMSSN400 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN102_103_300_400();
		}
	},
	ICMSSN500 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN500();
		}
	},
	ICMSSN900 {
		@Override
		public Object pegarGrupoIcms() {

			return new IcmsCSOSN900();
		}
	};

	public abstract Object pegarGrupoIcms();
}
