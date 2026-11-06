package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taptap.sdk.db.constant.Common;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final com.bytedance.sdk.openadsdk.core.f.ka f2037ms = new ms();
    private volatile String ab;
    private volatile String ah;
    private volatile com.bytedance.sdk.openadsdk.core.f.ka ao;
    private String az;
    private volatile int b;
    private volatile String c;
    private volatile boolean ch;
    private int cv;
    private volatile boolean d;
    private com.bytedance.sdk.openadsdk.core.playable.d e;
    private Bridge eg;
    private String f;
    private int g;
    private String h;
    private final Set<Integer> hi;
    private HashMap<String, Object> i;
    private volatile String jw;
    private String k;
    private volatile String ka;
    private int le;
    private boolean lm;
    private d m;
    private volatile boolean nw;
    private volatile int ny;
    private long of;
    private volatile Bridge op;
    private ka p;
    private boolean pc;
    private String qv;
    private volatile JSONObject re;
    private volatile boolean sl;
    private volatile boolean t;
    private volatile com.bytedance.sdk.openadsdk.core.jw.ms u;
    private volatile TTDownloadEventLogger ub;
    private String ul;
    private boolean w;
    private volatile com.bytedance.sdk.openadsdk.core.yu.ms x;
    private volatile String xr;
    private volatile boolean y;
    private boolean yu;
    private Bitmap zb;

    public static class ah {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public static final com.bytedance.sdk.component.d.ms.xr f2039ms = com.bytedance.sdk.openadsdk.core.jw.g.ms("sp_global_info");
    }

    public boolean ms() {
        return this.u != null && this.u.xr();
    }

    public boolean ms(boolean z) {
        return this.u != null && this.u.ms(z);
    }

    public void ms(String str) {
        this.jw = str;
    }

    public String xr() {
        if (TextUtils.isEmpty(this.jw)) {
            this.jw = com.bytedance.sdk.openadsdk.core.hi.ch.ms();
        }
        return this.jw;
    }

    public boolean ah() {
        if (!this.yu) {
            this.yu = true;
            try {
                ShortcutManager shortcutManager = (ShortcutManager) re.getContext().getSystemService(ShortcutManager.class);
                if (shortcutManager != null) {
                    this.w = shortcutManager.isRequestPinShortcutSupported();
                }
            } catch (Throwable unused) {
            }
        }
        return this.w;
    }

    public boolean ms(Activity activity) {
        return this.u != null && this.u.ms(activity);
    }

    public com.bytedance.sdk.openadsdk.core.jw.ms d() {
        if (this.u == null) {
            ah(re.getContext());
        }
        return this.u;
    }

    public boolean ka() {
        return com.bytedance.sdk.openadsdk.ub.ah.ms().d();
    }

    public String c() {
        return com.bytedance.sdk.openadsdk.ub.ah.ms().xr();
    }

    public boolean ab() {
        return this.lm;
    }

    public boolean x() {
        return com.bytedance.sdk.openadsdk.ub.ah.ms().ka();
    }

    public boolean ny() {
        return ch() && ab();
    }

    public boolean ch() {
        return !hi() && x();
    }

    public boolean hi() {
        return com.bytedance.sdk.openadsdk.ub.ah.ms().c();
    }

    public void sl() {
        com.bytedance.sdk.openadsdk.ub.ah.ms().ah();
    }

    private ch() {
        this.x = new com.bytedance.sdk.openadsdk.core.yu.ms(2);
        this.ny = 0;
        this.ch = true;
        this.hi = Collections.synchronizedSet(new HashSet());
        this.sl = false;
        this.zb = null;
        this.y = false;
        this.t = true;
        this.nw = true;
        this.b = 0;
        this.re = new JSONObject();
        this.i = new HashMap<>();
        this.w = false;
        this.yu = false;
        this.op = null;
        this.le = -1;
        this.cv = -1;
        this.g = -1;
        this.of = -1L;
        this.k = null;
    }

    public void zb() {
        u();
        Context context = re.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.api.c.ms.ms(context);
        }
        this.hi.add(4);
        ah(context);
    }

    public void u() {
        this.lm = com.bytedance.sdk.openadsdk.core.d.ms.xr();
    }

    private void ah(Context context) {
        this.u = new com.bytedance.sdk.openadsdk.core.jw.ms();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.u);
        } else {
            if (context == null || context.getApplicationContext() == null) {
                return;
            }
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.u);
        }
    }

    private static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ch f2041ms = new ch();
    }

    public static ch ub() {
        return xr.f2041ms;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.f.ka kaVar) {
        this.ao = kaVar;
    }

    public com.bytedance.sdk.openadsdk.core.f.ka ao() {
        return new le(qv());
    }

    public String h() {
        return this.k;
    }

    public void xr(String str) {
        this.k = str;
    }

    public com.bytedance.sdk.openadsdk.core.f.ka qv() {
        if (this.ao == null) {
            this.ao = fm() ? f2037ms : vl();
        }
        return this.ao;
    }

    public boolean y() {
        return ah.f2039ms.xr("sdk_activate_init", true);
    }

    public void xr(boolean z) {
        ah.f2039ms.ms("sdk_activate_init", z);
    }

    public String t() {
        if (!TextUtils.isEmpty(this.xr)) {
            return this.xr;
        }
        return com.bytedance.sdk.openadsdk.core.ah.d.ms().d();
    }

    public void ah(String str) {
        ub(str);
        this.xr = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", str);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
            jSONObject.put("sdk_version", g.ah);
            this.re.put("com.byted.pangle", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public String nw() {
        if (!TextUtils.isEmpty(this.ah)) {
            return this.ah;
        }
        return com.bytedance.sdk.openadsdk.core.ah.d.ms().ka();
    }

    public void d(String str) {
        ao(str);
        this.ah = str;
    }

    public boolean b() {
        if (com.bytedance.sdk.openadsdk.core.ah.ah.ms().xr()) {
            return com.bytedance.sdk.openadsdk.core.ah.d.ms().ms(this.d);
        }
        return this.d;
    }

    public void ah(boolean z) {
        this.d = z;
    }

    public String re() {
        if (!TextUtils.isEmpty(this.ka)) {
            return this.ka;
        }
        return com.bytedance.sdk.openadsdk.core.ah.d.ms().c("");
    }

    public void ka(String str) {
        h(str);
        this.ka = str;
    }

    public void ms(int i) {
        this.x = new com.bytedance.sdk.openadsdk.core.yu.ms(i, true);
    }

    public com.bytedance.sdk.openadsdk.core.yu.ms i() {
        return this.x;
    }

    public String w() {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        return com.bytedance.sdk.openadsdk.core.ah.d.ms().x("");
    }

    public Map<String, Object> yu() {
        if (!this.i.isEmpty()) {
            return this.i;
        }
        String strCh = com.bytedance.sdk.openadsdk.core.ah.d.ms().ch("");
        this.i.putAll(TextUtils.isEmpty(strCh) ? u(strCh) : new HashMap<>());
        return this.i;
    }

    public void c(final String str) {
        qv(str);
        com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("setUserData") { // from class: com.bytedance.sdk.openadsdk.core.ch.1
            @Override // java.lang.Runnable
            public void run() {
                ch.this.zb(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        HashMap map = new HashMap();
        JSONArray jSONArray2 = new JSONArray();
        boolean z = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                if (!jSONObjectOptJSONObject.isNull("__name__")) {
                    String strOptString = jSONObjectOptJSONObject.optString("__name__");
                    String strOptString2 = jSONObjectOptJSONObject.optString(com.anythink.core.common.e.f.a.d);
                    if (!TextUtils.isEmpty(strOptString)) {
                        map.put(strOptString, strOptString2);
                    }
                } else if ("csj_rit_list".equals(jSONObjectOptJSONObject.optString(Common.System.NAME))) {
                    ny(jSONObjectOptJSONObject.optString(com.anythink.core.common.e.f.a.d));
                    jSONArray.remove(i);
                    z = true;
                } else {
                    jSONArray2.put(jSONObjectOptJSONObject);
                }
            }
        }
        if (z) {
            this.c = jSONArray.toString();
        } else {
            this.c = str;
        }
        if ((jSONArray2.length() == 0 && map.isEmpty()) || jSONArray2.length() != 0) {
            this.c = jSONArray2.toString();
        }
        if (map.isEmpty()) {
            return;
        }
        this.i.putAll(map);
    }

    public void xr(int i) {
        this.ny = i;
    }

    public int op() {
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            return ah.f2039ms.xr("title_bar_theme", 0);
        }
        return this.ny;
    }

    public void d(boolean z) {
        this.ch = z;
    }

    public boolean le() {
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            return ah.f2039ms.xr("allow_show_notify", true);
        }
        return this.ch;
    }

    public void ka(boolean z) {
        ah(z);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().xr(z);
    }

    public void ab(String str) {
        c(str);
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            com.bytedance.sdk.openadsdk.core.ah.d.ms().ab(str);
            com.bytedance.sdk.openadsdk.core.ah.d.ms().ny(ms(this.i));
        }
    }

    public void x(String str) {
        ka(str);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().ka(str);
    }

    public void c(boolean z) {
        com.bytedance.sdk.component.utils.sl.d("bstsdk", "bst(true) stat-quit, run new pl");
        this.y = z;
        com.bytedance.sdk.openadsdk.core.d.ms.ms(true);
        com.bytedance.sdk.openadsdk.core.d.ah.ms();
    }

    public boolean cv() {
        return this.y;
    }

    public void g() {
        com.bytedance.sdk.openadsdk.core.ah.d.ms().xr(this.b);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().ms(this.xr);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().xr(this.ah);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().xr(this.d);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().ka(this.ka);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().ab(this.c);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().ny(ms(this.i));
        ah.f2039ms.ms("title_bar_theme", this.ny);
        ah.f2039ms.ms("allow_show_notify", this.ch);
        com.bytedance.sdk.openadsdk.core.ah.d.ms().d(this.sl);
        Set<Integer> set = this.hi;
        if (set != null && !set.isEmpty()) {
            Iterator<Integer> it = this.hi.iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append(it.next()).append(",");
            }
            ah.f2039ms.ms("network_state", sb.toString());
            return;
        }
        ah.f2039ms.ms("network_state");
    }

    public JSONObject of() {
        if (g.xr()) {
            ub().f();
        }
        return this.re;
    }

    public void ms(String str, String str2) {
        try {
            JSONObject jSONObjectOptJSONObject = this.re.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, str2);
            }
        } catch (JSONException unused) {
            com.bytedance.sdk.component.utils.sl.d("GlobalInfo", "JSONObject not found for name " + str + " when update plugin config.");
        }
    }

    public void ms(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObjectOptJSONObject = this.re.optJSONObject(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = this.xr;
            }
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            jSONObjectOptJSONObject.put("app_id", str4);
            jSONObjectOptJSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str3);
            jSONObjectOptJSONObject.put("sdk_version", str2);
            this.re.put(str, jSONObjectOptJSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.xr("GlobalInfo", "addPluginConfig for " + str + " failed: " + e.getMessage());
        }
    }

    public String p() {
        if (!TextUtils.isEmpty(this.ul)) {
            return this.ul;
        }
        try {
            Object objInvoke = Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                this.ul = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String pc() {
        if (!TextUtils.isEmpty(this.f)) {
            return this.f;
        }
        try {
            Object objInvoke = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                String str = (String) objInvoke;
                this.f = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String jw() {
        if (!TextUtils.isEmpty(this.az)) {
            return this.az;
        }
        try {
            Object obj = Class.forName("com.miui.zeus.mimo.sdk.BuildConfig").getField("VERSION_NAME").get(null);
            if (obj instanceof String) {
                String str = (String) obj;
                this.az = str;
                return str;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0071  */
    public void f() {
        String string;
        JSONObject jSONObject = new JSONObject();
        String strPc = pc();
        if (TextUtils.isEmpty(strPc) && (!TextUtils.isEmpty(p()) || !TextUtils.isEmpty(jw()))) {
            strPc = "1.0.0";
        }
        try {
            jSONObject.put("gdt_version", strPc);
        } catch (JSONException unused) {
        }
        int iAh = com.bytedance.sdk.openadsdk.op.hi.ah("com.byted.mixed");
        if (iAh != 0) {
            String string2 = new StringBuilder().append(iAh).toString();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string2.length(); i++) {
                sb.append(string2.charAt(i));
                if (i != string2.length() - 1) {
                    sb.append(j.z);
                }
            }
            if (TextUtils.isEmpty(sb.toString())) {
                string = "1.0.0.0";
            } else {
                string = sb.toString();
            }
        } else {
            string = "1.0.0.0";
        }
        if (jSONObject.has("gdt_version")) {
            try {
                jSONObject.put("app_id", this.xr);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, string);
                jSONObject.put("sdk_version", string);
                jSONObject.put("plugin_update_network", "2");
                this.re.put("com.byted.mixed", jSONObject);
            } catch (JSONException unused2) {
            }
        }
    }

    public void ms(Bundle bundle) {
        if (bundle == null || bundle.keySet().size() <= 0) {
            return;
        }
        for (String str : bundle.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Bundle bundle2 = bundle.getBundle(str);
                    if (bundle2 == null) {
                        return;
                    }
                    String string = bundle2.getString("app_id", this.xr);
                    ms(str, bundle2.getString("sdk_version"), bundle2.getString(PluginConstants.KEY_PLUGIN_VERSION), string);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        }
    }

    public Bridge ul() {
        Bridge bridge = this.eg;
        if (bridge != null) {
            return bridge;
        }
        if (g.xr >= 5500) {
            this.eg = c(3);
        } else {
            if (!AdSdkInitializerHolder.isSdkInitSuccess()) {
                return null;
            }
            try {
                this.eg = new com.bytedance.sdk.openadsdk.core.f.ah(Class.forName("com.bytedance.sdk.openadsdk.downloadnew.core.DownloadBridgeFactory").getDeclaredMethod("getDownloadBridge", Context.class).invoke(null, re.getContext()));
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.d("TTDownload", "Init download bridge failed: " + th.getMessage());
            }
        }
        return this.eg;
    }

    public TTDownloadEventLogger az() {
        return this.ub;
    }

    public void ms(TTDownloadEventLogger tTDownloadEventLogger) {
        this.ub = tTDownloadEventLogger;
        if (ub().ul() != null) {
            ub().ul().call(20, com.bykv.ms.ms.ms.ms.xr.f12ms, Void.class);
        }
    }

    public boolean ah(int i) {
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            String strXr = ah.f2039ms.xr("network_state", "");
            if (!TextUtils.isEmpty(strXr)) {
                String[] strArrSplit = strXr.split(",");
                if (strArrSplit.length > 0) {
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str) && String.valueOf(i).equals(str)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        Set<Integer> set = this.hi;
        return set != null && set.contains(Integer.valueOf(i));
    }

    public void ms(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.hi.clear();
            for (int i : iArr) {
                this.hi.add(Integer.valueOf(i));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    private static final String ms(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        }
        return jSONObject.toString();
    }

    private static final HashMap<String, Object> u(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> map = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    map.put(next, jSONObject.opt(next));
                }
            }
            return map;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    private static void ub(String str) {
        com.bytedance.sdk.component.utils.ao.ms(str, "appid不能为空");
    }

    private static void ao(String str) {
        com.bytedance.sdk.component.utils.ao.ms(str, "name不能为空");
    }

    private static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.ao.ms(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    private static void qv(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.ao.ms(str.length() <= 20000, "data超长, 最长为20000");
    }

    public com.bytedance.sdk.openadsdk.core.playable.d m() {
        if (this.e == null) {
            this.e = new com.bytedance.sdk.openadsdk.core.playable.d(10, 8);
        }
        return this.e;
    }

    public boolean lm() {
        if (com.bytedance.sdk.openadsdk.core.ah.ah.ms().xr()) {
            return com.bytedance.sdk.openadsdk.core.ah.d.ms().ah(false);
        }
        return this.sl;
    }

    public void ab(boolean z) {
        g.ab = z;
        this.sl = z;
    }

    public Bitmap e() {
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            return com.bytedance.sdk.component.utils.d.ms(ah.f2039ms.xr("pause_icon", ""));
        }
        return this.zb;
    }

    public void ms(Bitmap bitmap) {
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            String strMs = com.bytedance.sdk.component.utils.d.ms(bitmap);
            if (!TextUtils.isEmpty(strMs)) {
                ah.f2039ms.ms("pause_icon", strMs);
            }
        }
        this.zb = bitmap;
    }

    public int k() {
        if (com.bytedance.sdk.openadsdk.core.ah.ah.ms().xr()) {
            int iC = com.bytedance.sdk.openadsdk.core.ah.d.ms().c();
            return iC == Integer.MIN_VALUE ? this.b : iC;
        }
        return this.b;
    }

    public void d(int i) {
        if (i < 0 || i > 2) {
            i = 0;
        }
        try {
            this.b = i;
        } catch (Throwable unused) {
        }
    }

    public String eg() {
        if (!com.bytedance.sdk.openadsdk.core.ah.ah.ms().xr()) {
            return TextUtils.isEmpty(this.h) ? "" : this.h;
        }
        String strXr = ah.f2039ms.xr("tob_ab_sdk_version", "");
        return TextUtils.isEmpty(strXr) ? "" : strXr;
    }

    private static com.bytedance.sdk.openadsdk.core.f.ka vl() {
        return new com.bytedance.sdk.openadsdk.core.f.ka.ms().xr(true).ms(true).ms((com.bytedance.sdk.openadsdk.ao.xr.ah.ah) null).ah(true).ms((String) null).d(true).xr((String) null).ka(true).ah((String) null).c(true).d((String) null).ab(false).ms();
    }

    public static final class ms extends com.bytedance.sdk.openadsdk.core.f.ka {
        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public boolean ab() {
            return false;
        }

        public ms() {
            super(null);
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public boolean ms() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xr.ms(7, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public boolean xr() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xr.ms(17, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public boolean ah() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xr.ms(9, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public boolean d() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xr.ms(11, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public boolean ka() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xr.ms(12, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public boolean c() {
            return "1".equals(com.bytedance.sdk.openadsdk.tools.xr.ms(22, "1"));
        }

        @Override // com.bytedance.sdk.openadsdk.core.f.ka, com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public com.bytedance.sdk.openadsdk.ao.xr.ah.ah x() {
            String[] strArrSplit;
            String strMs = com.bytedance.sdk.openadsdk.tools.xr.ms(8, "");
            if (TextUtils.isEmpty(strMs) || (strArrSplit = strMs.split(",")) == null) {
                return null;
            }
            String str = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return new com.bytedance.sdk.openadsdk.ao.xr.ah.ah.ms().ms(Double.valueOf(str).doubleValue()).xr(Double.valueOf(str2).doubleValue()).ms();
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public String ny() {
            return com.bytedance.sdk.openadsdk.tools.xr.ms(10, "");
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public String ch() {
            return com.bytedance.sdk.openadsdk.tools.xr.ms(18, "");
        }

        @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.d
        public String hi() {
            return com.bytedance.sdk.openadsdk.tools.xr.ms(13, "");
        }
    }

    public boolean fm() {
        return "5001121".equals(this.xr) && "com.union_test.toutiao".equals(com.bytedance.sdk.openadsdk.core.jw.f.ch());
    }

    public boolean xn() {
        return "5001121".equals(this.xr);
    }

    public String il() {
        if (!TextUtils.isEmpty(this.qv)) {
            return this.qv;
        }
        com.bytedance.sdk.component.d.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.xr.ms();
        String strXr = xrVarMs.xr("any_door_id", (String) null);
        this.qv = strXr;
        if (!TextUtils.isEmpty(strXr)) {
            return this.qv;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        xrVarMs.ms("any_door_id", strValueOf);
        this.qv = strValueOf;
        return strValueOf;
    }

    public boolean qf() {
        return this.t;
    }

    public void x(boolean z) {
        this.t = z;
    }

    public void ka(int i) {
        com.bytedance.sdk.openadsdk.core.ah.d.ms().ah(i);
    }

    public int l() {
        return com.bytedance.sdk.openadsdk.core.ah.d.ms().d(0);
    }

    public Bridge am() {
        return this.op;
    }

    public Bridge c(int i) {
        if (this.op == null) {
            return null;
        }
        return new com.bytedance.sdk.openadsdk.core.f.ah(this.op.call(10, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, i).xr(), Object.class));
    }

    public void ms(Bridge bridge) {
        if (this.op != null) {
            return;
        }
        this.op = new com.bytedance.sdk.openadsdk.core.f.ah(bridge);
    }

    public boolean sa() {
        return this.pc;
    }

    public void ny(boolean z) {
        this.pc = z;
    }

    public String tz() {
        return this.ab;
    }

    public void ny(String str) {
        this.ab = str;
        com.bytedance.sdk.openadsdk.core.g.x.ms((com.bytedance.sdk.openadsdk.core.g.ka) null).ms(true);
    }

    public boolean ms(Context context) {
        if (com.bytedance.sdk.openadsdk.core.op.ms.ms().ka()) {
            this.le = 2;
        } else {
            this.le = 1;
        }
        return this.le == 1;
    }

    public boolean xr(Context context) {
        if (com.bytedance.sdk.openadsdk.core.op.ms.ms().ka()) {
            this.cv = 2;
        } else {
            this.cv = 1;
        }
        return this.cv == 1;
    }

    public void ab(int i) {
        this.g = i;
    }

    public int ti() {
        return this.g;
    }

    public void ms(long j) {
        this.of = j;
    }

    public long s() {
        return this.of;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.jw.ms.xr xrVar) {
        if (this.op != null) {
            if (this.p == null) {
                ka kaVar = new ka();
                this.p = kaVar;
                kaVar.ms(this.op);
            }
            this.p.ms(xrVar);
        }
    }

    public String v() {
        try {
            if ((re.xr().kl() & 1) == 1) {
                return com.bytedance.sdk.openadsdk.core.ah.ka.ms().ka();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Activity qk() {
        WeakReference<Activity> weakReferenceMs = this.u.ms();
        if (weakReferenceMs != null) {
            return weakReferenceMs.get();
        }
        Activity activity = this.op != null ? (Activity) this.op.call(14, null, Activity.class) : null;
        return activity == null ? gy() : activity;
    }

    public void ch(boolean z) {
        ah.f2039ms.ms("update_advance_preview_mode", z);
        ah.f2039ms.ms("update_advance_preview_mode_time", System.currentTimeMillis());
    }

    public boolean vm() {
        if (ah.f2039ms.xr("update_advance_preview_mode", false)) {
            long jXr = ah.f2039ms.xr("update_advance_preview_mode_time", -1L);
            if (jXr != -1) {
                if (System.currentTimeMillis() - jXr <= 3600000) {
                    return true;
                }
                ch(false);
            }
        }
        return false;
    }

    public void ch(String str) {
        ah.f2039ms.ms("toolsQueryHost", str);
    }

    public String zf() {
        return ah.f2039ms.xr("toolsQueryHost", "api-access.pangolin-sdk-toutiao.com");
    }

    public void hi(String str) {
        ah.f2039ms.ms("toolsAdPreviewUrl", str);
    }

    public String rt() {
        return ah.f2039ms.xr("toolsAdPreviewUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.2/html/ad_preview.html");
    }

    public void sl(String str) {
        ah.f2039ms.ms("toolsBasicInfUrl", str);
    }

    public String vy() {
        return ah.f2039ms.xr("toolsBasicInfUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.2/html/basic_info.html");
    }

    public d sk() {
        return this.m;
    }

    public void ms(d dVar) {
        this.m = dVar;
    }

    public static Activity gy() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(objInvoke);
            if (map != null && !map.isEmpty()) {
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("isTopResumedActivity");
                    declaredField2.setAccessible(true);
                    if (declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                        declaredField3.setAccessible(true);
                        return (Activity) declaredField3.get(obj);
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Map<String, Object> f2040ms;
        private String xr;

        public d(Map<String, Object> map, String str) {
            this.f2040ms = map;
            this.xr = str;
        }

        public void ms(JSONObject jSONObject) throws JSONException {
            Map<String, Object> map;
            if (jSONObject == null || (map = this.f2040ms) == null || map.size() == 0 || TextUtils.isEmpty(this.xr)) {
                return;
            }
            for (Map.Entry<String, Object> entry : this.f2040ms.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("preview_ads", new JSONObject(this.xr));
        }
    }
}
