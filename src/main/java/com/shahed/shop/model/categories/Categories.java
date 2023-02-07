package com.shahed.shop.model.categories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author m.mohabbati on 2/5/2023
 */
@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_categories")
    @SequenceGenerator(name = "seq_gen_categories", sequenceName = "seq_gen_categories", allocationSize = 5, initialValue = 200)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "code",unique =true)
    private String code;
}
