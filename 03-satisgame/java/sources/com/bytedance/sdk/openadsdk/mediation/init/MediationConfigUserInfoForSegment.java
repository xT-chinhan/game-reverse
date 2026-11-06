package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import com.byazt.cp.n;
import com.byazt.vx.w;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, 59, 60})
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";
    private Map<String, String> x;
    public final String TAG = MediationConstant.TAG;
    private String n = "";
    private String qg = "";
    private String s = "";
    private int q = 0;
    private String l = "";
    private String w = "";

    public void setCustomInfos(Map<String, String> map) {
        this.x = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    w.l(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (!checkValid(entry.getValue())) {
                    w.l(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                } else {
                    this.x.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public Map<String, String> getCustomInfos() {
        return this.x;
    }

    public String getUserId() {
        return this.n;
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.n = str;
        } else {
            w.l(MediationConstant.TAG, "流量分组user_id字段存在不合法输入");
        }
    }

    public String getChannel() {
        return this.qg;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.qg = str;
        } else {
            w.l(MediationConstant.TAG, "流量分组channer字段存在不合法输入");
        }
    }

    public String getSubChannel() {
        return this.s;
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.s = str;
        } else {
            w.l(MediationConstant.TAG, "流量分组sub_channer字段存在不合法输入");
        }
    }

    public int getAge() {
        return this.q;
    }

    public void setAge(int i) {
        this.q = i;
    }

    public String getGender() {
        return this.l;
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.l = str;
        } else {
            w.l(MediationConstant.TAG, "流量分组gender字段存在不合法输入");
        }
    }

    public String getUserValueGroup() {
        return this.w;
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.w = str;
        } else {
            w.l(MediationConstant.TAG, "流量分组user_value_group字段存在不合法输入");
        }
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment = (MediationConfigUserInfoForSegment) obj;
            boolean z2 = getAge() == mediationConfigUserInfoForSegment.getAge() && TextUtils.equals(getUserValueGroup(), mediationConfigUserInfoForSegment.getUserValueGroup()) && TextUtils.equals(getUserId(), mediationConfigUserInfoForSegment.getUserId()) && TextUtils.equals(getChannel(), mediationConfigUserInfoForSegment.getChannel()) && TextUtils.equals(getSubChannel(), mediationConfigUserInfoForSegment.getSubChannel()) && TextUtils.equals(getGender(), mediationConfigUserInfoForSegment.getGender());
            Map<String, String> customInfos = mediationConfigUserInfoForSegment.getCustomInfos();
            Map<String, String> map = this.x;
            if (map == null || customInfos == null) {
                z = map == null && customInfos == null;
            } else {
                if (map.size() == customInfos.size()) {
                    Iterator<String> it = this.x.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (TextUtils.isEmpty(next) || TextUtils.equals(this.x.get(next), customInfos.get(next))) {
                            }
                        }
                    }
                }
            }
            if (z2 && z) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[A-Za-z0-9-_]{1,100}");
    }
}
