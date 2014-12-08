Team 1: Final Search Engine Project
Members: Jason Sherman, Nicholas Evans, Brandon Sosa, Kevin Stasko

Enhancements Assignments: 

1. new Interface - Nick Evans
    - Classes: 
      - RestfulServer: implements the server
      - (There may be more)
    - Methods: search, index (more?)
    - Tests: test web server starts correctly, search method returns correct JSON, and the index method can add to the db

2. Allow more kinds of searches (< >, pre, in) - Kevin Stasko
    - methods (equalts, greaterThan, lessThan, prefix, isIn)
    - Junit test = SearchTypeTests.java //see src/SearchTypeTests.java for more details

3. Allow for combinations of searches - Jason Sherman
	- might make a new class called Combine.java or might 	alter the current search.
	- possible methods: multiSearch, combineResultsAnd, 	combineResultsOr
	-Junit test: CombineTests.java

5. return Iterator - Brandon Sosa
    - Interface = External Iterator, controlled by the search object
    - Class = Parse implementing the for loop(s) necessary to return an iterator rather than an array of strings
    - Tests: test that the correct iterators are returned and the interface works correctly engages with the search object

//Each Junit test can be found in the main directory



