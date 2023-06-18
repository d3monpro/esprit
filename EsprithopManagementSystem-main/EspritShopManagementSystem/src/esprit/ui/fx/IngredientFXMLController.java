
package esprit.ui.fx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import esprit.model.Ingredient;
import esprit.service.IngredientService;
import esprit.serviceImpl.IngredientServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class IngredientFXMLController implements Initializable {

    @FXML
    private TableColumn<Ingredient, String> action;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> quantity;

    @FXML
    private TableView<Ingredient> tableView;
    
    
    private IngredientService ingredientService=new IngredientServiceImpl();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        final List<Ingredient> listOfIngredients= ingredientService.displayIngredients();
        final ObservableList<Ingredient> ingredients= FXCollections.observableArrayList(listOfIngredients);
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("nameingredient"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("qte"));
        Callback<TableColumn<Ingredient,String>,TableCell<Ingredient,String>> cellFactory=(param)->{
        
            final TableCell<Ingredient,String> actionCell=new TableCell<Ingredient,String>(){
            @Override
            public void updateItem(String item,boolean empty){
                super.updateItem(item, empty);

                if(empty){
                    setGraphic(null);
                    setText(null);
                }else{
                    final Button actionButton= new Button("Add");
                    actionButton.setOnAction(event->{
                        Ingredient ingredient= getTableView().getItems().get(getIndex());
                        int qte=ingredient.getQte();
                        if(qte==0){
                            setDisabled(true);
                        }else{
                            ingredient.setQte(qte - 1);
                            Ingredient updatedIngredient=ingredientService.updateIngredient(ingredient);
                            getTableView().refresh();
                        }
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("You have added : \n "+ingredient.getNameingredient());
                        alert.show();
                    });
                    setGraphic(actionButton);
                    setText(null);
                }
            }
          };
            return actionCell;
        };
        
        action.setCellFactory(cellFactory);
        

        tableView.setItems(ingredients);
        
    }    
    
}
