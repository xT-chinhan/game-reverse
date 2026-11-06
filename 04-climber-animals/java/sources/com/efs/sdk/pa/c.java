package com.efs.sdk.pa;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.custommapping.InnerCustomMappingManager;
import com.efs.sdk.base.protocol.file.EfsTextFile;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.efs.sdk.base.protocol.file.section.TextSection;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.umeng.umcrash.UMCrash;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    /* JADX WARN: Code duplicated, block: B:38:0x00ea A[Catch: all -> 0x0105, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0026, B:8:0x002c, B:9:0x0034, B:11:0x003a, B:12:0x004e, B:14:0x0063, B:15:0x0068, B:35:0x00d6, B:36:0x00e4, B:38:0x00ea, B:39:0x00ed, B:34:0x00d3, B:17:0x006e, B:19:0x007e, B:21:0x0084, B:22:0x0091, B:24:0x00a1, B:26:0x00a7, B:27:0x00b4, B:29:0x00be, B:31:0x00c4), top: B:47:0x0003, inners: #0 }] */
    public static synchronized void a(PAFactory pAFactory, String str, String str2) {
        EfsReporter reporter;
        EfsTextFile efsTextFile = new EfsTextFile(str);
        KVSection kVSectionCreateAndAddKVSection = efsTextFile.createAndAddKVSection(GlobalSetting.CUSTOM_INFO_KEY);
        kVSectionCreateAndAddKVSection.put("bserial", pAFactory.getSerial());
        kVSectionCreateAndAddKVSection.put("bsver", pAFactory.getSver());
        HashMap<String, String> extend = pAFactory.getExtend();
        if (extend != null && !extend.isEmpty()) {
            for (Map.Entry<String, String> entry : extend.entrySet()) {
                kVSectionCreateAndAddKVSection.put(entry.getKey(), entry.getValue());
            }
        }
        kVSectionCreateAndAddKVSection.put("crver", "2.1.160.umeng");
        String strA = a(pAFactory.getContext());
        if (!TextUtils.isEmpty(strA)) {
            kVSectionCreateAndAddKVSection.put(UMCrash.KEY_CALLBACK_SESSION_ID, strA);
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                String strOnGetCallbackInfo = pAFactory.getPaClient().onGetCallbackInfo(UMCrash.KEY_CALLBACK_USER_STRING);
                if (pAFactory.getPaClient() != null && !TextUtils.isEmpty(strOnGetCallbackInfo)) {
                    kVSectionCreateAndAddKVSection.put(UMCrash.KEY_CALLBACK_USER_STRING, EncodeUtil.base64EncodeToStr(strOnGetCallbackInfo.getBytes()));
                }
                String strOnGetCallbackInfo2 = pAFactory.getPaClient().onGetCallbackInfo(UMCrash.KEY_CALLBACK_PAGE_ACTION);
                if (pAFactory.getPaClient() != null && !TextUtils.isEmpty(strOnGetCallbackInfo2)) {
                    kVSectionCreateAndAddKVSection.put(UMCrash.KEY_CALLBACK_PAGE_ACTION, EncodeUtil.base64EncodeToStr(strOnGetCallbackInfo2.getBytes()));
                }
                String customMappingJsonStr = InnerCustomMappingManager.getCustomMappingJsonStr();
                if (pAFactory.getPaClient() != null && !TextUtils.isEmpty(customMappingJsonStr)) {
                    kVSectionCreateAndAddKVSection.put(UMCrash.KEY_CALLBACK_CUSTOM_MAPPING, EncodeUtil.base64EncodeToStr(customMappingJsonStr.getBytes()));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            TextSection textSectionCreateAndAddTextSection = efsTextFile.createAndAddTextSection("stack");
            textSectionCreateAndAddTextSection.setBody(str2);
            textSectionCreateAndAddTextSection.setSep(AbsSection.SEP_LINE_BREAK);
            reporter = pAFactory.getReporter();
            if (reporter != null) {
                reporter.send(efsTextFile);
            }
            pAFactory.getConfigManager().increaseUploadSmoothLogCnt();
            Log.d("fred_xx", "reportPaWpkStats: stack: ".concat(String.valueOf(str2)));
        } else {
            reporter = pAFactory.getReporter();
            if (reporter != null) {
                reporter.send(efsTextFile);
            }
            pAFactory.getConfigManager().increaseUploadSmoothLogCnt();
            Log.d("fred_xx", "reportPaWpkStats: stack: ".concat(String.valueOf(str2)));
        }
        throw th;
    }

    private static String a(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getSid", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }
}
