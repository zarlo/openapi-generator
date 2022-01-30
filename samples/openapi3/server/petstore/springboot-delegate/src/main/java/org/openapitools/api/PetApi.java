/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.ModelApiResponse;
import org.openapitools.model.Pet;
import org.springframework.core.io.Resource;
import java.util.Set;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "pet", description = "the pet API")
public interface PetApi {

    default PetApiDelegate getDelegate() {
        return new PetApiDelegate() {};
    }

    /**
     * POST /pet : Add a new pet to the store
     *
     * @param body Pet object that needs to be added to the store (required)
     * @return successful operation (status code 200)
     *         or Invalid input (status code 405)
     */
    @Operation(
        operationId = "addPet",
        summary = "Add a new pet to the store",
        tags = { "pet" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "405", description = "Invalid input")
        },
        security = {
            @SecurityRequirement(name = "petstore_auth", scopes={ "write:pets", "read:pets" })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/pet",
        consumes = { "application/json", "application/xml" }
    )
    default ResponseEntity<Void> addPet(
        @Parameter(name = "body", description = "Pet object that needs to be added to the store", required = true, schema = @Schema(description = "")) @Valid @RequestBody Pet body
    ) {
        return getDelegate().addPet(body);
    }


    /**
     * DELETE /pet/{petId} : Deletes a pet
     *
     * @param petId Pet id to delete (required)
     * @param apiKey  (optional)
     * @return successful operation (status code 200)
     *         or Invalid pet value (status code 400)
     */
    @Operation(
        operationId = "deletePet",
        summary = "Deletes a pet",
        tags = { "pet" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid pet value")
        },
        security = {
            @SecurityRequirement(name = "petstore_auth", scopes={ "write:pets", "read:pets" })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/pet/{petId}"
    )
    default ResponseEntity<Void> deletePet(
        @Parameter(name = "petId", description = "Pet id to delete", required = true, schema = @Schema(description = "")) @PathVariable("petId") Long petId,
        @Parameter(name = "api_key", description = "", schema = @Schema(description = "")) @RequestHeader(value = "api_key", required = false) String apiKey
    ) {
        return getDelegate().deletePet(petId, apiKey);
    }


    /**
     * GET /pet/findByStatus : Finds Pets by status
     * Multiple status values can be provided with comma separated strings
     *
     * @param status Status values that need to be considered for filter (required)
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     */
    @Operation(
        operationId = "findPetsByStatus",
        summary = "Finds Pets by status",
        tags = { "pet" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Pet.class))),
            @ApiResponse(responseCode = "400", description = "Invalid status value")
        },
        security = {
            @SecurityRequirement(name = "petstore_auth", scopes={ "write:pets", "read:pets" })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/pet/findByStatus",
        produces = { "application/xml", "application/json" }
    )
    default ResponseEntity<List<Pet>> findPetsByStatus(
        @NotNull @Parameter(name = "status", description = "Status values that need to be considered for filter", required = true, schema = @Schema(description = "", allowableValues = { "available", "pending", "sold" })) @Valid @RequestParam(value = "status", required = true) List<String> status
    ) {
        return getDelegate().findPetsByStatus(status);
    }


    /**
     * GET /pet/findByTags : Finds Pets by tags
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param tags Tags to filter by (required)
     * @return successful operation (status code 200)
     *         or Invalid tag value (status code 400)
     * @deprecated
     */
    @Operation(
        operationId = "findPetsByTags",
        summary = "Finds Pets by tags",
        tags = { "pet" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Pet.class))),
            @ApiResponse(responseCode = "400", description = "Invalid tag value")
        },
        security = {
            @SecurityRequirement(name = "petstore_auth", scopes={ "write:pets", "read:pets" })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/pet/findByTags",
        produces = { "application/xml", "application/json" }
    )
    default ResponseEntity<Set<Pet>> findPetsByTags(
        @NotNull @Parameter(name = "tags", description = "Tags to filter by", required = true, schema = @Schema(description = "")) @Valid @RequestParam(value = "tags", required = true) Set<String> tags
    ) {
        return getDelegate().findPetsByTags(tags);
    }


    /**
     * GET /pet/{petId} : Find pet by ID
     * Returns a single pet
     *
     * @param petId ID of pet to return (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Pet not found (status code 404)
     */
    @Operation(
        operationId = "getPetById",
        summary = "Find pet by ID",
        tags = { "pet" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  Pet.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Pet not found")
        },
        security = {
            @SecurityRequirement(name = "api_key")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/pet/{petId}",
        produces = { "application/xml", "application/json" }
    )
    default ResponseEntity<Pet> getPetById(
        @Parameter(name = "petId", description = "ID of pet to return", required = true, schema = @Schema(description = "")) @PathVariable("petId") Long petId
    ) {
        return getDelegate().getPetById(petId);
    }


    /**
     * PUT /pet : Update an existing pet
     *
     * @param body Pet object that needs to be added to the store (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Pet not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "updatePet",
        summary = "Update an existing pet",
        tags = { "pet" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Pet not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        },
        security = {
            @SecurityRequirement(name = "petstore_auth", scopes={ "write:pets", "read:pets" })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/pet",
        consumes = { "application/json", "application/xml" }
    )
    default ResponseEntity<Void> updatePet(
        @Parameter(name = "body", description = "Pet object that needs to be added to the store", required = true, schema = @Schema(description = "")) @Valid @RequestBody Pet body
    ) {
        return getDelegate().updatePet(body);
    }


    /**
     * POST /pet/{petId} : Updates a pet in the store with form data
     *
     * @param petId ID of pet that needs to be updated (required)
     * @param name Updated name of the pet (optional)
     * @param status Updated status of the pet (optional)
     * @return Invalid input (status code 405)
     */
    @Operation(
        operationId = "updatePetWithForm",
        summary = "Updates a pet in the store with form data",
        tags = { "pet" },
        responses = {
            @ApiResponse(responseCode = "405", description = "Invalid input")
        },
        security = {
            @SecurityRequirement(name = "petstore_auth", scopes={ "write:pets", "read:pets" })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/pet/{petId}",
        consumes = { "application/x-www-form-urlencoded" }
    )
    default ResponseEntity<Void> updatePetWithForm(
        @Parameter(name = "petId", description = "ID of pet that needs to be updated", required = true, schema = @Schema(description = "")) @PathVariable("petId") Long petId,
        @Parameter(name = "name", description = "Updated name of the pet", schema = @Schema(description = "")) @Valid @RequestPart(value = "name", required = false) String name,
        @Parameter(name = "status", description = "Updated status of the pet", schema = @Schema(description = "")) @Valid @RequestPart(value = "status", required = false) String status
    ) {
        return getDelegate().updatePetWithForm(petId, name, status);
    }


    /**
     * POST /pet/{petId}/uploadImage : uploads an image
     *
     * @param petId ID of pet to update (required)
     * @param additionalMetadata Additional data to pass to server (optional)
     * @param file file to upload (optional)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "uploadFile",
        summary = "uploads an image",
        tags = { "pet" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  ModelApiResponse.class)))
        },
        security = {
            @SecurityRequirement(name = "petstore_auth", scopes={ "write:pets", "read:pets" })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/pet/{petId}/uploadImage",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    default ResponseEntity<ModelApiResponse> uploadFile(
        @Parameter(name = "petId", description = "ID of pet to update", required = true, schema = @Schema(description = "")) @PathVariable("petId") Long petId,
        @Parameter(name = "additionalMetadata", description = "Additional data to pass to server", schema = @Schema(description = "")) @Valid @RequestPart(value = "additionalMetadata", required = false) String additionalMetadata,
        @Parameter(name = "file", description = "file to upload", schema = @Schema(description = "")) @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        return getDelegate().uploadFile(petId, additionalMetadata, file);
    }

}
