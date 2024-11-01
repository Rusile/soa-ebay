package ru.itmo.ebay.model;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

import java.util.List;

public class PageProduct {
    @JsonbProperty("content")
    private List<Product> content;

    @JsonbProperty("pageable")
    private Pageable pageable;

    @JsonbProperty("totalPages")
    private int totalPages;

    @JsonbProperty("totalElements")
    private int totalElements;

    @JsonbCreator
    public PageProduct(List<Product> content, Pageable pageable, int totalPages, int totalElements) {
        this.content = content;
        this.pageable = pageable;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public PageProduct() {
    }

    public List<Product> getContent() {
        return content;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }
}