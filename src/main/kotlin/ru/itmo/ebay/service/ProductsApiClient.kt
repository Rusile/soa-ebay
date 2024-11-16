package ru.itmo.ebay.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.client.ClientBuilder
import jakarta.ws.rs.client.Entity
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON
import ru.itmo.ebay.model.PageProduct
import ru.itmo.ebay.model.Product


@ApplicationScoped
open class ProductsApiClient {

    open fun updatePrice(percent: Float) {
        val products = getAllProducts()

        products.forEach {
            it.price *= percent
        }
        updateProducts(products)
    }

    open fun getAllProducts(): List<Product> {
        val client = ClientBuilder.newClient()
        val response = client.target(URL)
            .path("/products/bulk")
            .queryParam("size", Int.MAX_VALUE)
            .request(APPLICATION_JSON)
            .header("Content-Type", "application/json")
            .post(Entity.json("[]"), PageProduct::class.java)

        client.close()

        return response.content
    }

    private fun updateProducts(products: List<Product>) {
        val client = ClientBuilder.newClient()
        products.forEach {
            client.target(URL)
                .path("/products/${it.id}")
                .queryParam("size", Int.MAX_VALUE)
                .request(APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .put(Entity.json(it))
        }
        client.close()
    }

    companion object {
        private val URL = "https://localhost:8023/products-1.0-SNAPSHOT/api"
    }
}