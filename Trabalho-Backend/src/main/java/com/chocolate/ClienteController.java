package com.chocolate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/api/cliente"})
public class ClienteController {
    @Autowired
    ClienteService service;

    @GetMapping
    public List<Cliente> listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity adicionar(@RequestBody @Valid Cliente p){
        ClienteC clienteC = new ClienteC();
        if(clienteC.validarCliente(p)){
            p = service.add(p);
            return new ResponseEntity(p, HttpStatus.OK);

        } else {
            return new ResponseEntity("Nome é inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        //return service.add(p);
    }

    @GetMapping(path = {"/{id}"})
    public Cliente listarId(@PathVariable("id")int id){
        return service.listarId(id);
    }
    @PutMapping(path = {"/{id}"})
    public Cliente editar(@RequestBody Cliente p, @PathVariable("id") int id){
        p.setId(id);
        return service.edit(p);
    }

    @DeleteMapping(path = {"/{id}"})
    public Cliente delete(@PathVariable("id") int  id){
        return service.delete(id);
    }
}
