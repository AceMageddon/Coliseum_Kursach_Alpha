package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player", schema = "public", catalog = "coliseumstats")
public class PlayerEntity {
    private long id;
    private String email;
    private String password;
    private String playername;
    private int health;
    private int damage;
    private int absorb;
    private int regen;
    private int fire;
    private int firestatus;
    private int insight;
    private int upgrades;
    private int shield;
    private int parry;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "playername")
    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
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

    @Basic
    @Column(name = "firestatus")
    public int getFirestatus() {
        return firestatus;
    }

    public void setFirestatus(int firestatus) {
        this.firestatus = firestatus;
    }

    @Basic
    @Column(name = "insight")
    public int getInsight() {
        return insight;
    }

    public void setInsight(int insight) {
        this.insight = insight;
    }

    @Basic
    @Column(name = "upgrades")
    public int getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(int upgrades) {
        this.upgrades = upgrades;
    }

    @Basic
    @Column(name = "shield")
    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    @Basic
    @Column(name = "parry")
    public int getParry() {
        return parry;
    }

    public void setParry(int parry) {
        this.parry = parry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntity that = (PlayerEntity) o;
        return id == that.id && health == that.health && damage == that.damage && absorb == that.absorb && regen == that.regen && fire == that.fire && firestatus == that.firestatus && insight == that.insight && upgrades == that.upgrades && shield == that.shield && parry == that.parry && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(playername, that.playername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, playername, health, damage, absorb, regen, fire, firestatus, insight, upgrades, shield, parry);
    }
}
