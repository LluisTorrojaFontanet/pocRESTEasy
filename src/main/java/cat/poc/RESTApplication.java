package cat.poc;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class RESTApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public RESTApplication() {
		singletons.add(new RESTService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	
}