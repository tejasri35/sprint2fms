package com.cg.fms.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fms.entity.Airport;

@Repository
public interface AirportDao extends JpaRepository<Airport,Integer>{


}