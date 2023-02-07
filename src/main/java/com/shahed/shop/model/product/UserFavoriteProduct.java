package com.shahed.shop.model.product;

import com.shahed.shop.model.userAccount.UserAccount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author m.mohabbati on 2/7/2023
 */
@Entity
@Table(name = "user_fav_product")
@Getter
@Setter
@NoArgsConstructor
public class UserFavoriteProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_user_fav_product")
    @SequenceGenerator(name = "seq_gen_user_fav_product", sequenceName = "seq_gen_user_fav_product", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    @Column(name = "created_date_time")
    private Timestamp createdDate;
}
