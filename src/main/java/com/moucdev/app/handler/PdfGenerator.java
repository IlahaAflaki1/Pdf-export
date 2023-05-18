package com.moucdev.app.handler;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.moucdev.app.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class PdfGenerator {

    private static final Logger logger = LoggerFactory.getLogger(PdfGenerator.class);

    public static ByteArrayInputStream generatePdfReport(List<User> users) {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();
            //Title elave et
            addTitleToDocument(document,"İşçinin ərizəsi və qüvvədə olan əmək müqaviləsi");



//            Burda men calisdim objectden for-a salim loop-la verim table-a


           //Table-da adlari qeyd edirem ve sayini qeyd edirem ki bu qeder coolumn var
//            PdfPTable table = new PdfPTable(2);
//
//            table.addCell("1. İşçinin soyadı, adı, atasının adı: Həsənova Hüsniyyə Faiq");
//            table.addCell("1. İşçinin soyadı, adı, atasının adı: Həsənova Hüsniyyə Faiq");
//            table.addCell("1. İşçinin soyadı, adı, atasının adı: Həsənova Hüsniyyə Faiq");
//            table.addCell("1. İşçinin soyadı, adı, atasının adı: Həsənova Hüsniyyə Faiq");
//            table.addCell("1. İşçinin soyadı, adı, atasının adı: Həsənova Hüsniyyə Faiq");
//            table.addCell("1. İşçinin soyadı, adı, atasının adı: Həsənova Hüsniyyə Faiq");

//            document.add(table);


            //close document
            document.close();

        } catch (DocumentException ex) {
            logger.error(ex.toString());
        }

        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    //Allows you to create a cell in the table
//    public static PdfPCell createCell(String cellName) {
//
//        PdfPCell cell = new PdfPCell(new Phrase(cellName));
//        cell.setPaddingLeft(4);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//        return cell;
//    }

    //Allows you to add a title to the pdf document
    public static void addTitleToDocument(Document document, String titleDocument) throws DocumentException {

          String FontBold = "src/main/java/com/moucdev/app/assets/Calibri-Bold.TTF";
          String FontLight = "src/main/java/com/moucdev/app/assets/Calibri-Light.TTF";

        BaseFont bf = null;
        BaseFont bf1 = null;

        try {
            bf = BaseFont.createFont(FontBold, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            bf1 = BaseFont.createFont(FontLight, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Font font = new Font(bf,14);
        Font font1 = new Font(bf1,14);

//        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN,  14, BaseColor.BLACK);
        Paragraph para_header = new Paragraph("İşə qəbul\n\n\n", font);
        Paragraph para_main = new Paragraph(titleDocument , font1);
        Paragraph para_main2 = new Paragraph("\n\n\nƏ M R   E D İ R Ə M", font);
        Paragraph para_source = new Paragraph(
                "\n1. İşçinin soyadı, adı, atasının adı: Həsənova Hüsniyyə Faiq" +
                "\n2. Struktur bölmə: İctimaiyyətlə əlaqələr və protokol departamenti" +
                        "\n3. Alt struktur bölmə: " +
                        "\n4. Alt bölmə: " +
                        "\n5. Vəzifəsi: Aparıcı mütəxəssis" +
                        "\n6. İşə qəbul tarixi: 01-10-2021" +
                        "\n7. Sınaq müddəti: null ay" +
                        "\n8. İş rejimi: Gündəlik" +
                        "\n9. İş müddəti: Tam" +
                        "\n10. Əmək haqqı: 1633.0 AZN vergilər və digər ödənişlər daxil olmaqla)" +
                        "\n    10.1    Dərəcəsi: 8" +
                        "\n    10.2    Ştat üzrə əsas əmək haqqı: 1633.0 AZN" +
                        "\n    10.3    Əmək şəraitinə görə əlavə: 0.0 AZN" +
                        "\n    10.4    Digər fərdi əlavə: 0.0" +
                        "\n11. Maliyyə və İnsan resursları departamentinə tapşırılsın ki, əmrdən irəli gələn zəruri məsələlərin həllini təmin etsinlər." +
                        "\n12. Əmr imzalandığı gündən qüvvəyə minir. ", font1);

        Paragraph para_footer = new Paragraph("\n\nBaş direktor              Taleh Ziyadov", font);


        para_header.setAlignment(Element.ALIGN_RIGHT);
        para_main.setAlignment(Element.ALIGN_CENTER);
        para_main2.setAlignment(Element.ALIGN_CENTER);
        para_footer.setAlignment(Element.ALIGN_CENTER);



        document.add(para_header);
        document.add(para_main);
        document.add(para_main2);
        document.add(para_source);
        document.add(para_footer);
        document.add(Chunk.NEWLINE);
    }
}