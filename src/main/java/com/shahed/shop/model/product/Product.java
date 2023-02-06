package com.shahed.shop.model.product;

import com.shahed.shop.model.categories.Categories;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author m.mohabbati on 2/5/2023
 */

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_product")
    @SequenceGenerator(name = "seq_gen_product", sequenceName = "seq_gen_product", allocationSize = 1)
    private Long id;

    @Column(name = "created_date_time")
    private Timestamp createdDate;

    @Column(name = "title")
    private String title;

    @Column(name = "amout")
    private Long amount;

    @Column(name = "price")
    private String price;

    @Column(name = "description", length = 2000)
    private String description;

    @OneToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;
}
