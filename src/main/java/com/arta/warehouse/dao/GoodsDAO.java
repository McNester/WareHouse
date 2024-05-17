package com.arta.warehouse.dao;

import com.arta.warehouse.model.Goods;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

/**
 * GoodsDAO
 */
public class GoodsDAO {
	public void saveGoods(Goods goods) {
		String sql = "INSERT INTO goods (name, quantity) VALUES (?, ?)";
		try (PreparedStatement stmt = DataBaseConnector.prepareStatement(sql)) {
			stmt.setString(1, goods.getName());
			stmt.setInt(2, goods.getQuantity());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Goods> getGoods() {
		List<Goods> goodsList = new ArrayList<>();
		String sql = "SELECT * FROM goods";
		try (ResultSet rs = DataBaseConnector.get(sql)) {
			while (rs != null && rs.next()) {
				Goods goods = new Goods();
				goods.setId(rs.getInt("id"));
				goods.setName(rs.getString("name"));
				goods.setQuantity(rs.getInt("quantity"));
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodsList;
	}
}
