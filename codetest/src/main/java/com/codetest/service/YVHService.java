package com.codetest.service;

import com.codetest.exception.ProtocolException;
import com.codetest.model.Coordinates;
import com.codetest.model.Request;

public interface YVHService {
	
	/**
	 * Devuelve coodenadas enemigas
	 * @param request the Request
	 * @return Coodinates
	 * @throws ProtocolException the exception
	 */
	Coordinates getCoordinates(Request request) throws ProtocolException;

}
