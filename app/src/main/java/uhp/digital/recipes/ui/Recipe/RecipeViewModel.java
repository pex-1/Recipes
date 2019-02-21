package uhp.digital.recipes.ui.Recipe;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import uhp.digital.recipes.data.Recipe;
import uhp.digital.recipes.data.RecipeRepository;

public class RecipeViewModel extends AndroidViewModel {
    private RecipeRepository recipeRepository;
    private LiveData<List<Recipe>> recipes;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
        recipeRepository = new RecipeRepository(application);
        recipes = recipeRepository.getRecipes();
        Log.e("note view model", "setup");
    }

    public LiveData<List<Recipe>> getRecipes(){
        return recipes;
    }
}
