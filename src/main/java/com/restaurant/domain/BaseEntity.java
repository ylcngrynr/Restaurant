package com.restaurant.domain;

import jakarta.persistence.*;


import java.time.LocalDate;


@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate savedTime;
    private LocalDate updateTime;

    @ManyToOne
    @JoinColumn(name = "id_user_save", nullable = false)
    private Users saveusers;

    @ManyToOne
    @JoinColumn(name="id_user_update",nullable = false)
    private Users updateusers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSavedTime() {
        return savedTime;
    }

    public void setSavedTime(LocalDate savedTime) {
        this.savedTime = savedTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    public Users getSaveusers() {
        return saveusers;
    }

    public void setSaveusers(Users saveusers) {
        this.saveusers = saveusers;
    }

    public Users getUpdateusers() {
        return updateusers;
    }

    public void setUpdateusers(Users updateusers) {
        this.updateusers = updateusers;
    }
}
