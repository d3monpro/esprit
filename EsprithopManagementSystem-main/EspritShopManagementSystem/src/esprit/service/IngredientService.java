
package esprit.service;
import esprit.model.Ingredient;

import java.util.List;
public interface IngredientService {
    
    void addIngredient();
    Ingredient updateIngredient(Ingredient ingredient);
    void deleteIngredient();
    List<Ingredient> displayIngredients();

}
