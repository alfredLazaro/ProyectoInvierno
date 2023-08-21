package com.backend.ProyectoInvierno.dto;
import java.io.Serializable;
public class PictureDTO implements Serializable {
    private long picture_id;
    private String picture_name;
    private String picture_path;
    private String restaurant_id;
    private String restaurant_name;

    public PictureDTO() {
    }

    /*public PictureDTO(long picture_id, String picture_name, String picture_path, String restaurant_id, String restaurant_name) {
        this.picture_id = picture_id;
        this.picture_name = picture_name;
        this.picture_path = picture_path;
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
    }*/
    public PictureDTO(long id_picture, String picture_name, String establishment_picture, String id, String name) {
        this.picture_id = id_picture;
        this.picture_name = picture_name;
        this.picture_path = establishment_picture;
        this.restaurant_id = id;
        this.restaurant_name = name;
    }


    public long getId_Picuture() {
        return picture_id;
    }

    public void setId_Picuture(long picture_id) {
        this.picture_id = picture_id;
    }

    public String getPicture_name() {
        return picture_name;
    }

    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }
}