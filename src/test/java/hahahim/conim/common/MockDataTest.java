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
		assumeTrue("������ �������� �� ������ ���� ������", items.size() > 0);
		assumeTrue("������ �������� ������ ��������� �����", items.contains("�����"));
		List<String> settlments = mService.getSettlmentsStrings(items.get(0), "RU");
		assumeTrue("������ ���������� ������� �� ������ ���� ������", items.size() > 0);
		assumeTrue("������ ���������� ������� ������ ��������� �����", settlments.contains("�����"));
		// ������ �������� �� ����������
		List<CatItem> catItems = mService.getRegionsList("en");
		assumeTrue("������ �������� �� ������ ���� ������", catItems.size() > 0);
		CatItem catItem = mService.getCatByValue("��������", "RU");
		assumeNotNull("�� ������ �� �������� ������� �����������", catItem);
		catItems = mService.getRootCatsByCategory("Goods.Category", "RU");
		int mainGoodsCatCount = catItems.size();
		catItems = mService.getCatsByCategory("Goods.Category", "RU");
		assumeTrue("������ ��������� � ������������ �� ������ ���������", catItems.size() > mainGoodsCatCount);
		catItems = mService.getChildCatsByCategory("Goods.Category", "Services", "EN");
		for (CatItem item : catItems) {
			System.out.println(item);
		}

	}

}
