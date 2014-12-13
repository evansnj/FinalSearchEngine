//Testing an empty Iterator
@Test
public void testSize0() {
        Iterator<String> iterator = Iterators.emptyIterator();
        assertEquals(0, Iterators.size(iterator));
        }
//Testing that the Iterator actually contains a value
@Test
public void testSize1() {
        Iterator<Integer> iterator = Collections.singleton(0).iterator();
        assertEquals(1, Iterators.size(iterator));
        }
//Check that the Iterator correctly parses a list index
@Test
public void testSize_partiallyConsumed() {
        Iterator<Integer> iterator = asList(1, 2, 3, 4, 5).iterator();
        iterator.next();
        iterator.next();
        assertEquals(3, Iterators.size(iterator));
        }