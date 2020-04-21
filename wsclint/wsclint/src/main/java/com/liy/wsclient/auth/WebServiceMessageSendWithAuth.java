package com.liy.wsclient.auth;

import org.springframework.ws.transport.http.HttpUrlConnectionMessageSender;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.HttpURLConnection;

public class WebServiceMessageSendWithAuth extends HttpUrlConnectionMessageSender {

    private static String usr;

    private static String passwd;

    public WebServiceMessageSendWithAuth() {}

    public WebServiceMessageSendWithAuth(String usr, String passwd) {
        this.usr = usr;
        this.passwd = passwd;
    }

    @Override
    protected void prepareConnection(HttpURLConnection connection) throws IOException {
        BASE64Encoder enc = new BASE64Encoder();
        String userpassword = usr+":"+passwd;
        String encodedAuthorization = enc.encode( userpassword.getBytes() );
        connection.setRequestProperty("Authorization", "Basic " + encodedAuthorization);
        super.prepareConnection(connection);
    }

}
