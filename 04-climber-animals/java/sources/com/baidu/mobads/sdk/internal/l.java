package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public enum l {
    NEWS("news", 0),
    IMAGE("image", 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD(com.umeng.analytics.pro.bv.aw, 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);

    String j;
    int k;

    l(String str, int i) {
        this.j = str;
        this.k = i;
    }

    public String b() {
        return this.j;
    }

    public int c() {
        return this.k;
    }

    public static l b(String str) {
        for (l lVar : values()) {
            if (lVar != null && TextUtils.isEmpty(lVar.j) && lVar.j.equals(str)) {
                return lVar;
            }
        }
        return null;
    }
}
