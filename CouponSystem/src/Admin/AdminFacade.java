package Admin;
import org.apache.derby.client.am.ClientTypes;
import Company.*;
import Customer.CustomerDBDAO;



/////////Class AdminFacade//////////////

public class AdminFacade  {
	
	/**Data members**/
    private  CompanyDBDAO companyDBDAO = new CompanyDBDAO();
    private CustomerDBDAO custDAO = new CustomerDBDAO();
    private String name = "admin";
    private String password = "1234";
    
   
    /**CTRS (constructors)**/
    
    public AdminFacade (){
    	
    }
    
    /**Methods**/
    
    public String getName() {
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
    
  
  public boolean Login (String name, String password, ClientTypes cType) throws Exception{
    	
    	if (name.equals(this.name) && password.equals(this.password))  {
    		return true;
    	}
    	return false;
      }
     }




	

	
	

	
	
	 
	
   

 
	  

	   
		


		