package io.swagger.v3.plugins.gradle.petstore.operation;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.plugins.gradle.resources.exception.NotFoundException;
import io.swagger.v3.plugins.gradle.resources.model.Pet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Resource with Operations Examples
 */
public class ExternalDocumentationResource {
    @GET
    @Path("/{petId}")
    @Operation(summary = "Find pet by ID",
            description = "Returns a pet when 0 < ID <= 10.  ID > 10 or non integers will simulate API error conditions",
            operationId = "petId",
            externalDocs = @ExternalDocumentation(description = "External in Operation", url = "http://url.me"))
    @ExternalDocumentation(description = "External Annotation Documentation", url = "http://url.me")
    public Response getPetById(
            @Parameter(description = "ID of pet that needs to be fetched", required = true)
            @PathParam("petId") Long petId) throws NotFoundException {
        return Response.ok().entity(new Pet()).build();
    }
}
