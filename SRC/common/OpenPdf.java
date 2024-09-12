/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.IOException;
import dao.InventoryUtils;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;
import javax.swing.JOptionPane;


/**
 *
 * @author Prajw
 */
public class OpenPdf {
    public static void openById(String id) {

        try {
            File pdfFile = new File(InventoryUtils.billPath + id + ".pdf");

            if (pdfFile.exists()) {
                // Use Desktop API for platform-independent opening
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    // Fallback (might not work on all systems)
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + pdfFile.getAbsolutePath());
                }
            } else {
                JOptionPane.showMessageDialog(null, "File is not Exists");
            }
        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }



 




}

