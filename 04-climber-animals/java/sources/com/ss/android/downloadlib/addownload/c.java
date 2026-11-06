package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.dlopt.common.a.a;
import com.ss.android.download.api.download.DownloadModel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f4361ms;
    private final ConcurrentHashMap<String, String> xr;

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static c f4362ms = new c();
    }

    public static c ms() {
        return ms.f4362ms;
    }

    private c() {
        this.f4361ms = new ConcurrentHashMap<>();
        this.xr = new ConcurrentHashMap<>();
    }

    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.xr.containsKey(str2)) {
            return;
        }
        this.xr.put(str2, str);
    }

    public String ms(String str) {
        if (TextUtils.isEmpty(str) || this.xr.isEmpty() || !this.xr.containsKey(str)) {
            return null;
        }
        String strAh = ah(str);
        if (this.f4361ms.containsValue(strAh)) {
            for (Map.Entry<String, String> entry : this.f4361ms.entrySet()) {
                if (TextUtils.equals(entry.getValue(), strAh)) {
                    String str2 = this.xr.get(entry.getKey());
                    this.xr.put(str, str2);
                    if (!this.f4361ms.containsKey(str)) {
                        this.f4361ms.put(str, strAh);
                    }
                    return str2;
                }
            }
        }
        return this.xr.get(str);
    }

    public String ms(DownloadModel downloadModel) {
        String strAh = ah(downloadModel.getDownloadUrl());
        if (strAh == null || TextUtils.isEmpty(strAh)) {
            return null;
        }
        String strKa = com.ss.android.socialbase.downloader.ny.c.ka(strAh + downloadModel.getPackageName());
        this.xr.put(downloadModel.getDownloadUrl(), strKa);
        return strKa;
    }

    private String ah(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(a.h)) {
                return null;
            }
            this.f4361ms.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
            return null;
        }
    }

    public void xr(String str) {
        Iterator<Map.Entry<String, String>> it = this.xr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.f4361ms.remove(next.getKey());
            }
        }
    }
}
