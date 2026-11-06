package com.umeng.commonsdk.framework;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UMWorkDispatch {
    public static final String GENERAL_CONTENT = "content";
    public static final String GENERAL_HEADER = "header";
    public static final String KEY_EXCEPTION = "exception";
    private static final int MSG_AUTO_PROCESS = 769;
    private static final int MSG_CHECKER_TIMER = 771;
    private static final int MSG_DELAY_PROCESS = 770;
    private static final int MSG_QUIT = 784;
    private static final int MSG_SEND_EVENT = 768;
    private static HandlerThread mNetTask = null;
    private static Handler mTaskHandler = null;
    private static a mSender = null;
    private static Object mSenderInitLock = new Object();

    public static void registerConnStateObserver(UMSenderStateNotify uMSenderStateNotify) {
        if (mSender != null) {
            a.a(uMSenderStateNotify);
        }
    }

    public static void sendEventInternal(Context context, int i, int i2, UMLogDataProtocol uMLogDataProtocol, Object obj, long j) throws Throwable {
        if (context == null || uMLogDataProtocol == null) {
            ULog.d("--->>> Context or UMLogDataProtocol parameter cannot be null!");
            return;
        }
        UMModuleRegister.registerAppContext(context.getApplicationContext());
        if (!UMModuleRegister.registerCallback(i2, uMLogDataProtocol)) {
            return;
        }
        if (mNetTask == null || mTaskHandler == null) {
            init();
        }
        try {
            if (mTaskHandler != null) {
                if (UMUtils.isMainProgress(context)) {
                    synchronized (mSenderInitLock) {
                        if (mSender == null) {
                            UMFrUtils.syncLegacyEnvelopeIfNeeded(context);
                            mSender = new a(context, mTaskHandler);
                        }
                    }
                }
                Message messageObtainMessage = mTaskHandler.obtainMessage();
                messageObtainMessage.what = i;
                messageObtainMessage.arg1 = i2;
                messageObtainMessage.obj = obj;
                mTaskHandler.sendMessageDelayed(messageObtainMessage, j);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
        }
    }

    public static void sendEvent(Context context, int i, UMLogDataProtocol uMLogDataProtocol, Object obj) {
        sendEventInternal(context, 768, i, uMLogDataProtocol, obj, 0L);
    }

    public static void sendEvent(Context context, int i, UMLogDataProtocol uMLogDataProtocol, Object obj, long j) throws Throwable {
        sendEventInternal(context, 768, i, uMLogDataProtocol, obj, j);
    }

    public static void sendEventEx(Context context, int i, UMLogDataProtocol uMLogDataProtocol, Object obj, long j) {
        sendEventInternal(context, MSG_CHECKER_TIMER, i, uMLogDataProtocol, obj, j);
    }

    private UMWorkDispatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void delayProcess() throws Throwable {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        ULog.d("--->>> delayProcess Enter...");
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> delayProcess Enter...");
        Context appContext = UMModuleRegister.getAppContext();
        if (appContext == null || !UMFrUtils.isOnline(appContext)) {
            return;
        }
        long jMaxDataSpace = UMEnvelopeBuild.maxDataSpace(appContext);
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName("analytics");
        JSONObject jSONObject = null;
        if (callbackFromModuleName != null) {
            try {
                jSONObject = callbackFromModuleName.setupReportData(jMaxDataSpace);
                if (jSONObject == null) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> analyticsCB.setupReportData() return null");
                    return;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
                return;
            }
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = (JSONObject) jSONObject.opt("header");
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt("content");
            if (appContext != null && jSONObject2 != null && jSONObject3 != null && (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(appContext, jSONObject2, jSONObject3)) != null) {
                try {
                    if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
                    }
                } catch (Throwable th2) {
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> autoProcess: removeCacheData ... ");
                callbackFromModuleName.removeCacheData(jSONObjectBuildEnvelopeWithExtHeader);
            }
        }
    }

    public static void sendDelayProcessMsg(long j) {
        if (mTaskHandler != null) {
            if (mTaskHandler.hasMessages(MSG_DELAY_PROCESS)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS has exist. do nothing.");
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS not exist. send it.");
            Message messageObtainMessage = mTaskHandler.obtainMessage();
            messageObtainMessage.what = MSG_DELAY_PROCESS;
            mTaskHandler.sendMessageDelayed(messageObtainMessage, j);
        }
    }

    private static synchronized void init() {
        ULog.d("--->>> Dispatch: init Enter...");
        try {
            if (mNetTask == null) {
                mNetTask = new HandlerThread("work_thread");
                mNetTask.start();
                if (mTaskHandler == null) {
                    mTaskHandler = new Handler(mNetTask.getLooper()) { // from class: com.umeng.commonsdk.framework.UMWorkDispatch.1
                        @Override // android.os.Handler
                        public void handleMessage(Message message) throws Throwable {
                            int i = message.what;
                            if (i != UMWorkDispatch.MSG_QUIT) {
                                switch (i) {
                                    case 768:
                                        UMWorkDispatch.handleEvent(message);
                                        break;
                                    case UMWorkDispatch.MSG_DELAY_PROCESS /* 770 */:
                                        UMWorkDispatch.delayProcess();
                                        break;
                                    case UMWorkDispatch.MSG_CHECKER_TIMER /* 771 */:
                                        UMWorkDispatch.handleEvent(message);
                                        break;
                                }
                            }
                            UMWorkDispatch.handleQuit();
                        }
                    };
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
        }
        ULog.d("--->>> Dispatch: init Exit...");
    }

    public static synchronized boolean eventHasExist(int i) {
        if (mTaskHandler == null) {
            return false;
        }
        return mTaskHandler.hasMessages(i);
    }

    public static synchronized boolean eventHasExist() {
        if (mTaskHandler == null) {
            return false;
        }
        return mTaskHandler.hasMessages(MSG_CHECKER_TIMER);
    }

    public static synchronized void removeEvent() {
        if (mTaskHandler == null) {
            return;
        }
        mTaskHandler.removeMessages(MSG_CHECKER_TIMER);
    }

    public static synchronized void removeEvent(int i) {
        if (mTaskHandler == null) {
            return;
        }
        mTaskHandler.removeMessages(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleEvent(Message message) throws Throwable {
        int i = message.arg1;
        Object obj = message.obj;
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName(UMModuleRegister.eventType2ModuleName(i));
        if (callbackFromModuleName != null) {
            ULog.d("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x" + Integer.toHexString(i) + "]");
            callbackFromModuleName.workEvent(obj, i);
        }
    }

    private static void teardown() {
        if (mNetTask != null) {
            mNetTask = null;
        }
        if (mTaskHandler != null) {
            mTaskHandler = null;
        }
        if (mSender != null) {
            mSender = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleQuit() throws Throwable {
        if (mSender != null && mNetTask != null) {
            a.c();
            ULog.d("--->>> handleQuit: Quit dispatch thread.");
            mNetTask.quit();
            teardown();
        }
    }

    public static void Quit() {
        if (mTaskHandler != null) {
            Message messageObtainMessage = mTaskHandler.obtainMessage();
            messageObtainMessage.what = MSG_QUIT;
            mTaskHandler.sendMessage(messageObtainMessage);
        }
    }
}
