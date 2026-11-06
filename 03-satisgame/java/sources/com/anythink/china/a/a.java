package com.anythink.china.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.l;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.t;
import com.anythink.core.common.i;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.b.e;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private static final long b = 1800000;
    private static volatile a c;
    private volatile boolean f;
    private volatile ScheduledFuture<?> g;
    private C0007a i;
    private final Object e = new Object();
    private final AtomicLong h = new AtomicLong(0);
    private final d d = new b();

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public final void a(com.anythink.core.e.b bVar) {
        if (bVar == null || bVar.J()) {
            return;
        }
        if (!bVar.aA()) {
            this.h.set(0L);
            b();
            return;
        }
        boolean z = true;
        if (!this.f) {
            synchronized (this.e) {
                this.f = true;
            }
        }
        int iAB = bVar.aB();
        synchronized (this.e) {
            long j = this.h.get();
            this.h.set(iAB);
            if (j != 0) {
                z = false;
            }
        }
        if (z && this.f) {
            b();
            com.anythink.core.common.u.b.c.a().g(new com.anythink.core.common.u.b.d(e.C, new Runnable() { // from class: com.anythink.china.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a aVar = a.this;
                    s.b();
                    a.a(aVar, s.y());
                }
            }));
        }
    }

    private void a(boolean z) {
        synchronized (this.e) {
            byte b2 = 0;
            try {
                if (!z) {
                    if (this.i != null) {
                        s.b().b(this.i);
                    }
                    this.i = new C0007a(this, b2);
                    s.b().a(this.i);
                    i.a();
                    f.a(com.anythink.core.e.b.a.z, com.anythink.core.common.res.image.c.a, "The application is in the background and cannot be obtained", i.m(), "", "", "", (ATAdRequest) null);
                    return;
                }
                if (this.i != null) {
                    s.b().b(this.i);
                    this.i = null;
                }
                d dVar = this.d;
                Context contextG = s.b().g();
                com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
                s sVarB = s.b();
                long j = c.a;
                int iAu = bVarA.au();
                boolean zAn = bVarA.an();
                if (sVarB.c(com.anythink.core.common.l.f.bH) || iAu != 2 || bVarA.J()) {
                    j &= -257;
                }
                if (sVarB.c("sensor_deny")) {
                    j = j & (-65) & (-129);
                }
                if (sVarB.c("bld_serial")) {
                    j &= -3;
                }
                if (sVarB.c("android_id")) {
                    j &= -5;
                }
                if (sVarB.c("imei")) {
                    j &= -2;
                }
                if (sVarB.c("s_c")) {
                    j &= -9;
                }
                if (sVarB.c("screen")) {
                    j &= -17;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bI)) {
                    j &= -513;
                }
                if (sVarB.c("battery")) {
                    j &= -1025;
                }
                if (ATSDKGlobalSetting.isDenyApi_getRunningAppProcesses()) {
                    j &= -2049;
                }
                if (sVarB.c("cpu")) {
                    j &= -4097;
                }
                if (sVarB.c("u_a")) {
                    j &= -8193;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bJ)) {
                    j &= -16385;
                }
                if (sVarB.c("d_s")) {
                    j &= -32769;
                }
                if (sVarB.c("ua")) {
                    j &= -65537;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bK)) {
                    j &= -131073;
                }
                if (sVarB.c("oaid")) {
                    j &= -262145;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bL)) {
                    j &= -524289;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bM)) {
                    j &= -1048577;
                }
                if (sVarB.c("package_name")) {
                    j &= -2097153;
                }
                if (sVarB.c("app_vn")) {
                    j &= -8388609;
                }
                if (sVarB.c("app_vc")) {
                    j &= -4194305;
                }
                if (sVarB.c("t_mem")) {
                    j &= -16777217;
                }
                if (sVarB.c("network_type")) {
                    j &= -33554433;
                }
                if (sVarB.c("wifi_name")) {
                    j &= -67108865;
                }
                if (sVarB.c("ip_v4") || sVarB.c("ip_v6") || sVarB.c("mac")) {
                    j &= -134217729;
                }
                if (!zAn) {
                    j &= -268435457;
                }
                byte[] bArrA = dVar.a(contextG, j);
                if (bArrA == null || bArrA.length == 0) {
                    return;
                }
                new com.anythink.core.common.l.d(new t(bArrA)).a(0, (com.anythink.core.common.l.s) new AnonymousClass2());
                if (this.f) {
                    long j2 = this.h.get();
                    if (j2 <= 0) {
                        j2 = 1800000;
                    }
                    b();
                    this.g = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(e.D, new AnonymousClass3()), j2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.a.a$2, reason: invalid class name */
    final class AnonymousClass2 extends com.anythink.core.common.l.c {
        @Override // com.anythink.core.common.l.s
        public final void onLoadError(int i, String str, AdError adError) {
        }

        AnonymousClass2() {
        }

        @Override // com.anythink.core.common.l.s
        public final void onLoadFinish(int i, Object obj) {
            if (obj instanceof JSONObject) {
                a.a((JSONObject) obj);
            }
        }
    }

    private static void b(JSONObject jSONObject) {
        try {
            com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
            if (bVarA != null && !bVarA.J() && jSONObject != null) {
                String strE = bVarA.e();
                if (TextUtils.isEmpty(strE)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(strE);
                JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("tags");
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        arrayList.add(jSONArrayOptJSONArray.optJSONObject(i).optString(TapEventParamConstants.PARAM_NAME));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                List<com.anythink.core.common.h.s.a> listA = com.anythink.core.common.h.s.a(jSONObject).a();
                if (listA != null && !listA.isEmpty()) {
                    for (com.anythink.core.common.h.s.a aVar : listA) {
                        if (!arrayList.contains(aVar.a())) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(TapEventParamConstants.PARAM_NAME, aVar.a());
                            arrayList2.add(jSONObject3);
                        }
                    }
                }
                if (arrayList2.isEmpty()) {
                    return;
                }
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    jSONArrayOptJSONArray.put((JSONObject) it.next());
                }
                jSONObject2.put("tags", jSONArrayOptJSONArray);
                bVarA.a(jSONObject2.toString());
                s.b().a(bVarA);
            }
        } catch (Throwable unused) {
        }
    }

    private void b() {
        com.anythink.core.common.u.b.c.a();
        com.anythink.core.common.u.b.c.a(this.g);
        this.g = null;
    }

    private void c() {
        if (this.f) {
            long j = this.h.get();
            if (j <= 0) {
                j = 1800000;
            }
            b();
            this.g = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(e.D, new AnonymousClass3()), j);
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.a.a$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            s.b();
            a.a(aVar, s.y());
        }
    }

    private static long d() {
        com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
        s sVarB = s.b();
        long j = c.a;
        int iAu = bVarA.au();
        boolean zAn = bVarA.an();
        if (sVarB.c(com.anythink.core.common.l.f.bH) || iAu != 2 || bVarA.J()) {
            j &= -257;
        }
        if (sVarB.c("sensor_deny")) {
            j = j & (-65) & (-129);
        }
        if (sVarB.c("bld_serial")) {
            j &= -3;
        }
        if (sVarB.c("android_id")) {
            j &= -5;
        }
        if (sVarB.c("imei")) {
            j &= -2;
        }
        if (sVarB.c("s_c")) {
            j &= -9;
        }
        if (sVarB.c("screen")) {
            j &= -17;
        }
        if (sVarB.c(com.anythink.core.common.l.f.bI)) {
            j &= -513;
        }
        if (sVarB.c("battery")) {
            j &= -1025;
        }
        if (ATSDKGlobalSetting.isDenyApi_getRunningAppProcesses()) {
            j &= -2049;
        }
        if (sVarB.c("cpu")) {
            j &= -4097;
        }
        if (sVarB.c("u_a")) {
            j &= -8193;
        }
        if (sVarB.c(com.anythink.core.common.l.f.bJ)) {
            j &= -16385;
        }
        if (sVarB.c("d_s")) {
            j &= -32769;
        }
        if (sVarB.c("ua")) {
            j &= -65537;
        }
        if (sVarB.c(com.anythink.core.common.l.f.bK)) {
            j &= -131073;
        }
        if (sVarB.c("oaid")) {
            j &= -262145;
        }
        if (sVarB.c(com.anythink.core.common.l.f.bL)) {
            j &= -524289;
        }
        if (sVarB.c(com.anythink.core.common.l.f.bM)) {
            j &= -1048577;
        }
        if (sVarB.c("package_name")) {
            j &= -2097153;
        }
        if (sVarB.c("app_vn")) {
            j &= -8388609;
        }
        if (sVarB.c("app_vc")) {
            j &= -4194305;
        }
        if (sVarB.c("t_mem")) {
            j &= -16777217;
        }
        if (sVarB.c("network_type")) {
            j &= -33554433;
        }
        if (sVarB.c("wifi_name")) {
            j &= -67108865;
        }
        if (sVarB.c("ip_v4") || sVarB.c("ip_v6") || sVarB.c("mac")) {
            j &= -134217729;
        }
        return !zAn ? j & (-268435457) : j;
    }

    /* JADX INFO: renamed from: com.anythink.china.a.a$a, reason: collision with other inner class name */
    private class C0007a implements l {
        private C0007a() {
        }

        /* synthetic */ C0007a(a aVar, byte b) {
            this();
        }

        @Override // com.anythink.core.common.d.l
        public final void a(boolean z) {
            if (z) {
                a.a(a.this, true);
            }
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        synchronized (aVar.e) {
            byte b2 = 0;
            try {
                if (!z) {
                    if (aVar.i != null) {
                        s.b().b(aVar.i);
                    }
                    aVar.i = new C0007a(aVar, b2);
                    s.b().a(aVar.i);
                    i.a();
                    f.a(com.anythink.core.e.b.a.z, com.anythink.core.common.res.image.c.a, "The application is in the background and cannot be obtained", i.m(), "", "", "", (ATAdRequest) null);
                    return;
                }
                if (aVar.i != null) {
                    s.b().b(aVar.i);
                    aVar.i = null;
                }
                d dVar = aVar.d;
                Context contextG = s.b().g();
                com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
                s sVarB = s.b();
                long j = c.a;
                int iAu = bVarA.au();
                boolean zAn = bVarA.an();
                if (sVarB.c(com.anythink.core.common.l.f.bH) || iAu != 2 || bVarA.J()) {
                    j &= -257;
                }
                if (sVarB.c("sensor_deny")) {
                    j = j & (-65) & (-129);
                }
                if (sVarB.c("bld_serial")) {
                    j &= -3;
                }
                if (sVarB.c("android_id")) {
                    j &= -5;
                }
                if (sVarB.c("imei")) {
                    j &= -2;
                }
                if (sVarB.c("s_c")) {
                    j &= -9;
                }
                if (sVarB.c("screen")) {
                    j &= -17;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bI)) {
                    j &= -513;
                }
                if (sVarB.c("battery")) {
                    j &= -1025;
                }
                if (ATSDKGlobalSetting.isDenyApi_getRunningAppProcesses()) {
                    j &= -2049;
                }
                if (sVarB.c("cpu")) {
                    j &= -4097;
                }
                if (sVarB.c("u_a")) {
                    j &= -8193;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bJ)) {
                    j &= -16385;
                }
                if (sVarB.c("d_s")) {
                    j &= -32769;
                }
                if (sVarB.c("ua")) {
                    j &= -65537;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bK)) {
                    j &= -131073;
                }
                if (sVarB.c("oaid")) {
                    j &= -262145;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bL)) {
                    j &= -524289;
                }
                if (sVarB.c(com.anythink.core.common.l.f.bM)) {
                    j &= -1048577;
                }
                if (sVarB.c("package_name")) {
                    j &= -2097153;
                }
                if (sVarB.c("app_vn")) {
                    j &= -8388609;
                }
                if (sVarB.c("app_vc")) {
                    j &= -4194305;
                }
                if (sVarB.c("t_mem")) {
                    j &= -16777217;
                }
                if (sVarB.c("network_type")) {
                    j &= -33554433;
                }
                if (sVarB.c("wifi_name")) {
                    j &= -67108865;
                }
                if (sVarB.c("ip_v4") || sVarB.c("ip_v6") || sVarB.c("mac")) {
                    j &= -134217729;
                }
                if (!zAn) {
                    j &= -268435457;
                }
                byte[] bArrA = dVar.a(contextG, j);
                if (bArrA == null || bArrA.length == 0) {
                    return;
                }
                new com.anythink.core.common.l.d(new t(bArrA)).a(0, (com.anythink.core.common.l.s) aVar.new AnonymousClass2());
                if (aVar.f) {
                    long j2 = aVar.h.get();
                    if (j2 <= 0) {
                        j2 = 1800000;
                    }
                    aVar.b();
                    aVar.g = com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(e.D, aVar.new AnonymousClass3()), j2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static /* synthetic */ void a(JSONObject jSONObject) {
        try {
            com.anythink.core.e.b bVarA = com.anythink.core.e.d.a();
            if (bVarA != null && !bVarA.J() && jSONObject != null) {
                String strE = bVarA.e();
                if (TextUtils.isEmpty(strE)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(strE);
                JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("tags");
                ArrayList arrayList = new ArrayList();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        arrayList.add(jSONArrayOptJSONArray.optJSONObject(i).optString(TapEventParamConstants.PARAM_NAME));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                List<com.anythink.core.common.h.s.a> listA = com.anythink.core.common.h.s.a(jSONObject).a();
                if (listA != null && !listA.isEmpty()) {
                    for (com.anythink.core.common.h.s.a aVar : listA) {
                        if (!arrayList.contains(aVar.a())) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(TapEventParamConstants.PARAM_NAME, aVar.a());
                            arrayList2.add(jSONObject3);
                        }
                    }
                }
                if (arrayList2.isEmpty()) {
                    return;
                }
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    jSONArrayOptJSONArray.put((JSONObject) it.next());
                }
                jSONObject2.put("tags", jSONArrayOptJSONArray);
                bVarA.a(jSONObject2.toString());
                s.b().a(bVarA);
            }
        } catch (Throwable unused) {
        }
    }
}
