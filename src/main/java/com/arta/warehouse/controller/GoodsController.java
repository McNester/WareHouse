package com.arta.warehouse.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import com.arta.warehouse.service.GoodsService;
import com.arta.warehouse.model.Goods;

/**
 * GoodsController
 */
public class GoodsController {
	private GoodsService goodsService = new GoodsService();

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveGoods(Goods goods) {
		goodsService.saveGoods(goods);
		return Response.ok().build();
	}

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Goods> getGoods() {
		return goodsService.getGoods();
	}

}
