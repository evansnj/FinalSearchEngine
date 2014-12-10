package org.uiowa.cs2820.engine;

import java.util.*;

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
		ArrayList<String> T = new ArrayList<String>();
		String [] R = D.fetch(targeta);
		if (R == null) R = new String[0];
		String [] S = D.fetch(targetb);
		if (S == null) S = new String[0];		
		for (String i : R){
			for (String k : S){
				if (i.equals(k)) T.add(i);
			}
		}
		String[] Andcontent = new String[T.size()];
		return Andcontent;
		}
	public String[] findOr() {
		ArrayList<String> X = new ArrayList<String>();
		String [] U = D.fetch(targeta);
		if (U == null) U = new String[0];
		String [] V = D.fetch(targetb);
		if (V == null) V = new String[0];
		for (String i : U){
			X.add(i);
		}
		for (String k : V){
			X.add(k);
			}
		ArrayList<String> removeduplicates = new ArrayList<String>(new LinkedHashSet<String>(X));
		String[] Orcontent = new String[removeduplicates.size()];
		return Orcontent;
		}
	}
