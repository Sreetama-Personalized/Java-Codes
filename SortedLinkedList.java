//Sorted Linked List Insertion
//While inserting find the proper place and then insert
//Compare with the previous and next element and place
import java.util.*;
import java.io.*;
import java.lang.*;
class SortedLinkedList
{
	Node head;
	static class Node
	{
		int _data;
		Node next;
		Node(int _d)
		{
			this._data=_d;
			next=null;
		}
	}
	public void SortInsertion(int _data)
	{
		Node _newNode= new Node(_data);
		boolean _flag=false;
		_newNode.next=null;
		if(head==null)//_newNode is the firstNode to be inserted
		{				
			head=_newNode;
		}
		else
		{
			Node _curr=head;
			Node _prev=head;
			if(_newNode._data<=head._data)//Set new head for the List
			{
				_newNode.next=head;
				head=_newNode;
			}
			else
			{
				while(_curr.next!=null)
				{
					//System.out.println("From while:");
					_prev=_curr;
					_curr=_curr.next;
					//System.out.println("Previous Node:  "+_prev._data);
					//System.out.println("Current Node:  "+_curr._data);
					if(_newNode._data>_prev._data && _newNode._data<_curr._data)
					{
						//System.out.println("From if:");
						_flag=true;//flag to check whether _newNode is to be inserted at the end of the list
						break;
					}
				}
				System.out.println("Flag is: "+_flag);				
				if(_flag)
				{
					_prev.next=_newNode;
					_newNode.next=_curr;
				}
				else
					_curr.next=_newNode;
			}
		}
		System.out.println("Sorting and insertion completed....");
		
	}
	public void viewSortedList()
	{
		Node _viewNode= head;
		System.out.println("Viewing Sorted List:");
		while(_viewNode!=null)
		{
						System.out.print(_viewNode._data+" ");
						_viewNode=_viewNode.next;
		}
		System.out.println("");
	}
	public static void main(String[] args)
	{
		System.out.println("The main funda of this program is to sort while inserting a node: ");
		int _data;
		SortedLinkedList _sorted= new SortedLinkedList();
		Scanner sc= new Scanner(System.in);
		while(true)
		{
			System.out.println("Press 1 to insert data, 2 to view, 3 to exit:");
			int _option=sc.nextInt();
			switch(_option)
			{
				case 1:	System.out.println("Please enter the data you want to insert: ");
						_data=sc.nextInt();						
						_sorted.SortInsertion(_data);
						break;
				case 2 : _sorted.viewSortedList();
						break;
				case 3: System.exit(0);
				default: System.out.println("Enter valid number.");
			}
		}
	}
}