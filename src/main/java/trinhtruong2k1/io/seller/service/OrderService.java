package trinhtruong2k1.io.seller.service;

import java.util.List;

import trinhtruong2k1.io.seller.model.OrderModel;

public interface OrderService {
	int countAll();
	void insert (OrderModel order);
	void edit (OrderModel order);
	void delete (int id);
	List<OrderModel> findAll();
	OrderModel findByID(String id);

}
