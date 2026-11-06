package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.OAIDService;
import com.tapsdk.tapad.oaid.aidl.MsaIdInterface;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class MsaImpl implements IOAID {
    private static final long DEFAULT_AIDL_FALLBACK_DELAY_MS = 1500;
    private static final long DEFAULT_TOTAL_TIMEOUT_MS = 9000;
    private static final String TAG = "MsaImpl";
    private final Context context;
    private Class<?> idSupplier;
    private Class<?> identifyListener;
    private Class<?> jLibrary;
    private Method loadCertMethod;
    private Class<?> midSDKHelper;
    private static final ExecutorService MSA_EXECUTOR = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tapsdk.tapad.oaid.impl.MsaImpl$$ExternalSyntheticLambda3
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return MsaImpl.lambda$static$0(runnable);
        }
    });
    private static final ScheduledExecutorService MSA_WATCHDOG = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.tapsdk.tapad.oaid.impl.MsaImpl$$ExternalSyntheticLambda4
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return MsaImpl.lambda$static$1(runnable);
        }
    });
    private static final List<String> INVALID_OAID_LIST = Arrays.asList("00000000-0000-0000-0000-000000000000", "FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF", "");

    public static final class CallbackOnceGetter implements IGetter {
        private final IGetter delegate;
        private final AtomicBoolean delivered;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isDelivered() {
            return this.delivered.get();
        }

        @Override // com.tapsdk.tapad.oaid.IGetter
        public void onOAIDGetComplete(String str) {
            if (this.delivered.compareAndSet(false, true)) {
                this.delegate.onOAIDGetComplete(str);
            }
        }

        @Override // com.tapsdk.tapad.oaid.IGetter
        public void onOAIDGetError(Exception exc) {
            if (this.delivered.compareAndSet(false, true)) {
                this.delegate.onOAIDGetError(exc);
            }
        }

        private CallbackOnceGetter(IGetter iGetter) {
            this.delivered = new AtomicBoolean(false);
            this.delegate = iGetter;
        }
    }

    public static final class SuccessOnlyGetter implements IGetter {
        private final CallbackOnceGetter delegate;

        @Override // com.tapsdk.tapad.oaid.IGetter
        public void onOAIDGetComplete(String str) {
            this.delegate.onOAIDGetComplete(str);
        }

        @Override // com.tapsdk.tapad.oaid.IGetter
        public void onOAIDGetError(Exception exc) {
            if (exc == null) {
                return;
            }
            exc.getMessage();
        }

        private SuccessOnlyGetter(CallbackOnceGetter callbackOnceGetter) {
            this.delegate = callbackOnceGetter;
        }
    }

    public MsaImpl(Context context) {
        this.context = context;
    }

    private boolean checkCertificate() {
        if (this.loadCertMethod == null) {
            return true;
        }
        try {
            String strLoadPemFromAssetFile = loadPemFromAssetFile();
            if (TextUtils.isEmpty(strLoadPemFromAssetFile)) {
                return false;
            }
            Object objInvoke = this.loadCertMethod.invoke(null, this.context, strLoadPemFromAssetFile);
            return objInvoke != null && ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            return false;
        }
    }

    private void doGetByAIDL(IGetter iGetter) {
        startMsaKlService(iGetter);
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.context.getPackageName());
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.tapsdk.tapad.oaid.impl.MsaImpl$$ExternalSyntheticLambda6
            @Override // com.tapsdk.tapad.oaid.OAIDService.RemoteCaller
            public final String callRemoteInterface(IBinder iBinder) {
                return MsaImpl.lambda$doGetByAIDL$6(iBinder);
            }
        });
    }

    private String extractOAIDFromCallback(Method method, Object[] objArr) {
        String name = method.getName();
        if ("OnSupport".equals(name)) {
            if (objArr != null && objArr.length > 0 && ((Boolean) objArr[0]).booleanValue()) {
                return (String) this.idSupplier.getDeclaredMethod("getOAID", null).invoke(objArr[1], null);
            }
        } else if ("onSupport".equals(name) && objArr != null && objArr.length > 0) {
            return (String) this.idSupplier.getDeclaredMethod("getOAID", null).invoke(objArr[0], null);
        }
        return null;
    }

    private void getMSAOAIDByReflection(final IGetter iGetter) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int iIntValue;
        if (!prepareMSASDK()) {
            throw new OAIDException("MSA SDK prepare failed");
        }
        if (!checkCertificate()) {
            throw new OAIDException("MSA certificate check failed");
        }
        InvocationHandler invocationHandler = new InvocationHandler() { // from class: com.tapsdk.tapad.oaid.impl.MsaImpl$$ExternalSyntheticLambda5
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return this.f$0.m399lambda$getMSAOAIDByReflection$5$comtapsdktapadoaidimplMsaImpl(iGetter, obj, method, objArr);
            }
        };
        Method declaredMethod = this.midSDKHelper.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, this.identifyListener);
        Context context = this.context;
        Object objInvoke = declaredMethod.invoke(null, context, Boolean.TRUE, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{this.identifyListener}, invocationHandler));
        if (objInvoke != null && (iIntValue = ((Integer) objInvoke).intValue()) != 1008614 && iIntValue != 1008612) {
            throw new OAIDException("MSA InitSdk failed with error code: " + iIntValue);
        }
    }

    private boolean initJLibrary() {
        Class<?> cls = this.jLibrary;
        if (cls == null) {
            return true;
        }
        try {
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(null, this.context);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isValidOAID(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = INVALID_OAID_LIST.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ void lambda$doGet$4(CallbackOnceGetter callbackOnceGetter) {
        if (callbackOnceGetter.isDelivered()) {
            return;
        }
        callbackOnceGetter.onOAIDGetError(new OAIDException("MSA OAID fetch timeout"));
    }

    static /* synthetic */ String lambda$doGetByAIDL$6(IBinder iBinder) {
        MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
        if (msaIdInterfaceAsInterface == null) {
            throw new OAIDException("MsaIdInterface is null");
        }
        if (msaIdInterfaceAsInterface.isSupported()) {
            return msaIdInterfaceAsInterface.getOAID();
        }
        throw new OAIDException("MsaIdInterface#isSupported return false");
    }

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "TapAd-MSA");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    }

    static /* synthetic */ Thread lambda$static$1(Runnable runnable) {
        Thread thread = new Thread(runnable, "TapAd-MSA-Watchdog");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    }

    private String loadPemFromAssetFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.context.getAssets().open(this.context.getPackageName() + ".cert.pem")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line).append('\n');
            }
        } catch (Exception e) {
            e.getMessage();
            return "";
        }
    }

    private boolean prepareMSASDK() {
        try {
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            this.midSDKHelper = cls;
            try {
                this.loadCertMethod = cls.getMethod("InitCert", Context.class, String.class);
            } catch (NoSuchMethodException e) {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                this.identifyListener = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                this.idSupplier = Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
                return true;
            } catch (ClassNotFoundException e2) {
                try {
                    this.identifyListener = Class.forName("com.bun.supplier.IIdentifierListener");
                    this.idSupplier = Class.forName("com.bun.supplier.IdSupplier");
                    this.jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                    return initJLibrary();
                } catch (ClassNotFoundException e3) {
                    try {
                        this.identifyListener = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                        this.idSupplier = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                        this.jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                        return initJLibrary();
                    } catch (ClassNotFoundException e4) {
                        return false;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return false;
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    this.identifyListener = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                    this.idSupplier = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                    this.jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                    return initJLibrary();
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                this.identifyListener = Class.forName("com.bun.supplier.IIdentifierListener");
                this.idSupplier = Class.forName("com.bun.supplier.IdSupplier");
                this.jLibrary = Class.forName("com.bun.miitmdid.core.JLibrary");
                return initJLibrary();
            }
        } catch (ClassNotFoundException e5) {
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    private void startMsaKlService(IGetter iGetter) {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.context.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.context.startService(intent);
            } else {
                this.context.startForegroundService(intent);
            }
        } catch (Throwable th) {
            iGetter.onOAIDGetError(new OAIDException(th));
        }
    }

    private void tryStartAidlFallback(CallbackOnceGetter callbackOnceGetter, AtomicBoolean atomicBoolean, IGetter iGetter) {
        if (!callbackOnceGetter.isDelivered() && atomicBoolean.compareAndSet(false, true)) {
            try {
                doGetByAIDL(iGetter);
            } catch (Throwable th) {
                iGetter.onOAIDGetError(new OAIDException(th));
            }
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(IGetter iGetter) {
        final CallbackOnceGetter callbackOnceGetter = new CallbackOnceGetter(iGetter);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final SuccessOnlyGetter successOnlyGetter = new SuccessOnlyGetter(callbackOnceGetter);
        MSA_EXECUTOR.execute(new Runnable() { // from class: com.tapsdk.tapad.oaid.impl.MsaImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m397lambda$doGet$2$comtapsdktapadoaidimplMsaImpl(callbackOnceGetter, atomicBoolean);
            }
        });
        ScheduledExecutorService scheduledExecutorService = MSA_WATCHDOG;
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.oaid.impl.MsaImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m398lambda$doGet$3$comtapsdktapadoaidimplMsaImpl(callbackOnceGetter, atomicBoolean, successOnlyGetter);
            }
        };
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        scheduledExecutorService.schedule(runnable, DEFAULT_AIDL_FALLBACK_DELAY_MS, timeUnit);
        scheduledExecutorService.schedule(new Runnable() { // from class: com.tapsdk.tapad.oaid.impl.MsaImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MsaImpl.lambda$doGet$4(callbackOnceGetter);
            }
        }, DEFAULT_TOTAL_TIMEOUT_MS, timeUnit);
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "MSA";
    }

    /* JADX INFO: renamed from: lambda$doGet$2$com-tapsdk-tapad-oaid-impl-MsaImpl, reason: not valid java name */
    /* synthetic */ void m397lambda$doGet$2$comtapsdktapadoaidimplMsaImpl(CallbackOnceGetter callbackOnceGetter, AtomicBoolean atomicBoolean) {
        try {
            getMSAOAIDByReflection(callbackOnceGetter);
        } catch (Exception e) {
            tryStartAidlFallback(callbackOnceGetter, atomicBoolean, callbackOnceGetter);
        }
    }

    /* JADX INFO: renamed from: lambda$doGet$3$com-tapsdk-tapad-oaid-impl-MsaImpl, reason: not valid java name */
    /* synthetic */ void m398lambda$doGet$3$comtapsdktapadoaidimplMsaImpl(CallbackOnceGetter callbackOnceGetter, AtomicBoolean atomicBoolean, IGetter iGetter) {
        if (callbackOnceGetter.isDelivered()) {
            return;
        }
        tryStartAidlFallback(callbackOnceGetter, atomicBoolean, iGetter);
    }

    /* JADX INFO: renamed from: lambda$getMSAOAIDByReflection$5$com-tapsdk-tapad-oaid-impl-MsaImpl, reason: not valid java name */
    /* synthetic */ Object m399lambda$getMSAOAIDByReflection$5$comtapsdktapadoaidimplMsaImpl(IGetter iGetter, Object obj, Method method, Object[] objArr) {
        try {
            method.getName();
            String strExtractOAIDFromCallback = extractOAIDFromCallback(method, objArr);
            if (isValidOAID(strExtractOAIDFromCallback)) {
                iGetter.onOAIDGetComplete(strExtractOAIDFromCallback);
                return null;
            }
            TextUtils.isEmpty(strExtractOAIDFromCallback);
            return null;
        } catch (Exception e) {
            iGetter.onOAIDGetError(new OAIDException("MSA callback error: " + e.getMessage()));
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (this.context.getPackageManager().getPackageInfo("com.mdid.msa", 0) == null) {
                throw new OAIDException("com.mdid.msa package not found");
            }
        } catch (Exception e) {
        }
        if (!prepareMSASDK()) {
            throw new OAIDException("MSA SDK not available or prepare failed");
        }
    }
}
