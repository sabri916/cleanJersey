package om.metamorph.exceptions;

import om.metamorph.envelopes.ErrorEnvelopeModel;
import om.metamorph.envelopes.ErrorListEnvelopeModel;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Provider
public class ConstraintExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        ErrorListEnvelopeModel errorListEnvelopeModel = new ErrorListEnvelopeModel();
        List<ErrorEnvelopeModel> errors = new ArrayList<>();

        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {/*
            errorListEnvelopeModel.getErrorListEnvelopeModels()
                    .add(new ErrorEnvelopeModel(422, violation.getMessage()));*/
            errors.add(new ErrorEnvelopeModel(422, violation.getMessage()));
        }
        return Response.status(422).entity(errors).build();
    }
}
