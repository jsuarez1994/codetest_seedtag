package com.codetest.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.codetest.util.Constants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Protocols {
	CLOSESTENEMIES(Constants.CLOSESTENEMIES_LABEL, 6), FURTHESTENEMIES(Constants.FURTHESTENEMIES_LABEL, 5),
	ASSISTALLIES(Constants.ASSISTALLIES_LABEL, 2), AVOIDCROSSFIRE(Constants.AVOIDCROSSFIRE_LABEL, 1),
	PRIORITIZEMECH(Constants.PRIORITIZEMECH_LABEL, 4), AVOIDMECH(Constants.AVOIDMECH_LABEL, 3);

	/** the label */
	public String label;

	/** the description */
	public int order;

	public String getLabel() {
		return this.label;
	}

	public int getOrder() {
		return this.order;
	}

	public static boolean hasProtocol(String protocol) {
		List<Protocols> protocols = Arrays.asList(values());
		return protocols.stream().anyMatch((Protocols pro) -> pro.label.equals(protocol));
	}

	public static List<String> getProtocolByNameOrder(List<String> protocolsRequest) {
		if (CollectionUtils.isEmpty(protocolsRequest)) {
			return new ArrayList<>();
		} else {
			List<Protocols> protocolsByReq = new ArrayList<>();
			protocolsRequest.stream().filter((String prot) -> hasProtocol(prot))
					.forEach((String prot) -> protocolsByReq.add(getProtocolByName(prot)));

			return (CollectionUtils.isEmpty(protocolsByReq)) ? new ArrayList<>()
					: protocolsByReq.stream().sorted(Comparator.comparing(Protocols::getOrder)).map(Protocols::getLabel)
							.collect(Collectors.toList());
		}

	}

	public static Protocols getProtocolByName(String protocol) {
		List<Protocols> protocols = Arrays.asList(values());
		return protocols.stream().filter((Protocols prot) -> StringUtils.equals(prot.label, protocol)).findFirst()
				.orElse(null);
	}
}
