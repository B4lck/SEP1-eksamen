package controllers;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.Employee;
import model.VIAPetsModelManager;

public class EmployeesController {
    private ViewHandler viewHandler;
    private Region root;
    private VIAPetsModelManager model;

    @FXML
    private TableView<Employee> employeesTable;

    @FXML private TableColumn<Employee, String> nameColumn;
    @FXML private TableColumn<Employee, String> descriptionColumn;

    private ObservableList<Employee> list = FXCollections.observableArrayList();

    public EmployeesController() {}
    public void init(ViewHandler viewHandler, VIAPetsModelManager model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        descriptionColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));

        reset();
    }
    public void reset(){
        list.clear();
        list.addAll(model.getEmployeeList().getList());
        employeesTable.setItems(list);
    }
    public Region getRoot() {
        return root;
    }

    public void back() {
        viewHandler.openView("MainMenu");
    }

    public void createEmployee() {}
    public void editEmployee() {}
    public void deleteEmployee() {}
}
