package com.exafluence.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.exafluence.main.model.Shipment;
import com.exafluence.main.repository.ShipmentRepository;

@Controller
public class ShipmentController {



@Autowired
private ShipmentRepository repository;






	@RequestMapping(value="/showShipment", method=RequestMethod.GET)
	public ModelAndView createNewShipment() {
	ModelAndView modelAndView=new ModelAndView();

	modelAndView.setViewName("shipment");
	return modelAndView;
	}

@RequestMapping(value="/save", method=RequestMethod.POST)
public ModelAndView save(
		@RequestParam String shipmentNumber,
		@RequestParam String shipmentDiscription,
		@RequestParam String containerNumber,
		@RequestParam String poNumber,
		@RequestParam String deliveryNumber,
		@RequestParam String deliveryDate,
		@RequestParam String ndcNumber,
		@RequestParam String batchId,
		@RequestParam String serialNumberOfGoods,
		@RequestParam String device,
		@RequestParam String goodsType,
		@RequestParam String routeDetails
)    {
ModelAndView modelAndView=new ModelAndView();
Shipment s=new Shipment();
s.setShipmentNumber(shipmentNumber);
s.setContainerNumber(containerNumber);
s.setShipmentDiscription(shipmentDiscription);
s.setDeliveryDate(deliveryDate);
s.setDeliveryNumber(deliveryNumber);
s.setPoNumber(poNumber);
s.setNdcNumber(ndcNumber);
s.setSerialNumberOfGoods(serialNumberOfGoods);
s.setBatchId(batchId);
s.setDevice(device);
s.setGoodsType(goodsType);
s.setRouteDetails(routeDetails);
repository.save(s);
//template.send("myTopic", s);



modelAndView.addObject("shipmentNumber", s.getShipmentNumber());
modelAndView.addObject("containerNumber", s.getContainerNumber());
modelAndView.addObject("deliveryDate", s.getDeliveryDate());
modelAndView.addObject("shipmentDiscription", s.getShipmentDiscription());
modelAndView.addObject("routeDetails", s.getRouteDetails());
modelAndView.addObject("message", "your shipment has been added");
modelAndView.setViewName("added");
return modelAndView;
}
//@GetMapping("/kafka/messages")
//public List<String> getMessages() {
    //return myTopicConsumer.getMessages();
//}


}
