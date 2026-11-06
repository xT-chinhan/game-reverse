package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";
    private Map<String, String> ab;
    public final String TAG = MediationConstant.TAG;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3990ms = "";
    private String xr = "";
    private String ah = "";
    private int d = 0;
    private String ka = "";
    private String c = "";

    public void setCustomInfos(Map<String, String> map) {
        this.ab = new HashMap();
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                if (!checkValid(entry.getKey())) {
                    ab.ka(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段存在不合法输入");
                } else if (!checkValid(entry.getValue())) {
                    ab.ka(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                } else {
                    this.ab.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public Map<String, String> getCustomInfos() {
        return this.ab;
    }

    public String getUserId() {
        return this.f3990ms;
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.f3990ms = str;
        } else {
            ab.ka(MediationConstant.TAG, "流量分组user_id字段存在不合法输入");
        }
    }

    public String getChannel() {
        return this.xr;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.xr = str;
        } else {
            ab.ka(MediationConstant.TAG, "流量分组channer字段存在不合法输入");
        }
    }

    public String getSubChannel() {
        return this.ah;
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.ah = str;
        } else {
            ab.ka(MediationConstant.TAG, "流量分组sub_channer字段存在不合法输入");
        }
    }

    public int getAge() {
        return this.d;
    }

    public void setAge(int i) {
        this.d = i;
    }

    public String getGender() {
        return this.ka;
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.ka = str;
        } else {
            ab.ka(MediationConstant.TAG, "流量分组gender字段存在不合法输入");
        }
    }

    public String getUserValueGroup() {
        return this.c;
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.c = str;
        } else {
            ab.ka(MediationConstant.TAG, "流量分组user_value_group字段存在不合法输入");
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
            Map<String, String> map = this.ab;
            if (map == null || customInfos == null) {
                z = map == null && customInfos == null;
            } else {
                if (map.size() == customInfos.size()) {
                    Iterator<String> it = this.ab.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (TextUtils.isEmpty(next) || TextUtils.equals(this.ab.get(next), customInfos.get(next))) {
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
