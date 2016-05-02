import static org.junit.Assert.*;

import org.junit.Test;

public class testforset {
	
	setImplementation impl = new setImplementation(100);
	
	@Test
	public void testifnoelementinstart() {
		assertEquals(0, impl.size());
	}
	
	@Test
	public void testelementcanbeadded(){
		impl.add(2);
		assertEquals(1, impl.size());
	}
	
	@Test
	public void testelementcanbedeleted(){
		impl.add(3);
		impl.delete(0);
		assertEquals(0, impl.size());
	}
	
	@Test
	public void testduplicatesarenotadded(){
		impl.add(3);
		impl.add(3);
		impl.add(4);
		impl.add(5);
		impl.delete(2);
		impl.add(6);
		impl.add(6);
		impl.add(8);
		impl.add(9);
		impl.add(1);
		assertEquals(6, impl.size());
	}
	

}
