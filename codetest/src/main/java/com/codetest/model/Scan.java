package com.codetest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Scan {
	/** the coordinates */
	public Coordinates coordinates;

	/** the enemies */
	public Enemies enemies;
	
	/** the allies */
	public int allies;
}
