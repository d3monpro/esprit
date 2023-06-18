
package esprit.serviceImpl;

import esprit.db.management.DataSource;
import esprit.model.Ingredient;
import esprit.service.IngredientService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class IngredientServiceImpl implements IngredientService{

    final DataSource dataSource= createConnection();

    @Override
    public void addIngredient(String name,String qte, String validity) {
       DataSource dataSource= createConnection();
       try {
                    String query="INSERT INTO ingredients(nameIngredients,qte,validity) VALUES(?,?,?,?);";
                    PreparedStatement stmt=dataSource.getConnection().prepareStatement(query);    
                    stmt.setString(1,name);
                    stmt.setString(2,qte);
                    stmt.setString(3,validity);
 
                    
                    stmt.executeUpdate();
                    stmt.close();
                    
                } catch (SQLException ex) {
                    System.err.println("error");
                }
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        try {
            String query = "UPDATE ingredients SET qte= ? WHERE idI= ?" ;
            PreparedStatement stmt= dataSource.getConnection().prepareStatement(query);
            stmt.setString(1,String.valueOf(ingredient.getQte()) );
            stmt.setString(2,String.valueOf(ingredient.getId()));
            stmt.executeUpdate();
        }catch (SQLException ex) {
                    System.err.println("error");
        }
        return ingredient;
    }

    @Override
    public void deleteIngredient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ingredient> displayIngredients() {
        List<Ingredient> listIngredient= new ArrayList<>();
        try {
            String query="Select * from ingredients;";
            PreparedStatement stmt=dataSource.getConnection().prepareStatement(query);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
                listIngredient.add(new Ingredient(rs.getInt("idI"),rs.getString("nameIngredient"), rs.getInt("qte")));
            }
        } catch (SQLException ex) {
                    System.err.println("error");
            }
        return listIngredient;
    }
    
    private DataSource createConnection(){
        return DataSource.getInstance();
    }
    
}
