import javax.print.DocFlavor.STRING;

public class MyBST<T extends Comparable<T>> implements Tree<T> {

	public class Node<T extends Comparable<T>>	{  //T is the generic type and T also estends Comparable

		private  T data;
		private Node<T> leftchild;
		private Node<T> rightchild;





	}

	private Node<T> root;

	public boolean isEmpty() {
		return root==null;
	}


	public T getMin() {
		if (isEmpty()==true) return null;
		T t=hgetMin(root);
		//System.out.println(t);
		return t;
	}

	private T hgetMin(Node<T> here) {
		// TODO Auto-generated method stub
		if(here.leftchild!=null) {

			hgetMin(here.leftchild);
		}


		else System.out.println(here.data);

		return here.data;
	}


	public T getMax() {
		if (isEmpty()==true) return null;

		return getMax(root);
	}

	private T getMax(Node<T> root) {
		// TODO Auto-generated method stub
		if(root.rightchild!=null) {

			getMax(root.rightchild);
		}

		else System.out.println(root.data);
		return root.data;
	}

	public void traverse() {
		traverseInOrder(root);


	}


	private void traverseInOrder(Node<T> root) {
		// TODO Auto-generated method stub
		if(root!=null) {
			traverseInOrder(root.leftchild);
			System.out.println(root.data);
			traverseInOrder(root.rightchild);	
		}
	}

	public Tree<T> insert(T data) {                    
		if(isEmpty()==true) {                      //check to see if tree is empty 


			root = new Node<T>(); root.data= data;}    //if tree is empty just make new node at the root 

		else { insert(data,root);}             //else call our helper method 

		return this;
	}


	private void insert(T data, Node<T> node) {   //the helper method 
		// TODO Auto-generated method stub
		if(data.compareTo(node.data)<0) {   //check to see if value is less than that of the root value

			if(node.leftchild==null) {       //if it is and there is no leftchild  put it there 
				node.leftchild=new Node<T>(); node.leftchild.data=data;
			} else {                         //if there is a left child   we need to compare again

				insert(data,node.leftchild);
			}

		}else if(data.compareTo(node.data)>0) {   // same concept as above 

			if(node.rightchild==null) {
				node.rightchild=new Node<T>(); node.rightchild.data=data;
			} else {

				insert(data,node.rightchild);
			}


		}
	}

	public void delete (T data) {

		root=delete(data,root);

	}


	private Node<T> delete(T data, Node<T> root) {
		// TODO Auto-generated method stub
		if (root==null) {return null;}   //if root is empty we can't do nothing

		if(data.compareTo(root.data)<0) {        //check to see if value is less than that of the root value
			root.leftchild=(delete(data,root.leftchild));  // call delete on the leftchild recursively 

		} else if (data.compareTo(root.data)>0) {      //same concept as above 
			root.rightchild=(delete(data,root.rightchild));

		}

		else {     // if we are here then we found the  child to be deleted 

			// ONE child     
			if(root.leftchild==null) {  // if that node have one child return that node 
				return root.rightchild;


			}else if(root.rightchild==null) {   // if that node have one child return that node 
				return root.leftchild;
			}

			// TWO children                         //if that node has two children 
			root.data=(getMax(root.leftchild));               //get the max 
			root.leftchild=(delete(root.data,root.leftchild)); 
		}

		return root;
	}


	public void searchh(T data) {
		if (root==null) {return ;}
		searchh(data,root);

		// return s.data ;

	}


	private void searchh(T key,Node<T> root) {
		if (root==null) { System.out.println("NOT FOUND");return;}
		String k= (String) root.data;           //rootdata only the nsme 
		//System.out.println(k);
		int l =((String) key).length();
		String n=first(l,k);                    ///rootdata only the nsme n
		//System.out.println(n);


		if (key.compareTo((T) n)<0) {        //check to see if value is less than that of the root value

			searchh(key,root.leftchild);  // call delete on the leftchild recursively 

		} else if (key.compareTo((T) n)>0) {      //same concept as above 
			searchh(key,root.rightchild);

		}

		else {     // if we are here then we found the  child 
			if((key.compareTo((T) n)==0)) {
				System.out.println(root.data);}


		}


	}

	private String first(int l, String data) {
		if(l>data.length())return data;
		return data.substring(0, l);

	}

	public void range(T lo,T high) {

		if (root==null) {return ;}
		range(lo,high,root);




	}

	private void range(T lo, T high,Node<T> root) {
		// TODO Auto-generated method stub
		if (root==null) {
		System.out.println("Invalid range please enter only one letter for min and one letter for max. Must be uppercase");
			return ;}
		int cmpLow = lo.compareTo(root.data);
		int cmpHigh = high.compareTo(root.data);

		if(cmpLow<0) {    // root is higher than range so go left

			range(lo,high,root.leftchild);

		}
		if  (cmpLow <= 0 && cmpHigh >= 0) {       // if in range print 


			System.out.println(root.data);
		}

		if(cmpHigh > 0) {                        // if high range is not met then go further


			range(lo,high,root.rightchild);

		}
	}

}
