package com.taller2.practica1.models.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[a-zA-ZàáèéìíòóùúüñÑ\\s]+$", message = "El nombre solo puede contener letras o espacios")
    private String nombre;

    @NotEmpty
    @Size(min=1, max=50)
    @Pattern(regexp = "^[a-zA-ZàáèéìíòóùúüñÑ\\s]+$", message = "El apellido solo puede contener letras o espacios")
    private String apellido;

    @NotEmpty
    @Email
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE) //indica que se manejará solo la fecha sin la hora
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }

    private static final long serialVersionUID = 1L;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
