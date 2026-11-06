package com.byazt.xe;

import android.text.TextUtils;
import com.byazt.ca.aj;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1624, 37})
public class pr {
    public String fw;
    public final int k;
    public uc zo;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final AtomicBoolean uc = new AtomicBoolean(false);
    public List<of> pr = new ArrayList();
    public List<of> hw = new ArrayList();
    public List<of> hn = new ArrayList();
    public List<String> x = new ArrayList();
    public long aj = -1;
    public long vk = -1;
    public long w = -1;
    public final Runnable m = new Runnable() { // from class: com.byazt.xe.pr.1
        @Override // java.lang.Runnable
        public void run() {
            if (!pr.this.uc.get()) {
                pr.this.c.set(true);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(pr.this.hw);
                for (of ofVar : pr.this.hn) {
                    int iPr = pr.this.pr(ofVar);
                    if (iPr == 2) {
                        ofVar.aj(100009L);
                        arrayList.add(ofVar);
                    } else if (iPr == 1) {
                        ofVar.aj(100008L);
                    } else {
                        ofVar.aj(100003L);
                        arrayList2.add(ofVar);
                    }
                }
                if (!arrayList.isEmpty() && pr.this.zo != null) {
                    pr.this.zo.hn(arrayList);
                }
                pr.this.hw(arrayList2);
            }
        }
    };

    public pr(int i) {
        this.k = i;
    }

    public void pr() {
        this.zo = null;
        aj.hn().removeCallbacks(this.m);
    }

    public void pr(long j) {
        this.aj = j;
    }

    public void hw(long j) {
        this.vk = j;
    }

    private void hn(long j) {
        this.w = j;
    }

    public void pr(List<of> list, uc ucVar) {
        this.zo = ucVar;
        pr(list);
    }

    private void pr(List<of> list) {
        int i;
        boolean z;
        this.pr = list;
        this.hw.clear();
        this.hn.clear();
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        boolean z2 = false;
        for (of ofVar : list) {
            this.x.add(ofVar.ri());
            JSONObject jSONObjectXn = ofVar.xn();
            if (jSONObjectXn == null) {
                ofVar.zo(-1L);
                this.hw.add(ofVar);
            } else {
                int iOptInt = jSONObjectXn.optInt("cache_correct_type", i2);
                int iOptInt2 = jSONObjectXn.optInt("is_need_cache_correct", i2);
                int iOptInt3 = jSONObjectXn.optInt("is_need_cache_check", i2);
                int i5 = iOptInt == i3 ? i3 : i2;
                int i6 = iOptInt2 == i3 ? i3 : i2;
                int i7 = iOptInt3 == i3 ? i3 : i2;
                if (i5 == 0) {
                    this.hw.add(ofVar);
                    ofVar.zo(0L);
                } else if (i6 == 0 && i7 == 0) {
                    this.hw.add(ofVar);
                    ofVar.zo(2L);
                    ofVar.aj(100002L);
                } else if (i6 != 0) {
                    long jOptLong = jSONObjectXn.optLong("creative_check_duration", 0L);
                    if (jOptLong > 0) {
                        z = Math.abs(((double) (System.currentTimeMillis() / 1000)) - ls.nt(ofVar)) <= ((double) jOptLong);
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (i7 == 0) {
                            this.hw.add(ofVar);
                            ofVar.zo(4L);
                            ofVar.aj(100002L);
                        } else {
                            this.hn.add(ofVar);
                            ofVar.zo(6L);
                            i2 = 0;
                            i3 = 1;
                            i4 = 1;
                        }
                    } else if (i7 == 0) {
                        this.hn.add(ofVar);
                        ofVar.zo(5L);
                        i2 = 0;
                        i3 = 1;
                        z2 = true;
                    } else {
                        this.hn.add(ofVar);
                        ofVar.zo(7L);
                        i2 = 0;
                        i3 = 1;
                        i4 = 1;
                        z2 = true;
                    }
                } else {
                    this.hn.add(ofVar);
                    ofVar.zo(3L);
                    i4 = i3;
                }
            }
            i2 = 0;
            i3 = 1;
        }
        if (this.hn.isEmpty() || (i4 == 0 && !z2)) {
            hn(this.hw);
            return;
        }
        if (i4 != 0 && z2) {
            i = 3;
        } else if (i4 != 0) {
            i = 1;
        } else if (!z2) {
            i = 0;
        } else {
            i = 2;
        }
        pr(i, this.hn);
    }

