//Linked List using Java
//Single linked List
import java.util.*;
import java.io.*;
import java.lang.*;
class SingleLinkedList
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
	//To view the SLL created
	public void viewSll()
	{
		Node viewNode= head;
		System.out.println("Viewing SLL:");
		while(viewNode!=null)
		{
						System.out.print(viewNode.data+" ");
						viewNode=viewNode.next;
		}
		System.out.println("");
					
	}
	//Insert at the end of the SLL
	public void InsertNodeAtEnd(int data)
	{
		Node insNode=new Node(data);
		insNode.next=null;
		if(head==null)//if this is the first node
		{
						head=insNode;
						return;
		}
		Node last=head;
		while(last.next!=null)//move to the last position
		{
						last=last.next;
		}
		last.next=insNode;                        
	}
	//Insert at the start of SLL
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
	//Insert at any position of SLL
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
			if(position>count+1||position<0)
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
	//Reverse the SLL
	public void reverseSll()
	{
		Node next=null;
		Node prev=null;
		Node current=head;
		while(current!=null)
		{
			next=current.next;//Move next a step
			current.next=prev;//reverse pointer
			prev=current;//Move prev a step
			current=next;//Move current a step
		}
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
		while(lastNode!=null)
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
		while(searchNode!=null)
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
		while(curr_x!=null && curr_x.data!=x)
		{
			prev_x=curr_x;
			curr_x=curr_x.next;
		}
		//track node which has value=y
		Node curr_y=head;
		Node prev_y=null;
		while(curr_y!=null && curr_y.data!=y)
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
	//Find nth node from the end of a Linked List
	public void searchNthNode(int pos)
	{
		if(head==null)
		{
			System.out.println("Empty List");
			return;
		}
		else
		{
			int count=getNodeCount();
			Node temp=head;
			if(pos<=count)
			{
			for(int i=0; i<(count-pos);i++)
			{
				temp=temp.next;
			}
			System.out.println("Data in "+pos+"th node from end is: "+temp.data);
			}
			else
			{
				System.out.println("position should be in between 0 and "+count);
			}
		}
	}
	public boolean IsListHaveLoop()
	{
		Node fastMove=head;
		Node slowMove=head;
		while(slowMove!=null && fastMove!=null && fastMove.next!=null)
		{
			slowMove=slowMove.next;
			fastMove=fastMove.next.next;
			if(slowMove==fastMove)
				return true;
		}
		return false;		
	}
	public void findBeginOfLoop()
	{
		Node fastMove=head;
		Node slowMove=head;
		boolean IsListHaveLoop=false;
		while(slowMove!=null && fastMove!=null && fastMove.next!=null)
		{
			slowMove=slowMove.next;
			fastMove=fastMove.next.next;
			if(slowMove==fastMove)
				IsListHaveLoop=true;
		}			
		if(IsListHaveLoop)
		{
			while(slowMove!=fastMove)
			{				
				fastMove=fastMove.next;
				slowMove=slowMove.next;
			}
			System.out.println("Begininning of the loop: "+slowMove.data);
		}
		else
			System.out.println("List dsnt hv loop!!!");
	}
	public void lengthOfLoop()
	{
		Node fastMove=head;
		Node slowMove=head;
		boolean IsListHaveLoop=false;
		while(slowMove!=null && fastMove!=null && fastMove.next!=null)
		{
			slowMove=slowMove.next;
			fastMove=fastMove.next.next;
			if(slowMove==fastMove)
				IsListHaveLoop=true;
		}			
		if(IsListHaveLoop)
		{
			int count=0;
			fastMove=fastMove.next;
			while(slowMove!=fastMove)
			{				
				fastMove=fastMove.next;
				count++;
			}
			System.out.println("Length of the loop: "+count);
		}
		else
			System.out.println("List dsnt hv loop!!!");
		
	}
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		SingleLinkedList sll= new SingleLinkedList();
		int data, position, key,position_new, count,x,y;
		boolean listHasLoop;
		while(true)//Options will come until user wants to exit from the program
		{
			System.out.println("Press 1 for inserting at end, 2 for insert at front, 3 insert at any position, 4 for key deletion, 5 for deletion from a position,6 for viewing, 7 for reversal,8 to delete the Linked List, 9 to get the total number of nodes, 10 to search an element, 11 to swap two elements, 12 to exit, 13 to search nth node from end:, 14 to check whether the list has loop, 15 to find the beginning of loop, 16 to find length of the loop:");
			int option=sc.nextInt();
			switch(option)
			{
				case 1: System.out.println("Enter the data you want to insert:");
						data=sc.nextInt();
						sll.InsertNodeAtEnd(data);
						break;
				case 2: System.out.println("Enter the data you want to insert:");
						data=sc.nextInt();
						sll.InsertNodeAtFront(data);
						break;
				case 3: System.out.println("Enter the data you want to insert:");
						data=sc.nextInt();
						System.out.println("Enter the position to insert:");
						position=sc.nextInt();
						sll.InsertNodeAtAny(data,position);
						break;
				case 4: System.out.println("Enter the key to delete:");
						key=sc.nextInt();
						sll.DeleteUsingKey(key);
						break;
				case 5: System.out.println("Enter the position to delete:");
						position_new=sc.nextInt();
						sll.DeleteFromPosition(position_new);
						break;
				case 6: sll.viewSll();
						break;
				case 7: sll.reverseSll();
						break;
				case 8: sll.delLinkedList();
						break;
				case 9: count=sll.getNodeCount();
						System.out.println("The total Number of Nodes present in the single Linked List is: "+count);
						break;
				case 10:System.out.println("Plaese enter the key you want to search");
						key= sc.nextInt();
						sll.searchKey(key);
						break;
				case 11:sll.viewSll();
						System.out.println("Now enter the keys to swap:");
						x=sc.nextInt();
						y=sc.nextInt();
						sll.swapNodes(x,y);
						break;
				case 12: System.exit(0);
				case 13:System.out.println("Enter the postion for nth node from end which you want to search:");
						position=sc.nextInt();
						sll.searchNthNode(position);
						break;
				case 14:listHasLoop=sll.IsListHaveLoop();
						if(listHasLoop)
							System.out.println("List has loop");
						else
							System.out.println("List does not have loop");
						break;
				case 15: sll.findBeginOfLoop();
						break;
				case 16:sll.lengthOfLoop();
						break;
				default: System.out.println("Please enter a valid number:");
						break;
				}
			}
	}
}	