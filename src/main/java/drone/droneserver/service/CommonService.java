package drone.droneserver.service;

import drone.droneserver.dao.CommonDAO;
import drone.droneserver.entity.Block;
import java.util.Set;

/**
 *
 * @author alex
 * @param <T>
 */
public class CommonService<T extends Block> {
    private final CommonDAO dao = new CommonDAO();
    
    public Set<String> getPrevious() {
        return dao.getPrevious();
    }

}
