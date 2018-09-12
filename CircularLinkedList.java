//Linked List using Java
//Single linked List
import java.util.*;
import java.io.*;
import java.lang.*;
class CircularLinkedList
{
	Node head;
	static class Node//This Node class will be accessed from different methods. This class frames the structure of a node of a single Linked List.
	{
		int data;// data holds the value of the node
		Node next;//next is the pointer to point the next node of the Linked list
		Node(int d)//Constructor of Node Class
		{ 
		this.data=d;
		next=null;
		}
	}
	//To view the CLL created
	public void viewCll()
	{
		Node viewNode= head;
		System.out.println("Viewing CLL:");
		if(head!=null)
		{
			do
			{
				System.out.print(viewNode.data+"->-");
				viewNode=viewNode.next;
			}while(viewNode!=head);//Check if the current node is the head node
			System.out.print(viewNode.data+" ");
		}
		System.out.println("");		
	}
	//Insert at the end of the CLL
	public void InsertNodeAtEnd(int data)
	{
		Node insNode=new Node(data);
		insNode.next=insNode;//Let the new node  to point to itself
		Node last=head;
		//while(last.next!=head && head!=null)//Move to the last node of the list
			//last=last.next;
		if(head==null)//if this is the first node 
		{
			head=insNode;			
		}
		else
		{
			while(last.next!=head)
			{
				last=last.next;
			}
			insNode.next=head;
			last.next=insNode;
		}
			
	}
	
