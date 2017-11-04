package cat.poc;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cat.poc.client.EJBClient;

@Path("/service")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_HTML)
public class RESTService {

	@GET
	@Path("/doTheJob")
	public Response doTheJob(@QueryParam("param") String param) {
		String resultREST = "RESTeasyService.doTheJob invoked: parameters [" + param + "]";
		EJBServiceRemote pocEJB;
		try {
			pocEJB = EJBClient.getService("EJBService");
		} catch (NamingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("EJB service not found").build();
		}
		String resultEJB = pocEJB.doTheJob("paramEJB");
		return Response.ok(resultREST + "<br/>" + resultEJB).build();
	}

}