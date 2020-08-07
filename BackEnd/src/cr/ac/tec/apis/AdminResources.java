package cr.ac.tec.apis;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("admin/")
public class AdminResources {
	
	@Path("newStation")
	@POST
	public Response createStation(@HeaderParam("authorization") String basicAuth) {
		
	}
	
	@Path("newStop")
	@POST
	public Response createStop(@HeaderParam("authorization") String basicAuth) {
		
	}
	
	@Path("changeStop")
	@POST
	public Response changeStop(@HeaderParam("authorization") String basicAuth) {
		
	}
	
	@Path("changeStation")
	@POST
	public Response changeStation(@HeaderParam("authorization") String basicAuth) {
		
	}
	
	@Path("deleteStation")
	@DELETE
	public Response deleteStation(@HeaderParam("authorization") String basicAuth) {
		
	}
	
	@Path("deleteStop")
	@POST
	public Response deleteStop(@HeaderParam("authorization")String basicAuth) {
		
	}
	
	@Path("reservations")
	@GET
	public Response getReservations(@HeaderParam("authorization") String basicAuth) {
		
	}
	
	@Path("test")
	@GET
	public String probando() {
		return "hola mundo";
	}
	
	
	

}
