package uhp.digital.recipes.ui.Recipe;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import uhp.digital.recipes.data.Recipe;
import uhp.digital.recipes.data.RecipeRepository;

public class RecipeViewModel extends AndroidViewModel {
    private LiveData<List<Recipe>> recipes;

    public RecipeViewModel(@NonNull Application application) {
        super(application);
        RecipeRepository recipeRepository = new RecipeRepository(application);
        recipes = recipeRepository.getRecipes();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return recipes;
    }
}
