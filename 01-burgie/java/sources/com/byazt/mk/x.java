package com.byazt.mk;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.sd.a;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1191, 121})
public class x implements Comparable<x> {
    public int c;
    public int fw;
    public long g;
    public int hn;
    public final String hw;
    public final ArrayList<Long> pr = new ArrayList<>();
    public final ArrayList<Long> x = new ArrayList<>();
    public final ArrayList<Long> uc = new ArrayList<>();
    public final ArrayList<Long> zo = new ArrayList<>();
    public final HashMap<String, c> aj = new HashMap<>();
    public int vk = 0;
    public int w = 0;
    public final HashMap<String, c> k = new HashMap<>();
    public int m = 0;

    public x(String str) {
        this.hw = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x0094  */
    public void pr(String str, String str2) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        switch (str) {
            case "show":
                this.pr.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (a.hw().cu()) {
                    this.hn++;
                    break;
                }
                break;
            case "click":
                this.x.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (a.hw().cu()) {
                    this.c++;
                    break;
                }
                break;
            case "play_start":
                this.uc.add(Long.valueOf(SystemClock.elapsedRealtime()));
                if (a.hw().cu()) {
                    this.fw++;
                }
                if (!TextUtils.isEmpty(str2)) {
                    c cVar7 = this.aj.get(str2);
                    if (cVar7 == null) {
                        cVar7 = new c();
                        this.aj.put(str2, cVar7);
                    }
                    cVar7.pr(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "dislike":
                this.zo.add(Long.valueOf(SystemClock.elapsedRealtime()));
                break;
            case "landingStart":
                if (!TextUtils.isEmpty(str2)) {
                    c cVar8 = this.k.get(str2);
                    if (cVar8 == null) {
                        cVar8 = new c();
                        this.k.put(str2, cVar8);
                    }
                    cVar8.pr(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingContinue":
                if (!TextUtils.isEmpty(str2) && (cVar = this.k.get(str2)) != null) {
                    cVar.x(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingPause":
                if (!TextUtils.isEmpty(str2) && (cVar2 = this.k.get(str2)) != null) {
                    cVar2.hn(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "landingFinish":
                if (!TextUtils.isEmpty(str2) && (cVar3 = this.k.get(str2)) != null && cVar3.pr() != c.c) {
                    cVar3.hw(SystemClock.elapsedRealtime());
                    if (a.hw().cu()) {
                        this.m = (int) (((long) this.m) + cVar3.pr(this.g, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "feed_pause":
                if (!TextUtils.isEmpty(str2) && (cVar4 = this.aj.get(str2)) != null) {
                    cVar4.hn(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_continue":
                if (!TextUtils.isEmpty(str2) && (cVar5 = this.aj.get(str2)) != null) {
                    cVar5.x(SystemClock.elapsedRealtime());
                    break;
                }
                break;
            case "feed_over":
            case "feed_break":
                if (!TextUtils.isEmpty(str2) && (cVar6 = this.aj.get(str2)) != null && cVar6.pr() != c.c) {
                    cVar6.hw(SystemClock.elapsedRealtime());
                    if (a.hw().cu()) {
                        this.vk = (int) (((long) this.vk) + cVar6.pr(this.g, SystemClock.elapsedRealtime()));
                    }
                    break;
                }
                break;
            case "videoPercent30":
                if (a.hw().cu()) {
                    this.w++;
                    break;
                }
                break;
        }
    }

    public JSONArray pr() {
        JSONArray jSONArray = new JSONArray();
        try {
            pr(jSONArray);
            hw(jSONArray);
        } catch (Throwable th) {
            ho.pr(th.getMessage());
        }
        return jSONArray;
    }

    private void pr(String str, JSONArray jSONArray, ArrayList<Long> arrayList, List<Integer> list, long j) throws JSONException {
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
                jSONObject.put(an.aI, str + iIntValue);
                jSONObject.put(an.aE, i);
                jSONArray.put(jSONObject);
            }
        }
        while (size >= 0) {
            arrayList.remove(0);
            size--;
        }
    }

    private void pr(JSONArray jSONArray) throws JSONException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        pr("show_", jSONArray, this.pr, a.hw().io(), jElapsedRealtime);
        pr("click_", jSONArray, this.x, a.hw().io(), jElapsedRealtime);
        pr("play_", jSONArray, this.uc, a.hw().io(), jElapsedRealtime);
        pr("dis_", jSONArray, this.zo, a.hw().io(), jElapsedRealtime);
        if (a.hw().cu() && this.hn != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(an.aI, "show_0");
            jSONObject.put(an.aE, this.hn);
            jSONArray.put(jSONObject);
        }
        if (a.hw().cu() && this.c != 0) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(an.aI, "click_0");
            jSONObject2.put(an.aE, this.c);
            jSONArray.put(jSONObject2);
        }
        if (a.hw().cu() && this.fw != 0) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(an.aI, "play_0");
            jSONObject3.put(an.aE, this.fw);
            jSONArray.put(jSONObject3);
        }
    }

    private void hw(JSONArray jSONArray) throws JSONException {
        HashSet hashSet;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        List<Integer> listIo = a.hw().io();
        long j = 60000;
        if (listIo == null) {
            hashSet = hashSet3;
        } else {
            int i = 0;
            while (i < listIo.size()) {
                int iIntValue = listIo.get(i).intValue();
                long j2 = jElapsedRealtime - (((long) iIntValue) * j);
                Iterator<String> it = this.k.keySet().iterator();
                long jPr = 0;
                while (it.hasNext()) {
                    Iterator<String> it2 = it;
                    HashSet hashSet4 = hashSet3;
                    c cVar = this.k.get(it.next());
                    if (cVar != null) {
                        jPr += cVar.pr(j2, jElapsedRealtime);
                    }
                    hashSet3 = hashSet4;
                    it = it2;
                }
                HashSet hashSet5 = hashSet3;
                if (jPr != 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(an.aI, "lpstay_".concat(String.valueOf(iIntValue)));
                    jSONObject.put(an.aE, jPr);
                    jSONArray.put(jSONObject);
                }
                i++;
                hashSet3 = hashSet5;
                j = 60000;
            }
            hashSet = hashSet3;
        }
        if (listIo != null) {
            int i2 = 0;
            while (i2 < listIo.size()) {
                int iIntValue2 = listIo.get(i2).intValue();
                long j3 = jElapsedRealtime - (((long) iIntValue2) * 60000);
                Iterator<String> it3 = this.aj.keySet().iterator();
                long jPr2 = 0;
                while (it3.hasNext()) {
                    List<Integer> list = listIo;
                    c cVar2 = this.aj.get(it3.next());
                    if (cVar2 != null) {
                        jPr2 += cVar2.pr(j3, jElapsedRealtime);
                    }
                    listIo = list;
                }
                List<Integer> list2 = listIo;
                if (jPr2 != 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(an.aI, "vstay_".concat(String.valueOf(iIntValue2)));
                    jSONObject2.put(an.aE, jPr2);
                    jSONArray.put(jSONObject2);
                }
                Iterator it4 = hashSet2.iterator();
                while (it4.hasNext()) {
                    this.k.remove((String) it4.next());
                }
                Iterator it5 = hashSet.iterator();
                while (it5.hasNext()) {
                    this.aj.remove((String) it5.next());
                }
                i2++;
                listIo = list2;
            }
        }
        if (a.hw().cu() && this.vk != 0) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(an.aI, "vstay_0");
            jSONObject3.put(an.aE, this.vk);
            jSONArray.put(jSONObject3);
        }
        if (a.hw().cu() && this.m != 0) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(an.aI, "lpstay_0");
            jSONObject4.put(an.aE, this.m);
            jSONArray.put(jSONObject4);
        }
        if (this.w != 0) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(an.aI, "v30p");
            jSONObject5.put(an.aE, this.w);
            jSONArray.put(jSONObject5);
        }
    }

    public void hw() {
        this.g = SystemClock.elapsedRealtime();
        this.w = 0;
        this.c = 0;
        this.hn = 0;
        this.m = 0;
        this.vk = 0;
        this.fw = 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public int compareTo(x xVar) {
        return xVar.hn - this.hn;
    }
}
