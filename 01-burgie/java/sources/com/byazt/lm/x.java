package com.byazt.lm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadModel;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface x {
    boolean hn();

    fw hw();

    void hw(String str);

    boolean hw(DownloadModel downloadModel, DownloadInfo downloadInfo);

    AlertDialog pr(Activity activity, boolean z, pr prVar);

    String pr(boolean z);

    JSONObject pr();

    void pr(int i, String str, Map<String, Object> map, c cVar);

    void pr(Activity activity, String[] strArr, uc ucVar);

    void pr(zo zoVar, boolean z);

    void pr(String str, byte[] bArr, String str2, c cVar);

    void pr(WeakReference<Context> weakReference, boolean z, pr prVar);

    void pr(JSONObject jSONObject, String str);

    boolean pr(Context context, String str);

    boolean pr(DownloadModel downloadModel);

    boolean pr(DownloadModel downloadModel, DownloadInfo downloadInfo);

    boolean pr(String str);
}
