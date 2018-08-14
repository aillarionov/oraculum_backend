package drone.droneserver.rest;

import drone.droneserver.entity.Cargo;
import drone.droneserver.entity.Telemetry;
import drone.droneserver.entity.Node;
import drone.droneserver.entity.Route;
import drone.droneserver.entity.Task;
import drone.droneserver.entity.TaskFinish;
import drone.droneserver.entity.TaskStart;
import drone.droneserver.service.CargoService;
import drone.droneserver.service.TelemetryService;
import drone.droneserver.service.NodeService;
import drone.droneserver.service.RouteService;
import drone.droneserver.service.TaskService;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * Node REST Web Service
 *
 * @author alex
 */
@Path("")
public class DroneREST {

//    @Context
//    private UriInfo context;
//
    private final NodeService nodeService = new NodeService();
    private final TelemetryService telemetryService = new TelemetryService();
    private final CargoService cargoService = new CargoService();
    private final RouteService routeService = new RouteService();
    private final TaskService taskService = new TaskService();

    /**
     * Creates a new instance of RESTNode
     */
    public DroneREST() {
    }

    /**
     * Retrieves representation of an instance of drone.droneserver.NodeREST
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/node/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Node getNode(@PathParam("id") String id) {
        return nodeService.get(id);
    }

    /**
     * PUT method for updating or creating an instance of NodeREST
     *
     * @param nodeRegistration
     * @param id
     */
    @PUT
    @Path("/node/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createNode(@PathParam("id") String id, Node nodeRegistration) {
        nodeService.create(id, nodeRegistration);
    }

    /**
     * Retrieves representation of an instance of drone.droneserver.NodeREST
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/telemetry/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Telemetry getTelemetry(@PathParam("id") String id) {
        return telemetryService.get(id);
    }

    /**
     * PUT method for updating or creating an instance of NodeREST
     *
     * @param nodeData
     */
    @PUT
    @Path("/telemetry")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTelemetry(Map<String, Telemetry> nodeData) {
        telemetryService.create(nodeData);
    }

    /**
     * Retrieves representation of an instance of drone.droneserver.CargoREST
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/cargo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cargo getCargo(@PathParam("id") String id) {
        return cargoService.get(id);
    }

    /**
     * PUT method for updating or creating an instance of CargoREST
     *
     * @param cargo
     */
    @PUT
    @Path("/cargo")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCargo(@PathParam("id") String id, Cargo cargo) {
        cargoService.create(id, cargo);
    }

    /**
     * Retrieves representation of an instance of drone.droneserver.RouteREST
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/route/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Route getRoute(@PathParam("id") String id) {
        return routeService.get(id);
    }

    /**
     * PUT method for updating or creating an instance of RouteREST
     *
     * @param route
     */
    @PUT
    @Path("/route")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createRoute(@PathParam("id") String id, Route route) {
        routeService.create(id, route);
    }

    /**
     * Retrieves representation of an instance of drone.droneserver.ContractREST
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/task/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTask(@PathParam("id") String id) {
        return taskService.get(id);
    }

    /**
     * PUT method for updating or creating an instance of ContractREST
     *
     * @param task
     */
    @PUT
    @Path("/task/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createTask(@PathParam("id") String id, Task task) {
        taskService.create(id, task);
    }

    /**
     * PUT method for updating or creating an instance of ContractREST
     *
     * @param taskStart
     */
    @PUT
    @Path("/task/start/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createStartTask(@PathParam("id") String id, TaskStart taskStart) {
        taskService.createStart(id, taskStart);
    }

    /**
     * PUT method for updating or creating an instance of ContractREST
     *
     * @param taskFinish
     */
    @PUT
    @Path("/task/finish/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createFinishTask(@PathParam("id") String id, TaskFinish taskFinish) {
        taskService.createFinish(id, taskFinish);
    }

    /**
     * Retrieves previous
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/previous")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<String> getPrevious() {
        return taskService.getPrevious();
    }

    /**
     * Retrieves free tasks
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/task/free")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<String> getFreeTasks() {
        return taskService.getFree();
    }

}
