package om.metamorph.offerprovider.model;

import om.metamorph.offerprovider.beanvalidations.LogoKey;

public class NewOfferProviderModel extends BaseOfferProvider {

    @LogoKey private String logoKey;

    public NewOfferProviderModel() {
    }

    public NewOfferProviderModel(String name, String phone, String logoKey) {
        super(name, phone);
        this.logoKey = logoKey;
    }

    public String getLogoKey() {
        return logoKey;
    }

    public void setLogoKey(String logoKey) {
        this.logoKey = logoKey;
    }
}
