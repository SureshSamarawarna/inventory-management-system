package lk.ijse.dep9.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "name")
    private String name;
    private BigDecimal price;
    private int qty;
    private BigDecimal discount;
    private String category;
}
