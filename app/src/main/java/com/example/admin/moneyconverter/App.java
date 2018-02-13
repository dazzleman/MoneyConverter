package com.example.admin.moneyconverter;

import android.app.Application;
import android.net.http.HttpResponseCache;
import android.util.Log;

import com.example.admin.moneyconverter.data.db.DbProviderImpl;

import java.io.File;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initHttpCache();
        DbProviderImpl.initInstance(getApplicationContext());
    }

    private void initHttpCache() {
        try {
            File httpCacheDir = new File(getCacheDir(), "http");
            long httpCacheSize = 2 * 1024 * 1024; // 2 MiB
            HttpResponseCache.install(httpCacheDir, httpCacheSize);
        } catch (Exception httpResponseCacheNotAvailable) {
            Log.d("myLogs", "HTTP response cache is unavailable.");
        }
    }

    private void destroyHttpCache() {
        HttpResponseCache cache = HttpResponseCache.getInstalled();
        if (cache != null) {
            cache.flush();
        }
    }
}
