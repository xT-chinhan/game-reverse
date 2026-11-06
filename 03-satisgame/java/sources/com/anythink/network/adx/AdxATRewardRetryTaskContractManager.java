package com.anythink.network.adx;

import android.text.TextUtils;
import com.anythink.rewardvideo.api.ATRewardRetryTaskContract;
import com.anythink.rewardvideo.api.ATRewardRetryTaskInfo;
import com.anythink.rewardvideo.api.ATRewardRetryTaskManager;
import com.anythink.rewardvideo.api.ATRewardRetryTaskResult;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AdxATRewardRetryTaskContractManager {
    private static final String a = "AdxATRewardRetryTaskContractManager";
    private static final Object b = new Object();
    private static volatile String c;
    private static volatile List<ATRewardRetryTaskInfo> d;
    private static volatile ATRewardRetryTaskContract.RetryRewardResultListener e;

    private static final class b implements ATRewardRetryTaskContract {
        private b() {
        }

        @Override // com.anythink.rewardvideo.api.ATRewardRetryTaskContract
        public void rewardAdRetryTaskUpdate(ATRewardRetryTaskInfo aTRewardRetryTaskInfo, ATRewardRetryTaskContract.RetryRewardConvertResultListener retryRewardConvertResultListener) {
        }

        @Override // com.anythink.rewardvideo.api.ATRewardRetryTaskContract
        public void setRetryRewardResultListener(List<ATRewardRetryTaskInfo> list, ATRewardRetryTaskContract.RetryRewardResultListener retryRewardResultListener) {
            if (list == null || list.isEmpty()) {
                if (retryRewardResultListener != null) {
                    retryRewardResultListener.onError(-1, "taskInfoList is null or empty");
                    return;
                }
                return;
            }
            if (retryRewardResultListener == null) {
                return;
            }
            List listE = AdxATRewardRetryTaskContractManager.e(list);
            if (listE.isEmpty()) {
                retryRewardResultListener.onError(-1, "no adx task in taskInfoList");
                return;
            }
            String strD = AdxATRewardRetryTaskContractManager.d(listE);
            if (TextUtils.isEmpty(strD)) {
                retryRewardResultListener.onError(-1, "taskInfo requestId is empty, cannot match ad session");
                return;
            }
            synchronized (AdxATRewardRetryTaskContractManager.b) {
                String unused = AdxATRewardRetryTaskContractManager.c = strD;
                List unused2 = AdxATRewardRetryTaskContractManager.d = new ArrayList(list);
                ATRewardRetryTaskContract.RetryRewardResultListener unused3 = AdxATRewardRetryTaskContractManager.e = retryRewardResultListener;
            }
        }
    }

    private AdxATRewardRetryTaskContractManager() {
    }

    public static void clearPendingRetryRewardQueryIfSession(String str) {
        synchronized (b) {
            if (b(str)) {
                b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(List<ATRewardRetryTaskInfo> list) {
        if (list == null) {
            return null;
        }
        for (ATRewardRetryTaskInfo aTRewardRetryTaskInfo : list) {
            if (aTRewardRetryTaskInfo != null && String.valueOf(66).equals(aTRewardRetryTaskInfo.getFirmId()) && !TextUtils.isEmpty(aTRewardRetryTaskInfo.getRequestId())) {
                return aTRewardRetryTaskInfo.getRequestId();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<ATRewardRetryTaskInfo> e(List<ATRewardRetryTaskInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        String strValueOf = String.valueOf(66);
        for (ATRewardRetryTaskInfo aTRewardRetryTaskInfo : list) {
            if (aTRewardRetryTaskInfo != null && strValueOf.equals(aTRewardRetryTaskInfo.getFirmId())) {
                arrayList.add(aTRewardRetryTaskInfo);
            }
        }
        return arrayList;
    }

    public static void install() {
        try {
            ATRewardRetryTaskManager.getInstance().registerContract(String.valueOf(66), new b());
        } catch (Throwable unused) {
        }
    }

    public static void notifyAdClosedIncompleteRetryReward(String str, boolean z) {
        if (z) {
            synchronized (b) {
                if (e == null || !b(str)) {
                    return;
                }
                try {
                    e.onError(-1, "ad closed");
                } catch (Throwable unused) {
                }
                b();
            }
        }
    }

    public static void notifyRetryRewardResult(String str, boolean z) {
        if (z) {
            synchronized (b) {
                if (e == null || d == null || !b(str)) {
                    return;
                }
                try {
                    ArrayList arrayList = new ArrayList(d.size());
                    for (ATRewardRetryTaskInfo aTRewardRetryTaskInfo : d) {
                        if (aTRewardRetryTaskInfo != null) {
                            arrayList.add(new ATRewardRetryTaskResult(aTRewardRetryTaskInfo, 0));
                        }
                    }
                    if (arrayList.isEmpty()) {
                        e.onError(-1, "no valid taskInfo in pending list");
                    } else {
                        e.onSuccess(arrayList);
                    }
                } catch (Throwable unused) {
                }
                b();
            }
        }
    }

    public static void notifyRetryRewardResultFailed(String str, boolean z, int i, String str2) {
        if (z) {
            synchronized (b) {
                if (e == null || !b(str)) {
                    return;
                }
                try {
                    ATRewardRetryTaskContract.RetryRewardResultListener retryRewardResultListener = e;
                    if (str2 == null) {
                        str2 = "";
                    }
                    retryRewardResultListener.onError(i, str2);
                } catch (Throwable unused) {
                }
                b();
            }
        }
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(c)) {
            return false;
        }
        return TextUtils.equals(str, c);
    }

    private static void b() {
        c = null;
        d = null;
        e = null;
    }
}
