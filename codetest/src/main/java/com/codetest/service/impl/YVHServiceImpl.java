package com.codetest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.codetest.exception.ProtocolException;
import com.codetest.model.Coordinates;
import com.codetest.model.Protocols;
import com.codetest.model.Request;
import com.codetest.model.Scan;
import com.codetest.service.YVHService;
import com.codetest.util.Constants;
import com.codetest.util.ExceptionConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class YVHServiceImpl implements YVHService {

	/**
	 * Devuelve coodenadas enemigas
	 * 
	 * @param request the Request
	 * @return Coodinates
	 * @throws ProtocolException the exception
	 */
	@Override
	public Coordinates getCoordinates(Request request) throws ProtocolException {
		// Obtenemos los scans
		List<Scan> scans = request.getScan();

		// Verificamos que existan los protocolos
		if (verifyProtocols(request) && !CollectionUtils.isEmpty(request.getProtocols())) {
			// Obtenemos los protocolos por orden
			List<String> protocolsByOrder = Protocols.getProtocolByNameOrder(request.getProtocols());

			for (String protocol : protocolsByOrder) {
				scans = getScansByProtocol(scans, protocol);
			}
		}

		return CollectionUtils.isEmpty(scans) ? new Coordinates() : scans.get(0).getCoordinates();
	}

	/**
	 * Obtenemos los scans por protocol
	 * 
	 * @param scans    the List Scans
	 * @param protocol the protocol
	 */
	private List<Scan> getScansByProtocol(List<Scan> scans, String protocol) {

		switch (protocol) {
		case Constants.CLOSESTENEMIES_LABEL:
			scans = getProtocolClosestEnemies(scans);
			break;
		case Constants.FURTHESTENEMIES_LABEL:
			scans = getProtocolFurthestEnemies(scans);
			break;
		case Constants.ASSISTALLIES_LABEL:
			scans = getProtocolAssistAllies(scans);
			break;
		case Constants.AVOIDCROSSFIRE_LABEL:
			scans = getProtocolAvoidCrossfire(scans);
			break;
		case Constants.PRIORITIZEMECH_LABEL:
			scans = getProtocolPrioritizeMech(scans);
			break;
		case Constants.AVOIDMECH_LABEL:
			scans = getProtocolAvoidMech(scans);
			break;
		default:
			log.info("PROTOCOLO NO CONTROLADO");
			break;
		}
		return scans;
	}

	/**
	 * No debe de atacarse ningun enemigo del tipo mech
	 * 
	 * @param scans the Scans
	 * @return List Scans
	 */
	private List<Scan> getProtocolAvoidMech(List<Scan> scans) {
		return scans.stream()
				.filter((Scan scan) -> !StringUtils.equals(scan.getEnemies().getType(), Constants.TYPE_MECH))
				.collect(Collectors.toList());
	}

	/**
	 * Debe de atacarse un mech si se encuentra. En caso negativo, cualquier otro
	 * tipo de objetivo sera valido.
	 * 
	 * @param scans the Scans
	 * @return List Scans
	 */
	private List<Scan> getProtocolPrioritizeMech(List<Scan> scans) {
		// Obtenemos los enemigos mechs
		List<Scan> mechs = scans.stream()
				.filter((Scan scan) -> StringUtils.equals(scan.getEnemies().getType(), Constants.TYPE_MECH))
				.collect(Collectors.toList());
		// Si no hay enemigos mechs recogemos los que no sean mechs
		return (CollectionUtils.isEmpty(mechs)) ? scans.stream()
				.filter((Scan scan) -> !StringUtils.equals(scan.getEnemies().getType(), Constants.TYPE_MECH))
				.collect(Collectors.toList()) : mechs;
	}

	/**
	 * No debe de atacarse ningun punto en el que haya algun aliado.
	 * 
	 * @param scans the Scans
	 * @return List Scans
	 */
	private List<Scan> getProtocolAvoidCrossfire(List<Scan> scans) {
		return scans.stream().filter((Scan scan) -> scan.getAllies() == 0).collect(Collectors.toList());
	}

	/**
	 * Deberan de priorizarse los puntos en los que exista algun aliado.
	 * 
	 * @param scans the Scans
	 * @return List Scans
	 */
	private List<Scan> getProtocolAssistAllies(List<Scan> scans) {
		return scans.stream().filter((Scan scan) -> scan.getAllies() > 0).collect(Collectors.toList());
	}

	/**
	 * Se debera priorizar el punto mas lejano en el que haya enemigos.
	 * 
	 * @param scans the Scans
	 * @return List Scans
	 */
	private List<Scan> getProtocolFurthestEnemies(List<Scan> scans) {
		List<Scan> scanBigX = new ArrayList<>();

		int postXBigger = scans.stream().map(Scan::getCoordinates).mapToInt(Coordinates::getX).max().orElse(0);
		scans.stream().filter((Scan scan) -> scan.getCoordinates().getX() == postXBigger).forEach(scanBigX::add);

		List<Scan> response = new ArrayList<>();
		int postYBigger = scanBigX.stream().map(Scan::getCoordinates).mapToInt(Coordinates::getY).max().orElse(0);
		scanBigX.stream().filter((Scan scan) -> scan.getCoordinates().getY() == postYBigger).forEach(response::add);

		return response;
	}

	/**
	 * Se debera priorizar el punto mas cercano en el que haya enemigos.
	 * 
	 * @param scans the Scans
	 * @return List Scans
	 */
	private List<Scan> getProtocolClosestEnemies(List<Scan> scans) {
		List<Scan> scanBigX = new ArrayList<>();

		int postXBigger = scans.stream().map(Scan::getCoordinates).mapToInt(Coordinates::getX).min().orElse(0);
		scans.stream().filter((Scan scan) -> scan.getCoordinates().getX() == postXBigger).forEach(scanBigX::add);

		List<Scan> response = new ArrayList<>();
		int postYBigger = scanBigX.stream().map(Scan::getCoordinates).mapToInt(Coordinates::getY).min().orElse(0);
		scanBigX.stream().filter((Scan scan) -> scan.getCoordinates().getY() == postYBigger).forEach(response::add);

		return response;
	}

	private boolean verifyProtocols(Request request) throws ProtocolException {
		boolean response = true;
		List<String> protocols = request.getProtocols();
		for (String protocol : protocols) {
			if (!Protocols.hasProtocol(protocol)) {
				String error = ExceptionConstants.PROTOCOL_NOT_FOUND.replace("{}", protocol);
				throw new ProtocolException(error);
			}
		}
		return response;
	}

}
