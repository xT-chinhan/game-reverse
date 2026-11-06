package com.anythink.core.common.j;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATGDPRAuthCallback;
import com.anythink.core.api.ATGDPRConsentDismissListener;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.NetTrafficeCallback;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.v;
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
        this.k.put(23, new c(23, 1782, 2));
        this.k.put(59, new c(59, 16831, 2));
        this.k.put(45, new c(45, 3183, 2));
        this.k.put(14, new c(14, 2710, 2));
        this.k.put(10, new c(10, 1985, 2));
        this.k.put(25, new c(25, 2312, 2));
        this.l = new HashMap();
        this.q = new ArrayList();
    }

    public final void a(ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
        t.b();
        a(aTGDPRConsentDismissListener, "is cn sdk!", -1);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.j.a$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ boolean b;
        final /* synthetic */ Activity c;
        final /* synthetic */ ATGDPRConsentDismissListener d;

        private AnonymousClass1(Context context, boolean z, Activity activity, ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
            this.a = context;
            this.b = z;
            this.c = activity;
            this.d = aTGDPRConsentDismissListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!TextUtils.isEmpty(b.a(this.a).b())) {
                if (this.b) {
                    d.a(this.a).a(this.c, new d.a() { // from class: com.anythink.core.common.j.a.1.1
                        @Override // com.anythink.core.common.j.d.a
                        public final void a(boolean z) {
                            a.b("(UMP Update)UMP onConsentSuccess isRealTimeDialogDismiss:".concat(String.valueOf(z)));
                        }

                        @Override // com.anythink.core.common.j.d.a
                        public final void a(String str) {
                            a.b("(UMP Update)UMP onConsentFail:".concat(String.valueOf(str)));
                        }
                    });
                }
                a.this.a(this.d, "", 101);
            } else {
                if (this.b) {
                    d.a(this.a).a(this.c, new d.a() { // from class: com.anythink.core.common.j.a.1.2
                        @Override // com.anythink.core.common.j.d.a
                        public final void a(boolean z) {
                            if (t.b().F()) {
                                a.b("UMP onConsentSuccess isRealTimeDialogDismiss:".concat(String.valueOf(z)));
                            }
                            if (z) {
                                a.c(AnonymousClass1.this.a);
                            }
                            a.this.a(AnonymousClass1.this.d, "", z ? 105 : 103);
                        }

                        @Override // com.anythink.core.common.j.d.a
                        public final void a(String str) {
                            if (t.b().F()) {
                                a.b("UMP onConsentFail:".concat(String.valueOf(str)));
                            }
                            if (d.a(AnonymousClass1.this.a).a()) {
                                a.b("UMP canRequestAd:true after onConsentFail");
                                a.this.a(AnonymousClass1.this.d, "", 106);
                            } else {
                                a.this.a(AnonymousClass1.this.a, AnonymousClass1.this.d);
                            }
                        }
                    });
                    if (d.a(this.a).a()) {
                        a.b("UMP canRequestAd:true");
                        a.this.a(this.d, "", 104);
                        return;
                    }
                    return;
                }
                a.this.a(this.a, this.d);
            }
        }
    }

    protected final void a(final Context context, final ATGDPRConsentDismissListener aTGDPRConsentDismissListener) {
        if (v.a(context).a() != 2) {
            a(aTGDPRConsentDismissListener, "", 101);
        } else {
            ATSDK.checkIsEuTraffic(context, new NetTrafficeCallback() { // from class: com.anythink.core.common.j.a.2
                @Override // com.anythink.core.api.NetTrafficeCallback
                public final void onResultCallback(boolean z) {
                    if (!z) {
                        a.this.a(aTGDPRConsentDismissListener, "", 102);
                    } else {
                        v.a(context).a(context, new ATGDPRAuthCallback() { // from class: com.anythink.core.common.j.a.2.1
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
                public final void onErrorCallback(String str) {
                    a.this.a(aTGDPRConsentDismissListener, str, -1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ATGDPRConsentDismissListener aTGDPRConsentDismissListener, final String str, final int i2) {
        t.b().b(new Runnable() { // from class: com.anythink.core.common.j.a.3
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
            } catch (Throwable th) {
                th.getMessage();
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
        b("initNetworkConsentMap others:" + (v.a(context).a() == 0));
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
        return v.a(context).c();
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
            v.a(context).a(1);
        } else {
            v.a(context).a(0);
        }
    }

    public final synchronized JSONObject a(JSONObject jSONObject) {
        if (!b() && TextUtils.isEmpty(this.n)) {
            this.n = b.a(t.b().g()).b();
            this.p = b.a(t.b().g()).d();
            this.o = b.a(t.b().g()).c();
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
}
