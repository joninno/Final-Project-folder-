import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/*
* @author joninno
*/
public class PlayerManager extends Application 
{
	Stage menu = new Stage();
	public ArrayList<NFLPlayer> availablePlayers = new ArrayList<NFLPlayer>();
	public ArrayList<OffensivePlayer> offensivePlayers = new ArrayList<OffensivePlayer>();
	public ArrayList<DefensivePlayer> defensivePlayers = new ArrayList<DefensivePlayer>();
	public ArrayList<Object> roster = new ArrayList<Object>();
	public TextField searchField = new TextField();

	

	public void start(Stage primaryStage) 
	{
		createPlayers();
		menu.setTitle("NFL Draft Day");
		showMenu(); 
	}

	
	public void showMenu() 
	{
		BorderPane pane = new BorderPane();
		VBox center = new VBox(getSearchBar(), getMenu());
		center.setPadding(new Insets(15, 15, 15, 15));
		;
		pane.setCenter(center);
		menu.setScene(new Scene(pane, 768, 480));
		menu.show();
	}

	
	private void showOffense() 
	{
		BorderPane pane = new BorderPane();
		
		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(10, 5, 5, 5));

		Button back = new Button();
		back.setText("\u21D0Home"); 
		back.setId("back to menu");

		back.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		Button AvailableOff = new Button("Available Players"); 

		AvailableOff.setId("allOff"); 
		AvailableOff.setMaxWidth(Double.MAX_VALUE); 
		AvailableOff.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		Button QB = new Button("Quarterback"); 
		QB.setId("QB");
		QB.setMaxWidth(Double.MAX_VALUE); 
		QB.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		Button RB = new Button("Running backs"); 
		RB.setId("RB"); 
		RB.setMaxWidth(Double.MAX_VALUE); 
		RB.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		Button WR = new Button("Wide receiver"); 
		WR.setId("WR"); 
		WR.setMaxWidth(Double.MAX_VALUE); 
		WR.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		HBox offenseType = new HBox(); 
		offenseType.setSpacing(25);
		offenseType.setPadding(new Insets(0, 15, 0, 15));
		offenseType.getChildren().addAll(AvailableOff, QB, RB, WR); 


