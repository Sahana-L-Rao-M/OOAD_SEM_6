import java.util.*;

class leave_man{
	public static void main(String[] args)
	{
		LeaveProcessorFactory factory = new LeaveProcessorFactory();
		TechLead tlead = (TechLead)factory.createProcessor("TECHLEAD");
		ProjectManager pm = (ProjectManager)factory.createProcessor("PROJECT MANAGER");
		Director dir = (Director)factory.createProcessor("DIRECTOR");
		
		tlead.setSuccessor(pm);  
		pm.setSuccessor(dir);
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of employees: ");  
		int a= sc.nextInt(); 

		while(a!=0)
		{
			a=a-1;
			
			System.out.print("Enter leave type: ");  
			String leavetype= sc.next();
			
			System.out.print("Enter employee name: ");  
			String empname= sc.next();
			 
			String leavestatus= "NEW";
			
			System.out.print("Enter request date: ");  
			String rdate= sc.next();
			
			String leavereason="NotApplicable";
			String sdate="Not Applicable";
			String edate="Not Applicable";
			
			if(leavetype.equals("CL"))
			{
				System.out.print("Enter reason: ");  
				leavereason= sc.next();
			}
			else if(leavetype.equals("VL"))
			{
				System.out.print("Enter start date : ");  
				sdate= sc.next();
				System.out.print("Enter end date : ");  
				edate= sc.next();
			}
			tlead.approve(new EmployeeLeave(leavetype,empname,leavestatus,rdate,leavereason,sdate,edate));
		}	
	}
}
class LeaveProcessorFactory {
    public EmployeeLeaveProcessor createProcessor(String type) {
        if(type.equals("TECHLEAD")) {
            return new TechLead();
        }
        else if(type.equals("PROJECT MANAGER")) {
            return new ProjectManager();
        }
        else if(type.equals("DIRECTOR")) {
            return new Director();
        }
        return null;
    }
}

class TechLead extends EmployeeLeaveProcessor
{
	protected String getApprovalLimit(){
		return "SL";
	};
	protected String getDesignation(){
		return "TECHLEAD";
	}
}
class ProjectManager extends EmployeeLeaveProcessor
{
	protected String getApprovalLimit(){
		return "CL";
	};
	protected String getDesignation(){
		return "PROJECT MANAGER";
	}
}
class Director extends EmployeeLeaveProcessor
{
	protected String getApprovalLimit(){
		return "VL";
	};
	protected String getDesignation(){
		return "Director";
	}
}
abstract class EmployeeLeaveProcessor{
	EmployeeLeaveProcessor tp;
	protected abstract String getApprovalLimit();
	protected abstract String getDesignation();
	void setSuccessor(EmployeeLeaveProcessor tp)
	{
		this.tp = tp;
		
	}
	void approve(EmployeeLeave t)
	{
		if((t.getleavetype()).equals(this.getApprovalLimit()))
		{
			t.approvedBy=this.getDesignation();
			t.leaveStatus="Done";
			t.approvalDate=t.requestDate;
			System.out.println("\n*********************\n");
			System.out.println(t.getleavetype()+" is approved by "+this.getDesignation());
			System.out.println("\nThe details of the employees are as follows:\n"+
		"Employee name : "+t.empName+"\nLeave Status : "+t.leaveStatus+"\nRequest Date : "+t.requestDate+"\nLeave Reason : "+t.leavereason
		+"\nStart Date : "+t.sdate+"\nEnd Date : "+t.edate);
			System.out.println("\n*********************\n");
		}
		else
		{
			tp.approve(t);
		}
	}
}

class EmployeeLeave{
	public String leavetype;
	public String empName;
	public String leaveStatus="New";
    public String approvedBy;
	public String requestDate;
	public String approvalDate;
	public String leavereason;
	public String sdate;
	public String edate;
	EmployeeLeave(String leavetype,String empName,String leaveStatus,String requestDate,String leavereason,String sdate,String edate)
	{
		this.leavetype=leavetype;
		this.empName=empName;
		this.leaveStatus=leaveStatus;
		this.requestDate=requestDate;
		this.leavereason=leavereason;
		this.sdate=sdate;
		this.edate=edate;
	}
	String getleavetype()
	{
		return leavetype;
	}
}