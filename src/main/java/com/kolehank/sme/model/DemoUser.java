package com.kolehank.sme.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "DEMO_USER")
public class DemoUser {
    @Id
    @Column(name = "USERID")
    @SequenceGenerator(name = "sql", sequenceName = "SEQ_DEMO_USER")
    //@GeneratedValue(strategy= GenerationType.IDENTITY,generator = "Select SEQ_DEMO_USER.nextval from dual")
    private Long userid;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USERNAME")
    private String username;

    /**
     * @return USERID
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return USERNAME
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}