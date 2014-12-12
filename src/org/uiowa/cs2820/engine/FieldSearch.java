package org.uiowa.cs2820.engine;

public class FieldSearch {
  Field target;
  Database D;
  public FieldSearch(Field f) { 
	D = new LinearDiskDatabase();
	target = f; 
	}
  public String[] findEquals() {
	String [] R = D.fetch(target);
	if (R == null) R = new String[0];
	return R;
	}
  public String[] findGT() {
	  String [] R = D.fetchGT(target);
	  if (R == null) R = new String[0];
	  return R;	  
  	}
  public String[] findLS() {
	  String [] R = D.fetchLS(target);
	  if (R == null) R = new String[0];
	  return R;
  	}
  public String[] findPrefix() {
	  String [] R = D.prefix(target);
	  if(R == null) R = new String[0];
	  return R;
  	}
  }