	//Insert at the start of CLL
	public void InsertNodeAtFront(int data)
	{
		Node insNode=new Node(data);
		if(head==null)//if this is the first node 
		{
			head=insNode;
			return;
		}
		insNode.next=head;
		head=insNode;//make the newly inserted node as head		
	}
	//Insert at any position of CLL
	public void InsertNodeAtAny(int data, int position)
	{
		Node insNode=new Node(data);
		int count=getNodeCount();
		if((head==null))//if this is the first node 
		{
			head=insNode;
			return;
		}
		Node node = head;
		if(position==1)//if position is the first position
		{
			InsertNodeAtFront(data);
			return;
		}		
		else 
		{
			if(position>count||position<0)
			{
				System.out.println("Position should be in between 1 to "+count+". Please try again by pressing 3.");
				return;
			}
			else
			{				
				for(int i=1; i<position-1;i++)//Point to the position where you want to insert the data
				{
					node=node.next;
				}
				insNode.next=node.next;
				node.next=insNode;
			}
		}
	}
	//Delete the node for which you know the key value
	public void DeleteUsingKey(int key)
	{				
		Node temp=head;
		Node prev=null;
		if(temp==null)
		{
			System.out.println("Cannot be deleted; empty linked List.");
			return;
		}
		if (temp != null && temp.data == key) 
		{  
			head = temp.next;  
			return;  
		}  
		while (temp != null && temp.data != key)
		{  
			prev = temp;  
			temp = temp.next;  
		}  		 
		prev.next = temp.next;  		
	}
	//Delete a node mentioning its position
	public void DeleteFromPosition(int position)
	{
		Node temp=head;		
		if(temp==null)
		{
			System.out.println("Cannot be deleted empty linked List.");
			return;
		}	
		if(position==1)//delete from 1st position
		{
			head=temp.next;
			return;
		}
		else//Delete from any position
		{
			for (int i =1; temp!=null && i<position-1;i++)
			{				
				temp=temp.next;				
			}
			Node next=temp.next.next;
			temp.next=next;
		}		
	}
	//Reverse the CLL
	public void reverseCll()
	{
		Node next=null;
		Node prev=null;
		Node current=head;
		while(current!=head)
		{
			next=current.next;//Move next a step
			current.next=prev;//reverse pointer
			prev=current;//Move prev a step
			current=next;//Move current a step
		}
		head.next=prev;
		head=prev;		
	}
	//Delete the whole Linked List
	public void delLinkedList()
	{
		System.out.println("Deleting the Linked List, are you sure to delete? Press y if you want to delete.");
		Scanner sc= new Scanner(System.in);
		char warning= sc.next().charAt(0);
		head=null;
	}
	//Get node count
	public int getNodeCount()
	{
		int count=0;
		Node lastNode=head;
		while(lastNode!=head)
		{
			count++;
			lastNode=lastNode.next;
		}
		return count;
	}
	//Search a key
	public void searchKey(int key)
	{
		Node searchNode=head;		
		boolean flag=false;
		int count=getNodeCount();//Returns the length of the Linked List
		while(searchNode!=head)
		{
			for(int i=1;i<=count;i++)
			{
				if(key==searchNode.data)
				{
					System.out.println("Key found at position: "+i);
					flag=true;					
					return;
				}
				searchNode=searchNode.next;//If key not found move to next node
			}
		}
		if(flag==false)
		{
			System.out.println("Key not found.");
		}
					
	}
	//Swaping two nodes
	public void swapNodes(int x, int y)
	{
		if(x==y)//If x and y are same do nothing
			return;
		//track node which has value=x
		Node curr_x=head;
		Node prev_x=null;
		while(curr_x!=head && curr_x.data!=x)
		{
			prev_x=curr_x;
			curr_x=curr_x.next;
		}
		//track node which has value=y
		Node curr_y=head;
		Node prev_y=null;
		while(curr_y!=head && curr_y.data!=y)
		{
			prev_y=curr_y;
			curr_y=curr_y.next;
		}
		if(curr_x==null || curr_y==null)
			return;
		if(prev_x!=null)
			prev_x.next=curr_y;
		else
			head=curr_y;
		if(prev_y!=null)
			prev_y.next=curr_x;
		else
			head=curr_x;
		//swap two pointers
		Node temp=curr_x.next;
		curr_x.next=curr_y.next;
		curr_y.next=temp;
	}
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		CircularLinkedList cll= new CircularLinkedList();
		int data, position, key,position_new, count,x,y;
		while(true)//Options will come until user wants to exit from the program
		{
			System.out.println("Press 1 for inserting at end, 2 for insert at front, 3 insert at any position, 4 for key deletion, 5 for deletion from a position,6 for viewing, 7 for reversal,8 to delete the Linked List, 9 to get the total number of nodes, 10 to search an element, 11 to swap two elements, 12 to exit:");
			int option=sc.nextInt();
			switch(option)
			{
				case 1: System.out.println("Enter the data you want to insert:");
						data=sc.nextInt();
						cll.InsertNodeAtEnd(data);
						break;
				case 2: System.out.println("Enter the data you want to insert:");
						data=sc.nextInt();
						cll.InsertNodeAtFront(data);
						break;
				case 3: System.out.println("Enter the data you want to insert:");
						data=sc.nextInt();
						System.out.println("Enter the position to insert:");
						position=sc.nextInt();
						cll.InsertNodeAtAny(data,position);
						break;
				case 4: System.out.println("Enter the key to delete:");
						key=sc.nextInt();
						cll.DeleteUsingKey(key);
						break;
				case 5: System.out.println("Enter the position to delete:");
						position_new=sc.nextInt();
						cll.DeleteFromPosition(position_new);
						break;
				case 6: cll.viewCll();
						break;
				case 7: cll.reverseCll();
						break;
				case 8: cll.delLinkedList();
						break;
				case 9: count=cll.getNodeCount();
						System.out.println("The total Number of Nodes present in the single Linked List is: "+count);
						break;
				case 10: System.out.println("Plaese enter the key you want to search");
						key= sc.nextInt();
						cll.searchKey(key);
						break;
				case 11:cll.viewCll();
						System.out.println("Now enter the keys to swap:");
						x=sc.nextInt();
						y=sc.nextInt();
						cll.swapNodes(x,y);
						break;
				case 12: System.exit(0);
				default: System.out.println("Please enter a valid number:");
						break;
			}	
		}	
	}
}	