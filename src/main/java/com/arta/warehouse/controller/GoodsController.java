package com.arta.warehouse.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

import com.arta.warehouse.service.GoodsService;
import com.arta.warehouse.model.Goods;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 * GoodsController
 */
@Path("/goods")
public class GoodsController {
	private GoodsService goodsService = new GoodsService();
	private ObjectMapper mapper = new ObjectMapper();

	@POST
	@Path("/save")
	@Consumes("application/json")
	@Produces("application/json")
	public Response saveGoods(String json) {
		try {
			System.out.println("Received JSON: " + json + " the end");
			Goods goods = mapper.readValue(json, Goods.class);
			goodsService.saveGoods(goods);
			return Response.ok().build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity("Invalid JSON").build();
		}
	}
	//
	// @GET
	// @Path("/getAll")
	// @Produces("application/json")
	// public List<Goods> getGoods() {
	// return goodsService.getGoods();
	// }

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public Response getGoods() {
		List<Goods> goodsList = goodsService.getGoods();
		try {
			String json = mapper.writeValueAsString(goodsList);
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Error converting list to JSON").build();
		}
	}

}
