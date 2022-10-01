

public interface Tree<T extends Comparable <T>> {   // this is the inferace any class that implements this interface must hact the following methods 
	
	Tree<T> insert (T data);
	
	void delete (T data);
	
	void traverse();
	
	T getMax();
	
	T getMin();
	
	boolean isEmpty();
	
	

}
