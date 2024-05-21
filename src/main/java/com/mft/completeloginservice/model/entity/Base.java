package com.mft.completeloginservice.model.entity;


import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;




@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@MappedSuperclass
public class Base implements Serializable {
    @Column(length = 1)
    @JsonbTransient
    private Boolean deleted;

    @Version
    @JsonbTransient
    private Long versionId;


}
