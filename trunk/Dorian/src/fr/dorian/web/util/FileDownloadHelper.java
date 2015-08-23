package fr.dorian.web.util;

import java.io.InputStream;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/** @author Dimitri Dean DARSEYNE (D3), 
 * published by Short-Circuit under Creative Commons (CC) Licensing: 
 * Authorship/Paternity, NO Commercial Use, NO Derivative
 * please check for more informations:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/
 *
 * auteur Dimitri Dean DARSEYNE (D3),
 * publié par Short-Circuit sous license Creative Commons (CC):
 * Paternité, PAS d'Utilisation Commerciale, pas de Dérivés/Modifications
 * Pour plus d'informations, se rendre sur:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/fr/ 
 * 
 * @since Short-Circuit 1999
 */

public class FileDownloadHelper
{
    //No constructor, only static access
    //public FileDownloadHelper() {}

    public static void returnFile(String filePath, String fileName, String contentType)
    {
        FacesContext ctx                    = FacesContext.getCurrentInstance();

        if (!ctx.getResponseComplete())
        {
            HttpServletResponse response    = (HttpServletResponse) ctx.getExternalContext().getResponse();

            response.setContentType(contentType);
            response.setHeader("Content-Disposition","attachment;filename=\"" + fileName + "\"");

            try
            {
                ServletOutputStream out     = response.getOutputStream();
                byte[] filesContentArray    = IOHelper.getBytes(filePath + fileName);

                //System.out.println("FileDownloadHelper: return File: file size: " + filesContentArray.length);

                out.write(filesContentArray);
                out.flush();
                ctx.responseComplete();
            }
            catch (Exception e) {System.out.println("FileDownloadHelper: returnFile: " + e.toString()); /*e.printStackTrace();*/}
        }
    }
    
    public static void returnFile(InputStream stream, String contentType, String attachmentName)
    {
        FacesContext ctx                    = FacesContext.getCurrentInstance();

        if (!ctx.getResponseComplete())
        {
            HttpServletResponse response    = (HttpServletResponse) ctx.getExternalContext().getResponse();

            response.setContentType(contentType);
            response.setHeader("Content-Disposition","attachment;filename=\"" + attachmentName + "\"");

            ctx.getResponseWriter();    
                
            try
            {
                ServletOutputStream out     = response.getOutputStream();                              
                
                byte[] buffer = new byte[1024];
                  
                while(stream.available()>0)
                {
                    stream.read(buffer);
                    out.write(buffer);
                }
                    
                out.flush();
                out.close();
                stream.close();     
            }
            catch (Exception e) {System.out.println("FileDownloadHelper: returnFile: " + e.toString()); /*e.printStackTrace();*/}
                        
            ctx.responseComplete();                
          }
    }



}
