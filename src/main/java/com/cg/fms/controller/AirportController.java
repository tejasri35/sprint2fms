package com.cg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entity.Airport;
import com.cg.fms.exception.AirportException;
import com.cg.fms.service.AirportService;


@RestController
@CrossOrigin("*")
public class AirportController {

@Autowired
AirportService airportService;

@GetMapping("airport/{id}")
public ResponseEntity<Airport> findAirportById(@PathVariable("id")  int airportcode) throws AirportException
{
Airport  airport = airportService.findAirportById(airportcode);
  ResponseEntity<Airport>  tr = new ResponseEntity<>(airport,HttpStatus.OK);
  return tr;

}

@PostMapping("airport")
public ResponseEntity<Airport> createAirport(@RequestBody Airport airport)
{
Airport t=airportService.addAirport(airport);    

ResponseEntity<Airport> tr=new ResponseEntity<Airport>(t,HttpStatus.OK);

return tr;
}
@GetMapping("airport")
public ResponseEntity<List<Airport>> findAllAirports() throws AirportException
{
List<Airport> list = airportService.findAllAirports();
ResponseEntity<List<Airport>>  rt = new ResponseEntity<List<Airport>>(list,HttpStatus.OK);
return rt;
}

@DeleteMapping("airport/{id}")
public ResponseEntity<Airport> deleteAirportById(@PathVariable("id") int airportcode) throws AirportException
{

Airport  airport = airportService.findAirportById(airportcode);
ResponseEntity<Airport>  rt = null;

if(airport!=null)
{
rt= new ResponseEntity<Airport>(airport,HttpStatus.OK);
airportService.deleteAirportById(airportcode);
}
else
{
rt=new ResponseEntity<Airport>(HttpStatus.NOT_FOUND);
}
   
return rt;
}

@PutMapping("airport")
public  ResponseEntity<Airport>  updateCenterById(@RequestBody Airport hea) throws  Exception
{
	ResponseEntity<Airport>  rt = null;
	
	if(hea!=null)
	{
		hea= airportService.updateAirportById(hea);
		rt= new ResponseEntity<Airport>(hea,HttpStatus.OK);
	}
	else
	{
		rt=new ResponseEntity<Airport>(HttpStatus.NOT_FOUND);
	}
	return rt;
}


}












