package com.byazt.fxc;

import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.gct.pk;
import com.byazt.tk.rv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1743, 19})
public class n {
    public final int d;
    public w fs;
    public String x;
    public final AtomicBoolean l = new AtomicBoolean(false);
    public final AtomicBoolean w = new AtomicBoolean(false);
    public List<pk> n = new ArrayList();
    public List<pk> qg = new ArrayList();
    public List<pk> s = new ArrayList();
    public List<String> q = new ArrayList();
    public long rv = -1;
    public long tj = -1;
    public long cp = -1;
    public final Runnable oa = new Runnable() { // from class: com.byazt.fxc.n.1
        @Override // java.lang.Runnable
        public void run() {
            if (n.this.w.get()) {
                return;
            }
            n.this.l.set(true);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(n.this.qg);
            for (pk pkVar : n.this.s) {
                int iN = n.this.n(pkVar);
                if (iN == 2) {
                    pkVar.rv(100009L);
                    arrayList.add(pkVar);
                } else if (iN == 1) {
                    pkVar.rv(100008L);
                } else {
                    pkVar.rv(100003L);
                    arrayList2.add(pkVar);
                }
            }
            if (!arrayList.isEmpty() && n.this.fs != null) {
                n.this.fs.s(arrayList);
            }
            n.this.qg(arrayList2);
        }
    };

    public n(int i) {
        this.d = i;
    }

    public void n() {
        this.fs = null;
        rv.s().removeCallbacks(this.oa);
    }

    public void n(long j) {
        this.rv = j;
    }

    public void qg(long j) {
        this.tj = j;
    }

    private void s(long j) {
        this.cp = j;
    }

