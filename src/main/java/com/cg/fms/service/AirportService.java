package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entity.Airport;
import com.cg.fms.exception.AirportException;

public interface AirportService {


public Airport addAirport(Airport airport);

public List<Airport>  findAllAirports() throws AirportException;

public Airport deleteAirportById(int airportcode) throws AirportException;

public Airport findAirportById(int airportcode) throws AirportException;
 
public Airport updateAirportById(Airport airport) throws AirportException;

}

