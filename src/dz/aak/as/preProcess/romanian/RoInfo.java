package dz.aak.as.preProcess.romanian;

import aak.as.preProcess.lang.PreProcessInfo;

public class RoInfo implements PreProcessInfo {

	@Override
	public String getISO639_1() {
		return "ro";
	}

	@Override
	public String getLangEnglishName() {
		return "Romanian";
	}

	@Override
	public String getLangName() {
		return "limba română";
	}

	@Override
	public String getPrefix() {
		return "Ro";
	}

}