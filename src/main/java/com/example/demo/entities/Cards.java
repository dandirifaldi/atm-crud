package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="tb_m_cards")
public class Cards {
    @Id
    private String card_id;
    private String cardtype;
    private Date valid_thru;
    
    public String getCard_id() {
        return card_id;
    }
    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
    public String getCardtype() {
        return cardtype;
    }
    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }
    public Date getValid_thru() {
        return valid_thru;
    }
    public void setValid_thru(Date valid_thru) {
        this.valid_thru = valid_thru;
    }
}
