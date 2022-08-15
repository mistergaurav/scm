package com.exafluence.main.model;



import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Component
@Document(collection="shipment")
public class Shipment {
@Id 
private String id;
@NotBlank(message="Shipment number should not be blank")
private String shipmentNumber;
@NotBlank(message="discription should not be blank")
private String shipmentDiscription;
@NotBlank(message="containor should not be blank")
private String containerNumber;
@NotBlank(message="PO Number should not be blank")
private String poNumber;
@NotBlank(message="delivery number should not be blank")
private String deliveryNumber;
@NotBlank(message="delivery date should not be blank")
private String deliveryDate;
private String ndcNumber;
private String batchId;
private String serialNumberOfGoods;
private String device;
private String routeDetails;

private String goodsType;



public Shipment() {
}



public Shipment(@NotBlank(message = "Shipment number should not be blank") String shipmentNumber,
		@NotBlank(message = "discription should not be blank") String shipmentDiscription,
		@NotBlank(message = "containor should not be blank") String containerNumber,
		@NotBlank(message = "PO Number should not be blank") String poNumber,
		@NotBlank(message = "delivery number should not be blank") String deliveryNumber,
		@NotBlank(message = "delivery date should not be blank") String deliveryDate, String ndcNumber, String batchId,
		String serialNumberOfGoods, String device, String routeDetails, String goodsType) {
	super();
	this.shipmentNumber = shipmentNumber;
	this.shipmentDiscription = shipmentDiscription;
	this.containerNumber = containerNumber;
	this.poNumber = poNumber;
	this.deliveryNumber = deliveryNumber;
	this.deliveryDate = deliveryDate;
	this.ndcNumber = ndcNumber;
	this.batchId = batchId;
	this.serialNumberOfGoods = serialNumberOfGoods;
	this.device = device;
	this.routeDetails = routeDetails;
	this.goodsType = goodsType;
}



public String getId() {
	return id;
}



public void setId(String id) {
	this.id = id;
}



public String getShipmentNumber() {
	return shipmentNumber;
}



public void setShipmentNumber(String shipmentNumber) {
	this.shipmentNumber = shipmentNumber;
}



public String getShipmentDiscription() {
	return shipmentDiscription;
}



public void setShipmentDiscription(String shipmentDiscription) {
	this.shipmentDiscription = shipmentDiscription;
}



public String getContainerNumber() {
	return containerNumber;
}



public void setContainerNumber(String containerNumber) {
	this.containerNumber = containerNumber;
}



public String getPoNumber() {
	return poNumber;
}



public void setPoNumber(String poNumber) {
	this.poNumber = poNumber;
}



public String getDeliveryNumber() {
	return deliveryNumber;
}



public void setDeliveryNumber(String deliveryNumber) {
	this.deliveryNumber = deliveryNumber;
}



public String getDeliveryDate() {
	return deliveryDate;
}



public void setDeliveryDate(String deliveryDate) {
	this.deliveryDate = deliveryDate;
}



public String getNdcNumber() {
	return ndcNumber;
}



public void setNdcNumber(String ndcNumber) {
	this.ndcNumber = ndcNumber;
}



public String getBatchId() {
	return batchId;
}



public void setBatchId(String batchId) {
	this.batchId = batchId;
}



public String getSerialNumberOfGoods() {
	return serialNumberOfGoods;
}



public void setSerialNumberOfGoods(String serialNumberOfGoods) {
	this.serialNumberOfGoods = serialNumberOfGoods;
}



public String getDevice() {
	return device;
}



public void setDevice(String device) {
	this.device = device;
}



public String getRouteDetails() {
	return routeDetails;
}



public void setRouteDetails(String routeDetails) {
	this.routeDetails = routeDetails;
}



public String getGoodsType() {
	return goodsType;
}



public void setGoodsType(String goodsType) {
	this.goodsType = goodsType;
}


}
