package sample;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Controller {
    @FXML public TreeTableColumn<String,String> clmTS;
    @FXML public TreeTableColumn<String, String> clmDF;
    @FXML public TreeTableView<String> tblTreeView;
    private Stage stage;


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize(){
        File[] root = File.listRoots();
        ArrayList<TreeItem<String>> list = new ArrayList<>();
        for (int i = 0; i < root.length; i++) {
            list.add(new TreeItem<String>(root[i].getAbsolutePath()));
        }

        TreeItem<String> tblRoot = new TreeItem<>("My computer");

        tblRoot.getChildren().addAll(list);

        clmTS.setCellValueFactory((TreeTableColumn.CellDataFeatures<String, String> p) ->
                new ReadOnlyStringWrapper(p.getValue().getValue()));

        tblTreeView.setRoot(tblRoot);

    }
}
