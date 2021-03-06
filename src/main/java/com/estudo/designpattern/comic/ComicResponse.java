package com.estudo.designpattern.comic;

import com.estudo.designpattern.creator.CreatorResponse;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;


public class ComicResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private String isbn;
    private String discountDay;
    private boolean discountActive;
    private String description;
    private String thumbnail;

    private Set<CreatorResponse> creators;

    public ComicResponse() {

    }

    public ComicResponse(Long id, String name, Double price, String isbn, String discountDay, boolean discountActive,
                         String description, String thumbnail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isbn = isbn;
        this.discountDay = discountDay;
        this.discountActive = discountActive;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public ComicResponse(Comic entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.isbn = entity.getIsbn();
        this.discountDay = entity.getDiscountDay();
        this.discountActive = entity.getDiscountActive();
        this.description = entity.getDescription();
        this.thumbnail = entity.getThumbnail();

        if (entity.getCreators() != null) {
            this.creators = entity.getCreators().stream().map(x -> new CreatorResponse(x)).collect(Collectors.toSet());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDiscountDay() {
        return discountDay;
    }

    public void setDiscountDay(String discountDay) {
        this.discountDay = discountDay;
    }

    public boolean isDiscountActive() {
        return discountActive;
    }

    public void setDiscountActive(boolean discountActive) {
        this.discountActive = discountActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Set<CreatorResponse> getCreators() {
        return creators;
    }
}
