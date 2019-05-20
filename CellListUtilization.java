
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CellListUtilization {
	public static void main(String[] args) {
		CellList list1 = new CellList();
		CellList list2 = new CellList();
		CellList list3 = new CellList();
		String pathName = "Cell_Info.txt";
		File f = new File(pathName);
		FileInputStream fis = null;
		Scanner in = null;
		Scanner input = null;
		try {
			fis = new FileInputStream(f);
			in = new Scanner(fis);
			ArrayList<CellPhone> arr = new ArrayList<CellPhone>();
			//read the text
			while(in.hasNextLine()) {
				//read a line as a String
				String line = in.nextLine();
				//splits the line String with one or more spaces to a String array
				String[] s = line.split("\\s+");
				//converts the String to long variable
				long serialNum = Long.parseLong(s[0]);
				//converts the String to double variable
				double price = Double.parseDouble(s[2]);
				//transfer the String to integer variable
				int year = Integer.parseInt(s[3]);
				//creates CellPhone object
				CellPhone phone = new CellPhone(serialNum, s[1], year, price);
				//add the CellPhone object to the ArrayList
				arr.add(phone);
			}
			//traverse the ArrayList
			//if there exists CellPhone objects share same serial number, only reserves a single one;
			for(int i = 0; i < arr.size() -1; i++) {
				for(int j = arr.size() - 1; j > i; j--) {
					if(arr.get(i).getSerialNum() == arr.get(j).getSerialNum())
						arr.remove(j);
				}
			}
			//add the phone information to the list1
			for(CellPhone phone : arr) {
				list1.addToStart(phone);
			}
			

			
			//shows the details of the list
			list1.showContents();
			//find the phone with serial number
			System.out.println("\n---------------------------------------------------------------------------------\n");
			String numberList;
			do {
			input = new Scanner(System.in);
			System.out.print("Please enter a few serial numbers for which you want to search, enter -1 to end: ");
			numberList = input.nextLine();
			//converts the input String to Long array
			String[] numberString = numberList.split(" ");
			Long[] number = new Long[numberString.length];
			for(int i = 0; i < numberString.length; i++) {
				number[i] = Long.parseLong(numberString[i]);
			}
			//traverses the Long array to find the number of iterations performs
			for(long num : number) {
				if(!list1.contains(num))
					System.out.println(". No phone has the serial number: " + num);
				System.out.println("\n---------------------------------------------------------------------------------\n");
			}}while(!numberList.equals("-1"));
			
			
			System.out.println("****************************************");
			System.out.println("     Test constructors and methods");
			System.out.println("****************************************\n");
			//copy constructor of CellPhone class
			System.out.println("Test for CellPhone class:");
			CellPhone p1 = new CellPhone(1001, "Huawei", 2010, 300);
			CellPhone p2 = new CellPhone(p1, 1002);
			//clone method of CellPhone class
			CellPhone p3 = p2.clone(1003);
			CellPhone p4 = new CellPhone(1004, "Cat", 2015, 200);
			CellPhone p5 = new CellPhone(1005, "Dog", 2022, 300.4);
			CellPhone p6 = new CellPhone(1006, "bear", 2011, 266.4);
			CellPhone p7 = new CellPhone(1007, "Mount", 2011, 266.4);
			CellPhone p8 = new CellPhone(1008, "Summit", 2018,900);
			CellPhone p9 = new CellPhone(1009, "Wind", 2014, 666);
			//equals method of CellPhone class
			System.out.println(p1 + "><><><><><><" + p2 +  "><><><><><><" + p3 + "><><><><><><" + p4);
			System.out.println("p1 is euqal to p2 initializing by copy constructor: " + p1.equals(p2) + ". p2 is equal to p3 initializing by clone method: " + p2.equals(p3) + ". p3 is equal to p4: " + p3.equals(p4));
			System.out.println("^\n^\n^\n");
			//copy constructor of CellList class -- list2 copies list1
			System.out.println("Test for copy constructor of CellList class:");
			list2 = new CellList(list1);
			System.out.println("Initiate list2 with copy constructor list 1, list1 is euqal to list2: " + list1.equals(list2));
			System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>The Contents of List 1<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
			list1.showContents();
			System.out.println();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>The Contents of List 2<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
			list2.showContents();
			System.out.println("^\n^\n^\n");
			//method insertAtIndex() of CellList class
			System.out.println("test for methods of CellList class:");
			list3.addToStart(p1);
			list3.addToStart(p2);
			list3.addToStart(p3);
			list3.addToStart(p4);
			list3.showContents();
			//index is 0,index is size of list,intermediate index
			System.out.println("\ninsert a node at index 0");
			list3.insertAtIndex(p5, 0);
			list3.showContents();
			System.out.println("\ninsert a node at index 2");
			list3.insertAtIndex(p6, 2);
			list3.showContents();
			//method deleteFromStat() of CellList class
			System.out.println("\ndelete a node form the start");
			list3.deleteFromStart();
			list3.showContents();
			//method deleteFromIndex() of CellList class
			//index is 0,index is size of list,intermediate index
			System.out.println("\ndelete a node form index 3");
			list3.deleteFromIndex(3);
			list3.showContents();
			System.out.println("\ndelet the last node");
			list3.deleteFromIndex(3);
			list3.showContents();
			//method replaceAtIndex() of CellList class
			System.out.println("\nreplace the first node with p7");
			list3.replaceAtIndex(p7, 0);
			list3.showContents();
			System.out.println("\nrepalce the last node with p8");
			list3.replaceAtIndex(p8, 2);
			list3.showContents();
			System.out.println("\nreplace the second node with p9");
			list3.replaceAtIndex(p9, 1);
			list3.showContents();
			//method equals() of CellList class
			System.out.println("^\n^\n^\n");
			System.out.println("test for method equals() in CellList class:");
			System.out.println("list 1 is equal to list 2:"+list1.equals(list2));
			System.out.println("list 1 is equal to list 3:"+list1.equals(list3));
			CellList list4 = new CellList();
			CellList list5 = new CellList();
			list4.addToStart(p1);
			list4.addToStart(p4);
			list4.addToStart(p5);
			
			list5.addToStart(p2);
			list5.addToStart(p4);
			list5.addToStart(p5);
			System.out.println("CellPhone objects of list 4 and list 5 share same brand, price, and year but serial number. Are they euqal? "+list4.equals(list5));
//			CellList list6 = new CellList();
//			list6.addToStart(p2);
//			list6.addToStart(p5);
//			list6.addToStart(p4);
//			System.out.println("list 4 and list 6 have similar objects but different order. Are they equal? "+list4.equalsIgnoreOrder(list6));
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			input.close();
			in.close();
			System.out.println("\nThank you very much for using. The program has terminated");
		}
	}
}
