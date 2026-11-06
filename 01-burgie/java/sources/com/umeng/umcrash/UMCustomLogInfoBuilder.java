package com.umeng.umcrash;

import android.text.TextUtils;
import android.util.Log;
import com.uc.crashsdk.export.CustomLogInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class UMCustomLogInfoBuilder {
    public static final String LINE_SEP = "\n";
    public static final String LOG_KEY_AC = "k_ac";
    public static final String LOG_KEY_CT = "k_ct";
    private static final String LOG_KEY_STACK_FUNC = "stackFunc";
    private static final String LOG_KEY_STACK_HASH = "stackHash";
    private static final String LOG_SECTION_SEP = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    public static final String LOG_TYPE = "exception";
    private String stack;
    private Map<String, String> kvInfoMap = new HashMap(20);
    private List<String> sectionList = new ArrayList(5);
    private CustomLogInfo mCustomLogInfo = new CustomLogInfo(new StringBuffer(), "exception");

    public UMCustomLogInfoBuilder(String subLogType) {
        this.kvInfoMap.put(LOG_KEY_CT, "exception");
        this.kvInfoMap.put(LOG_KEY_AC, subLogType);
    }

    public UMCustomLogInfoBuilder put(String key, String value) {
        if (LOG_KEY_AC.equals(key) || LOG_KEY_CT.equals(key)) {
            Log.w("crashsdk", "key can not be 'k_ac' and 'k_ct'");
            return this;
        }
        this.kvInfoMap.put(key, value);
        return this;
    }

    public UMCustomLogInfoBuilder stackFunc(String stackFunc) {
        this.kvInfoMap.put(LOG_KEY_STACK_FUNC, stackFunc);
        return this;
    }

    public UMCustomLogInfoBuilder stackHash(String stackHash) {
        this.kvInfoMap.put(LOG_KEY_STACK_HASH, stackHash);
        return this;
    }

    public UMCustomLogInfoBuilder stack(Throwable t) {
        return stack(Log.getStackTraceString(t));
    }

    public UMCustomLogInfoBuilder stack(String stackStr) {
        this.stack = "Exception message:\nBack traces starts.\n" + stackStr + "Back traces ends.";
        return this;
    }

    public UMCustomLogInfoBuilder addSection(String section) {
        this.sectionList.add(section);
        return this;
    }

    public UMCustomLogInfoBuilder uploadNow(boolean uploadNow) {
        this.mCustomLogInfo.mUploadNow = uploadNow;
        return this;
    }

    public UMCustomLogInfoBuilder addLogCat(boolean addLogcat) {
        this.mCustomLogInfo.mAddLogcat = addLogcat;
        return this;
    }

    public CustomLogInfo build() {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : this.kvInfoMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        if (!TextUtils.isEmpty(this.stack)) {
            sb.append(this.stack);
            sb.append("\n");
        }
        for (String sectionText : this.sectionList) {
            sb.append(LOG_SECTION_SEP);
            sb.append("\n");
            sb.append(sectionText);
            sb.append("\n");
        }
        this.mCustomLogInfo.mData = sb;
        return this.mCustomLogInfo;
    }
}
