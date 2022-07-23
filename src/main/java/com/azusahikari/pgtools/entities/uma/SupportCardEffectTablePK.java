package com.azusahikari.pgtools.entities.uma;

import lombok.Data;

import java.io.Serializable;

@Data
public class SupportCardEffectTablePK implements Serializable {
    private String id;
    private String type;
}