    private void pr(final int i, final List<of> list) {
        Iterator<of> it = list.iterator();
        long jMin = 2147483647L;
        while (it.hasNext()) {
            JSONObject jSONObjectXn = it.next().xn();
            long jOptLong = jSONObjectXn == null ? 0L : jSONObjectXn.optLong("correct_interface_timeout", 0L);
            if (jOptLong > 0) {
                jMin = Math.min(jMin, jOptLong);
            }
        }
        if (jMin == 2147483647L) {
            jMin = 0;
        }
        if (jMin > 0) {
            aj.hn().postDelayed(this.m, jMin);
        }
        a.pr().pr(hw(i, list), new hw<c>() { // from class: com.byazt.xe.pr.2
            @Override // com.byazt.xe.hw
            public void pr(c cVar, long j, long j2) {
                try {
                    pr.this.pr(i, list, cVar, j);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });
    }

    private JSONObject hw(int i, List<of> list) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<of> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(hw(it.next()));
            }
            jSONObject.put("ads", jSONArray);
            jSONObject.put("check_type", i);
        } catch (JSONException e) {
            e.getMessage();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, List<of> list, c cVar, long j) throws JSONException {
        uc ucVar;
        if (this.c.get()) {
            return;
        }
        this.uc.set(true);
        if (cVar == null || cVar.pr()) {
            x(Collections.emptyList());
            return;
        }
        if (j != 20000) {
            Iterator<of> it = list.iterator();
            while (it.hasNext()) {
                it.next().aj(100001L);
            }
            hw(this.pr);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Map<String, JSONObject> map = cVar.hw;
        for (of ofVar : list) {
            String strPr = c.pr(ofVar.x(), ofVar.ny());
            JSONObject jSONObject = TextUtils.isEmpty(strPr) ? null : map.get(strPr);
            if (jSONObject == null) {
                ofVar.aj(100004L);
                arrayList.add(ofVar);
            } else {
                ofVar.vk(jSONObject.optLong("cali_timestamp", 0L));
                if (jSONObject.has("is_valid")) {
                    if (jSONObject.optBoolean("is_valid")) {
                        if (i == 2 || i == 3) {
                            String strOptString = jSONObject.optString("ext");
                            String strOptString2 = jSONObject.optString("media_ext");
                            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                                ofVar.aj(100006L);
                                arrayList.add(ofVar);
                            } else {
                                ofVar.z(strOptString);
                                ofVar.pr(pr(new JSONObject(strOptString2), ofVar.zc()));
                            }
                        }
                        ofVar.aj(100000L);
                        arrayList.add(ofVar);
                    } else {
                        arrayList2.add(ofVar);
                        this.fw = jSONObject.optString(MediationConstant.KEY_REASON);
                        ofVar.aj(100007L);
                    }
                } else {
                    ofVar.aj(100005L);
                    arrayList.add(ofVar);
                }
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            hn((of) it2.next());
        }
        if (!arrayList2.isEmpty() && (ucVar = this.zo) != null) {
            ucVar.hn(arrayList2);
        }
        arrayList.addAll(this.hw);
        hw(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(List<of> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : this.x) {
            for (of ofVar : list) {
                if (str.equals(ofVar.ri())) {
                    arrayList.add(ofVar);
                }
            }
        }
        x(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pr(of ofVar) {
        JSONObject jSONObjectXn = ofVar == null ? null : ofVar.xn();
        int iOptInt = jSONObjectXn == null ? 0 : jSONObjectXn.optInt("cache_correct_fallback_type", 0);
        if (iOptInt != 0 && iOptInt != 1 && iOptInt != 2) {
            return 0;
        }
        return iOptInt;
    }

    public static Map<String, Object> pr(JSONObject jSONObject, Map<String, Object> map) {
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

    private JSONObject hw(of ofVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strX = ofVar.x();
            String strB_ = ofVar.B_();
            Map<String, Object> mapZc = ofVar.zc();
            String string = "";
            if (mapZc != null) {
                JSONObject jSONObject2 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = mapZc.entrySet();
                if (!setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                if (jSONObject2.length() > 0) {
                    string = jSONObject2.toString();
                }
            }
            pr(strX, strB_, string, ofVar.ny(), jSONObject);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private void pr(String str, String str2, String str3, String str4, JSONObject jSONObject) throws JSONException {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(str).append("&timestamp=").append(iCurrentTimeMillis).append("&ext=").append(str2).append("&media_ext=").append(str3).append("&req_id=").append(str4);
        String upperCase = com.byazt.ca.c.hw(sb.toString()).toUpperCase();
        jSONObject.put("id", str);
        jSONObject.put("timestamp", iCurrentTimeMillis);
        jSONObject.put("ext", str2);
        jSONObject.put("media_ext", str3);
        jSONObject.put("req_id", str4);
        jSONObject.put("sign", upperCase);
    }

    private void hn(List<of> list) {
        list.size();
        Iterator<of> it = list.iterator();
        while (it.hasNext()) {
            hn(it.next());
        }
        uc ucVar = this.zo;
        if (ucVar != null) {
            ucVar.pr(list);
        }
        pr();
    }

    private void x(List<of> list) {
        list.size();
        Iterator<of> it = list.iterator();
        while (it.hasNext()) {
            hn(it.next());
        }
        uc ucVar = this.zo;
        if (ucVar != null) {
            ucVar.hw(list);
        }
        pr();
    }

    private void hn(of ofVar) {
        hn(System.currentTimeMillis());
        if (ofVar.mj() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String strHw = ls.hw(this.k);
            long j = this.vk;
            long j2 = this.aj;
            jSONObject.put("cache_get_duration", j - j2 < 0 ? -1L : j - j2);
            long j3 = this.w;
            long j4 = this.vk;
            jSONObject.put("network_check_duration", j3 - j4 < 0 ? -1L : j3 - j4);
            long j5 = this.w;
            long j6 = this.aj;
            jSONObject.put("cache_total_duration", j5 - j6 < 0 ? -1L : j5 - j6);
            jSONObject.put("cache_loss_reason", this.fw);
            jSONObject.put("creative_check_duration", ofVar.xn() != null ? ofVar.xn().optLong("creative_check_duration", 0L) : -1L);
            hn.pr(ofVar, jSONObject, false);
            com.byazt.pj.pr.hn(ofVar, strHw, jSONObject);
        } catch (Exception e) {
        }
    }
}
