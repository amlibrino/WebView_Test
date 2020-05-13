package org.hmid.gui;

import javafx.beans.InvalidationListener;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class WebViewController implements Initializable {
    @FXML
    public ProgressBar progressBar;
    @FXML
    public ProgressIndicator progressCercle;
    @FXML
    private Button button;
    @FXML
    private Button btn2;
    @FXML
    private WebView webView;

    private WebEngine engine;
    private String url = "https://germainsip.github.io/" ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

       engine = webView.getEngine();

        // A Worker load the page
        Worker<Void> worker = engine.getLoadWorker();
        // Listening to the status of worker
        worker.stateProperty().addListener((InvalidationListener) e -> {
        });

        // Bind the progress property of ProgressBar
        // with progress property of Worker
        progressBar.progressProperty().bind(worker.progressProperty());
        progressCercle.progressProperty().bind(worker.progressProperty());

    }

    public void onClick(ActionEvent Event){
        progressCercle.setVisible(false);
        progressBar.setVisible(true);
        engine.load(url);
    }
    public void btn2(ActionEvent Event){
        engine.executeScript("window.location = \"https://github.com/amlibrino//\";");
        progressBar.setVisible(false);
        progressCercle.setVisible(true);
    }
}

