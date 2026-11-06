package com.mar.sdk.http;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.mar.sdk.log.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class MARHttp {
    private static final String TAG = "MARHttp";

    public static boolean onlineNet(String url) {
        HttpOnlineCheck onlineCheck = new HttpOnlineCheck();
        HttpCheckTask httpCheckTask = new HttpCheckTask(url, onlineCheck);
        return HttpThread.getInstance().addTask(httpCheckTask, 2600L, TimeUnit.MILLISECONDS);
    }

    public static long getNetworkTime() {
        HttpTimeImpl httpTime = new HttpTimeImpl();
        HttpTimeCallable httpTimeCallable = new HttpTimeCallable(httpTime);
        return HttpThread.getInstance().addTask(httpTimeCallable, "");
    }

    public static Bitmap loadBitmap(String url) {
        HttpImageLoad httpImageLoad = new HttpImageLoad();
        HttpImageCallable httpImageCallable = new HttpImageCallable(url, httpImageLoad);
        return HttpThread.getInstance().addTask(httpImageCallable, 3L);
    }

    public static String postRequest(String url, Map<String, String> params) {
        HttpPostRequest httpPostRequest = new HttpPostRequest();
        HttpCallable callable = new HttpCallable(url, params, httpPostRequest);
        return HttpThread.getInstance().addTask(callable);
    }

    public static String postRequest(String url, String header, Map<String, String> params) {
        if (TextUtils.isEmpty(header)) {
            Log.d(TAG, "header is null, request down");
            return null;
        }
        HttpPostRequest httpPostRequest = new HttpPostRequest();
        HttpCallable callable = new HttpCallable(url, header, params, httpPostRequest);
        return HttpThread.getInstance().addTask(callable);
    }

    public static void postRequest(String url, String header, Map<String, String> params, HttpListener listener) {
        if (listener == null) {
            Log.d(TAG, "http listener is null,request down");
            return;
        }
        if (TextUtils.isEmpty(header)) {
            Log.d(TAG, "header is null, request down");
            listener.onFail();
        } else {
            HttpPostRequest httpPostRequest = new HttpPostRequest();
            HttpTask task = new HttpTask(url, header, params, httpPostRequest, listener);
            HttpThread.getInstance().addTask(task);
        }
    }

    public static void postRequest(String url, Map<String, String> params, HttpListener listener) {
        if (listener == null) {
            Log.d(TAG, "http listener is null,request down");
            return;
        }
        HttpPostRequest httpPostRequest = new HttpPostRequest();
        HttpTask task = new HttpTask(url, params, httpPostRequest, listener);
        HttpThread.getInstance().addTask(task);
    }

    public static void postRequest(String url, String header, String json, HttpListener listener) {
        if (listener == null) {
            Log.d(TAG, "http listener is null,request down");
            return;
        }
        if (TextUtils.isEmpty(header)) {
            Log.d(TAG, "header is null, request down");
            listener.onFail();
        } else {
            HttpPostRequest httpPostRequest = new HttpPostRequest();
            HttpTask task = new HttpTask(url, header, json, httpPostRequest, listener);
            HttpThread.getInstance().addTask(task);
        }
    }

    public static String getRequest(String url, String header, Map<String, String> params) {
        if (TextUtils.isEmpty(header)) {
            Log.d(TAG, "header is null, request down");
            return null;
        }
        HttpGetRequest httpGetRequest = new HttpGetRequest();
        HttpCallable task = new HttpCallable(url, header, params, httpGetRequest);
        return HttpThread.getInstance().addTask(task);
    }

    public static String getRequest(String url, Map<String, String> params) {
        HttpGetRequest httpGetRequest = new HttpGetRequest();
        HttpCallable task = new HttpCallable(url, params, httpGetRequest);
        return HttpThread.getInstance().addTask(task);
    }

    public static void getRequest(String url, String header, Map<String, String> params, HttpListener listener) {
        if (listener == null) {
            Log.d(TAG, "http listener is null,request down");
            return;
        }
        if (TextUtils.isEmpty(header)) {
            Log.d(TAG, "header is null, request down");
            listener.onFail();
        } else {
            HttpGetRequest httpGetRequest = new HttpGetRequest();
            HttpTask task = new HttpTask(url, header, params, httpGetRequest, listener);
            HttpThread.getInstance().addTask(task);
        }
    }

    public static void getRequest(String url, Map<String, String> params, HttpListener listener) {
        if (listener == null) {
            Log.d(TAG, "http listener is null,request down");
            return;
        }
        HttpGetRequest httpGetRequest = new HttpGetRequest();
        HttpTask task = new HttpTask(url, params, httpGetRequest, listener);
        HttpThread.getInstance().addTask(task);
    }

    public static void download(final String url, final File file, final DownloadListener downloadListener) {
        if (downloadListener == null) {
            Log.d(TAG, "download fail, download listener is null ");
            return;
        }
        Download download = new Download();
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.setUrl(url);
        DownloadTask downloadTask = new DownloadTask(download, downloadInfo, new DownloadListener() { // from class: com.mar.sdk.http.MARHttp.1
            @Override // com.mar.sdk.http.DownloadListener
            public void onComplete(File file2) {
                downloadListener.onComplete(file2);
            }

            @Override // com.mar.sdk.http.DownloadListener
            public void onSuc(int size) {
                int end;
                downloadListener.onSuc(size);
                Log.d(MARHttp.TAG, "onSuc: file size:" + size);
                int coreCPU = Runtime.getRuntime().availableProcessors();
                Log.d(MARHttp.TAG, "onSuc: coreCPU size:" + coreCPU);
                int last = size % coreCPU;
                int step = (size - last) / coreCPU;
                Log.d(MARHttp.TAG, "onSuc: step size:" + step);
                List<Runnable> list = new ArrayList<>();
                for (int i = 0; i < coreCPU; i++) {
                    int start = i * step;
                    if (i != coreCPU - 1) {
                        end = ((i + 1) * step) - 1;
                    } else {
                        end = ((i + 1) * step) + last;
                    }
                    try {
                        String range = String.format(Locale.getDefault(), "bytes=%d-%d", Integer.valueOf(start), Integer.valueOf(end));
                        Download dl = new Download();
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
                        randomAccessFile.seek(start);
                        DownloadInfo info = new DownloadInfo();
                        info.setUrl(url);
                        info.setFile(file);
                        info.setRandomAccessFile(randomAccessFile);
                        info.setRange(range);
                        info.setStart(start);
                        info.setEnd(end);
                        info.setSize(size);
                        DownloadTask task = new DownloadTask(dl, info, downloadListener);
                        list.add(task);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                HttpThread.getInstance().addTask(list);
            }

            @Override // com.mar.sdk.http.DownloadListener
            public void onFail() {
                downloadListener.onFail();
            }
        });
        HttpThread.getInstance().addTask(downloadTask);
    }
}
