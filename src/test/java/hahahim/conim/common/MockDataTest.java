package hahahim.conim.common;

import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import services.MockService;

class MockDataTest {
	private MockService mService = new MockService();

	@Test
	void test() {
		List<String> items = mService.getRegionsString(null);
		assumeTrue("Список регионов не должен быть пустым", items.size() > 0);
		assumeTrue("Список регионов должен содержать Хайфа", items.contains("Хайфа"));
		List<String> settlments = mService.getSettlmentsStrings(items.get(0), "EN");
		System.out.println(settlments.toString());
		assumeTrue("Список населенных пунктов не должен быть пустым", items.size() > 0);
	}

}
