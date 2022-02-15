package com.codetest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enemies {
	/** the type */
	public String type;

	/** the number */
	public int number;
}
