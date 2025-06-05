package pe.oxxo.documents.infra.in.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.oxxo.documents.app.query.service.DocumentsService;
import pe.oxxo.documents.domain.model.Documents;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/documents")
public class DocumentsController {

    private final DocumentsService documentsService;

    @Operation(summary = "Endpoint que verifica la autentificacion de un usuario y retorna un String con el nombre  e id del usuario " +
            "en caso de ser validado", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "403", description  = "Header de autentificacion invalido"),
            @ApiResponse(responseCode = "500", description  = "Token invalida"),
    })
    @GetMapping("hello")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + "!! Your user id is: ";
    }

    @Operation(summary = "Endpoint que inserta datos en documents", security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion exitosa"),
            @ApiResponse(responseCode = "403", description  = "Header de autentificacion invalido"),
            @ApiResponse(responseCode = "500", description  = "Token invalida"),
    })
    @PostMapping
    public ResponseEntity<Documents> saveProduct(@RequestBody Documents documents){
        log.info("Hola saveProduct");
        log.info("Product: {}",documents);
        return new ResponseEntity<>(documentsService.save(documents), HttpStatus.CREATED);
    }
}
