import java.util.Scanner;

class Primes
{
	private int a,b;
	public int get_a()
	{
		return this.a;
	}
	public int get_b()
	{
		return this.b;
	}
	public void set_a(int a)
	{
		this.a=a;
	}
	public void set_b(int b)
	{
		this.b=b;
	}
	Primes(int x,int y)
	{
			set_a(x);
			set_b(y);
	}
	boolean checkPrime(int x)
    {
        if(x<=1)
        {
            return false;
        }
       for(int i=2;i<=x/2;i++)
       {
           if((x%i)==0)
               return  false;
       }
       return true;
    }
	public int isPrime()
	{
		boolean a_check=checkPrime(this.a);
		boolean b_check=checkPrime(this.b);
		if(a_check==false && b_check==false)
		{
			return 0;
		}
		else if(a_check==true && b_check==false)
		{
			return 1;
		}
		else if(a_check==false && b_check==true)
		{
			return 2;
		}
		else
		{
			if(((int)Math.abs(this.a-this.b))!=2)
			{
				return 3;
			}
			else
			{
				return 4;
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter 2 integers : \nEnter value of a : ");
		int a=scan.nextInt();
		System.out.println("Enter value of b : ");
		int b=scan.nextInt();
		Primes p=new Primes(a,b);
		/*
		//To view the nos:
		System.out.println("Value of a is : "+p.get_a());
		System.out.println("Value of b is : "+p.get_b());
		*/
		System.out.println("Result : "+p.isPrime());
	}
}