package com.byazt.ew;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.anythink.china.b.c;
import com.anythink.core.common.f.e;
import com.byazt.ho.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 101})
public class fs {
    public String a;
    public long ae;
    public long an;
    public int b;
    public int bb;
    public int bz;
    public String c;
    public boolean ca;
    public boolean cd;
    public long ci;
    public Runnable cp;
    public boolean ct;
    public int cx;
    public boolean cy;
    public final Handler d;
    public long df;
    public String dg;
    public int dh;
    public String di;
    public JSONObject dm;
    public int dn;
    public com.byazt.ew.n dw;
    public String dz;
    public boolean e;
    public String ei;
    public Context el;
    public int eq;
    public long f;
    public long fi;
    public WeakReference<View> fl;
    public final Handler fs;
    public int g;
    public String h;
    public int ha;
    public boolean hd;
    public n he;
    public long hf;
    public boolean hu;
    public w i;
    public int ic;
    public int il;
    public boolean iz;
    public long j;
    public boolean jh;
    public String ju;
    public qg k;
    public JSONObject kc;
    public final String l;
    public int la;
    public String lg;
    public long lh;
    public long ln;
    public int lq;
    public ViewTreeObserver.OnGlobalLayoutListener lr;
    public boolean m;
    public String mz;
    public final String n;
    public int nf;
    public float nk;
    public JSONObject np;
    public float o;
    public Runnable oa;
    public String of;
    public String oj;
    public boolean oo;
    public boolean ou;
    public int ox;
    public String pe;
    public String pk;
    public String py;
    public final String q;
    public final String qg;
    public int qh;
    public int qn;
    public String r;
    public int rf;
    public int ri;
    public Runnable rv;
    public JSONObject ry;
    public final String s;
    public int sh;
    public String sq;
    public s su;
    public Runnable sz;
    public long t;
    public String ta;
    public int ti;
    public Runnable tj;
    public boolean tr;
    public String u;
    public Set<String> um;
    public long ur;
    public long v;
    public com.byazt.uad.q vb;
    public float vo;
    public final String w;
    public List<JSONObject> wf;
    public boolean wm;
    public int wo;
    public String wv;
    public final String x;
    public boolean xb;
    public int xd;
    public Map<String, String> xi;
    public boolean y;
    public int yw;
    public int z;
    public int ze;

    public enum n {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    public String an() {
        return "function playable_callJS(){return \"Android调用了JS的callJS方法\";}";
    }

    public static /* synthetic */ int d(fs fsVar) {
        int i = fsVar.wo;
        fsVar.wo = i + 1;
        return i;
    }

    public static /* synthetic */ int oa(fs fsVar) {
        int i = fsVar.sh;
        fsVar.sh = i + 1;
        return i;
    }

