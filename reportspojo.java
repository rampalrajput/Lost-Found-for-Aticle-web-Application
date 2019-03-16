package Dao;

import java.util.Date;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class reportspojo {
    private String item_id;
     private String item_name;
    private String item_cat;
    private String item_palce;
    private String item_desc ;
    private String item_img ;
    private Date item_date ;   
    private String Report_type ;
    private String Reward ;

    public String getReward() {
        return Reward;
    }

    public void setReward(String Reward) {
        this.Reward = Reward;
    }

    public String getReport_type() {
        return Report_type;
    }

    public void setReport_type(String Report_type) {
        this.Report_type = Report_type;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_cat() {
        return item_cat;
    }

    public void setItem_cat(String item_cat) {
        this.item_cat = item_cat;
    }

    public String getItem_palce() {
        return item_palce;
    }

    public void setItem_palce(String item_palce) {
        this.item_palce = item_palce;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getItem_img() {
        return item_img;
    }

    public void setItem_img(String item_img) {
        this.item_img = item_img;
    }

    public Date getItem_date() {
        return item_date;
    }

    public void setItem_date(Date item_date) {
        this.item_date = item_date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.item_id);
        hash = 89 * hash + Objects.hashCode(this.item_name);
        hash = 89 * hash + Objects.hashCode(this.item_cat);
        hash = 89 * hash + Objects.hashCode(this.item_palce);
        hash = 89 * hash + Objects.hashCode(this.item_desc);
        hash = 89 * hash + Objects.hashCode(this.item_img);
        hash = 89 * hash + Objects.hashCode(this.item_date);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final reportspojo other = (reportspojo) obj;
        if (!Objects.equals(this.item_id, other.item_id)) {
            return false;
        }
        if (!Objects.equals(this.item_name, other.item_name)) {
            return false;
        }
        if (!Objects.equals(this.item_cat, other.item_cat)) {
            return false;
        }
        if (!Objects.equals(this.item_palce, other.item_palce)) {
            return false;
        }
        if (!Objects.equals(this.item_desc, other.item_desc)) {
            return false;
        }
        if (!Objects.equals(this.item_img, other.item_img)) {
            return false;
        }
        if (!Objects.equals(this.item_date, other.item_date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reportspojo{" + "item_id=" + item_id + ", item_name=" + item_name + ", item_cat=" + item_cat + ", item_palce=" + item_palce + ", item_desc=" + item_desc + ", item_img=" + item_img + ", item_date=" + item_date + '}';
    }
    
}
