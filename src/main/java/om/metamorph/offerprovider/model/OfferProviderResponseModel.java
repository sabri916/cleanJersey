package om.metamorph.offerprovider.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "phone", "logoUrl"})
public class OfferProviderResponseModel extends BaseOfferProvider {
    private long id;
    private String logoUrl;

    public OfferProviderResponseModel() {
    }

    public OfferProviderResponseModel(String name, String phone, long id, String logoUrl) {
        super(name, phone);
        this.id = id;
        this.logoUrl = logoUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
