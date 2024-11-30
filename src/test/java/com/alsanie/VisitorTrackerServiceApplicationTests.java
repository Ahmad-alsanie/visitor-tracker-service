package com.alsanie;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
@SpringBootTest
class VisitorTrackerServiceApplicationTests {

	@Test
	void contextLoads() {
		DynamoDB dynamoDB = Mockito.mock(DynamoDB.class);
	}

}
