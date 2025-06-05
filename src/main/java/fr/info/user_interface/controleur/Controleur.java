package fr.info.user_interface.controleur;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_0.JavaDoubleParser;
import fr.info.user_interface.modele.Catalogue;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
/*
 * OSM
 */
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

import  fr.info.user_interface.controleur.Services;

import java.util.List;

import static java.lang.Double.parseDouble;

@Controller
@ComponentScan("fr.info")
public class Controleur {
  private final Services services;

  @Autowired
  public Controleur(Services services) {

    this.services = services;
  }
 
  @GetMapping("/selection") // => localhost:8090/selection
    public String selection(Model model) {
      // model-attribute :
      // - associe la requete localhost:8090/selection avec l'objet catalogue
      model.addAttribute("menu", "selection");
      model.addAttribute("catalogue", services.selection());
      return "catalogue"; // charge le fichier "catalogue.html"
    }

  @GetMapping("/catalogue")
  public String   liste(Model model) {
    model.addAttribute("liste", services.liste());
    return "catalogue";
  }

  @GetMapping("/ajouter")
  public String ajouter(@ModelAttribute("catalogue") Catalogue catalogue, Model model) {

    model.addAttribute("catalogue", services.ajouterCatalogue(catalogue));
    return "redirect:/catalogue";
  }

  @GetMapping("/index")
  public String   index() {
    return "index";
  }

  @GetMapping("/accueil")
  public String   accueil() {
    return "accueil";
  }

  @ModelAttribute
  public void addAttributes(Model model){
    model.addAttribute("menu", "catalogue");

  }
  @PostMapping("/search")
  public String search(@RequestParam("query") String query, Model model) {
    JSONObject location;
    try {
      location = services.search(query);
      System.out.println("\n\tlocation : "+location);
      String lat = location.getString("lat");
      String lon = location.getString("lon");
      double dlat = parseDouble(lat);
      double dlon = parseDouble(lon);
      model.addAttribute("latitude", dlat);
      model.addAttribute("longitude", dlon);

      System.out.println("\n\tlocation : "+dlat);
      System.out.println("\n\tlocation : "+dlon);

    } catch (IOException e) {
      e.printStackTrace();
    }
    return "accueil";
  }

}

