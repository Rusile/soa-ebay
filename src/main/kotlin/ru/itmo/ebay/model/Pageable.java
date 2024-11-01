package ru.itmo.ebay.model;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class Pageable {

    @JsonbProperty("pageNumber")
    private int pageNumber;

    @JsonbProperty("pageSize")
    private int pageSize;

    @JsonbCreator
    public Pageable(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Pageable() {
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }
}
