package com.anythink.core.api;

import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ATCustomRange {
    private static ATCustomRange sInstance;
    private final Map<String, Pair<CustomContentListener, List<RangeObject>>> listenerMap = new HashMap();

    public interface CustomContentListener {
        void callBackResult(List<RangeObject> list);
    }

    public static ATCustomRange getInstance() {
        ATCustomRange aTCustomRange;
        synchronized (ATCustomRange.class) {
            if (sInstance == null) {
                sInstance = new ATCustomRange();
            }
            aTCustomRange = sInstance;
        }
        return aTCustomRange;
    }

    public void addAdCustomContentListener(String str, CustomContentListener customContentListener, List<RangeObject> list) {
        if (TextUtils.isEmpty(str) || customContentListener == null || list == null) {
            return;
        }
        this.listenerMap.put(str, new Pair<>(customContentListener, list));
    }

    public void removeAdCustomContentListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.listenerMap.remove(str);
    }

    public Pair<CustomContentListener, List<RangeObject>> getAdCustomContentInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.listenerMap.get(str);
    }

    public static class RangeObject {
        private String adSourceId;
        private double customMsg;
        private Object tag;

        public String getAdSourceId() {
            return this.adSourceId;
        }

        public void setAdSourceId(String str) {
            this.adSourceId = str;
        }

        public RangeObject(double d) {
            this.customMsg = d;
        }

        public void setCustomMsg(double d) {
            this.customMsg = d;
        }

        public double getCustomMsg() {
            return this.customMsg;
        }

        public String toString() {
            return "{customMsg=" + this.customMsg + ", adSourceId='" + this.adSourceId + "'}";
        }

        public Object getTag() {
            return this.tag;
        }

        public void setTag(Object obj) {
            this.tag = obj;
        }
    }
}
