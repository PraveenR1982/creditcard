package creditcard;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;


import creditcard.Eligibility;

public class Eligibilitydao {
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}   
	
	public void saveCC(Eligibility credit){  
	    template.save(credit);  
	} 
	
	public Eligibility check(String panNo){  
		Eligibility credit=(Eligibility)template.get(Eligibility.class,panNo);  
	    return credit;  
	}  
	
	
	
}
