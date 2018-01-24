/**
 * @author diego
 *
 */
package de.com.element.insurance.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.http.ContentType;


import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;

import de.com.element.insurance.InsuranceApiApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = InsuranceApiApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class InsuranceIntegrationTest {
	
	
	@LocalServerPort
    private int port;
	
	@Test
	public void getInsurance() {
		
		given()
			.when()
			.get("http://127.0.0.1:" + port + "/api/v1/insurance")
			.then()
			.assertThat()
			.body("totalPages", not(0))
			.body("content",notNullValue())
			.statusCode(200);
		
	}
	
	@Test
	public void getInsuranceById() {
		
		given()
			.when()
			.get("http://127.0.0.1:" + port + "/api/v1/insurance/ff8081816125ed45016125ef308d0004")
			.then()
			.assertThat()
			.body("id",notNullValue())
			.body("username",notNullValue())
			.body("username",notNullValue())
			.body("productValue",notNullValue())
			.body("tariff",notNullValue())
			.body("insurance",notNullValue())
			.body("created",notNullValue())
			.body("simulation",notNullValue())
			.statusCode(200);
		
	}
	
	@Test
	public void createInsurance() {
		
		given()
			.contentType(ContentType.JSON)
			.body("{ \"username\": \"Nathalie\", \"productValue\": 4140, \"insurance\": \"SPORT_EQUIPMENT\" }")
			.when()
			.post("http://127.0.0.1:" + port + "/api/v1/insurance")
			.then()
			.assertThat()
			.statusCode(201);
		
	}
	
	@Test
	public void updateInsurance() {
		
		given()
			.contentType(ContentType.JSON)
			.body("{ \"username\": \"Diego\", \"productValue\": 410, \"insurance\": \"BIKE\" }")
			.when()
			.put("http://127.0.0.1:" + port + "/api/v1/insurance/ff8081816125ed45016125ef704a0005")
			.then()
			.assertThat()
			.statusCode(204);
		
	}
	
	@Test
	public void updateInsuranceStatus() {
		
		given()
			.contentType(ContentType.JSON)
			.body("")
			.when()
			.put("http://127.0.0.1:" + port + "/api/v1/insurance/ff8081816125ed45016125eeac670002/status")
			.then()
			.assertThat()
			.statusCode(204);
		
	}
	
	@Test
	public void deleteProduct() {
		
		given()			
			.contentType(ContentType.JSON)
			.when()
			.delete("http://127.0.0.1:" + port + "/api/v1/insurance/ff8081816125ed45016125ee38920001")
			.then()
			.assertThat()
			.statusCode(204);
		
	}
}