package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Controller {

    /**
     * Global variables
     */
    String dname="pmsn",duser="root",dpass="root",durl="";
    String username,password,ename,eid;
    int quant;

    /**
     * FXML Elements
     */
    @FXML private TextField userID;
    @FXML private PasswordField userPass;
    @FXML private StackPane dData;
    @FXML private Panel vSalePane,vEmployeePanel;


    /**
     * FXML Button Actions
     */
    @FXML
    public void login() throws IOException, SQLException {
        eid=userID.getText();
        password=userPass.getText();

        Stage s= (Stage) userID.getScene().getWindow();
        Parent root;

        /**
         * Code to verify the username and password
         */
        Connection con= sqLiteDataSource.getConnection();
        System.out.print(con);
        root= FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene=new Scene(root);
        s.setResizable(true);
        s.setTitle("Home");
        s.setScene(scene);
        s.show();

    }

    @FXML
    public void clear() {
        userID.setText("");
        userPass.setText("");
    }
    @FXML
    public void exit(){
        System.exit(0);
    }


    private static final SQLiteDataSource sqLiteDataSource;

    /**
     * Helper Functions
     */

    static {
        sqLiteDataSource=new SQLiteDataSource();
        sqLiteDataSource.setUrl("jdbc:sqlite:pms.db");
    }

    private void changeTop(Node node) {
        ObservableList<Node> childs = dData.getChildren();


            //
            Node topNode = childs.get(childs.size()-1);

            // This node will be brought to the front
            Node newTopNode = node;

            topNode.setVisible(false);
            topNode.toBack();

            newTopNode.setVisible(true);

    }
}
