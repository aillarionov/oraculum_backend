package drone.droneserver.service;

import drone.droneserver.dao.CargoDAO;
import drone.droneserver.entity.Cargo;

/**
 *
 * @author alex
 */
public class CargoService extends CommonService<Cargo> {

    private final CargoDAO dao = new CargoDAO();

    public Cargo get(String id) {
        return dao.get(id);
    }

    public void create(String id, Cargo cargo) {
        dao.put(id, cargo);
    }

}
