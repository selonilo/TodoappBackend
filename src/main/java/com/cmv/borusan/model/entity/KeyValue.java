package com.cmv.borusan.model.entity;

import com.cmv.borusan.model.base.ExtendedModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "KeyValue")
public class KeyValue extends ExtendedModel {

    @Column(name = "key")
    private String Key;

    @Column(name = "value")
    private String Value;
}
