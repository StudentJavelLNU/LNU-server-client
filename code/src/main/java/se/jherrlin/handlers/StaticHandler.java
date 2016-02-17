package se.jherrlin.handlers;

import se.jherrlin.model.Header;
import se.jherrlin.model.Response;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;


public class StaticHandler {

    public static void findStaticFile(String filenameIn, Response responseIn){

        Response response = responseIn;

        try{
            File file = new File(StaticHandler.class.getResource(filenameIn).getPath());

            if (file.isFile()){
                Path path = file.toPath();
                response.setBody(Files.readAllBytes(path));

                // Get file format
                String[] format = file.getName().split("\\.");
                if (format[1].equals("css")){
                    response.appendHeader(Header.response_200_ok);
                    response.appendHeader(Header.header_content_type_textcss);
                }
                else if (format[1].equals("jpg") || format[1].equals("png") || format[1].equals("jpeg")){
                    response.appendHeader(Header.response_200_ok);
                    response.appendHeader(Header.header_content_type_image);
                }
                else {
                    response.appendHeader(Header.response_200_ok);
                    response.appendHeader(Header.header_content_type_texthtml);
                }
                return;
            }

            if (file.isDirectory()){
                try{
                    File html = new File(file.getPath()+"/index.html");
                    Path htmlPath = html.toPath();
                    response.appendHeader(Header.response_200_ok);
                    response.appendHeader(Header.header_content_type_texthtml);
                    response.setBody(Files.readAllBytes(htmlPath));
                    return;
                }
                catch (Exception e){
                    e.printStackTrace();
                    response.setHeader(Header.response_404_notfound);
                }

                try{
                    File htm = new File(file.getPath()+"/index.htm");
                    Path htmPath = htm.toPath();
                    response.appendHeader(Header.response_200_ok);
                    response.appendHeader(Header.header_content_type_texthtml);
                    response.setBody(Files.readAllBytes(htmPath));
                    return;
                }
                catch (Exception e){
                    e.printStackTrace();
                    response.setHeader(Header.response_404_notfound);
                }
            }

            response.setHeader(Header.response_404_notfound);
            return;
        }
        catch (Exception e){
            e.printStackTrace();
            response.setHeader(Header.response_404_notfound);
            return;
        }
    }
}
