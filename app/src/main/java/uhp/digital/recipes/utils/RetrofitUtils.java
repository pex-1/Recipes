package uhp.digital.recipes.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uhp.digital.recipes.RecipesApi;

public class RetrofitUtils {

    public static Retrofit getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RecipesApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
