package com.tapsdk.tapad.internal.j;

import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.TapAdResp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static HashMap<WeakReference<TapFeedAd>, WeakReference<c>> f = new HashMap<>();
    private static HashMap<WeakReference<AdInfo>, WeakReference<TapAdResp.b>> g = new HashMap<>();
    private WeakReference<TapFeedAd> a;
    private String b = "taptap://taptap.com/app?app_id=222429&tapdsp_track=trackid:ky0m70LXZ2WAIOcnmTgLGcWtuTo";
    private String c = "https://www.taptap.com/app/222429";
    private int d = 1;
    private int e = 2;

    public c(TapFeedAd tapFeedAd) {
        WeakReference<TapFeedAd> weakReference = new WeakReference<>(tapFeedAd);
        this.a = weakReference;
        f.put(weakReference, new WeakReference<>(this));
    }

    public static c a(TapFeedAd tapFeedAd) {
        for (Map.Entry<WeakReference<TapFeedAd>, WeakReference<c>> entry : f.entrySet()) {
            if (entry.getKey().get() == tapFeedAd) {
                return entry.getValue().get();
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
    
        if (r5.btnInteractionInfo.floatingLayerStyle != 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tapsdk.tapad.model.entities.AdInfo a(com.tapsdk.tapad.model.entities.AdInfo r5, com.tapsdk.tapad.internal.j.c r6) {
        /*
            com.tapsdk.tapad.model.entities.TapAdResp$b r0 = a(r5)
            if (r5 == 0) goto L72
            if (r0 == 0) goto L72
            if (r6 != 0) goto Lb
            goto L72
        Lb:
            int r1 = r6.e
            com.tapsdk.tapad.model.entities.InteractionInfo r2 = r5.btnInteractionInfo
            int r3 = r2.interactionType
            r4 = 1
            if (r1 != r3) goto L2a
            if (r1 != r4) goto L29
            int r1 = r6.d
            if (r1 != r4) goto L1f
            int r1 = r2.floatingLayerStyle
            if (r1 != r4) goto L1f
            return r5
        L1f:
            int r1 = r6.d
            if (r1 == r4) goto L2a
            com.tapsdk.tapad.model.entities.InteractionInfo r1 = r5.btnInteractionInfo
            int r1 = r1.floatingLayerStyle
            if (r1 == r4) goto L2a
        L29:
            return r5
        L2a:
            com.tapsdk.tapad.model.entities.TapAdResp$r$a r1 = com.tapsdk.tapad.model.entities.TapAdResp.r.a6()
            int r2 = r6.e
            com.tapsdk.tapad.model.entities.TapAdResp$InteractionType r2 = com.tapsdk.tapad.model.entities.TapAdResp.InteractionType.forNumber(r2)
            r1.a(r2)
            int r2 = r6.e
            if (r2 == r4) goto L4e
            r3 = 2
            if (r2 == r3) goto L48
            r3 = 3
            if (r2 == r3) goto L42
            goto L5a
        L42:
            java.lang.String r6 = r6.c
            r1.c(r6)
            goto L5a
        L48:
            java.lang.String r6 = r6.b
            r1.a(r6)
            goto L5a
        L4e:
            int r6 = r6.d
            if (r6 != r4) goto L56
            r1.o0(r4)
            goto L5a
        L56:
            r6 = 0
            r1.o0(r6)
        L5a:
            com.tapsdk.tapad.model.entities.AdInfo r6 = new com.tapsdk.tapad.model.entities.AdInfo
            com.tapadn.protobuf.GeneratedMessageLite$Builder r0 = r0.toBuilder()
            com.tapsdk.tapad.model.entities.TapAdResp$b$a r0 = (com.tapsdk.tapad.model.entities.TapAdResp.b.a) r0
            com.tapsdk.tapad.model.entities.TapAdResp$b$a r0 = r0.a(r1)
            com.tapadn.protobuf.GeneratedMessageLite r0 = r0.build()
            com.tapsdk.tapad.model.entities.TapAdResp$b r0 = (com.tapsdk.tapad.model.entities.TapAdResp.b) r0
            com.tapsdk.tapad.model.entities.TrackBackData r5 = r5.trackBackData
            r6.<init>(r0, r5)
            return r6
        L72:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapsdk.tapad.internal.j.c.a(com.tapsdk.tapad.model.entities.AdInfo, com.tapsdk.tapad.internal.j.c):com.tapsdk.tapad.model.entities.AdInfo");
    }

    private static TapAdResp.b a(AdInfo adInfo) {
        for (Map.Entry<WeakReference<AdInfo>, WeakReference<TapAdResp.b>> entry : g.entrySet()) {
            if (entry.getKey().get() == adInfo) {
                return entry.getValue().get();
            }
        }
        return null;
    }

    public static void a(AdInfo adInfo, TapAdResp.b bVar) {
        g.put(new WeakReference<>(adInfo), new WeakReference<>(bVar));
    }

    public static void b() {
        f.clear();
        g.clear();
    }

    public void a() {
        this.a.clear();
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }
}
