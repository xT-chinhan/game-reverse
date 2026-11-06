package com.byazt.whi;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.be.CreativeContainer;
import com.byazt.fvm.oa;
import com.byazt.gct.cp;
import com.byazt.gct.pk;
import com.byazt.gct.tj;
import com.byazt.ia.NativeVideoTsView;
import com.byazt.iz.fs;
import com.byazt.mr.EmptyView;
import com.byazt.nf.rv;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.qit.x;
import com.byazt.tk.d;
import com.byazt.tk.k;
import com.byazt.tk.ou;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.JProtect;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 953, 5})
public class q {
    public AppDownloadListener a;
    public n an;
    public Activity bb;
    public View cy;
    public com.byazt.dc.n fs;
    public volatile com.byazt.ys.n h;
    public com.byazt.dc.n hd;
    public volatile com.byazt.ys.qg hu;
    public CreativeContainer j;
    public WeakReference<ViewGroup> k;
    public WeakReference<NativeVideoTsView> ln;
    public View m;
    public final pk n;
    public oa q;
    public final Context qg;
    public volatile ITTInnerDownloadAdapter s;
    public ViewGroup sz;
    public com.byazt.ys.n t;
    public ou um;
    public com.byazt.ys.n ur;
    public com.byazt.ia.n v;
    public final com.byazt.hm.qg w;
    public EmptyView wm;
    public String x;
    public List<View> l = new ArrayList();
    public Double rv = null;
    public final AtomicBoolean tj = new AtomicBoolean(false);
    public final AtomicBoolean cp = new AtomicBoolean(false);
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final AtomicBoolean oa = new AtomicBoolean(false);
    public int cd = 5;
    public volatile long py = 0;
    public volatile boolean ou = true;
    public volatile boolean lh = false;

    public q(Context context, oa oaVar, pk pkVar, String str) {
        this.x = com.byazt.wg.qg.AD_TAG_FEED;
        this.q = oaVar;
        this.n = pkVar;
        this.qg = context;
        this.x = str;
        this.w = new com.byazt.hm.qg(pkVar, str);
    }

    public void n(oa oaVar) {
        this.q = oaVar;
    }

    public void n(Activity activity) {
        this.bb = activity;
        if (this.s != null) {
            this.s.setActivity(activity, false);
        }
    }

    public void n(View view, int i) {
        oa oaVar = this.q;
        com.byazt.de.qg.s(oaVar != null ? oaVar.hu() : null);
        com.byazt.dc.n nVar = this.fs;
        if (nVar != null) {
            nVar.qg(view, this.q);
        }
    }

    public void n(CreativeContainer creativeContainer) {
        this.j = creativeContainer;
        if (creativeContainer == null || this.hu == null) {
            return;
        }
        this.j.setOnClickListener(this.hu);
    }

