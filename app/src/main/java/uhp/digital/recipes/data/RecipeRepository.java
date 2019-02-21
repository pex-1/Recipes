package uhp.digital.recipes.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uhp.digital.recipes.BuildConfig;
import uhp.digital.recipes.RecipesApi;
import uhp.digital.recipes.utils.RetrofitUtils;

public class RecipeRepository {
    private final MutableLiveData<List<Recipe>> recipes = new MutableLiveData<>();

    public RecipeRepository(final Application application){
        RecipesApi recipesApi = RetrofitUtils.getClient().create(RecipesApi.class);
        Call<MyResponse> call = recipesApi.getRecipes(BuildConfig.ApiKey);

        //run in background
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(application.getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Recipe> result = response.body().getRecipes();
                recipes.setValue(result);
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public LiveData<List<Recipe>> getRecipes() {
        return recipes;
    }
}
