package om.metamorph.databasemanager.mysqlmanager;

import om.metamorph.databasemanager.IDatabaseManager;
import om.metamorph.envelopes.ListEnvelopeModel;
import om.metamorph.offerprovider.model.NewOfferProviderModel;
import om.metamorph.offerprovider.model.OfferProviderResponseModel;
import om.metamorph.offerprovider.model.UpdateOfferProviderModel;

import java.util.ArrayList;
import java.util.List;

public class MySqlDatabaseManager implements IDatabaseManager {
    @Override
    public OfferProviderResponseModel readOfferProvider(int id) {
        String query = "Select * from table where bla bla";
        //run query

        //map resultset to POJO in this class, not in POJO

        //return POJO
        return new OfferProviderResponseModel("my name", "333", id, "logo-url");
    }

    @Override
    public ListEnvelopeModel readListOfferProvider(int limit, int offset) {
        String query = "Select * from table where bla bla";
        //map resultSet on here not in POJO

        List<OfferProviderResponseModel> offerProviderList = new ArrayList<>();
        offerProviderList.add(new OfferProviderResponseModel("my name", "333", 15, "logo-url"));
        ListEnvelopeModel listEnvelopeModel = new ListEnvelopeModel();
        listEnvelopeModel.setCount(1);
        listEnvelopeModel.setLimit(limit);
        listEnvelopeModel.setOffset(offset);
        listEnvelopeModel.setData(offerProviderList);
        return listEnvelopeModel;
    }

    @Override
    public OfferProviderResponseModel createOfferProvider(String cognitoSub, NewOfferProviderModel newOfferProviderModel,
                                                          String newLogoKey) {
        String q = "insert to table bla bla bla";
        //write to database and stuff
        //extract id of inserted row
        int id = 15;
        return readOfferProvider(15);
    }

    @Override
    public OfferProviderResponseModel updateOfferProviderLogo(int id, String newLogoKey) {
        String q = "update table set image = newlogokey";
        return readOfferProvider(id);
    }

    @Override
    public OfferProviderResponseModel updateOfferProvider(int id, UpdateOfferProviderModel updateOfferProviderModel) {
        String q = "update table set name = newName, etc";
        return readOfferProvider(id);
    }

    @Override
    public String readLogoKeyOfOfferProvider(int id) {
        String q = "select logKey from table where id =?";
        return new String("logoKey");
    }

    @Override
    public void deleteOfferProvider(int id) {
        String q = "delete offer provider where id = ?";
    }
}
