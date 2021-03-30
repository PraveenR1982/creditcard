package creditcard;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EligibilityController {
	
	

	
	@RequestMapping("/validate")
	public String validate(HttpServletRequest req, HttpServletResponse res)
	{
		String panno=req.getParameter("panno").toUpperCase();
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		Eligibilitydao dao=context.getBean("eligibilitydao",Eligibilitydao.class);  
	      
	    Eligibility score =  dao.check(panno);
	
		
		 String returnjsp = "";
		  if(score == null)
		   {
		   
				returnjsp ="Invalid";
			
			}
		  else  if(score.getScore()>=5) {
				
					returnjsp ="Eligible";}
		   else if(score.getScore()<5)
		   {
					returnjsp ="Not_Eligible";
		   }
			
		   
	      return returnjsp;
	   }
		
	
	}


