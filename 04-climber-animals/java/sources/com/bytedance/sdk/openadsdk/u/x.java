package com.bytedance.sdk.openadsdk.u;

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
import com.anythink.basead.exoplayer.k.o;
import com.anythink.core.common.e.f;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.g;
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

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private int a;
    private final String ab;
    public final String ah;
    private int am;
    private boolean ao;
    private long az;
    private boolean b;
    private WeakReference<View> bz;
    private final String c;
    private float cc;
    private Context ce;
    private Runnable ch;
    private float cj;
    private int cv;
    public final String d;
    private int di;
    private String dv;
    private String e;
    private JSONObject ec;
    private String eg;
    private long f;
    private List<JSONObject> fk;
    private int fm;
    private long g;
    private String gs;
    private int gy;
    private boolean h;
    private Runnable hi;
    private boolean i;
    private ah ih;
    private boolean il;
    private String ir;
    private com.bytedance.sdk.openadsdk.u.ms j;
    private String jj;
    private com.bytedance.sdk.component.zb.ah jm;
    private boolean jr;
    private long jw;
    private c jy;
    private String k;
    public final String ka;
    private int kk;
    private String kl;
    private int l;
    private long le;
    private String lm;
    private long m;
    private int mh;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final String f4201ms;
    private Map<String, String> n;
    private JSONObject nl;
    private String nn;
    private boolean nq;
    private String nw;
    private Runnable ny;
    private String o;
    private long of;
    private int oh;
    private boolean oi;
    private long op;
    private boolean oy;
    private long p;
    private long pc;
    private int ph;
    private int pl;
    private boolean qd;
    private int qf;
    private int qk;
    private float qo;
    private ms qr;
    private boolean qv;
    private String r;
    private boolean re;
    private long rt;
    private boolean s;
    private int sa;
    private int si;
    private JSONObject sk;
    private final Handler sl;
    private String so;
    private String t;
    private String ti;
    private String tk;
    private int tz;
    private Runnable u;
    private xr ub;
    private String uc;
    private long ul;
    private int v;
    private String vf;
    private int vl;
    private int vm;
    private boolean vx;
    private long vy;
    private boolean w;
    private ViewTreeObserver.OnGlobalLayoutListener wc;
    private boolean we;
    private int wp;
    private int wq;
    private final Handler x;
    private int xn;
    public final String xr;
    private Set<String> y;
    private String yu;
    private JSONObject z;
    private Runnable zb;
    private int zd;
    private int zf;
    private int zx;

    public enum ms {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    public String jw() {
        return "function playable_callJS(){return \"Android调用了JS的callJS方法\";}";
    }

    static /* synthetic */ int sl(x xVar) {
        int i = xVar.fm;
        xVar.fm = i + 1;
        return i;
    }

    static /* synthetic */ int zb(x xVar) {
        int i = xVar.xn;
        xVar.xn = i + 1;
        return i;
    }

    private x(Context context, com.bytedance.sdk.component.zb.ah ahVar, ah ahVar2, com.bytedance.sdk.openadsdk.u.ms msVar, ms msVar2, boolean z) {
        this.c = "playable_stuck_check_ping";
        this.ab = "playable_apply_media_permission_callback";
        this.x = new Handler(Looper.getMainLooper());
        this.sl = new Handler(Looper.getMainLooper());
        this.ao = true;
        this.h = true;
        this.qv = true;
        this.f4201ms = "PL_sdk_playable_global_viewable";
        this.xr = "PL_sdk_page_screen_blank";
        this.ah = "PL_sdk_playable_destroy_analyze_summary";
        this.d = "PL_sdk_playable_hardware_dialog_cancel";
        this.ka = "PL_sdk_playable_hardware_dialog_setting";
        this.y = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.t = null;
        this.nw = "embeded_ad";
        this.b = true;
        this.re = true;
        this.i = true;
        this.w = false;
        this.yu = "";
        this.op = 10L;
        this.le = 10L;
        this.cv = 700;
        this.g = 0L;
        this.of = 0L;
        this.p = -1L;
        this.pc = -1L;
        this.jw = -1L;
        this.f = -1L;
        this.ul = -1L;
        this.az = -1L;
        this.m = -1L;
        this.lm = "";
        this.e = "";
        this.k = "";
        this.eg = "";
        this.fm = 0;
        this.xn = 0;
        this.il = false;
        this.qf = 0;
        this.l = -1;
        this.am = 0;
        this.sa = 0;
        this.tz = 0;
        this.ti = null;
        this.s = false;
        this.v = 0;
        this.qk = 0;
        this.vm = 0;
        this.zf = 0;
        this.rt = 0L;
        this.vy = 0L;
        this.gy = -2;
        this.vl = 0;
        this.oh = 0;
        this.zd = 0;
        this.z = new JSONObject();
        this.n = new HashMap();
        this.ec = new JSONObject();
        this.r = "";
        this.qo = 0.0f;
        this.cc = 0.0f;
        this.vx = false;
        this.qd = false;
        this.we = false;
        this.fk = new ArrayList();
        this.wc = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.u.x.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) x.this.bz.get();
                    if (view == null) {
                        return;
                    }
                    x.this.xr(view);
                } catch (Throwable th) {
                    ab.ms("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.gy = 0;
        this.qr = msVar2;
        this.jm = ahVar;
        ny.ms(ahVar);
        if (!z) {
            ms(ahVar.getView());
        }
        ms(context, ahVar2, msVar);
    }

    private x(Context context, com.bytedance.sdk.component.zb.ah ahVar, ah ahVar2, com.bytedance.sdk.openadsdk.u.ms msVar, Set<String> set, ms msVar2, boolean z) {
        this(context, ahVar, ahVar2, msVar, msVar2, z);
        this.y = set;
    }

    private void ms(Context context, ah ahVar, com.bytedance.sdk.openadsdk.u.ms msVar) {
        this.t = UUID.randomUUID().toString();
        this.ce = context;
        this.j = msVar;
        this.ih = ahVar;
        ch.ms(msVar);
        this.jy = new c(this);
        f();
    }

    private void f() {
        this.ub = new xr(this, this.cv);
        this.ny = new Runnable() { // from class: com.bytedance.sdk.openadsdk.u.x.3
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.re) {
                    x.this.re = false;
                    x.this.x.removeCallbacks(x.this.ch);
                    x.this.ms(2, "容器加载超时");
                }
            }
        };
        this.ch = new Runnable() { // from class: com.bytedance.sdk.openadsdk.u.x.4
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.re) {
                    x.this.re = false;
                    x.this.x.removeCallbacks(x.this.ny);
                    x.this.ms(3, "JSSDK加载超时");
                }
            }
        };
        this.zb = new Runnable() { // from class: com.bytedance.sdk.openadsdk.u.x.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (x.this.jm != null) {
                    x.this.jm.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.u.x.5.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (x.this.ub != null) {
                                x.this.ub.ms(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (x.this.sl != null) {
                    x.this.sl.postDelayed(this, 500L);
                }
            }
        };
        this.u = new Runnable() { // from class: com.bytedance.sdk.openadsdk.u.x.6
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                x.this.ms("playable_stuck_check_ping", new JSONObject());
                if (x.this.sl != null) {
                    x.this.sl.postDelayed(this, 500L);
                }
            }
        };
        this.hi = new Runnable() { // from class: com.bytedance.sdk.openadsdk.u.x.7
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.vy <= 0) {
                    x.this.xr(1, "点击热区卡死");
                } else {
                    if (x.this.vy - x.this.rt <= x.this.cv) {
                        x.this.g();
                        x.this.rt = 0L;
                        x.this.vy = 0L;
                        return;
                    }
                    x.this.xr(1, "点击热区卡死");
                }
            }
        };
    }

    private boolean ch(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public void ms(View view) {
        if (view == null) {
            return;
        }
        try {
            this.bz = new WeakReference<>(view);
            xr(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.wc);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.oh == view.getWidth() && this.zd == view.getHeight()) {
                return;
            }
            this.oh = view.getWidth();
            this.zd = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.oh);
            jSONObject.put("height", this.zd);
            ms("resize", jSONObject);
            this.z = jSONObject;
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public Context getContext() {
        return this.ce;
    }

    public x ms(String str, String str2) {
        this.n.put(str, str2);
        return this;
    }

    public Map<String, String> ms() {
        return this.n;
    }

    public x ms(String str) {
        this.tk = str;
        return this;
    }

    public x xr(String str) {
        this.nn = str;
        return this;
    }

    public JSONObject xr() {
        return this.nl;
    }

    public String ah() {
        return this.nn;
    }

    public String d() {
        return this.tk;
    }

    public x ah(String str) {
        this.o = str;
        return this;
    }

    public String ka() {
        return this.o;
    }

    public x d(String str) {
        this.dv = str;
        return this;
    }

    public String c() {
        return this.dv;
    }

    public x ms(boolean z) {
        this.oy = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.oy);
            ms("volumeChange", jSONObject);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public boolean ab() {
        return this.oy;
    }

    public x ms(long j) {
        if (j <= 0) {
            this.op = 10L;
        } else {
            this.op = j;
        }
        return this;
    }

    public x xr(long j) {
        if (j <= 0) {
            this.le = 10L;
        } else {
            this.le = j;
        }
        return this;
    }

    public x xr(boolean z) {
        if (this.oi == z) {
            return this;
        }
        this.oi = z;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.oi) {
                jSONObject.put("playable_background_show_type", this.qk);
            }
        } catch (JSONException e) {
            sl.ms(e);
        }
        ah(this.oi ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.pc == -1 && this.oi) {
            this.pc = System.currentTimeMillis();
            ah("PL_sdk_page_show", (JSONObject) null);
        }
        if (this.pc != -1 && !this.oi && !this.vx) {
            this.vx = true;
        }
        if (this.oi) {
            this.p = System.currentTimeMillis();
        } else if (this.p != -1) {
            this.g += System.currentTimeMillis() - this.p;
            this.p = -1L;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("viewStatus", this.oi);
            ms("viewableChange", jSONObject2);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "setViewable error", th);
        }
        if (this.oi) {
            g();
        } else {
            of();
        }
        return this;
    }

    public boolean x() {
        return this.oi;
    }

    public x ah(boolean z) {
        this.nq = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.nq);
            ms("change_playable_click", jSONObject);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public JSONObject ny() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.nq);
            return jSONObject;
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public Set<String> ch() {
        Set<String> setMs = this.jy.ms();
        Set<String> set = this.y;
        if (set == null || set.size() <= 0) {
            return setMs;
        }
        HashSet hashSet = new HashSet();
        for (String str : setMs) {
            if (!this.y.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public JSONObject hi() {
        try {
            boolean zMs = ka.ms(this.ce, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zMs);
            return jSONObject;
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject sl() {
        try {
            boolean zMs = ka.ms(this.ce, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zMs);
            return jSONObject;
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject zb() {
        boolean zMs;
        boolean zMs2;
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 33) {
                zMs = ka.ms(this.ce, "android.permission.READ_MEDIA_IMAGES");
                zMs2 = true;
            } else {
                zMs = ka.ms(this.ce, g.i);
                zMs2 = ka.ms(this.ce, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", zMs);
            jSONObject.put("isHasWrite", zMs2);
            if (!zMs || !zMs2) {
                z = false;
            }
            jSONObject.put("result", z);
            return jSONObject;
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public void ms(JSONObject jSONObject) {
        if (this.j != null) {
            ub();
        }
    }

    public void xr(JSONObject jSONObject) {
        int iOptInt = 0;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("resource_type", 0);
            ka.ah = jSONObject.optInt("video_min_duration", 1);
            ka.d = jSONObject.optInt("video_max_duration", 20);
            ka.ka = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        if (this.j != null) {
            ms(iOptInt);
        }
    }

    public void ah(JSONObject jSONObject) throws Throwable {
        com.bytedance.sdk.openadsdk.u.ms msVar = this.j;
        if (msVar == null || msVar.ms(jSONObject) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        int iOptInt = jSONObject.optInt("resource_type", -1);
        String strOptString2 = jSONObject.optString("resource_name", "playable_media");
        if (iOptInt == 1) {
            xr(strOptString2, strOptString);
        } else if (iOptInt == 2) {
            ah(strOptString2, strOptString);
        }
    }

    public void d(JSONObject jSONObject) {
        if (this.j != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception e) {
                sl.ms(e);
            }
        }
    }

    public JSONObject u() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.qr.ordinal());
            jSONObject.put("safe_area_top_height", this.qo);
            jSONObject.put("safe_area_bottom_height", this.cc);
            jSONObject.put("playable_enter_from", this.sa);
            jSONObject.put("playable_retry_count", this.am);
            jSONObject.put("playable_card_session", this.lm);
            jSONObject.put("playable_video_session", this.e);
            jSONObject.put("playable_network_type", ao());
            jSONObject.put("aweme_id", this.eg);
            return jSONObject;
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public Intent ub() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File fileMs = ka.ms();
        if (fileMs == null) {
            return null;
        }
        intent.putExtra("output", FileProvider.getUriForFile(this.ce, this.ce.getPackageName() + ".playable.fileProvider", fileMs));
        return intent;
    }

    public Intent ms(int i) {
        Intent intent = new Intent("android.intent.action.PICK");
        if (i == 0) {
            intent.setType("*/*");
        } else if (i == 1) {
            intent.setType("image/*");
        } else if (i == 2) {
            intent.setType(o.e);
        } else {
            intent.setType("*/*");
        }
        return intent;
    }

    public void ms(String str, JSONObject jSONObject) {
        ah ahVar = this.ih;
        if (ahVar != null) {
            ahVar.ms(str, jSONObject);
        }
    }

    public void xr(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.ce, "照片保存失败", 0).show();
            return;
        }
        Bitmap bitmapXr = ka.xr(str2);
        if (bitmapXr != null) {
            MediaStore.Images.Media.insertImage(this.ce.getContentResolver(), bitmapXr, str, "");
            Toast.makeText(this.ce, "照片已保存到相册", 0).show();
        } else {
            Toast.makeText(this.ce, "照片保存失败", 0).show();
        }
    }

    public void ah(String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.ce, "视频保存失败", 0).show();
            return;
        }
        File fileMs = ka.ms(str, str2);
        if (fileMs == null || !fileMs.exists()) {
            Toast.makeText(this.ce, "视频保存失败", 0).show();
            return;
        }
        Uri uriFromFile = Uri.fromFile(fileMs);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uriFromFile);
        this.ce.sendBroadcast(intent);
        Toast.makeText(this.ce, "视频已保存到相册", 0).show();
    }

    public String ao() {
        com.bytedance.sdk.openadsdk.u.ms msVar;
        if (TextUtils.isEmpty(this.k) && (msVar = this.j) != null) {
            this.k = msVar.d().toString();
        }
        return this.k;
    }

    public com.bytedance.sdk.openadsdk.u.ms h() {
        return this.j;
    }

    public JSONObject qv() {
        if (this.z.isNull("width")) {
            View view = this.bz.get();
            if (view == null) {
                return this.z;
            }
            xr(view);
        }
        return this.z;
    }

    public JSONObject y() {
        return this.ec;
    }

    public x ka(JSONObject jSONObject) {
        this.ec = jSONObject;
        return this;
    }

    public x ka(String str) {
        int iIndexOf;
        String strDecode;
        this.r = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                xr(0);
                if (str != null && (iIndexOf = str.indexOf("?")) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            } else {
                String host = uri.getHost();
                if ("webview".equalsIgnoreCase(host) || (host != null && host.contains("webview"))) {
                    xr(0);
                    String queryParameter = uri.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf("?");
                        str = iIndexOf2 != -1 ? strDecode.substring(0, iIndexOf2) : strDecode;
                    }
                } else if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.gy == -1) {
                        xr(2);
                    } else {
                        xr(1);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.vf = str;
        return this;
    }

    public x xr(int i) {
        this.gy = i;
        return this;
    }

    public x d(boolean z) {
        this.i = z;
        return this;
    }

    public JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.cj);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.wq);
            jSONObject2.put("height", this.si);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.di);
            jSONObject3.put("y", this.pl);
            jSONObject3.put("width", this.a);
            jSONObject3.put("height", this.mh);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.kk);
            jSONObject4.put("y", this.wp);
            jSONObject4.put("width", this.ph);
            jSONObject4.put("height", this.zx);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void nw() {
        com.bytedance.sdk.openadsdk.u.ms msVar = this.j;
        if (msVar != null) {
            msVar.ms();
        }
    }

    public void b() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ul > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.ul);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.jw > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.jw;
                this.m = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            ah("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ti = jSONObject.optString("section");
        }
    }

    public void re() {
        this.l = 2;
    }

    public void i() {
        this.s = true;
    }

    public void w() {
        if (this.j != null) {
            ms msVar = ms.FEED_AWEME;
        }
    }

    public void yu() {
        if (this.j != null) {
            ms msVar = ms.FEED_AWEME;
        }
    }

    public void ab(JSONObject jSONObject) {
        this.sk = jSONObject;
        this.tz++;
        of();
        this.x.removeCallbacks(this.hi);
        if (this.i) {
            this.az = System.currentTimeMillis();
            this.rt = System.currentTimeMillis();
            this.vy = 0L;
            int i = this.gy;
            if (i == 0) {
                com.bytedance.sdk.component.zb.ah ahVar = this.jm;
                if (ahVar != null) {
                    ahVar.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.u.x.8
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            x.this.vy = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i == 1 || i == 2) {
                ms("playable_stuck_check_ping", new JSONObject());
            }
            this.x.postDelayed(this.hi, this.cv);
        }
    }

    public void op() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ul > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.ul);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.jw > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.jw);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            ah("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void x(JSONObject jSONObject) {
        xr(2, jSONObject != null ? jSONObject.optString("error_msg", "素材直接调用端上异常兜底蒙层") : "素材直接调用端上异常兜底蒙层");
    }

    public void le() {
        xr xrVar;
        this.vy = System.currentTimeMillis();
        int i = this.gy;
        if ((i == 1 || i == 2) && (xrVar = this.ub) != null) {
            xrVar.ms(System.currentTimeMillis());
        }
    }

    public JSONObject ny(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            return hi();
        }
        if (iOptInt != 2) {
            return iOptInt != 3 ? jSONObject2 : zb();
        }
        return sl();
    }

    public JSONObject ch(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (iOptInt == 1) {
                jSONObject2.put("result", ka.xr(this.ce, "android.permission.RECORD_AUDIO"));
            } else {
                if (iOptInt != 2) {
                    if (iOptInt == 3) {
                        jSONObject2.put("result", ka.ms(this.ce));
                    }
                    return jSONObject2;
                }
                jSONObject2.put("result", ka.xr(this.ce, "android.permission.CAMERA"));
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void c(String str) {
        int i;
        int i2;
        this.vl = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.jw = jCurrentTimeMillis;
            long j = this.pc;
            jSONObject.put("playable_page_show_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        ah("PL_sdk_html_load_start", jSONObject);
        if (this.b && ((i = this.gy) == 0 || i == 1 || i == 2)) {
            this.x.postDelayed(this.ny, this.op * 1000);
            if (ch(this.vf) || (i2 = this.gy) == 1 || i2 == 2) {
                this.x.postDelayed(this.ch, this.le * 1000);
            }
            this.b = false;
        }
        if (this.h) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (ka.ms(this.ce, ka.sl)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (ka.xr(this.ce, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ka.ms(this.ce, ka.hi)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ka.ms(this.ce, ka.ch)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ka.ms(this.ce, ka.ny)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ka.ms(this.ce, ka.x)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (ka.xr(this.ce, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ka.ms(this.ce, ka.ab)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (ka.ms(this.ce)) {
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
                ah("PL_sdk_hardware_detect", jSONObject2);
                this.h = false;
            } catch (Throwable th2) {
                ab.ms("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public void ab(String str) {
        com.bytedance.sdk.component.zb.ah ahVar;
        this.vl = 2;
        this.kl = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f = jCurrentTimeMillis;
            long j = this.jw;
            jSONObject.put("playable_html_load_start_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        ah("PL_sdk_html_load_finish", jSONObject);
        this.x.removeCallbacks(this.ny);
        try {
            if (this.gy == 0) {
                if (this.ao && (ahVar = this.jm) != null) {
                    this.ao = false;
                    ahVar.evaluateJavascript(jw(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.u.x.9
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                g();
            }
        } catch (Throwable th2) {
            ab.ms("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public void cv() {
        this.x.removeCallbacks(this.ny);
        this.x.removeCallbacks(this.ch);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.jw > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.jw);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            ah("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    public void hi(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("success", true);
            if (zOptBoolean) {
                this.vl = 3;
                g();
            } else {
                this.vl = -2;
            }
            if (zOptBoolean || !this.re) {
                return;
            }
            this.re = false;
            this.x.removeCallbacks(this.ny);
            this.x.removeCallbacks(this.ch);
            ms(4, "素材渲染失败");
        }
    }

    private void ah(int i, String str) {
        com.bytedance.sdk.openadsdk.u.ms msVar = this.j;
        if (msVar != null) {
            msVar.ms(i, str);
        }
    }

    protected void ms(int i, String str) {
        of();
        ah(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "reportRenderFatal error", th);
        }
        ah("PL_sdk_global_faild", jSONObject);
    }

    public void xr(int i, String str) {
        this.l = i;
        if (this.sk == null) {
            this.sk = new JSONObject();
        }
        try {
            this.sk.put("playable_stuck_type", i);
            this.sk.put("playable_stuck_reason", str);
            if (this.az > 0) {
                this.sk.put("playable_stuck_duration", System.currentTimeMillis() - this.az);
            } else {
                this.sk.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        ah("PL_sdk_page_stuck", this.sk);
        of();
        if (this.j == null || i != 2) {
            return;
        }
        this.sk = new JSONObject();
    }

    protected void xr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ka(str, jSONObject);
    }

    private String d(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.gs) && !TextUtils.isEmpty(this.r)) {
            Uri uri = Uri.parse(this.r);
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
            this.gs = builderAppendQueryParameter.toString();
        }
        return this.gs;
    }

    private String ka(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.vf = str3;
        return str3;
    }

    private void ul() {
        String str;
        if (this.ec == null || (str = this.vf) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.ec.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        String host = Uri.parse(this.vf).getHost();
        if (TextUtils.isEmpty(host)) {
            this.vf += "/cid_" + strOptString;
        } else {
            this.vf = this.vf.replace(host, host + "/cid_" + strOptString);
        }
    }

    private void ka(String str, JSONObject jSONObject) {
        try {
            int i = this.gy;
            if (i == 0) {
                if (this.qr != ms.LAND_PAGE && !ch(this.vf)) {
                    ul();
                }
                jSONObject.put("playable_url", this.vf);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", ka(this.so, this.uc));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", d(this.ir, this.jj));
            }
            jSONObject.put("playable_render_type", this.gy);
            if (this.j != null && this.gy == 0 && this.qr == ms.LAND_PAGE) {
                ch(this.vf);
            }
        } catch (JSONException unused) {
        }
    }

    public void ah(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.il && this.xn > 0) {
                this.il = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.oi);
            jSONObject.put("playable_session_id", this.t);
            int i = this.gy;
            if (i == 0) {
                if (this.qr != ms.LAND_PAGE && !ch(this.vf)) {
                    ul();
                }
                jSONObject.put("playable_url", this.vf);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", ka(this.so, this.uc));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", d(this.ir, this.jj));
            }
            jSONObject.put("playable_full_url", this.r);
            jSONObject.put("playable_replay_count", this.qf);
            jSONObject.put("playable_is_prerender", this.jr);
            jSONObject.put("playable_is_preload", this.il);
            jSONObject.put("playable_render_type", this.gy);
            jSONObject.put("playable_scenes_type", this.qr.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.ir) ? "" : this.ir);
            if (!TextUtils.isEmpty(this.jj)) {
                str2 = this.jj;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.so);
            jSONObject.put("playable_minigamelite_schema", this.uc);
            jSONObject.put("playable_is_debug", this.qd);
            jSONObject.put("playable_retry_count", this.am);
            jSONObject.put("playable_enter_from", this.sa);
            jSONObject.put("playable_sequence", this.tz);
            jSONObject.put("playable_current_section", this.ti);
            jSONObject.put("is_playable_finish", this.s);
            jSONObject.put("playable_card_session", this.lm);
            jSONObject.put("playable_video_session", this.e);
            jSONObject.put("playable_network_type", ao());
            jSONObject.put("playable_lynx_version", this.yu);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put(TTDownloadField.TT_TAG, this.nw);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put(TTDownloadField.TT_REFER, "playable");
            jSONObject2.put(f.a.d, this.ec.opt("cid"));
            jSONObject2.put("log_extra", this.ec.opt("log_extra"));
            int i2 = this.gy;
            if (i2 != -1 && i2 != -2) {
                if (this.j != null) {
                    List<JSONObject> list = this.fk;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.fk.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject("ad_extra_data");
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.gy);
                                jSONObjectOptJSONObject.put("playable_url", this.vf);
                            }
                        }
                        this.fk.clear();
                    }
                    if (this.gy == 0 && this.qr == ms.LAND_PAGE) {
                        ch(this.vf);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.fk == null) {
                this.fk = new ArrayList();
            }
            this.fk.add(jSONObject2);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void x(String str) {
        this.x.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.u.x.10
            @Override // java.lang.Runnable
            public void run() {
                x.sl(x.this);
            }
        });
    }

    public void ny(String str) {
        this.x.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.u.x.2
            @Override // java.lang.Runnable
            public void run() {
                x.zb(x.this);
            }
        });
    }

    public void g() {
        if (this.i) {
            this.az = System.currentTimeMillis();
            if (this.qr == ms.FEED_AWEME) {
                if (this.oi && this.vl == 3) {
                    xr xrVar = this.ub;
                    if (xrVar != null && xrVar.xr()) {
                        az();
                        return;
                    } else {
                        if (this.ub == null) {
                            this.ub = new xr(this, this.cv);
                            az();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.oi && this.vl == 2) {
                xr xrVar2 = this.ub;
                if (xrVar2 != null && xrVar2.xr()) {
                    az();
                } else if (this.ub == null) {
                    this.ub = new xr(this, this.cv);
                    az();
                }
            }
        }
    }

    private void az() {
        Runnable runnable;
        Runnable runnable2;
        this.ub.ms(System.currentTimeMillis());
        Handler handler = this.sl;
        if (handler != null) {
            int i = this.gy;
            if (i == 0 && (runnable2 = this.zb) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.u) != null) {
                handler.post(runnable);
            }
            this.ub.ms(500);
        }
    }

    public void of() {
        try {
            xr xrVar = this.ub;
            if (xrVar != null) {
                xrVar.ms();
            }
            Handler handler = this.sl;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused) {
        }
    }

    public void p() {
        this.oh = 0;
        this.zd = 0;
        this.cj = 0.0f;
        this.wq = 0;
        this.si = 0;
        this.pl = 0;
        this.di = 0;
        this.a = 0;
        this.mh = 0;
        this.wp = 0;
        this.kk = 0;
        this.ph = 0;
        this.zx = 0;
    }

    public void pc() {
        if (this.we) {
            return;
        }
        this.we = true;
        this.of = 0L;
        this.h = true;
        p();
        try {
            View view = this.bz.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.wc);
            }
        } catch (Throwable unused) {
        }
        try {
            this.jy.xr();
        } catch (Throwable unused2) {
        }
        try {
            xr xrVar = this.ub;
            if (xrVar != null) {
                xrVar.ms();
                this.ub = null;
            }
            Handler handler = this.sl;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.vf)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.fm);
                jSONObject.put("playable_hit_times", this.xn);
                int i = this.fm;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.xn) / (((double) i) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                ah("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (!TextUtils.isEmpty(this.vf)) {
                if (this.p != -1) {
                    this.g += System.currentTimeMillis() - this.p;
                    this.p = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.g);
                ah("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused5) {
        }
        this.x.removeCallbacks(this.ny);
        this.x.removeCallbacks(this.ch);
        this.x.removeCallbacksAndMessages(null);
    }

    public void ms(int i, String str, String str2) {
        this.vl = -1;
        this.kl = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            ab.ms("PlayablePlugin", "onWebReceivedError error", th);
        }
        ah("PL_sdk_html_load_error", jSONObject);
        if (this.re) {
            this.re = false;
            this.x.removeCallbacks(this.ny);
            this.x.removeCallbacks(this.ch);
            ms(1, "容器加载失败");
        }
    }

    public void ms(boolean z, String str, int i) {
        if (z) {
            this.vl = -1;
            this.kl = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                ab.ms("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            ah("PL_sdk_html_load_error", jSONObject);
            if (this.re) {
                this.re = false;
                this.x.removeCallbacks(this.ny);
                this.x.removeCallbacks(this.ch);
                ms(1, "容器加载失败");
            }
        }
    }

    public JSONObject d(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        JSONObject jSONObjectMs = this.jy.ms(str, jSONObject);
        if (ab.ms()) {
            System.currentTimeMillis();
        }
        return jSONObjectMs;
    }

    public static x ms(Context context, com.bytedance.sdk.component.zb.ah ahVar, ah ahVar2, com.bytedance.sdk.openadsdk.u.ms msVar, Set<String> set, ms msVar2, boolean z) {
        if (ahVar == null || ahVar2 == null || msVar == null) {
            return null;
        }
        return new x(context, ahVar, ahVar2, msVar, set, msVar2, z);
    }
}
