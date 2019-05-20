import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class CellList {
	private class CellNode {
		private CellPhone phone;
		private CellNode next;

		/**
		 * default constructor that assigns two attributes to null
		 */
		public CellNode() {
			phone = null;
			next = null;
		}

		/**
		 * parameterized constructor
		 * 
		 * @param phone CellPhone
		 * @param next CellNode
		 */
		public CellNode(CellPhone phone, CellNode next) {
			this.phone = phone;
			this.next = next;
		}

		/**
		 * copy constructor
		 * 
		 * @param node CellNode
		 */
		public CellNode(CellNode node) {
			this.phone = node.phone;
			this.next = node.next;
		}

		/**
		 * methods that creates a new object and assigns the value of attributes of
		 * passed object to it
		 * @return CellNode
		 */
		public CellNode clone() {
			return new CellNode(this.phone, this.next);
		}

		/**
		 * accessor that gets the value of phone
		 * 
		 * @return phone
		 */
		public CellPhone getPhone() {
			return phone;
		}

		/**
		 * mutator that sets the value of phone
		 * 
		 * @param phone CellPhone object
		 */
		public void setPhone(CellPhone phone) {
			this.phone = phone;
		}

		/**
		 * accessor that gets the value of next
		 * 
		 * @return next
		 */
		public CellNode getNext() {
			return next;
		}

		/**
		 * mutator that sets the value of next
		 * 
		 * @param next CellNode
		 */
		public void setNext(CellNode next) {
			this.next = next;
		}
	}// end of CellNode class

	private CellNode head;
	private int size = 0;

	/**
	 * default constructor
	 */
	public CellList() {
		head = null;
	}

	/**
	 * copy constructor
	 * 
	 * @param list CellList
	 */
	public CellList(CellList list) {
		this.head = list.head;
		this.size = list.size;
	}

	/**
	 * method that add node to the beginning, the added node will be the first node
	 * 
	 * @param phone CellPhone Object
	 */
	public void addToStart(CellPhone phone) {
		head = new CellNode(phone, head);
		size++;
	}

	/**
	 * method that add node in the end
	 * 
	 * @param phone CellPhone Object
	 */
	public void addToEnd(CellPhone phone) {
		// creates a node with "null" next node
		CellNode node = new CellNode(phone, null);
		CellNode current;
		if (head == null) {// add the head node
			head = node;
		} else {
			current = head;
			// traverse the list to find the last node
			while (current.next != null) {
				current = current.next;
			}
			// change the last node's pointer to the new node
			current.next = node;
		}
		size++;
	}

	/**
	 * method that adds a node in the specified index
	 * 
	 * @param phone CellPhone object
	 * @param index index you want to insert
	 * @throws NoSuchElementException thrown if the index is invalid
	 */
	public void insertAtIndex(CellPhone phone, int index) throws NoSuchElementException {
		CellNode previous;
		CellNode current = null;
		CellNode node = new CellNode(phone, null);
		if (phone == null) {
			System.out.println("Please initiate the CellPhone");
		} else if (index >= 0 && index <= size - 1 && phone != null) {
			if (index == 0)
				addToStart(phone);
			else if (index == size - 1)
				addToEnd(phone);
			else {
				previous = head;
				current = previous.next;
				// find the front node of the node with specified index with for loop
				for (int i = 0; i < index - 1; i++) {
					previous = previous.next;
					current = previous.next;
				}
				// assigns the added node to the next of (index-1) node
				previous.next = node;
				// assigns the previous index node to the next of added node
				node.next = current;
				size++;
			}
		} else {
			throw new NoSuchElementException("The index is invalid, and the program will terminate!!!");
		}
	}

	/**
	 * method that delete the node with specified index
	 * 
	 * @param index index of the list
	 */
	public void deleteFromIndex(int index) {
		CellNode previous;
		if (index >= 0 && index <= size - 1) {
			if (head != null) {
				// remove the first node
				if (index == 0) {
					head = head.next;
				} else if (index == size - 1) {
					previous = head;
					while (previous.next != null) {
						if (previous.next.next == null) {
							previous.next = null;break;}
						previous = previous.next;
					}
				} else {
					previous = head;
					for (int i = 0; i < index - 1; i++) {
						previous = previous.next;
					}
					previous.next = previous.next.next;
				}
				size--;
			} else {
				System.out.println("the list is empty");
			}
		} else {
			throw new NoSuchElementException("The index is invalid, and the program will terminate!!!");
		}
	}

	/**
	 * method that removes the first node of list
	 */
	public void deleteFromStart() {
		if (head != null) {
			head = head.next;
			size--;
		} else {
			System.out.println("The list is empty");
		}
	}

	/**
	 * method that replaces the node with passed index
	 * 
	 * @param phone CellPhone Object 
	 * @param index index of list
	 */
	public void replaceAtIndex(CellPhone phone, int index) {
		CellNode previous;
		CellNode after = null;
		CellNode node = new CellNode(phone, null);
		if (index >= 0 && index <= size - 1) {
			if (phone == null)
				System.out.println("No changes since the CellPhone object is not intiatialized");
			else if (index == 0) {
				previous = head;
				node.next=previous.next;
				head=node;
			}
			else if (index == size - 1) {
				previous = head;
				while(previous.next.next != null) {
					previous = previous.next;
				}
				previous.next = node;
				}
			else {
				previous = head;
				after = previous.next.next;
				for (int i = 0; i < index - 1; i++) {
					previous = previous.next;
					after = previous.next.next;
				}
				previous.next = node;
				node.next = after;
			}
		} else {
			System.out.println("No changes since the index is invalid");
		}
	}

	/**
	 * method that finds the details of CellPhone with serial number
	 * @param serialNum serial number
	 * @return return a node
	 */
	public CellNode find(long serialNum) {
		boolean flag = true;
		CellNode pointer = head;
		int iterations = 0;
		long num;
		// traverse the list
		while (pointer != null) {
			iterations++;
			// get the current node's serial number
			num = pointer.getPhone().getSerialNum();
			if (num == serialNum) {
				System.out.print(iterations + " iteration(s) is/are made before finding the phone: ");
				System.out.println(pointer.getPhone());
				flag = false;
				return pointer;
			}
			pointer = pointer.next;
		}
		if(flag)
			System.out.print(iterations + "iterations performed");
		return null;
	}

	/**
	 * methods that returns true if there exists a node containing the specific
	 * serial number
	 * 
	 * @param serialNum serial number
	 * @return true if the list contains the serial number
	 */
	public boolean contains(long serialNum) {
		return find(serialNum) != null;
	}

	/**
	 * method that displays the details of the list
	 */
	public void showContents() {
		int count = 0;
		System.out.println("The current size of the list is " + size + " . Here are the contents of the list");
		System.out.println("================================================================================");
		/// String contents = "";
		CellNode current = head;
		if (head == null) {
			System.out.println("the list is empty");
		} else {
			while (current != null) {
				System.out.print(current.getPhone().toString() + " ---> ");
				count++;
				if (count % 3 == 0)
					System.out.println();
				if (current.next == null) {
					System.out.println("X");
					break;
				}
				current = current.next;
			}
		}
	}
	
	public boolean equals(CellList list) {
		boolean flag = true;
		if(list == null) {
			return false;
		}else if(this.size==list.size) {
			CellNode thisCurrent = this.head;
			CellNode listCurrent = list.head;
			while(thisCurrent.next != null) {
				if(!thisCurrent.phone.equals(listCurrent.phone)) {
					flag = false;
					break;
				}
				thisCurrent = thisCurrent.next;
				listCurrent = listCurrent.next;
			}
			return flag;
		}else
			return false;
	}
	
	public boolean equalsIgnoreOrder(CellList list) {
		int count = 0;
		if(this.size != list.size)
			return false;
		else {
			CellNode thisCurrent = this.head;
			CellNode listCurrent = list.head;
			List<CellPhone> thislist = new ArrayList<CellPhone>();
			List<CellPhone> listlist = new ArrayList<CellPhone>();
			while(thisCurrent != null) {
				thislist.add(thisCurrent.phone);
				thisCurrent = thisCurrent.next;
				listlist.add(listCurrent.phone);
				listCurrent = listCurrent.next;
			}
			for(int i = 0; i < thislist.size(); i++) {
				for(int j = 0; j < listlist.size(); j++) {
					if(thislist.get(i).equals(listlist.get(j))) {
						count++;
						listlist.remove(j);
						break;
					}
				}
			}
		return (count==thislist.size());}
	}

}
