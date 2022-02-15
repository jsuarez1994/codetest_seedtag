package com.codetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.exception.ProtocolException;
import com.codetest.model.Coordinates;
import com.codetest.model.Request;
import com.codetest.service.YVHService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/codetest")
@Slf4j
public class YVHController {

	@Autowired
	private YVHService yvhService;

	@ApiOperation(value = "Radar")
	@PostMapping(path = "/radar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Coordinates> radar(@RequestBody Request request) {
		log.info("Inicializamos metodo radar");
		try {
			Coordinates response = yvhService.getCoordinates(request);
			log.info("Terminamos metodo radar");
			return ResponseEntity.ok(response);
		} catch (ProtocolException e) {
			log.error("Error metodo radar: {}", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
