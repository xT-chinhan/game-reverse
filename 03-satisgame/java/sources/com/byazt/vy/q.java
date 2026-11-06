package com.byazt.vy;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 5})
public class q {
    public static boolean n = false;
    public static boolean qg = false;

    public static void qg(List<String> list, String str) {
    }

    public static List<String> n() {
        ArrayList arrayList = null;
        if (!com.byazt.vyf.s.cy().sh()) {
            return null;
        }
        Field[] declaredFields = com.byazt.ws.qg.class.getDeclaredFields();
        if (declaredFields != null && declaredFields.length != 0) {
            arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (declaredFields != null && !TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                    arrayList.add(field.getName());
                }
            }
            arrayList.remove("mTotalWaterFallCount");
            arrayList.remove("mWaterFallConfigList");
            arrayList.remove("mWaterFallConfMap");
            arrayList.remove("mTotalLoadLevelCount");
            arrayList.remove("mCurrentCommonAdMaxCpm");
            arrayList.remove("mLoadSortLevelList");
            arrayList.remove("hasServerBidding");
            arrayList.remove("hasClientOrMultiLevel");
            arrayList.remove("mRitInfoJson");
        }
        return arrayList;
    }

    public static List<String> qg() {
        ArrayList arrayList = null;
        if (!com.byazt.vyf.s.cy().sh()) {
            return null;
        }
        Field[] declaredFields = com.byazt.ws.tj.class.getDeclaredFields();
        if (declaredFields != null && declaredFields.length != 0) {
            arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (declaredFields != null && !TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                    arrayList.add(field.getName());
                }
            }
            arrayList.remove("mServerBiddingWinner");
        }
        return arrayList;
    }

    public static void n(List<String> list, String str) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        list.remove(str);
    }
}
