//this test does not work. Been swamped with other projects
package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;


class SearchTypeTest {
  Database D = new LinearDiskDatabase();
  
  D.store(new Field("Name", "Kevin"),"Kevin");
  D.store(new Field("Name", "Deborah"),"Deborah");
  D.store(new Field("Name", "Jim"), "Jim");
  D.store(new Field("Part", "Axel"), "Axel");
  D.store(new Field("Name", "Jimmy"), "Jimmy");
  D.store(new Field("Animal", "Zebra"),"Zebra");
  D.store(new Field("Animal", "Dog"), "Dog");
  D.store(new Field("Part", "Wheel"), "Wheel");
  D.store(new Field("Serial", 456782), "SerialID");
  D.store(new Field("Serial", 12345), "SerialID");
  D.store(new Field("Serial", 56432), "SerialID");
  //...and so on
  
  @Test
  public void Test1(){
    Field f = new Field("Animal", "Dog");
    FieldSearch F = new FieldSearch.findLS(f);
    String [] S = F.findLS();
    assertEquals(S.length,1);
  }
  
  @Test
  public void Test2(){
    Field g = new Field("Serial", 12345);
    FieldSearch F = new FieldSearch.findGT(f);
    String [] S = F.findGT();
    assertEquals(S.length,1);

  }
  
  @Test 
  public void Test3(){
    Field g = new Field("Name", "Ji");
    FieldSearch F = new FieldSearch.findPrefix(g);
    String [] S = F.findPrefix();
    assertEquals(S.length, 2);
  }
  
  
  
  
  
  
}
