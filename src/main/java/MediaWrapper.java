
import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thayer
 */
public class MediaWrapper extends Application{
    static String applicationDirectory;

    public MediaWrapper(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File asdf = new File("./thayer");
        if(!asdf.exists())
            asdf.mkdir();
    }
    
    public String findDirectory(String targetDir){
        System.out.println("Finding application path:");
        String applicationDir = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        applicationDir = applicationDir.replaceAll("%20", " ");
        applicationDir = new File(applicationDir).getParent();
        System.out.println("\t1: checking " + applicationDir);
        if(new File(applicationDir + File.separator + targetDir).exists())
            return applicationDir;

        applicationDir = new File(applicationDir).getParent();
        System.out.println("\t2: checking " + applicationDir);
        if(new File(applicationDir + File.separator + targetDir).exists())
            return applicationDir;
        
        applicationDir = new File(applicationDir).getParent();
        System.out.println("\t3: checking " + applicationDir);
        if(new File(applicationDir + File.separator + targetDir).exists())
            return applicationDir;
        System.out.println("Defaulting to user.dir, checking:");
        if(new File(System.getProperty("user.dir") + File.separator + targetDir).exists())
            return System.getProperty("user.dir");
        return null;
    }
}
