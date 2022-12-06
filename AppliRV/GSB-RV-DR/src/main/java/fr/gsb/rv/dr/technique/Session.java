package fr.gsb.rv.dr.technique;

import fr.gsb.rv.dr.entites.Visiteur;


public class Session {
    private static Session session = null;
    private Visiteur leVisiteur ;

    public Session(Visiteur leVisiteur) {
        this.leVisiteur = leVisiteur ;
    } ;

    static public void ouvrir(Visiteur leVisiteur) {
        Session session = new Session(leVisiteur);
    }

    static public Session fermer(){
        return session = null;
    }

    public void setLeVisiteur(Visiteur leVisiteur) {
        this.leVisiteur = leVisiteur;
    }

    public static void setSession(Session session) {
        Session.session = session;
    }

    public Visiteur getLeVisiteur() {
        return leVisiteur;
    }

    public static Session getSession() {
        return session;
    }

    public static boolean estOuverte(){
        if(session == null){
            return false ;
        }
        else{
            return true ;
        }
    }

    @Override
    public String toString() {
        return "Session{" +
                "leVisiteur=" + leVisiteur +
                '}';
    }
}
