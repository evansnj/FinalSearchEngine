Team 1: Final Search Engine Project
Members: Jason Sherman, Nicholas Evans, Brandon Sosa, Kevin Stasko

Enhancements Assignments: 

1. REST Interface - Nick Evans
    - Classes: 
      - Server: implements the server
      - ServerTest
      - Main
    - Methods: search, index
    - Tests: test search method returns correct files, and the index method can add to the db

2. Allow more kinds of searches (< >, pre, in) - Kevin Stasko
    - methods (equalts, greaterThan, lessThan, prefix, isIn)
    - Junit test = SearchTypeTests.java //see src/SearchTypeTests.java for more details

3. Allow for combinations of searches - Jason Sherman
	- might make a new class called Combine.java or might 	alter the current search.
	- possible methods: multiSearch, combineResultsAnd, 	combineResultsOr
	-Junit test: CombineTests.java

5. return Iterator - Brandon Sosa
    - Interface = External Iterator, controlled by the search object
    - Class = Parse implementing the for loop(s) necessary to return an iterator rather than an array of strings, implementing
              the designed interfaces.
    -Methods: StackedIterator, LinkedStack
    - Tests: test that the correct iterators are returned and that the interface correctly engages with the search object

//Each Junit test can be found in the main directory



