package com.byazt.kru;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.ep.cp;
import com.byazt.pp.LottieAnimationView;
import com.byazt.pp.d;
import com.byazt.pp.ou;
import com.byazt.pp.py;
import com.byazt.pp.q;
import com.byazt.pp.rv;
import com.byazt.pp.w;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.k;
import com.byazt.xz.oa;
import com.byazt.xz.tj;
import com.byazt.xz.x;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, 19})
public class n extends com.byazt.kru.qg {
    public C0231n bz;
    public final List<qg> il;
    public final UgenLottieView.n la;
    public boolean nk;
    public boolean qn;
    public View ze;

    public n(Context context) {
        super(context);
        this.nk = false;
        this.qn = false;
        this.il = new ArrayList();
        this.la = new UgenLottieView.n() { // from class: com.byazt.kru.n.1
            @Override // com.byazt.kru.UgenLottieView.n
            public void n(int i) {
                n.this.w(i);
            }

            @Override // com.byazt.kru.UgenLottieView.n
            public void n(boolean z) {
                n.this.q(z);
            }
        };
    }

    @Override // com.byazt.kru.qg, com.byazt.ih.s
    /* JADX INFO: renamed from: x */
    public UgenLottieView n() {
        LottieAnimationView.qg qgVar = new LottieAnimationView.qg() { // from class: com.byazt.kru.n.2
            @Override // com.byazt.pp.LottieAnimationView.qg
            public void n(String str, JSONArray jSONArray) {
                cy cyVar = new cy();
                cyVar.n(1);
                cyVar.n(n.this);
                if (jSONArray != null && jSONArray.length() > 0) {
                    n.this.n(cyVar, jSONArray);
                }
                if (n.this.ju == null || TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lottieEvent", true);
                    jSONObject.put("uttieUrl", n.this.n);
                    if (TextUtils.equals("CSJCLOSE", str)) {
                        jSONObject.put("type", ILivePush.ClickType.CLOSE);
                    } else if (TextUtils.equals("clickEvent", str)) {
                        jSONObject.put("type", "clickEvent");
                    }
                    cyVar.n(jSONObject);
                    cd cdVar = n.this.ju;
                    n nVar = n.this;
                    cdVar.n(cyVar, nVar, nVar);
                } catch (JSONException unused) {
                }
            }
        };
        UgenLottieView ugenLottieViewN = super.n();
        ugenLottieViewN.setTextDelegate(new py(ugenLottieViewN) { // from class: com.byazt.kru.n.3
            @Override // com.byazt.pp.py
            public String n(String str) {
                return com.byazt.mcb.qg.n(str, n.this.q);
            }
        });
        ugenLottieViewN.setViewDelegate(new ou() { // from class: com.byazt.kru.n.4
            @Override // com.byazt.pp.ou
            public View n(String str, Map<String, Object> map) {
                if (!"view:".equals(str) || map == null || map.isEmpty()) {
                    return null;
                }
                if (!n.this.nk) {
                    n.this.nk = true;
                    n.this.qg(map);
                }
                return n.this.ze;
            }
        });
        ugenLottieViewN.setLottieClicklistener(qgVar);
        ugenLottieViewN.setLottieAnimListener(new LottieAnimationView.n() { // from class: com.byazt.kru.n.5
            @Override // com.byazt.pp.LottieAnimationView.n
            public void n(Map<String, Object> map) {
                n.this.n(map, 19);
            }

            @Override // com.byazt.pp.LottieAnimationView.n
            public void qg(Map<String, Object> map) {
                n.this.n(map, 20);
            }
        });
        C0231n c0231n = new C0231n(this, qgVar);
        this.bz = c0231n;
        ugenLottieViewN.setEventMonitorProxy(c0231n);
        ugenLottieViewN.setTriggerVisibilityListener(this.la);
        ugenLottieViewN.n(new d() { // from class: com.byazt.kru.n.6
            @Override // com.byazt.pp.d
            public void n(w wVar) {
                n.this.n(wVar);
            }
        });
        return ugenLottieViewN;
    }

