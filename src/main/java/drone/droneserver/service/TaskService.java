package drone.droneserver.service;

import drone.droneserver.dao.CargoDAO;
import drone.droneserver.dao.TaskStartDAO;
import drone.droneserver.dao.TaskFinishDAO;
import drone.droneserver.dao.TaskDAO;
import drone.droneserver.dao.NodeDAO;
import drone.droneserver.dao.TelemetryDAO;
import drone.droneserver.dao.RouteDAO;
import drone.droneserver.entity.TaskStart;
import drone.droneserver.entity.TaskFinish;
import drone.droneserver.entity.Task;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author alex
 */
public class TaskService extends CommonService<Task> {

    private final TaskDAO daoTask = new TaskDAO();
    private final TaskStartDAO daoAccept = new TaskStartDAO();
    private final TaskFinishDAO daoFinish = new TaskFinishDAO();
    private final TelemetryDAO daoNodeRegistration = new TelemetryDAO();
    private final NodeDAO daoNodeData = new NodeDAO();
    private final CargoDAO daoCargo = new CargoDAO();
    private final RouteDAO daoRoute = new RouteDAO();

    public Task get(String id) {
        return daoTask.get(id);
    }

    public void create(String id, Task task) {
        daoTask.put(id, task);
    }

    public TaskStart getAccept(String id) {
        return daoAccept.get(id);
    }

    public void createStart(String id, TaskStart contract) {
        daoAccept.put(id, contract);
    }

    public TaskFinish getFinish(String id) {
        return daoFinish.get(id);
    }

    public void createFinish(String id, TaskFinish contract) {
        //contract.setSuccess(checkSuccess(contract));
        daoFinish.put(id, contract);
    }
    
    public Set<String> getFree() {
        return daoTask.getFree();
    }
/*
    private Boolean checkSuccess(TaskFinish contract) {
        ContractRegistration contractRegistration = daoRegistration.get(contract.getContract());
        Node nodeRegistration = daoNodeRegistration.get(contract.getNode());
        Cargo cargo = daoCargo.get(contractRegistration.getCargo());
        Route route = daoRoute.get(contractRegistration.getRoute());
        Set<Telemetry> nodeData = daoNodeData.getByContractAndNode(contractRegistration.getId(), nodeRegistration.getId());

        return getSmartContract(contractRegistration).checkSuccess(contractRegistration, nodeRegistration, cargo, route, nodeData);
    }

    private SmartContract getSmartContract(ContractRegistration contractRegistration) {

        switch (contractRegistration.getSmartContract()) {

            case "CheckSpeedSmartContract":
                return new CheckSpeedSmartContract();
            
            default:
                return new EmptySmartContract();
        }

    }
*/
}
