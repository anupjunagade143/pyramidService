package com.fetchRewards.services.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ValidateServiceImpl implements ValidateService {

	@Override
	public boolean validatePyramidString(String input) {

		boolean result = true;
		Map<String, Integer> alphabetCountMap = new HashMap<>();
		for (int cnt = 0; cnt < input.length(); cnt++) {
			String strVal = String.valueOf(input.charAt(cnt));
			alphabetCountMap.put(strVal, alphabetCountMap.getOrDefault(strVal, 0) + 1);
		}
		List<Integer> valueCntList = alphabetCountMap.values().stream().sorted().collect(Collectors.toList());

		for (int i = 1; i < valueCntList.size(); i++) {
			if ((valueCntList.get(i) != valueCntList.get(i - 1) + 1)) {
				result = false;
				break;
			}
		}
		return result;
	}

}
