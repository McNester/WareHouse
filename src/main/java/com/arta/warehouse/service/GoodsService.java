package com.arta.warehouse.service;

import java.util.List;

import com.arta.warehouse.dao.GoodsDAO;
import com.arta.warehouse.model.Goods;

/**
 * GoodsService
 */
public class GoodsService {
	private GoodsDAO goodsDAO = new GoodsDAO();

	public void saveGoods(Goods goods) {
		goodsDAO.saveGoods(goods);
	}

	public List<Goods> getGoods() {
		return goodsDAO.getGoods();
	}
}
