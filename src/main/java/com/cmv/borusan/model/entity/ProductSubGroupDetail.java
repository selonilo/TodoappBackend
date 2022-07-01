package com.cmv.borusan.model.entity;

import com.cmv.borusan.model.base.ExtendedModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_sub_group_detail")
public class ProductSubGroupDetail extends ExtendedModel {

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductSubGroup productSubGroup;

    @OneToMany(mappedBy = "productSubGroupDetail",cascade = CascadeType.ALL)
    private List<ProductLastDetail> productLastDetails;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_user")
    private String updateUser;

}
