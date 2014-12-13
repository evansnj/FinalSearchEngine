package org.uiowa.cs2820.engine;

import java.util.*;

public class ComboSearch {
	String [] R;
	String [] S;
	ArrayList<String> T;
	public ComboSearch(String [] input1, String [] input2) { 
		R = input1;
		S = input2;
		T = new ArrayList<String>();
	}
	public String[] findAnd() {	
		for (String i : R){
			for (String k : S){
				if (i.equals(k)) T.add(i);
			}
		}
		String[] Andcontent = new String[T.size()];
		return Andcontent;
		}
	public String[] findOr() {
		for (String i : R){
			T.add(i);
		}
		for (String k : S){
			T.add(k);
			}
		ArrayList<String> removeduplicates = new ArrayList<String>(new LinkedHashSet<String>(T));
		String[] Orcontent = new String[removeduplicates.size()];
		return Orcontent;
		}
	}
