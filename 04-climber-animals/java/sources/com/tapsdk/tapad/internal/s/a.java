package com.tapsdk.tapad.internal.s;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.h;
import com.tapsdk.tapad.internal.tracker.c;
import com.tapsdk.tapad.internal.ui.views.web.ADWebView;
import com.tapsdk.tapad.internal.ui.views.web.BrowserActivity;
import com.tapsdk.tapad.internal.ui.views.web.WebViewDialogFragment;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import com.tapsdk.tapad.model.entities.InteractionInfo;
import com.tapsdk.tapad.model.entities.WxMiniProgramInfo;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static WeakReference<DownloadPresenter> a;

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.s.a$a, reason: collision with other inner class name */
    static class C0632a implements ADWebView.e {
        final /* synthetic */ Activity a;
        final /* synthetic */ String b;
        final /* synthetic */ WebViewDialogFragment c;

        C0632a(Activity activity, String str, WebViewDialogFragment webViewDialogFragment) {
            this.a = activity;
            this.b = str;
            this.c = webViewDialogFragment;
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void a() {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void a(String str) {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void b(String str) {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void c(String str) {
            try {
                a.b(this.a, this.b);
                this.c.dismissAllowingStateLoss();
            } catch (Throwable unused) {
            }
        }
    }

    static class b implements ADWebView.e {
        final /* synthetic */ InteractionInfo a;
        final /* synthetic */ Activity b;
        final /* synthetic */ WebViewDialogFragment c;
        final /* synthetic */ AdInfo d;
        final /* synthetic */ List e;

        b(InteractionInfo interactionInfo, Activity activity, WebViewDialogFragment webViewDialogFragment, AdInfo adInfo, List list) {
            this.a = interactionInfo;
            this.b = activity;
            this.c = webViewDialogFragment;
            this.d = adInfo;
            this.e = list;
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void a() {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void a(String str) {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void b(String str) {
            if (TextUtils.isEmpty(str) || !str.startsWith(WebViewDialogFragment.WEIXIN) || this.d == null) {
                return;
            }
            c.a().a(this.e, (Map<String, String>) null, this.d.getOpenDeepLinkMonitorHeaderListWrapper());
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.ADWebView.e
        public void c(String str) {
            InteractionInfo interactionInfo = this.a;
            if (interactionInfo.landingType == 2 && TextUtils.equals(interactionInfo.landingUrl, str)) {
                a.b(this.b, this.a);
                this.c.dismissAllowingStateLoss();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void a(Activity activity, InteractionInfo interactionInfo, AdInfo adInfo) {
        String str = interactionInfo.deepLinkUrl;
        a(activity, adInfo, interactionInfo, (DownloadPresenter) null);
        if (str == null || str.length() <= 0) {
            return;
        }
        com.tapsdk.tapad.internal.tracker.experiment.entities.a<Boolean, ? extends Exception> aVarB = b(activity, str);
        if (aVarB.a.booleanValue()) {
            c.a().a(adInfo.dpSuccessMonitorUrlsList, (Map<String, String>) null, (List<DynamicHeader>) null);
        } else {
            c.a().a(adInfo.dpFailedMonitorUrlsList, (Map<String, String>) null, (List<DynamicHeader>) null, (Map<String, String>) null);
        }
    }

    private static boolean a(Activity activity, AdInfo adInfo, InteractionInfo interactionInfo, DownloadPresenter downloadPresenter) {
        int i = interactionInfo.landingType;
        String str = interactionInfo.landingUrl;
        boolean z = ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.i, Integer.class, 1)).intValue() == 1 || ((Integer) com.tapsdk.tapad.internal.j.a.b().a(Constants.f.j, Integer.class, 0)).intValue() == 1;
        if (i != 1 || TextUtils.isEmpty(str) || !z) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", adInfo);
        bundle.putString("landing_url", str);
        Intent intent = new Intent(activity, (Class<?>) BrowserActivity.class);
        intent.putExtras(bundle);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        if (adInfo.getInnerWebViewIsSelf() == 1) {
            a = new WeakReference<>(downloadPresenter);
        }
        activity.startActivity(intent);
        return true;
    }

    public static boolean a(Activity activity, InteractionInfo interactionInfo, List<String> list, boolean z, AdInfo adInfo) {
        if (activity == null || activity.isDestroyed() || interactionInfo == null || TextUtils.isEmpty(interactionInfo.landingUrl)) {
            return false;
        }
        try {
            WebViewDialogFragment webViewDialogFragmentNewInstance = WebViewDialogFragment.newInstance("", interactionInfo.landingUrl, z, adInfo != null ? adInfo.getLandingHeaderListWrapper() : null, adInfo);
            webViewDialogFragmentNewInstance.setWebViewClientDelegate(new b(interactionInfo, activity, webViewDialogFragmentNewInstance, adInfo, list));
            webViewDialogFragmentNewInstance.show(activity.getFragmentManager(), WebViewDialogFragment.TAG);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Activity activity, String str, AdInfo adInfo) {
        int defaultOpenWebMode = adInfo != null ? adInfo.getDefaultOpenWebMode() : 0;
        if (activity != null && !activity.isDestroyed() && str != null && str.length() != 0) {
            try {
                if (defaultOpenWebMode != 0) {
                    b(activity, str);
                    return true;
                }
                WebViewDialogFragment webViewDialogFragmentNewInstance = WebViewDialogFragment.newInstance("", str, false, adInfo);
                webViewDialogFragmentNewInstance.setWebViewClientDelegate(new C0632a(activity, str, webViewDialogFragmentNewInstance));
                webViewDialogFragmentNewInstance.show(activity.getFragmentManager(), WebViewDialogFragment.TAG);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static synchronized boolean a(Activity activity, boolean z, AdInfo adInfo, DownloadPresenter downloadPresenter) {
        a = null;
        InteractionInfo interactionInfo = z ? adInfo.viewInteractionInfo : adInfo.btnInteractionInfo;
        if (interactionInfo == null) {
            return false;
        }
        int i = interactionInfo.interactionType;
        if (i == 2) {
            a(activity, interactionInfo, adInfo);
            return true;
        }
        if (i == 3) {
            if (a(activity, adInfo, interactionInfo, downloadPresenter)) {
                return true;
            }
            int i2 = interactionInfo.landingType;
            if (i2 == 1 || i2 == 2) {
                TapADLogger.i("wechat scheme url launch miniprogram");
                if (!a(activity, interactionInfo, adInfo.openDeeplinkMonitorUrls, interactionInfo.landingType == 2, adInfo)) {
                    TapADLogger.i(" launch miniprogram is failed , go to H5");
                    b(activity, interactionInfo);
                }
            } else {
                b(activity, interactionInfo);
            }
            return true;
        }
        if (i != 4) {
            return false;
        }
        if (interactionInfo.isValidWxOpenSdk() && TextUtils.equals(activity.getApplicationContext().getPackageName(), interactionInfo.wxMiniProgramInfo.d)) {
            WxMiniProgramInfo wxMiniProgramInfo = interactionInfo.wxMiniProgramInfo;
            if (h.a(activity, wxMiniProgramInfo.c, wxMiniProgramInfo.a, wxMiniProgramInfo.b, 0)) {
                TapADLogger.i("wechat opensdk launch miniprogram");
                c.a().a(adInfo.openDeeplinkMonitorUrls, (Map<String, String>) null, adInfo.getOpenDeepLinkMonitorHeaderListWrapper());
                return true;
            }
        }
        int i3 = interactionInfo.landingType;
        if (i3 == 1 || i3 == 2) {
            TapADLogger.i("wechat scheme url launch miniprogram");
            if (!a(activity, interactionInfo, adInfo.openDeeplinkMonitorUrls, interactionInfo.landingType == 2, adInfo)) {
                TapADLogger.i(" launch miniprogram is failed , go to H5");
                b(activity, interactionInfo);
            }
        } else {
            b(activity, interactionInfo);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.tapsdk.tapad.internal.tracker.experiment.entities.a<Boolean, ? extends Exception> b(Activity activity, String str) {
        if (str == null || str.length() == 0) {
            return new com.tapsdk.tapad.internal.tracker.experiment.entities.a<>(Boolean.FALSE, new IllegalArgumentException("link is empty"));
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            Context baseContext = activity.getBaseContext();
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            baseContext.startActivity(intent);
            return new com.tapsdk.tapad.internal.tracker.experiment.entities.a<>(Boolean.TRUE, null);
        } catch (Exception e) {
            return new com.tapsdk.tapad.internal.tracker.experiment.entities.a<>(Boolean.FALSE, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, InteractionInfo interactionInfo) {
        b(activity, interactionInfo.landingUrl);
    }
}
