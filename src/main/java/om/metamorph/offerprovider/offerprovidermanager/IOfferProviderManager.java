package om.metamorph.offerprovider.offerprovidermanager;

import om.metamorph.envelopes.ListEnvelopeModel;
import om.metamorph.offerprovider.model.NewOfferProviderModel;
import om.metamorph.offerprovider.model.OfferProviderResponseModel;
import om.metamorph.offerprovider.model.UpdateOfferProviderModel;

public interface IOfferProviderManager {

    OfferProviderResponseModel getSingleOfferProvider(int id);

    ListEnvelopeModel getOfferProviders(int limit, int offset);

    OfferProviderResponseModel createOfferProvider(String cognitoSub, NewOfferProviderModel newOfferProviderModel);

    OfferProviderResponseModel modifyOfferProvider(String cognitoSub, int id, UpdateOfferProviderModel updateOfferProviderModel);

    void deleteOfferProvider(int id);
}
