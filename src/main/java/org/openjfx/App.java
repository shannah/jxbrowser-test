package org.openjfx;

import com.teamdev.jxbrowser.engine.EngineOptions;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.view.javafx.BrowserView;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();



        Engine engine = Engine.newInstance(EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("1BNDHFSC1G51VT575OLLTSXNWRDR9RINXKDHUIJMPVOZE52Y8TF2YDHI7RI4HLAL4LMR1P")
                .build()
        );



// Create a Browser instance.
        Browser browser = engine.newBrowser();

// Load the required web page.
        browser.navigation().loadUrl("https://html5test.com");

// Create and embed JavaFX BrowserView component to display web content.
        BrowserView view = BrowserView.newInstance(browser);

        Scene scene = new Scene(new BorderPane(view), 1280, 800);
        primaryStage.setTitle("JxBrowser JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();

// Shutdown Chromium and release allocated resources.
        primaryStage.setOnCloseRequest(event -> engine.close());
    }

    public static void main(String[] args) {
        launch();
    }

}