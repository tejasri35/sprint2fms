package com.cg.fms;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.dao.AirportDao;
import com.cg.fms.entity.Airport;
import com.cg.fms.exception.AirportException;
import com.cg.fms.service.AirportService;

@SpringBootTest
class FmsApplicationTests {
	@MockBean
private AirportDao airportdao;
	@Autowired
private AirportService airportservice;
	@Test
	public void getAirportsTest()  throws AirportException{
		when(airportdao.findAll()).thenReturn(Stream.of(new Airport(1012,"shamshabad","hyd"),new Airport(1013,"rgia","bng")).collect(Collectors.toList()));
	assertEquals(2,airportservice.findAllAirports().size());
	}
}