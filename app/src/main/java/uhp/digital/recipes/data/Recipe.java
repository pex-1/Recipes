package uhp.digital.recipes.data;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    private String publisher;
    @SerializedName("f2f_url")
    private String fullArticle;
    private String title;
    @SerializedName("source_url")
    private String sourceURL;
    private String recipeId;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("social_rank")
    private int socialRank;
    private String publisherUrl;

    public String getTitle() {
        return title;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public int getSocialRank() {
        return socialRank;
    }
}
