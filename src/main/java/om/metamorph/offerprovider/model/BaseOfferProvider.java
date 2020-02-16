package om.metamorph.offerprovider.model;

import om.metamorph.offerprovider.beanvalidations.OfferProviderName;

import javax.validation.constraints.NotNull;

public abstract class BaseOfferProvider {
    @OfferProviderName protected String name;
    @NotNull(message = "Phone number cannot be null") protected String phone;

    public BaseOfferProvider() {
    }

    public BaseOfferProvider(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
