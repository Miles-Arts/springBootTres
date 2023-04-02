package med.voll.api.medico;

import jakarta.persistence.*;
import med.voll.api.direccion.DatosDireccion;
import med.voll.api.direccion.Direccion;
import org.springframework.web.bind.annotation.RestController;

@Table(name = "medicos")
@Entity(name = "Medico")
public class Medico {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;


}
