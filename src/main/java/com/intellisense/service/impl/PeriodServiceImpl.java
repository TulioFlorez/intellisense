package com.intellisense.service.impl;


import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.intellisense.dto.AssetDto;
import com.intellisense.dto.PeriodDto;
import com.intellisense.service.PeriodService;

@Service
public class PeriodServiceImpl implements PeriodService {
	List<Double> listpromedio = new ArrayList<Double>();
	

	@Override
	public AssetDto getAvarageAssetService(PeriodDto periodDto) {	
		return callReferenceApi( periodDto);
	}
	
	
	
	private AssetDto callReferenceApi(PeriodDto periodDto) {
		AssetDto avarageByAsset = null;
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
			RestTemplate seizureOutTemplate = new RestTemplate();

			URI urlUri;
			urlUri = new URI(String.format("%s", "https://reference.intellisense.io/test.dataprovider"));

			ResponseEntity<Object> response = seizureOutTemplate.exchange(urlUri, HttpMethod.GET, requestEntity,
					new ParameterizedTypeReference<Object>() {
					});
			if (200 == response.getStatusCode().value()) {			
				 avarageByAsset = ReadJSON(periodDto);
			}
		
		} catch (URISyntaxException ex) {
			avarageByAsset = ReadJSON (periodDto);

		}catch (RuntimeException ex) {
			
			avarageByAsset = ReadJSON (periodDto);

		}
		
		return avarageByAsset;
	}
	
	private AssetDto ReadJSON (PeriodDto periodDto) {
		 AssetDto AssetDto = new AssetDto();
		 try {
			
		        JSONParser parser = new JSONParser();//Use JSONObject for simple JSON and JSONArray for array of JSON. 
		        JSONObject data = (JSONObject) parser.parse(
		              new FileReader("intellisense.json"));//path to the JSON file.
		        JSONObject date =  (JSONObject) data.get("660");
		         @SuppressWarnings("unchecked")
		        List<Double> _3000 = (List<Double>) date.get("3000");
		         _3000.removeAll(Collections.singleton(null));
		        List<Double> _3000Avarage = getavarage(_3000,periodDto);
		        AssetDto.set_3000(_3000Avarage);
		         
				@SuppressWarnings("unchecked")
				List<Double> _3001 = (List<Double>) date.get("3001");
				_3001.removeAll(Collections.singleton(null));
				 List<Double> _3001Avarage =getavarage(_3001,periodDto);
				 AssetDto.set_3001(_3001Avarage);
				 
		        @SuppressWarnings("unchecked")
				List<Double> _3002 = (List<Double>) date.get("3002");
		        _3002.removeAll(Collections.singleton(null));
		        List<Double> _3002Avarage =getavarage(_3002,periodDto);
		        AssetDto.set_3002(_3002Avarage);
		        
		        @SuppressWarnings("unchecked")
				List<Double> _3003 = (List<Double>) date.get("3003");
		        _3003.removeAll(Collections.singleton(null));
		        List<Double> _3003Avarage= getavarage(_3003,periodDto);
		        AssetDto.set_3003(_3003Avarage);
		        
		        @SuppressWarnings("unchecked")
				List<Double> _3004 = (List<Double>) date.get("3004");
		        _3004.removeAll(Collections.singleton(null));
		        List<Double> _3004Avarage= getavarage(_3004,periodDto);
		        AssetDto.set_3004(_3004Avarage);
		        
		        @SuppressWarnings("unchecked")
				List<Double> _3005 = (List<Double>) date.get("3005");
		        _3005.removeAll(Collections.singleton(null));
		        List<Double> _3005Avarage= getavarage(_3005,periodDto);
		        AssetDto.set_3005(_3005Avarage);
		        	         
		        return AssetDto;
		        
		    } catch (IOException | ParseException e) {
		        e.printStackTrace();
		    }
		return AssetDto;
		
	}


	private List<Double> getavarage(List<Double> Asset, PeriodDto periodDto) {
		
		List<Double> listAvareByAsset = new ArrayList<Double>();
		int lenght = 1;
		double sumaOfvalues = 0;
		double values = 0.0;
		final int G = periodDto.getPeriod();
		final int segmentation = (Asset.size() + G - 1) / G;

		List<List<Double>> segmentationbyAsset = IntStream.range(0, segmentation)
				.mapToObj(i -> Asset.subList(G * i, Math.min(G * i + G, Asset.size()))).collect(Collectors.toList());

		for (int a = 0; a < segmentationbyAsset.size(); a++) {
			sumaOfvalues = 0;
			for (int p = 0; p < segmentationbyAsset.get(a).size(); p++) {

				if (segmentationbyAsset.get(a).get(p) instanceof Number) {
					values = ((Number) segmentationbyAsset.get(a).get(p)).doubleValue();
				}
				lenght = segmentationbyAsset.get(a).size();
				sumaOfvalues += values;
			}
			listAvareByAsset.add(sumaOfvalues / lenght);
		}
		return listAvareByAsset;

	}
}
