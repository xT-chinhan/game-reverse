package com.tapsdk.tapad.internal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import com.tapsdk.tapad.model.entities.ImageInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private WeakHashMap<Context, Dialog> a;
    HashMap<String, String> b;

    class a implements com.tapsdk.tapad.internal.download.n.a.f {
        final /* synthetic */ Activity a;
        final /* synthetic */ AdInfo b;

        a(Activity activity, AdInfo adInfo) {
            this.a = activity;
            this.b = adInfo;
        }

        @Override // com.tapsdk.tapad.internal.download.n.a.f
        public void a() {
            c.this.a();
            c.this.b.put("__REMINDER_ACTIVATION_ACTION__", "3");
            com.tapsdk.tapad.internal.tracker.c.a().a(this.b.reminderActivationMonitorUrls, (Map<String, String>) null, (List<DynamicHeader>) null, c.this.b);
        }

        @Override // com.tapsdk.tapad.internal.download.n.a.f
        public void b() {
            com.tapsdk.tapad.internal.utils.b.b(this.a, this.b.appInfo.packageName);
            c.this.b.put("__REMINDER_ACTIVATION_ACTION__", "2");
            com.tapsdk.tapad.internal.tracker.c.a().a(this.b.reminderActivationMonitorUrls, (Map<String, String>) null, (List<DynamicHeader>) null, c.this.b);
        }
    }

    static class b {
        static c a = new c(null);

        b() {
        }
    }

    private c() {
        this.a = new WeakHashMap<>();
        this.b = new HashMap<>();
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    private String a(AppInfo appInfo) {
        String str = appInfo.packageName;
        String str2 = appInfo.apkMd5;
        String str3 = appInfo.appName;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str3.length() == 0) {
            return null;
        }
        return str + "_" + str2 + "_" + str3;
    }

    public static c b() {
        return b.a;
    }

    public synchronized void a() {
        this.a.clear();
    }

    public synchronized void a(Activity activity, AdInfo adInfo) {
        a(activity, adInfo, false);
    }

    public synchronized void a(Activity activity, AdInfo adInfo, boolean z) {
        AppInfo appInfo;
        Window window;
        String str;
        if (com.tapsdk.tapad.internal.utils.a.b(activity)) {
            return;
        }
        if (adInfo != null && (appInfo = adInfo.appInfo) != null && appInfo.packageName != null && adInfo.getShowApkOpenDialog() == 1) {
            if (adInfo.btnInteractionInfo.interactionType != 1) {
                return;
            }
            if (com.tapsdk.tapad.internal.utils.b.a(activity, adInfo.appInfo.packageName)) {
                if ((this.a.containsKey(activity) ? this.a.get(activity) : null) != null) {
                    return;
                }
                String str2 = "";
                ImageInfo imageInfo = adInfo.appInfo.appIconImage;
                if (imageInfo != null && (str = imageInfo.imageUrl) != null) {
                    str2 = str;
                }
                com.tapsdk.tapad.internal.download.n.a aVar = new com.tapsdk.tapad.internal.download.n.a(activity, new com.tapsdk.tapad.internal.download.n.a.e.C0615a().a(str2).b(adInfo.appInfo.appName).a(), new a(activity, adInfo));
                a();
                this.a.put(activity, aVar);
                if (z && (window = aVar.getWindow()) != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.dimAmount = 0.0f;
                    window.setAttributes(attributes);
                }
                this.b.put("__REMINDER_ACTIVATION_ACTION__", "1");
                com.tapsdk.tapad.internal.tracker.c.a().a(adInfo.reminderActivationMonitorUrls, (Map<String, String>) null, (List<DynamicHeader>) null, this.b);
                aVar.show();
            }
        }
    }
}
