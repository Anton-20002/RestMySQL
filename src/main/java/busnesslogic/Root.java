package busnesslogic;

import javax.inject.Inject;
import javax.transaction.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

/**
 * Created by Anton on 08.09.2018.
 */
@Path("/root")
public class Root {

    @Inject
    private RootService service;


    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Book sendData() throws SQLException, HeuristicRollbackException, HeuristicMixedException, NotSupportedException, RollbackException, SystemException {
        return service.getBooks();
    }
}
