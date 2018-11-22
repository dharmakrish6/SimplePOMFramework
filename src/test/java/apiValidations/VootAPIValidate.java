package apiValidations;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VootAPIValidate {
	public String checkRecommendationShows() {

		RestAssured.baseURI = "https://rec.voot.com/v2";

		Response response = RestAssured.given().contentType(ContentType.JSON).body(

				"{\"requestParameters\":{\"filterViacomExcludeContent\":[\"602865\",\"606420\",\"619837\",\"639913\",\"640134\",\"639077\",\"572880\",\"606786\",\"642213\",\"643908\"]}}")

				.when()

				.post("/recommendation.json?method=showsForYou&useCaseId=UC_ANDROID_5&userId=d4570746a3944b4cb56d4973879de23e")

				.then().assertThat().statusCode(200).log().body().extract().response();
		// Change item index
		String showName = response.path("assets[0].items[0].mediaMainTitle");

		// System.out.println("Show name from the API is :"+showName);

		return showName;

	}
	public String checkCarouselDataAPI() {

		RestAssured.baseURI = "https://apiv2.voot.com/wsv_2_4";

		Response response = RestAssured.given().contentType(ContentType.JSON)

				.when()

				.get("/media/assetDetails.json?tabId=shows&subTabId=allShows&rowId=734&language=English%2CHindi&sortId=mostPopular&type=more&limit=8&offSet=0")

				.then().assertThat().statusCode(200).log().body().extract().response();
		// Change item index
		String showName = response.path("assets[0].items[0].mediaMainTitle");

		// System.out.println("Show name from the API is :"+showName);

		return showName;

	}
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
        
		RestAssured.given().contentType(ContentType.JSON).
	    when().
	        get("https://apiv2.voot.com/wsv_2_4/media/assetDetails.json?tabId=shows&subTabId=allShows&rowId=734&language=English%2CHindi&sortId=mostPopular&type=more").
	    then().
	        assertThat().
	        log().all();
	}
	
	public static void main(String[] args) {
		VootAPIValidate api=new VootAPIValidate();
		api.test_NumberOfCircuitsFor2017Season_ShouldBe20();
//		System.out.println(api.test_NumberOfCircuitsFor2017Season_ShouldBe20());
	}

}