
package esprit.model;

public class Ingredient {
    private int id;
    private String nameingredient;
    private int qte;
    private boolean validity;

    
    public Ingredient(){
        
    }

    public Ingredient(String nameingredient, int qte, boolean validity) {
        this.nameingredient = nameingredient;
        this.qte = qte;
        this.validity = validity;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameingredient() {
        return nameingredient;
    }

    public void setNameingredient(String nameingredient) {
        this.nameingredient = nameingredient;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }
    
    
    
}
