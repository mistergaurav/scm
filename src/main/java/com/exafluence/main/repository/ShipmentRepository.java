package com.exafluence.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exafluence.main.model.Shipment;

public interface ShipmentRepository extends MongoRepository<Shipment, String> {



}
