package uhp.digital.recipes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import uhp.digital.recipes.R;
import uhp.digital.recipes.data.Recipe;
import uhp.digital.recipes.ui.Recipe.RecipeAdapter;
import uhp.digital.recipes.ui.Recipe.RecipeViewModel;
import uhp.digital.recipes.utils.NetworkUtils;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecipeAdapter recipeAdapter;
    private ProgressBar progressBar;

    private RecipeViewModel recipeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!NetworkUtils.isNetworkConnected(this)){
            Toast.makeText(this, "No network connection!", Toast.LENGTH_SHORT).show();
            return;
        }
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        recipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel.class);

        recipeViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                setUI(recipes);
                progressBar.setVisibility(View.GONE);
            }
        });

    }

    void setUI(List<Recipe> recipes){
        if(recipes == null){
            Toast.makeText(this, "Limit exceeded!", Toast.LENGTH_SHORT).show();
            return;
        }
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        recipeAdapter = new RecipeAdapter(getApplicationContext(), recipes);
        recyclerView.setAdapter(recipeAdapter);
    }
}
