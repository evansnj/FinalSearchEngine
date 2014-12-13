package org.uiowa.cs2820.engine;

public class FieldSearch {
  Field target;
  Database D;
  String [] R;
  public FieldSearch(Field f) { 
	D = new LinearDiskDatabase();
	target = f; 
	}
  public String[] findEquals() {
	R = D.fetch(target);
	if (R == null) R = new String[0];
	return R;
	}
  public String[] findGT() {
	  R = D.fetchGT(target);
	  if (R == null) R = new String[0];
	  return R;	  
  	}
  public String[] findLS() {
	  R = D.fetchLS(target);
	  if (R == null) R = new String[0];
	  return R;
  	}
  public String[] findPrefix() {
	  R = D.prefix(target);
	  if(R == null) R = new String[0];
	  return R;
  	}
  }
