package com.byazt.eld;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.bek.DownloadModel;
import com.byazt.fi.BaseConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 5})
public class uc {
    public final ConcurrentHashMap<String, String> hw;
    public final ConcurrentHashMap<String, String> pr;

    @com.byazt.vzx.pr(pr = {0, 1, 128, 129})
    public static class pr {
        public static uc pr = new uc();
    }

    public static uc pr() {
        return pr.pr;
    }

    private uc() {
        this.pr = new ConcurrentHashMap<>();
        this.hw = new ConcurrentHashMap<>();
    }

    public void pr(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !this.hw.containsKey(str2)) {
            this.hw.put(str2, str);
        }
    }

    public String pr(String str) {
        if (TextUtils.isEmpty(str) || this.hw.isEmpty() || !this.hw.containsKey(str)) {
            return null;
        }
        String strHn = hn(str);
        if (this.pr.containsValue(strHn)) {
            for (Map.Entry<String, String> entry : this.pr.entrySet()) {
                if (TextUtils.equals(entry.getValue(), strHn)) {
                    String str2 = this.hw.get(entry.getKey());
                    this.hw.put(str, str2);
                    if (!this.pr.containsKey(str)) {
                        this.pr.put(str, strHn);
                    }
                    return str2;
                }
            }
        }
        return this.hw.get(str);
    }

    public String pr(DownloadModel downloadModel) {
        String strHn = hn(downloadModel.getDownloadUrl());
        if (strHn == null || TextUtils.isEmpty(strHn)) {
            return null;
        }
        String strC = com.byazt.tuy.uc.c(strHn + downloadModel.getPackageName());
        this.hw.put(downloadModel.getDownloadUrl(), strC);
        return strC;
    }

    private String hn(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.equals(BaseConstants.SCHEME_HTTPS, scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.pr.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e) {
            return null;
        }
    }

    public void hw(String str) {
        Iterator<Map.Entry<String, String>> it = this.hw.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.pr.remove(next.getKey());
            }
        }
    }
}
