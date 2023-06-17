
package esprit.ui.fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import esprit.model.Ingredient;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class IngredientFXMLController implements Initializable {

    @FXML
    private TableColumn<?, ?> action;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> quantity;

    @FXML
    private TableColumn<?, ?> validity;

    @FXML
    private TableView<Ingredient> tableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn idColumn= new TableColumn("id");
        TableColumn nameColumn= new TableColumn("name");
        TableColumn quantityColumn= new TableColumn("quantity");
        TableColumn validityColumn= new TableColumn("validity");
        TableColumn actionColumn= new TableColumn("action");
        
        tableView.getColumns().addAll(idColumn,nameColumn,quantityColumn,validityColumn,actionColumn);
        
        final ObservableList<Ingredient> ingredients= FXCollections.observableArrayList(
        new Ingredient(1,"Fromage Rappé",20,true),
        new Ingredient(2,"Ketchup",3,true),
        new Ingredient(3,"Harissa",15,true),
        new Ingredient(4,"Salade Verte",100,true),
        new Ingredient(5,"Mayonnaise",0,false)
        );
        
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nameingredient"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("qte"));
        validityColumn.setCellValueFactory(new PropertyValueFactory<>("validity"));
        
        tableView.setItems(ingredients);
        
    }    
    
}
