package om.metamorph.databasemanager;

import om.metamorph.envelopes.ListEnvelopeModel;
import om.metamorph.offerprovider.model.NewOfferProviderModel;
import om.metamorph.offerprovider.model.OfferProviderResponseModel;
import om.metamorph.offerprovider.model.UpdateOfferProviderModel;

public interface IDatabaseManager {
    OfferProviderResponseModel readOfferProvider(int id);

    ListEnvelopeModel readListOfferProvider(int limit, int offset);

    OfferProviderResponseModel createOfferProvider(String cognitoSub, NewOfferProviderModel newOfferProviderModel,
                                                   String newLogoKey);

    OfferProviderResponseModel updateOfferProviderLogo(int id, String newLogoKey);

    OfferProviderResponseModel updateOfferProvider(int id, UpdateOfferProviderModel updateOfferProviderModel);

    String readLogoKeyOfOfferProvider(int id);

    void deleteOfferProvider(int id);
}