    public ITTInnerDownloadAdapter n() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        pk pkVar = this.n;
        if (pkVar == null || pkVar.rv() != 4) {
            return;
        }
        if (this.lh) {
            q();
        } else {
            this.lh = true;
            com.byazt.ag.qg.n(new x("feed_register_download") { // from class: com.byazt.whi.q.1
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.s == null) {
                        q qVar = q.this;
                        qVar.s = fs.n(qVar.qg, q.this.n, q.this.x);
                    }
                    q.this.s.setActivity(q.this.bb, false);
                    q.this.q();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.s != null) {
            if (this.hu != null) {
                ((com.byazt.zct.n) this.hu.n(com.byazt.zct.n.class)).n(this.s);
            }
            if (this.h != null) {
                ((com.byazt.zct.n) this.h.n(com.byazt.zct.n.class)).n(this.s);
            }
            com.byazt.ys.n nVar = this.ur;
            if (nVar != null) {
                ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n(this.s);
            }
            com.byazt.ys.n nVar2 = this.t;
            if (nVar2 != null) {
                ((com.byazt.zct.n) nVar2.n(com.byazt.zct.n.class)).n(this.s);
            }
            try {
                this.s.init();
                this.s.addAppDownloadListener(this.a);
            } catch (Exception unused) {
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 953, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n implements View.OnLayoutChangeListener {
        public final com.byazt.hm.qg n;
        public final ViewGroup qg;

        public n(com.byazt.hm.qg qgVar, ViewGroup viewGroup) {
            this.n = qgVar;
            this.qg = viewGroup;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.n.n(com.byazt.okk.q.qg(this.qg), 17);
        }
    }

    public void n(final ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, final com.byazt.dc.n nVar, com.byazt.dc.n nVar2) {
        final EmptyView emptyView;
        this.fs = nVar;
        this.sz = viewGroup;
        this.k = new WeakReference<>(this.sz);
        this.cy = view;
        this.hd = nVar2;
        Context context = this.qg;
        pk pkVar = this.n;
        String str = this.x;
        this.ur = new com.byazt.ys.n(context, pkVar, str, w.q(str));
        n nVar3 = new n(this.w, viewGroup);
        this.an = nVar3;
        viewGroup.addOnLayoutChangeListener(nVar3);
        qg(viewGroup);
        EmptyView emptyViewQ = q(viewGroup);
        if (emptyViewQ == null) {
            pk pkVar2 = this.n;
            EmptyView emptyView2 = new EmptyView(this.qg, viewGroup, pkVar2 != null ? pkVar2.yq() : 1000) { // from class: com.byazt.whi.q.3
                @Override // android.view.View
                public void onVisibilityChanged(View view2, int i) {
                    super.onVisibilityChanged(view2, i);
                    ou ouVar = q.this.um;
                    if (ouVar == null) {
                        return;
                    }
                    try {
                        q.this.ou = isShown();
                        if (isShown()) {
                            ouVar.n(q.this.n != null ? q.this.n.v() : 0);
                        } else {
                            ouVar.qg(q.this.n != null ? q.this.n.v() : 0);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            emptyView2.setAdType(this.cd);
            emptyView2.n(this.n, this.x);
            viewGroup.addView(emptyView2);
            emptyView = emptyView2;
        } else {
            emptyView = emptyViewQ;
        }
        emptyView.n();
        emptyView.setRefClickViews(list2);
        emptyView.setRefCreativeViews(list3);
        emptyView.setRefDirectDownloadViews(list4);
        this.wm = emptyView;
        n(this.ur, this.sz, this.cy, nVar, this.hd, 3);
        this.l = list;
        Context context2 = this.qg;
        pk pkVar3 = this.n;
        String str2 = this.x;
        this.hu = new com.byazt.ys.qg(context2, pkVar3, str2, w.q(str2));
        n(this.hu, viewGroup, view, nVar, nVar2, 0);
        Context context3 = this.qg;
        pk pkVar4 = this.n;
        String str3 = this.x;
        this.h = new com.byazt.ys.n(context3, pkVar4, str3, w.q(str3));
        n(this.h, viewGroup, view, nVar, nVar2, 1);
        if (!d.n(list4)) {
            Context context4 = this.qg;
            pk pkVar5 = this.n;
            String str4 = this.x;
            com.byazt.ys.n nVar4 = new com.byazt.ys.n(context4, pkVar5, str4, w.q(str4));
            this.t = nVar4;
            nVar4.n(2);
            n(this.t, viewGroup, view, nVar, nVar2, 2);
        }
        CreativeContainer creativeContainer = this.j;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(this.hu);
        }
        emptyView.n(list2, this.hu);
        emptyView.n(list3, this.h);
        emptyView.n(list4, this.t);
        emptyView.setCallback(new EmptyView.n() { // from class: com.byazt.whi.q.4
            @Override // com.byazt.mr.EmptyView.n
            public void n(boolean z) {
                q.this.w.n(com.byazt.okk.q.qg(viewGroup), z ? 12 : 13);
                if (q.this.v != null) {
                    q.this.v.n(z);
                }
                ou ouVar = q.this.um;
                if (ouVar != null) {
                    if (z) {
                        ouVar.n(q.this.n != null ? q.this.n.v() : 0);
                    } else {
                        try {
                            ouVar.qg(q.this.n != null ? q.this.n.v() : 0);
                        } catch (Throwable th) {
                            k.qg("ShakeUtils", "onPause error:" + th.getMessage());
                        }
                    }
                }
                if (q.this.cd == 9) {
                    if (z) {
                        com.byazt.fr.s.n().n(q.this.sz.getContext(), q.this.n, w.bb(q.this.n));
                    } else {
                        com.byazt.fr.s.n().qg(q.this.sz.getContext(), q.this.n, true);
                    }
                }
            }

            @Override // com.byazt.mr.EmptyView.n
            public void n() {
                q.this.s();
                if (q.this.cd == 9) {
                    com.byazt.fr.s.n().n(q.this.sz.getContext(), q.this.n, w.bb(q.this.n));
                }
                q.this.w.n(com.byazt.okk.q.qg(viewGroup), 14);
            }

            @Override // com.byazt.mr.EmptyView.n
            public void qg() {
                if (q.this.s != null) {
                    q.this.s.onDestroy();
                }
                try {
                    if (q.this.um != null) {
                        q.this.um.qg(q.this.n != null ? q.this.n.v() : 0);
                    }
                } catch (Throwable th) {
                    k.qg("ShakeUtils", "onPause error:" + th.getMessage());
                }
                q.this.tj.set(false);
                q.this.cp.set(false);
                if (q.this.cd == 9) {
                    com.byazt.fr.s.n().qg(q.this.sz.getContext(), q.this.n, true);
                }
                q.this.w.n(com.byazt.okk.q.qg(viewGroup), 15);
            }

            @Override // com.byazt.mr.EmptyView.n
            @JProtect
            public void n(View view2, Map<String, Object> map) {
                com.byazt.msp.n.n(q.this.cd, q.this.n);
                q.this.s();
                q.this.w.n(com.byazt.okk.q.qg(viewGroup), 11);
                Map mapX = q.this.x();
                mapX.put("is_repeat", Boolean.valueOf(q.this.d.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapX.put("show_send_type", map.get("show_send_type"));
                }
                mapX.put("is_repeat", Boolean.valueOf(q.this.d.get()));
                mapX.put("view_state", Integer.valueOf(q.this.n(viewGroup) ? 1 : 0));
                q.this.tj.set(true);
                if (!q.this.cp.get()) {
                    q.this.cp.set(true);
                    com.byazt.hm.n.n(q.this.n, q.this.x, (Map<String, Object>) mapX, q.this.rv);
                    com.byazt.hnb.qg.n().q();
                    com.byazt.cd.s.n(q.this.n != null ? q.this.n.v() : 0);
                }
                if (nVar != null) {
                    boolean zIt = rv.qg().it();
                    if (!q.this.d.getAndSet(true) || zIt) {
                        com.byazt.de.qg.n(q.this.q != null ? q.this.q.hu() : null, false);
                        nVar.n(q.this.q);
                        if (q.this.n != null && q.this.n.ur() && q.this.n.sz() != null) {
                            com.byazt.rl.n.n().n(q.this.qg, q.this.n.sz().qg());
                        }
                    }
                    q.this.py = System.currentTimeMillis();
                    q.this.w();
                }
                if (q.this.v != null) {
                    q.this.v.n();
                }
                if (!q.this.cp.get() || q.this.oa.get()) {
                    return;
                }
                q.this.oa.set(true);
                com.byazt.uq.qg.n(q.this.n, q.this.x, emptyView, q.this.n != null && q.this.n.wn());
            }
        });
        emptyView.setNeedCheckingShow(true);
        s();
    }

    public boolean n(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof NativeVideoTsView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && n((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public void n(com.byazt.ia.n nVar) {
        this.v = nVar;
    }

    public void n(WeakReference<NativeVideoTsView> weakReference) {
        this.ln = weakReference;
    }

    private void n(final com.byazt.ys.qg qgVar, ViewGroup viewGroup, View view, final com.byazt.dc.n nVar, final com.byazt.dc.n nVar2, final int i) {
        n((com.byazt.fq.s) qgVar.n(com.byazt.fq.s.class));
        if (i != 3) {
            HashMap map = new HashMap();
            map.put("click_type", 1);
            ((com.byazt.fq.n) qgVar.n(com.byazt.fq.n.class)).n(map);
        }
        qgVar.n(viewGroup);
        qgVar.qg(view);
        ((com.byazt.zct.n) qgVar.n(com.byazt.zct.n.class)).n(this.q);
        com.byazt.zct.n.InterfaceC0409n interfaceC0409n = new com.byazt.zct.n.InterfaceC0409n() { // from class: com.byazt.whi.q.5
            @Override // com.byazt.zct.n.InterfaceC0409n
            public void n(View view2, int i2) {
                com.byazt.de.qg.s(q.this.q != null ? q.this.q.hu() : null);
                if (qgVar instanceof com.byazt.ys.n) {
                    com.byazt.dc.n nVar3 = nVar;
                    if (nVar3 != null) {
                        nVar3.qg(view2, q.this.q);
                    }
                    com.byazt.dc.n nVar4 = nVar2;
                    if (nVar4 != null) {
                        nVar4.qg(view2, q.this.q);
                    }
                } else {
                    com.byazt.dc.n nVar5 = nVar;
                    if (nVar5 != null) {
                        nVar5.n(view2, q.this.q);
                    }
                    com.byazt.dc.n nVar6 = nVar2;
                    if (nVar6 != null) {
                        nVar6.n(view2, q.this.q);
                    }
                }
                if (i != 2 || q.this.n == null) {
                    return;
                }
                q.this.n.l(true);
            }
        };
        ((com.byazt.zct.n) qgVar.n(com.byazt.zct.n.class)).n(interfaceC0409n);
        pk pkVar = this.n;
        if (pkVar != null) {
            com.byazt.ikv.qg.qg(pkVar.ih(), interfaceC0409n, com.byazt.zct.n.InterfaceC0409n.class);
        }
    }

    public void n(int i) {
        this.cd = i;
    }

    private void qg(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        View viewS = s(viewGroup);
        if (viewS != null) {
            HashMap map = new HashMap();
            map.put("tag", "shake_compat");
            map.put("click_listener", this.ur);
            try {
                viewS.setTag(2114387349, map);
            } catch (Throwable th) {
                k.qg("ShakeUtils", "onPause error:" + th.getMessage());
                com.byazt.cd.qg.n(2114387349, th.getMessage());
            }
            this.m = viewS;
            return;
        }
        View view = new View(this.qg);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.whi.q.6
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                try {
                    if (q.this.um != null) {
                        q.this.um.qg(q.this.n != null ? q.this.n.v() : 0);
                    }
                } catch (Throwable th2) {
                    k.qg("ShakeUtils", "onPause error:" + th2.getMessage());
                }
            }
        });
        HashMap map2 = new HashMap();
        map2.put("tag", "shake_compat");
        map2.put("click_listener", this.ur);
        try {
            view.setTag(2114387349, map2);
        } catch (Throwable th2) {
            k.qg("ShakeUtils", "onPause error:" + th2.getMessage());
            com.byazt.cd.qg.n(2114387349, th2.getMessage());
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        viewGroup.addView(view);
        this.m = view;
    }

    private View s(ViewGroup viewGroup) {
        Object obj;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            Object tag = childAt.getTag();
            String string = "";
            if ((tag instanceof Map) && (obj = ((Map) tag).get("tag")) != null) {
                string = obj.toString();
            }
            if ("shake_compat".equals(string)) {
                return childAt;
            }
        }
        return null;
    }

    private cp l() {
        pk pkVar;
        cp cpVarSi;
        if (this.cd == 5 && (pkVar = this.n) != null && (cpVarSi = pkVar.si()) != null && cpVarSi.n() == 1) {
            return cpVarSi;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        cp cpVarL = l();
        if (cpVarL == null) {
            return;
        }
        final float fQg = cpVarL.qg();
        final float fS = cpVarL.s();
        if (this.um == null) {
            this.um = new ou(rv.getContext(), 1, com.byazt.vyf.s.cy().q());
        }
        this.um.qg(this.n.eu());
        this.um.n(this.n.kv());
        this.um.qg(this.n.bs());
        this.um.w(this.n.on());
        this.um.s(this.n.rk());
        this.um.n(this.n.mp());
        this.um.l(this.n.qd());
        this.um.n(new ou.n() { // from class: com.byazt.whi.q.7
            @Override // com.byazt.tk.ou.n
            public void n(int i) {
                if (i == 1 && q.this.ou && com.byazt.okk.q.n(q.this.sz)) {
                    com.byazt.cd.qg.n(q.this.k, fQg, fS, q.this.py);
                }
            }
        });
        ou ouVar = this.um;
        pk pkVar = this.n;
        ouVar.n(pkVar != null ? pkVar.v() : 0);
    }

    public void n(final com.byazt.fq.s sVar) {
        sVar.n(new com.byazt.fq.s.n() { // from class: com.byazt.whi.q.8
            @Override // com.byazt.fq.s.n
            public boolean n() {
                sVar.n(q.this.wm);
                sVar.n(q.this.x());
                sVar.n(q.this.x);
                sVar.n(q.this.rv);
                return q.this.tj.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> x() {
        NativeVideoTsView nativeVideoTsView;
        HashMap map = new HashMap();
        if (this.l != null) {
            JSONArray jSONArray = new JSONArray();
            for (View view : this.l) {
                if (view != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("width", view.getWidth());
                        jSONObject.put("height", view.getHeight());
                        jSONObject.put("alpha", view.getAlpha());
                    } catch (Throwable unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
            map.put("image_view", jSONArray.toString());
        }
        if (this.sz != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("width", this.sz.getWidth());
                jSONObject2.put("height", this.sz.getHeight());
                jSONObject2.put("alpha", this.sz.getAlpha());
            } catch (Throwable unused2) {
            }
            map.put("root_view", jSONObject2.toString());
        }
        WeakReference<NativeVideoTsView> weakReference = this.ln;
        if (weakReference != null && (nativeVideoTsView = weakReference.get()) != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("width", nativeVideoTsView.getWidth());
                jSONObject3.put("height", nativeVideoTsView.getHeight());
                jSONObject3.put("alpha", nativeVideoTsView.getAlpha());
            } catch (JSONException unused3) {
            }
            map.put("video_view", jSONObject3.toString());
        }
        return map;
    }

    private EmptyView q(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void n(AppDownloadListener appDownloadListener) {
        this.a = appDownloadListener;
    }

    public void n(View view, tj tjVar) {
        if (this.h != null) {
            this.h.n(view, tjVar);
        }
    }

    public void qg(View view, tj tjVar) {
        if (this.hu != null) {
            this.hu.n(view, tjVar);
        }
    }

    public void n(Double d) {
        this.rv = d;
    }

    public void qg() {
        n nVar;
        if (this.s != null) {
            this.s.onDestroy();
        }
        WeakReference<ViewGroup> weakReference = this.k;
        if (weakReference != null) {
            weakReference.clear();
        }
        final ViewGroup viewGroup = this.sz;
        final EmptyView emptyView = this.wm;
        if (viewGroup != null && emptyView != null) {
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.whi.q.9
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(emptyView);
                }
            });
            n nVar2 = this.an;
            if (nVar2 != null) {
                viewGroup.removeOnLayoutChangeListener(nVar2);
            }
        }
        final View view = this.m;
        if (viewGroup != null && view != null) {
            com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.whi.q.10
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(view);
                }
            });
        }
        ou ouVar = this.um;
        if (ouVar != null) {
            pk pkVar = this.n;
            ouVar.qg(pkVar != null ? pkVar.v() : 0);
        }
        pk pkVar2 = this.n;
        com.byazt.cd.s.qg(pkVar2 != null ? pkVar2.v() : 0);
        CreativeContainer creativeContainer = this.j;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(null);
        }
        int i = this.cd;
        if (i == 9 && this.sz != null && com.byazt.fr.n.q(i)) {
            com.byazt.fr.s.n().qg(this.sz.getContext(), this.n, true);
        }
        if (viewGroup != null && (nVar = this.an) != null) {
            viewGroup.removeOnLayoutChangeListener(nVar);
        }
        com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.whi.q.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.hm.qg qgVar = q.this.w;
                if (qgVar != null) {
                    qgVar.n(16);
                }
            }
        });
    }
}
