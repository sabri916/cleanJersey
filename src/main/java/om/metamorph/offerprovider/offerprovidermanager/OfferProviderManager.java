package om.metamorph.offerprovider.offerprovidermanager;

import om.metamorph.databasemanager.IDatabaseManager;
import om.metamorph.databasemanager.mysqlmanager.MySqlDatabaseManager;
import om.metamorph.envelopes.ListEnvelopeModel;
import om.metamorph.offerprovider.model.NewOfferProviderModel;
import om.metamorph.offerprovider.model.OfferProviderResponseModel;
import om.metamorph.offerprovider.model.UpdateOfferProviderModel;
import om.metamorph.storagemanager.IStorageManager;
import om.metamorph.storagemanager.s3manager.S3Manager;

public class OfferProviderManager implements IOfferProviderManager {

    private IDatabaseManager databaseManager;
    private IStorageManager storageManager;

    public OfferProviderManager() {
        databaseManager = new MySqlDatabaseManager();
        storageManager = new S3Manager();
    }

    @Override
    public OfferProviderResponseModel getSingleOfferProvider(int id) {
        return databaseManager.readOfferProvider(id);
    }

    @Override
    public ListEnvelopeModel getOfferProviders(int limit, int offset) {
        return databaseManager.readListOfferProvider(limit,offset);
    }

    @Override
    public OfferProviderResponseModel createOfferProvider(String cognitoSub, NewOfferProviderModel newOfferProviderModel) {
        String newLogoKey = storageManager.moveFileToPermanentLocation(cognitoSub, newOfferProviderModel.getLogoKey());
        OfferProviderResponseModel offerProviderResponseModel =
                databaseManager.createOfferProvider(cognitoSub, newOfferProviderModel, newLogoKey);
        return offerProviderResponseModel;
    }

    @Override
    public OfferProviderResponseModel modifyOfferProvider(String cognitoSub, int id,
                                                          UpdateOfferProviderModel updateOfferProviderModel) {
        OfferProviderResponseModel offerProviderResponseModel = null;
        if(updateOfferProviderModel.getLogoKey() != null) {
            String newLogoKey = storageManager.moveFileToPermanentLocation(cognitoSub,
                    updateOfferProviderModel.getLogoKey());
            databaseManager.updateOfferProviderLogo(id, newLogoKey);
        }
        return databaseManager.updateOfferProvider(id, updateOfferProviderModel);
    }

    @Override
    public void deleteOfferProvider(int id) {
        //get logo key
        String logoKey = databaseManager.readLogoKeyOfOfferProvider(id);
        //delete logo
        storageManager.deleteFile(logoKey);
        databaseManager.deleteOfferProvider(id);
    }
}
