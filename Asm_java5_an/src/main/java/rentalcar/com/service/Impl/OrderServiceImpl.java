package rentalcar.com.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import rentalcar.com.dao.OrderDetailRepo;
import rentalcar.com.dao.OrderRepo;
import rentalcar.com.entity.Order;
import rentalcar.com.entity.OrderDetail;
import rentalcar.com.report.ReportCategory;
import rentalcar.com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired OrderRepo oRepo;
	@Autowired OrderDetailRepo odRepo;

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		oRepo.save(order);
		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
		};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		odRepo.saveAll(details);
		return order;
	}

	@Override
	public Order findById(Long id) {
		return oRepo.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		return oRepo.findByUsername(username);
	}

	@Override
	public List<Order> findOrderInMonth(Integer month){
		return oRepo.findOrderInMonth(month);
	}

	@Override
	public Integer countOrderInMonth(Integer month) {
		return oRepo.countOrderInMonth(month);
	}

	
}
