package com.cmv.borusan.model.entity;

import com.cmv.borusan.model.base.ExtendedModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_area")
public class ProductArea extends ExtendedModel {

    @ManyToMany(mappedBy = "productAreas",cascade = CascadeType.ALL)
    List<ProductGroup> productGroups = new ArrayList<>();

    @Column(name = "name")
   private String name;
}
