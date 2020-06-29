package com.productdetailsservice.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.meru.productdetails.ProductDetailsServiceApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProductDetailsServiceApplication.class)
@SpringBootTest
public class ProductDetailsServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
