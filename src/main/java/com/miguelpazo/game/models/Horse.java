package com.miguelpazo.game.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Document(collection = "horses")
public class Horse {

    @Id
    @Field("_id")
    private ObjectId id;
    @Field("code")
    private String code;
    @Field("name")
    private String name;
    @Field("race")
    private String race;
    @Field("weigth")
    private Double weigth;
    @Field("height")
    private Double height;
    @Field("enabled")
    private Boolean enabled;
    @Field("deleted")
    private Boolean deleted;
    @Field("created_at")
    private Date createdAt;
    @Field("updated_at")
    private Date updatedAt;
    @Field("deleted_at")
    private Date deletedAt;

    public Horse() {
        setDefault();
    }

    public Horse(String code, String name, String race, Double weigth, Double height) {
        setDefault();

        this.code = code;
        this.name = name;
        this.race = race;
        this.weigth = weigth;
        this.height = height;
        this.createdAt = new Date();
    }

    private void setDefault() {
        this.enabled = true;
        this.deleted = false;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Double getWeigth() {
        return weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", weigth=" + weigth +
                ", height=" + height +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
