package org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class SearchType {
  ArrayList<Field> D;
  
  public ArrayList<Field> greaterThan(Field n){
    ArrayList<Field> master = new ArrayList<Field>();
    for(Field a : D){   	
    
    	if (a.getFieldName().equals(n.getFieldName())){
        
        	if (a.getFieldName().compareTo(n.getFieldName()) > 0){
        		master.add(a);
        	}
    	}
    }
    return master;
  }
  
  public ArrayList<Field> lessThan(Field n,ArrayList<Field> D){
	  ArrayList<Field> master = new ArrayList<Field>();
	  for(Field a : D){   	
	    
		if (a.getFieldName().equals(n.getFieldName())){
	        
	      		if (a.getFieldName().compareTo(n.getFieldName()) < 0){
	    	  		master.add(a);
	      	  	}
		  }
	  }
	  return master;
  }
  
  public ArrayList<Field> equals(Field n, ArrayList<Field> D){
	  ArrayList<Field> master = new ArrayList<Field>();
	  for(Field a : D){   	
	    
		if (a.getFieldName().equals(n.getFieldName())){
	        
	      		if (a.getFieldName().compareTo(n.getFieldName()) == 0){
	    	  		master.add(a);
	          	}
	      	}
	  }
	  return master;
	  }
  public ArrayList<Field> prefix( Field n, ArrayList<Field> D){
	ArrayList<Field> master = new ArrayList<Field>();
      for(Field a : D){
    
    	  if (a.getFieldName().equals(n.getFieldName())){
       
    		  if (a.getFieldValue().substring(0, (n.getFieldValue().toString().length())) == n.getFieldValue()){
    			  master.add(a);
       			}
       		}
       }
      return master;
      }
}
