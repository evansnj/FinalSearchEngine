package org.uiowa.cs2820.engine;

import java.util.Arraylist;

public class SearchType (
  
public class SearchType {
  
  public void greaterThan( Field n){
    ArrayList<Field> master = new ArrayList<Field>();
    for(Field a : database){
    
      if (a.getFieldName().equals(n.getFieldName())){
        int flag = a.getFieldValue().compareTo(n.getFieldValue());
        
        if (flag == 1){
          master.add(a);
        }
      }
    }
    return master;
  }
  
  public void lessThan( Field n){
    //ArrayList<Field> master = new ArrayList<Field>()
    //for(field a in database)
    
      //if a.getFieldName().equals(n.getFieldName()
        //int flag = a.getFieldValue().compareTo(n.getFieldValue())
        
        //if flag == -1
          //master.add(a)
    //return master
  }
    public void equals( Field n){
      //ArrayList<Field> master = new ArrayList<Field>()
      //for(field a in database)
    
      //if a.getFieldName().equals(n.getFieldName()
        //int flag = a.getFieldValue().compareTo(n.getFieldValue())
        
        //if flag == 0
          //master.add(a)
    //return master
    }
      public void prefix( Field n){
        //ArrayList<Field> master = new ArrayList<Field>()
        //for(field a in database)
    
       //if a.getFieldName().equals(n.getFieldName())
       
        //if a.getFieldValue().substring(0, n.getFieldValue().length()) == n.getFieldValue()
            //master.add(a);
            
      //return master
      }