		vBox.getChildren().addAll(back, getSearchBar(), new Label("Select Position"), offenseType);
		pane.setCenter(vBox);
		menu.setScene(new Scene(pane, 768, 480));
		menu.show();
	}

	 //List offensive players
	private void listOffensivePlayers(String selection) 
	{
		BorderPane pane = new BorderPane();

		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(15, 5, 5, 5));

		Button back = new Button();
		back.setText("\u21E6"); 
		back.setId("back to offense");

		back.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		GridPane list = new GridPane();
		list.setAlignment(Pos.CENTER);
		list.setPadding(new Insets(10, 12, 12, 12));
		list.setHgap(5);
		list.setVgap(5);
		int i = 1;

		list.add(new Label("Name"), 0, 0);
		list.add(new Label("Age"), 1, 0);
		list.add(new Label("Number"), 2, 0);
		list.add(new Label("Team"), 3, 0);
		list.add(new Label("Height"), 4, 0);
		list.add(new Label("Weight"), 5, 0);
		list.add(new Label("Passing/Rec"), 6, 0);
		list.add(new Label("Rushing"), 7, 0);
		list.add(new Label("TD"), 8, 0);
		list.add(new Label("Draft"), 9, 0);

		if (selection == "allOff") 
		{
			for (OffensivePlayer object : offensivePlayers) 
			{
				if (object.getStatus() == "available") 
				{
					Label name = new Label(object.getName());
					Label age = new Label(Integer.toString(object.getAge()));
					Label number = new Label(Integer.toString(object.getNumber()));
					Label team = new Label(object.getTeam());
					Label height = new Label(Float.toString(object.getHeight()));
					Label weight = new Label(Float.toString(object.getWeight()));
					Label passRec = new Label(Double.toString(object.getPassing()));
					Label rushing = new Label(Double.toString(object.getRushing()));
					Label td = new Label(Double.toString(object.getTd()));
					Button draft = new Button();
					draft.setText("Draft"); 
					draft.setId("draftOff " + object.getName());
					draft.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
					list.add(name, 0, i);
					list.add(age, 1, i);
					list.add(number, 2, i);
					list.add(team, 3, i);
					list.add(height, 4, i);
					list.add(weight, 5, i);
					list.add(passRec, 6, i);
					list.add(rushing, 7, i);
					list.add(td, 8, i);
					list.add(draft, 9, i);
					i++;
				}
			}
		}
		
		
		 
		else 
		{
			for (OffensivePlayer object : offensivePlayers) 
			{
				if (object.getStatus() == "available" && object.getPosition() == selection) 
				{
					Label name = new Label(object.getName());
					Label age = new Label(Integer.toString(object.getAge()));
					Label number = new Label(Integer.toString(object.getNumber()));
					Label team = new Label(object.getTeam());
					Label height = new Label(Float.toString(object.getHeight()));
					Label weight = new Label(Float.toString(object.getWeight()));
					Label passRec = new Label(Double.toString(object.getPassing()));
					Label rushing = new Label(Double.toString(object.getRushing()));
					Label td = new Label(Double.toString(object.getTd()));
					Button draft = new Button();
					draft.setText("Draft"); 
					draft.setId("draftOff " + object.getPosition() + " " + object.getName());
					draft.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
					list.add(name, 0, i);
					list.add(age, 1, i);
					list.add(number, 2, i);
					list.add(team, 3, i);
					list.add(height, 4, i);
					list.add(weight, 5, i);
					list.add(passRec, 6, i);
					list.add(rushing, 7, i);
					list.add(td, 8, i);
					list.add(draft, 9, i);
					i++;
				}
			}
		}

		//Columns will resize with window
		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setFillWidth(true);
		columnConstraints.setHgrow(Priority.ALWAYS);
		list.getColumnConstraints().add(columnConstraints);
		
		vBox.getChildren().addAll(back, getSearchBar(), list);
		pane.setCenter(vBox);

		ScrollPane scroller = new ScrollPane(pane);
		scroller.setFitToWidth(true);

		menu.setScene(new Scene(scroller, 768, 480));
		menu.show();
	}

	//Show Defense Menu
	public void showDefense() 
	{
		BorderPane pane = new BorderPane();
		
		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(12, 5, 5, 5));
		//Unicode for back Arrow
		Button back = new Button();
		back.setText("\u21E6 Home"); 
		back.setId("back to menu");
		
		back.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
		//Create My Roster button
		Button AvailableOff = new Button("Available"); 
		//Set button id
		AvailableOff.setId("alldef"); 
		//Set button width
		AvailableOff.setMaxWidth(Double.MAX_VALUE); 
		AvailableOff.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
		//Create Defensive End
		Button DE = new Button("Defensive End");
		//Set button id
		DE.setId("DE"); 
		//Set button width
		DE.setMaxWidth(Double.MAX_VALUE); 
		DE.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
		//Create Linebacker
		Button ILB = new Button("Linebacker"); 
		//Set button id
		ILB.setId("ILB");
		//Set button width
		ILB.setMaxWidth(Double.MAX_VALUE); 
		ILB.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());


		//Create Free safety
		Button FS = new Button("Free safety"); 
		//Set button id
		FS.setId("FS"); 
		//Set button width
		FS.setMaxWidth(Double.MAX_VALUE); 
		FS.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
		//Create Outside Linebacker
		Button OLB = new Button("Outside Linebacker"); 
		//Set button id
		OLB.setId("OLB"); 
		//Set button width
		OLB.setMaxWidth(Double.MAX_VALUE); 
		OLB.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
		//Create Middle Linebacker
		Button MLB = new Button("Middle Linebacker "); 
		//Set button id
		MLB.setId("MLB");
		//Set button width
		MLB.setMaxWidth(Double.MAX_VALUE); 
		MLB.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());



		FlowPane defenseType = new FlowPane(); 
		defenseType.setHgap(50);
		defenseType.setPadding(new Insets(0, 10, 0, 10));
		
		defenseType.getChildren().addAll(AvailableOff, DE, ILB,  FS, OLB, MLB); 


		vBox.getChildren().addAll(back, getSearchBar(), new Label("Select Position"), defenseType);
		pane.setCenter(vBox);
		menu.setScene(new Scene(pane, 768, 480));
		menu.show();
	}
	
	
	//List defensive players
	private void listDeffensivePlayers(String selection) 
	{
		BorderPane pane = new BorderPane();

		VBox vBox = new VBox(15);
		vBox.setPadding(new Insets(12, 5, 5, 5));

		Button back = new Button();
		//Unicode for back Arrow
		back.setText("\u21E6"); 
		back.setId("back to defense");
		back.setFont(Font.font("Verdana", 20));
		back.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
		
		//Create gridPane for list of players
		GridPane list = new GridPane();
		list.setAlignment(Pos.CENTER);
		list.setPadding(new Insets(10, 12, 12, 12));
		list.setHgap(5);
		list.setVgap(5);
		int i = 1;

		//Set grid headers
		list.add(new Label("Name"), 0, 0);
		list.add(new Label("Age"), 1, 0);
		list.add(new Label("Number"), 2, 0);
		list.add(new Label("Team"), 3, 0);
		list.add(new Label("Height"), 4, 0);
		list.add(new Label("Weight"), 5, 0);
		list.add(new Label("Tackles"), 6, 0);
		list.add(new Label("Sacks"), 7, 0);
		list.add(new Label("Int"), 8, 0);
		list.add(new Label("Draft"), 9, 0);

		if (selection == "alldef") 
		{
			 //List all defensive players
			for (DefensivePlayer object : defensivePlayers) 
			{ 
				if (object.getStatus() == "available") 
				{
					Label name = new Label(object.getName());
					Label age = new Label(Integer.toString(object.getAge()));
					Label number = new Label(Integer.toString(object.getNumber()));
					Label team = new Label(object.getTeam());
					Label height = new Label(Float.toString(object.getHeight()));
					Label weight = new Label(Float.toString(object.getWeight()));
					Label Tackles = new Label(Double.toString(object.getTackles()));
					Label Sacks = new Label(Double.toString(object.getSacks()));
					Label Int = new Label(Double.toString(object.getInter()));
					Button draft = new Button();
					draft.setText("Draft"); 
					draft.setId("draftdef " + object.getName());
					draft.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
					list.add(name, 0, i);
					list.add(age, 1, i);
					list.add(number, 2, i);
					list.add(team, 3, i);
					list.add(height, 4, i);
					list.add(weight, 5, i);
					list.add(Tackles, 6, i);
					list.add(Sacks, 7, i);
					list.add(Int, 8, i);
					list.add(draft, 9, i);
					i++;
				}
			}
		} 
		
		
		else 
		{
			for (DefensivePlayer object : defensivePlayers) 
			{
				//All players by position
				if (object.getStatus() == "available" && object.getPosition() == selection) 
				{ 
					Label name = new Label(object.getName());
					Label age = new Label(Integer.toString(object.getAge()));
					Label number = new Label(Integer.toString(object.getNumber()));
					Label team = new Label(object.getTeam());
					Label height = new Label(Float.toString(object.getHeight()));
					Label weight = new Label(Float.toString(object.getWeight()));
					Label Tackles = new Label(Double.toString(object.getTackles()));
					Label Sacks = new Label(Double.toString(object.getSacks()));
					Label Int = new Label(Double.toString(object.getInter()));
					Button draft = new Button();
					//Unicode for back Arrow
					draft.setText("Draft"); 
					draft.setId("draftdef " + object.getPosition() + " " + object.getName());
					draft.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
					list.add(name, 0, i);
					list.add(age, 1, i);
					list.add(number, 2, i);
					list.add(team, 3, i);
					list.add(height, 4, i);
					list.add(weight, 5, i);
					list.add(Tackles, 6, i);
					list.add(Sacks, 7, i);
					list.add(Int, 8, i);
					list.add(draft, 9, i);
					i++;
				}
			}
		}

		
		//Columns will resize with window
		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setFillWidth(true);
		columnConstraints.setHgrow(Priority.ALWAYS);
		list.getColumnConstraints().add(columnConstraints);
		
		//Add All Node to vBox
		vBox.getChildren().addAll(back, getSearchBar(), list);
		pane.setCenter(vBox);

		//Create ScrollPane
		ScrollPane scroller = new ScrollPane(pane);
		scroller.setFitToWidth(true);

		menu.setScene(new Scene(scroller, 768, 480));
		menu.show();
	}
	
	
	//Show My Roster
	private void showRoster() 
	{
		BorderPane pane = new BorderPane();
	
		VBox vBox = new VBox(12);
		vBox.setPadding(new Insets(12, 5, 5, 5));

		Button back = new Button();
		 //Unicode for back Arrow
		back.setText("\u21E6"); 
		back.setId("back to menu");

		back.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		 //Create gridPane for list of players
		GridPane list = new GridPane();
		list.setAlignment(Pos.CENTER);
		list.setPadding(new Insets(10, 12, 12, 12));
		list.setHgap(5);
		list.setVgap(5);
		int i = 0;
		int offResults = 0;
		int defResults = 0;

		// List all defensive players
		for (Object object : roster) 
		{ 
			if (((NFLPlayer) object).getCategory().equals("off")) 
			{
				offResults++;
			}
		}

		
		
		if (offResults > 0) 
		{
			list.add(new Label("Offense"), 0, 0);
			list.add(new Label("Age"), 1, 0);
			list.add(new Label("Number"), 2, 0);
			list.add(new Label("Team"), 3, 0);
			list.add(new Label("Height"), 4, 0);
			list.add(new Label("Weight"), 5, 0);
			list.add(new Label("Passing/Rec"), 6, 0);
			list.add(new Label("Rushing"), 7, 0);
			list.add(new Label("TD"), 8, 0);
			list.add(new Label("Cut"), 9, 0);
			i++;
		}
		
		
		//List all defensive players
		for (Object object : roster) 
		{ 
			if (((NFLPlayer) object).getCategory() == "off") {
				Label name = new Label(((NFLPlayer) object).getName());
				Label age = new Label(Integer.toString(((NFLPlayer) object).getAge()));
				Label number = new Label(Integer.toString(((NFLPlayer) object).getNumber()));
				Label team = new Label(((NFLPlayer) object).getTeam());
				Label height = new Label(Float.toString(((NFLPlayer) object).getHeight()));
				Label weight = new Label(Float.toString(((NFLPlayer) object).getWeight()));
				Label passRec = new Label(Double.toString(((OffensivePlayer) object).getPassing()));
				Label rushing = new Label(Double.toString(((OffensivePlayer) object).getRushing()));
				Label td = new Label(Double.toString(((OffensivePlayer) object).getTd()));
				Button draft = new Button();
				draft.setText("Cut"); 
				draft.setId("cut_ " + ((NFLPlayer) object).getName());
				draft.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
				list.add(name, 0, i);
				list.add(age, 1, i);
				list.add(number, 2, i);
				list.add(team, 3, i);
				list.add(height, 4, i);
				list.add(weight, 5, i);
				list.add(passRec, 6, i);
				list.add(rushing, 7, i);
				list.add(td, 8, i);
				list.add(draft, 9, i);
				i++;
			}
		}

		
		//Set grid headers
        //List all defensive players
		for (Object object : roster) {
			if (((NFLPlayer) object).getCategory().equals("def")) 
			{
				defResults++;
			}
		}
		

		if (defResults > 0) 
		{
			list.add(new Label("Defense"), 0, i);
			list.add(new Label("Age"), 1, i);
			list.add(new Label("Number"), 2, i);
			list.add(new Label("Team"), 3, i);
			list.add(new Label("Height"), 4, i);
			list.add(new Label("Weight"), 5, i);
			list.add(new Label("Tackles"), 6, i);
			list.add(new Label("Sacks"), 7, i);
			list.add(new Label("Int"), 8, i);
			list.add(new Label("Cut"), 9, i);
			i++;
		}

		
		 //List all defensive players
		for (Object object : roster) 
		{ 
			if (((NFLPlayer) object).getCategory() == "def") {
				Label name = new Label(((NFLPlayer) object).getName());
				Label age = new Label(Integer.toString(((NFLPlayer) object).getAge()));
				Label number = new Label(Integer.toString(((NFLPlayer) object).getNumber()));
				Label team = new Label(((NFLPlayer) object).getTeam());
				Label height = new Label(Float.toString(((NFLPlayer) object).getHeight()));
				Label weight = new Label(Float.toString(((NFLPlayer) object).getWeight()));
				Label Tackles = new Label(Double.toString(((DefensivePlayer) object).getTackles()));
				Label Sacks = new Label(Double.toString(((DefensivePlayer) object).getSacks()));
				Label Int = new Label(Double.toString(((DefensivePlayer) object).getInter()));
				Button draft = new Button();
				 //Unicode for back Arrow
				draft.setText("Cut"); 
				draft.setId("cut_ " + ((NFLPlayer) object).getName());
				draft.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
				list.add(name, 0, i);
				list.add(age, 1, i);
				list.add(number, 2, i);
				list.add(team, 3, i);
				list.add(height, 4, i);
				list.add(weight, 5, i);
				list.add(Tackles, 6, i);
				list.add(Sacks, 7, i);
				list.add(Int, 8, i);
				list.add(draft, 9, i);
				i++;
			}
		}


		//Columns will resize with window
		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setFillWidth(true);
		columnConstraints.setHgrow(Priority.ALWAYS);
		list.getColumnConstraints().add(columnConstraints);

		//Add All Node to vBox
		vBox.getChildren().addAll(back, getSearchBar(), list);
		pane.setCenter(vBox);

		//Create ScrollPane
		ScrollPane scroller = new ScrollPane(pane);
		scroller.setFitToWidth(true);

		menu.setScene(new Scene(scroller, 768, 480));
		menu.show();
	}

	//Show Search Results
	private void showSearchResults(String searchName) 
	{
		BorderPane pane = new BorderPane();

		VBox vBox = new VBox(12);
		vBox.setPadding(new Insets(12, 5, 5, 5));

		Button back = new Button();
		 //Unicode for back Arrow
		back.setText("\u21E6"); 
		back.setId("back to menu");
		back.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		//Create gridPane for list of players
		GridPane list = new GridPane();
		list.setAlignment(Pos.CENTER);
		list.setPadding(new Insets(10, 12, 12, 12));
		list.setHgap(5);
		list.setVgap(5);
		int i = 0;
		int offResults = 0;
		int defResults = 0;

		//List all defensive players
		for (Object object : offensivePlayers) { 
			if (((NFLPlayer) object).getName().toLowerCase().contains(searchName.toLowerCase())) 
			{
				offResults++;
			}
		}
		
		

		if (offResults > 0) 
		{
			list.add(new Label("Offense"), 0, 0);
			list.add(new Label("Age"), 1, 0);
			list.add(new Label("Number"), 2, 0);
			list.add(new Label("Team"), 3, 0);
			list.add(new Label("Height"), 4, 0);
			list.add(new Label("Weight"), 5, 0);
			list.add(new Label("Passing/Rec"), 6, 0);
			list.add(new Label("Rushing"), 7, 0);
			list.add(new Label("TD"), 8, 0);
			list.add(new Label("Cut"), 9, 0);
			i++;
		}
		
		
		//List all defensive players
		for (Object object : offensivePlayers) { 
			if (((NFLPlayer) object).getName().toLowerCase().contains(searchName.toLowerCase())) 
			{
				Label name = new Label(((NFLPlayer) object).getName());
				Label age = new Label(Integer.toString(((NFLPlayer) object).getAge()));
				Label number = new Label(Integer.toString(((NFLPlayer) object).getNumber()));
				Label team = new Label(((NFLPlayer) object).getTeam());
				Label height = new Label(Float.toString(((NFLPlayer) object).getHeight()));
				Label weight = new Label(Float.toString(((NFLPlayer) object).getWeight()));
				Label passRec = new Label(Double.toString(((OffensivePlayer) object).getPassing()));
				Label rushing = new Label(Double.toString(((OffensivePlayer) object).getRushing()));
				Label td = new Label(Double.toString(((OffensivePlayer) object).getTd()));
				Button draft = new Button();
				 //Unicode for back Arrow
				draft.setText("Draft"); 
				draft.setId("draftOff " + ((NFLPlayer) object).getName());
				draft.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
				list.add(name, 0, i);
				list.add(age, 1, i);
				list.add(number, 2, i);
				list.add(team, 3, i);
				list.add(height, 4, i);
				list.add(weight, 5, i);
				list.add(passRec, 6, i);
				list.add(rushing, 7, i);
				list.add(td, 8, i);
				list.add(draft, 9, i);
				i++;
			}
		}
		
		
		//List all defensive players
		for (Object object : defensivePlayers) { 
			if (((NFLPlayer) object).getName().toLowerCase().contains(searchName.toLowerCase())) 
			{
				defResults++;
			}
		}
		
		

		if (defResults > 0) 
		{
			//Set grid headers
			list.add(new Label("Defense"), 0, i);
			list.add(new Label("Age"), 1, i);
			list.add(new Label("Number"), 2, i);
			list.add(new Label("Team"), 3, i);
			list.add(new Label("Height"), 4, i);
			list.add(new Label("Weight"), 5, i);
			list.add(new Label("Tackles"), 6, i);
			list.add(new Label("Sacks"), 7, i);
			list.add(new Label("Int"), 8, i);
			list.add(new Label("Cut"), 9, i);
			i++;
		}

		
		 //List all defensive players
		for (Object object : defensivePlayers) 
		{ 
			if (((NFLPlayer) object).getName().toLowerCase().contains(searchName.toLowerCase())) 
			{
				Label name = new Label(((NFLPlayer) object).getName());
				Label age = new Label(Integer.toString(((NFLPlayer) object).getAge()));
				Label number = new Label(Integer.toString(((NFLPlayer) object).getNumber()));
				Label team = new Label(((NFLPlayer) object).getTeam());
				Label height = new Label(Float.toString(((NFLPlayer) object).getHeight()));
				Label weight = new Label(Float.toString(((NFLPlayer) object).getWeight()));
				Label Tackles = new Label(Double.toString(((DefensivePlayer) object).getTackles()));
				Label Sacks = new Label(Double.toString(((DefensivePlayer) object).getSacks()));
				Label Int = new Label(Double.toString(((DefensivePlayer) object).getInter()));
				Button draft = new Button();
				 //Unicode for back Arrow
				draft.setText("Draft"); 
				draft.setId("draftdef " + ((NFLPlayer) object).getName());
				draft.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
				list.add(name, 0, i);
				list.add(age, 1, i);
				list.add(number, 2, i);
				list.add(team, 3, i);
				list.add(height, 4, i);
				list.add(weight, 5, i);
				list.add(Tackles, 6, i);
				list.add(Sacks, 7, i);
				list.add(Int, 8, i);
				list.add(draft, 9, i);
				i++;
			}
		}

		//Columns will resize with window
		ColumnConstraints columnConstraints = new ColumnConstraints();
		columnConstraints.setFillWidth(true);
		columnConstraints.setHgrow(Priority.ALWAYS);
		list.getColumnConstraints().add(columnConstraints);
		
		//Add All Node to vBox
		vBox.getChildren().addAll(back, getSearchBar(), list);
		pane.setCenter(vBox);
		
		//Create ScrollPane
		ScrollPane scroller = new ScrollPane(pane);
		scroller.setFitToWidth(true);

		menu.setScene(new Scene(scroller, 768, 480));
		menu.show();
	}

	//Return Main Menu
	private Node getMenu() 
	{
		//Create View Offense
		Button offense = new Button("View Offense"); 
		//Set button id
		offense.setId("View Offense"); 
		 //Set button width
		offense.setMaxWidth(Double.MAX_VALUE); 
		offense.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		//Create View Defense
		Button defense = new Button("View Defense");
		//Set button id
		defense.setId("View Defense"); 
		 //Set button width
		defense.setMaxWidth(Double.MAX_VALUE);
		defense.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		//Create My Roster
		Button myRoster = new Button("My Roster");
		//Set button id
		myRoster.setId("My Roster");
		 //Set button width
		myRoster.setMaxWidth(Double.MAX_VALUE);
		myRoster.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());

		VBox vbButtons = new VBox();
		vbButtons.setSpacing(25);
		vbButtons.setPadding(new Insets(25, 200, 25, 200));

		vbButtons.getChildren().addAll(offense, defense);

		//If currentRoster has any players add button to scene
		if (!roster.isEmpty()) 
		{
			vbButtons.getChildren().addAll(myRoster);
		}
		
		
		
		return vbButtons;
	}

	//Return Logo in StackPane
    private StackPane getLogo(){
        //15 pixels space between child nodes
        StackPane stackPane = new StackPane();
        stackPane.setPrefHeight(100);
        //15 pixel padding all around
        stackPane.setPadding(new Insets(15, 15, 15, 15));
        //Background color is gray
        stackPane.setStyle("-fx-background-color: gray");
        //Create & add image to imageView
        ImageView imageView = new ImageView(new Image("images/NFL_Draft.png"));
        //Set imageView height
        imageView.setFitHeight(200);
        //Preserve image aspect ratio
        imageView.setPreserveRatio(true);
        //Add imageView to hbox
        stackPane.getChildren().add(imageView);
        return stackPane;
    }
    
	//Create and return Searchbar
	private HBox getSearchBar() 
	{
		 //Create label
		Label searchlabel = new Label("Search Player");
		searchField.setId("searchFor");
		searchField.setMinWidth(75);
		searchField.setPrefWidth(560);
		searchField.setMaxWidth(560);
		//Create search button
		Button searchBtn = new Button("Search");
		 //Set button id
		searchBtn.setId("search"); 
		//Set button width
		searchBtn.setMaxWidth(Double.MAX_VALUE);
		searchBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler());
		//Create HBox
		HBox searchBar = new HBox(); 
		//Add all nodes to scene
		searchBar.getChildren().addAll(searchlabel, searchField, searchBtn); 

		searchBar.setSpacing(10);
		return searchBar;
	}


	
	public void createPlayers() 
	{

		// Create Offensive Players
	
OffensivePlayer offensivePlayer1 = new OffensivePlayer("Drew Brees",38,9,"Nee Orleans Saints",6,209,"off","QB",5208,8.1,23,20,0,0, 0);
OffensivePlayer offensivePlayer2 = new OffensivePlayer("Matt Ryan",31,2,"Atlanta Falcons",6.4,217,"off","QB",4944,9.3,35,117,0, 0, 0);
OffensivePlayer offensivePlayer3 = new OffensivePlayer("Kirk Cousins",28,8,"Washinngton Redskins",6.3,210,"off","QB",4917,8.1,34,96,0, 0, 0);
OffensivePlayer offensivePlayer4 = new OffensivePlayer("Aaron Rodgers",33,12,"Green Bay Packer",6.2,225,"off","QB",4428,7.3,67,369,0, 0, 0);
OffensivePlayer offensivePlayer5 = new OffensivePlayer("Philip Rivers",35,17,"Los Angeles Chargers",6.5,228,"off","QB",4386,7.6,14,35,0, 0, 0);
OffensivePlayer offensivePlayer6 = new OffensivePlayer("Ezekiel Elliott",21,21,"Dallas Cowboys",6,225,"off", "RB",0,0,322,1631,11.3, 0, 0);

OffensivePlayer offensivePlayer7 = new OffensivePlayer("Jordan Howard",22,24,"Chicago Bears",6,222,"off","RB",0,0,252,1313,10.3, 0, 0);
OffensivePlayer offensivePlayer8 = new OffensivePlayer("DeMarco Murray",29,29,"Tennessee",6.1,220,"off","RB",0,0,293,1287,7.1, 0, 0);
OffensivePlayer offensivePlayer9 = new OffensivePlayer("Jay Ajayi",23,23,"Miami Dolphins",6,229,"off","RB",0,0,260,1272,5.6, 0, 0);
OffensivePlayer offensivePlayer10 = new OffensivePlayer("Le'Veon Bell",25,26,"Pittsburg Steelers",6.1,225,"off","RB",0,0,261,1268,5.7, 0, 0);
OffensivePlayer offensivePlayer11 = new OffensivePlayer(" T.Y. Hilton",27,13,"Indianapolis Colts",5.9,180,"off","WR",0,0,0,1448,15.9, 0, 0);
OffensivePlayer offensivePlayer12 = new OffensivePlayer("Julio Jones",28,11,"Atlanta Falcons",6.3,220,"off","WR",0,0,0,1409,17, 0, 0);
OffensivePlayer offensivePlayer13 = new OffensivePlayer("Odell Beckham",24,13,"New York Giants",5.11,198,"off","WR",0,0,1,1367,13.5, 0, 0);
OffensivePlayer offensivePlayer14 = new OffensivePlayer("Mike Evans",23,13,"Tampa Bay Buccaneers",6.5,231,"off","WR",0,0,0,1321,13.8, 0, 0);
OffensivePlayer offensivePlayer15 = new OffensivePlayer("Antonio Brown",28,84,"Pittsburg Steelers",5.1,181,"off","WR",0,0,3,1284,12.1, 0, 0);



		// Create Defensive Players
		


DefensivePlayer defensivePlayer1 = new DefensivePlayer("Bobby Wagner",26,64,"Seattle Seahawks","MLB",6,245,"def",167,85,82,4.5, 0);
DefensivePlayer defensivePlayer2 = new DefensivePlayer("Zach Brown",27,53,"Buffalo Bills","ILB",6.1,248,"def",149,97,52,4, 0);
DefensivePlayer defensivePlayer3 = new DefensivePlayer("Christian Kirksey",24,58,"Cleveland Browns","ILB",6.2,235,"def",148,96,52,2.5, 0);
DefensivePlayer defensivePlayer4 = new DefensivePlayer("Kwon Alexander",22,58,"Tampa Bay Buccaneers","MLB",6.1,227,"def",145,108,37,3, 0);
DefensivePlayer defensivePlayer5 = new DefensivePlayer("Sean Lee",30,50,"Dallas Cowboys","OLB",6.2,238,"def",145,93,52,0, 0);
DefensivePlayer defensivePlayer6 = new DefensivePlayer("Vic Beasley",24,44,"Atlanta Falcons","OLB",6.3,246,"def",39,32,7,15.5, 0);
DefensivePlayer defensivePlayer7 = new DefensivePlayer("Von Miller",27,58,"Denver Broncos","OLB",6.3,250,"def",78,62,16,13.5, 0);
DefensivePlayer defensivePlayer8 = new DefensivePlayer("Lorenzo Alexander",33,57,"Buffalo Bills","OLB",6.1,245,"def",76,56,20,12.5, 0);
DefensivePlayer defensivePlayer9 = new DefensivePlayer("Markus Golden",26,44,"Arizona Cardinals","OLB",6.3,260,"def",51,2,10,13.5, 0);
DefensivePlayer defensivePlayer10 = new DefensivePlayer("Danielle Hunter",22,99,"Minnesota Vikings","DE",6.5,252,"def",56,34,22,12.5, 0);
DefensivePlayer defensivePlayer11 = new DefensivePlayer("Casey Hayward",27,26,"Loa Angeles Chargers","CB",5.11,192,"def",58,51,7,0, 0);
DefensivePlayer defensivePlayer12 = new DefensivePlayer("Marcus Peters",24,22,"Kansas City Chiefs","CB",6,197,"def",45,35,10,0, 0);
DefensivePlayer defensivePlayer13 = new DefensivePlayer("Dominique Rodgers-Cromartie",30,41,"New York Giants","CB",6.2,193,"def",49,41,8,1, 0);
DefensivePlayer defensivePlayer14 = new DefensivePlayer("Ha Ha Clinton-Dix",24,21,"Green Bay Packers","FS",6.1,208,"def",80,62,18,0.5, 0);





		// Add Offensive Players to draft
		offensivePlayers.add(offensivePlayer1);
		offensivePlayers.add(offensivePlayer2);
		offensivePlayers.add(offensivePlayer3);
		offensivePlayers.add(offensivePlayer4);
		offensivePlayers.add(offensivePlayer5);
		offensivePlayers.add(offensivePlayer6);
		offensivePlayers.add(offensivePlayer7);
		offensivePlayers.add(offensivePlayer8);
		offensivePlayers.add(offensivePlayer9);
		offensivePlayers.add(offensivePlayer10);
		
		offensivePlayers.add(offensivePlayer11);
		offensivePlayers.add(offensivePlayer12);
		offensivePlayers.add(offensivePlayer13);
		offensivePlayers.add(offensivePlayer14);
		offensivePlayers.add(offensivePlayer15);

		// Add Defensive Players to draft
		defensivePlayers.add(defensivePlayer1);
		defensivePlayers.add(defensivePlayer2);
		defensivePlayers.add(defensivePlayer3);
		defensivePlayers.add(defensivePlayer4);
		defensivePlayers.add(defensivePlayer5);
		defensivePlayers.add(defensivePlayer6);
		defensivePlayers.add(defensivePlayer7);
		defensivePlayers.add(defensivePlayer8);
		defensivePlayers.add(defensivePlayer9);
		defensivePlayers.add(defensivePlayer10);
		defensivePlayers.add(defensivePlayer11);
		defensivePlayers.add(defensivePlayer12);
		defensivePlayers.add(defensivePlayer13);
		defensivePlayers.add(defensivePlayer14);
		
	
	
	
	}

	
	public static void main(String[] args) 
	{
		launch(args);
	}

	//This handles all events for when buttons are clicked
	private class MyEventHandler implements EventHandler<Event> 
	{
		
		public void handle(Event evt) 
		{
			//Switch that runs methods based upon button id
			switch (((Control) evt.getSource()).getId()) 
			{
			case "View Offense":
				showOffense();
				break;
			case "View Defense":
				showDefense();
				break;
			case "My Roster":
				showRoster();
				break;
			case "back to menu":
				showMenu();
				break;
			case "back to offense":
				showOffense();
				break;
			case "back to defense":
				showDefense();
				break;
			case "search":
				showSearchResults(searchField.getText());
				break;
			case "allOff":
				listOffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "QB":
				listOffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "RB":
				listOffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "WR":
				listOffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "alldef":
				listDeffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "DE":
				listDeffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "ILB":
				listDeffensivePlayers(((Control) evt.getSource()).getId());
				break;

			case "FS":
				listDeffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "OLB":
				listDeffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "MLB":
				listDeffensivePlayers(((Control) evt.getSource()).getId());
				break;

			case "LB":
				listDeffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "CB":
				listDeffensivePlayers(((Control) evt.getSource()).getId());
				break;
			case "HOME":
				listDeffensivePlayers(((Control) evt.getSource()).getId());
				break;
			}

			
			//Drafting offense
			if (((Control) evt.getSource()).getId().contains("draftOff")) 
			{
				String name;
				String players;
				 
				//If QB is clicked
				if (((Control) evt.getSource()).getId().contains("QB")) { 
																			

					name = ((Control) evt.getSource()).getId().substring(12);
					players = "QB";
				} 
				//If RB is clicked
				else if (((Control) evt.getSource()).getId().contains("RB")) 
				
				
				{ 

					name = ((Control) evt.getSource()).getId().substring(12);
					players = "RB";
				} 
				//If WR is clicked
				else if (((Control) evt.getSource()).getId().contains("WR")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "WR";
				} 
				
				//All home
				else if (((Control) evt.getSource()).getId().contains("HOME")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "HOME";

				} 
				//All offense QB is clicked
				else {
					name = ((Control) evt.getSource()).getId().substring(9); 

					players = "allOff";
				}
				
				
				//Iterate through all objects in arraylist
				for (Iterator<OffensivePlayer> it = offensivePlayers.iterator(); it.hasNext();) 
				{ 
					OffensivePlayer offensivePlayers = it.next();
					
					//If object name equals name of person drafted
					if (offensivePlayers.getName().equals(name)) 
					{ 
						//Create alert with celebration message
						Alert a = new Alert(AlertType.INFORMATION); 

						a.setTitle("Celebrator");
						a.setHeaderText("Now that is a great draft choice!");
						a.setResizable(true);
						String version = System.getProperty("java.version");
						String content = String.format(offensivePlayers.getName() + offensivePlayers.celebrate(),
								version);
						a.setContentText(content);
						a.showAndWait();

						//Add object to current roster
						roster.add(offensivePlayers); 
						//Remove object for offensive players 
						it.remove(); 

						if (searchField.getText().isEmpty()) 
						{
							 //List players passing selection
							listOffensivePlayers(players); 
						}
						
						
						else {
							showSearchResults(searchField.getText());
							searchField = new TextField();
						}

					}
				}

			}
			
			

			// drafting defense
			if (((Control) evt.getSource()).getId().contains("draftdef")) 
			{
				String name;
				String players;
				//If DE is clicked
				if (((Control) evt.getSource()).getId().contains("DE")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "DE";
				} 
				
				//If IBL is clicked
				else if (((Control) evt.getSource()).getId().contains("ILB")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(13);
					players = "ILB";
				} 
				//If DB is clicked
				else if (((Control) evt.getSource()).getId().contains("DB")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "DB";
				} 
				//If FS is clicked
				else if (((Control) evt.getSource()).getId().contains("FS")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "FS";
				} 
				//If OLB is clicked
				else if (((Control) evt.getSource()).getId().contains("OLB")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(13);
					players = "OLB";
				} 
				//If MLB is clicked
				else if (((Control) evt.getSource()).getId().contains("MLB")) 
				{ 

					name = ((Control) evt.getSource()).getId().substring(13);
					players = "MLB";
				} 
				
				//If DT is clicked
				else if (((Control) evt.getSource()).getId().contains("DT")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "DT";
				} 
				
				//If LB is clicked
				else if (((Control) evt.getSource()).getId().contains("LB")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "LB";
				} 
				
				//If CB is clicked
				else if (((Control) evt.getSource()).getId().contains("CB")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "HOME";
				} 
				
				
				//If CB is clicked
				else if (((Control) evt.getSource()).getId().contains("CB")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "CB";
				} 
				
				
				//If RB is clicked
				else if (((Control) evt.getSource()).getId().contains("HOME")) 
				{ 
					name = ((Control) evt.getSource()).getId().substring(12);
					players = "HOME";
				} 
				
				
				//All defensive clicked
				else 
				{
					name = ((Control) evt.getSource()).getId().substring(9); 

					players = "alldef";
				}

				
				//Iterate through all objects in arraylist
				for (Iterator<DefensivePlayer> it = defensivePlayers.iterator(); it.hasNext();) 
				{ 
					DefensivePlayer defensivePlayers = it.next();
					 //If object name equals name of person drafted
					if (defensivePlayers.getName().equals(name)) 
					{ 
						//Create alert with celebration message
						Alert a = new Alert(AlertType.INFORMATION); 
						
						a.setTitle("Celebrator");
						a.setHeaderText("That is a great pick!,");
						a.setResizable(true);
						String version = System.getProperty("java.version");
						String content = String.format(defensivePlayers.getName() + defensivePlayers.celebrate(),
								version);
						a.setContentText(content);
						a.showAndWait();
						
						//Add object to current roster
						roster.add(defensivePlayers); 
						//Remove object for offensive players 
						it.remove(); 
						if (searchField.getText().isEmpty()) 
						{
							listDeffensivePlayers(players); 
						} 
						
						
						else 
						{
							showSearchResults(searchField.getText());
							searchField = new TextField();
						}
					}
				}

			}
			
			

			// drafting defense
			if (((Control) evt.getSource()).getId().contains("cut_")) 
			{
				String name;
				name = ((Control) evt.getSource()).getId().substring(5);
				 //Iterate through all objects in arraylist
				for (Iterator<Object> it = roster.iterator(); it.hasNext();) 
				{ 
					Object roster = it.next();

					if (((NFLPlayer) roster).getName().equals(name)) 
					{
						//Create alert with celebration message
						Alert a = new Alert(AlertType.INFORMATION); 

						a.setTitle("Celebrator");
						a.setHeaderText("I'm sorry it didn't work out!");
						a.setResizable(true);
						String version = System.getProperty("java.version");
						String content = String.format("You just cut " + name, version);
						a.setContentText(content);
						a.showAndWait();

						if (((NFLPlayer) roster).getCategory().equals("off")) 
						{
							//Add object to current roster
							offensivePlayers.add((OffensivePlayer) roster); 
							//Remove object from roster
							it.remove(); 
							//List players on my roster
							showRoster(); 
						}
						
						

						if (((NFLPlayer) roster).getCategory().equals("def")) 
						{
							//Add object to current roster
							defensivePlayers.add((DefensivePlayer) roster);
							//Remove object from roster
							it.remove(); 
							//List players on my roster
							showRoster(); 
						}

					}
				}

			}

		}
	}

}