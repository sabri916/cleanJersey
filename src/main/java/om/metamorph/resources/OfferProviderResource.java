package om.metamorph.resources;

import om.metamorph.envelopes.ListEnvelopeModel;
import om.metamorph.offerprovider.model.NewOfferProviderModel;
import om.metamorph.offerprovider.model.OfferProviderResponseModel;
import om.metamorph.offerprovider.model.UpdateOfferProviderModel;
import om.metamorph.offerprovider.offerprovidermanager.IOfferProviderManager;
import om.metamorph.offerprovider.offerprovidermanager.OfferProviderManager;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;

@Path("offer-provider")
public class OfferProviderResource {

    private IOfferProviderManager offerProviderManager;
    @Context private transient HttpServletRequest servletRequest;

    public OfferProviderResource() {
        offerProviderManager = new OfferProviderManager();
    }

    public OfferProviderResource(IOfferProviderManager offerProviderManager) {
        this.offerProviderManager = offerProviderManager;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSingleOfferProvider(@PathParam("id") int id) {
        OfferProviderResponseModel offerProviderResponseModel = offerProviderManager.getSingleOfferProvider(id);
        return Response.status(Response.Status.OK).entity(offerProviderResponseModel).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListOfferProvider(@QueryParam("limit") @DefaultValue("999999999") int limit,
                                         @QueryParam("offset") int offset) {
        ListEnvelopeModel listEnvelopeModel = offerProviderManager.getOfferProviders(limit,offset);
        return Response.status(Response.Status.OK).entity(listEnvelopeModel).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOfferProvider(@Valid NewOfferProviderModel newOfferProviderModel) {
        String cognitoSub = (String) servletRequest.getAttribute("cognitoSub");
        OfferProviderResponseModel offerProviderResponseModel = offerProviderManager
                .createOfferProvider(cognitoSub, newOfferProviderModel);
        return Response.status(Response.Status.CREATED).entity(offerProviderResponseModel).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOfferProvider(@Valid UpdateOfferProviderModel updateOfferProviderModel, @PathParam("id") int id) {
        String cognitoSub = (String) servletRequest.getAttribute("cognitoSub");
        OfferProviderResponseModel offerProviderResponseModel =
                offerProviderManager.modifyOfferProvider(cognitoSub, id, updateOfferProviderModel);
        return Response.status(Response.Status.OK).entity(offerProviderResponseModel).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteOfferProvider(@PathParam("id") int id) {
        offerProviderManager.deleteOfferProvider(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
