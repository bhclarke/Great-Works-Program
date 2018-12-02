import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class GreatWorksProgramApplication extends Application {

  Stage window;

  // Initial Scene
  BorderPane layout;
  Scene scene;

  // Backend Data


  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    // get starting data

    // Set Application Title
    window = primaryStage;
    window.setTitle("Great Works Program");

    // Create initial layout
    layout = createStart();

    // set scene
    scene = new Scene(layout, 1600, 900);
    // scene.getStylesheets().add("stylesheet.css");
    window.setScene(scene);

    // show Application
    window.show();

  }

  private BorderPane createStart() {
    // TODO Auto-generated method stub
    BorderPane layout = new BorderPane();
    layout.setTop(getProgressBars());
    layout.setCenter(getTabs());
    return layout;
  }

  private Node getTabs() {
    TabPane tabLayout = new TabPane();
    tabLayout.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

    Tab literatureTab = getLiteratureTab();
    Tab artTab = getArtTab();
    Tab musicTab = getMusicTab();
    Tab theatreTab = getTheatreTab();
    Tab filmTab = getFilmTab();
    Tab scienceTab = getScienceTab();
    tabLayout.getTabs().addAll(literatureTab, artTab, musicTab, theatreTab, filmTab, scienceTab);
    
    tabLayout.widthProperty().addListener((observable, oldValue, newValue) -> {
      tabLayout.setTabMinWidth(tabLayout.getWidth() / 7);
      tabLayout.setTabMaxWidth(tabLayout.getWidth() / 7);
    });

    return tabLayout;
  }

  private HBox getProgressBars() {
    HBox progressBars = new HBox();
    progressBars.getChildren().add(new Label("Progress:"));
    progressBars.getChildren().add(makeProgressBar("Literature", 0, 20));
    progressBars.getChildren().add(makeProgressBar("Art", 1, 20));
    progressBars.getChildren().add(makeProgressBar("Music", 2, 20));
    progressBars.getChildren().add(makeProgressBar("Theatre", 3, 20));
    progressBars.getChildren().add(makeProgressBar("Film", 4, 20));
    progressBars.getChildren().add(makeProgressBar("Science and Technology", 5, 10));
    return progressBars;
  }

  private HBox makeProgressBar(String label, int complete, int total) {
    
    HBox pStats = new HBox();
    
    Label title = new Label(label);
    ProgressBar pb = new ProgressBar();
    pb.setProgress((double) complete / total);
    Label progressText = new Label(complete + "/" + total);
    
    pStats.getChildren().addAll(title, pb, progressText);
    return pStats;
  }

  private Tab getScienceTab() {
    Tab tab = new Tab("Science and Technology");
    return tab;
  }

  private Tab getMusicTab() {
    Tab tab = new Tab("Music");
    return tab;
  }

  private Tab getTheatreTab() {
    Tab tab = new Tab("Theatre");
    return tab;
  }

  private Tab getFilmTab() {
    Tab tab = new Tab("Film");
    return tab;
  }

  private Tab getArtTab() {
    Tab tab = new Tab("Art");
    return tab;
  }

  private Tab getLiteratureTab() {
    Tab tab = new Tab("Literature");
    return tab;
  }

}
