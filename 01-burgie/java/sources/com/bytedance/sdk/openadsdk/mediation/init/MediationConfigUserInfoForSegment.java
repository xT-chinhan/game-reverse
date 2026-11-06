package com.bytedance.sdk.openadsdk.mediation.init;

import android.text.TextUtils;
import com.byazt.dea.uc;
import com.byazt.vzx.pr;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 82, 83})
public class MediationConfigUserInfoForSegment implements Serializable {
    public static final String GENDER_FEMALE = "female";
    public static final String GENDER_MALE = "male";
    public static final String GENDER_UNKNOWN = "unknown";
    private Map<String, String> fw;
    public final String TAG = MediationConstant.TAG;
    private String pr = "";
    private String hw = "";
    private String hn = "";
    private int x = 0;
    private String c = "";
    private String uc = "";

    public void setCustomInfos(Map<String, String> map) {
        this.fw = new HashMap();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    if (!checkValid(entry.getKey())) {
                        uc.c(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段存在不合法输入");
                    } else if (!checkValid(entry.getValue())) {
                        uc.c(MediationConstant.TAG, "流量分组" + entry.getKey() + "字段的值" + entry.getValue() + "存在不合法输入");
                    } else {
                        this.fw.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }

    public Map<String, String> getCustomInfos() {
        return this.fw;
    }

    public String getUserId() {
        return this.pr;
    }

    public void setUserId(String str) {
        if (checkValid(str)) {
            this.pr = str;
        } else {
            uc.c(MediationConstant.TAG, "流量分组user_id字段存在不合法输入");
        }
    }

    public String getChannel() {
        return this.hw;
    }

    public void setChannel(String str) {
        if (checkValid(str)) {
            this.hw = str;
        } else {
            uc.c(MediationConstant.TAG, "流量分组channer字段存在不合法输入");
        }
    }

    public String getSubChannel() {
        return this.hn;
    }

    public void setSubChannel(String str) {
        if (checkValid(str)) {
            this.hn = str;
        } else {
            uc.c(MediationConstant.TAG, "流量分组sub_channer字段存在不合法输入");
        }
    }

    public int getAge() {
        return this.x;
    }

    public void setAge(int i) {
        this.x = i;
    }

    public String getGender() {
        return this.c;
    }

    public void setGender(String str) {
        if (checkValid(str)) {
            this.c = str;
        } else {
            uc.c(MediationConstant.TAG, "流量分组gender字段存在不合法输入");
        }
    }

    public String getUserValueGroup() {
        return this.uc;
    }

    public void setUserValueGroup(String str) {
        if (checkValid(str)) {
            this.uc = str;
        } else {
            uc.c(MediationConstant.TAG, "流量分组user_value_group字段存在不合法输入");
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b6 A[EDGE_INSN: B:41:0x00b6->B:42:0x00b7 BREAK  A[LOOP:0: B:30:0x0087->B:50:0x0087]] */
    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment = (MediationConfigUserInfoForSegment) obj;
        if (getAge() == mediationConfigUserInfoForSegment.getAge() && TextUtils.equals(getUserValueGroup(), mediationConfigUserInfoForSegment.getUserValueGroup()) && TextUtils.equals(getUserId(), mediationConfigUserInfoForSegment.getUserId()) && TextUtils.equals(getChannel(), mediationConfigUserInfoForSegment.getChannel()) && TextUtils.equals(getSubChannel(), mediationConfigUserInfoForSegment.getSubChannel()) && TextUtils.equals(getGender(), mediationConfigUserInfoForSegment.getGender())) {
            z = true;
        } else {
            z = false;
        }
        Map<String, String> customInfos = mediationConfigUserInfoForSegment.getCustomInfos();
        Map<String, String> map = this.fw;
        if (map != null && customInfos != null) {
            if (map.size() == customInfos.size()) {
                Iterator<String> it = this.fw.keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && !TextUtils.equals(this.fw.get(next), customInfos.get(next))) {
                            z2 = false;
                            break;
                        }
                    } else {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
        } else if (map == null && customInfos == null) {
            z2 = true;
        } else {
            z2 = false;
            break;
        }
        if (z && z2) {
            return true;
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
