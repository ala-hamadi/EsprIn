package Modules;

import Utils.Enums.OffreCategorie;
import Utils.Enums.State;


public class Offre {
    private int idOffre;
    private long offerProvider;
    private OffreCategorie category;
    private String titleOffer, descOffer, imgOffre;

    private State state;

    public Offre(OffreCategorie category, String titleOffer, String descOffer, long offerProvider, String imgOffre) {
        this.category = category;
        this.titleOffer = titleOffer;
        this.descOffer = descOffer;
        this.offerProvider = offerProvider;
        this.imgOffre = imgOffre;
    }

    public Offre( String titleOffer, String descOffer, OffreCategorie category, long offerProvider) {
       this.offerProvider = offerProvider;
        this.category = category;
        this.titleOffer = titleOffer;
        this.descOffer = descOffer;
    }

    public Offre(int idOffre, String titleOffer, String descOffer, OffreCategorie category, long offerProvider,State state, String imgOffre) {
        this.state=state;
        this.idOffre = idOffre;
        this.offerProvider = offerProvider;
        this.category = category;
        this.titleOffer = titleOffer;
        this.descOffer = descOffer;
        this.imgOffre = imgOffre;
    }

    public OffreCategorie getCategory() {
        return category;
    }

    public void setCategory(OffreCategorie category) {
        this.category = category;
    }

    public long getOfferProvider() {
        return offerProvider;
    }

    public void setOfferProvider(long offerProvider) {
        this.offerProvider = offerProvider;
    }

    public String getTitleOffer() {
        return titleOffer;
    }

    public void setTitleOffer(String titleOffer) {
        this.titleOffer = titleOffer;
    }

    public String getDescOffer() {
        return descOffer;
    }

    public void setDescOffer(String descOffer) {
        this.descOffer = descOffer;
    }

    public int getIdOffer() {
        return idOffre;
    }

    public String getImgOffre() { return imgOffre; }

    public void setImgOffre(String imgOffre) { this.imgOffre = imgOffre; }

    @Override
    public String toString() {
        return "Offre{" +
                "offerProvider=" + offerProvider +
                ", category=" + category +
                ", titleOffer='" + titleOffer + '\'' +
                ", descOffer='" + descOffer + '\'' +
                ", imgOffre='" + imgOffre + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}