package com.unit.cafe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CafeTest {

	private static final CoffeeType[] typesOfCoffee = { CoffeeType.Espresso,
			CoffeeType.Latte, CoffeeType.FilterCoffee };

	private Cafe cafe;

	@Before
	public void before() {
		cafe = new Cafe();
	}

	@Test
	public void canBrewCoffee() {

		for (CoffeeType coffeeType : typesOfCoffee) {
			// Given
			prepareCafe(coffeeType);

			// When
			Coffee coffee = cafe.brew(coffeeType);

			// Then
			Assert.assertEquals(coffeeType, coffee.getType());
			Assert.assertEquals(coffeeType.getRequiredMilk(), coffee.getMilk());
			Assert.assertEquals(coffeeType.getRequiredBeans(),
					coffee.getBeans());
		}

	}

	private void prepareCafe(CoffeeType coffeeType) {
		cafe.restockBeans(coffeeType.getRequiredBeans());
		cafe.restockMilk(coffeeType.getRequiredMilk());
	}
}
