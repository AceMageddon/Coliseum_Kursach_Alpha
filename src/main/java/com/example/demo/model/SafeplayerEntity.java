package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "safeplayer", schema = "public", catalog = "coliseumstats")
public class SafeplayerEntity {
    private long id;
    private int health;
    private int damage;
    private int absorb;
    private int regen;
    private int fire;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "health")
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Basic
    @Column(name = "damage")
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Basic
    @Column(name = "absorb")
    public int getAbsorb() {
        return absorb;
    }

    public void setAbsorb(int absorb) {
        this.absorb = absorb;
    }

    @Basic
    @Column(name = "regen")
    public int getRegen() {
        return regen;
    }

    public void setRegen(int regen) {
        this.regen = regen;
    }

    @Basic
    @Column(name = "fire")
    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SafeplayerEntity that = (SafeplayerEntity) o;
        return id == that.id && health == that.health && damage == that.damage && absorb == that.absorb && regen == that.regen && fire == that.fire;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, health, damage, absorb, regen, fire);
    }
}
