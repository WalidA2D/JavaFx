package fr.gsb.rv.dr.gsbrvdr;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Alert.AlertType;
import fr.gsb.rv.dr.technique.Session ;
import fr.gsb.rv.dr.entites.Visiteur ;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene( root , 650 , 500);

        // Création du visiteur
        Visiteur visiteur1 = new Visiteur("OB001","BOUAICHI","Oumaya");
        // Fin création du visiteur

        // Initialisation de la barre de menus
        MenuBar barreMenu = new MenuBar();

        Menu menuFichier = new Menu("Fichier");
        MenuItem itemsSeConnecter = new MenuItem("Se connecter");
        MenuItem itemsSeDeconnecter = new MenuItem("Se déconnecter");
        MenuItem itemsQuitter = new MenuItem("Quitter");

        Menu menuRapport = new Menu("Rapport");
        MenuItem itemsConsulter = new MenuItem("Consulter");

        Menu menuPraticiens = new Menu("Praticiens");
        MenuItem itemsHesitants = new MenuItem("Hésitants");
        // Fin d'initialisation de la barre de menus

        itemsQuitter.setOnAction(actionEvent -> {
            Alert alertQuitter = new Alert(AlertType.CONFIRMATION) ;
            alertQuitter.setTitle("Quitter");
            alertQuitter.setHeaderText("Demande de confirmation");
            alertQuitter.setContentText("Voulez-vous quitter l'application ?");

            alertQuitter.showAndWait();
            Platform.exit();
        }
        );
        // Barre de menus par défaut
        root.setTop(barreMenu);
        barreMenu.getMenus().add(menuFichier);
        menuFichier.getItems().add(itemsSeConnecter);

        menuFichier.getItems().add(itemsQuitter);
        // Fin barre de menus

        itemsSeConnecter.setOnAction(actionEvent -> {
            Session.ouvrir(visiteur1); // Ouvrir la session
            stage.setTitle(visiteur1.getNom() + " " + visiteur1.getPrenom()); // Titre après connection

            // Barre menus en étant connecté
            menuFichier.getItems().add(itemsSeDeconnecter);
            menuFichier.getItems().remove(itemsSeConnecter);

            barreMenu.getMenus().add(menuRapport);
            menuRapport.getItems().add(itemsConsulter);

            barreMenu.getMenus().add(menuPraticiens);
            menuPraticiens.getItems().add(itemsHesitants);
            // Fin barre de menus



        });
        itemsSeDeconnecter.setOnAction(actionEvent -> {
            Session.fermer() ; // Fermer la session
            stage.setTitle("GSB-RV-DR"); // Titre après déconnection

            // Barre menus sans être connecté
            menuFichier.getItems().remove(itemsSeDeconnecter);
            menuFichier.getItems().add(itemsSeConnecter);

            barreMenu.getMenus().remove(menuRapport);
            menuRapport.getItems().remove(itemsConsulter);

            barreMenu.getMenus().remove(menuPraticiens);
            menuPraticiens.getItems().remove(itemsHesitants);
            // Fin barre de menus



        });
        itemsConsulter.setOnAction(actionEvent -> {
            // Affichage dans le terminal
            System.out.println("[Rapport] " + visiteur1.getNom() + " " + visiteur1.getPrenom());
            // Fin de l'affichage dans le terminal
        });

        itemsHesitants.setOnAction(actionEvent -> {
            // Affichage dans le terminal
            System.out.println("[Praticiens] " + visiteur1.getNom() + " " + visiteur1.getPrenom());
            // Fin de l'affichage dans le terminal
        });

        stage.setTitle("GSB-RV-DR"); // Titre par défaut
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}