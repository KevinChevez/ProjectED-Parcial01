
import java.io.File;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.HiloVideo;
import modelo.Video;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin Chevez pc
 */
public class MainTest extends Application{
    public static Group root = new Group();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String path = "src/videos/2.mp4";
        //String path = "src\\videos\\1.mp4";
//        Media media = new Media(new File(path).toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        System.out.println(mediaPlayer.getStopTime());
////        mediaPlayer.setOnRepeat(new Runnable() {
////            @Override
////            public void run() {
////                System.out.println("Repite");
////                
//////                try{
//////                    Thread.sleep(10);
//////                }catch(InterruptedException e){
//////                    System.out.println(e.getMessage());
//////                }
////            }
////        });
//        
//        //mediaPlayer.setCycleCount(1);
//        MediaView mediaView = new MediaView(mediaPlayer);
//        DoubleProperty mvWidth = mediaView.fitWidthProperty();
//        DoubleProperty mvHeight = mediaView.fitHeightProperty();
//        mvWidth.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
//        mvHeight.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
//        
//        mediaView.setPreserveRatio(true);
//        mediaPlayer.setAutoPlay(true);
        
        Video video1 = new Video(path);
        MediaView mediaView = video1.mostrarVideo();        
        
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Prueba video");
        primaryStage.show();
    }
    
}
