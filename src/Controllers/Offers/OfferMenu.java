package Controllers.Offers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import Modules.Extern;
import Modules.Offre;
import Services.OffreServices;
import Services.UserServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OfferMenu implements Initializable {

    private List<Offre> offres;
    private OffreServices offreServices;

    @FXML
    private Button excelBtn;

    @FXML
    private ListView<AnchorPane> OfferListView;

    public OfferMenu() {
        try {
            offreServices = OffreServices.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        offres = offreServices.getList();
        OfferListView = new ListView<>();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            for(int i=0;i<offres.size();i++)
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/Views/Templates/OfferCell.fxml"));
                AnchorPane pane = loader.load();
                OfferCell offerCell = loader.getController();
                offerCell.setData(offres.get(i));
                OfferListView.getItems().add(pane);
            }


        }

        catch(Exception ex){

        }
    }

    @FXML
    void exportExcel(ActionEvent event) throws IOException {

        String[] columns = { "title", "description", "category",
                "provider" };

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Offer");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with contacts data
        int rowNum = 1;

        for (Offre offre : offres) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(offre.getTitleOffer());
            row.createCell(1).setCellValue(offre.getDescOffer());
            row.createCell(2).setCellValue(offre.getCategory().name());

            try {
                UserServices userService = UserServices.getInstance();
                Extern extern = (Extern) userService.retrive(offre.getOfferProvider());
                row.createCell(3).setCellValue(extern.getEntrepriseName());


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }




        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("Offre.xlsx");
        workbook.write(fileOut);
        fileOut.close();
    }
}
