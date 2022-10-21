package trinhtruong2k1.io.seller.Dao;

import java.util.List;

import trinhtruong2k1.io.seller.model.OrderItemModel;

public interface OrderItemDao {
	int countAll(String id);
	void insert (OrderItemModel orderItem);
	void edit (OrderItemModel orderItem);
	void delete (int id);
	List<OrderItemModel> findAll();
	List<OrderItemModel> findBySellerID(String id);
	OrderItemModel findByItemID(String id);
	int countTotalSale(String id);
	double countAvgSale(String id);
}
