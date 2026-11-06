package com.anythink.core.common.i;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATGDPRAuthCallback;
import com.anythink.core.api.ATGDPRConsentDismissListener;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.NetTrafficeCallback;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.u;
import com.anythink.core.common.i.d.AnonymousClass3;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String i = "anythink_ump";
    private static volatile a j;
    private Map<Integer, c> k;
    private Map<Integer, c> l;
    private List<Integer> q;
    final int a = -1;
    final int b = 100;
    final int c = 101;
    final int d = 102;
    final int e = 103;
    final int f = 104;
    final int g = 105;
    final int h = 106;
    private String n = "";
    private String o = "";
    private String p = "";
    private boolean m = false;

    public static a a() {
        if (j == null) {
            synchronized (a.class) {
                if (j == null) {
                    j = new a();
                }
            }
        }
        return j;
    }

    private a() {
        HashMap map = new HashMap();
        this.k = map;
        map.put(2, new c(2, 755, 1));
        this.k.put(33, new c(33, 755, 1));
        this.k.put(6, new c(6, 867, 1));
        this.k.put(3, new c(3, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_FRAME_META_CALLBACK, 1));
        this.k.put(37, new c(37, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_ASYNC, 1));
        this.k.put(13, new c(13, 667, 1));
        this.k.put(36, new c(36, 31, 1));
        this.k.put(58, new c(58, 512, 1));
        this.k.put(75, new c(75, 793, 1));
        this.k.put(1, new c(1, 89, 2));
        this.k.put(12, new c(12, 3234, 2));
        this.k.put(5, new c(5, 1301, 2));
        this.k.put(9, new c(9, 2898, 2));
        this.k.put(11, new c(11, 2878, 2));
        this.k.put(59, new c(59, 16831, 2));
        this.k.put(45, new c(45, 3183, 2));
        this.k.put(25, new c(25, 2312, 2));
        this.l = new HashMap();
        this.q = new ArrayList();
    }

    public final void a(ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
        s.b();
        a(aTGDPRConsentDismissListener, "is cn sdk!", -1);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.i.a$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ ATGDPRConsentDismissListener b;
        final /* synthetic */ Activity c;
        final /* synthetic */ boolean d;
        final /* synthetic */ String e;

        private AnonymousClass1(Context context, ATGDPRConsentDismissListener aTGDPRConsentDismissListener, Activity activity, boolean z, String str) {
            this.a = context;
            this.b = aTGDPRConsentDismissListener;
            this.c = activity;
            this.d = z;
            this.e = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int iE = u.a(this.a).e();
            if (iE == -100 || iE == 1) {
                u.a(this.a).a(new u.a() { // from class: com.anythink.core.common.i.a.1.1
                    @Override // com.anythink.core.common.d.u.a
                    public final void a(boolean z, boolean z2) {
                        a.b("checkIsEuTraffic:onResultCallback:" + z + ":" + z2);
                        if (!z2) {
                            a.a(a.this, AnonymousClass1.this.a, AnonymousClass1.this.c, AnonymousClass1.this.d, AnonymousClass1.this.b);
                        } else if (!z) {
                            a.this.a(AnonymousClass1.this.b, "", 102);
                        } else {
                            a.a(a.this, AnonymousClass1.this.a, AnonymousClass1.this.c, AnonymousClass1.this.d, AnonymousClass1.this.b);
                        }
                    }

                    @Override // com.anythink.core.api.NetTrafficeCallback
                    public final void onResultCallback(boolean z) {
                        a.b("checkIsEuTraffic:onResultCallback:".concat(String.valueOf(z)));
                    }

                    @Override // com.anythink.core.api.NetTrafficeCallback
                    public final void onErrorCallback(String str) {
                        a.b("checkIsEuTraffic:onErrorCallback:".concat(String.valueOf(str)));
                        a.a(a.this, AnonymousClass1.this.a, AnonymousClass1.this.c, AnonymousClass1.this.d, AnonymousClass1.this.b);
                    }
                }, this.e);
            } else {
                a.a(a.this, this.a, this.c, this.d, this.b);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.i.a$2, reason: invalid class name */
    final class AnonymousClass2 implements d.a {
        final /* synthetic */ Context a;
        final /* synthetic */ ATGDPRConsentDismissListener b;

        AnonymousClass2(Context context, ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
            this.a = context;
            this.b = aTGDPRConsentDismissListener;
        }

        @Override // com.anythink.core.common.i.d.a
        public final void a(boolean z) {
            if (s.b().G()) {
                a.b("UMP onConsentSuccess isRealTimeDialogDismiss:".concat(String.valueOf(z)));
            }
            if (z) {
                a.c(this.a);
            }
            a.this.a(this.b, "", z ? 105 : 103);
        }

        @Override // com.anythink.core.common.i.d.a
        public final void a(String str) {
            if (s.b().G()) {
                a.b("UMP onConsentFail:".concat(String.valueOf(str)));
            }
            if (d.a(this.a).b()) {
                a.b("UMP canRequestAd:true after onConsentFail");
                a.this.a(this.b, "", 106);
            } else {
                a.this.a(this.b, str, -1);
            }
        }
    }

    private void a(Context context, Activity activity, boolean z, ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
        if (z) {
            d dVarA = d.a(context);
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(context, aTGDPRConsentDismissListener);
            try {
                if (dVarA.a()) {
                    s.b();
                    s.b(dVarA.new AnonymousClass3(activity, anonymousClass2));
                    return;
                } else {
                    anonymousClass2.a("isPrivacyOptionsRequired is not.");
                    return;
                }
            } catch (Throwable th) {
                anonymousClass2.a("secondAdsConsent:" + th.getMessage());
                return;
            }
        }
        a(aTGDPRConsentDismissListener, "ump sdk not exist", -1);
    }

    public final void b(ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
        s.b();
        a(aTGDPRConsentDismissListener, "is cn sdk!", -1);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.i.a$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ ATGDPRConsentDismissListener b;
        final /* synthetic */ Activity c;
        final /* synthetic */ boolean d;
        final /* synthetic */ String e;

        private AnonymousClass3(Context context, ATGDPRConsentDismissListener aTGDPRConsentDismissListener, Activity activity, boolean z, String str) {
            this.a = context;
            this.b = aTGDPRConsentDismissListener;
            this.c = activity;
            this.d = z;
            this.e = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int iE = u.a(this.a).e();
            if (iE == -100 || iE == 1) {
                u.a(this.a).a(new u.a() { // from class: com.anythink.core.common.i.a.3.1
                    @Override // com.anythink.core.common.d.u.a
                    public final void a(boolean z, boolean z2) {
                        a.b("checkIsEuTraffic:onResultCallback:" + z + ":" + z2);
                        if (!z2) {
                            a.a(a.this, AnonymousClass3.this.a, AnonymousClass3.this.c, AnonymousClass3.this.d, AnonymousClass3.this.b, AnonymousClass3.this.e);
                        } else if (!z) {
                            a.this.a(AnonymousClass3.this.b, "", 102);
                        } else {
                            a.a(a.this, AnonymousClass3.this.a, AnonymousClass3.this.c, AnonymousClass3.this.d, AnonymousClass3.this.b, AnonymousClass3.this.e);
                        }
                    }

                    @Override // com.anythink.core.api.NetTrafficeCallback
                    public final void onResultCallback(boolean z) {
                        a.b("checkIsEuTraffic:onResultCallback:".concat(String.valueOf(z)));
                    }

                    @Override // com.anythink.core.api.NetTrafficeCallback
                    public final void onErrorCallback(String str) {
                        a.b("checkIsEuTraffic:onErrorCallback:".concat(String.valueOf(str)));
                        a.a(a.this, AnonymousClass3.this.a, AnonymousClass3.this.c, AnonymousClass3.this.d, AnonymousClass3.this.b, AnonymousClass3.this.e);
                    }
                }, this.e);
            } else {
                a.a(a.this, this.a, this.c, this.d, this.b, this.e);
            }
        }
    }

    private void a(Context context, Activity activity, boolean z, ATGDPRConsentDismissListener aTGDPRConsentDismissListener, String str) {
        if (!TextUtils.isEmpty(b.a(context).b())) {
            if (z) {
                d.a(context).a(activity, new AnonymousClass4());
            }
            a(aTGDPRConsentDismissListener, "", 101);
        } else {
            if (z) {
                d.a(context).a(activity, new AnonymousClass5(context, aTGDPRConsentDismissListener, str));
                if (d.a(context).b()) {
                    b("UMP canRequestAd:true");
                    a(aTGDPRConsentDismissListener, "", 104);
                    return;
                }
                return;
            }
            a(context, aTGDPRConsentDismissListener, str);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.i.a$4, reason: invalid class name */
    final class AnonymousClass4 implements d.a {
        AnonymousClass4() {
        }

        @Override // com.anythink.core.common.i.d.a
        public final void a(boolean z) {
            a.b("(UMP Update)UMP onConsentSuccess isRealTimeDialogDismiss:".concat(String.valueOf(z)));
        }

        @Override // com.anythink.core.common.i.d.a
        public final void a(String str) {
            a.b("(UMP Update)UMP onConsentFail:".concat(String.valueOf(str)));
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.i.a$5, reason: invalid class name */
    final class AnonymousClass5 implements d.a {
        final /* synthetic */ Context a;
        final /* synthetic */ ATGDPRConsentDismissListener b;
        final /* synthetic */ String c;

        AnonymousClass5(Context context, ATGDPRConsentDismissListener aTGDPRConsentDismissListener, String str) {
            this.a = context;
            this.b = aTGDPRConsentDismissListener;
            this.c = str;
        }

        @Override // com.anythink.core.common.i.d.a
        public final void a(boolean z) {
            if (s.b().G()) {
                a.b("UMP onConsentSuccess isRealTimeDialogDismiss:".concat(String.valueOf(z)));
            }
            if (z) {
                a.c(this.a);
            }
            a.this.a(this.b, "", z ? 105 : 103);
        }

        @Override // com.anythink.core.common.i.d.a
        public final void a(String str) {
            if (s.b().G()) {
                a.b("UMP onConsentFail:".concat(String.valueOf(str)));
            }
            if (d.a(this.a).b()) {
                a.b("UMP canRequestAd:true after onConsentFail");
                a.this.a(this.b, "", 106);
            } else {
                a.this.a(this.a, this.b, this.c);
            }
        }
    }

    protected final void a(final Context context, final ATGDPRConsentDismissListener aTGDPRConsentDismissListener, String str) {
        if (u.a(context).a() != 2) {
            a(aTGDPRConsentDismissListener, "", 101);
        } else {
            ATSDK.checkIsEuTraffic(context, new NetTrafficeCallback() { // from class: com.anythink.core.common.i.a.6
                @Override // com.anythink.core.api.NetTrafficeCallback
                public final void onResultCallback(boolean z) {
                    if (!z) {
                        a.this.a(aTGDPRConsentDismissListener, "", 102);
                    } else {
                        u.a(context).a(context, new ATGDPRAuthCallback() { // from class: com.anythink.core.common.i.a.6.1
                            @Override // com.anythink.core.api.ATGDPRAuthCallback
                            public final void onAuthResult(int i2) {
                                a.this.a(aTGDPRConsentDismissListener, "", 100);
                            }

                            @Override // com.anythink.core.api.ATGDPRAuthCallback
                            public final void onPageLoadFail() {
                                a.this.a(aTGDPRConsentDismissListener, "showUploadDataNotifyDialog onPageLoadFail", -1);
                            }
                        });
                    }
                }

                @Override // com.anythink.core.api.NetTrafficeCallback
                public final void onErrorCallback(String str2) {
                    a.this.a(aTGDPRConsentDismissListener, str2, -1);
                }
            }, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ATGDPRConsentDismissListener aTGDPRConsentDismissListener, final String str, final int i2) {
        s.b();
        s.b(new Runnable() { // from class: com.anythink.core.common.i.a.7
            @Override // java.lang.Runnable
            public final void run() {
                if (aTGDPRConsentDismissListener == null || a.this.q.contains(Integer.valueOf(aTGDPRConsentDismissListener.hashCode()))) {
                    return;
                }
                a.this.q.add(Integer.valueOf(aTGDPRConsentDismissListener.hashCode()));
                aTGDPRConsentDismissListener.onDismiss(new ATGDPRConsentDismissListener.ConsentDismissInfo(str, i2));
            }
        });
    }

    private synchronized void b(Context context) {
        boolean zA;
        if (TextUtils.isEmpty(this.n)) {
            this.n = b.a(context).b();
            this.p = b.a(context).d();
            this.o = b.a(context).c();
        }
        b("IABTCF_TCString:" + this.n);
        b("IABTCF_VendorConsents:" + this.p);
        b("IABTCF_AddtlConsent:" + this.o);
        if (TextUtils.isEmpty(this.n)) {
            this.m = true;
            return;
        }
        this.m = false;
        this.l.clear();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.o)) {
            try {
                String[] strArrSplit = this.o.split("~");
                if (strArrSplit.length >= 2) {
                    for (String str : strArrSplit[1].split("\\.")) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        for (Map.Entry<Integer, c> entry : this.k.entrySet()) {
            Integer key = entry.getKey();
            c value = entry.getValue();
            int iC = value.c();
            if (iC == 1) {
                zA = a(this.p, value.b());
            } else {
                if (iC == 2) {
                    zA = arrayList.size() == 0 ? false : arrayList.contains(Integer.valueOf(value.b()));
                }
                this.l.put(key, value);
                b("initNetworkConsentMap " + value.a() + ":" + value.d());
            }
            value.a(zA);
            this.l.put(key, value);
            b("initNetworkConsentMap " + value.a() + ":" + value.d());
        }
        c(context);
        b("initNetworkConsentMap others:" + (u.a(context).a() == 0));
        this.m = true;
    }

    public final synchronized boolean b() {
        return this.m;
    }

    public final synchronized boolean a(Context context, int i2) {
        c cVar;
        if (this.l.size() > 0 && (cVar = this.l.get(Integer.valueOf(i2))) != null) {
            return cVar.d();
        }
        return u.a(context).c();
    }

    private static boolean a(String str, int i2) {
        if (!TextUtils.isEmpty(str) && i2 > 0) {
            try {
                if (str.length() >= i2 && str.charAt(i2 - 1) == '1') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean a(List<Integer> list, int i2) {
        if (list.size() == 0) {
            return false;
        }
        return list.contains(Integer.valueOf(i2));
    }

    public final String c() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context) {
        String strA = b.a(context).a();
        if (!TextUtils.isEmpty(strA) && !strA.contains("1")) {
            u.a(context).a(1);
        } else {
            u.a(context).a(0);
        }
    }

    public final synchronized JSONObject a(JSONObject jSONObject) {
        if (!b() && TextUtils.isEmpty(this.n)) {
            this.n = b.a(s.b().g()).b();
            this.p = b.a(s.b().g()).d();
            this.o = b.a(s.b().g()).c();
        }
        try {
            if (!TextUtils.isEmpty(this.n)) {
                jSONObject.put("tc_string", this.n);
            }
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("addtl_consent", this.o);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.d(i, str);
        }
    }

    static /* synthetic */ void a(a aVar, Context context, Activity activity, boolean z, ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
        if (z) {
            d dVarA = d.a(context);
            AnonymousClass2 anonymousClass2 = aVar.new AnonymousClass2(context, aTGDPRConsentDismissListener);
            try {
                if (dVarA.a()) {
                    s.b();
                    s.b(dVarA.new AnonymousClass3(activity, anonymousClass2));
                    return;
                } else {
                    anonymousClass2.a("isPrivacyOptionsRequired is not.");
                    return;
                }
            } catch (Throwable th) {
                anonymousClass2.a("secondAdsConsent:" + th.getMessage());
                return;
            }
        }
        aVar.a(aTGDPRConsentDismissListener, "ump sdk not exist", -1);
    }

    static /* synthetic */ void a(a aVar, Context context, Activity activity, boolean z, ATGDPRConsentDismissListener aTGDPRConsentDismissListener, String str) {
        if (!TextUtils.isEmpty(b.a(context).b())) {
            if (z) {
                d.a(context).a(activity, aVar.new AnonymousClass4());
            }
            aVar.a(aTGDPRConsentDismissListener, "", 101);
        } else {
            if (z) {
                d.a(context).a(activity, aVar.new AnonymousClass5(context, aTGDPRConsentDismissListener, str));
                if (d.a(context).b()) {
                    b("UMP canRequestAd:true");
                    aVar.a(aTGDPRConsentDismissListener, "", 104);
                    return;
                }
                return;
            }
            aVar.a(context, aTGDPRConsentDismissListener, str);
        }
    }
}
