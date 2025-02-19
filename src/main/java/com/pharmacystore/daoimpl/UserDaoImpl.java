package com.pharmacystore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pharmacystore.connection.DbConnection;
import com.pharmacystore.dao.UserDao;
import com.pharmacystore.pojo.Order;
import com.pharmacystore.pojo.Product;
import com.pharmacystore.pojo.User;

public class UserDaoImpl implements UserDao {
	@Override
	public boolean register(User user) {
		try (Connection con = 
				DbConnection.getDatabaseConnection())
		{
			PreparedStatement pst = 
		con.prepareStatement("INSERT INTO user"
				+ " VALUES(?,?,?,?,?,?,?,?)");
			
			pst.setString(1,user.getUserid());
			pst.setString(2,user.getPassword());
			pst.setString(3,user.getEmailid());
			pst.setInt(4,user.getAge());
			pst.setString(5,user.getContact());
			pst.setString(6,user.getCity());
			pst.setString(7,user.getState());
			pst.setString(8,user.getPincode());
			
			int count = pst.executeUpdate();
			
			if(count > 0)
				return true;
			else
				return false;
		}
		catch(SQLException | NullPointerException exc) {
			exc.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkUser(User user) {
		try (Connection con = 
				DbConnection.getDatabaseConnection())
		{
			PreparedStatement pst = 
		con.prepareStatement("SELECT * FROM user"
				+ " WHERE userid = ? AND"
				+ " password = ?");
			
			pst.setString(1,user.getUserid());
			pst.setString(2,user.getPassword());
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.isBeforeFirst())
				return true;
			else
				return false;
		}
		catch(SQLException | NullPointerException exc) {
			exc.printStackTrace();
			return false;
		}
	}
	public boolean cancelOrder(Order order)
	   {
		   try (Connection con = 
					DbConnection.getDatabaseConnection())
			{
				PreparedStatement pst = 
			con.prepareStatement("SELECT cancelled FROM productorder"
					+ " WHERE orderid = ?  " );
				
				pst.setInt(1,order.getOrderid());
				 
			
				ResultSet rs = pst.executeQuery();
				
				if(rs.isBeforeFirst())
					return true;
				else
					return false;
			}
			catch(SQLException | NullPointerException exc) {
				exc.printStackTrace();
				return false;
			}
			 
		}
 @Override
public List<Order> displaymycancelledorder(User u){
	 List<Order> orderList = new ArrayList<>();
	 String uid = u.getUserid();
	 try (Connection con = 
				DbConnection.getDatabaseConnection())
		{
			
			PreparedStatement pst = 
					con.prepareStatement("Select cancelled from productorder where orderid =? ");
			pst.setString(1,uid);
			ResultSet rs = pst.executeQuery();
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					Order order = new Order();
					order.setOrderid(rs.getInt("orderid"));
					order.setOrderedunits(rs.getInt("orderdunits"));
					order.setAddress(rs.getString("address"));
					order.setOrdereddate(rs.getDate("ordereddate"));
					order.setRequesteddate(
							rs.getDate("requesteddate"));
					order.setAccepted(rs.getBoolean("accepted"));
					order.setCancelled(rs.getBoolean("cancelled"));
					order.setConfirmed(rs.getBoolean("confirmed"));
					order.setBillamount(rs.getInt("billamount"));
					order.setCustomerid(rs.getString("customerid"));
					order.setProductid(rs.getInt("productid"));
					
					orderList.add(order);
				}
			}
			
			return orderList;
		}
		catch(NullPointerException | SQLException
				 exc) {
			exc.printStackTrace();
			 orderList.clear();
			return  orderList;
		}
	}

	}