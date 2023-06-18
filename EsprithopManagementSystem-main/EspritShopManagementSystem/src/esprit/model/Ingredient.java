
package esprit.model;

public class Ingredient {
    private int id;
    private String nameingredient;
    private int qte;

    
    public Ingredient(){
        
    }

    public Ingredient(int id,String nameingredient, int qte) {
        this.id=id;
        this.nameingredient = nameingredient;
        this.qte = qte;
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

    
    
    
}
