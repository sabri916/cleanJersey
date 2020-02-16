package om.metamorph.envelopes;

import java.util.ArrayList;
import java.util.List;

public class ErrorListEnvelopeModel {

    private List<ErrorEnvelopeModel> errorListEnvelopeModels;

    public ErrorListEnvelopeModel() {
        errorListEnvelopeModels = new ArrayList<>();
    }

    public ErrorListEnvelopeModel(List<ErrorEnvelopeModel> errorListEnvelopeModels) {
        this.errorListEnvelopeModels = errorListEnvelopeModels;
    }

    public List<ErrorEnvelopeModel> getErrorListEnvelopeModels() {
        return errorListEnvelopeModels;
    }

    public void setErrorListEnvelopeModels(List<ErrorEnvelopeModel> errorListEnvelopeModels) {
        this.errorListEnvelopeModels = errorListEnvelopeModels;
    }
}
