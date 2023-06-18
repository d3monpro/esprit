
package esprit.service;
import esprit.model.Ingredient;

import java.util.List;

public interface IngredientService {
    
    void addIngredient(String name,String qte, String validity);
    Ingredient updateIngredient(Ingredient ingredient);
    void deleteIngredient();
    List<Ingredient> displayIngredients();

}
