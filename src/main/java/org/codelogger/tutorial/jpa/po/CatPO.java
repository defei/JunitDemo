package org.codelogger.tutorial.jpa.po;

import javax.persistence.*;

/**
 * @author defei
 * @since 10/5/18.
 */
@Entity
@Table(name="cat")
public class CatPO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;

    public static CatPO of(String value){
        CatPO catPO = new CatPO();
        catPO.setValue(value);
        return catPO;
    }

    /**
     * {@linkplain CatPO#id}
     */
    public Long getId() {
        return id;
    }

    /**
     * {@linkplain CatPO#id}
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * {@linkplain CatPO#value}
     */
    public String getValue() {
        return value;
    }

    /**
     * {@linkplain CatPO#value}
     */
    public void setValue(String value) {
        this.value = value;
    }
}
