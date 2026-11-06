package com.mar.sdk.gg.control;

import com.mar.sdk.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class WeightRandom {
    private static final String TAG = "MARSDK";
    List<WeightCategory> categorys = new ArrayList();
    private Random random = new Random();

    public void initData(int a, int b, int c, int d) {
        this.categorys.clear();
        WeightCategory wc1 = new WeightCategory("A", Integer.valueOf(a * 10));
        WeightCategory wc2 = new WeightCategory("B", Integer.valueOf(b * 10));
        WeightCategory wc3 = new WeightCategory("C", Integer.valueOf(c * 10));
        WeightCategory wc4 = new WeightCategory("D", Integer.valueOf(d * 10));
        this.categorys.add(wc1);
        this.categorys.add(wc2);
        this.categorys.add(wc3);
        this.categorys.add(wc4);
        Log.d(TAG, "This total weightSum A =  " + wc1.getWeight());
        Log.d(TAG, "This total weightSum B =  " + wc2.getWeight());
        Log.d(TAG, "This total weightSum C =  " + wc3.getWeight());
        Log.d(TAG, "This total weightSum D =  " + wc4.getWeight());
    }

    public String getRandomForInters(int a, int b, int c) {
        return getRandomForInters(a, b, c, 0);
    }

    public String getRandomForInters(int a, int b, int c, int d) {
        initData(a, b, c, d);
        Integer weightSum = 0;
        Iterator<WeightCategory> it = this.categorys.iterator();
        while (it.hasNext()) {
            weightSum = Integer.valueOf(weightSum.intValue() + it.next().getWeight().intValue());
        }
        if (weightSum.intValue() <= 0) {
            Log.d(TAG, "Error: weightSum=" + weightSum.toString());
            return "";
        }
        Integer n = Integer.valueOf(this.random.nextInt(weightSum.intValue()));
        Integer m = 0;
        for (WeightCategory wc : this.categorys) {
            if (m.intValue() <= n.intValue() && n.intValue() < m.intValue() + wc.getWeight().intValue()) {
                Log.d(TAG, "This Random Category is " + wc.getCategory());
                return wc.getCategory();
            }
            m = Integer.valueOf(m.intValue() + wc.getWeight().intValue());
        }
        return "";
    }

    public String getRandomForInters(int a, int b, int c, int d, int e) {
        initData(a, b, c, d);
        Integer weightSum = 0;
        Iterator<WeightCategory> it = this.categorys.iterator();
        while (it.hasNext()) {
            weightSum = Integer.valueOf(weightSum.intValue() + it.next().getWeight().intValue());
        }
        if (weightSum.intValue() <= 0) {
            Log.d(TAG, "Error: weightSum=" + weightSum.toString());
            return "";
        }
        Integer n = Integer.valueOf(this.random.nextInt(weightSum.intValue()));
        Integer m = 0;
        for (WeightCategory wc : this.categorys) {
            if (m.intValue() <= n.intValue() && n.intValue() < m.intValue() + wc.getWeight().intValue()) {
                Log.d(TAG, "This Random Category is " + wc.getCategory());
                return wc.getCategory();
            }
            m = Integer.valueOf(m.intValue() + wc.getWeight().intValue());
        }
        return "";
    }

    public int getRandomForInterval(int a, int b) {
        int dd = b - a;
        if (dd >= 5) {
            Integer n = Integer.valueOf(this.random.nextInt(dd));
            int dd2 = a + n.intValue();
            Log.d(TAG, "This Random Category is " + dd2);
            return dd2;
        }
        return a;
    }

    public int getIntersTypeByWeight(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i).intValue();
        }
        int ranNum = this.random.nextInt(sum);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (ranNum > arrayList.get(i2).intValue()) {
                ranNum -= arrayList.get(i2).intValue();
            } else {
                return i2;
            }
        }
        return 0;
    }

    public String getIntersTypeByWeight(HashMap<String, Integer> hashMap) {
        int sum = 0;
        Iterator<Map.Entry<String, Integer>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            sum += it.next().getValue().intValue();
        }
        int ranNum = this.random.nextInt(sum);
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (ranNum <= entry.getValue().intValue()) {
                return entry.getKey();
            }
            ranNum -= entry.getValue().intValue();
        }
        return "";
    }
}
