package cr.ac.tec.apis;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import cr.ac.tec.adt.Graph;
import cr.ac.tec.adt.Node;
import cr.ac.tec.workingObjects.Purchase;
import cr.ac.tec.workingObjects.TrainStation;
import javax.ws.rs.core.MediaType;

@Path("admin/")
@Consumes(value= MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class AdminResources {
	
	String user = "admin";
	String password = "1234abc";
	
	@Path("newStation")
	@POST
	public Response createStation(@QueryParam("user") String user, @QueryParam("password") String password, TrainStation station) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			Graph.getMainGraph().addNode(new Node(station));
			return Response.ok().build();
		}else {
			return Response.status(401).build();
		}
	}
	
	@Path("newStop")
	@POST
	public Response createStop(@QueryParam("user") String user, @QueryParam("password") String password, @QueryParam("origin") String origin, @QueryParam("destiny") String destiny, @QueryParam("distance") int distance ) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			Node toS = Graph.getMainGraph().getNodes().get(new Node(new TrainStation(destiny, null)));
			Graph.getMainGraph().getNodes().get(new Node(new TrainStation(origin, null))).addDestination(toS, distance);			
			return Response.ok().build();
		}else {
			return Response.status(401).build();
		}

	}
	
	
	@Path("deleteStop")
	@DELETE
	public Response deleteStop(@QueryParam("user") String user, @QueryParam("password") String password, @QueryParam("origin") String origin, @QueryParam("destiny") String destiny) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			if (isUsed(origin)) {
				return Response.ok().build();
			} else if (isUsed(destiny)) {
				return Response.ok().build();
			} else {
				Node toS = Graph.getMainGraph().getNodes().get(new Node(new TrainStation(destiny, null)));
				Node fromS = Graph.getMainGraph().getNodes().get(new Node(new TrainStation(origin, null)));
				if (fromS.getAdjacentNodes().containsKey(toS)) {
					fromS.getAdjacentNodes().remove(toS);
				}
				return Response.ok().build();
			}
		}else {
			return Response.status(401).build();
		}
		
		
	}
	
	@Path("deleteStation")
	@DELETE
	public Response deleteStation(@QueryParam("user") String user, @QueryParam("password") String password, @QueryParam("name") String name) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			if (isUsed(name)) {
				return Response.ok().build();
			} else {
				Node toDelete = Graph.getMainGraph().getNodes().get(new Node(new TrainStation(name, null)));
				Graph.getMainGraph().deleteNode(toDelete);
				return Response.ok().build();
			}
		}else {
			return Response.status(401).build();
		}
	}
	
	
	@Path("reservations")
	@GET
	public Response getReservations(@QueryParam("user") String user, @QueryParam("password") String password) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			return Response.ok(Purchase.list).build();
		}else {
			return Response.status(401).build();
		}
	}
	
	private boolean isUsed(String name) {
		for(Purchase buy : Purchase.list) {
			if(buy.getEndPoint().equals(name) || buy.getStartPoint().equals(name)) {
				return true;
			}
		}return false;
	}
	
	
	
	
	

}
