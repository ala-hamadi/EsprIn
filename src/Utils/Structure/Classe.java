package Utils.Structure;

public class Classe {
    private int niveau;
    private String specialite;
    private int numclass;

    public Classe(int niveau , String specialite , int numclass) {
        this.niveau = niveau;
        this.specialite=specialite;
        this.numclass=numclass;
    }

    public int getNiveau() { return niveau; }

    public String getSpecialite() { return specialite; }

    public int getNumclass() { return numclass; }

    public void setNiveau(int niveau) { this.niveau = niveau; }

    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public void setNumclass(int numclass) { this.numclass = numclass; }

    @Override
    public String toString() { return  niveau + " " + specialite  + " " + numclass; }


}
