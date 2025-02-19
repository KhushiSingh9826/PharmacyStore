package com.pharmacystore.dao;

import java.util.List;

import com.pharmacystore.pojo.Order;
import com.pharmacystore.pojo.User;

public interface UserDao {
	boolean register(User user);
	boolean checkUser(User user);
	boolean cancelOrder(Order o);
	List<Order> displaymycancelledorder(User u);
	
}