    public void n(List<pk> list, w wVar) {
        this.fs = wVar;
        n(list);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00da  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e6  */
    private void n(List<pk> list) {
        int i;
        boolean z;
        boolean z2;
        this.n = list;
        this.qg.clear();
        this.s.clear();
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        for (pk pkVar : list) {
            this.q.add(pkVar.cs());
            JSONObject jSONObjectPz = pkVar.pz();
            if (jSONObjectPz == null) {
                pkVar.fs(-1L);
                this.qg.add(pkVar);
            } else {
                int iOptInt = jSONObjectPz.optInt("cache_correct_type", i2);
                int iOptInt2 = jSONObjectPz.optInt("is_need_cache_correct", i2);
                int iOptInt3 = jSONObjectPz.optInt("is_need_cache_check", i2);
                int i3 = iOptInt == 1 ? 1 : i2;
                int i4 = iOptInt2 == 1 ? 1 : i2;
                int i5 = iOptInt3 == 1 ? 1 : i2;
                if (i3 == 0) {
                    this.qg.add(pkVar);
                    pkVar.fs(0L);
                } else if (i4 == 0 && i5 == 0) {
                    this.qg.add(pkVar);
                    pkVar.fs(2L);
                    pkVar.rv(100002L);
                } else if (i4 == 0) {
                    this.s.add(pkVar);
                    pkVar.fs(3L);
                    z3 = true;
                } else {
                    long jOptLong = jSONObjectPz.optLong("creative_check_duration", 0L);
                    if (jOptLong > 0) {
                        z = z3;
                        z2 = Math.abs(((double) (System.currentTimeMillis() / 1000)) - com.byazt.vgx.w.um(pkVar)) <= ((double) jOptLong);
                        if (z2) {
                            if (i5 == 0) {
                                this.qg.add(pkVar);
                                pkVar.fs(4L);
                                pkVar.rv(100002L);
                                z3 = z;
                            } else {
                                this.s.add(pkVar);
                                pkVar.fs(6L);
                                z3 = true;
                            }
                        } else if (i5 == 0) {
                            this.s.add(pkVar);
                            pkVar.fs(5L);
                            z4 = true;
                            z3 = z;
                        } else {
                            this.s.add(pkVar);
                            pkVar.fs(7L);
                            z3 = true;
                            z4 = true;
                        }
                        i2 = 0;
                    } else {
                        z = z3;
                    }
                    if (z2) {
                        if (i5 == 0) {
                            this.qg.add(pkVar);
                            pkVar.fs(4L);
                            pkVar.rv(100002L);
                            z3 = z;
                        } else {
                            this.s.add(pkVar);
                            pkVar.fs(6L);
                            z3 = true;
                        }
                    } else if (i5 == 0) {
                        this.s.add(pkVar);
                        pkVar.fs(5L);
                        z4 = true;
                        z3 = z;
                    } else {
                        this.s.add(pkVar);
                        pkVar.fs(7L);
                        z3 = true;
                        z4 = true;
                    }
                    i2 = 0;
                }
            }
            z = z3;
            z3 = z;
            i2 = 0;
        }
        boolean z5 = z3;
        if (this.s.isEmpty() || (!z5 && !z4)) {
            s(this.qg);
            return;
        }
        if (z5 && z4) {
            i = 3;
        } else if (z5) {
            i = 1;
        } else {
            i = z4 ? 2 : 0;
        }
        n(i, this.s);
    }

    private void n(final int i, final List<pk> list) {
        Iterator<pk> it = list.iterator();
        long jMin = 2147483647L;
        while (it.hasNext()) {
            JSONObject jSONObjectPz = it.next().pz();
            long jOptLong = jSONObjectPz == null ? 0L : jSONObjectPz.optLong("correct_interface_timeout", 0L);
            if (jOptLong > 0) {
                jMin = Math.min(jMin, jOptLong);
            }
        }
        if (jMin == 2147483647L) {
            jMin = 0;
        }
        if (jMin > 0) {
            rv.s().postDelayed(this.oa, jMin);
        }
        com.byazt.nf.rv.n().n(qg(i, list), new qg<l>() { // from class: com.byazt.fxc.n.2
            @Override // com.byazt.fxc.qg
            public void n(l lVar, long j, long j2) {
                try {
                    n.this.n(i, list, lVar, j);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });
    }

    private JSONObject qg(int i, List<pk> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<pk> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(qg(it.next()));
            }
            jSONObject.put("ads", jSONArray);
            jSONObject.put("check_type", i);
        } catch (JSONException e) {
            e.getMessage();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, List<pk> list, l lVar, long j) throws JSONException {
        w wVar;
        if (this.l.get()) {
            return;
        }
        this.w.set(true);
        if (lVar == null || lVar.n()) {
            q(Collections.emptyList());
            return;
        }
        if (j != 20000) {
            Iterator<pk> it = list.iterator();
            while (it.hasNext()) {
                it.next().rv(100001L);
            }
            qg(this.n);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, JSONObject> map = lVar.qg;
        for (pk pkVar : list) {
            String strN = l.n(pkVar.q(), pkVar.ou());
            JSONObject jSONObject = TextUtils.isEmpty(strN) ? null : map.get(strN);
            if (jSONObject == null) {
                pkVar.rv(100004L);
                arrayList.add(pkVar);
            } else {
                pkVar.tj(jSONObject.optLong("cali_timestamp", 0L));
                if (jSONObject.has("is_valid")) {
                    if (jSONObject.optBoolean("is_valid")) {
                        if (i == 2 || i == 3) {
                            String strOptString = jSONObject.optString("ext");
                            String strOptString2 = jSONObject.optString("media_ext");
                            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                                pkVar.rv(100006L);
                                arrayList.add(pkVar);
                            } else {
                                pkVar.t(strOptString);
                                pkVar.n(n(new JSONObject(strOptString2), pkVar.wl()));
                            }
                        }
                        pkVar.rv(100000L);
                        arrayList.add(pkVar);
                    } else {
                        arrayList2.add(pkVar);
                        this.x = jSONObject.optString(MediationConstant.KEY_REASON);
                        pkVar.rv(100007L);
                    }
                } else {
                    pkVar.rv(100005L);
                    arrayList.add(pkVar);
                }
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            s((pk) it2.next());
        }
        if (!arrayList2.isEmpty() && (wVar = this.fs) != null) {
            wVar.s(arrayList2);
        }
        arrayList.addAll(this.qg);
        qg(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(List<pk> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : this.q) {
            for (pk pkVar : list) {
                if (str.equals(pkVar.cs())) {
                    arrayList.add(pkVar);
                }
            }
        }
        q(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n(pk pkVar) {
        JSONObject jSONObjectPz = pkVar == null ? null : pkVar.pz();
        int iOptInt = jSONObjectPz == null ? 0 : jSONObjectPz.optInt("cache_correct_fallback_type", 0);
        if (iOptInt == 0 || iOptInt == 1 || iOptInt == 2) {
            return iOptInt;
        }
        return 0;
    }

    public static Map<String, Object> n(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject == null) {
            return map;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, jSONObject.opt(next));
            }
        }
        return map;
    }

    private JSONObject qg(pk pkVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strQ = pkVar.q();
            String strF_ = pkVar.F_();
            Map<String, Object> mapWl = pkVar.wl();
            String string = "";
            if (mapWl != null) {
                JSONObject jSONObject2 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = mapWl.entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                if (jSONObject2.length() > 0) {
                    string = jSONObject2.toString();
                }
            }
            n(strQ, strF_, string, pkVar.ou(), jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void n(String str, String str2, String str3, String str4, JSONObject jSONObject) throws JSONException {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        StringBuilder sb = new StringBuilder("id=");
        sb.append(str).append("&timestamp=").append(iCurrentTimeMillis).append("&ext=").append(str2).append("&media_ext=").append(str3).append("&req_id=").append(str4);
        String upperCase = com.byazt.tk.l.qg(sb.toString()).toUpperCase();
        jSONObject.put("id", str);
        jSONObject.put(TapEventParamConstants.PARAM_SUB_TIMESTAMP, iCurrentTimeMillis);
        jSONObject.put("ext", str2);
        jSONObject.put("media_ext", str3);
        jSONObject.put("req_id", str4);
        jSONObject.put(f.Y, upperCase);
    }

    private void s(List<pk> list) {
        list.size();
        Iterator<pk> it = list.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        w wVar = this.fs;
        if (wVar != null) {
            wVar.n(list);
        }
        n();
    }

    private void q(List<pk> list) {
        list.size();
        Iterator<pk> it = list.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        w wVar = this.fs;
        if (wVar != null) {
            wVar.qg(list);
        }
        n();
    }

    private void s(pk pkVar) {
        s(System.currentTimeMillis());
        if (pkVar.ec() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String strQg = com.byazt.vgx.w.qg(this.d);
            long j = this.tj;
            long j2 = this.rv;
            jSONObject.put("cache_get_duration", j - j2 < 0 ? -1L : j - j2);
            long j3 = this.cp;
            long j4 = this.tj;
            jSONObject.put("network_check_duration", j3 - j4 < 0 ? -1L : j3 - j4);
            long j5 = this.cp;
            long j6 = this.rv;
            jSONObject.put("cache_total_duration", j5 - j6 < 0 ? -1L : j5 - j6);
            jSONObject.put("cache_loss_reason", this.x);
            jSONObject.put("creative_check_duration", pkVar.pz() != null ? pkVar.pz().optLong("creative_check_duration", 0L) : -1L);
            s.n(pkVar, jSONObject, false);
            com.byazt.hm.n.s(pkVar, strQg, jSONObject);
        } catch (Exception unused) {
        }
    }
}
