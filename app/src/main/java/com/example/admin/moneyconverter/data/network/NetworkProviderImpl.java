package com.example.admin.moneyconverter.data.network;

import com.example.admin.moneyconverter.model.ValCurs;
import com.example.admin.moneyconverter.utils.ParseUtils;
import com.example.admin.moneyconverter.utils.StringUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class NetworkProviderImpl implements NetworkProvider {

    private static final int TIMEOUT_VALUE = 2000;
    private static final String URL_CONNECTION = "http://www.cbr.ru/scripts/XML_daily.asp";

    @Override
    public ValCurs getXmlFromNetwork() {

        try {
            URL url = new URL(URL_CONNECTION);
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                try {
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(TIMEOUT_VALUE);
                    connection.setReadTimeout(TIMEOUT_VALUE);
                    connection.connect();
                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        InputStream is = new BufferedInputStream(connection.getInputStream());
                        String xmlResponse = StringUtils.readInputString(is);
                        if (xmlResponse.isEmpty()) {
                            return getXmlFromCache();
                        } else {
                            return ParseUtils.parseXML(xmlResponse);
                        }
                    } else {
                        return getXmlFromCache();
                    }
                } catch (IOException e) {
                    return getXmlFromCache();
                }
                finally {
                    if (connection != null) connection.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ValCurs getXmlFromCache() {
        try {
            URL url = new URL(URL_CONNECTION);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try {
                connection.addRequestProperty("Cache-Control", "only-if-cached");
                int maxStale = 60 * 60 * 24; // tolerate 1 day stale
                connection.addRequestProperty("Cache-Control", "max-stale=" + maxStale);
                connection.setUseCaches(true);
                InputStream is = connection.getInputStream();
                String xmlResponse = StringUtils.readInputString(is);
                ValCurs result = ParseUtils.parseXML(xmlResponse);
                if (result != null) result.setCache(true);
                return result;
            } finally {
                if (connection != null) connection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
