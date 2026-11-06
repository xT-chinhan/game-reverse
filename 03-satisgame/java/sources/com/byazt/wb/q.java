package com.byazt.wb;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1324, 5})
public class q implements Comparable<q> {
    public int l;
    public final String qg;
    public int s;
    public long sz;
    public int x;
    public final ArrayList<Long> n = new ArrayList<>();
    public final ArrayList<Long> q = new ArrayList<>();
    public final ArrayList<Long> w = new ArrayList<>();
    public final ArrayList<Long> fs = new ArrayList<>();
    public final HashMap<String, l> rv = new HashMap<>();
    public int tj = 0;
    public int cp = 0;
    public final HashMap<String, l> d = new HashMap<>();
    public int oa = 0;

    public q(String str) {
        this.qg = str;
    }

    public void n(String str, String str2) {
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        l lVar5;
        l lVar6;
        str.hashCode();
        switch (str) {
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (lVar = this.d.get(str2)) != null) {
                    lVar.q(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (lVar2 = this.d.get(str2)) != null) {
                    lVar2.s(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2)) {
                    l lVar7 = this.d.get(str2);
                    if (lVar7 == null) {
                        lVar7 = new l();
                        this.d.put(str2, lVar7);
                    }
                    lVar7.n(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
                if (!TextUtils.isEmpty(str2) && (lVar3 = this.rv.get(str2)) != null && lVar3.n() != l.l) {
                    lVar3.qg(SystemClock.elapsedRealtime());
                    if (rv.qg().m36if()) {
                        this.tj = (int) (((long) this.tj) + lVar3.n(this.sz, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "show":
                this.n.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (rv.qg().m36if()) {
                    this.s++;
                    break;
                }
                break;
            case "click":
                this.q.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (rv.qg().m36if()) {
                    this.l++;
                    break;
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (lVar4 = this.rv.get(str2)) != null) {
                    lVar4.q(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (lVar5 = this.rv.get(str2)) != null) {
                    lVar5.s(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (lVar6 = this.d.get(str2)) != null && lVar6.n() != l.l) {
                    lVar6.qg(SystemClock.elapsedRealtime());
                    if (rv.qg().m36if()) {
                        this.oa = (int) (((long) this.oa) + lVar6.n(this.sz, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "videoPercent30":
                if (rv.qg().m36if()) {
                    this.cp++;
                    break;
                }
                break;
            case "dislike":
                this.fs.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
            case "play_start":
                this.w.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (rv.qg().m36if()) {
                    this.x++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    l lVar8 = this.rv.get(str2);
                    if (lVar8 == null) {
                        lVar8 = new l();
                        this.rv.put(str2, lVar8);
                    }
                    lVar8.n(SystemClock.elapsedRealtime());
                    break;
                }
                break;
        }
    }

    public JSONArray n() {
        JSONArray jSONArray = new JSONArray();
        try {
            n(jSONArray);
            qg(jSONArray);
        } catch (Throwable th) {
            k.n(th.getMessage());
        }
        return jSONArray;
    }

    private void n(String str, JSONArray jSONArray, ArrayList<Long> arrayList, List<Integer> list, long j) throws JSONException {
        int size = arrayList.size() - 1;
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            long j2 = j - (((long) iIntValue) * 60000);
            while (size >= 0 && arrayList.get(size).longValue() >= j2) {
                i++;
                size--;
            }
            if (i != 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", str + iIntValue);
                jSONObject.put("v", i);
                jSONArray.put(jSONObject);
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void n(JSONArray jSONArray) throws JSONException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        n("show_", jSONArray, this.n, rv.qg().jb(), jElapsedRealtime);
        n("click_", jSONArray, this.q, rv.qg().jb(), jElapsedRealtime);
        n("play_", jSONArray, this.w, rv.qg().jb(), jElapsedRealtime);
        n("dis_", jSONArray, this.fs, rv.qg().jb(), jElapsedRealtime);
        if (rv.qg().m36if() && this.s != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t", "show_0");
            jSONObject.put("v", this.s);
            jSONArray.put(jSONObject);
        }
        if (rv.qg().m36if() && this.l != 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("t", "click_0");
            jSONObject2.put("v", this.l);
            jSONArray.put(jSONObject2);
        }
        if (!rv.qg().m36if() || this.x == 0) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("t", "play_0");
        jSONObject3.put("v", this.x);
        jSONArray.put(jSONObject3);
    }

    private void qg(JSONArray jSONArray) throws JSONException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        List<Integer> listJb = rv.qg().jb();
        long j = 60000;
        if (listJb != null) {
            int i = 0;
            while (i < listJb.size()) {
                int iIntValue = listJb.get(i).intValue();
                long j2 = jElapsedRealtime - (((long) iIntValue) * j);
                Iterator<String> it = this.d.keySet().iterator();
                long jN = 0;
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    HashSet hashSet3 = hashSet2;
                    l lVar = this.d.get(it.next());
                    if (lVar != null) {
                        jN += lVar.n(j2, jElapsedRealtime);
                    }
                    hashSet2 = hashSet3;
                    it = it2;
                }
                HashSet hashSet4 = hashSet2;
                if (jN != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", "lpstay_".concat(String.valueOf(iIntValue)));
                    jSONObject.put("v", jN);
                    jSONArray.put(jSONObject);
                }
                i++;
                hashSet2 = hashSet4;
                j = 60000;
            }
        }
        HashSet hashSet5 = hashSet2;
        if (listJb != null) {
            int i2 = 0;
            while (i2 < listJb.size()) {
                int iIntValue2 = listJb.get(i2).intValue();
                long j3 = jElapsedRealtime - (((long) iIntValue2) * 60000);
                Iterator<String> it3 = this.rv.keySet().iterator();
                long jN2 = 0;
                while (it3.hasNext()) {
                    List<Integer> list = listJb;
                    l lVar2 = this.rv.get(it3.next());
                    if (lVar2 != null) {
                        jN2 += lVar2.n(j3, jElapsedRealtime);
                    }
                    listJb = list;
                }
                List<Integer> list2 = listJb;
                if (jN2 != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("t", "vstay_".concat(String.valueOf(iIntValue2)));
                    jSONObject2.put("v", jN2);
                    jSONArray.put(jSONObject2);
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    this.d.remove((String) it4.next());
                }
                Iterator it5 = hashSet5.iterator();
                while (it5.hasNext()) {
                    this.rv.remove((String) it5.next());
                }
                i2++;
                listJb = list2;
            }
        }
        if (rv.qg().m36if() && this.tj != 0) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("t", "vstay_0");
            jSONObject3.put("v", this.tj);
            jSONArray.put(jSONObject3);
        }
        if (rv.qg().m36if() && this.oa != 0) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("t", "lpstay_0");
            jSONObject4.put("v", this.oa);
            jSONArray.put(jSONObject4);
        }
        if (this.cp != 0) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("t", "v30p");
            jSONObject5.put("v", this.cp);
            jSONArray.put(jSONObject5);
        }
    }

    public void qg() {
        this.sz = SystemClock.elapsedRealtime();
        this.cp = 0;
        this.l = 0;
        this.s = 0;
        this.oa = 0;
        this.tj = 0;
        this.x = 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int compareTo(q qVar) {
        return qVar.s - this.s;
    }
}
