package uhp.digital.recipes.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MyResponse {
    private int count;
    @SerializedName("recipes")
    private List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        return recipes;
    }
}

