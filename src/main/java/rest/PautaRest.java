package rest;

import dto.PautaDTO;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.PautaService;
import service.SessaoService;
import service.VotoService;

@Path("/pauta")
@Produces("application/json")
@Consumes("application/json")
public class PautaRest {

    @Inject
    PautaService pautaService;
    @Inject
    SessaoService sessaoService;
    @Inject
    VotoService votoService;

    @POST
    @Path("/criar")
    public Response criarPauta(@Valid PautaDTO pautaDTO){
        return Response.status(Response.Status.CREATED).entity(pautaService.criarPauta(pautaDTO)).build();
    }

    @POST
    @Path("{idPauta}/abrir-votacao")
    public Response iniciarVotacao(@PathParam("idPauta") Long idPauta , @QueryParam("minutos") @DefaultValue("1") Long minutos ) throws Exception {
        return Response.status(Response.Status.CREATED).entity(sessaoService.abrirSessao(idPauta, minutos)).build();
    }

    @GET
    @Path("{idPauta}/resultado")
    public Response resultadoVotacao(@PathParam("idPauta") Long idPauta){
        return Response.status(Response.Status.ACCEPTED).entity(votoService.resultadoVotacao(idPauta)).build();
    }

}
