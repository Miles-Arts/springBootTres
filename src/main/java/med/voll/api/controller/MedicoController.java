package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;


    @PostMapping
    public void registrarMedico(@Valid  @RequestBody  DatosRegistroMedico datosRegistroMedico) {

        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    //public List<DatosListadoMedico> listadoMedicos()
    public Page<DatosListadoMedico> listadoMedicos(@PageableDefault() Pageable paginacion) {
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }

}
