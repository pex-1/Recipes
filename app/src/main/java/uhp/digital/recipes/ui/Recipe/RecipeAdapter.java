package uhp.digital.recipes.ui.Recipe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import uhp.digital.recipes.R;
import uhp.digital.recipes.data.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private Context context;
    private List<Recipe> recipes;

    public RecipeAdapter(Context context, List<Recipe> reipes) {
        this.context = context;
        this.recipes = reipes;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recipe_item, viewGroup, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int position) {
        //picasso and glide won't load images from http url
        String link = recipes.get(position).getImageUrl().replace("http", "https");

        Picasso.get()
                .load(link)
                .placeholder(R.drawable.placeholder)
                .resize(100, 100)
                .centerCrop()
                .into(recipeViewHolder.recipeImage);
        recipeViewHolder.recipeTitle.setText(recipes.get(position).getTitle());
        recipeViewHolder.socialRank.setText(String.valueOf(recipes.get(position).getSocialRank()));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder{
        ImageView recipeImage;
        TextView recipeTitle;
        TextView socialRank;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.image_view_recipe);
            recipeTitle = itemView.findViewById(R.id.text_view_title);
            socialRank = itemView.findViewById(R.id.text_view_social_rank);
        }
    }
}
