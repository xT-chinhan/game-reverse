package com.byazt.qs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.ch.ho;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.byazt.dd.fw;
import com.byazt.dd.vk;
import com.byazt.dx.LottieAnimationView;
import com.byazt.dx.aj;
import com.byazt.dx.cz;
import com.byazt.dx.k;
import com.byazt.dx.ny;
import com.byazt.dx.uc;
import com.byazt.dx.x;
import com.byazt.ea.w;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.mar.sdk.MARCode;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
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
@com.byazt.vzx.pr(pr = {0, 1, 670, 37})
public class pr extends hw {
    public boolean ku;
    public View p;
    public boolean xb;
    public C0173pr xg;

    public pr(Context context) {
        super(context);
        this.xb = false;
        this.ku = false;
    }

    @Override // com.byazt.qs.hw, com.byazt.ik.hn
    /* JADX INFO: renamed from: fw */
    public UgenLottieView pr() {
        LottieAnimationView.hw hwVar = new LottieAnimationView.hw() { // from class: com.byazt.qs.pr.1
            @Override // com.byazt.dx.LottieAnimationView.hw
            public void pr(String str, JSONArray jSONArray) {
                nt ntVar = new nt();
                ntVar.pr(1);
                ntVar.pr(pr.this);
                if (jSONArray != null && jSONArray.length() > 0) {
                    pr.this.pr(ntVar, jSONArray);
                }
                if (pr.this.u != null && !TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lottieEvent", true);
                        jSONObject.put("uttieUrl", pr.this.pr);
                        if (TextUtils.equals("CSJCLOSE", str)) {
                            jSONObject.put("type", ILivePush.ClickType.CLOSE);
                        } else if (TextUtils.equals("clickEvent", str)) {
                            jSONObject.put("type", "clickEvent");
                        }
                        ntVar.pr(jSONObject);
                        lb lbVar = pr.this.u;
                        pr prVar = pr.this;
                        lbVar.pr(ntVar, prVar, prVar);
                    } catch (JSONException e) {
                    }
                }
            }
        };
        UgenLottieView ugenLottieViewPr = super.pr();
        ugenLottieViewPr.setTextDelegate(new cz(ugenLottieViewPr) { // from class: com.byazt.qs.pr.2
            @Override // com.byazt.dx.cz
            public String pr(String str) {
                return com.byazt.tn.hw.pr(str, pr.this.x);
            }
        });
        ugenLottieViewPr.setViewDelegate(new ny() { // from class: com.byazt.qs.pr.3
            @Override // com.byazt.dx.ny
            public View pr(String str, Map<String, Object> map) {
                if ("view:".equals(str) && map != null && !map.isEmpty()) {
                    if (!pr.this.xb) {
                        pr.this.xb = true;
                        pr.this.pr(map);
                    }
                    return pr.this.p;
                }
                return null;
            }
        });
        ugenLottieViewPr.setLottieClicklistener(hwVar);
        ugenLottieViewPr.setLottieAnimListener(new LottieAnimationView.pr() { // from class: com.byazt.qs.pr.4
            @Override // com.byazt.dx.LottieAnimationView.pr
            public void pr(Map<String, Object> map) {
                pr.this.pr(map, 19);
            }

            @Override // com.byazt.dx.LottieAnimationView.pr
            public void hw(Map<String, Object> map) {
                pr.this.pr(map, 20);
            }
        });
        C0173pr c0173pr = new C0173pr(this, hwVar);
        this.xg = c0173pr;
        ugenLottieViewPr.setEventMonitorProxy(c0173pr);
        ugenLottieViewPr.pr(new k() { // from class: com.byazt.qs.pr.5
            @Override // com.byazt.dx.k
            public void pr(uc ucVar) {
                pr.this.pr(ucVar);
            }
        });
        return ugenLottieViewPr;
    }

    @Override // com.byazt.qs.hw
    public void zo() {
        if (this.c != 0) {
            ((UgenLottieView) this.c).setImageAssetDelegate(new AnonymousClass6());
            lv();
            if (((UgenLottieView) this.c).getVisibility() == 0) {
                ((UgenLottieView) this.c).pr();
                vj();
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.qs.pr$6, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 670, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500})
    public class AnonymousClass6 implements x {
        public AnonymousClass6() {
        }

        @Override // com.byazt.dx.x
        public Bitmap pr(final aj ajVar) {
            final String strPr;
            if (ajVar == null) {
                return null;
            }
            String strG = ajVar.g();
            String strM = ajVar.m();
            String strX = ajVar.x();
            if (!TextUtils.isEmpty(strX) && strX.startsWith("${") && "image:".equals(strG)) {
                strPr = com.byazt.tn.hw.pr(strX, pr.this.x);
            } else if (!TextUtils.isEmpty(strG) && TextUtils.isEmpty(strM)) {
                strPr = com.byazt.tn.hw.pr(strG, pr.this.x);
            } else if (!TextUtils.isEmpty(strM) && TextUtils.isEmpty(strG)) {
                strPr = com.byazt.tn.hw.pr(strM, pr.this.x);
            } else {
                strPr = (TextUtils.isEmpty(strM) || TextUtils.isEmpty(strG)) ? null : com.byazt.tn.hw.pr(strG, pr.this.x) + com.byazt.tn.hw.pr(strM, pr.this.x);
            }
            if (TextUtils.isEmpty(strPr)) {
                return null;
            }
            Bitmap bitmap = pr.this.fe.get(strPr);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = pr.this.ks.get(strPr);
            if (num == null || num.intValue() == 2) {
                pr.this.ks.put(strPr, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            ((UgenLottieView) pr.this.c).pr(strPr, new com.byazt.rwn.aj() { // from class: com.byazt.qs.pr.6.1
                @Override // com.byazt.rwn.aj
                public void pr(Bitmap bitmap2) {
                    pr.this.pr(ajVar, strPr, bitmap2);
                }

                @Override // com.byazt.rwn.aj
                public void pr() {
                    com.byazt.llk.uc.pr().hw().pr(pr.this.aj, strPr, new com.byazt.llk.hw.pr() { // from class: com.byazt.qs.pr.6.1.1
                        @Override // com.byazt.llk.hw.pr
                        public void pr(Bitmap bitmap2) {
                            pr.this.pr(ajVar, strPr, bitmap2);
                        }
                    });
                }
            });
            return pr.this.fe.get(strPr);
        }
    }

    private void vj() {
        nt ntVar = new nt();
        ntVar.pr(21);
        ntVar.pr(this);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            jSONObject.put("uttieUrl", this.pr);
            ntVar.pr(jSONObject);
            this.u.pr(ntVar, this, this);
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Map<String, Object> map, int i) {
        nt ntVar = new nt();
        ntVar.pr(i);
        ntVar.pr(this);
        if (map != null) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                pr(ntVar, (JSONArray) obj);
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lottieEvent", true);
            if (map != null) {
                Object obj2 = map.get("duration");
                if (obj2 instanceof Long) {
                    jSONObject.put("duration", obj2);
                    jSONObject.put("uttieUrl", this.pr);
                }
                Object obj3 = map.get("el");
                if (obj3 instanceof String) {
                    jSONObject.put("type", obj3);
                }
            }
            ntVar.pr(jSONObject);
            this.u.pr(ntVar, this, this);
        } catch (JSONException e) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ww());
        String str = i == 19 ? TrackAction.START : "complete";
        arrayList.add(str);
        com.byazt.dd.nt ntVarHn = this.aj == null ? null : this.aj.hn();
        if (ntVarHn == null) {
            pr(hw((com.byazt.ik.hn) this), "Lottie://state", arrayList.toArray());
            return;
        }
        String strX = this.aj.x();
        HashMap map2 = new HashMap();
        map2.put("id", ww());
        map2.put(Common.System.NAME, ww());
        map2.put("state", str);
        ntVarHn.pr(strX, "Lottie://state", map2);
    }

    private void pr(com.byazt.ik.hn hnVar, String str, Object... objArr) {
        List<com.byazt.ik.hn<View>> listFw;
        if (hnVar == null) {
            return;
        }
        hnVar.pr(str, objArr);
        if (!(hnVar instanceof com.byazt.ik.pr) || (listFw = ((com.byazt.ik.pr) hnVar).fw()) == null || listFw.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
        while (it.hasNext()) {
            pr(it.next(), str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(nt ntVar, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("vid");
                    if (!TextUtils.isEmpty(strOptString)) {
                        int iOptInt = jSONObjectOptJSONObject.optInt(LiveConfigKey.HIGH, 0);
                        com.byazt.ik.hn hnVarPr = pr(ntVar.pr(), strOptString);
                        if (hnVarPr != null) {
                            hnVarPr.hw(iOptInt == 0 ? 0 : 8);
                            View viewAj = hnVarPr.aj();
                            if (viewAj instanceof UgenLottieView) {
                                UgenLottieView ugenLottieView = (UgenLottieView) viewAj;
                                if (iOptInt == 0) {
                                    ugenLottieView.pr();
                                    vj();
                                } else {
                                    ugenLottieView.uc();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private com.byazt.ik.hn pr(com.byazt.ik.hn hnVar, String str) {
        if (hnVar == null) {
            return null;
        }
        while (hnVar.y() != null) {
            hnVar = hnVar.y();
        }
        return hnVar.x(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(uc ucVar) {
        com.byazt.wg.x triggerManagerProxy;
        if (ucVar == null || this.c == 0 || this.ku || (triggerManagerProxy = ((UgenLottieView) this.c).getTriggerManagerProxy()) == null) {
            return;
        }
        String strX = this.aj != null ? this.aj.x() : null;
        HashSet hashSet = new HashSet();
        Map<String, aj> mapYb = ucVar.yb();
        if (mapYb != null) {
            Iterator<aj> it = mapYb.values().iterator();
            while (it.hasNext()) {
                String strNt = it.next().nt();
                if (!TextUtils.isEmpty(strNt)) {
                    hashSet.add(strNt);
                }
            }
        }
        uc.hn hnVarW = ucVar.w();
        if (hnVarW != null && !TextUtils.isEmpty(hnVarW.c)) {
            hashSet.add(hnVarW.c);
        }
        uc.hw hwVarK = ucVar.k();
        if (hwVarK != null && !TextUtils.isEmpty(hwVarK.aj)) {
            hashSet.add(hwVarK.aj);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            pr(triggerManagerProxy, strX, (String) it2.next());
        }
        this.ku = true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0075 A[Catch: JSONException -> 0x008a, TRY_LEAVE, TryCatch #0 {JSONException -> 0x008a, blocks: (B:2:0x0000, B:4:0x000c, B:6:0x0012, B:8:0x001a, B:10:0x0020, B:12:0x0034, B:13:0x0038, B:15:0x0040, B:17:0x004f, B:18:0x0052, B:20:0x005a, B:22:0x0062, B:24:0x006a, B:27:0x0075), top: B:32:0x0000 }] */
    private void pr(com.byazt.wg.x xVar, String str, String str2) {
        fw fwVarPr;
        try {
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && (fwVarPr = fw.pr(jSONObjectOptJSONObject, this.x)) != null && fwVarPr.pr() != null) {
                    fw.pr prVarPr = fwVarPr.pr();
                    String strHw = prVarPr.hw();
                    if ("Lottie".equalsIgnoreCase(prVarPr.pr())) {
                        strHw = prVarPr.c();
                    }
                    if (com.byazt.at.x.pr.contains(strHw)) {
                        HashMap map = new HashMap();
                        Map<String, Object> mapHn = fwVarPr.pr().hn();
                        if (mapHn != null) {
                            map.putAll(mapHn);
                        }
                        if (com.byazt.at.x.hw.contains(strHw)) {
                            Object obj = map.get("id");
                            if (obj == null) {
                                obj = map.get(Common.System.NAME);
                            }
                            if (obj != null && !TextUtils.isEmpty(String.valueOf(obj))) {
                                final List<fw.pr> listHw = fwVarPr.hw();
                                final WeakReference weakReference = new WeakReference(this);
                                xVar.pr(str, strHw, map, new com.byazt.wg.hw() { // from class: com.byazt.qs.pr.7
                                    @Override // com.byazt.wg.hw
                                    public void pr() {
                                        pr prVar = (pr) weakReference.get();
                                        if (prVar != null) {
                                            prVar.pr((List<fw.pr>) listHw);
                                        }
                                    }
                                });
                            }
                        } else {
                            final List listHw2 = fwVarPr.hw();
                            final WeakReference weakReference2 = new WeakReference(this);
                            xVar.pr(str, strHw, map, new com.byazt.wg.hw() { // from class: com.byazt.qs.pr.7
                                @Override // com.byazt.wg.hw
                                public void pr() {
                                    pr prVar = (pr) weakReference2.get();
                                    if (prVar != null) {
                                        prVar.pr((List<fw.pr>) listHw2);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(List<fw.pr> list) {
        com.byazt.tby.pr prVarPr;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (fw.pr prVar : list) {
            if (prVar != null && (prVarPr = com.byazt.tby.pr.C0193pr.pr(this, "", prVar)) != null) {
                prVarPr.pr();
                prVarPr.hw();
            }
        }
    }

    @Override // com.byazt.ik.hn, com.byazt.llk.c
    public void uc() {
        super.uc();
        mw();
    }

    private void mw() {
        C0173pr c0173pr = this.xg;
        if (c0173pr != null) {
            c0173pr.pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Map<String, Object> map) {
        String str;
        String str2;
        final int iIntValue;
        Object obj = map.get("ugen_url");
        if (!(obj instanceof String)) {
            str = null;
        } else {
            str = (String) obj;
        }
        Object obj2 = map.get("ugen_md5");
        if (!(obj2 instanceof String)) {
            str2 = null;
        } else {
            str2 = (String) obj2;
        }
        Object obj3 = map.get("ugen_v");
        final String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("ugen_w");
        if (!(obj4 instanceof Integer)) {
            iIntValue = 0;
        } else {
            iIntValue = ((Integer) obj4).intValue();
        }
        Object obj5 = map.get("ugen_h");
        final int iIntValue2 = obj5 instanceof Integer ? ((Integer) obj5).intValue() : 0;
        if (iIntValue <= 0 || iIntValue2 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        w.pr(str, str2, new com.byazt.ea.hn() { // from class: com.byazt.qs.pr.8
            @Override // com.byazt.ea.hn
            public void pr(String str4) {
                try {
                    pr.this.pr(new JSONObject(str4), iIntValue, iIntValue2, str3);
                } catch (Throwable th) {
                }
            }

            @Override // com.byazt.ea.hn
            public void pr() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(JSONObject jSONObject, int i, int i2, String str) {
        ho hoVar = new ho(this.hw);
        com.byazt.ik.hn<View> hnVarPr = null;
        if (str.startsWith("2")) {
            hnVarPr = hoVar.pr(jSONObject);
            hoVar.hw(this.x);
        } else if (str.startsWith(GlobalSetting.SPLASH_AD)) {
            hnVarPr = hoVar.pr(jSONObject, this.x, (JSONObject) null);
        }
        if (hnVarPr != null) {
            this.p = hnVarPr.aj();
        }
    }

    /* JADX INFO: renamed from: com.byazt.qs.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 670, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static class C0173pr implements com.byazt.wg.hn {
        public int c;
        public final Map<String, vk> hn = new ConcurrentHashMap();
        public final LottieAnimationView.hw hw;
        public final WeakReference<com.byazt.ik.hn> pr;
        public int x;

        public C0173pr(com.byazt.ik.hn hnVar, LottieAnimationView.hw hwVar) {
            this.pr = new WeakReference<>(hnVar);
            this.hw = hwVar;
        }

        public void pr() {
            this.hn.clear();
        }

        @Override // com.byazt.wg.hn
        public void pr(MotionEvent motionEvent, String str, aj ajVar, String str2, JSONArray jSONArray, int i, String str3, final com.byazt.wg.pr prVar, boolean z) {
            if (motionEvent == null) {
                return;
            }
            String strFw = ajVar != null ? ajVar.fw() : null;
            JSONArray jSONArrayAj = ajVar != null ? ajVar.aj() : null;
            if (str == null) {
                jSONArray = jSONArrayAj;
            } else {
                if (!TextUtils.isEmpty(strFw) || str.contains("CSJNO")) {
                    str2 = strFw;
                }
                if ((jSONArrayAj == null || jSONArrayAj.length() <= 0) && !str.contains("CSJLELNO")) {
                    strFw = str2;
                } else {
                    strFw = str2;
                    jSONArray = jSONArrayAj;
                }
            }
            String strNt = ajVar != null ? ajVar.nt() : null;
            if (!TextUtils.isEmpty(strNt)) {
                str3 = strNt;
            }
            if (!TextUtils.isEmpty(str3)) {
                vk vkVarPr = this.hn.get(str);
                if (vkVarPr == null) {
                    vkVarPr = vk.pr(this.pr.get(), str3);
                    com.byazt.ik.hn hnVar = this.pr.get();
                    if (hnVar != null) {
                        vkVarPr.pr(hnVar.bm());
                        vkVarPr.pr(hnVar.jn());
                    }
                    vkVarPr.pr(new com.byazt.ch.uc() { // from class: com.byazt.qs.pr.pr.1
                        @Override // com.byazt.ch.uc
                        public void pr(com.byazt.ik.hn hnVar2, String str4, List<fw.pr> list) {
                            com.byazt.wg.pr prVar2 = prVar;
                            if (prVar2 != null) {
                                prVar2.pr();
                            }
                        }
                    });
                    this.hn.put(str, vkVarPr);
                }
                vkVarPr.pr(z);
                vkVarPr.pr(motionEvent);
                return;
            }
            if (motionEvent.getAction() == 0) {
                this.x = (int) motionEvent.getX();
                this.c = (int) motionEvent.getY();
            }
            if (motionEvent.getAction() == 1) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int iAbs = Math.abs(this.x - x);
                int iAbs2 = Math.abs(this.c - y);
                float f = (int) (i * Resources.getSystem().getDisplayMetrics().density);
                if ((iAbs * iAbs) + (iAbs2 * iAbs2) <= f * f) {
                    if (!TextUtils.isEmpty(strFw) || (jSONArray != null && jSONArray.length() > 0)) {
                        this.hw.pr(strFw, jSONArray);
                    }
                    if (prVar != null) {
                        prVar.pr();
                    }
                }
            }
        }
    }
}
