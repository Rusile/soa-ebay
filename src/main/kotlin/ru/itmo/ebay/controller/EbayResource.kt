package ru.itmo.ebay.controller

import jakarta.inject.Inject
import jakarta.validation.Valid
import jakarta.validation.constraints.Positive
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import ru.itmo.ebay.service.ProductsApiClient

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/price")
open class EbayResource {

    @Inject
    private lateinit var productsApiClient: ProductsApiClient

    @POST
    @Path("/increase/{increase-percent}")
    open fun increasePrice(@Valid @Positive @PathParam("increase-percent") percent: Float): Response {
        productsApiClient.updatePrice(1 + percent)
        return Response.ok().build()
    }

    @POST
    @Path("/decrease/{decrease-percent}")
    open fun decreasePrice(@Valid @Positive @PathParam("decrease-percent") percent: Float): Response {
        if (percent >= 1) {
            return Response.status(400).build()
        }
        productsApiClient.updatePrice(1 - percent)
        return Response.ok().build()
    }
}