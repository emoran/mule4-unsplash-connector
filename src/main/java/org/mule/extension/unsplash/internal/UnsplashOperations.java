package org.mule.extension.unsplash.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.emoran.RandonPhotoPOJO;
import com.emoran.searchPOJO;
import com.google.gson.Gson;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class UnsplashOperations {


  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public String superPhoto(Integer maxPhotos) {
    return "done";
  }


  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public List<RandonPhotoPOJO> getRandomPhoto(@Config UnsplashConfiguration configuration,@Optional(defaultValue = "10") Integer maxPhotos) throws Exception {
    StringBuilder result = new StringBuilder();
    URL url = new URL("https://api.unsplash.com/photos/random?client_id="+configuration.getUnsplashAccessToken()+"&count="+maxPhotos);
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

    return gson.fromJson(result.toString(), (Type) java.util.Collection.class);

  }

  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public searchPOJO searchPhoto(@Config UnsplashConfiguration configuration, @Optional(defaultValue = "") String searchTerm, @Optional(defaultValue = "") Integer page, Integer perPage )  throws Exception {
    StringBuilder result = new StringBuilder();
    URL url = new URL("https://api.unsplash.com/search/photos?client_id="+configuration.getUnsplashAccessToken()+"&query="+searchTerm+"&page="+page+"&per_page="+perPage);
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
    //return result.toString();
  }
}
