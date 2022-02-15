package com.codetest.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Request {
	/** the protocols */
	public List<String> protocols;
	
	/** the scan */
	public List<Scan> scan;
	
}
