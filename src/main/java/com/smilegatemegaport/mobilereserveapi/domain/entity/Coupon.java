package com.smilegatemegaport.mobilereserveapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coupon implements Persistable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long sequence;
    private String phoneNumber;
    private String couponNumber;
    private LocalDateTime createDate;

    @PrePersist
    protected void onUpdate() {
        createDate = LocalDateTime.now();
    }

    @Override
    @Transient
    @JsonIgnore
    public String getId() {
        return phoneNumber;
    }

    @Override
    @Transient
    @JsonIgnore
    public boolean isNew() {
        return true;
    }
}
