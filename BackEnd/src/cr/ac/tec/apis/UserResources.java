package cr.ac.tec.apis;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import cr.ac.tec.adt.Graph;
import cr.ac.tec.adt.Node;
import cr.ac.tec.workingObjects.Purchase;
import cr.ac.tec.workingObjects.TrainStation;
import cr.ac.tec.workingObjects.Calculator;
import cr.ac.tec.workingObjects.Dijkstra;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Consumes(value= MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class UserResources {
	
	@Path("stations")
	@GET
	public Response getStations() {
		return Response.ok(Graph.getMainGraph().getNodes().toArrayList()).build();
	}
	
	@Path("purchase")
	@POST
	public Response buyTickets(@QueryParam("fromS") String fromS ,@QueryParam("toS") String toS, @QueryParam("num") int num, @QueryParam("email") String email ) {
		if(num<=0) {
			System.out.println("Wont proceed with purchase");
			return Response.status(405).build();
		}else {
			Purchase newBuy = new Purchase(fromS, toS, email, num);
			Purchase.list.add(newBuy);
			Node origin = Graph.getMainGraph().getNodes().get(new Node(new TrainStation(fromS, null)));
			Node destiny = Graph.getMainGraph().getNodes().get(new Node(new TrainStation(fromS, null)));
			Graph calculator = Dijkstra.calculateShortestPathFromSource(Graph.getMainGraph(), origin);
			int price;
			Calculator toReturn;
			ArrayList<Node> route = calculator.gettingPath(destiny, origin);
			if(num == 1) {
				price = calculator.getNodes().get(destiny).getDistance()*125;
				toReturn = new Calculator(price, route);
			}else if(num < 45){
				price = calculator.getNodes().get(destiny).getDistance()*125;
				price = (int) (price - price*0.02*num);
				toReturn = new Calculator(price, route);
			}else {
				price = calculator.getNodes().get(destiny).getDistance()*125;
				price = (int) (price - price*0.02*45);
				toReturn = new Calculator(price, route);
			}
			return Response.ok(toReturn).build();
		}
	}
	
}
