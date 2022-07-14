package com.prueba.tecnica.controllers;

import com.prueba.tecnica.models.Ciclistas;
import com.prueba.tecnica.services.CiclistasService;
import com.prueba.tecnica.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin
@RestController
@RequestMapping("/equipos/ciclistas")
public class CiclistasController {

    @Autowired
    CiclistasService ciclistasService;

    private final Response response = new Response();
    private HttpStatus httpStatus = HttpStatus.OK;



    @GetMapping()
    public ResponseEntity<Response> getCilclistas() {
        response.restart();
        try {
            response.data = ciclistasService.getCiclistas();
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> getCiclistaPorId(@PathVariable(value = "id") Long id) {
        response.restart();
        try {
            response.data = ciclistasService.findById(id);
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }



    @PostMapping()
    public ResponseEntity<Response> saveCiclista(@RequestBody Ciclistas ciclistas) {

        response.restart();
        try {
            response.data = ciclistasService.saveCiclista(ciclistas);
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateCiclista(@RequestBody Ciclistas ciclistas, @PathVariable(value = "id") Long id) {

        response.restart();
        try {
            response.data = ciclistasService.updateCiclista(id, ciclistas);
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response> deleteCiclista(@PathVariable(value = "id") Long id) {
        response.restart();
        try {
            response.data = ciclistasService.deleteUserRol(id);
            if (response.data == null) {
                response.message = "NO EXISTE";
                httpStatus = HttpStatus.NOT_FOUND;
            } else {
                response.message = "ELIMINADO";
                httpStatus = HttpStatus.OK;
            }
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }


    private void getErrorMessageForResponse(DataAccessException exception) {
        response.error = true;
        if (exception.getRootCause() instanceof SQLException) {
            SQLException sqlEx = (SQLException) exception.getRootCause();
            var sqlErrorCode = sqlEx.getErrorCode();
            switch (sqlErrorCode) {
                case 1062:
                    response.message = "REGISTRADO";
                    break;
                case 1452:
                    response.message = "NO EXISTE";
                    break;
                default:
                    response.message = exception.getMessage();
                    response.data = exception.getCause();
            }
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            response.message = exception.getMessage();
            response.data = exception.getCause();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }


    private void getErrorMessageInternal(Exception exception) {
        response.error = true;
        response.message = exception.getMessage();
        response.data = exception.getCause();
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
