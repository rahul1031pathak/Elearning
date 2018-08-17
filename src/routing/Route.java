package routing;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.baswell.routes.RoutingTable;

public final class Route implements ServletContextListener {   
	
    
	   public void contextInitialized(ServletContextEvent event) {
		 
		   RoutingTable routingTable = new RoutingTable();
			routingTable.add(new class_operations(),new question_route()).build();
		
	    }          
        
	    public void contextDestroyed(ServletContextEvent event) {
	        // Webapp shutdown.
	    	// System.out.println("stop");
	    }
}
                         