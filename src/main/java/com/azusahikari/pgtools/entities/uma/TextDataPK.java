package com.azusahikari.pgtools.entities.uma;

import lombok.Data;

import java.io.Serializable;

@Data
public class TextDataPK implements Serializable {
    private String category;
    private String index;
}
