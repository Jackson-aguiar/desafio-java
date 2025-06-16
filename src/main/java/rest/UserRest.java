package rest;

import dto.VotoDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.UsuarioService;


@Path("/usuario")
@Produces("application/json")
@Consumes("application/json")
public class UserRest {

    @Inject
    UsuarioService usuarioService;

    @POST
    @Path("/votar/pauta/{idPauta}")
    public Response votar(@PathParam("idPauta") Long idPauta, VotoDTO votoDTO) throws Exception {
        usuarioService.votar(idPauta, votoDTO);
        return Response.status(Response.Status.CREATED).build();
    }

}
