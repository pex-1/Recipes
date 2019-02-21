package uhp.digital.recipes.data;

import com.google.gson.annotations.SerializedName;

public class Recipe {
    private String title;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("social_rank")
    private int socialRank;

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
