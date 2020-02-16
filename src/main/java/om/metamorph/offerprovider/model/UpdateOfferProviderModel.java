package om.metamorph.offerprovider.model;

import om.metamorph.offerprovider.beanvalidations.LogoKeyModification;

public class UpdateOfferProviderModel extends BaseOfferProvider {
    @LogoKeyModification private String logoKey;

    public UpdateOfferProviderModel() {
    }

    public UpdateOfferProviderModel(String name, String phone, String logoKey) {
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
