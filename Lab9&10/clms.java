class clms{
	public static void main(String[] args)
	{
		CEO ceo = new CEO();
		Manager manager = new Manager();
		VicePresident vp = new VicePresident();
		manager.setSuccessor(vp);  
		vp.setSuccessor(ceo);
		
		manager.approve(new Transaction("general", 150));
		
		
		
	}
}
class Manager extends TransactionProcessor
{
	protected double getApprovalLimit(){
		return 100000;
	};
	protected String getDesignation(){
		return "MANAGER";
	}
}
class VicePresident extends TransactionProcessor
{
	protected double getApprovalLimit(){
		return 1000000;
	};
	protected String getDesignation(){
		return "VICEPRESIDENT";
	}
}
class CEO extends TransactionProcessor
{
	protected double getApprovalLimit(){
		return 2500000;
	};
	protected String getDesignation(){
		return "CEO";
	}
}
abstract class TransactionProcessor{
	TransactionProcessor tp;
	protected abstract double getApprovalLimit();
	protected abstract String getDesignation();
	void setSuccessor(TransactionProcessor tp)
	{
		this.tp = tp;
		
	}
	void approve(Transaction t)
	{
		if(t.getAmount() <= 0.0)
		{
			System.out.println("not valid");
			
		}
		else if(t.getAmount()>2500000)
		{
			System.out.println("nobody can approve");
		}
		else
		{
				// 200000 <= 100000 -- first time  false
				//200000 <=100000
				// 200000 <= 100000
			if(t.getAmount() <= tp.getApprovalLimit())
			{
				System.out.println(tp);
				System.out.println(t.getAmount()+"is approved by "+tp.getDesignation());
			}
			else{
				tp.approve(t);
			}
			
			
			
			
			
		}
	}
	
	
	
	
	
}
class Transaction{
	double amount;
	String purpose;
	Transaction(String purpose, double amount)
	{
		this.purpose = purpose;
		this.amount = amount;
	}
	double getAmount()
	{
		return amount;
	}
}