package cr.ac.tec.apis;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import cr.ac.tec.filters.*;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rest/")
public class RestAPI extends Application {
	/**
	 *devuelve las clases que contienen cada API
	 */
	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> classList = new HashSet<>();
		classList.add(CORSFilter.class);
		classList.add(AdminResources.class);
		classList.add(UserResources.class);
		return classList;
	}	

}