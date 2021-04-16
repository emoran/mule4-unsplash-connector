package org.mule.extension.unsplash.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Text;
import org.mule.runtime.extension.api.annotation.values.OfValues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.emoran.ColorValueProvider;
import com.emoran.OrientationValueProvider;
import com.emoran.RandonPhotoPOJO;
import com.emoran.searchPOJO;
import com.google.gson.Gson;

public class UnsplashOperations {

  /**
   * Operation that allows to get a Random photo from Unsplash.
   * @param configuration
   * @param count
   * @param keyword
   * @param orientation
   * @return
   * @throws Exception
   */
  @MediaType(value = ANY, strict = false)
  public List<RandonPhotoPOJO> getRandomPhoto(  @Config UnsplashConfiguration configuration, @Optional(defaultValue = "10") Integer count,
                                                @Optional String keyword, @Optional(defaultValue = "portrait")
                                                @OfValues(OrientationValueProvider.class) String orientation) throws Exception {
    StringBuilder result = new StringBuilder();
    URL url = new URL("https://api.unsplash.com/photos/random?client_id="+configuration.getUnsplashAccessToken()+"&count="+ count + "&query="+keyword + "&orientation="+ orientation);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestProperty ("Accept-Version", "v1");
    conn.setRequestMethod("GET");
    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line;
    while ((line = rd.readLine()) != null) {
      result.append(line);
    }
    rd.close();
    Gson gson = new Gson();
    return gson.fromJson(result.toString(),(Type) java.util.Collection.class);
  }

  /**
   * Operation that allows to Search photos from the Unsplash API
   * @param configuration
   * @param searchTerm
   * @param page
   * @param perPage
   * @return
   * @throws Exception
   */
  @MediaType(value = ANY, strict = false)
  public searchPOJO searchPhoto(@Config UnsplashConfiguration configuration,
                                @Optional(defaultValue = "") String searchTerm,
                                @Optional(defaultValue = "") Integer page,
                                @Optional(defaultValue = "10") Integer perPage,
                                @Optional @OfValues(ColorValueProvider.class) String color)  throws Exception {
    StringBuilder result = new StringBuilder();
    URL url = new URL("https://api.unsplash.com/search/photos?client_id="+configuration.getUnsplashAccessToken()+"&query="+searchTerm+"&page="+page+"&per_page="+perPage+"&color="+color);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestProperty ("Accept-Version", "v1");
    conn.setRequestMethod("GET");
    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String line;
    while ((line = rd.readLine()) != null) {
      result.append(line);
    }
    rd.close();
    Gson gson = new Gson();
    return gson.fromJson(result.toString(), (Type) searchPOJO.class);
  }
}
