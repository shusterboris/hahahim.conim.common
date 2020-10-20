package hahahim.conim.common;

import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import entities.CatItem;
import services.MockService;

class MockDataTest {
	private MockService mService = new MockService();

	@Test
	void test() {
		List<String> items = mService.getRegionsString(null);
		assumeTrue("Список регионов не должен быть пустым", items.size() > 0);
		assumeTrue("Список регионов должен содержать Хайфа", items.contains("Хайфа"));
		List<String> settlments = mService.getSettlmentsStrings(items.get(0), "RU");
		assumeTrue("Список населенных пунктов не должен быть пустым", items.size() > 0);
		assumeTrue("Список населенных пунктов должен содержать Нешер", settlments.contains("Нешер"));
		// список регионов на английском
		List<CatItem> catItems = mService.getRegionsList("en");
		assumeTrue("Список регионов не должен быть пустым", catItems.size() > 0);
		CatItem catItem = mService.getCatByValue("Алкоголь", "RU");
		assumeNotNull("Не найден по значению элемент справочника", catItem);
		catItems = mService.getRootCatsByCategory("Goods.Category", "RU");
		int mainGoodsCatCount = catItems.size();
		catItems = mService.getCatsByCategory("Goods.Category", "RU");
		assumeTrue("Список категорий и подкатегорий не должен совпадать", catItems.size() > mainGoodsCatCount);
		catItems = mService.getChildCatsByCategory("Goods.Category", "Services", "EN");
		for (CatItem item : catItems) {
			System.out.println(item);
		}

	}

}
