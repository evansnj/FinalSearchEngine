package org.uiowa.cs2820.engine;

public class LinearDiskDatabase implements Database {

	  public void store(Field f, String id) {
	    Storage.add(f,id);
	    }

	  public void remove(String id) {
	    Node.remove(id);
	    }

	  public String[] fetch(Field f) {
	    Node n = Node.findNode(f);
	    if (n == null) return new String[0];
	    return Identifier.getAllIds(n.identlist);
	    }
	  public String[] fetchGT(Field f){
		Node n = Node.findNodeGT(f);
		if(n==null) return new String[0];
		return Identifier.getAllIds(n.identlist);
	    }
	  public String[] fetchLS(Field f){
		  Node n = Node.findNodeLS(f);
		  if(n==null) return new String[0];
		  return Identifier.getAllIds(n.identlist);
	  	}
	  public String[] prefix(Field f){
		  Node n = Node.findPrefix(f);
		  if(n == null) return new String[0];
		  return Identifier.getAllIds(n.identlist);
	  	}
	  }
		  
