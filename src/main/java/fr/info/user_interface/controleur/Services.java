package fr.info.user_interface.controleur;

import fr.info.user_interface.modele.Catalogue;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
@ComponentScan("fr.info")
public class Services {
  private ArrayList<Catalogue> listecatalogue;

  public Services() {
    listecatalogue = new ArrayList<>();
    init();
  }

  public void init() {
    String [] titre =  { "Asterix gladiateur",
            "Lucky Luke, Sur la piste des Dalton",
            "Garfield prend du poids",
            "L'Anniversaire d'Astérix et Obélix "};

    String[] auteur = {
            "R. Goscinny, A. Uderzo",
            "Morris,  R. Goscinny",
            "J. Davis",
            "R. Goscinny, A. Uderzo"};
    String categorie = "bande dessinee";

    int i =0;
    for(i=0; i<titre.length; i++){
      Catalogue c = new Catalogue();
      c.init(titre[i], auteur[i], categorie);
      listecatalogue.add(c);
    }
  }

  public Catalogue selection() {
    Catalogue catalogue = new Catalogue();
    catalogue.init("Asterix, Le Bouclier Arverne","R. Goscinny, A. Uderzo", "bande dessinee");
    return catalogue;
  }

  public ArrayList <Catalogue> liste() {
    return listecatalogue;
  }

  public Catalogue ajouterCatalogue(Catalogue catalogue) {
    listecatalogue.add(catalogue);
    return  catalogue;
  }
  /*
   * OSM
   */
  private static final OkHttpClient httpClient = new OkHttpClient();
  public JSONObject search(String query) throws IOException {
    Request request = new Request.Builder()
            .url("https://nominatim.openstreetmap.org/search?format=json&q=" + query)
            .build();

    try (Response response = httpClient.newCall(request).execute()) {
      if (!response.isSuccessful())
        System.out.println("\n\tUnexpected code " + response);

      JSONArray jsonArray = new JSONArray(response.body().string());

      if(jsonArray.length() > 0) {
        return jsonArray.getJSONObject(0);
      }

      return null;
    }
  }
}
