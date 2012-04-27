/*(C) 2007-2012 Alibaba Group Holding Limited.	

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BoundedConcurrentHashMapUnitTest {
	
	@Test
	public void testBounded() {
		int size = 100;
		Object[] keys = new Object[size];
		Object[] values = new Object[size];
		
		for(int i = 0; i < size; i++) {
			keys[i] = new Object();
			values[i] = new Object();
		}
		
		int capacity = 50;
		BoundedConcurrentHashMap<Object, Object> boundedConcurrentHashMap = 
			new BoundedConcurrentHashMap<Object, Object>(capacity);
		
		for(int i = 0; i < capacity; i++) {
			boundedConcurrentHashMap.put(keys[i], values[i]);
		}
		
		for(int i = capacity; i < size; i++) {
			boundedConcurrentHashMap.put(keys[i], values[i]);
			assertEquals(null, boundedConcurrentHashMap.get(keys[i - capacity]));
			assertEquals(values[i], boundedConcurrentHashMap.get(keys[i]));
		}
	}

}