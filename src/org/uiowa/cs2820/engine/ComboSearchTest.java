package org.uiowa.cs2820.engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class ComboSearchTest {
	
	 @Test
	  public void test0() {	
		CheckPoint.reset();
		DiskSpace.reset();
		Field f = new Field("citizen",true);
		Indexer I = new Indexer("first.db");
		I.addField(f);
		Field g = new Field("two",2);
		I.addField(g);
		I = new Indexer("second.db");
		I.addField(f);
		I.addField(new Field("three",3));
		FieldSearch F = new FieldSearch(f);
		String[] S = F.findEquals();
		assertEquals(S.length,2);
		assertEquals(S[0],"second.db");
		assertEquals(S[1],"first.db");
		I.remove();
		S = F.findEquals();
		assertEquals(S.length,1);
		}

	
	@Test
	  public void test1() {	
		CheckPoint.reset();
		DiskSpace.reset();
		// load some dummy data from a testing file
		HashMap<String,ArrayList<Field>> H = new HashMap<String,ArrayList<Field>>();
		String CurrentIndex = null;
		ArrayList<Field> CurrentFields = null;
	 	try {
		  BufferedReader B = new BufferedReader(new FileReader("Resources/fielddata.txt"));
		  String line;
		  String[] tokens;
		  // NOTE: has a bug (EOF not handled well); use extra fake input line at end
		  while ((line = B.readLine()) != null) {
			tokens = line.split("\\s+");
			if (CurrentIndex == null || !CurrentIndex.equals(tokens[0])) {
			  if (CurrentIndex != null) H.put(CurrentIndex,CurrentFields);
			  CurrentIndex = tokens[0];
			  CurrentFields = new ArrayList<Field>();
			  }
			CurrentFields.add(new Field(tokens[1],tokens[2]));
			}
		  B.close();
		  }
		catch (Exception e) { }
		// put dummy data into the database
		Iterator I = H.entrySet().iterator();
		while (I.hasNext()) {
		  Map.Entry pairs = (Map.Entry)I.next();
		  Indexer N = new Indexer((String)pairs.getKey());
		  CurrentFields = (ArrayList<Field>)pairs.getValue();
		  for (Field f: CurrentFields) {
		    N.addField(f);
		    // System.out.println("Added "+N+' '+f);
		    }
		  }
	    }

	@Test
	public void test2(){
		Field testera = new Field ("2.txt","l var");
		Field testerb = new Field ("1.txt","ssp var");
		FieldSearch F = new FieldSearch(testera);
		String[] array1 = F.findEquals();
		FieldSearch G = new FieldSearch(testerb);
		String[] array2 = G.findGT();
		ComboSearch A = new ComboSearch (array1,array2);
		String[] End = A.findAnd();
		//System.out.print(End.length);
		assertEquals(End.length,0);
	}
		
	@Test
	public void test3(){
		Field testera = new Field ("2.txt","l var");
		Field testerb = new Field ("1.txt","ssp var");
		FieldSearch F = new FieldSearch(testera);
		String[] array1 = F.findEquals();
		FieldSearch G = new FieldSearch(testerb);
		String[] array2 = G.findGT();
		ComboSearch A = new ComboSearch (array1,array2);
		String[] End = A.findOr();
		//System.out.print(End.length);
		assertEquals(End.length,1);
		
	}

}
