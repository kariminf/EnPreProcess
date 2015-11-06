package dz.aak.as.preProcess.czech;

import aak.as.preProcess.lang.PreProcessInfo;

public class CsInfo implements PreProcessInfo {

	@Override
	public String getISO639_1() {
		return "cs";
	}

	@Override
	public String getLangEnglishName() {
		return "Czech";
	}

	@Override
	public String getLangName() {
		return "čeština";
	}

	@Override
	public String getPrefix() {
		return "Cs";
	}

}