package com.emoran;

import java.util.Date;
import java.util.List;

public class searchPOJO {
  // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
  public class Urls{
    public String raw;
    public String full;
    public String regular;
    public String small;
    public String thumb;
  }

  public class Links{
    public String self;
    public String html;
    public String download;
    public String download_location;
    public String photos;
    public String likes;
    public String portfolio;
    public String following;
    public String followers;
  }

  public class ProfileImage{
    public String small;
    public String medium;
    public String large;
  }

  public class User{
    public String id;
    public Date updated_at;
    public String username;
    public String name;
    public String first_name;
    public String last_name;
    public String twitter_username;
    public String portfolio_url;
    public String bio;
    public String location;
    public Links links;
    public ProfileImage profile_image;
    public String instagram_username;
    public int total_collections;
    public int total_likes;
    public int total_photos;
    public boolean accepted_tos;
    public boolean for_hire;
  }

  public class Type{
    public String slug;
    public String pretty_slug;
  }

  public class Category{
    public String slug;
    public String pretty_slug;
  }

  public class Subcategory{
    public String slug;
    public String pretty_slug;
  }

  public class Ancestry{
    public Type type;
    public Category category;
    public Subcategory subcategory;
  }

  public class CoverPhoto{
    public String id;
    public Date created_at;
    public Date updated_at;
    public Date promoted_at;
    public int width;
    public int height;
    public String color;
    public String blur_hash;
    public String description;
    public String alt_description;
    public Urls urls;
    public Links links;
    public List<Object> categories;
    public int likes;
    public boolean liked_by_user;
    public List<Object> current_user_collections;
    public Object sponsorship;
    public User user;
  }

  public class Source{
    public Ancestry ancestry;
    public String title;
    public String subtitle;
    public String description;
    public String meta_title;
    public String meta_description;
    public CoverPhoto cover_photo;
  }

  public class Tag{
    public String type;
    public String title;
    public Source source;
  }

  public class Result{
    public String id;
    public Date created_at;
    public Date updated_at;
    public Date promoted_at;
    public int width;
    public int height;
    public String color;
    public String blur_hash;
    public String description;
    public String alt_description;
    public Urls urls;
    public Links links;
    public List<Object> categories;
    public int likes;
    public boolean liked_by_user;
    public List<Object> current_user_collections;
    public Object sponsorship;
    public User user;
    public List<Tag> tags;
  }

  public int total;
  public int total_pages;
  public List<Result> results;



}
