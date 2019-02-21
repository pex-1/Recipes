package uhp.digital.recipes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import uhp.digital.recipes.data.MyResponse;

public interface RecipesApi {
    String BASE_URL = "https://www.food2fork.com/";

    @GET("api/search/count")
    Call<MyResponse> getRecipes(@Query("key") String apiKey);
}
