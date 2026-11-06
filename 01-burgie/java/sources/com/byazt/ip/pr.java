package com.byazt.ip;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.wt.ls;
import com.byazt.wt.qi;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import com.qq.e.comm.pi.ACTD;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1193, 37})
public class pr implements com.byazt.wt.pr.hw {
    public static HashMap<String, Long> c;
    public static volatile pr pr;
    public static final HashSet uc;
    public static final String x;
    public com.byazt.wt.pr hn;
    public CopyOnWriteArrayList<JSONObject> hw = new CopyOnWriteArrayList<>();

    static {
        String name = pr.class.getName();
        x = name;
        c = new HashMap<>();
        uc = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", name));
    }

    public static pr c() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    private pr() {
        com.byazt.wt.pr prVarHn = zo.nt().hn();
        this.hn = prVarHn;
        if (prVarHn != null) {
            prVarHn.hn(this);
        }
    }

    public void pr(int i, com.byazt.qe.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        pr(i, hwVar.x(), hwVar);
    }

    private boolean pr(Long l) {
        return !pr(new Date(), new Date(l.longValue()));
    }

    private boolean pr(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    private boolean pr(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Long l = c.get(str);
            if (l != null && l.longValue() != 0) {
                if (!pr(l)) {
                    return false;
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis > 0) {
                    c.put(str, Long.valueOf(jCurrentTimeMillis));
                }
            }
            return true;
        } catch (Throwable th) {
            ho.pr("callstack error:" + th.getMessage());
            return true;
        }
    }

    public void pr(final int i, final String str, com.byazt.qe.hw hwVar) {
        if (!hw.pr() || !pr(str)) {
            return;
        }
        if (hwVar != null && hwVar.ve()) {
            return;
        }
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        c.pr(new fw("callChainStatistic") { // from class: com.byazt.ip.pr.1
            @Override // java.lang.Runnable
            public void run() {
                pr.this.hw.add(pr.this.pr(i, str, stackTrace));
                if (pr.this.hw.size() >= 3) {
                    try {
                        pr.this.uc();
                    } catch (OutOfMemoryError e) {
                    }
                }
            }
        }, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = this.hw;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.hw.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException e) {
        }
        this.hw.clear();
        String strVk = ls.vk("/api/ad/union/sdk/callstack/batch/");
        qi qiVar = new qi();
        qiVar.pr(strVk);
        qiVar.hn(jSONObject, "callstack");
        qiVar.pr(new com.byazt.hcx.fw() { // from class: com.byazt.ip.pr.2
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar != null) {
                    Object[] objArr = {Boolean.valueOf(mVar.fw()), mVar.zo()};
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str, Throwable th) {
                th.getMessage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject pr(int i, String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", str);
            jSONObject.put(ACTD.APPID_KEY, zo.nt().ny());
            jSONObject.put("app_version", ls.vk());
            jSONObject.put("ad_sdk_version", iu.c);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
            jSONObject.put("adtype", i);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("callstack", pr(obj));
            jSONObject.put("type", "callstack");
            jSONObject.put("device_info", com.byazt.mp.pr.pr(a.getContext(), i));
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    private JSONArray pr(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj == null) {
            return jSONArray;
        }
        for (StackTraceElement stackTraceElement : (StackTraceElement[]) obj) {
            if (stackTraceElement != null && !uc.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                String className = stackTraceElement.getClassName();
                if (className != null && className.startsWith("android.app")) {
                    break;
                }
                jSONArray.put(stackTraceElement.toString());
            }
        }
        return jSONArray;
    }

    @Override // com.byazt.wt.pr.hw
    public void pr() {
        if (zo.nt().y()) {
            return;
        }
        uc();
    }

    @Override // com.byazt.wt.pr.hw
    public void hw() {
    }

    @Override // com.byazt.wt.pr.hw
    public void hn() {
    }

    @Override // com.byazt.wt.pr.hw
    public void x() {
    }
}
