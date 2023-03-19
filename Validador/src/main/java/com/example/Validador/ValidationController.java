package com.example.Validador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidationController {
    private final ValidationService validationService;
    @Autowired
    public ValidationController(com.example.Validador.ValidationService validationService) {
        this.validationService = validationService;
    }
//    @RequestMapping(value = "/Person", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @PostMapping("/ArchivosCSV")
    public boolean procesar(@RequestBody Person persona){

        boolean validez = validationService.validarLinea(persona);
        System.out.println(validez);
        return validez;
    }
}
