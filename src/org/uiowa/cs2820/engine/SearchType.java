package src.org.uiowa.cs2820.engine;

import java.util.ArrayList;

public class SearchType {
  
  public void greaterThan(Field n){
    ArrayList<Field> master = new ArrayList<Field>();
    for(Field a : database){   	
    
    	if (a.getFieldName().equals(n.getFieldName())){
        
        if (a.getFieldName().compareTo(n.getFieldName() == 1)){
          master.add(a);
        }
      }
    }
    return master;
  }
  
  public void lessThan( Field n){
	  ArrayList<Field> master = new ArrayList<Field>();
	    for(Field a : database){   	
	    
	      if (a.getFieldName().equals(n.getFieldName())){
	        
	        if (a.getFieldName().compareTo(n.getFieldName() == -1)){
	          master.add(a);
	        }
	      }
	    }
	    return master;
	  }
    public void equals( Field n){
  	  ArrayList<Field> master = new ArrayList<Field>();
	    for(Field a : database){   	
	    
	      if (a.getFieldName().equals(n.getFieldName())){
	        
	        if (a.getFieldName().compareTo(n.getFieldName() == 0)){
	          master.add(a);
	        }
	      }
	    }
	    return master;
	  }
      public void prefix( Field n){
       ArrayList<Field> master = new ArrayList<Field>()
       for(Field a : database){
    
       if (a.getFieldName().equals(n.getFieldName())){
       
       	if (a.getFieldValue().substring(0, n.getFieldValue().length()) == n.getFieldValue()){
            master.add(a);
       			}
       		}
       }
      return master;
      }
}
