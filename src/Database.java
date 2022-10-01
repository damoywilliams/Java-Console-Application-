/**
 *
 * @author (Damoy Williams)
 * @version (a version 7)
 */

import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.Scanner;

public class Database {
	MyBST <String>my= new MyBST<String>();   // TO store the keys
	Comparable key;
	LinkedList <String> keys = new LinkedList<>();


	public void start(){
		System.out.println();
		Database d = new Database();
		d.load();
		System.out.println("For Exact qeury please enter 1"+"\n"+"For Range query please enter 2"+"\n"+"For Min value please enter 3"+"\n"+"For Max value please enter 4"+"\n");
		Scanner myObja = new Scanner(System.in); 
		String response = myObja.nextLine();  



		if(response.equals("1")) {
			try {
				System.out.println("Available keys"+"\n");
				System.out.println(d.keys+"\n");  
				System.out.println("Please enter college you wish to search for, refer to keys above"+"\n");

				String college=myObja.nextLine();
				d.my.searchh(college);
			} catch(Exception e) {System.out.println("please enter a valid key");}

			start();


		} else if(response.equals("2")) {
			try {
				System.out.println("For range query, Please enter the min value for the start of the  range followed by the max value for the end of the range of colleges you wish to see, must be uppercase" );
				char c = myObja.next(".").charAt(0);
				String convertC=String.valueOf(c); 
				System.out.println("second lettter");
				char b = myObja.next(".").charAt(0);
				String convertB=String.valueOf(b); 
				System.out.println();
				d.my.range(convertC, convertB);
			} catch(Exception e) {System.out.println("please enter a valid key");}
			start();
		} 

		else if(response.equals("3")) {
			try {
				d.my.getMin();
			} catch(Exception e) {System.out.println("please enter a valid key");}
			start();
		}


		else if(response.equals("4")) {
			try {
				d.my.getMax();

			} catch(Exception e) {System.out.println("please enter a valid key");}
			start();
		}


	}

	public void load(){               //add values to the BST 
		try{
			RandomAccessFile reading1 = new RandomAccessFile("generatedBinary.dat","r");
			RandomAccessFile index1 = new RandomAccessFile("index.dat","r");

			for (int i = 0, j = 0; i <=index1.length() || j<=reading1.length(); i+=38, j+=92){
				reading1.seek(j); 
				index1.seek(i);
				String key = index1.readUTF();

				key = key.replaceAll("\\s", "");

				keys.add(key);

				reading1.seek(j);
				reading1.readUTF(); 
				String data=key+"  "+" private  "+ reading1.readUTF().replaceAll("\\s", "")+"  applied  "+reading1.readInt()+"  accepted  "+reading1.readInt()+"  enrolled  "+reading1.readInt()+ "  GradRate   "+reading1.readInt()+"%";

				my.insert(data);

			}}catch(Exception e){}
	}

	public static void main(String[] args) {
		binary bin= new binary();
		bin.textToBinary("college.txt");
		bin.index();
		Database db = new Database();
		db.start();
	}



}
