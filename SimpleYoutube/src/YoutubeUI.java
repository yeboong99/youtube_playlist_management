
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YoutubeUI extends Application {

	@Override
	public void start(Stage primaryStage) {

		ListView<YoutubeData> video_lv = new ListView<>();
		ObservableList<YoutubeData> video_ov = FXCollections.observableArrayList();
		video_lv.setItems(video_ov);

		TextField video_addTf = new TextField();
		video_addTf.setPromptText("Youtube Video Address");
		video_addTf.setPrefWidth(313);

		Button video_loadBt = new Button("Load");
		Button video_addBt = new Button("Add");
		Button video_removeBt = new Button("Remove");

		HBox video_hb = new HBox(video_addTf, video_loadBt, video_addBt, video_removeBt);
		video_hb.setSpacing(2);

		ListView<ChannelData> channel_lv = new ListView<ChannelData>();
		ObservableList<ChannelData> channel_ov = FXCollections.observableArrayList();
		channel_lv.setItems(channel_ov);

		TextField channel_addTf = new TextField();
		channel_addTf.setPromptText("Youtube Channel Address");
		channel_addTf.setPrefWidth(313);

		Button channel_loadBt = new Button("Load");
		Button channel_addBt = new Button("Add");
		Button channel_removeBt = new Button("Remove");

		HBox channel_hb = new HBox(channel_addTf, channel_loadBt, channel_addBt, channel_removeBt);
		channel_hb.setSpacing(2);

		video_loadBt.setOnAction(e -> {

		});

		video_addBt.setOnAction(e -> {

		});

		video_removeBt.setOnAction(e -> {

		});

		VBox vb = new VBox(video_hb, video_lv, channel_hb, channel_lv);
		vb.setSpacing(2);
		vb.setPadding(new Insets(2));

		Scene scene = new Scene(vb, 500, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Simple Youtube");
		primaryStage.setResizable(false);

		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/ytbicon.png")));

		Connection.Response response;
		try {
			response = Jsoup.connect("https://www.youtube.com/@ITSUB").method(Connection.Method.GET).execute();
			Document chanDoc = response.parse();
			
			System.out.println(chanDoc);
			Elements chanTitleEle = chanDoc.select("#text");
			
			System.out.println(chanTitleEle);
		} catch (Exception e1) {
			System.out.println("err");
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static String getChannelName(String channelUrl) {
		
		try {
			
			
			
			
		} catch (Exception e) {
			System.out.println("chantitle get connection error!");
			
		}
		
		return "";
	}
	
	

	class YoutubeData {

		private String title;
		private String url;
		
		public String getTitle() {
			return this.title;
		}
		
		public String getUrl() {
			return this.url;
		}
		
		public String toString() {
			return this.title;
		}
		
		
		
		
		
	}

	class ChannelData {
		private String title;
		private String url;
		
		public String getTitle() {
			return this.title;
		}
		
		public String getUrl() {
			return this.url;
		}
		
		public String toString() {
			return this.title;
		}
		
		
		
		
		
		
		
	}
}
