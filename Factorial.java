//recursive Factorial
import java.util.*;
class Factorial
{
	public static int factorial(int number)
	{
		if (number==0|| number==1)
			return 1;
		else 
			return number * factorial(number-1);
	}
	public static void main (String[] args)
	{
		int n, factOfn;
		System.out.println("Enter the number for which you want to find the Factorial Value:");
		Scanner sc= new Scanner(System.in);
		n= sc.nextInt();
		factOfn=factorial(n);
		System.out.println("The value of factorial is:"+ factOfn);
	}
}