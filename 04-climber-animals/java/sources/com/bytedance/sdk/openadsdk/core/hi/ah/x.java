package com.bytedance.sdk.openadsdk.core.hi.ah;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.ao;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.of;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.ul;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tapsdk.tapad.e.a;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x extends ka implements le.ms {
    protected WeakReference<Context> ah;
    protected Bridge b;
    protected String c;
    protected final com.bytedance.sdk.openadsdk.core.nw.ka d;
    protected HashSet<Integer> hi;
    protected boolean i;
    protected lm ka;
    protected ao qv;
    protected volatile boolean re;
    protected com.bytedance.sdk.openadsdk.core.hi.xr.ka sl;
    protected volatile Runnable t;
    protected final String ub;
    private volatile com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah w;
    protected final AtomicInteger ab = new AtomicInteger(1);
    protected final AtomicBoolean x = new AtomicBoolean(false);
    protected boolean ny = false;
    protected final AtomicBoolean ch = new AtomicBoolean(false);
    protected final le zb = new le(Looper.getMainLooper(), this);
    protected boolean u = true;
    protected boolean ao = false;
    protected volatile boolean h = false;
    protected ms y = new ms();
    protected int nw = 0;
    private List<y> yu = new CopyOnWriteArrayList();

    protected abstract void c();

    public abstract void ms(boolean z);

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public abstract boolean ms();

    public abstract void xr();

    public x(Context context, lm lmVar, String str, boolean z) {
        this.ah = new WeakReference<>(context);
        this.ka = lmVar;
        com.bytedance.sdk.openadsdk.core.nw.ka kaVarZh = lmVar.zh();
        this.d = kaVarZh;
        str = TextUtils.isEmpty(str) ? f.xr(lmVar) : str;
        this.c = TextUtils.isEmpty(str) ? "embeded_ad" : str;
        this.ub = lmVar.hashCode() + lmVar.eu();
        this.b = com.bytedance.sdk.openadsdk.core.ch.ub().ul();
        if (kaVarZh == null) {
            return;
        }
        if (re.getContext() == null) {
            re.ms(context);
        }
        this.sl = new com.bytedance.sdk.openadsdk.core.hi.xr.ka();
        ka(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ka(boolean z) {
        ms(z);
        xr();
    }

    protected Context getContext() {
        try {
            WeakReference<Context> weakReference = this.ah;
            if (weakReference == null) {
                return re.getContext();
            }
            Context context = weakReference.get();
            return context == null ? re.getContext() : context;
        } catch (Throwable unused) {
            return re.getContext();
        }
    }

    public com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah hi() {
        if (this.w == null) {
            synchronized (this) {
                if (this.w == null) {
                    this.w = new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ah(getContext(), this.ka);
                }
            }
        }
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar) {
        ms(msVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar, boolean z) {
        if (msVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.ka kaVar = this.sl;
        if (kaVar != null) {
            kaVar.ms(msVar);
        }
        if (z) {
            xr(msVar);
        }
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(int i, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (this.hi == null) {
            this.hi = new HashSet<>();
        }
        this.hi.add(Integer.valueOf(i));
        if (this.b != null) {
            this.b.call(9, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_HID, Integer.valueOf(i)).ms("id", Integer.valueOf(i)).ms(TTDownloadField.TT_ONEVENT_LOG_HANDLER, onEventLogHandler).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Void.class);
        }
    }

    public class ms extends com.bytedance.sdk.component.ch.ny {
        long ah;
        String d;
        String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f2620ms;
        long xr;

        ms() {
            super("DownloadCallbackRunnable");
        }

        ms(String str, long j, long j2, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.f2620ms = str;
            this.xr = j;
            this.ah = j2;
            this.d = str2;
            this.ka = str3;
        }

        public void ms(String str) {
            this.f2620ms = str;
        }

        public void ms(long j) {
            this.xr = j;
        }

        public void xr(long j) {
            this.ah = j;
        }

        public void xr(String str) {
            this.d = str;
        }

        public void ah(String str) {
            this.ka = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                x.this.sl().ms(x.this.ub, this.f2620ms, this.xr, this.ah, this.d, this.ka);
            } catch (Throwable unused) {
            }
        }
    }

    protected ao sl() {
        if (this.qv == null) {
            this.qv = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.xr.ms(com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext()).ms(3));
        }
        return this.qv;
    }

    protected void zb() {
        if (this.ah == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && com.bytedance.sdk.openadsdk.core.ch.ub().ms(activity)) {
            xr(activity);
        } else {
            h();
        }
    }

    private void xr(Activity activity) {
        com.bytedance.sdk.openadsdk.core.jw.ms msVarD = com.bytedance.sdk.openadsdk.core.ch.ub().d();
        if (msVarD != null && this.t == null) {
            this.t = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.h();
                    x.this.t = null;
                }
            };
            msVarD.ms(activity, this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            com.bytedance.sdk.component.ch.ab.ah().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.x.2
                @Override // java.lang.Runnable
                public void run() {
                    ao aoVarMs = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.xr.ms(com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext()).ms(3));
                    try {
                        synchronized (x.this.yu) {
                            if (aoVarMs != null) {
                                if (x.this.yu.size() > 0) {
                                    Iterator it = x.this.yu.iterator();
                                    while (it.hasNext()) {
                                        aoVarMs.xr(x.this.ub, (y) it.next());
                                    }
                                    x.this.yu.clear();
                                }
                            }
                        }
                    } catch (RemoteException e) {
                        com.bytedance.sdk.component.utils.sl.ms(e);
                    }
                }
            });
        }
    }

    protected void xr(final com.bytedance.sdk.openadsdk.core.hi.xr.ms msVar) {
        if (!com.bytedance.sdk.openadsdk.core.multipro.xr.ah() || msVar == null) {
            return;
        }
        com.bytedance.sdk.component.ch.ab.ah().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.x.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.ms msVarMs = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(re.getContext());
                com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.c cVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.c(msVar);
                ao aoVarMs = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.xr.ms(msVarMs.ms(3));
                if (aoVarMs != null) {
                    try {
                        aoVarMs.ms(x.this.ub, cVar);
                        synchronized (x.this.yu) {
                            try {
                                x.this.yu.add(cVar);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (RemoteException e) {
                        com.bytedance.sdk.component.utils.sl.ms(e);
                    }
                }
            }
        });
    }

    protected String ms(String str) {
        Uri uri;
        return (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || TextUtils.isEmpty(uri.getScheme())) ? "" : uri.getScheme().toLowerCase(Locale.US);
    }

    protected void ah(JSONObject jSONObject, boolean z) {
        com.bytedance.sdk.openadsdk.core.nw.ka kaVar = this.d;
        if (kaVar == null || kaVar.xr() == null) {
            return;
        }
        ms(jSONObject, z);
    }

    protected void ms(lm lmVar, String str, String str2, Throwable th) {
        if (ms()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, str, str2, th);
    }

    public boolean d() {
        if (this.ka.tc() != null) {
            String strXr = this.ka.tc().xr();
            if (!TextUtils.isEmpty(strXr)) {
                h.ms((String) null);
                Uri uri = Uri.parse(strXr);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                f.xr(intent);
                if (this.h) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ka, this.c, "lp_open_dpl", ms(strXr));
                }
                if (f.ms(getContext(), intent)) {
                    try {
                        f.ms(this.h, this.ka, this.c);
                        if (!ms(this.c, "open_url_app", this.ka)) {
                            HashMap map = new HashMap();
                            map.put("source", "DMLibManager");
                            com.bytedance.sdk.openadsdk.core.zb.ah.x(this.ka, this.c, "open_url_app", map);
                        }
                        com.bytedance.sdk.component.utils.xr.startActivity(getContext(), intent, TextUtils.equals("main", UMModuleRegister.INNER));
                        com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(this.ka, this.c, this.h);
                        if (this.h) {
                            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, this.c, "lp_openurl", (Throwable) null);
                            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, this.c, "lp_deeplink_success_realtime", (Throwable) null);
                        } else {
                            com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, this.c, "deeplink_success_realtime", (Throwable) null);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (!TextUtils.isEmpty(this.ka.ir())) {
                            ul.ms(getContext(), this.ka.ir(), this.ka, this.c);
                        }
                        if (this.h) {
                            com.bytedance.sdk.openadsdk.core.zb.ah.ah(this.ka, this.c, "lp_openurl_failed");
                            ms(this.ka, this.c, "lp_deeplink_fail_realtime", th);
                        } else {
                            ms(this.ka, this.c, "deeplink_fail_realtime", th);
                        }
                        return false;
                    }
                }
                if (this.h) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ah(this.ka, this.c, "lp_openurl_failed");
                    ms(this.ka, this.c, "lp_deeplink_fail_realtime", null);
                } else {
                    ms(this.ka, this.c, "deeplink_fail_realtime", null);
                }
            }
            if (this.ab.get() != 4 && this.ab.get() != 3 && (!this.ny || this.x.get())) {
                this.ny = true;
                if (!ms(this.c, "open_fallback_url", this.ka)) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.x(this.ka, this.c, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    protected boolean ms(String str, String str2, lm lmVar) {
        if (this.b == null) {
            return false;
        }
        return ((Boolean) this.b.call(2, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_TAG_INTERCEPT, str).ms(TTDownloadField.TT_LABEL, str2).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch())).ms(TTDownloadField.TT_META, lmVar.rm().toString())).xr(), Boolean.class)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms(JSONObject jSONObject, boolean z) {
        if (this.ab.get() == 1) {
            if (com.bytedance.sdk.component.utils.u.ah(getContext()) == 0) {
                try {
                    op.ms(getContext(), t.ms(getContext(), "tt_no_network"), 0);
                } catch (Exception unused) {
                }
            } else {
                if (f.xr(getContext())) {
                    f.ms(this.h, this.ka, this.c);
                }
                d(jSONObject, z);
            }
            return true;
        }
        if (f.xr(getContext())) {
            f.ms(this.h, this.ka, this.c);
        }
        xr(jSONObject, z);
        if (this.ab.get() == 3 || this.ab.get() == 4) {
            this.x.set(false);
            return false;
        }
        if (this.ab.get() != 6) {
            return false;
        }
        this.x.set(true);
        return false;
    }

    protected void ab(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ka, this.c, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ka, this.c, "quickapp_fail");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void x() {
        if (re.getContext() == null) {
            re.ms(getContext());
        }
        xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ms(boolean z, boolean z2) {
        this.u = z;
        return x(z2);
    }

    protected void ms(Map<String, Object> map) {
        Bridge bridge = this.b;
        if (bridge != null) {
            bridge.call(16, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, map).xr(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ny() {
        com.bytedance.sdk.openadsdk.core.hi.xr.ka kaVar = this.sl;
        if (kaVar != null) {
            kaVar.xr();
        }
        c();
        HashSet<Integer> hashSet = this.hi;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.hi);
            this.hi.clear();
            final Iterator it = hashSet2.iterator();
            com.bytedance.sdk.openadsdk.op.ab.ms(new com.bytedance.sdk.component.ch.ny("remove_log_hanlder") { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.x.4
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        if (x.this.b != null) {
                            x.this.b.call(3, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, new of().ms(TTDownloadField.TT_HID, Integer.valueOf(iIntValue)).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(x.this.ch()))).xr(), Void.class);
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.ah;
        if (weakReference != null) {
            weakReference.clear();
            this.ah = null;
        }
        this.w = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(Activity activity) {
        if (activity == null) {
            return;
        }
        this.ah = new WeakReference<>(activity);
        xr();
    }

    public int u() {
        return this.ab.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void d(boolean z) {
        this.i = z;
    }

    public void ah(boolean z) {
        this.h = z;
    }

    public void ms(Message message) {
        if (message.what != 9) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.ch.ub() != null && !com.bytedance.sdk.openadsdk.core.ch.ub().ms()) {
            ab(false);
            if (this.u) {
                Object obj = message.obj;
                ah(f.y(this.ka), obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false);
                return;
            }
            return;
        }
        ab(true);
    }

    protected void d(JSONObject jSONObject, boolean z) {
        c(jSONObject, z);
        this.x.set(true);
    }

    private void c(JSONObject jSONObject, boolean z) {
        xr(jSONObject, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(int i) {
        this.nw = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public Map<String, Object> ka() {
        return new HashMap();
    }

    protected void ms(String str, long j, long j2, String str2, String str3) {
        ms msVar = this.y;
        if (msVar == null) {
            this.y = new ms(str, j, j2, str2, str3);
        } else {
            msVar.ms(str);
            this.y.ms(j);
            this.y.xr(j2);
            this.y.xr(str2);
            this.y.ah(str3);
        }
        com.bytedance.sdk.component.ch.ab.ah().execute(this.y);
    }

    protected boolean ub() {
        if (this.b == null || nw.y(this.ka) == 1 || nw.ch(this.ka)) {
            return true;
        }
        if (!((Boolean) this.b.call(6, com.bykv.ms.ms.ms.ms.xr.ms().ms(0, new of().ms(TTDownloadField.TT_DOWNLOAD_URL, this.d.xr()).ms(TTDownloadField.TT_HASHCODE, Integer.valueOf(ch()))).xr(), Boolean.class)).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.x.5
            @Override // java.lang.Runnable
            public void run() {
                op.ms(x.this.getContext(), "应用正在下载...", 0);
            }
        });
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(final lm lmVar, final boolean z) {
        if (getContext() == null) {
            return;
        }
        this.ka = lmVar;
        qv();
        if (com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms(this.ka, false) && !com.bytedance.sdk.openadsdk.core.ugeno.ch.ka(this.ka) && !com.bytedance.sdk.openadsdk.core.ugeno.ch.d(this.ka)) {
            new com.bytedance.sdk.openadsdk.core.xr.ms.xr.d(this.ka, getContext()).ms(this.c).ms(new com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.x.6
                @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.d.ms
                public void ms() {
                    x.this.ab(f.y(lmVar), z);
                }
            });
        } else {
            ab(f.y(lmVar), z);
        }
    }

    private void qv() {
        if (this.ao) {
            return;
        }
        this.ao = true;
        ms(4, new ITTDownloadAdapter.OnEventLogHandler() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.x.7
            @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter.OnEventLogHandler
            public boolean onEventLog(int i, String str, String str2, String str3, Object obj) {
                if (i != 4) {
                    return true;
                }
                if ("market_click_open".equals(str3) || "applink_click".equals(str3)) {
                    com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_jump_success_ad_tag", str2);
                    com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_dpl_success_materialmeta", str);
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(final JSONObject jSONObject, final boolean z) {
        int iMs = com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.ka, new com.bytedance.sdk.openadsdk.core.live.ms.ah() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.x.8
            @Override // com.bytedance.sdk.openadsdk.core.live.ms.ah
            public void ms() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.live.ms.ah
            public void ms(int i) {
                x.this.x(jSONObject, z);
            }
        }, this.c);
        if (iMs == 1 || iMs == 2) {
            return;
        }
        x(jSONObject, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(final JSONObject jSONObject, final boolean z) {
        com.bytedance.sdk.openadsdk.core.live.xr xrVarMs = com.bytedance.sdk.openadsdk.core.live.xr.ms();
        HashMap map = new HashMap(1);
        map.put("event_tag", this.c);
        if ((xrVarMs.ms(getContext(), this.ka, map) & 255) == 0) {
            com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_jump_success_ad_tag", this.c);
            com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_dpl_success_materialmeta", this.ka.rm().toString());
            return;
        }
        hi().ms(ao(), this.ka);
        boolean zMs = com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.ms();
        if (zMs) {
            com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.ms(false);
        }
        if (!zMs) {
            if (new com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch(this.ka, getContext()).ms(this.c).ms(f.xr(this.c)).xr(this.h).ms(new com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ah.x.9
                @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.ms
                public void ms() {
                    com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_jump_success_ad_tag", x.this.c);
                    com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_dpl_success_materialmeta", x.this.ka.rm().toString());
                }

                @Override // com.bytedance.sdk.openadsdk.core.xr.ms.xr.ch.ms
                public void xr() {
                    x.this.ka(jSONObject, z);
                }
            })) {
                return;
            }
            ka(jSONObject, z);
            return;
        }
        ka(jSONObject, z);
    }

    protected void ka(JSONObject jSONObject, boolean z) {
        if (d()) {
            this.x.set(true);
            return;
        }
        if (!this.h && this.ka.zh() == null && this.ka.ir() != null && !this.ka.kr()) {
            ul.ms(getContext(), this.ka.ir(), this.ka, this.c);
        } else if (x(z)) {
            this.x.set(true);
        } else {
            if (this.ka.kr()) {
                return;
            }
            ah(jSONObject, z);
        }
    }

    protected com.bytedance.sdk.openadsdk.core.hi.ah.ah.ms ao() {
        if (ms()) {
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.ka();
        }
        if (this.h) {
            return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.d();
        }
        return new com.bytedance.sdk.openadsdk.core.hi.ah.ah.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public boolean ah() {
        lm lmVar = this.ka;
        return (lmVar == null || this.d == null || nw.c(lmVar) != 3 || this.d.ms() == null) ? false : true;
    }

    protected boolean x(boolean z) {
        if (this.d == null || !ah()) {
            return false;
        }
        boolean zMs = com.bytedance.sdk.openadsdk.core.hi.ah.xr.ah.ms(getContext(), this.d.ms(), this.ka, this.c, this.h);
        if (zMs) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 9;
            messageObtain.obj = Boolean.valueOf(z);
            this.zb.sendMessageDelayed(messageObtain, a.f);
            com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_jump_success_ad_tag", this.c);
            com.bytedance.sdk.openadsdk.core.xr.ms().ms("save_dpl_success_materialmeta", this.ka.rm().toString());
        } else {
            ab(false);
        }
        return zMs;
    }
}
