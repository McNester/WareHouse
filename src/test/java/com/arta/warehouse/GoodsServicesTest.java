package com.arta.warehouse;

import org.junit.*;
import org.mockito.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.arta.warehouse.dao.GoodsDAO;
import com.arta.warehouse.model.Goods;
import com.arta.warehouse.service.GoodsService;

/**
 * GoodsServicesTest
 */
public class GoodsServicesTest {

	@Mock
	private GoodsDAO goodsDAO;

	@InjectMocks
	private GoodsService goodsService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSave() {
		Goods goods = new Goods();
		goods.setName("Test");
		goods.setQuantity(1000);
		goodsService.saveGoods(goods);
		verify(goodsDAO, times(1)).saveGoods(goods);
	}

	@Test
	public void testGetGoods() {
		Goods goods1 = new Goods();
		goods1.setName("First good");
		goods1.setQuantity(9);

		Goods goods2 = new Goods();
		goods2.setName("Second good");
		goods2.setQuantity(2);

		when(goodsDAO.getGoods()).thenReturn(Arrays.asList(goods1, goods2));

		List<Goods> goodsList = goodsService.getGoods();
		assertEquals(2, goodsList.size());

		verify(goodsDAO, times(1)).getGoods();
	}
}
