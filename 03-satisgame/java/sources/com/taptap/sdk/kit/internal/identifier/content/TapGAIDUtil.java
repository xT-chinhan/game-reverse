package com.taptap.sdk.kit.internal.identifier.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.byazt.gc.AbsServerManager;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil;
import com.taptap.sdk.kit.internal.utils.TapReflectionUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TapGAIDUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0017\u001a\u00020\u000e2\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/taptap/sdk/kit/internal/identifier/content/TapGAIDUtil;", "", "()V", "CONNECTION_RESULT_SUCCESS", "", "TAG", "", "gaid", "Lcom/taptap/sdk/kit/internal/identifier/TapIdentifierUtil$GAID;", "isQuerying", "Ljava/util/concurrent/atomic/AtomicBoolean;", "waitingList", "", "Lkotlin/Function1;", "", "getAndroidId", "context", "Landroid/content/Context;", "getAndroidIdViaReflection", "getAndroidIdViaService", "getGAID", "isGooglePlayServicesAvailable", "", "queryGAID", "callback", "GoogleAdInfo", "GoogleAdServiceConnection", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapGAIDUtil {
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final String TAG = "TapGAIDUtil";
    private static TapIdentifierUtil.GAID gaid;
    public static final TapGAIDUtil INSTANCE = new TapGAIDUtil();
    private static List<Function1<TapIdentifierUtil.GAID, Unit>> waitingList = new ArrayList();
    private static AtomicBoolean isQuerying = new AtomicBoolean(false);

    private TapGAIDUtil() {
    }

    public final void queryGAID(Function1<? super TapIdentifierUtil.GAID, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this) {
            TapIdentifierUtil.GAID gaid2 = gaid;
            if (gaid2 != null) {
                callback.invoke(gaid2);
                return;
            }
            waitingList.add(callback);
            if (isQuerying.get()) {
                return;
            }
            isQuerying.set(true);
            Unit unit = Unit.INSTANCE;
            ThreadsKt.thread$default(false, false, null, null, 0, new AnonymousClass2(), 31, null);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.kit.internal.identifier.content.TapGAIDUtil$queryGAID$2, reason: invalid class name */
    /* JADX INFO: compiled from: TapGAIDUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final TapIdentifierUtil.GAID androidId = TapGAIDUtil.INSTANCE.getAndroidId(TapTapKit.INSTANCE.getContext());
            Handler handler = new Handler(Looper.getMainLooper());
            final TapGAIDUtil tapGAIDUtil = TapGAIDUtil.this;
            handler.post(new Runnable() { // from class: com.taptap.sdk.kit.internal.identifier.content.TapGAIDUtil$queryGAID$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TapGAIDUtil.AnonymousClass2.invoke$lambda$2(tapGAIDUtil, androidId);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(TapGAIDUtil this$0, TapIdentifierUtil.GAID advertisingId) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(advertisingId, "$advertisingId");
            synchronized (this$0) {
                TapGAIDUtil tapGAIDUtil = TapGAIDUtil.INSTANCE;
                TapGAIDUtil.gaid = advertisingId;
                Iterator it = TapGAIDUtil.waitingList.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(advertisingId);
                }
                TapGAIDUtil.waitingList.clear();
                TapGAIDUtil.isQuerying.set(false);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final TapIdentifierUtil.GAID getGAID() {
        TapIdentifierUtil.GAID gaid2 = gaid;
        return gaid2 != null ? gaid2 : getAndroidId(TapTapKit.INSTANCE.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TapIdentifierUtil.GAID getAndroidId(Context context) {
        TapIdentifierUtil.GAID androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection != null) {
            return androidIdViaReflection;
        }
        TapIdentifierUtil.GAID androidIdViaService = getAndroidIdViaService(context);
        return androidIdViaService == null ? new TapIdentifierUtil.GAID(null, false, 3, null) : androidIdViaService;
    }

    private final boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = TapReflectionUtil.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object objInvokeMethodQuietly = TapReflectionUtil.invokeMethodQuietly(null, methodQuietly, context);
        return (objInvokeMethodQuietly instanceof Integer) && Intrinsics.areEqual(objInvokeMethodQuietly, (Object) 0);
    }

    private final TapIdentifierUtil.GAID getAndroidIdViaService(Context context) {
        GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            try {
                if (context.bindService(intent, googleAdServiceConnection, 1)) {
                    GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                    TapIdentifierUtil.GAID gaid2 = new TapIdentifierUtil.GAID(null, false, 3, null);
                    gaid2.setAndroidAdvertiserIdValue(googleAdInfo.getAdvertiserId());
                    gaid2.setTrackingLimited(googleAdInfo.isTrackingLimited());
                    return gaid2;
                }
            } catch (Exception e) {
                TapLogger.loge(TAG, "getAndroidIdViaService", e);
            } finally {
                context.unbindService(googleAdServiceConnection);
            }
        } catch (SecurityException unused) {
        }
        return null;
    }

    private final TapIdentifierUtil.GAID getAndroidIdViaReflection(Context context) {
        Object objInvokeMethodQuietly;
        try {
            if (!isGooglePlayServicesAvailable(context)) {
                return null;
            }
            Method methodQuietly = TapReflectionUtil.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null || (objInvokeMethodQuietly = TapReflectionUtil.invokeMethodQuietly(null, methodQuietly, context)) == null) {
                return null;
            }
            Method methodQuietly2 = TapReflectionUtil.getMethodQuietly(objInvokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
            Method methodQuietly3 = TapReflectionUtil.getMethodQuietly(objInvokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
            if (methodQuietly2 != null && methodQuietly3 != null) {
                TapIdentifierUtil.GAID gaid2 = new TapIdentifierUtil.GAID(null, false, 3, null);
                gaid2.setAndroidAdvertiserIdValue((String) TapReflectionUtil.invokeMethodQuietly(objInvokeMethodQuietly, methodQuietly2, new Object[0]));
                Boolean bool = (Boolean) TapReflectionUtil.invokeMethodQuietly(objInvokeMethodQuietly, methodQuietly3, new Object[0]);
                gaid2.setTrackingLimited(bool != null ? bool.booleanValue() : false);
                return gaid2;
            }
            return null;
        } catch (Exception e) {
            TapLogger.loge(TAG, "getAndroidIdViaReflection", e);
            return null;
        }
    }

    /* JADX INFO: compiled from: TapGAIDUtil.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/kit/internal/identifier/content/TapGAIDUtil$GoogleAdServiceConnection;", "Landroid/content/ServiceConnection;", "()V", AbsServerManager.BUNDLE_BINDER, "Landroid/os/IBinder;", "getBinder", "()Landroid/os/IBinder;", "consumed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "queue", "Ljava/util/concurrent/BlockingQueue;", "onServiceConnected", "", TapEventParamConstants.PARAM_NAME, "Landroid/content/ComponentName;", "service", "onServiceDisconnected", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class GoogleAdServiceConnection implements ServiceConnection {
        private final AtomicBoolean consumed = new AtomicBoolean(false);
        private final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (service != null) {
                try {
                    this.queue.put(service);
                } catch (InterruptedException e) {
                    TapLogger.loge(TapGAIDUtil.TAG, "onServiceConnected", e);
                }
            }
        }

        public final IBinder getBinder() throws InterruptedException {
            if (!(!this.consumed.compareAndSet(true, true))) {
                throw new IllegalStateException("Binder already consumed".toString());
            }
            IBinder iBinderTake = this.queue.take();
            Intrinsics.checkNotNullExpressionValue(iBinderTake, "queue.take()");
            return iBinderTake;
        }
    }

    /* JADX INFO: compiled from: TapGAIDUtil.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/kit/internal/identifier/content/TapGAIDUtil$GoogleAdInfo;", "Landroid/os/IInterface;", AbsServerManager.BUNDLE_BINDER, "Landroid/os/IBinder;", "(Landroid/os/IBinder;)V", "advertiserId", "", "getAdvertiserId", "()Ljava/lang/String;", "isTrackingLimited", "", "()Z", "asBinder", "Companion", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class GoogleAdInfo implements IInterface {
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private final IBinder binder;

        public GoogleAdInfo(IBinder binder) {
            Intrinsics.checkNotNullParameter(binder, "binder");
            this.binder = binder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.binder;
        }

        public final String getAdvertiserId() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
            Parcel parcelObtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain()");
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public final boolean isTrackingLimited() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
            Parcel parcelObtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(parcelObtain2, "obtain()");
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(1);
                this.binder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
