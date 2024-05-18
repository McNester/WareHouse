package com.arta.warehouse.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

import com.arta.warehouse.service.GoodsService;
import com.arta.warehouse.model.Goods;

/**
 * GoodsController
 */
@Path("/goods")
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
