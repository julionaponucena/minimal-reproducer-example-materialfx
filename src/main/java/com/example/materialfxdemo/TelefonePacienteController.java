package com.example.materialfxdemo;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.VBox;

public class TelefonePacienteController {
    @FXML
    private MFXTableView mfxTableView;

    @FXML
    MFXTextField txtTelefone;

    @FXML
    MFXTextField txtDDD;

    ObservableList<Telefone> telefones = FXCollections.observableArrayList();

    @FXML
    VBox containerTelefones;

    @FXML
    private void initialize(){
        this.mfxTableView = new MFXTableView<Telefone>();
        final MFXTableColumn<Telefone> DDDColumn = new MFXTableColumn("DDD");
        final MFXTableColumn<Telefone> telefoneColumn = new MFXTableColumn<>("Telefone");
        final MFXTableColumn<Telefone> deleteColumn = new MFXTableColumn<>("");

        DDDColumn.setRowCellFactory(telefone -> new MFXTableRowCell<Telefone, Integer>(Telefone::getDDD));

        telefoneColumn.setRowCellFactory(telefone -> new MFXTableRowCell<Telefone, Long>(Telefone::getNumero));

        deleteColumn.setRowCellFactory(telefone -> {
            final MFXButton mfxButton = new MFXButton("Deletar");

            final MFXTableRowCell mfxTableRowCell = new MFXTableRowCell<Telefone, String>(telefone1 -> "Deletar");
            mfxTableRowCell.setGraphic(mfxButton);

            return mfxTableRowCell;
        });

        mfxTableView.getTableColumns().addAll(DDDColumn, telefoneColumn, deleteColumn);


        mfxTableView.setItems(telefones);
        this.containerTelefones.getChildren().add(mfxTableView);
    }

    @FXML
    private void add (){
        final String numero = txtTelefone.getText();
        final String DDD = txtDDD.getText();


        Telefone telefone = new Telefone();
        telefone.setNumero(Long.parseLong(numero));
        telefone.setDDD(Integer.parseInt(DDD));

        this.telefones.add(telefone);
    }
}