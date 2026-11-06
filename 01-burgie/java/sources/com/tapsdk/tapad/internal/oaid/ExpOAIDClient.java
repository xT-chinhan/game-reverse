package com.tapsdk.tapad.internal.oaid;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.Constants;
import com.tapsdk.tapad.internal.util.ExpTwoTuple;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class ExpOAIDClient {
    private static final long DEFAULT_FETCH_TIMEOUT_MS = 9000;
    private static final long DEFAULT_INIT_TIMEOUT_MS = 300;
    private static final String TAG = "ExpOAIDClient";
    private Class<?> idSupplier;
    private Class<?> identifyListener;
    private Class<?> jLibrary;
    private Class<?> midSDKHelper;
    private static final ExecutorService OAID_EXECUTOR = Executors.newFixedThreadPool(2, new ThreadFactory() { // from class: com.tapsdk.tapad.internal.oaid.ExpOAIDClient$$ExternalSyntheticLambda3
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return ExpOAIDClient.lambda$static$0(runnable);
        }
    });
    private static volatile Boolean oaidSdkAvailable = null;
    private static volatile boolean oaidSdkCheckLogged = false;
    private boolean ready = false;
    private boolean initialized = false;
    private Method loadCertMethod = null;
    public OAIDResult initSuccessResult = new OAIDResult.Builder().withResponseCode(0).withMessage(Constants.OAIDErrorMessage.OK_MESSAGE).build();

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.oaid.ExpOAIDClient$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ FetchOAIDListener val$fetchOAIDListener;
        final /* synthetic */ Future val$future;
        final /* synthetic */ long val$waitTimeMillis;

        public AnonymousClass2(Future future, long j, FetchOAIDListener fetchOAIDListener) {
            this.val$future = future;
            this.val$waitTimeMillis = j;
            this.val$fetchOAIDListener = fetchOAIDListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final ExpTwoTuple expTwoTuple = (ExpTwoTuple) this.val$future.get(this.val$waitTimeMillis + 1000, TimeUnit.MILLISECONDS);
                final FetchOAIDListener fetchOAIDListener = this.val$fetchOAIDListener;
                AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.oaid.ExpOAIDClient$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExpOAIDClient.FetchOAIDListener fetchOAIDListener2 = fetchOAIDListener;
                        ExpTwoTuple expTwoTuple2 = expTwoTuple;
                        fetchOAIDListener2.onResult((OAIDResult) expTwoTuple2.paramA, (String) expTwoTuple2.paramB);
                    }
                });
            } catch (TimeoutException e) {
                this.val$future.cancel(true);
                final OAIDResult oAIDResultCreateErrorResult = ExpOAIDClient.this.createErrorResult(2003, Constants.OAIDErrorMessage.OAID_CLIENT_FETCH_TIMEOUT);
                final FetchOAIDListener fetchOAIDListener2 = this.val$fetchOAIDListener;
                AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.oaid.ExpOAIDClient$2$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        fetchOAIDListener2.onResult(oAIDResultCreateErrorResult, "");
                    }
                });
            } catch (Exception e2) {
                e2.getMessage();
                this.val$future.cancel(true);
                final OAIDResult oAIDResultCreateErrorResult2 = ExpOAIDClient.this.createErrorResult(Constants.OAIDErrorCode.OAID_CLIENT_FETCH_INTERRUPTED, Constants.OAIDErrorMessage.OAID_CLIENT_FETCH_INTERRUPTED);
                final FetchOAIDListener fetchOAIDListener3 = this.val$fetchOAIDListener;
                AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.internal.oaid.ExpOAIDClient$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        fetchOAIDListener3.onResult(oAIDResultCreateErrorResult2, "");
                    }
                });
            }
        }
    }

    public interface FetchOAIDListener {
        void onResult(OAIDResult oAIDResult, String str);
    }

    public interface InitListener {
        void onResult(OAIDResult oAIDResult);
    }

    private boolean checkCertificate(Context context) {
        if (this.loadCertMethod == null) {
            return true;
        }
        try {
            String strLoadPemFromAssetFile = loadPemFromAssetFile(context);
            if (TextUtils.isEmpty(strLoadPemFromAssetFile)) {
                return false;
            }
            Object objInvoke = this.loadCertMethod.invoke(null, context, strLoadPemFromAssetFile);
            return objInvoke != null ? ((Boolean) objInvoke).booleanValue() : true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OAIDResult createErrorResult(int i, String str) {
        return new OAIDResult.Builder().withResponseCode(i).withMessage(str).build();
    }

    private Callable<ExpTwoTuple<OAIDResult, String>> createFetchTask(final Context context, final long j) {
        return new Callable() { // from class: com.tapsdk.tapad.internal.oaid.ExpOAIDClient$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m177lambda$createFetchTask$2$comtapsdktapadinternaloaidExpOAIDClient(context, j);
            }
        };
    }

    private Callable<OAIDResult> createInitTask(final Context context) {
        return new Callable() { // from class: com.tapsdk.tapad.internal.oaid.ExpOAIDClient$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m178lambda$createInitTask$1$comtapsdktapadinternaloaidExpOAIDClient(context);
            }
        };
    }

    private InvocationHandler createOAIDCallbackHandler(final CountDownLatch countDownLatch, final StringBuilder sb, final OAIDResult.Builder builder) {
        return new InvocationHandler() { // from class: com.tapsdk.tapad.internal.oaid.ExpOAIDClient$$ExternalSyntheticLambda1
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.f$0.m179lambda$createOAIDCallbackHandler$3$comtapsdktapadinternaloaidExpOAIDClient(sb, builder, countDownLatch, obj, method, objArr);
            }
        };
    }

    private String extractOAIDFromCallback(Method method, Object[] objArr) {
        String name = method.getName();
        if ("OnSupport".equals(name)) {
            return (objArr == null || objArr.length <= 0 || !((Boolean) objArr[0]).booleanValue()) ? "" : (String) this.idSupplier.getDeclaredMethod("getOAID", null).invoke(objArr[1], null);
        }
        return (!"onSupport".equals(name) || objArr == null || objArr.length <= 0) ? "" : (String) this.idSupplier.getDeclaredMethod("getOAID", null).invoke(objArr[0], null);
    }

    private static String getMSAErrorMessage(int i) {
        switch (i) {
            case Constants.MSAOAIDErrorCode.INIT_ERROR_MANUFACTURER_NO_SUPPORT /* 1008611 */:
                return Constants.MSAOAIDErrorMessage.INIT_ERROR_MANUFACTURER_NO_SUPPORT;
            case Constants.MSAOAIDErrorCode.INIT_ERROR_DEVICE_NO_SUPPORT /* 1008612 */:
                return Constants.MSAOAIDErrorMessage.INIT_ERROR_DEVICE_NO_SUPPORT;
            case Constants.MSAOAIDErrorCode.INIT_ERROR_LOAD_CONFIG_FILE /* 1008613 */:
                return Constants.MSAOAIDErrorMessage.INIT_ERROR_LOAD_CONFIG_FILE;
            case Constants.MSAOAIDErrorCode.INIT_ERROR_RESULT_DELAY /* 1008614 */:
            default:
                return "";
            case Constants.MSAOAIDErrorCode.INIT_ERROR_HELPER_CALL_ERROR /* 1008615 */:
                return Constants.MSAOAIDErrorMessage.INIT_ERROR_INIT_SDK_ERROR;
        }
    }

    private void handleFetchTaskExecution(Callable<ExpTwoTuple<OAIDResult, String>> callable, long j, FetchOAIDListener fetchOAIDListener, Context context) {
        ExecutorService executorService = OAID_EXECUTOR;
        executorService.execute(new AnonymousClass2(executorService.submit(callable), j, fetchOAIDListener));
    }

    private void handleInitTaskExecution(Callable<OAIDResult> callable, final InitListener initListener) {
        AsyncExecutor.executeIO(callable, new AsyncExecutor.ResultCallback<OAIDResult>() { // from class: com.tapsdk.tapad.internal.oaid.ExpOAIDClient.1
            @Override // com.tapsdk.tapad.internal.utils.AsyncExecutor.ResultCallback
            public void onError(Exception exc) {
                exc.getMessage();
                initListener.onResult(ExpOAIDClient.this.createErrorResult(1004, Constants.OAIDErrorMessage.OAID_CLIENT_INIT_INTERRUPTED));
            }

            @Override // com.tapsdk.tapad.internal.utils.AsyncExecutor.ResultCallback
            public void onSuccess(OAIDResult oAIDResult) {
                initListener.onResult(oAIDResult);
            }
        });
    }

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "TapAd-OAID");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0076 A[Catch: Exception -> 0x0072, TRY_LEAVE, TryCatch #6 {Exception -> 0x0072, blocks: (B:31:0x006e, B:35:0x0076), top: B:53:0x006e }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0089 A[Catch: Exception -> 0x0085, TRY_LEAVE, TryCatch #4 {Exception -> 0x0085, blocks: (B:41:0x0081, B:45:0x0089), top: B:51:0x0081 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String loadPemFromAssetFile(Context context) throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStreamOpen;
        Exception e;
        try {
            inputStreamOpen = context.getAssets().open(context.getPackageName() + ".cert.pem");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append('\n');
                    }
                    String string = sb.toString();
                    try {
                        bufferedReader.close();
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        return string;
                    } catch (Exception e2) {
                        e2.getMessage();
                        return string;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.getMessage();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                if (inputStreamOpen != null) {
                                    inputStreamOpen.close();
                                }
                            } catch (Exception e4) {
                                e4.getMessage();
                                return "";
                            }
                        } else if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                if (inputStreamOpen != null) {
                                    inputStreamOpen.close();
                                }
                            } catch (Exception e5) {
                                e5.getMessage();
                                throw th;
                            }
                        } else if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                    } else if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                bufferedReader = null;
                e = e6;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
            }
        } catch (Exception e7) {
            bufferedReader = null;
            e = e7;
            inputStreamOpen = null;
        } catch (Throwable th5) {
            bufferedReader = null;
            th = th5;
            inputStreamOpen = null;
        }
    }

    private boolean prepareSDK(Context context) {
        if (oaidSdkAvailable != null) {
            if (!oaidSdkAvailable.booleanValue() && !oaidSdkCheckLogged) {
                oaidSdkCheckLogged = true;
            }
            return oaidSdkAvailable.booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            this.midSDKHelper = cls;
            try {
                this.loadCertMethod = cls.getMethod("InitCert", Context.class, String.class);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.identifyListener = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                this.idSupplier = Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
                return true;
            } catch (Exception e2) {
                try {
                    this.identifyListener = Class.forName("com.bun.supplier.IIdentifierListener");
                    this.idSupplier = Class.forName("com.bun.supplier.IdSupplier");
                    this.jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                    return true;
                } catch (Exception e3) {
                    try {
                        this.identifyListener = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                        this.idSupplier = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                        this.jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                        return true;
                    } catch (Exception e4) {
                        Class<?> cls2 = this.jLibrary;
                        if (cls2 != null) {
                            try {
                                cls2.getDeclaredMethod("InitEntry", Context.class).invoke(null, context);
                            } catch (Throwable th) {
                                oaidSdkAvailable = Boolean.FALSE;
                                return false;
                            }
                        }
                        if (this.midSDKHelper != null && this.identifyListener != null && this.idSupplier != null) {
                            oaidSdkAvailable = Boolean.TRUE;
                            return true;
                        }
                        if (!oaidSdkCheckLogged) {
                            oaidSdkCheckLogged = true;
                        }
                        oaidSdkAvailable = Boolean.FALSE;
                        return false;
                    }
                }
            }
        } catch (Throwable th2) {
            oaidSdkAvailable = Boolean.FALSE;
            if (!oaidSdkCheckLogged) {
                oaidSdkCheckLogged = true;
            }
            return false;
        }
    }

    private void setFetchError(OAIDResult.Builder builder, int i, String str) {
        builder.withResponseCode(i).withMessage(str);
    }

    private OAIDResult validateInitParams(InitListener initListener, Context context) {
        if (initListener == null) {
            throw new RuntimeException("initListener is null");
        }
        if (context == null) {
            return createErrorResult(-1, "context is null");
        }
        return null;
    }

    public void fetchOAID(FetchOAIDListener fetchOAIDListener, Context context) {
        if (fetchOAIDListener == null) {
            throw new RuntimeException("fetchOAIDListener is null");
        }
        if (context == null) {
            fetchOAIDListener.onResult(createErrorResult(-1, "Context is null"), "");
        } else if (this.ready) {
            handleFetchTaskExecution(createFetchTask(context, DEFAULT_FETCH_TIMEOUT_MS), DEFAULT_FETCH_TIMEOUT_MS, fetchOAIDListener, context);
        } else {
            fetchOAIDListener.onResult(createErrorResult(1001, "OAID Client not ready"), "");
        }
    }

    public void init(InitListener initListener, Context context) {
        OAIDResult oAIDResultValidateInitParams = validateInitParams(initListener, context);
        if (oAIDResultValidateInitParams != null) {
            initListener.onResult(oAIDResultValidateInitParams);
        } else if (this.initialized && this.ready) {
            initListener.onResult(this.initSuccessResult);
        } else {
            handleInitTaskExecution(createInitTask(context), initListener);
        }
    }

    public boolean isReady() {
        return this.ready;
    }

    /* JADX INFO: renamed from: lambda$createFetchTask$2$com-tapsdk-tapad-internal-oaid-ExpOAIDClient, reason: not valid java name */
    /* synthetic */ ExpTwoTuple m177lambda$createFetchTask$2$comtapsdktapadinternaloaidExpOAIDClient(Context context, long j) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        StringBuilder sb = new StringBuilder();
        OAIDResult.Builder builder = new OAIDResult.Builder();
        try {
            Object objInvoke = this.midSDKHelper.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, this.identifyListener).invoke(null, context, Boolean.TRUE, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{this.identifyListener}, createOAIDCallbackHandler(countDownLatch, sb, builder)));
            if (objInvoke == null) {
                builder.withResponseCode(2002).withMessage(Constants.OAIDErrorMessage.OAID_CLIENT_FETCH_MSA_INTERFACE_ERROR_2);
                return ExpTwoTuple.create(builder.build(), "");
            }
            int iIntValue = ((Integer) objInvoke).intValue();
            if (1008614 != iIntValue && 1008610 != iIntValue) {
                countDownLatch.countDown();
                builder.withResponseCode(2001).withMessage(getMSAErrorMessage(iIntValue));
                return ExpTwoTuple.create(builder.build(), "");
            }
            boolean zAwait = countDownLatch.await(j, TimeUnit.MILLISECONDS);
            if (!zAwait || sb.length() <= 0) {
                if (!zAwait) {
                    builder.withResponseCode(2003).withMessage(Constants.OAIDErrorMessage.OAID_CLIENT_FETCH_TIMEOUT);
                }
            } else if (builder.build().getResponseCode() == 0) {
                builder.withResponseCode(0).withMessage(Constants.OAIDErrorMessage.OK_MESSAGE);
            }
            return ExpTwoTuple.create(builder.build(), sb.toString());
        } catch (Throwable th) {
            th.toString();
            countDownLatch.countDown();
            builder.withResponseCode(2002).withMessage(Constants.OAIDErrorMessage.OAID_CLIENT_FETCH_MSA_INTERFACE_ERROR_2);
            return ExpTwoTuple.create(builder.build(), "");
        }
    }

    /* JADX INFO: renamed from: lambda$createInitTask$1$com-tapsdk-tapad-internal-oaid-ExpOAIDClient, reason: not valid java name */
    /* synthetic */ OAIDResult m178lambda$createInitTask$1$comtapsdktapadinternaloaidExpOAIDClient(Context context) {
        if (!prepareSDK(context)) {
            this.initialized = true;
            return createErrorResult(1001, Constants.OAIDErrorMessage.OAID_CLIENT_MSA_CONFIGURATION_ERROR);
        }
        if (!checkCertificate(context)) {
            this.initialized = true;
            return createErrorResult(1002, Constants.OAIDErrorMessage.OAID_CLIENT_INIT_CERTIFICATE_CONFIGURATION_FAIL);
        }
        this.ready = true;
        this.initialized = true;
        return this.initSuccessResult;
    }

    /* JADX INFO: renamed from: lambda$createOAIDCallbackHandler$3$com-tapsdk-tapad-internal-oaid-ExpOAIDClient, reason: not valid java name */
    /* synthetic */ Object m179lambda$createOAIDCallbackHandler$3$comtapsdktapadinternaloaidExpOAIDClient(StringBuilder sb, OAIDResult.Builder builder, CountDownLatch countDownLatch, Object obj, Method method, Object[] objArr) {
        method.getName();
        try {
            String strExtractOAIDFromCallback = extractOAIDFromCallback(method, objArr);
            if (OaidValidator.isValid(strExtractOAIDFromCallback)) {
                sb.append(OaidValidator.sanitize(strExtractOAIDFromCallback));
                builder.withResponseCode(0).withMessage(Constants.OAIDErrorMessage.OK_MESSAGE);
            } else if (!TextUtils.isEmpty(strExtractOAIDFromCallback)) {
                builder.withResponseCode(Constants.OAIDErrorCode.OAID_INVALID_RESULT).withMessage(Constants.OAIDErrorMessage.OAID_INVALID_RESULT);
            }
            if (strExtractOAIDFromCallback == null || strExtractOAIDFromCallback.length() <= 0) {
                return null;
            }
            countDownLatch.countDown();
            return null;
        } catch (Throwable th) {
            th.getMessage();
            setFetchError(builder, 2003, Constants.OAIDErrorMessage.OAID_CLIENT_FETCH_TIMEOUT);
            countDownLatch.countDown();
            return null;
        }
    }
}
