package com.anythink.core.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.AdError;
import com.anythink.core.b.i.AnonymousClass1;
import com.anythink.core.common.h.ad;
import com.anythink.core.common.h.ap;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.h.p;
import com.anythink.core.common.h.z;
import com.anythink.core.common.m.q;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.ae;
import com.anythink.core.common.v.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends d {
    public static final double j = 10000.0d;
    final String k;
    protected final List<JSONObject> l;
    List<bv> m;
    List<bv> n;
    String o;
    String p;
    String q;
    com.anythink.core.b.b.b r;
    long s;
    protected AtomicBoolean t;
    protected AtomicBoolean u;
    ConcurrentHashMap<String, bv> v;
    ConcurrentHashMap<String, bv> w;
    ConcurrentHashMap<String, bv> x;
    ConcurrentHashMap<String, bv> y;
    com.anythink.core.common.t.b z;

    protected abstract void a(List<JSONObject> list, q qVar);

    protected abstract String b();

    public e(com.anythink.core.common.h.a aVar) {
        super(aVar);
        this.k = getClass().getSimpleName() + ":";
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.t = new AtomicBoolean(false);
        this.u = new AtomicBoolean(false);
        this.v = new ConcurrentHashMap<>();
        this.w = new ConcurrentHashMap<>();
        this.x = new ConcurrentHashMap<>();
        this.y = new ConcurrentHashMap<>();
        this.z = new com.anythink.core.common.t.b() { // from class: com.anythink.core.b.e.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.b.e.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.g();
                    }
                });
            }
        };
        if (aVar.j != null && aVar.j.size() > 0) {
            for (bv bvVar : aVar.j) {
                if (bvVar != null) {
                    this.v.put(bvVar.z(), bvVar);
                    this.x.put(bvVar.z(), bvVar);
                }
            }
        }
        if (aVar.k != null && aVar.k.size() > 0) {
            for (bv bvVar2 : aVar.k) {
                this.w.put(bvVar2.z(), bvVar2);
                this.y.put(bvVar2.z(), bvVar2);
            }
        }
        if (aVar.r != null) {
            this.l.add(aVar.r);
        }
        this.o = aVar.d;
        this.p = aVar.e;
        this.q = b();
    }

    @Override // com.anythink.core.b.d
    public final void a(boolean z) {
        this.g = z;
    }

    @Override // com.anythink.core.b.d
    protected final void a(com.anythink.core.b.b.b bVar) {
        this.s = SystemClock.elapsedRealtime();
        this.r = bVar;
        if (ATSDK.isNetworkLogDebug()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("PlacementId", this.f.e);
                if (this.f.s.ah()) {
                    jSONObject.put("isAdxNetworkMode", true);
                }
                jSONObject.put("S2S Start HeadBidding List", a(this.f.j));
                jSONObject.put("S2S Start HeadBidding List(Directly)", b(this.l));
            } catch (Exception unused) {
            }
            ab.a(ab.a, jSONObject.toString(), false);
        }
        if (this.f.j.size() == 0 && this.f.k != null && this.f.k.size() > 0) {
            c(this.s);
            return;
        }
        long jN = this.f.n.n();
        if (jN <= 0) {
            jN = 500;
        }
        com.anythink.core.common.t.d.a().a(this.z, jN, false);
        Iterator<Map.Entry<String, bv>> it = this.v.entrySet().iterator();
        while (it.hasNext()) {
            bv value = it.next().getValue();
            if (value.g() == 66) {
                com.anythink.core.common.a.i.a(this.f.b).a(value.z(), System.currentTimeMillis());
            }
            i iVar = new i(this.f);
            i.a aVar = new i.a() { // from class: com.anythink.core.b.e.2
                @Override // com.anythink.core.b.i.a
                public final void a(bv bvVar, ATBaseAdAdapter aTBaseAdAdapter) {
                    if (e.this.r != null) {
                        e.this.r.a(bvVar, aTBaseAdAdapter);
                    }
                }

                @Override // com.anythink.core.b.i.a
                public final void a(bv bvVar, JSONObject jSONObject2) {
                    if (e.this.h.get()) {
                        return;
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    bvVar.m(jElapsedRealtime - e.this.s);
                    bvVar.a(jElapsedRealtime);
                    e.this.x.remove(bvVar.z());
                    e.a(e.this, bvVar);
                    if (!e.this.t.get() || e.this.t.get()) {
                        e.a(e.this, jSONObject2, bvVar);
                    } else {
                        a(ATBidRequestInfo.BIDTOKEN_OBTAIN_TIMEOUT_TYPE, bvVar);
                    }
                }

                @Override // com.anythink.core.b.i.a
                public final void a(String str, bv bvVar) {
                    if (e.this.h.get()) {
                        return;
                    }
                    bvVar.m(SystemClock.elapsedRealtime() - e.this.s);
                    if (str == null) {
                        str = "";
                    }
                    e.this.x.remove(bvVar.z());
                    e.this.v.remove(bvVar.z());
                    e.a(e.this, str, bvVar);
                    str.hashCode();
                    switch (str) {
                        case "This network don't support header bidding in current TopOn's version.":
                        case "Network init error.":
                        case "The parameter is abnormal.":
                        case "There is no Network Adapter.":
                            e.this.b(bvVar, str, 0L, -9);
                            break;
                        case "Request Token or Custom bid info Timeout.":
                        case "Network BidToken or Custom bid info is Empty.":
                            e.this.b(bvVar, str, 0L, -2);
                            break;
                        default:
                            e.this.b(bvVar, "Unknown error: ".concat(String.valueOf(str)), 0L, -9);
                            break;
                    }
                    e.a(e.this, (JSONObject) null, (bv) null);
                }
            };
            iVar.d = aVar;
            p pVarA = u.a(value);
            ATBaseAdAdapter aTBaseAdAdapter = pVarA != null ? pVarA.a : null;
            if (aTBaseAdAdapter == null) {
                String strA = ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE;
                if (pVarA != null) {
                    strA = pVarA.a(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE);
                }
                aVar.a(strA, value);
            } else {
                com.anythink.core.common.v.b.b.a().a(iVar.new AnonymousClass1(aTBaseAdAdapter, value));
            }
        }
    }

    private void b(long j2) {
        com.anythink.core.common.t.d.a().a(this.z, j2, false);
    }

    private void f() {
        com.anythink.core.common.t.d.a().b(this.z);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0033  */
    /* JADX WARN: Code duplicated, block: B:15:0x0035 A[Catch: all -> 0x0070, TryCatch #0 {, blocks: (B:11:0x001d, B:12:0x002b, B:15:0x0035, B:17:0x003d, B:25:0x004e, B:26:0x0053), top: B:38:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    /* JADX WARN: Code duplicated, block: B:22:0x004a  */
    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:25:0x004e A[Catch: all -> 0x0070, TryCatch #0 {, blocks: (B:11:0x001d, B:12:0x002b, B:15:0x0035, B:17:0x003d, B:25:0x004e, B:26:0x0053), top: B:38:0x001d }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0055 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    private void a(JSONObject jSONObject, bv bvVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (this.x.size() == 0) {
            f();
            if (this.u.get()) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        synchronized (this) {
            if (jSONObject != null && bvVar != null) {
                this.l.add(jSONObject);
                this.y.put(bvVar.z(), bvVar);
                if (this.l.size() <= 0) {
                    z3 = false;
                } else if (!z) {
                    if (this.t.get()) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z3 = false;
                    }
                }
                if (z3) {
                    c(this.s);
                    return;
                } else if (this.m.size() > 0) {
                    return;
                } else {
                    return;
                }
            }
            if (this.l.size() <= 0) {
                z3 = false;
            } else if (!z) {
                if (this.t.get() || this.u.get()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    z3 = false;
                }
            }
            if (z3) {
                c(this.s);
                return;
            } else {
                if (this.m.size() > 0 || !m()) {
                    return;
                }
                a(null, 0L, "", null, null);
                return;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        if (this.h.get()) {
            return;
        }
        this.t.set(true);
        if (this.l.size() > 0) {
            c(SystemClock.elapsedRealtime());
        }
    }

    protected synchronized void a(List<JSONObject> list, Map<String, bv> map, Map<String, JSONObject> map2) {
        for (JSONObject jSONObject : this.l) {
            list.add(jSONObject);
            map2.put(jSONObject.optString("ad_source_id"), jSONObject);
        }
        this.l.clear();
        ConcurrentHashMap<String, bv> concurrentHashMap = this.y;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, bv>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                bv value = it.next().getValue();
                if (value != null) {
                    value.b(SystemClock.elapsedRealtime());
                }
            }
        }
        map.putAll(this.y);
        this.y.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(final long j2) {
        if (this.u.get()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        final ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        a(arrayList, concurrentHashMap, concurrentHashMap2);
        this.u.set(true);
        a(arrayList, new q() { // from class: com.anythink.core.b.e.3
            @Override // com.anythink.core.common.m.q
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                synchronized (e.this) {
                    if (e.this.h.get()) {
                        String str = e.this.k;
                        String str2 = e.this.f.e;
                        return;
                    }
                    e.this.u.set(false);
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - j2;
                    e.this.a(e.a(obj), jElapsedRealtime, null, concurrentHashMap, concurrentHashMap2);
                    e.this.d();
                }
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str, AdError adError) {
                synchronized (e.this) {
                    if (e.this.h.get()) {
                        String str2 = e.this.k;
                        String str3 = e.this.f.e;
                    } else {
                        e.this.u.set(false);
                        e.this.d();
                        e.this.a(null, SystemClock.elapsedRealtime() - j2, adError != null ? adError.getPlatformMSG() : "", concurrentHashMap, concurrentHashMap2);
                    }
                }
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadCanceled(int i) {
                synchronized (e.this) {
                    if (e.this.h.get()) {
                        String str = e.this.k;
                        String str2 = e.this.f.e;
                    } else {
                        e.this.u.set(false);
                        e.this.d();
                        e.this.a(null, SystemClock.elapsedRealtime() - j2, "onLoadCanceled.", concurrentHashMap, concurrentHashMap2);
                    }
                }
            }
        });
    }

    protected final synchronized void d() {
        if (e()) {
            com.anythink.core.common.v.b.b.a().a(new Runnable() { // from class: com.anythink.core.b.e.4
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (e.this) {
                        if (e.this.e()) {
                            e.this.c(SystemClock.elapsedRealtime());
                        }
                    }
                }
            });
        }
    }

    protected final boolean e() {
        return !this.u.get() && this.l.size() > 0;
    }

    private boolean h() {
        return this.t.get() && !this.u.get();
    }

    private synchronized void i() {
        if (!this.h.get()) {
            this.h.set(true);
            f();
            this.x.clear();
            a(0L, -3, ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.v);
            a(0L, -3, ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.w);
            l();
            k();
            j();
        }
    }

    private void j() {
        com.anythink.core.b.b.b bVar;
        if ((this.n.size() > 0 || this.m.size() > 0) && (bVar = this.r) != null) {
            bVar.a(this.n, this.m);
        }
        this.n.clear();
        this.m.clear();
    }

    private void a(long j2, int i, String str, Map<String, bv> map) {
        for (bv bvVar : map.values()) {
            if (a(bvVar, str, i)) {
                this.n.add(bvVar);
            } else {
                b(bvVar, str, j2, i);
            }
        }
        map.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<ad> list, long j2, String str, Map<String, bv> map, Map<String, JSONObject> map2) {
        ap apVarAW;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collections.sort(list);
                    for (int i = 0; i < list.size(); i++) {
                        ad adVar = list.get(i);
                        this.v.remove(adVar.k);
                        bv bvVarRemove = map.remove(adVar.k);
                        if (this.w.containsKey(adVar.k)) {
                            bvVarRemove = this.w.remove(adVar.k);
                            this.w.clear();
                        }
                        bv bvVar = bvVarRemove;
                        if (bvVar != null) {
                            if (adVar.isSuccessWithUseType()) {
                                int i2 = i + 1;
                                a(bvVar.g(), adVar, i2 < list.size() ? list.get(i2).getSortPrice() : 0.0d, adVar.isSamePrice());
                                if (bvVar != null && adVar != null && (apVarAW = bvVar.aW()) != null) {
                                    apVarAW.b(adVar.m());
                                    apVarAW.d(adVar.n());
                                    apVarAW.a(adVar.o());
                                }
                                JSONObject jSONObject = map2.get(bvVar.z());
                                if (jSONObject != null) {
                                    String strOptString = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BID_TOKEN);
                                    if (TextUtils.isEmpty(strOptString)) {
                                        strOptString = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BUYERUID);
                                    }
                                    new StringBuilder("fillBidTokenFromNetwork, ").append(bvVar).append("\nbind bidToken=").append(strOptString).append("\nbind payload=");
                                    String str2 = adVar.token;
                                    adVar.c(strOptString);
                                }
                            }
                            a(bvVar, adVar, j2);
                            if (bvVar.g() == 66) {
                                com.anythink.core.common.a.i.a(this.f.b).a(bvVar.z(), adVar.w);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (map != null) {
            for (String str3 : map.keySet()) {
                if (str3 != null) {
                    this.v.remove(str3);
                }
                if (this.w.containsKey(str3)) {
                    this.w.clear();
                }
            }
        }
        if (map != null) {
            a(j2, -4, TextUtils.isEmpty(str) ? "No Response error." : "No Response error." + str, map);
        }
        if (this.n.size() >= 2) {
            Collections.sort(this.n);
        }
        l();
        k();
        j();
    }

    private static void a(Map<String, JSONObject> map, bv bvVar, ad adVar) {
        JSONObject jSONObject = map.get(bvVar.z());
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BID_TOKEN);
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = jSONObject.optString(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BUYERUID);
            }
            new StringBuilder("fillBidTokenFromNetwork, ").append(bvVar);
            String str = adVar.token;
            adVar.c(strOptString);
        }
    }

    private synchronized void k() {
        if (m()) {
            this.h.set(true);
        }
    }

    private void l() {
        if (ATSDK.isNetworkLogDebug()) {
            if (this.n.size() > 0 || this.m.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("PlacementId", this.f.e);
                    if (this.f.s.ah()) {
                        jSONObject.put("isAdxNetworkMode", true);
                    }
                    jSONObject.put("S2S HeadBidding Success List", a(this.n));
                    jSONObject.put("S2S HeadBidding Fail List", a(this.m));
                } catch (Exception unused) {
                }
                ab.a(ab.a, jSONObject.toString(), false);
            }
        }
    }

    private boolean m() {
        return this.v.size() == 0 && this.w.size() == 0 && this.x.size() == 0;
    }

    private static List<ad> b(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONObject) {
            JSONArray jSONArrayOptJSONArray = ((JSONObject) obj).optJSONArray("data");
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(ad.a(jSONArrayOptJSONArray.optJSONObject(i)));
            }
        }
        return arrayList;
    }

    private void b(bv bvVar) {
        int iG = bvVar.g();
        com.anythink.core.common.u.e.a(bvVar, this.f, bvVar.X(), true, f.a().b(iG));
        f.a().a(iG);
    }

    private void a(String str, bv bvVar) {
        if (TextUtils.equals(str, ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE) || TextUtils.equals(str, ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
            return;
        }
        int iG = bvVar.g();
        com.anythink.core.common.u.e.a(bvVar, this.f, bvVar.X(), false, f.a().b(iG));
        f.a().a(iG);
    }

    @Override // com.anythink.core.b.d
    protected void a(bv bvVar, z zVar, long j2) {
        String str;
        int i;
        if (zVar instanceof ad) {
            ad adVar = (ad) zVar;
            boolean zIsSuccessWithUseType = adVar.isSuccessWithUseType();
            boolean zA = a(zIsSuccessWithUseType, bvVar, zVar);
            int i2 = 0;
            AdError adErrorA = ae.a(0, this.f.s, bvVar, zVar);
            boolean z = adErrorA != null;
            if (zIsSuccessWithUseType && !zA && !z) {
                bvVar.c(j2 > 0 ? bvVar.X() + j2 : 0L);
                this.n.add(bvVar);
                if (bvVar.q() == 3 || bvVar.q() == 7) {
                    adVar.f = adVar.e + System.currentTimeMillis();
                } else {
                    adVar.f = bvVar.s() + System.currentTimeMillis();
                }
                a(bvVar, adVar);
                return;
            }
            if (zA) {
                b(bvVar, ATBidRequestInfo.LESS_THAN_BID_FLOOR_TYPE, j2, -11);
                bvVar.b(zVar.getPrice());
                bvVar.e(zVar.getSortPrice());
                a(adVar, bvVar);
                return;
            }
            if (z) {
                b(bvVar, adErrorA.getPlatformMSG(), j2, -13);
                bvVar.b(zVar.getPrice());
                bvVar.e(zVar.getSortPrice());
                b(adVar, bvVar);
                return;
            }
            if (adVar.useType == 2) {
                bvVar.V();
                str = "filter by s2s bid max count";
                i = 0;
                i2 = 1;
            } else {
                str = "errorCode:[" + adVar.a + "],errorMsg:[" + adVar.errorMsg + "]";
                i = -1;
            }
            if (a(bvVar, str, i, i2)) {
                this.n.add(bvVar);
            } else {
                b(bvVar, str, j2, i);
            }
        }
    }

    @Override // com.anythink.core.b.d
    protected final void a() {
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(bv bvVar, String str, long j2, int i) {
        long jX = 0;
        if (j2 > 0) {
            try {
                jX = bvVar.X() + j2;
            } catch (Throwable th) {
                throw th;
            }
        }
        a(bvVar, str, jX, i);
        this.m.add(bvVar);
    }

    private static void b(bv bvVar, ad adVar) {
        ap apVarAW;
        if (bvVar == null || adVar == null || (apVarAW = bvVar.aW()) == null) {
            return;
        }
        apVarAW.b(adVar.m());
        apVarAW.d(adVar.n());
        apVarAW.a(adVar.o());
    }

    static /* synthetic */ void a(e eVar, bv bvVar) {
        int iG = bvVar.g();
        com.anythink.core.common.u.e.a(bvVar, eVar.f, bvVar.X(), true, f.a().b(iG));
        f.a().a(iG);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[Catch: all -> 0x0072, TryCatch #0 {, blocks: (B:11:0x001f, B:12:0x002d, B:15:0x0037, B:17:0x003f, B:25:0x0050, B:26:0x0055), top: B:38:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x004c  */
    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050 A[Catch: all -> 0x0072, TryCatch #0 {, blocks: (B:11:0x001f, B:12:0x002d, B:15:0x0037, B:17:0x003f, B:25:0x0050, B:26:0x0055), top: B:38:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0057 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    static /* synthetic */ void a(e eVar, JSONObject jSONObject, bv bvVar) {
        boolean z;
        boolean z2;
        String str = eVar.k;
        boolean z3 = true;
        if (eVar.x.size() == 0) {
            eVar.f();
            if (eVar.u.get()) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        synchronized (eVar) {
            if (jSONObject != null && bvVar != null) {
                eVar.l.add(jSONObject);
                eVar.y.put(bvVar.z(), bvVar);
                if (eVar.l.size() <= 0) {
                    z3 = false;
                } else if (!z) {
                    if (eVar.t.get()) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z3 = false;
                    }
                }
                if (z3) {
                    eVar.c(eVar.s);
                    return;
                } else if (eVar.m.size() > 0) {
                    return;
                } else {
                    return;
                }
            }
            if (eVar.l.size() <= 0) {
                z3 = false;
            } else if (!z) {
                if (eVar.t.get() || eVar.u.get()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    z3 = false;
                }
            }
            if (z3) {
                eVar.c(eVar.s);
                return;
            } else {
                if (eVar.m.size() > 0 || !eVar.m()) {
                    return;
                }
                eVar.a(null, 0L, "", null, null);
                return;
            }
            throw th;
        }
    }

    static /* synthetic */ void a(e eVar, String str, bv bvVar) {
        if (TextUtils.equals(str, ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE) || TextUtils.equals(str, ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
            return;
        }
        int iG = bvVar.g();
        com.anythink.core.common.u.e.a(bvVar, eVar.f, bvVar.X(), false, f.a().b(iG));
        f.a().a(iG);
    }

    static /* synthetic */ List a(Object obj) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONObject) {
            JSONArray jSONArrayOptJSONArray = ((JSONObject) obj).optJSONArray("data");
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(ad.a(jSONArrayOptJSONArray.optJSONObject(i)));
            }
        }
        return arrayList;
    }
}
