package com.byazt.pmn;

import android.app.Activity;
import com.byazt.gct.pk;
import com.byazt.ms.n;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface ITTInnerDownloadAdapter {
    void addAppDownloadListener(AppDownloadListener appDownloadListener);

    void addAppDownloadListener(AppDownloadListener appDownloadListener, boolean z);

    void addOnEventLogHandler(int i, n.InterfaceC0249n interfaceC0249n);

    void cancelDownload();

    void changeDownloadStatus(JSONObject jSONObject, boolean z);

    Map<String, Object> getParam();

    void handleAdClick(pk pkVar, boolean z);

    boolean hasShowDLFactorsCard();

    void init();

    boolean isAppMarketConvert();

    void onDestroy();

    void onPause();

    void onResume();

    void setActivity(Activity activity, boolean z);

    void setCheckCompliance(int i);

    void setCheckReplaceDialogWithLp(boolean z);

    void setClickViewIsButton(boolean z);

    void setOpenMarketInterceptorForDSP(boolean z);

    void setShowDLFactorsCard(boolean z);

    void setVideoDataListener(com.byazt.cs.n.InterfaceC0149n interfaceC0149n);
}
