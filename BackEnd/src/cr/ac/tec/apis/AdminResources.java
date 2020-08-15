package cr.ac.tec.apis;

import java.util.ArrayList;

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
	
	/**
	 * @param user
	 * @param password
	 * @param name
	 * @return Funcion auxiliar para crear estacion de tren desde API
	 */
	@Path("newStation")
	@POST
	public Response createStation(@QueryParam("user") String user, @QueryParam("password") String password, @QueryParam("name") String name) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			Graph.getMainGraph().addNode(new Node(new TrainStation(name)));
			return Response.ok().build();
		}else {
			return Response.status(401).build();
		}
	}
	
	/**
	 * @param user
	 * @param password
	 * @param origin
	 * @param destiny
	 * @param distance
	 * @return Funcion auxiliar para crear parada con destino y origen desde API
	 */
	@Path("newStop")
	@POST
	public Response createStop(@QueryParam("user") String user, @QueryParam("password") String password, @QueryParam("origin") String origin, @QueryParam("destiny") String destiny, @QueryParam("distance") int distance ) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			Node toS = Graph.getMainGraph().getNodes().get(new Node(new TrainStation(destiny, null)));
			Graph.getMainGraph().getNodes().get(new Node(new TrainStation(origin))).addDestination(toS, distance);			
			return Response.ok().build();
		}else {
			return Response.status(401).build();
		}

	}
	
	
	/**
	 * @param user
	 * @param password
	 * @param origin
	 * @param destiny
	 * @return Funcion auxiliar para eliminar paradas
	 */
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
				System.out.println("eliminado");
				return Response.ok().build();
			}
		}else {
			return Response.status(401).build();
		}
		
		
	}
	
	/**
	 * @param user
	 * @param password
	 * @param name
	 * @return Funcion auxiliar para eliminar estacion
	 */
	@Path("deleteStation")
	@DELETE
	public Response deleteStation(@QueryParam("user") String user, @QueryParam("password") String password, @QueryParam("name") String name) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			if (isUsed(name)) {
				return Response.ok().build();
			} else {
				System.out.println("borrar");
				Node toDelete = Graph.getMainGraph().getNodes().get(new Node(new TrainStation(name, null)));
				Graph.getMainGraph().deleteNode(toDelete);
				return Response.ok().build();
			}
		}else {
			return Response.status(401).build();
		}
	}
	
	
	/**
	 * @param user
	 * @param password
	 * @return Devuelve las compras hechas por usuarios
	 */
	@Path("reservations")
	@GET
	public Response getReservations(@QueryParam("user") String user, @QueryParam("password") String password) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			return Response.ok(Purchase.list).build();
		}else {
			return Response.status(401).build();
		}
	}
	
	/**
	 * @param name
	 * @return devuelve true en caso de estar siendo usada en reservaciones
	 */
	private boolean isUsed(String name) {
		for(Purchase buy : Purchase.list) {
			if(buy.getEndPoint().equals(name) || buy.getStartPoint().equals(name)) {
				return true;
			}
		}return false;
	}
	
	/**
	 * @param user
	 * @param password
	 * @param elimination
	 * @return Funcion auxiliar para eliminar o expirar compras
	 */
	@Path("expirate")
	@DELETE
	public Response prueba(@QueryParam("user") String user, @QueryParam("password") String password, String[] elimination) {
		if(user.equals(this.user)&&password.equals(this.password)) {
			for(String purchase: elimination) {
				for(Purchase register: Purchase.list) {
					if(register.getEmail().equals(purchase)) {
						Purchase.list.remove(register);	
					}
				}
			}
			System.out.println("expirado");
			return Response.ok().build();
		}else {
			return Response.status(401).build();
		}
	}
	
	
	
	
	

}
