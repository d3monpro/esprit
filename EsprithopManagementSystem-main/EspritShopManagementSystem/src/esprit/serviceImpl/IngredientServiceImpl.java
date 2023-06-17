
package esprit.serviceImpl;

import esprit.db.management.DataSource;
import esprit.model.Ingredient;
import esprit.service.IngredientService;
import java.util.List;


public class IngredientServiceImpl implements IngredientService{

    @Override
    public void addIngredient() {
       DataSource dataSource= createConnection();
       
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteIngredient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ingredient> displayIngredients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private DataSource createConnection(){
        return DataSource.getInstance();
    }
    
}
