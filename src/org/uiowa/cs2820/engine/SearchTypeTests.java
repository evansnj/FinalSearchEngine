package org.uiowa.cs2820.engine;

public class AllocateTest {
//create a relatively elaborate database
  DB.add("Name", "Kevin")
  DB.add("Part", "Axel");
  DB.add("Part", "Box");
  DB.add("Part", "Gear");
  ...
//create other entries that include numbers as well as strings in Field values
  DB2.add("Serial",0123);
  DB2.add("Serial",4567);
  DB2.add("Serial", 9876);
  ...
/*prefix test
  //for a given search, should return all items with that prefix
  
  SearchType.prefix("Word", "pre");
//get list of all returns and compare to an existing ArrayList<Strings>

/* greaterThan, lessThan and isIn will follow this format as well. Each method will return an
ArrayList<Strings> and potentially print a string on screen
