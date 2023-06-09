package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;


    @PostMapping
    public void registrarMedico(@RequestBody @Valid  DatosRegistroMedico datosRegistroMedico) {

        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    //public List<DatosListadoMedico> listadoMedicos()
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault() Pageable paginacion) {
        //return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
        return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
       Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());

       medico.actualizarDatos(datosActualizarMedico);

    }
    //@DeleteMapping("/7") //Dete fijo
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {

        Medico medico = medicoRepository.getReferenceById(id);

        medicoRepository.delete(medico);

        return ResponseEntity.noContent().build();

    }
}
