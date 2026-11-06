package com.tapsdk.tapad.lottie.network;

import android.content.Context;
import android.util.Pair;
import com.tapsdk.tapad.lottie.L;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.LottieCompositionFactory;
import com.tapsdk.tapad.lottie.LottieResult;
import com.tapsdk.tapad.lottie.LottieTask;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkFetcher {
    private final Context appContext;
    private final NetworkCache networkCache;
    private final String url;

    private NetworkFetcher(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.url = str;
        this.networkCache = new NetworkCache(applicationContext, str);
    }

    public static LottieTask<LottieComposition> fetch(Context context, String str) {
        return new NetworkFetcher(context, str).fetch();
    }

    private LottieComposition fetchFromCache() {
        Pair<FileExtension, InputStream> pairFetch = this.networkCache.fetch();
        if (pairFetch == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) pairFetch.first;
        InputStream inputStream = (InputStream) pairFetch.second;
        LottieResult<LottieComposition> lottieResultFromZipStreamSync = fileExtension == FileExtension.Zip ? LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), this.url) : LottieCompositionFactory.fromJsonInputStreamSync(inputStream, this.url);
        if (lottieResultFromZipStreamSync.getValue() != null) {
            return lottieResultFromZipStreamSync.getValue();
        }
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork() {
        try {
            return fetchFromNetworkInternal();
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:22:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:23:0x00bb  */
    private LottieResult fetchFromNetworkInternal() throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResultFromZipStreamSync;
        boolean z;
        L.debug("Fetching " + this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setRequestMethod(TapHttp.METHOD_GET);
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            int iHashCode = contentType.hashCode();
            if (iHashCode == -1248325150) {
                if (contentType.equals("application/zip")) {
                    L.debug("Handling zip response.");
                    fileExtension = FileExtension.Zip;
                    lottieResultFromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension))), this.url);
                }
                if (lottieResultFromZipStreamSync.getValue() != null) {
                    this.networkCache.renameTempFile(fileExtension);
                }
                StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                if (lottieResultFromZipStreamSync.getValue() != null) {
                    z = true;
                } else {
                    z = false;
                }
                L.debug(sb.append(z).toString());
                return lottieResultFromZipStreamSync;
            }
            if (iHashCode == -43840953) {
                contentType.equals("application/json");
            }
            L.debug("Received json response.");
            fileExtension = FileExtension.Json;
            lottieResultFromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
            if (lottieResultFromZipStreamSync.getValue() != null) {
                this.networkCache.renameTempFile(fileExtension);
            }
            StringBuilder sb2 = new StringBuilder("Completed fetch from network. Success: ");
            if (lottieResultFromZipStreamSync.getValue() != null) {
                z = true;
            } else {
                z = false;
            }
            L.debug(sb2.append(z).toString());
            return lottieResultFromZipStreamSync;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb3 = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new LottieResult((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb3)));
            }
            sb3.append(line).append('\n');
        }
    }

    public static LottieResult<LottieComposition> fetchSync(Context context, String str) {
        return new NetworkFetcher(context, str).fetchSync();
    }

    private LottieTask<LottieComposition> fetch() {
        return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.tapsdk.tapad.lottie.network.NetworkFetcher.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return NetworkFetcher.this.fetchSync();
            }
        });
    }

    public LottieResult<LottieComposition> fetchSync() {
        LottieComposition lottieCompositionFetchFromCache = fetchFromCache();
        if (lottieCompositionFetchFromCache != null) {
            return new LottieResult<>(lottieCompositionFetchFromCache);
        }
        L.debug("Animation for " + this.url + " not found in cache. Fetching from network.");
        return fetchFromNetwork();
    }
}
