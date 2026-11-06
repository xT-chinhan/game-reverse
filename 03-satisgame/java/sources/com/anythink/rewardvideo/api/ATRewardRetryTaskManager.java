package com.anythink.rewardvideo.api;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ATRewardRetryTaskManager {
    private final String TAG;
    private final Map<String, ATRewardRetryTaskContract> mNetworkTaskContracts;
    private volatile ATRewardRetryTaskContract.AdRewardRetryTaskListener mRewardRetryTaskListener;

    private ATRewardRetryTaskManager() {
        this.TAG = "anythink";
        this.mNetworkTaskContracts = new HashMap();
    }

    private static final class a {
        static final ATRewardRetryTaskManager sInstance = new ATRewardRetryTaskManager();

        private a() {
        }
    }

    public static ATRewardRetryTaskManager getInstance() {
        return a.sInstance;
    }

    public void registerContract(String str, ATRewardRetryTaskContract aTRewardRetryTaskContract) {
        if (str == null || aTRewardRetryTaskContract == null) {
            return;
        }
        synchronized (this.mNetworkTaskContracts) {
            this.mNetworkTaskContracts.put(str, aTRewardRetryTaskContract);
        }
    }

    public void notifyATRewardRetryTask(ATRewardRetryTaskInfo aTRewardRetryTaskInfo) {
        ATRewardRetryTaskContract.AdRewardRetryTaskListener adRewardRetryTaskListener;
        if (aTRewardRetryTaskInfo == null || (adRewardRetryTaskListener = this.mRewardRetryTaskListener) == null) {
            return;
        }
        adRewardRetryTaskListener.onAdRewardRetryTaskNotify(aTRewardRetryTaskInfo);
    }

    private ATRewardRetryTaskContract getManager(String str) {
        ATRewardRetryTaskContract aTRewardRetryTaskContract;
        synchronized (this.mNetworkTaskContracts) {
            aTRewardRetryTaskContract = this.mNetworkTaskContracts.get(str);
        }
        return aTRewardRetryTaskContract;
    }

    public void setAdRewardRetryTaskListener(ATRewardRetryTaskContract.AdRewardRetryTaskListener adRewardRetryTaskListener) {
        this.mRewardRetryTaskListener = adRewardRetryTaskListener;
    }

    public void rewardAdRetryTaskUpdate(ATRewardRetryTaskInfo aTRewardRetryTaskInfo, ATRewardRetryTaskContract.RetryRewardConvertResultListener retryRewardConvertResultListener) {
        if (aTRewardRetryTaskInfo == null || TextUtils.isEmpty(aTRewardRetryTaskInfo.getRequestId())) {
            if (retryRewardConvertResultListener != null) {
                retryRewardConvertResultListener.onError(-1, "taskInfo is null or requestId is empty");
                return;
            }
            return;
        }
        String firmId = aTRewardRetryTaskInfo.getFirmId();
        if (TextUtils.isEmpty(firmId)) {
            if (retryRewardConvertResultListener != null) {
                retryRewardConvertResultListener.onError(-1, "taskInfo firmId is empty");
            }
            Log.e("anythink", "taskInfo firmId is empty");
            return;
        }
        ATRewardRetryTaskContract manager = getManager(firmId);
        if (manager == null) {
            if (retryRewardConvertResultListener != null) {
                retryRewardConvertResultListener.onError(-1, "RewardRetryTaskManager not available for network: ".concat(String.valueOf(firmId)));
            }
            Log.e("anythink", "RewardRetryTaskManager not registered for network: ".concat(String.valueOf(firmId)));
            return;
        }
        manager.rewardAdRetryTaskUpdate(aTRewardRetryTaskInfo, retryRewardConvertResultListener);
    }

    public void setRetryRewardResultListener(List<ATRewardRetryTaskInfo> list, ATRewardRetryTaskContract.RetryRewardResultListener retryRewardResultListener) {
        if (list == null || list.isEmpty()) {
            if (retryRewardResultListener != null) {
                retryRewardResultListener.onError(-1, "taskInfoList is null or empty");
                return;
            }
            return;
        }
        try {
            ATRewardRetryTaskInfo[] aTRewardRetryTaskInfoArr = (ATRewardRetryTaskInfo[]) list.toArray(new ATRewardRetryTaskInfo[0]);
            HashMap map = new HashMap();
            for (ATRewardRetryTaskInfo aTRewardRetryTaskInfo : aTRewardRetryTaskInfoArr) {
                if (aTRewardRetryTaskInfo == null || TextUtils.isEmpty(aTRewardRetryTaskInfo.getFirmId())) {
                    if (retryRewardResultListener != null) {
                        retryRewardResultListener.onError(-1, "taskInfo is null or taskInfo firmId is empty");
                    }
                    Log.w("anythink", "Skip invalid taskInfo: taskInfo is null or firmId is empty");
                } else {
                    String firmId = aTRewardRetryTaskInfo.getFirmId();
                    List arrayList = (List) map.get(firmId);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map.put(firmId, arrayList);
                    }
                    arrayList.add(aTRewardRetryTaskInfo);
                }
            }
            if (map.isEmpty()) {
                if (retryRewardResultListener != null) {
                    retryRewardResultListener.onError(-1, "No valid taskInfo in taskInfoList");
                }
                Log.e("anythink", "No valid taskInfo in taskInfoList after filtering");
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                List<ATRewardRetryTaskInfo> list2 = (List) entry.getValue();
                ATRewardRetryTaskContract manager = getManager(str);
                if (manager == null) {
                    Log.e("anythink", "RewardRetryTaskManager not registered for network: " + str + ", skip this network");
                } else {
                    manager.setRetryRewardResultListener(list2, retryRewardResultListener);
                }
            }
        } catch (Throwable th) {
            if (retryRewardResultListener != null) {
                retryRewardResultListener.onError(-1, "setRetryRewardResultListener error: " + th.getMessage());
            }
        }
    }
}