    @Override // com.byazt.kru.qg
    public void fs() {
        if (this.l != 0) {
            ((UgenLottieView) this.l).setMaintainOriginalImageBounds(true);
            ((UgenLottieView) this.l).setImageAssetDelegate(new AnonymousClass7());
            cx();
            if (((UgenLottieView) this.l).getVisibility() == 0) {
                ((UgenLottieView) this.l).n();
                ic();
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.kru.n$7, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, 75})
    public class AnonymousClass7 implements q {
        public AnonymousClass7() {
        }

        @Override // com.byazt.pp.q
        public Bitmap n(final rv rvVar) {
            final String strN;
            if (rvVar == null) {
                return null;
            }
            String strSz = rvVar.sz();
            String strOa = rvVar.oa();
            String strQ = rvVar.q();
            if (!TextUtils.isEmpty(strQ) && strQ.startsWith("${") && "image:".equals(strSz)) {
                strN = com.byazt.mcb.qg.n(strQ, n.this.q);
            } else if (!TextUtils.isEmpty(strSz) && TextUtils.isEmpty(strOa)) {
                strN = com.byazt.mcb.qg.n(strSz, n.this.q);
            } else if (!TextUtils.isEmpty(strOa) && TextUtils.isEmpty(strSz)) {
                strN = com.byazt.mcb.qg.n(strOa, n.this.q);
            } else {
                strN = (TextUtils.isEmpty(strOa) || TextUtils.isEmpty(strSz)) ? null : com.byazt.mcb.qg.n(strSz, n.this.q) + com.byazt.mcb.qg.n(strOa, n.this.q);
            }
            if (TextUtils.isEmpty(strN)) {
                return null;
            }
            Bitmap bitmap = n.this.ei.get(strN);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = n.this.dm.get(strN);
            if (num == null || num.intValue() == 2) {
                n.this.dm.put(strN, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            ((UgenLottieView) n.this.l).n(strN, new com.byazt.vk.rv() { // from class: com.byazt.kru.n.7.1
                @Override // com.byazt.vk.rv
                public void n(Bitmap bitmap2) {
                    n.this.n(rvVar, strN, bitmap2);
                }

                @Override // com.byazt.vk.rv
                public void n() {
                    com.byazt.gu.w.n().qg().n(n.this.rv, strN, new com.byazt.gu.qg.n() { // from class: com.byazt.kru.n.7.1.1
                        @Override // com.byazt.gu.qg.n
                        public void n(Bitmap bitmap2) {
                            n.this.n(rvVar, strN, bitmap2);
                        }
                    });
                }
            });
            return n.this.ei.get(strN);
        }
    }

    private void ic() {
        cy cyVar = new cy();
        cyVar.n(21);
        cyVar.n(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            jSONObject.put("uttieUrl", this.n);
            cyVar.n(jSONObject);
            this.ju.n(cyVar, this, this);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Map<String, Object> map, int i) {
        cy cyVar = new cy();
        cyVar.n(i);
        cyVar.n(this);
        if (map != null) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                n(cyVar, (JSONArray) obj);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            if (map != null) {
                Object obj2 = map.get(MediationConstant.EXTRA_DURATION);
                if (obj2 instanceof Long) {
                    jSONObject.put(MediationConstant.EXTRA_DURATION, obj2);
                    jSONObject.put("uttieUrl", this.n);
                }
                Object obj3 = map.get("el");
                if (obj3 instanceof String) {
                    jSONObject.put("type", obj3);
                }
            }
            cyVar.n(jSONObject);
            this.ju.n(cyVar, this, this);
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(v());
        String str = i == 19 ? "start" : "complete";
        arrayList.add(str);
        com.byazt.xz.cy cyVarS = this.rv == null ? null : this.rv.s();
        if (cyVarS != null) {
            String strQ = this.rv.q();
            HashMap map2 = new HashMap();
            map2.put("id", v());
            map2.put(TapEventParamConstants.PARAM_NAME, v());
            map2.put(WebLoginFragment.QUERY_KEY_ID, str);
            cyVarS.n(strQ, "Lottie://state", map2);
            return;
        }
        n(qg((com.byazt.ih.s) this), "Lottie://state", arrayList.toArray());
    }

    private void n(com.byazt.ih.s sVar, String str, Object... objArr) {
        List<com.byazt.ih.s<View>> listX;
        if (sVar == null) {
            return;
        }
        sVar.n(str, objArr);
        if (!(sVar instanceof com.byazt.ih.n) || (listX = ((com.byazt.ih.n) sVar).x()) == null || listX.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            n(it.next(), str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(cy cyVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("vid");
                    if (!TextUtils.isEmpty(strOptString)) {
                        int iOptInt = jSONObjectOptJSONObject.optInt(LiveConfigKey.HIGH, 0);
                        com.byazt.ih.s sVarN = n(cyVar.n(), strOptString);
                        if (sVarN != null) {
                            sVarN.qg(iOptInt == 0 ? 0 : 8);
                            View viewRv = sVarN.rv();
                            if (viewRv instanceof UgenLottieView) {
                                UgenLottieView ugenLottieView = (UgenLottieView) viewRv;
                                if (iOptInt == 0) {
                                    ugenLottieView.n();
                                    ic();
                                } else {
                                    ugenLottieView.w();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private com.byazt.ih.s n(com.byazt.ih.s sVar, String str) {
        if (sVar == null) {
            return null;
        }
        while (sVar.lh() != null) {
            sVar = sVar.lh();
        }
        return sVar.q(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(w wVar) {
        com.byazt.rx.q triggerManagerProxy;
        if (wVar == null || this.l == 0 || this.qn || (triggerManagerProxy = ((UgenLottieView) this.l).getTriggerManagerProxy()) == null) {
            return;
        }
        String strQ = this.rv != null ? this.rv.q() : null;
        HashSet hashSet = new HashSet();
        Map<String, rv> mapHd = wVar.hd();
        if (mapHd != null) {
            Iterator<rv> it = mapHd.values().iterator();
            while (it.hasNext()) {
                String strCy = it.next().cy();
                if (!TextUtils.isEmpty(strCy)) {
                    hashSet.add(strCy);
                }
            }
        }
        w.s sVarCp = wVar.cp();
        if (sVarCp != null && !TextUtils.isEmpty(sVarCp.l)) {
            hashSet.add(sVarCp.l);
        }
        w.qg qgVarD = wVar.d();
        if (qgVarD != null && !TextUtils.isEmpty(qgVarD.rv)) {
            hashSet.add(qgVarD.rv);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            n(triggerManagerProxy, strQ, (String) it2.next());
        }
        n(triggerManagerProxy, strQ);
        this.qn = true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0075 A[Catch: JSONException -> 0x00a3, TryCatch #0 {JSONException -> 0x00a3, blocks: (B:2:0x0000, B:4:0x000c, B:6:0x0012, B:8:0x001a, B:10:0x0020, B:12:0x0034, B:13:0x0038, B:15:0x0040, B:17:0x004f, B:18:0x0052, B:20:0x005a, B:22:0x0062, B:24:0x006a, B:27:0x0075, B:29:0x0089), top: B:33:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0089 A[Catch: JSONException -> 0x00a3, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00a3, blocks: (B:2:0x0000, B:4:0x000c, B:6:0x0012, B:8:0x001a, B:10:0x0020, B:12:0x0034, B:13:0x0038, B:15:0x0040, B:17:0x004f, B:18:0x0052, B:20:0x005a, B:22:0x0062, B:24:0x006a, B:27:0x0075, B:29:0x0089), top: B:33:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x009f A[SYNTHETIC] */
    private void n(com.byazt.rx.q qVar, String str, String str2) {
        x xVarN;
        s sVar;
        try {
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (xVarN = x.n(jSONObjectOptJSONObject, this.q)) != null && xVarN.n() != null) {
                    x.n nVarN = xVarN.n();
                    String strQg = nVarN.qg();
                    if ("Lottie".equalsIgnoreCase(nVarN.n())) {
                        strQg = nVarN.w();
                    }
                    if (com.byazt.sx.q.n.contains(strQg)) {
                        HashMap map = new HashMap();
                        Map<String, Object> mapS = xVarN.n().s();
                        if (mapS != null) {
                            map.putAll(mapS);
                        }
                        if (com.byazt.sx.q.qg.contains(strQg)) {
                            Object obj = map.get("id");
                            if (obj == null) {
                                obj = map.get(TapEventParamConstants.PARAM_NAME);
                            }
                            if (obj != null && !TextUtils.isEmpty(String.valueOf(obj))) {
                                sVar = new s(this, xVarN.qg());
                                qVar.n(str, strQg, map, sVar);
                                if ("timer".equals(strQg)) {
                                    int iIdentityHashCode = System.identityHashCode(sVar);
                                    this.il.size();
                                    System.identityHashCode(this);
                                    this.il.add(new qg(iIdentityHashCode, map, sVar));
                                }
                            }
                        } else {
                            sVar = new s(this, xVarN.qg());
                            qVar.n(str, strQg, map, sVar);
                            if ("timer".equals(strQg)) {
                                int iIdentityHashCode2 = System.identityHashCode(sVar);
                                this.il.size();
                                System.identityHashCode(this);
                                this.il.add(new qg(iIdentityHashCode2, map, sVar));
                            }
                        }
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    private void n(com.byazt.rx.q qVar, String str, int i, Map<String, Object> map, com.byazt.rx.qg qgVar) {
        if (qVar == null) {
            return;
        }
        HashMap map2 = new HashMap();
        if (this.l != 0) {
            map2.put("view", this.l);
        }
        qVar.n(str, "timer", i, map, map2, qgVar);
    }

    private void n(com.byazt.rx.q qVar, String str) {
        if (qVar == null || this.il.isEmpty()) {
            return;
        }
        this.il.size();
        System.identityHashCode(this);
        for (qg qgVar : this.il) {
            n(qVar, str, qgVar.n, qgVar.qg, qgVar.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i) {
        com.byazt.rx.q triggerManagerProxy;
        if (this.il.isEmpty() || this.l == 0 || (triggerManagerProxy = ((UgenLottieView) this.l).getTriggerManagerProxy()) == null) {
            return;
        }
        String strQ = this.rv != null ? this.rv.q() : null;
        Iterator<qg> it = this.il.iterator();
        while (it.hasNext()) {
            triggerManagerProxy.n(strQ, "timer", it.next().n, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z) {
        com.byazt.rx.q triggerManagerProxy;
        if (this.il.isEmpty() || this.l == 0 || (triggerManagerProxy = ((UgenLottieView) this.l).getTriggerManagerProxy()) == null) {
            return;
        }
        String strQ = this.rv != null ? this.rv.q() : null;
        Iterator<qg> it = this.il.iterator();
        while (it.hasNext()) {
            triggerManagerProxy.n(strQ, "timer", it.next().n, z);
        }
    }

    @Override // com.byazt.ih.s
    public void cp(String str) {
        com.byazt.rx.q triggerManagerProxy;
        if (this.il.isEmpty() || this.l == 0 || (triggerManagerProxy = ((UgenLottieView) this.l).getTriggerManagerProxy()) == null) {
            return;
        }
        String strQ = this.rv != null ? this.rv.q() : null;
        if (str == null) {
            str = "";
        }
        Iterator<qg> it = this.il.iterator();
        while (it.hasNext()) {
            triggerManagerProxy.n(strQ, "timer", it.next().n, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(List<x.n> list) {
        n(list, (Map<String, Object>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(List<x.n> list, Map<String, Object> map) {
        if (list == null || list.isEmpty()) {
            return;
        }
        JSONObject jSONObjectN = n(map);
        for (x.n nVarN : list) {
            if (nVarN != null) {
                if (jSONObjectN != null) {
                    nVarN = n(nVarN, jSONObjectN);
                }
                com.byazt.ss.n nVarN2 = com.byazt.ss.n.C0336n.n(this, "", nVarN);
                if (nVarN2 != null) {
                    nVarN2.n();
                    nVarN2.qg();
                }
            }
        }
    }

    private JSONObject n(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.q != null) {
                Iterator<String> itKeys = this.q.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, this.q.opt(next));
                }
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getKey() != null) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        return jSONObject;
    }

    private x.n n(x.n nVar, JSONObject jSONObject) {
        x.n nVarN;
        String strL = nVar.l();
        if (!TextUtils.isEmpty(strL) && strL.contains("${") && (nVarN = oa.n(com.byazt.mcb.qg.qg(strL, jSONObject), (JSONObject) null)) != null) {
            nVarN.s(nVar.x());
            return nVarN;
        }
        x.n nVar2 = new x.n();
        nVar2.n(nVar.n());
        nVar2.qg(nVar.qg());
        nVar2.q(nVar.w());
        nVar2.s(nVar.l());
        nVar2.s(nVar.x());
        Map<String, Object> mapS = nVar.s();
        if (mapS != null) {
            HashMap map = new HashMap(mapS.size());
            for (Map.Entry<String, Object> entry : mapS.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    map.put(entry.getKey(), com.byazt.mcb.qg.qg((String) value, jSONObject));
                } else {
                    map.put(entry.getKey(), value);
                }
            }
            nVar2.n(map);
        }
        return nVar2;
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void l() {
        super.l();
        hf();
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void w() {
        super.w();
        ci();
        kc();
    }

    @Override // com.byazt.ih.s, com.byazt.gu.l
    public void n(boolean z) {
        super.n(z);
        q(z);
    }

    private void ci() {
        C0231n c0231n = this.bz;
        if (c0231n != null) {
            c0231n.n();
        }
    }

    private void hf() {
        com.byazt.rx.q triggerManagerProxy;
        if (this.il.isEmpty() || this.l == 0 || (triggerManagerProxy = ((UgenLottieView) this.l).getTriggerManagerProxy()) == null) {
            return;
        }
        String strQ = this.rv != null ? this.rv.q() : null;
        this.il.size();
        System.identityHashCode(this);
        for (qg qgVar : this.il) {
            n(triggerManagerProxy, strQ, qgVar.n, qgVar.qg, qgVar.s);
        }
    }

    private void kc() {
        if (this.il.isEmpty()) {
            return;
        }
        String strQ = this.rv != null ? this.rv.q() : null;
        com.byazt.sx.q qVarN = com.byazt.sx.q.n();
        Iterator<qg> it = this.il.iterator();
        while (it.hasNext()) {
            qVarN.n(strQ, it.next().n);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, 226})
    private static final class qg {
        public final int n;
        public final Map<String, Object> qg;
        public final com.byazt.rx.qg s;

        public qg(int i, Map<String, Object> map, com.byazt.rx.qg qgVar) {
            this.n = i;
            this.qg = map;
            this.s = qgVar;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, 829})
    private static final class s implements com.byazt.rx.qg {
        public final WeakReference<n> n;
        public final List<x.n> qg;

        public s(n nVar, List<x.n> list) {
            this.n = new WeakReference<>(nVar);
            this.qg = list;
        }

        @Override // com.byazt.rx.qg
        public void n() {
            n nVar = this.n.get();
            if (nVar == null) {
                return;
            }
            nVar.n(this.qg);
        }

        @Override // com.byazt.rx.qg
        public void n(Map<String, Object> map) {
            n nVar = this.n.get();
            if (nVar == null) {
                return;
            }
            nVar.n(this.qg, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(Map<String, Object> map) {
        Object obj = map.get("ugen_url");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("ugen_md5");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("ugen_v");
        final String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("ugen_w");
        final int iIntValue = obj4 instanceof Integer ? ((Integer) obj4).intValue() : 0;
        Object obj5 = map.get("ugen_h");
        final int iIntValue2 = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        cp.n(str, str2, new com.byazt.ep.s() { // from class: com.byazt.kru.n.8
            @Override // com.byazt.ep.s
            public void n() {
            }

            @Override // com.byazt.ep.s
            public void n(String str4) {
                try {
                    n.this.n(new JSONObject(str4), iIntValue, iIntValue2, str3);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject, int i, int i2, String str) {
        com.byazt.ih.s<View> sVarN;
        k kVar = new k(this.qg);
        if (str.startsWith("2")) {
            sVarN = kVar.n(jSONObject);
            kVar.qg(this.q);
        } else {
            sVarN = str.startsWith("3") ? kVar.n(jSONObject, this.q, (JSONObject) null) : null;
        }
        if (sVarN != null) {
            this.ze = sVarN.rv();
        }
    }

    /* JADX INFO: renamed from: com.byazt.kru.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0231n implements com.byazt.rx.s {
        public int l;
        public final WeakReference<com.byazt.ih.s> n;
        public int q;
        public final LottieAnimationView.qg qg;
        public final Map<String, tj> s = new ConcurrentHashMap();

        public C0231n(com.byazt.ih.s sVar, LottieAnimationView.qg qgVar) {
            this.n = new WeakReference<>(sVar);
            this.qg = qgVar;
        }

        public void n() {
            this.s.clear();
        }

        @Override // com.byazt.rx.s
        public void n(MotionEvent motionEvent, String str, rv rvVar, String str2, JSONArray jSONArray, int i, String str3, final com.byazt.rx.n nVar, boolean z) {
            if (motionEvent == null) {
                return;
            }
            String strX = rvVar != null ? rvVar.x() : null;
            JSONArray jSONArrayRv = rvVar != null ? rvVar.rv() : null;
            if (str == null) {
                jSONArray = jSONArrayRv;
            } else {
                if (!TextUtils.isEmpty(strX) || str.contains("CSJNO")) {
                    str2 = strX;
                }
                if ((jSONArrayRv == null || jSONArrayRv.length() <= 0) && !str.contains("CSJLELNO")) {
                    strX = str2;
                } else {
                    strX = str2;
                    jSONArray = jSONArrayRv;
                }
            }
            String strCy = rvVar != null ? rvVar.cy() : null;
            if (!TextUtils.isEmpty(strCy)) {
                str3 = strCy;
            }
            if (!TextUtils.isEmpty(str3)) {
                tj tjVarN = this.s.get(str);
                if (tjVarN == null) {
                    tjVarN = tj.n(this.n.get(), str3);
                    com.byazt.ih.s sVar = this.n.get();
                    if (sVar != null) {
                        tjVarN.n(sVar.pe());
                        tjVarN.n(sVar.e());
                    }
                    tjVarN.n(new com.byazt.vh.w() { // from class: com.byazt.kru.n.n.1
                        @Override // com.byazt.vh.w
                        public void n(com.byazt.ih.s sVar2, String str4, List<x.n> list) {
                            com.byazt.rx.n nVar2 = nVar;
                            if (nVar2 != null) {
                                nVar2.n();
                            }
                        }
                    });
                    this.s.put(str, tjVarN);
                }
                tjVarN.n(z);
                tjVarN.n(motionEvent);
                return;
            }
            if (motionEvent.getAction() == 0) {
                this.q = (int) motionEvent.getX();
                this.l = (int) motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int iAbs = Math.abs(this.q - x);
                int iAbs2 = Math.abs(this.l - y);
                float f = (int) (i * Resources.getSystem().getDisplayMetrics().density);
                if ((iAbs * iAbs) + (iAbs2 * iAbs2) <= f * f) {
                    if (!TextUtils.isEmpty(strX) || (jSONArray != null && jSONArray.length() > 0)) {
                        this.qg.n(strX, jSONArray);
                    }
                    if (nVar != null) {
                        nVar.n();
                    }
                }
            }
        }
    }
}
