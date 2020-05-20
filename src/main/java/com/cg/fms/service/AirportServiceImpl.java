package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.AirportDao;

import com.cg.fms.entity.Airport;

import com.cg.fms.exception.AirportException;



@Service
public class AirportServiceImpl implements AirportService {

@Autowired
AirportDao airportDao;


@Override
public Airport addAirport(Airport airport) {
	List<Airport> list=airportDao.findAll();
   
      Airport tr= airportDao.saveAndFlush(airport);


return tr;
}





@Override
public List<Airport> findAllAirports() throws AirportException {
List<Airport> list=airportDao.findAll();
return list;
}

@Override
public Airport deleteAirportById(int airportcode) throws AirportException {


Airport tr=null;
if(airportDao.existsById(airportcode))
{
tr = airportDao.findById(airportcode).get();
airportDao.deleteById(airportcode);
}
else
{
throw new AirportException(" ID NOT FOUND ");
}
return tr ;
}

@Override
public Airport findAirportById(int airportcode) throws AirportException {
Airport airport = null;
if( airportDao.existsById(airportcode))
{
airport = airportDao.findById(airportcode).get();
}
else
{
throw new AirportException(airportcode+ " ID NOT FOUND ");
}
return airport;

}





@Override
public Airport updateAirportById(Airport airport) throws AirportException {
	
	
	int airportcode = airport.getAcode();
	if( airportDao.existsById(airportcode))
	{
		 Airport he = airportDao.findById(airportcode).get();
		 airportDao.saveAndFlush(airport);
	}
	else
	{
		throw new AirportException("Id not found");
	}
	return airport ;
}




}











