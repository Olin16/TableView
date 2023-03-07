package org.scienceleadership.Phone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class PhoneController {
  public TableView allColumns;
  public TableColumn<Samsung, String> phoneColumn;
  public TableColumn<Samsung, String> storageColumn;
  public TableColumn<Samsung, String> sizeColumn;
  public TableColumn<Samsung, String> processorColumn;
  public TableColumn<Samsung, String> chargerTypeColumn;
  public TableColumn<Samsung, String> memoryColumn;
  public TableColumn<Samsung, String> fingerPrintColumn;
  public TableColumn<Samsung, String> ramColumn;

  public void initialize() throws Exception {
    //Apple.readAppleData();
    Samsung.readSamsungData();

    ArrayList<Phone> temporaryList = Phone.getPhones();
    System.out.println((temporaryList));
    ObservableList temporaryObservableList = FXCollections.observableArrayList(temporaryList);
    allColumns.setItems(temporaryObservableList);

    phoneColumn.setCellValueFactory(new PropertyValueFactory<>("Phone"));
    storageColumn.setCellValueFactory(new PropertyValueFactory<>("Storage"));
    sizeColumn.setCellValueFactory(new PropertyValueFactory<>("Size"));
    processorColumn.setCellValueFactory(new PropertyValueFactory<>("Processor"));
    chargerTypeColumn.setCellValueFactory(new PropertyValueFactory<>("Charger Type"));
    memoryColumn.setCellValueFactory(new PropertyValueFactory<>("Memory"));
    fingerPrintColumn.setCellValueFactory(new PropertyValueFactory<>("Finger Print"));
    ramColumn.setCellValueFactory(new PropertyValueFactory<>("Ram"));

    // This causes TableView's values to be editable
    phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    storageColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    sizeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    processorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    chargerTypeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    memoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    fingerPrintColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    ramColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    // This causes edited values from TableView to be stored in BoxOfficeFilm object
    phoneColumn.setOnEditCommit(
            (TableColumn.CellEditEvent<Samsung, String> t) -> {
              int tableRow = t.getTablePosition().getRow();
              Samsung filmFromTableRow = t.getTableView().getItems().get(tableRow);
              filmFromTableRow.setPhoneType(String.valueOf(t.getNewValue()));
            });
    storageColumn.setOnEditCommit(
            (TableColumn.CellEditEvent<Samsung, String> t) -> {
              int tableRow = t.getTablePosition().getRow();
              Samsung filmFromTableRow = t.getTableView().getItems().get(tableRow);
              filmFromTableRow.setStorage(t.getNewValue());
            });
    sizeColumn.setOnEditCommit(
            (TableColumn.CellEditEvent<Samsung, String> t) -> {
              int tableRow = t.getTablePosition().getRow();
              Samsung filmFromTableRow = t.getTableView().getItems().get(tableRow);
              filmFromTableRow.setScreenSize(String.valueOf(t.getNewValue()));
            });
    processorColumn.setOnEditCommit(
            (TableColumn.CellEditEvent<Samsung, String> t) -> {
              int tableRow = t.getTablePosition().getRow();
              Samsung filmFromTableRow = t.getTableView().getItems().get(tableRow);
              filmFromTableRow.setProcessor(String.valueOf(t.getNewValue()));
            });
    chargerTypeColumn.setOnEditCommit(
            (TableColumn.CellEditEvent<Samsung, String> t) -> {
              int tableRow = t.getTablePosition().getRow();
              Samsung filmFromTableRow = t.getTableView().getItems().get(tableRow);
              filmFromTableRow.setChargerType(String.valueOf(t.getNewValue()));
            });
    memoryColumn.setOnEditCommit(
            (TableColumn.CellEditEvent<Samsung, String> t) -> {
              int tableRow = t.getTablePosition().getRow();
              Samsung filmFromTableRow = t.getTableView().getItems().get(tableRow);
              filmFromTableRow.setExternalMemory(String.valueOf(t.getNewValue()));
            });
    fingerPrintColumn.setOnEditCommit(
            (TableColumn.CellEditEvent<Samsung, String> t) -> {
              int tableRow = t.getTablePosition().getRow();
              Samsung filmFromTableRow = t.getTableView().getItems().get(tableRow);
              filmFromTableRow.setFingerPrint(String.valueOf(t.getNewValue()));
            });
    ramColumn.setOnEditCommit(
            (TableColumn.CellEditEvent<Samsung, String> t) -> {
              int tableRow = t.getTablePosition().getRow();
              Samsung filmFromTableRow = t.getTableView().getItems().get(tableRow);
              filmFromTableRow.setRam(String.valueOf(t.getNewValue()));
            });
  }


  public void saveData() throws Exception {
    FileOutputStream fileOut = new FileOutputStream("SavedFilmObjects");
    ObjectOutputStream out = new ObjectOutputStream(fileOut);

    // allTheTexts is my ListView. Save its ObservableList by turning it into an ArrayList.
    ArrayList<String> temporaryList = new ArrayList<>(allColumns.getItems());
    out.writeObject(temporaryList);

    out.close();
    fileOut.close();
  }

  public void restoreOrReadData() throws FileNotFoundException {
    // First try to restore saved objects, but then read data file if that fails.
    try {
      FileInputStream fileIn = new FileInputStream("SavedFilmObjects");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      // Restored saved objects into Film's arrayList of all films
      Phone.setPhones((ArrayList<Phone>)in.readObject());
      in.close();
      fileIn.close();
    } catch (Exception exception) {
      // Restoring saved objects failed, so read data from text file instead
      Samsung.readSamsungData();
    }

    ArrayList<Phone> temporaryList = (ArrayList<Phone>) Phone.getPhones();
    // Turn the read data's ArrayList into an ObservableList
    ObservableList temporaryObservableList = FXCollections.observableArrayList(temporaryList);
    // Make that ObservableList the list for my TableView
    allColumns.setItems(temporaryObservableList);
  }
}

