package Utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CropImg {
    public static void crop(Bounds bounds, ImageView image, File imageFile) {

        int width = (int) bounds.getWidth();
        int height = (int) bounds.getHeight();
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setViewport(new Rectangle2D(bounds.getMinX(), bounds.getMinY(), width, height));
        WritableImage wi = new WritableImage(width, height);
        image.snapshot(parameters, wi);
        BufferedImage bufImageARGB = SwingFXUtils.fromFXImage(wi, null);
        BufferedImage bufImageRGB = new BufferedImage(bufImageARGB.getWidth(), bufImageARGB.getHeight(), BufferedImage.OPAQUE);
        Graphics2D graphics = bufImageRGB.createGraphics();
        graphics.drawImage(bufImageARGB, 0, 0, null);

        try {

            ImageIO.write(bufImageRGB, "jpg", new File("/Img/"+imageFile.getName()));

            System.out.println("Image saved ");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        graphics.dispose();

    }

    public static File importImg() throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilterJpg = new FileChooser.ExtensionFilter("Jpg files(*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extensionFilterPng = new FileChooser.ExtensionFilter("Png files(*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extensionFilterJpg, extensionFilterPng);
        File file = fileChooser.showOpenDialog(null);
        return file;
        /*Stage stage = (Stage) image.getScene().getWindow();
        stage.sizeToScene();*/
    }
    public static void importImg(Image image,File imageFile) throws IOException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilterJpg = new FileChooser.ExtensionFilter("Jpg files(*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extensionFilterPng = new FileChooser.ExtensionFilter("Png files(*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extensionFilterJpg, extensionFilterPng);
        imageFile = fileChooser.showOpenDialog(null);
        BufferedImage bufferedImage = ImageIO.read(imageFile);
         image= SwingFXUtils.toFXImage(bufferedImage, null);
        return;
        /*Stage stage = (Stage) image.getScene().getWindow();
        stage.sizeToScene();*/
    }

    public static Image fileToImage(File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image imageImported = SwingFXUtils.toFXImage(bufferedImage, null);
            return imageImported;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void createFile(File originalFile, File destinantion) {
        try {
            BufferedImage original = ImageIO.read(originalFile);
            ImageIO.write(original, "jpg", destinantion);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println(exception.getCause());
        }
    }
}
