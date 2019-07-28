package demo09;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import demo09.simple.MyStack1;

public class MyStack1Test {
	@Test
	public final void testMyStack1() {
		Stack stack=new MyStack1();
		assertTrue(stack.isEmpty());		
	}
    @Test(expected=StackEmptyException.class)
	public final void testMyStack_�¶���POPӦ���׳��쳣() throws StackEmptyException {
    	Stack stack=new MyStack1();
		stack.pop();		
	}
    
    @Test(expected=StackEmptyException.class)
	public final void testMyStack_�¶���TOPӦ���׳��쳣() throws StackEmptyException {
    	Stack stack=new MyStack1();
		stack.top();		
	}
	@Test
	public final void testPush_�����ļ������ݺ�˳��_����ѹ�������() throws StackEmptyException {
		Stack stack=new MyStack1();
		stack.push("a");
		stack.push("bbbbbb");
		stack.push("CCC  cccCCC");
		assertFalse(stack.isEmpty());
		assertEquals("CCC  cccCCC",stack.pop());
		assertEquals("bbbbbb",stack.pop());
		assertEquals("a",stack.pop());
		assertTrue(stack.isEmpty());
	}
	@Test
	public final void testPush_����NULL_����NULL����() throws StackEmptyException {
		Stack stack=new MyStack1();
		stack.push(null);
		stack.push(null);
		assertFalse(stack.isEmpty());
		assertEquals(null,stack.pop());
		assertEquals(null,stack.pop());
		assertTrue(stack.isEmpty());
	}
	@Test
	public final void testPush_����մ�_���ؿ�() throws StackEmptyException {
		Stack stack=new MyStack1();
		stack.push("");
		stack.push("   ");
		stack.push("     ");
		assertFalse(stack.isEmpty());
		assertEquals("     ",stack.pop());
		assertEquals("   ",stack.pop());
		assertEquals("",stack.pop());
		assertTrue(stack.isEmpty());
	}
	
	@Test(expected=StackEmptyException.class)
	public final void testPop_��ʱ�׳��쳣() throws StackEmptyException {
		Stack stack=new MyStack1();
		stack.pop();
	}

	@Test(expected=StackEmptyException.class)
	public final void testPop_��ʱ�׳��쳣����Ȼ����ʹ��() {
		Stack stack=new MyStack1();
		try {
			stack.pop();
			fail("��ʱӦ���׳��쳣������û���׳�");
		} catch (StackEmptyException e) {			
			stack.push("a");
			assertFalse(stack.isEmpty());			
			e.printStackTrace();
		}
	}
	
	@Test(expected=StackEmptyException.class)
	public final void testPop_�Ѿ�����պ��׳��쳣() throws StackEmptyException {
		MyStack1 stack=new MyStack1();
		stack.push("a");
		stack.push("a");
		stack.push("a");
		stack.pop();
		stack.pop();
		stack.pop();
		//Ӧ���׳��쳣
		stack.pop();
	}
	
	@Test
	public final void testTop_��ȡѹ������ݵ��ǲ�ɾ��() throws StackEmptyException {
		MyStack1 stack=new MyStack1();
		stack.push("a");
		stack.push("bbbbbb");
		stack.push("CCC  cccCCC");
		
		assertFalse(stack.isEmpty());
		
		assertEquals("CCC  cccCCC",stack.top());
		
		stack.pop();
		assertEquals("bbbbbb",stack.top());
		
		stack.pop();
		assertEquals("a",stack.top());
		
		assertFalse(stack.isEmpty());
		stack.pop();
		assertTrue(stack.isEmpty());
	}
}