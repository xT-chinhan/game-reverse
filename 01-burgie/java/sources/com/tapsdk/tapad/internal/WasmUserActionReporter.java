package com.tapsdk.tapad.internal;

import android.content.Context;
import com.byazt.mg.PluginConstants;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.UserAction;
import com.tapsdk.tapad.exceptions.AdException;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.WasmAdInstance;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.WasmRuntimeController;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class WasmUserActionReporter {
    private static final String EXPORT_SUBMIT = "user_action_submit";

    private WasmUserActionReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fail(final com.tapsdk.tapad.Callback callback, final String str) {
        AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmUserActionReporter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                callback.onError(new AdException(Constants.AdError.ERROR_CODE_UNKNOWN, str));
            }
        });
    }

    private static void failOnce(com.tapsdk.tapad.Callback callback, AtomicBoolean atomicBoolean, String str) {
        if (atomicBoolean.compareAndSet(false, true)) {
            fail(callback, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void finish(com.tapsdk.tapad.Callback callback, WasmAdInstance wasmAdInstance, AtomicBoolean atomicBoolean, String str, String str2) {
        if (atomicBoolean.compareAndSet(false, true)) {
            if (wasmAdInstance != null) {
                wasmAdInstance.dispose();
            }
            if ("onUserActionSuccess".equals(str)) {
                callback.onSuccess();
                return;
            }
            int iOptInt = Constants.AdError.ERROR_CODE_UNKNOWN;
            String strOptString = "user action request failed";
            try {
                if (str2 == null) {
                    str2 = "{}";
                }
                JSONObject jSONObject = new JSONObject(str2);
                iOptInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, iOptInt);
                strOptString = jSONObject.optString("message", "user action request failed");
            } catch (Throwable th) {
            }
            callback.onError(new AdException(iOptInt, strOptString));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void invoke(Context context, DirichletRuntime dirichletRuntime, UserAction[] userActionArr, final com.tapsdk.tapad.Callback callback, WasmModule wasmModule) {
        if (wasmModule == null || !wasmModule.hasFunction(EXPORT_SUBMIT)) {
            fail(callback, "user action reporter unavailable");
            return;
        }
        if (!AdnRuntimeBootstrap.getInstance().ensurePublisherInstalled(context, dirichletRuntime, wasmModule)) {
            fail(callback, "ADN publisher is not initialized");
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        final AtomicReference atomicReference = new AtomicReference();
        WasmAdInstance wasmAdInstance = WasmAdInstance.create(wasmModule, new DirichletRuntime.NativeCallback() { // from class: com.tapsdk.tapad.internal.WasmUserActionReporter$$ExternalSyntheticLambda2
            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.NativeCallback
            public final void onCallback(String str, String str2) {
                WasmUserActionReporter.finish(callback, (WasmAdInstance) atomicReference.get(), atomicBoolean, str, str2);
            }
        }).get();
        if (wasmAdInstance == null) {
            fail(callback, "user action reporter unavailable");
            return;
        }
        atomicReference.set(wasmAdInstance);
        try {
            wasmModule.callVoid(EXPORT_SUBMIT, Integer.valueOf(wasmAdInstance.instanceId()), requestJson(userActionArr).toString());
        } catch (Throwable th) {
            wasmAdInstance.dispose();
            failOnce(callback, atomicBoolean, "user action submission failed");
        }
    }

    private static JSONObject requestJson(UserAction[] userActionArr) {
        JSONArray jSONArray = new JSONArray();
        for (UserAction userAction : userActionArr) {
            if (userAction != null) {
                jSONArray.put(new JSONObject().put("action_type", userAction.actionType).put("action_time", userAction.actionTime).put(IAction.BuyKey.CostAmount, userAction.amount).put(com.tapsdk.tapad.group.constants.Constants.IS_WIN_FIELD, userAction.winStatus));
            }
        }
        if (jSONArray.length() != 0) {
            return new JSONObject().put("actions", jSONArray);
        }
        throw new IllegalArgumentException("user actions are empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void start(final Context context, final UserAction[] userActionArr, final com.tapsdk.tapad.Callback callback) {
        try {
            if (!WasmRuntimeController.getInstance().ensureAdCoreInitialized(context)) {
                fail(callback, "shared Core unavailable");
            } else {
                final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
                WasmCoreModuleLoader.load(dirichletRuntime, new WasmCoreModuleLoader.Callback() { // from class: com.tapsdk.tapad.internal.WasmUserActionReporter.1
                    @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
                    public void onError(Exception exc) {
                        WasmUserActionReporter.fail(callback, "shared Core module unavailable");
                    }

                    @Override // com.tapsdk.tapad.internal.WasmCoreModuleLoader.Callback
                    public void onLoaded(WasmModule wasmModule) {
                        WasmUserActionReporter.invoke(context, dirichletRuntime, userActionArr, callback, wasmModule);
                    }
                });
            }
        } catch (Throwable th) {
            fail(callback, "shared Core initialization failed");
        }
    }

    public static void submit(final UserAction[] userActionArr, final com.tapsdk.tapad.Callback callback) {
        if (callback == null) {
            return;
        }
        final Context context = AppContextHolder.get();
        if (context == null || userActionArr == null || userActionArr.length == 0) {
            fail(callback, "invalid user action request");
        } else {
            if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.internal.WasmUserActionReporter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    WasmUserActionReporter.start(context, userActionArr, callback);
                }
            })) {
                return;
            }
            fail(callback, "user action executor is saturated");
        }
    }
}
