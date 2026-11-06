package com.byazt.wz;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qit.l;
import com.byazt.qit.x;
import com.byazt.qk.oa;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.byazt.vyf.s;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.comm.pi.ACTD;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsEncryptVersion, 19})
public class n implements com.byazt.ot.n.qg {
    public static HashMap<String, Long> l = null;
    public static volatile n n = null;
    public static final String q = "com.byazt.wz.n";
    public static final HashSet w;
    public CopyOnWriteArrayList<JSONObject> qg = new CopyOnWriteArrayList<>();
    public com.byazt.ot.n s;

    @Override // com.byazt.ot.n.qg
    public void q() {
    }

    @Override // com.byazt.ot.n.qg
    public void qg() {
    }

    @Override // com.byazt.ot.n.qg
    public void s() {
    }

    static {
        String name = n.class.getName();
        l = new HashMap<>();
        w = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", name));
    }

    public static n l() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    private n() {
        com.byazt.ot.n nVarS = s.cy().s();
        this.s = nVarS;
        if (nVarS != null) {
            nVarS.s(this);
        }
    }

    public void n(int i, com.byazt.zq.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        n(i, qgVar.q(), qgVar);
    }

    private boolean n(Long l2) {
        return !n(new Date(), new Date(l2.longValue()));
    }

    private boolean n(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    private boolean n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Long l2 = l.get(str);
            if (l2 != null && l2.longValue() != 0) {
                if (!n(l2)) {
                    return false;
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis > 0) {
                    l.put(str, Long.valueOf(jCurrentTimeMillis));
                }
            }
            return true;
        } catch (Throwable th) {
            k.n("callstack error:" + th.getMessage());
            return true;
        }
    }

    public void n(final int i, final String str, com.byazt.zq.qg qgVar) {
        if (qg.n() && n(str)) {
            if (qgVar == null || !qgVar.j()) {
                final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                l.n(new x("callChainStatistic") { // from class: com.byazt.wz.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.qg.add(n.this.n(i, str, stackTrace));
                        if (n.this.qg.size() < 3) {
                            return;
                        }
                        try {
                            n.this.w();
                        } catch (OutOfMemoryError unused) {
                        }
                    }
                }, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = this.qg;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.qg.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException unused) {
        }
        this.qg.clear();
        String strTj = w.tj("/api/ad/union/sdk/callstack/batch/");
        com.byazt.udc.s sVar = new com.byazt.udc.s();
        sVar.n(strTj);
        sVar.s(jSONObject, "callstack");
        sVar.n(new com.byazt.qk.x() { // from class: com.byazt.wz.n.2
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                if (oaVar != null) {
                    Object[] objArr = new Object[2];
                    Boolean.valueOf(oaVar.x());
                    oaVar.fs();
                }
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str, Throwable th) {
                th.getMessage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject n(int i, String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", str);
            jSONObject.put(ACTD.APPID_KEY, s.cy().ou());
            jSONObject.put("app_version", w.tj());
            jSONObject.put("ad_sdk_version", tj.w);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
            jSONObject.put("adtype", i);
            jSONObject.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("callstack", n(obj));
            jSONObject.put("type", "callstack");
            jSONObject.put("device_info", com.byazt.ehw.n.n(rv.getContext(), i));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private JSONArray n(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj == null) {
            return jSONArray;
        }
        for (StackTraceElement stackTraceElement : (StackTraceElement[]) obj) {
            if (stackTraceElement != null && !w.contains(stackTraceElement.getClassName() + i.E + stackTraceElement.getMethodName())) {
                String className = stackTraceElement.getClassName();
                if (className != null && className.startsWith("android.app")) {
                    break;
                }
                jSONArray.put(stackTraceElement.toString());
            }
        }
        return jSONArray;
    }

    @Override // com.byazt.ot.n.qg
    public void n() {
        if (s.cy().lh()) {
            return;
        }
        w();
    }
}
