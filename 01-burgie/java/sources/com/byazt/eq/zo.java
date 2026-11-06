package com.byazt.eq;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
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
@com.byazt.vzx.pr(pr = {0, 1, 661, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public String a;
    public Context aa;
    public String ag;
    public Runnable aj;
    public String b;
    public ViewTreeObserver.OnGlobalLayoutListener bg;
    public hn bh;
    public int bm;
    public final String c;
    public WeakReference<View> cr;
    public String cz;
    public JSONObject d;
    public long e;
    public String eh;
    public long er;
    public int ey;
    public int f;
    public String fe;
    public boolean fo;
    public int fs;
    public final String fw;
    public Runnable g;
    public String gg;
    public long gu;
    public int gz;
    public int h;
    public boolean hg;
    public final String hn;
    public hw ho;
    public boolean hs;
    public final String hw;
    public int i;
    public int ie;
    public String ii;
    public long iu;
    public com.byazt.son.x iy;
    public uc j;
    public String jn;
    public int jw;
    public final Handler k;
    public String kl;
    public JSONObject ks;
    public int ku;
    public boolean l;
    public boolean lb;
    public int lj;
    public long ls;
    public int lv;
    public Runnable m;
    public String mr;
    public int mw;
    public long n;
    public Map<String, String> na;
    public long nl;
    public String np;
    public boolean nt;
    public int nw;
    public boolean ny;
    public int o;
    public int od;
    public String of;
    public int oj;
    public boolean om;
    public int p;
    public int pj;
    public boolean pp;
    public int pq;
    public final String pr;
    public List<JSONObject> q;
    public Set<String> qa;
    public String qi;
    public String qn;
    public com.byazt.eq.pr qo;
    public JSONObject qv;
    public String qx;
    public int r;
    public boolean rc;
    public JSONObject rk;
    public long s;
    public float sr;
    public String su;
    public long sv;
    public int sx;
    public int t;
    public boolean tv;
    public String u;
    public final String uc;
    public int uk;
    public long v;
    public long ve;
    public int vj;
    public Runnable vk;
    public boolean vv;
    public Runnable w;
    public boolean wm;
    public boolean wo;
    public pr wt;
    public long ww;
    public float wz;
    public final String x;
    public float xb;
    public int xg;
    public String xi;
    public long y;
    public boolean yb;
    public String yj;
    public boolean z;
    public final Handler zo;

    public enum pr {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    public static /* synthetic */ int k(zo zoVar) {
        int i = zoVar.i;
        zoVar.i = i + 1;
        return i;
    }

    public static /* synthetic */ int m(zo zoVar) {
        int i = zoVar.r;
        zoVar.r = i + 1;
        return i;
    }

    private zo(Context context, com.byazt.son.x xVar, hn hnVar, com.byazt.eq.pr prVar, pr prVar2, boolean z) {
        this.uc = "playable_stuck_check_ping";
        this.fw = "playable_apply_media_permission_callback";
        this.zo = new Handler(Looper.getMainLooper());
        this.k = new Handler(Looper.getMainLooper());
        this.nt = true;
        this.yb = true;
        this.lb = true;
        this.pr = "PL_sdk_playable_global_viewable";
        this.hw = "PL_sdk_page_screen_blank";
        this.hn = "PL_sdk_playable_destroy_analyze_summary";
        this.x = "PL_sdk_playable_hardware_dialog_cancel";
        this.c = "PL_sdk_playable_hardware_dialog_setting";
        this.qa = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.a = null;
        this.cz = com.byazt.pfl.hw.AD_TAG_FEED;
        this.ny = true;
        this.fo = true;
        this.rc = true;
        this.z = false;
        this.b = "";
        this.iu = 10L;
        this.ve = 10L;
        this.gz = 700;
        this.nl = 0L;
        this.y = 0L;
        this.ww = -1L;
        this.n = -1L;
        this.e = -1L;
        this.s = -1L;
        this.ls = -1L;
        this.er = -1L;
        this.v = -1L;
        this.qi = "";
        this.qn = "";
        this.of = "";
        this.ii = "";
        this.i = 0;
        this.r = 0;
        this.hs = false;
        this.nw = 0;
        this.ie = -1;
        this.o = 0;
        this.f = 0;
        this.bm = 0;
        this.jn = null;
        this.l = false;
        this.lv = 0;
        this.od = 0;
        this.vj = 0;
        this.mw = 0;
        this.sv = 0L;
        this.gu = 0L;
        this.pq = -2;
        this.jw = 0;
        this.pj = 0;
        this.ey = 0;
        this.qv = new JSONObject();
        this.na = new HashMap();
        this.rk = new JSONObject();
        this.fe = "";
        this.sr = 0.0f;
        this.wz = 0.0f;
        this.om = false;
        this.hg = false;
        this.pp = false;
        this.q = new ArrayList();
        this.bg = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.eq.zo.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) zo.this.cr.get();
                    if (view != null) {
                        zo.this.hw(view);
                    }
                } catch (Throwable th) {
                    fw.pr("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.pq = 0;
        this.wt = prVar2;
        this.iy = xVar;
        aj.pr(xVar);
        if (!z) {
            pr(xVar.getView());
        }
        pr(context, hnVar, prVar);
    }

    private zo(Context context, com.byazt.son.x xVar, hn hnVar, com.byazt.eq.pr prVar, Set<String> set, pr prVar2, boolean z) {
        this(context, xVar, hnVar, prVar, prVar2, z);
        this.qa = set;
    }

    private void pr(Context context, hn hnVar, com.byazt.eq.pr prVar) {
        this.a = UUID.randomUUID().toString();
        this.aa = context;
        this.qo = prVar;
        this.bh = hnVar;
        vk.pr(prVar);
        this.j = new uc(this);
        s();
    }

    private void s() {
        this.ho = new hw(this, this.gz);
        this.aj = new Runnable() { // from class: com.byazt.eq.zo.3
            @Override // java.lang.Runnable
            public void run() {
                if (zo.this.fo) {
                    zo.this.fo = false;
                    zo.this.zo.removeCallbacks(zo.this.vk);
                    zo.this.pr(2, "容器加载超时");
                }
            }
        };
        this.vk = new Runnable() { // from class: com.byazt.eq.zo.4
            @Override // java.lang.Runnable
            public void run() {
                if (zo.this.fo) {
                    zo.this.fo = false;
                    zo.this.zo.removeCallbacks(zo.this.aj);
                    zo.this.pr(3, "JSSDK加载超时");
                }
            }
        };
        this.m = new Runnable() { // from class: com.byazt.eq.zo.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (Build.VERSION.SDK_INT >= 19 && zo.this.iy != null) {
                    zo.this.iy.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.byazt.eq.zo.5.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (zo.this.ho != null) {
                                zo.this.ho.pr(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (zo.this.k != null) {
                    zo.this.k.postDelayed(this, 500L);
                }
            }
        };
        this.g = new Runnable() { // from class: com.byazt.eq.zo.6
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                zo.this.pr("playable_stuck_check_ping", new JSONObject());
                if (zo.this.k != null) {
                    zo.this.k.postDelayed(this, 500L);
                }
            }
        };
        this.w = new Runnable() { // from class: com.byazt.eq.zo.7
            @Override // java.lang.Runnable
            public void run() {
                if (zo.this.gu <= 0) {
                    zo.this.hw(1, "点击热区卡死");
                } else {
                    if (zo.this.gu - zo.this.sv <= zo.this.gz) {
                        zo.this.nl();
                        zo.this.sv = 0L;
                        zo.this.gu = 0L;
                        return;
                    }
                    zo.this.hw(1, "点击热区卡死");
                }
            }
        };
    }

    private boolean vk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/")) {
            return true;
        }
        return false;
    }

    public void pr(View view) {
        if (view == null) {
            return;
        }
        try {
            this.cr = new WeakReference<>(view);
            hw(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.bg);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.pj == view.getWidth() && this.ey == view.getHeight()) {
                return;
            }
            this.pj = view.getWidth();
            this.ey = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.pj);
            jSONObject.put("height", this.ey);
            pr("resize", jSONObject);
            this.qv = jSONObject;
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public Context getContext() {
        return this.aa;
    }

    public zo pr(String str, String str2) {
        this.na.put(str, str2);
        return this;
    }

    public Map<String, String> pr() {
        return this.na;
    }

    public zo pr(String str) {
        this.u = str;
        return this;
    }

    public zo hw(String str) {
        this.np = str;
        return this;
    }

    public JSONObject hw() {
        return this.ks;
    }

    public String hn() {
        return this.np;
    }

    public String x() {
        return this.u;
    }

    public zo hn(String str) {
        this.eh = str;
        return this;
    }

    public String c() {
        return this.eh;
    }

    public zo x(String str) {
        this.yj = str;
        return this;
    }

    public String uc() {
        return this.yj;
    }

    public zo pr(boolean z) {
        this.vv = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.vv);
            pr("volumeChange", jSONObject);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public boolean fw() {
        return this.vv;
    }

    public zo pr(long j) {
        if (j <= 0) {
            this.iu = 10L;
        } else {
            this.iu = j;
        }
        return this;
    }

    public zo hw(long j) {
        if (j <= 0) {
            this.ve = 10L;
        } else {
            this.ve = j;
        }
        return this;
    }

    public zo hw(boolean z) {
        if (this.tv == z) {
            return this;
        }
        this.tv = z;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.tv) {
                jSONObject.put("playable_background_show_type", this.od);
            }
        } catch (JSONException e) {
        }
        hn(this.tv ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.n == -1 && this.tv) {
            this.n = System.currentTimeMillis();
            hn("PL_sdk_page_show", (JSONObject) null);
        }
        if (this.n != -1 && !this.tv && !this.om) {
            this.om = true;
        }
        if (this.tv) {
            this.ww = System.currentTimeMillis();
        } else if (this.ww != -1) {
            this.nl += System.currentTimeMillis() - this.ww;
            this.ww = -1L;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("viewStatus", this.tv);
            pr("viewableChange", jSONObject2);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "setViewable error", th);
        }
        if (this.tv) {
            nl();
        } else {
            y();
        }
        return this;
    }

    public boolean zo() {
        return this.tv;
    }

    public zo hn(boolean z) {
        this.wm = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.wm);
            pr("change_playable_click", jSONObject);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public JSONObject aj() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.wm);
            return jSONObject;
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public Set<String> vk() {
        Set<String> setPr = this.j.pr();
        Set<String> set = this.qa;
        if (set != null && set.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : setPr) {
                if (!this.qa.contains(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        }
        return setPr;
    }

    public JSONObject w() {
        try {
            boolean zPr = c.pr(this.aa, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zPr);
            return jSONObject;
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject k() {
        try {
            boolean zPr = c.pr(this.aa, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zPr);
            return jSONObject;
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject m() {
        boolean zPr;
        boolean zPr2;
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 33) {
                zPr = c.pr(this.aa, "android.permission.READ_MEDIA_IMAGES");
                zPr2 = true;
            } else {
                zPr = c.pr(this.aa, "android.permission.READ_EXTERNAL_STORAGE");
                zPr2 = c.pr(this.aa, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", zPr);
            jSONObject.put("isHasWrite", zPr2);
            if (!zPr || !zPr2) {
                z = false;
            }
            jSONObject.put("result", z);
            return jSONObject;
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public void pr(JSONObject jSONObject) {
        if (this.qo != null) {
            ho();
        }
    }

    public void hw(JSONObject jSONObject) {
        int iOptInt = 0;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("resource_type", 0);
            c.hn = jSONObject.optInt("video_min_duration", 1);
            c.x = jSONObject.optInt("video_max_duration", 20);
            c.c = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        if (this.qo != null) {
            pr(iOptInt);
        }
    }

    public void hn(JSONObject jSONObject) {
        com.byazt.eq.pr prVar = this.qo;
        if (prVar != null && !prVar.pr(jSONObject) && jSONObject != null) {
            String strOptString = jSONObject.optString("resource_base64");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            int iOptInt = jSONObject.optInt("resource_type", -1);
            String strOptString2 = jSONObject.optString("resource_name", "playable_media");
            if (iOptInt == 1) {
                hw(strOptString2, strOptString);
            } else if (iOptInt == 2) {
                hn(strOptString2, strOptString);
            }
        }
    }

    public void x(JSONObject jSONObject) {
        if (this.qo != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception e) {
            }
        }
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.wt.ordinal());
            jSONObject.put("safe_area_top_height", this.sr);
            jSONObject.put("safe_area_bottom_height", this.wz);
            jSONObject.put("playable_enter_from", this.f);
            jSONObject.put("playable_retry_count", this.o);
            jSONObject.put("playable_card_session", this.qi);
            jSONObject.put("playable_video_session", this.qn);
            jSONObject.put("playable_network_type", nt());
            jSONObject.put("aweme_id", this.ii);
            return jSONObject;
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public Intent ho() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File filePr = c.pr();
        if (filePr == null) {
            return null;
        }
        intent.putExtra("output", FileProvider.getUriForFile(this.aa, this.aa.getPackageName() + ".playable.fileProvider", filePr));
        return intent;
    }

    public Intent pr(int i) {
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

    public void pr(String str, JSONObject jSONObject) {
        hn hnVar = this.bh;
        if (hnVar != null) {
            hnVar.pr(str, jSONObject);
        }
    }

    public void hw(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.aa, "照片保存失败", 0).show();
            return;
        }
        Bitmap bitmapHw = c.hw(str2);
        if (bitmapHw != null) {
            MediaStore.Images.Media.insertImage(this.aa.getContentResolver(), bitmapHw, str, "");
            Toast.makeText(this.aa, "照片已保存到相册", 0).show();
        } else {
            Toast.makeText(this.aa, "照片保存失败", 0).show();
        }
    }

    public void hn(String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.aa, "视频保存失败", 0).show();
            return;
        }
        File filePr = c.pr(str, str2);
        if (filePr == null || !filePr.exists()) {
            Toast.makeText(this.aa, "视频保存失败", 0).show();
            return;
        }
        Uri uriFromFile = Uri.fromFile(filePr);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uriFromFile);
        this.aa.sendBroadcast(intent);
        Toast.makeText(this.aa, "视频已保存到相册", 0).show();
    }

    public String nt() {
        com.byazt.eq.pr prVar;
        if (TextUtils.isEmpty(this.of) && (prVar = this.qo) != null) {
            this.of = prVar.x().toString();
        }
        return this.of;
    }

    public com.byazt.eq.pr yb() {
        return this.qo;
    }

    public JSONObject lb() {
        if (this.qv.isNull("width")) {
            View view = this.cr.get();
            if (view == null) {
                return this.qv;
            }
            hw(view);
        }
        return this.qv;
    }

    public JSONObject qa() {
        return this.rk;
    }

    public zo c(JSONObject jSONObject) {
        this.rk = jSONObject;
        return this;
    }

    public zo c(String str) {
        int iIndexOf;
        String strDecode;
        this.fe = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(scheme)) {
                hw(0);
                if (str != null && (iIndexOf = str.indexOf("?")) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            } else {
                String host = uri.getHost();
                if ("webview".equalsIgnoreCase(host) || (host != null && host.contains("webview"))) {
                    hw(0);
                    String queryParameter = uri.getQueryParameter(BreakpointSQLiteKey.URL);
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf("?");
                        if (iIndexOf2 != -1) {
                            str = strDecode.substring(0, iIndexOf2);
                        } else {
                            str = strDecode;
                        }
                    }
                } else if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.pq == -1) {
                        hw(2);
                    } else {
                        hw(1);
                    }
                }
            }
        } catch (Throwable th) {
        }
        this.mr = str;
        return this;
    }

    public zo hw(int i) {
        this.pq = i;
        return this;
    }

    public zo x(boolean z) {
        this.rc = z;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.xb);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.p);
            jSONObject2.put("height", this.ku);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.fs);
            jSONObject3.put("y", this.xg);
            jSONObject3.put("width", this.sx);
            jSONObject3.put("height", this.uk);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.lj);
            jSONObject4.put("y", this.oj);
            jSONObject4.put("width", this.h);
            jSONObject4.put("height", this.t);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void cz() {
        com.byazt.eq.pr prVar = this.qo;
        if (prVar != null) {
            prVar.pr();
        }
    }

    public void ny() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ls > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.ls);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.e > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.e;
                this.v = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            hn("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException e) {
        }
    }

    public void uc(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.jn = jSONObject.optString("section");
        }
    }

    public void fo() {
        this.ie = 2;
    }

    public void rc() {
        this.l = true;
    }

    public void z() {
        if (this.qo != null) {
            pr prVar = pr.FEED_AWEME;
        }
    }

    public void b() {
        if (this.qo != null) {
            pr prVar = pr.FEED_AWEME;
        }
    }

    public void fw(JSONObject jSONObject) {
        com.byazt.son.x xVar;
        this.d = jSONObject;
        this.bm++;
        y();
        this.zo.removeCallbacks(this.w);
        if (!this.rc) {
            return;
        }
        this.er = System.currentTimeMillis();
        this.sv = System.currentTimeMillis();
        this.gu = 0L;
        int i = this.pq;
        if (i == 0) {
            if (Build.VERSION.SDK_INT >= 19 && (xVar = this.iy) != null) {
                xVar.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.byazt.eq.zo.8
                    @Override // android.webkit.ValueCallback
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public void onReceiveValue(String str) {
                        zo.this.gu = System.currentTimeMillis();
                    }
                });
            }
        } else if (i == 1 || i == 2) {
            pr("playable_stuck_check_ping", new JSONObject());
        }
        this.zo.postDelayed(this.w, this.gz);
    }

    public void iu() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ls > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.ls);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.e > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.e);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            hn("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException e) {
        }
    }

    public void zo(JSONObject jSONObject) {
        hw(2, jSONObject != null ? jSONObject.optString(Constants.ERROR_MSG_FIELD, "素材直接调用端上异常兜底蒙层") : "素材直接调用端上异常兜底蒙层");
    }

    public void ve() {
        hw hwVar;
        this.gu = System.currentTimeMillis();
        int i = this.pq;
        if ((i == 1 || i == 2) && (hwVar = this.ho) != null) {
            hwVar.pr(System.currentTimeMillis());
        }
    }

    public JSONObject aj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        switch (iOptInt) {
            case 0:
            default:
                return jSONObject2;
            case 1:
                return w();
            case 2:
                return k();
            case 3:
                return m();
        }
    }

    public JSONObject vk(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            switch (iOptInt) {
                case 1:
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject2.put("result", c.hw(this.aa, "android.permission.RECORD_AUDIO"));
                    } else {
                        jSONObject2.put("result", false);
                    }
                    break;
                case 2:
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject2.put("result", c.hw(this.aa, "android.permission.CAMERA"));
                    } else {
                        jSONObject2.put("result", false);
                    }
                    break;
                case 3:
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject2.put("result", c.pr(this.aa));
                    } else {
                        jSONObject2.put("result", false);
                    }
                    break;
            }
        } catch (JSONException e) {
        }
        return jSONObject2;
    }

    public void uc(String str) {
        int i;
        int i2;
        this.jw = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.e = jCurrentTimeMillis;
            long j = 0;
            long j2 = this.n;
            if (j2 != -1) {
                j = jCurrentTimeMillis - j2;
            }
            jSONObject.put("playable_page_show_duration", j);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        hn("PL_sdk_html_load_start", jSONObject);
        if (this.ny && ((i = this.pq) == 0 || i == 1 || i == 2)) {
            this.zo.postDelayed(this.aj, this.iu * 1000);
            if (vk(this.mr) || (i2 = this.pq) == 1 || i2 == 2) {
                this.zo.postDelayed(this.vk, this.ve * 1000);
            }
            this.ny = false;
        }
        if (this.yb) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (c.pr(this.aa, c.k)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (c.hw(this.aa, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (c.pr(this.aa, c.w)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (c.pr(this.aa, c.vk)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (c.pr(this.aa, c.aj)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (c.pr(this.aa, c.zo)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (c.hw(this.aa, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (c.pr(this.aa, c.fw)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (c.pr(this.aa)) {
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
                hn("PL_sdk_hardware_detect", jSONObject2);
                this.yb = false;
            } catch (Throwable th2) {
                fw.pr("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public void fw(String str) {
        com.byazt.son.x xVar;
        this.jw = 2;
        this.ag = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.s = jCurrentTimeMillis;
            long j = 0;
            long j2 = this.e;
            if (j2 != -1) {
                j = jCurrentTimeMillis - j2;
            }
            jSONObject.put("playable_html_load_start_duration", j);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        hn("PL_sdk_html_load_finish", jSONObject);
        this.zo.removeCallbacks(this.aj);
        try {
            if (this.pq == 0) {
                if (Build.VERSION.SDK_INT >= 19 && this.nt && (xVar = this.iy) != null) {
                    this.nt = false;
                    xVar.evaluateJavascript(e(), new ValueCallback<String>() { // from class: com.byazt.eq.zo.9
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                nl();
            }
        } catch (Throwable th2) {
            fw.pr("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public void gz() {
        this.zo.removeCallbacks(this.aj);
        this.zo.removeCallbacks(this.vk);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.e > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.e);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            hn("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException e) {
        }
    }

    public void w(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean(TrackAction.SUCCESS, true);
            if (zOptBoolean) {
                this.jw = 3;
                nl();
            } else {
                this.jw = -2;
            }
            if (!zOptBoolean && this.fo) {
                this.fo = false;
                this.zo.removeCallbacks(this.aj);
                this.zo.removeCallbacks(this.vk);
                pr(4, "素材渲染失败");
            }
        }
    }

    private void hn(int i, String str) {
        com.byazt.eq.pr prVar = this.qo;
        if (prVar != null) {
            prVar.pr(i, str);
        }
    }

    public void pr(int i, String str) {
        y();
        hn(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "reportRenderFatal error", th);
        }
        hn("PL_sdk_global_faild", jSONObject);
    }

    public void hw(int i, String str) {
        this.ie = i;
        if (this.d == null) {
            this.d = new JSONObject();
        }
        try {
            this.d.put("playable_stuck_type", i);
            this.d.put("playable_stuck_reason", str);
            if (this.er > 0) {
                this.d.put("playable_stuck_duration", System.currentTimeMillis() - this.er);
            } else {
                this.d.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable th) {
        }
        hn("PL_sdk_page_stuck", this.d);
        y();
        if (this.qo != null && i == 2) {
            this.d = new JSONObject();
        }
    }

    public void hw(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(str, jSONObject);
    }

    private String x(String str, String str2) {
        String queryParameter;
        if (TextUtils.isEmpty(this.qx) && !TextUtils.isEmpty(this.fe)) {
            Uri uri = Uri.parse(this.fe);
            String host = uri.getHost();
            String queryParameter2 = "";
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                queryParameter2 = uri.getQueryParameter("surl");
                queryParameter = uri.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
            }
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(uri.getScheme()).authority(host).appendQueryParameter("surl", queryParameter2);
            if (!TextUtils.isEmpty(queryParameter)) {
                builderAppendQueryParameter.appendQueryParameter("playable_hash", queryParameter);
            }
            this.qx = builderAppendQueryParameter.toString();
        }
        return this.qx;
    }

    private String c(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.mr = str3;
        return str3;
    }

    private void ls() {
        String str;
        if (this.rk == null || (str = this.mr) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.rk.optString("cid");
        if (!TextUtils.isEmpty(strOptString)) {
            String host = Uri.parse(this.mr).getHost();
            if (TextUtils.isEmpty(host)) {
                this.mr += "/cid_" + strOptString;
            } else {
                this.mr = this.mr.replace(host, host + "/cid_" + strOptString);
            }
        }
    }

    private void c(String str, JSONObject jSONObject) {
        try {
            int i = this.pq;
            if (i == 0) {
                if (this.wt != pr.LAND_PAGE && !vk(this.mr)) {
                    ls();
                }
                jSONObject.put("playable_url", this.mr);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", c(this.kl, this.xi));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", x(this.su, this.gg));
            }
            jSONObject.put("playable_render_type", this.pq);
            if (this.qo == null || this.pq != 0 || this.wt != pr.LAND_PAGE) {
                return;
            }
            vk(this.mr);
        } catch (JSONException e) {
        }
    }

    public void hn(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.hs && this.r > 0) {
                this.hs = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.tv);
            jSONObject.put("playable_session_id", this.a);
            int i = this.pq;
            if (i == 0) {
                if (this.wt != pr.LAND_PAGE && !vk(this.mr)) {
                    ls();
                }
                jSONObject.put("playable_url", this.mr);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", c(this.kl, this.xi));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", x(this.su, this.gg));
            }
            jSONObject.put("playable_full_url", this.fe);
            jSONObject.put("playable_replay_count", this.nw);
            jSONObject.put("playable_is_prerender", this.wo);
            jSONObject.put("playable_is_preload", this.hs);
            jSONObject.put("playable_render_type", this.pq);
            jSONObject.put("playable_scenes_type", this.wt.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.su) ? "" : this.su);
            if (!TextUtils.isEmpty(this.gg)) {
                str2 = this.gg;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.kl);
            jSONObject.put("playable_minigamelite_schema", this.xi);
            jSONObject.put("playable_is_debug", this.hg);
            jSONObject.put("playable_retry_count", this.o);
            jSONObject.put("playable_enter_from", this.f);
            jSONObject.put("playable_sequence", this.bm);
            jSONObject.put("playable_current_section", this.jn);
            jSONObject.put("is_playable_finish", this.l);
            jSONObject.put("playable_card_session", this.qi);
            jSONObject.put("playable_video_session", this.qn);
            jSONObject.put("playable_network_type", nt());
            jSONObject.put("playable_lynx_version", this.b);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            jSONObject2.put("tag", this.cz);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", BaseConstants.CATEGORY_UMENG);
            jSONObject2.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put(Constants.VALUE_FIELD, this.rk.opt("cid"));
            jSONObject2.put("log_extra", this.rk.opt("log_extra"));
            int i2 = this.pq;
            if (i2 != -1 && i2 != -2) {
                if (this.qo != null) {
                    List<JSONObject> list = this.q;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.q.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.pq);
                                jSONObjectOptJSONObject.put("playable_url", this.mr);
                            }
                        }
                        this.q.clear();
                    }
                    if (this.pq != 0 || this.wt != pr.LAND_PAGE) {
                        return;
                    }
                    vk(this.mr);
                    return;
                }
                return;
            }
            if (this.q == null) {
                this.q = new ArrayList();
            }
            this.q.add(jSONObject2);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void zo(String str) {
        this.zo.post(new Runnable() { // from class: com.byazt.eq.zo.10
            @Override // java.lang.Runnable
            public void run() {
                zo.k(zo.this);
            }
        });
    }

    public void aj(String str) {
        this.zo.post(new Runnable() { // from class: com.byazt.eq.zo.2
            @Override // java.lang.Runnable
            public void run() {
                zo.m(zo.this);
            }
        });
    }

    public void nl() {
        if (!this.rc) {
            return;
        }
        this.er = System.currentTimeMillis();
        if (this.wt == pr.FEED_AWEME) {
            if (this.tv && this.jw == 3) {
                hw hwVar = this.ho;
                if (hwVar != null && hwVar.hw()) {
                    er();
                    return;
                } else {
                    if (this.ho == null) {
                        this.ho = new hw(this, this.gz);
                        er();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.tv && this.jw == 2) {
            hw hwVar2 = this.ho;
            if (hwVar2 != null && hwVar2.hw()) {
                er();
            } else if (this.ho == null) {
                this.ho = new hw(this, this.gz);
                er();
            }
        }
    }

    private void er() {
        Runnable runnable;
        Runnable runnable2;
        this.ho.pr(System.currentTimeMillis());
        Handler handler = this.k;
        if (handler != null) {
            int i = this.pq;
            if (i == 0 && (runnable2 = this.m) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.g) != null) {
                handler.post(runnable);
            }
            this.ho.pr(500);
        }
    }

    public void y() {
        try {
            hw hwVar = this.ho;
            if (hwVar != null) {
                hwVar.pr();
            }
            Handler handler = this.k;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
        }
    }

    public void ww() {
        this.pj = 0;
        this.ey = 0;
        this.xb = 0.0f;
        this.p = 0;
        this.ku = 0;
        this.xg = 0;
        this.fs = 0;
        this.sx = 0;
        this.uk = 0;
        this.oj = 0;
        this.lj = 0;
        this.h = 0;
        this.t = 0;
    }

    public void n() {
        if (this.pp) {
            return;
        }
        this.pp = true;
        this.y = 0L;
        this.yb = true;
        ww();
        View view = this.cr.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.bg);
            } else {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this.bg);
            }
        }
        try {
            this.j.hw();
        } catch (Throwable th) {
        }
        try {
            hw hwVar = this.ho;
            if (hwVar != null) {
                hwVar.pr();
                this.ho = null;
            }
            Handler handler = this.k;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th2) {
        }
        try {
            if (!TextUtils.isEmpty(this.mr)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.i);
                jSONObject.put("playable_hit_times", this.r);
                int i = this.i;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.r) / (((double) i) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                hn("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable th3) {
        }
        try {
            if (!TextUtils.isEmpty(this.mr)) {
                if (this.ww != -1) {
                    this.nl += System.currentTimeMillis() - this.ww;
                    this.ww = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.nl);
                hn("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable th4) {
        }
        this.zo.removeCallbacks(this.aj);
        this.zo.removeCallbacks(this.vk);
        this.zo.removeCallbacksAndMessages(null);
    }

    public void pr(int i, String str, String str2) {
        this.jw = -1;
        this.ag = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            fw.pr("PlayablePlugin", "onWebReceivedError error", th);
        }
        hn("PL_sdk_html_load_error", jSONObject);
        if (this.fo) {
            this.fo = false;
            this.zo.removeCallbacks(this.aj);
            this.zo.removeCallbacks(this.vk);
            pr(1, "容器加载失败");
        }
    }

    public void pr(boolean z, String str, int i) {
        if (z) {
            this.jw = -1;
            this.ag = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                fw.pr("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            hn("PL_sdk_html_load_error", jSONObject);
            if (this.fo) {
                this.fo = false;
                this.zo.removeCallbacks(this.aj);
                this.zo.removeCallbacks(this.vk);
                pr(1, "容器加载失败");
            }
        }
    }

    public String e() {
        return "function playable_callJS(){return \"Android调用了JS的callJS方法\";}";
    }

    public JSONObject x(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        JSONObject jSONObjectPr = this.j.pr(str, jSONObject);
        if (fw.pr()) {
            System.currentTimeMillis();
        }
        return jSONObjectPr;
    }

    public static zo pr(Context context, com.byazt.son.x xVar, hn hnVar, com.byazt.eq.pr prVar, Set<String> set, pr prVar2, boolean z) {
        if (xVar == null || hnVar == null || prVar == null) {
            return null;
        }
        return new zo(context, xVar, hnVar, prVar, set, prVar2, z);
    }
}