    private fs(Context context, com.byazt.uad.q qVar, s sVar, com.byazt.ew.n nVar, n nVar2, boolean z) {
        this.w = "playable_stuck_check_ping";
        this.x = "playable_apply_media_permission_callback";
        this.fs = new Handler(Looper.getMainLooper());
        this.d = new Handler(Looper.getMainLooper());
        this.cy = true;
        this.hd = true;
        this.cd = true;
        this.n = "PL_sdk_playable_global_viewable";
        this.qg = "PL_sdk_page_screen_blank";
        this.s = "PL_sdk_playable_destroy_analyze_summary";
        this.q = "PL_sdk_playable_hardware_dialog_cancel";
        this.l = "PL_sdk_playable_hardware_dialog_setting";
        this.um = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.a = null;
        this.py = com.byazt.wg.qg.AD_TAG_FEED;
        this.ou = true;
        this.wm = true;
        this.m = true;
        this.hu = false;
        this.h = "";
        this.t = 10L;
        this.ur = 10L;
        this.bb = 700;
        this.ln = 0L;
        this.lh = 0L;
        this.v = -1L;
        this.j = -1L;
        this.an = -1L;
        this.ae = -1L;
        this.f = -1L;
        this.fi = -1L;
        this.df = -1L;
        this.oj = "";
        this.dg = "";
        this.u = "";
        this.pk = "";
        this.wo = 0;
        this.sh = 0;
        this.y = false;
        this.rf = 0;
        this.dh = -1;
        this.b = 0;
        this.ri = 0;
        this.nf = 0;
        this.pe = null;
        this.e = false;
        this.yw = 0;
        this.cx = 0;
        this.lq = 0;
        this.ic = 0;
        this.ci = 0L;
        this.hf = 0L;
        this.z = -2;
        this.dn = 0;
        this.ha = 0;
        this.g = 0;
        this.ry = new JSONObject();
        this.xi = new HashMap();
        this.np = new JSONObject();
        this.ei = "";
        this.vo = 0.0f;
        this.o = 0.0f;
        this.ct = false;
        this.iz = false;
        this.oo = false;
        this.wf = new ArrayList();
        this.lr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.ew.fs.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) fs.this.fl.get();
                    if (view == null) {
                        return;
                    }
                    fs.this.qg(view);
                } catch (Throwable th) {
                    x.n("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.z = 0;
        this.he = nVar2;
        this.vb = qVar;
        rv.n(qVar);
        if (!z) {
            n(qVar.getView());
        }
        n(context, sVar, nVar);
    }

    private fs(Context context, com.byazt.uad.q qVar, s sVar, com.byazt.ew.n nVar, Set<String> set, n nVar2, boolean z) {
        this(context, qVar, sVar, nVar, nVar2, z);
        this.um = set;
    }

    private void n(Context context, s sVar, com.byazt.ew.n nVar) {
        this.a = UUID.randomUUID().toString();
        this.el = context;
        this.dw = nVar;
        this.su = sVar;
        tj.n(nVar);
        this.i = new w(this);
        ae();
    }

    private void ae() {
        this.k = new qg(this, this.bb);
        this.rv = new Runnable() { // from class: com.byazt.ew.fs.3
            @Override // java.lang.Runnable
            public void run() {
                if (fs.this.wm) {
                    fs.this.wm = false;
                    fs.this.fs.removeCallbacks(fs.this.tj);
                    fs.this.n(2, "容器加载超时");
                }
            }
        };
        this.tj = new Runnable() { // from class: com.byazt.ew.fs.4
            @Override // java.lang.Runnable
            public void run() {
                if (fs.this.wm) {
                    fs.this.wm = false;
                    fs.this.fs.removeCallbacks(fs.this.rv);
                    fs.this.n(3, "JSSDK加载超时");
                }
            }
        };
        this.oa = new Runnable() { // from class: com.byazt.ew.fs.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (fs.this.vb != null) {
                    fs.this.vb.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.byazt.ew.fs.5.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (fs.this.k != null) {
                                fs.this.k.n(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (fs.this.d != null) {
                    fs.this.d.postDelayed(this, 500L);
                }
            }
        };
        this.sz = new Runnable() { // from class: com.byazt.ew.fs.6
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                fs.this.n("playable_stuck_check_ping", new JSONObject());
                if (fs.this.d != null) {
                    fs.this.d.postDelayed(this, 500L);
                }
            }
        };
        this.cp = new Runnable() { // from class: com.byazt.ew.fs.7
            @Override // java.lang.Runnable
            public void run() {
                if (fs.this.hf <= 0) {
                    fs.this.qg(1, "点击热区卡死");
                } else {
                    if (fs.this.hf - fs.this.ci <= fs.this.bb) {
                        fs.this.ln();
                        fs.this.ci = 0L;
                        fs.this.hf = 0L;
                        return;
                    }
                    fs.this.qg(1, "点击热区卡死");
                }
            }
        };
    }

    private boolean tj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public void n(View view) {
        if (view == null) {
            return;
        }
        try {
            this.fl = new WeakReference<>(view);
            qg(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.lr);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.ha == view.getWidth() && this.g == view.getHeight()) {
                return;
            }
            this.ha = view.getWidth();
            this.g = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.ha);
            jSONObject.put("height", this.g);
            n("resize", jSONObject);
            this.ry = jSONObject;
        } catch (Throwable th) {
            x.n("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public Context getContext() {
        return this.el;
    }

    public fs n(String str, String str2) {
        this.xi.put(str, str2);
        return this;
    }

    public Map<String, String> n() {
        return this.xi;
    }

    public fs n(String str) {
        this.ju = str;
        return this;
    }

    public fs qg(String str) {
        this.ta = str;
        return this;
    }

    public JSONObject qg() {
        return this.dm;
    }

    public String s() {
        return this.ta;
    }

    public String q() {
        return this.ju;
    }

    public fs s(String str) {
        this.wv = str;
        return this;
    }

    public String l() {
        return this.wv;
    }

    public fs q(String str) {
        this.lg = str;
        return this;
    }

    public String w() {
        return this.lg;
    }

    public fs n(boolean z) {
        this.jh = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.jh);
            n("volumeChange", jSONObject);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public boolean x() {
        return this.jh;
    }

    public fs n(long j) {
        if (j <= 0) {
            this.t = 10L;
        } else {
            this.t = j;
        }
        return this;
    }

    public fs qg(long j) {
        if (j <= 0) {
            this.ur = 10L;
        } else {
            this.ur = j;
        }
        return this;
    }

    public fs qg(boolean z) {
        if (this.xb == z) {
            return this;
        }
        this.xb = z;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.xb) {
                jSONObject.put("playable_background_show_type", this.cx);
            }
        } catch (JSONException unused) {
        }
        s(this.xb ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.j == -1 && this.xb) {
            this.j = System.currentTimeMillis();
            s("PL_sdk_page_show", (JSONObject) null);
        }
        if (this.j != -1 && !this.xb && !this.ct) {
            this.ct = true;
        }
        if (this.xb) {
            this.v = System.currentTimeMillis();
        } else if (this.v != -1) {
            this.ln += System.currentTimeMillis() - this.v;
            this.v = -1L;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("viewStatus", this.xb);
            n("viewableChange", jSONObject2);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "setViewable error", th);
        }
        if (this.xb) {
            ln();
        } else {
            lh();
        }
        return this;
    }

    public boolean fs() {
        return this.xb;
    }

    public fs s(boolean z) {
        if (this.ca == z) {
            return this;
        }
        this.ca = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ca);
            n("change_playable_click", jSONObject);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public JSONObject rv() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ca);
            return jSONObject;
        } catch (Throwable th) {
            x.n("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public Set<String> tj() {
        Set<String> setN = this.i.n();
        Set<String> set = this.um;
        if (set == null || set.size() <= 0) {
            return setN;
        }
        HashSet hashSet = new HashSet();
        for (String str : setN) {
            if (!this.um.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public JSONObject cp() {
        try {
            boolean zN = l.n(this.el, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zN);
            return jSONObject;
        } catch (Throwable th) {
            x.n("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject d() {
        try {
            boolean zN = l.n(this.el, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zN);
            return jSONObject;
        } catch (Throwable th) {
            x.n("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject oa() {
        boolean zN;
        boolean zN2;
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 33) {
                zN = l.n(this.el, "android.permission.READ_MEDIA_IMAGES");
                zN2 = true;
            } else {
                zN = l.n(this.el, "android.permission.READ_EXTERNAL_STORAGE");
                zN2 = l.n(this.el, c.b);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", zN);
            jSONObject.put("isHasWrite", zN2);
            if (!zN || !zN2) {
                z = false;
            }
            jSONObject.put("result", z);
            return jSONObject;
        } catch (Throwable th) {
            x.n("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public void n(JSONObject jSONObject) {
        if (this.dw != null) {
            k();
        }
    }

    public void qg(JSONObject jSONObject) {
        int iOptInt = 0;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("resource_type", 0);
            l.s = jSONObject.optInt("video_min_duration", 1);
            l.q = jSONObject.optInt("video_max_duration", 20);
            l.l = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        if (this.dw != null) {
            n(iOptInt);
        }
    }

    public void s(JSONObject jSONObject) {
        com.byazt.ew.n nVar = this.dw;
        if (nVar == null || nVar.n(jSONObject) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        int iOptInt = jSONObject.optInt("resource_type", -1);
        String strOptString2 = jSONObject.optString("resource_name", "playable_media");
        if (iOptInt == 1) {
            qg(strOptString2, strOptString);
        } else if (iOptInt == 2) {
            s(strOptString2, strOptString);
        }
    }

    public void q(JSONObject jSONObject) {
        if (this.dw != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject sz() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.he.ordinal());
            jSONObject.put("safe_area_top_height", this.vo);
            jSONObject.put("safe_area_bottom_height", this.o);
            jSONObject.put("playable_enter_from", this.ri);
            jSONObject.put("playable_retry_count", this.b);
            jSONObject.put("playable_card_session", this.oj);
            jSONObject.put("playable_video_session", this.dg);
            jSONObject.put("playable_network_type", cy());
            jSONObject.put("aweme_id", this.pk);
            return jSONObject;
        } catch (Throwable th) {
            x.n("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public Intent k() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File fileN = l.n();
        if (fileN == null) {
            return null;
        }
        intent.putExtra("output", FileProvider.getUriForFile(this.el, this.el.getPackageName() + ".playable.fileProvider", fileN));
        return intent;
    }

    public Intent n(int i) {
        Intent intent = new Intent("android.intent.action.PICK");
        if (i == 0) {
            intent.setType("*/*");
        } else if (i == 1) {
            intent.setType("image/*");
        } else if (i == 2) {
            intent.setType("video/mp4");
        } else {
            intent.setType("*/*");
        }
        return intent;
    }

    public void n(String str, JSONObject jSONObject) {
        s sVar = this.su;
        if (sVar != null) {
            sVar.n(str, jSONObject);
        }
    }

    public void qg(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.el, "照片保存失败", 0).show();
            return;
        }
        Bitmap bitmapQg = l.qg(str2);
        if (bitmapQg != null) {
            MediaStore.Images.Media.insertImage(this.el.getContentResolver(), bitmapQg, str, "");
            Toast.makeText(this.el, "照片已保存到相册", 0).show();
        } else {
            Toast.makeText(this.el, "照片保存失败", 0).show();
        }
    }

    public void s(String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.el, "视频保存失败", 0).show();
            return;
        }
        File fileN = l.n(str, str2);
        if (fileN == null || !fileN.exists()) {
            Toast.makeText(this.el, "视频保存失败", 0).show();
            return;
        }
        Uri uriFromFile = Uri.fromFile(fileN);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uriFromFile);
        this.el.sendBroadcast(intent);
        Toast.makeText(this.el, "视频已保存到相册", 0).show();
    }

    public String cy() {
        com.byazt.ew.n nVar;
        if (TextUtils.isEmpty(this.u) && (nVar = this.dw) != null) {
            this.u = nVar.q().toString();
        }
        return this.u;
    }

    public com.byazt.ew.n hd() {
        return this.dw;
    }

    public JSONObject cd() {
        if (this.ry.isNull("width")) {
            View view = this.fl.get();
            if (view == null) {
                return this.ry;
            }
            qg(view);
        }
        return this.ry;
    }

    public JSONObject um() {
        return this.np;
    }

    public fs l(JSONObject jSONObject) {
        this.np = jSONObject;
        return this;
    }

    public fs l(String str) {
        int iIndexOf;
        String strDecode;
        this.ei = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(scheme)) {
                qg(0);
                if (str != null && (iIndexOf = str.indexOf("?")) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            } else {
                String host = uri.getHost();
                if ("webview".equalsIgnoreCase(host) || (host != null && host.contains("webview"))) {
                    qg(0);
                    String queryParameter = uri.getQueryParameter(ImagesContract.URL);
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf("?");
                        str = iIndexOf2 != -1 ? strDecode.substring(0, iIndexOf2) : strDecode;
                    }
                } else if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.z == -1) {
                        qg(2);
                    } else {
                        qg(1);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.r = str;
        return this;
    }

    public fs qg(int i) {
        this.z = i;
        return this;
    }

    public fs q(boolean z) {
        this.m = z;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.nk);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.ze);
            jSONObject2.put("height", this.qn);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(com.byazt.af.x.n, this.il);
            jSONObject3.put("y", this.bz);
            jSONObject3.put("width", this.la);
            jSONObject3.put("height", this.qh);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(com.byazt.af.x.n, this.ox);
            jSONObject4.put("y", this.eq);
            jSONObject4.put("width", this.xd);
            jSONObject4.put("height", this.ti);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void py() {
        com.byazt.ew.n nVar = this.dw;
        if (nVar != null) {
            nVar.n();
        }
    }

    public void ou() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.f);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.an > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.an;
                this.df = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            s("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void w(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.pe = jSONObject.optString("section");
        }
    }

    public void wm() {
        this.dh = 2;
    }

    public void m() {
        this.e = true;
    }

    public void hu() {
        if (this.dw != null) {
            n nVar = n.FEED_AWEME;
        }
    }

    public void h() {
        if (this.dw != null) {
            n nVar = n.FEED_AWEME;
        }
    }

    public void x(JSONObject jSONObject) {
        this.kc = jSONObject;
        this.nf++;
        lh();
        this.fs.removeCallbacks(this.cp);
        if (this.m) {
            this.fi = System.currentTimeMillis();
            this.ci = System.currentTimeMillis();
            this.hf = 0L;
            int i = this.z;
            if (i == 0) {
                com.byazt.uad.q qVar = this.vb;
                if (qVar != null) {
                    qVar.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.byazt.ew.fs.8
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            fs.this.hf = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i == 1 || i == 2) {
                n("playable_stuck_check_ping", new JSONObject());
            }
            this.fs.postDelayed(this.cp, this.bb);
        }
    }

    public void t() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.f);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.an > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.an);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            s("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void fs(JSONObject jSONObject) {
        qg(2, jSONObject != null ? jSONObject.optString("error_msg", "素材直接调用端上异常兜底蒙层") : "素材直接调用端上异常兜底蒙层");
    }

    public void ur() {
        qg qgVar;
        this.hf = System.currentTimeMillis();
        int i = this.z;
        if ((i == 1 || i == 2) && (qgVar = this.k) != null) {
            qgVar.n(System.currentTimeMillis());
        }
    }

    public JSONObject rv(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            return cp();
        }
        if (iOptInt != 2) {
            return iOptInt != 3 ? jSONObject2 : oa();
        }
        return d();
    }

    public JSONObject tj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (iOptInt == 1) {
                jSONObject2.put("result", l.qg(this.el, "android.permission.RECORD_AUDIO"));
            } else {
                if (iOptInt != 2) {
                    if (iOptInt == 3) {
                        jSONObject2.put("result", l.n(this.el));
                    }
                    return jSONObject2;
                }
                jSONObject2.put("result", l.qg(this.el, "android.permission.CAMERA"));
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void w(String str) {
        int i;
        int i2;
        this.dn = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.an = jCurrentTimeMillis;
            long j = this.j;
            jSONObject.put("playable_page_show_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        s("PL_sdk_html_load_start", jSONObject);
        if (this.ou && ((i = this.z) == 0 || i == 1 || i == 2)) {
            this.fs.postDelayed(this.rv, this.t * 1000);
            if (tj(this.r) || (i2 = this.z) == 1 || i2 == 2) {
                this.fs.postDelayed(this.tj, this.ur * 1000);
            }
            this.ou = false;
        }
        if (this.hd) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (l.n(this.el, l.d)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (l.qg(this.el, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (l.n(this.el, l.cp)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (l.n(this.el, l.tj)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (l.n(this.el, l.rv)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (l.n(this.el, l.fs)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (l.qg(this.el, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (l.n(this.el, l.x)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (l.n(this.el)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                s("PL_sdk_hardware_detect", jSONObject2);
                this.hd = false;
            } catch (Throwable th2) {
                x.n("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public void x(String str) {
        com.byazt.uad.q qVar;
        this.dn = 2;
        this.mz = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.ae = jCurrentTimeMillis;
            long j = this.an;
            jSONObject.put("playable_html_load_start_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        s("PL_sdk_html_load_finish", jSONObject);
        this.fs.removeCallbacks(this.rv);
        try {
            if (this.z == 0) {
                if (this.cy && (qVar = this.vb) != null) {
                    this.cy = false;
                    qVar.evaluateJavascript(an(), new ValueCallback<String>() { // from class: com.byazt.ew.fs.9
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                ln();
            }
        } catch (Throwable th2) {
            x.n("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public void bb() {
        this.fs.removeCallbacks(this.rv);
        this.fs.removeCallbacks(this.tj);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.an > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.an);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            s("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void cp(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("success", true);
            if (zOptBoolean) {
                this.dn = 3;
                ln();
            } else {
                this.dn = -2;
            }
            if (zOptBoolean || !this.wm) {
                return;
            }
            this.wm = false;
            this.fs.removeCallbacks(this.rv);
            this.fs.removeCallbacks(this.tj);
            n(4, "素材渲染失败");
        }
    }

    private void s(int i, String str) {
        com.byazt.ew.n nVar = this.dw;
        if (nVar != null) {
            nVar.n(i, str);
        }
    }

    public void n(int i, String str) {
        lh();
        s(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "reportRenderFatal error", th);
        }
        s("PL_sdk_global_faild", jSONObject);
    }

    public void qg(int i, String str) {
        this.dh = i;
        if (this.kc == null) {
            this.kc = new JSONObject();
        }
        try {
            this.kc.put("playable_stuck_type", i);
            this.kc.put("playable_stuck_reason", str);
            if (this.fi > 0) {
                this.kc.put("playable_stuck_duration", System.currentTimeMillis() - this.fi);
            } else {
                this.kc.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        s("PL_sdk_page_stuck", this.kc);
        lh();
        if (this.dw == null || i != 2) {
            return;
        }
        this.kc = new JSONObject();
    }

    public void qg(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        l(str, jSONObject);
    }

    private String q(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.sq) && !TextUtils.isEmpty(this.ei)) {
            Uri uri = Uri.parse(this.ei);
            String host = uri.getHost();
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                queryParameter = uri.getQueryParameter("surl");
                queryParameter2 = uri.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
                queryParameter2 = "";
            }
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(uri.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                builderAppendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.sq = builderAppendQueryParameter.toString();
        }
        return this.sq;
    }

    private String l(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.r = str3;
        return str3;
    }

    private void f() {
        String str;
        if (this.np == null || (str = this.r) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.np.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        String host = Uri.parse(this.r).getHost();
        if (TextUtils.isEmpty(host)) {
            this.r += "/cid_" + strOptString;
        } else {
            this.r = this.r.replace(host, host + "/cid_" + strOptString);
        }
    }

    private void l(String str, JSONObject jSONObject) {
        try {
            int i = this.z;
            if (i == 0) {
                if (this.he != n.LAND_PAGE && !tj(this.r)) {
                    f();
                }
                jSONObject.put("playable_url", this.r);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", l(this.c, this.di));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", q(this.of, this.dz));
            }
            jSONObject.put("playable_render_type", this.z);
            if (this.dw != null && this.z == 0 && this.he == n.LAND_PAGE) {
                tj(this.r);
            }
        } catch (JSONException unused) {
        }
    }

    public void s(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.y && this.sh > 0) {
                this.y = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.xb);
            jSONObject.put("playable_session_id", this.a);
            int i = this.z;
            if (i == 0) {
                if (this.he != n.LAND_PAGE && !tj(this.r)) {
                    f();
                }
                jSONObject.put("playable_url", this.r);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", l(this.c, this.di));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", q(this.of, this.dz));
            }
            jSONObject.put("playable_full_url", this.ei);
            jSONObject.put("playable_replay_count", this.rf);
            jSONObject.put("playable_is_prerender", this.tr);
            jSONObject.put("playable_is_preload", this.y);
            jSONObject.put("playable_render_type", this.z);
            jSONObject.put("playable_scenes_type", this.he.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.of) ? "" : this.of);
            if (!TextUtils.isEmpty(this.dz)) {
                str2 = this.dz;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.c);
            jSONObject.put("playable_minigamelite_schema", this.di);
            jSONObject.put("playable_is_debug", this.iz);
            jSONObject.put("playable_retry_count", this.b);
            jSONObject.put("playable_enter_from", this.ri);
            jSONObject.put("playable_sequence", this.nf);
            jSONObject.put("playable_current_section", this.pe);
            jSONObject.put("is_playable_finish", this.e);
            jSONObject.put("playable_card_session", this.oj);
            jSONObject.put("playable_video_session", this.dg);
            jSONObject.put("playable_network_type", cy());
            jSONObject.put("playable_lynx_version", this.h);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            jSONObject2.put("tag", this.py);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", BaseConstants.CATEGORY_UMENG);
            jSONObject2.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put(e.a.d, this.np.opt("cid"));
            jSONObject2.put("log_extra", this.np.opt("log_extra"));
            int i2 = this.z;
            if (i2 != -1 && i2 != -2) {
                if (this.dw != null) {
                    List<JSONObject> list = this.wf;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.wf.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.z);
                                jSONObjectOptJSONObject.put("playable_url", this.r);
                            }
                        }
                        this.wf.clear();
                    }
                    if (this.z == 0 && this.he == n.LAND_PAGE) {
                        tj(this.r);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.wf == null) {
                this.wf = new ArrayList();
            }
            this.wf.add(jSONObject2);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void fs(String str) {
        this.fs.post(new Runnable() { // from class: com.byazt.ew.fs.10
            @Override // java.lang.Runnable
            public void run() {
                fs.d(fs.this);
            }
        });
    }

    public void rv(String str) {
        this.fs.post(new Runnable() { // from class: com.byazt.ew.fs.2
            @Override // java.lang.Runnable
            public void run() {
                fs.oa(fs.this);
            }
        });
    }

    public void ln() {
        if (this.m) {
            this.fi = System.currentTimeMillis();
            if (this.he == n.FEED_AWEME) {
                if (this.xb && this.dn == 3) {
                    qg qgVar = this.k;
                    if (qgVar != null && qgVar.qg()) {
                        fi();
                        return;
                    } else {
                        if (this.k == null) {
                            this.k = new qg(this, this.bb);
                            fi();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.xb && this.dn == 2) {
                qg qgVar2 = this.k;
                if (qgVar2 != null && qgVar2.qg()) {
                    fi();
                } else if (this.k == null) {
                    this.k = new qg(this, this.bb);
                    fi();
                }
            }
        }
    }

    private void fi() {
        Runnable runnable;
        Runnable runnable2;
        this.k.n(System.currentTimeMillis());
        Handler handler = this.d;
        if (handler != null) {
            int i = this.z;
            if (i == 0 && (runnable2 = this.oa) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.sz) != null) {
                handler.post(runnable);
            }
            this.k.n(500);
        }
    }

    public void lh() {
        try {
            qg qgVar = this.k;
            if (qgVar != null) {
                qgVar.n();
            }
            Handler handler = this.d;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused) {
        }
    }

    public void v() {
        this.ha = 0;
        this.g = 0;
        this.nk = 0.0f;
        this.ze = 0;
        this.qn = 0;
        this.bz = 0;
        this.il = 0;
        this.la = 0;
        this.qh = 0;
        this.eq = 0;
        this.ox = 0;
        this.xd = 0;
        this.ti = 0;
    }

    public void j() {
        if (this.oo) {
            return;
        }
        this.oo = true;
        this.lh = 0L;
        this.hd = true;
        v();
        try {
            View view = this.fl.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.lr);
            }
        } catch (Throwable unused) {
        }
        try {
            this.i.qg();
        } catch (Throwable unused2) {
        }
        try {
            qg qgVar = this.k;
            if (qgVar != null) {
                qgVar.n();
                this.k = null;
            }
            Handler handler = this.d;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.r)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.wo);
                jSONObject.put("playable_hit_times", this.sh);
                int i = this.wo;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.sh) / (((double) i) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                s("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (!TextUtils.isEmpty(this.r)) {
                if (this.v != -1) {
                    this.ln += System.currentTimeMillis() - this.v;
                    this.v = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.ln);
                s("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused5) {
        }
        this.fs.removeCallbacks(this.rv);
        this.fs.removeCallbacks(this.tj);
        this.fs.removeCallbacksAndMessages(null);
    }

    public void n(int i, String str, String str2) {
        this.dn = -1;
        this.mz = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            x.n("PlayablePlugin", "onWebReceivedError error", th);
        }
        s("PL_sdk_html_load_error", jSONObject);
        if (this.wm) {
            this.wm = false;
            this.fs.removeCallbacks(this.rv);
            this.fs.removeCallbacks(this.tj);
            n(1, "容器加载失败");
        }
    }

    public void n(boolean z, String str, int i) {
        if (z) {
            this.dn = -1;
            this.mz = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                x.n("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            s("PL_sdk_html_load_error", jSONObject);
            if (this.wm) {
                this.wm = false;
                this.fs.removeCallbacks(this.rv);
                this.fs.removeCallbacks(this.tj);
                n(1, "容器加载失败");
            }
        }
    }

    public JSONObject q(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        JSONObject jSONObjectN = this.i.n(str, jSONObject);
        if (x.n()) {
            System.currentTimeMillis();
        }
        return jSONObjectN;
    }

    public static fs n(Context context, com.byazt.uad.q qVar, s sVar, com.byazt.ew.n nVar, Set<String> set, n nVar2, boolean z) {
        if (qVar == null || sVar == null || nVar == null) {
            return null;
        }
        return new fs(context, qVar, sVar, nVar, set, nVar2, z);
    }
}
