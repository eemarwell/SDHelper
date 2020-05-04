package com.marwell.sdhelper.utils;

import com.marwell.sdhelper.controller.ConfigPaneController;
import org.codehaus.jettison.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo Marwell
 */
public class VerificaChatTimer {
    public void executarTimer (){
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
            ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
                try {
                    verificandoChat();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 5, 5, TimeUnit.SECONDS);
    }

    public void verificandoChat () throws IOException {
        String line;
        String ENCODING = "UTF-8";
        String user = "tomaze01@heiway.net";
        String password = "@M545663ip";
        String passUser = user+":"+password;
        String requestType = "GET";
        String encoder = Base64.getEncoder().encodeToString(passUser.getBytes(ENCODING));

        URL url = new URL ("https://nextgen.service-now.com/" +
                "api/now/v1/table/" +
                "chat_queue_entry?sysparm_query=" +
                "opened_by.active!%3Dfalse^state%3D2^queue%3D7643954fdb2d4010d1132ded0b961980" +
                "&sysparm_first_row=1&sysparm_display_value=true&sysparm_exclude_reference_link=true" +
                "&sysparm_fields=assigned_to,work_start,opened_by,wait_time,document_id,sys_id"
        );

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestType);
        connection.setDoOutput(true);
        connection.setRequestProperty  ("Authorization", "Basic " + encoder);

        try {
            int status = connection.getResponseCode();
            if (status == 200) {
                InputStream content = (InputStream)connection.getInputStream();
                BufferedReader in = new BufferedReader (new InputStreamReader(content));
                while ((line = in.readLine()) != null) {
                    JSONObject json = new JSONObject(line); // Convert text to object
                    System.out.println(json.toString(4));
                }
                content.close();
            } else if (status == 404) {
                System.out.println("Erro 404");
            } else {
                System.out.println("Erro: "+status);
                InputStream error = (InputStream)connection.getErrorStream();
                BufferedReader in = new BufferedReader (new InputStreamReader (error));
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                error.close();
            }

        } catch(Exception ex) {
            Logger.getLogger(ConfigPaneController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro ali");
        }
    }
}
