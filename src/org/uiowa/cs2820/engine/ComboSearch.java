package org.uiowa.cs2820.engine;

public class ComboSearch {
	Field targeta;
	Field targetb;
	Database D;
	public ComboSearch(Field f, Field g) { 
		D = new LinearDiskDatabase();
		targeta = f;
		targetb = g;
		}
	public String[] findAnd() {
		String [] R = D.fetch(targeta);
		if (R == null) R = new String[0];
		String [] S = D.fetch(targetb);
		if (S == null) S = new String[0];
		
		return T;
		}
	public String[] findOr() {
		String [] U = D.fetch(targeta);
		if (U == null) U = new String[0];
		String [] V = D.fetch(targetb);
		if (V == null) V = new String[0];
		
		return X;
		}
	}
