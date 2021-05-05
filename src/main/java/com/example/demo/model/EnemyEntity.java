package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "enemy", schema = "public", catalog = "coliseumstats")
public class EnemyEntity {
    private long id;
    private String title;
    private int health;
    private int damage;
    private int hitch;
    private int attime;
    private int critch;
    private int breakch;
    private int body;
    private int head;
    private int arms;
    private int legs;
    private int lacrit;
    private int racrit;
    private int llcrit;
    private int rlcrit;
    private String weapon;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "hitch")
    public int getHitch() {
        return hitch;
    }

    public void setHitch(int hitch) {
        this.hitch = hitch;
    }

    @Basic
    @Column(name = "attime")
    public int getAttime() {
        return attime;
    }

    public void setAttime(int attime) {
        this.attime = attime;
    }

    @Basic
    @Column(name = "critch")
    public int getCritch() {
        return critch;
    }

    public void setCritch(int critch) {
        this.critch = critch;
    }

    @Basic
    @Column(name = "breakch")
    public int getBreakch() {
        return breakch;
    }

    public void setBreakch(int breakch) {
        this.breakch = breakch;
    }

    @Basic
    @Column(name = "body")
    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    @Basic
    @Column(name = "head")
    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    @Basic
    @Column(name = "arms")
    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    @Basic
    @Column(name = "legs")
    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Basic
    @Column(name = "lacrit")
    public int getLacrit() {
        return lacrit;
    }

    public void setLacrit(int lacrit) {
        this.lacrit = lacrit;
    }

    @Basic
    @Column(name = "racrit")
    public int getRacrit() {
        return racrit;
    }

    public void setRacrit(int racrit) {
        this.racrit = racrit;
    }

    @Basic
    @Column(name = "llcrit")
    public int getLlcrit() {
        return llcrit;
    }

    public void setLlcrit(int llcrit) {
        this.llcrit = llcrit;
    }

    @Basic
    @Column(name = "rlcrit")
    public int getRlcrit() {
        return rlcrit;
    }

    public void setRlcrit(int rlcrit) {
        this.rlcrit = rlcrit;
    }

    @Basic
    @Column(name = "weapon")
    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnemyEntity that = (EnemyEntity) o;
        return id == that.id && health == that.health && damage == that.damage && hitch == that.hitch && attime == that.attime && critch == that.critch && breakch == that.breakch && body == that.body && head == that.head && arms == that.arms && legs == that.legs && lacrit == that.lacrit && racrit == that.racrit && llcrit == that.llcrit && rlcrit == that.rlcrit && Objects.equals(title, that.title) && Objects.equals(weapon, that.weapon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, health, damage, hitch, attime, critch, breakch, body, head, arms, legs, lacrit, racrit, llcrit, rlcrit, weapon);
    }
}
