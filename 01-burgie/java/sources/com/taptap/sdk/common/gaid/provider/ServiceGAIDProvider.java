package com.taptap.sdk.common.gaid.provider;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.taptap.sdk.common.gaid.data.model.GAID;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ServiceGAIDProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/common/gaid/provider/ServiceGAIDProvider;", "Lcom/taptap/sdk/common/gaid/provider/GAIDProvider;", "()V", "createIntent", "Landroid/content/Intent;", "provideGAID", "Lcom/taptap/sdk/common/gaid/data/model/GAID;", d.R, "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryBindService", "", "intent", "connection", "Lcom/taptap/sdk/common/gaid/provider/GoogleAdServiceConnection;", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ServiceGAIDProvider implements GAIDProvider {
    private static final String ACTION = "com.google.android.gms.ads.identifier.service.START";
    private static final String PACKAGE = "com.google.android.gms";

    /* JADX INFO: renamed from: com.taptap.sdk.common.gaid.provider.ServiceGAIDProvider$provideGAID$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServiceGAIDProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.common.gaid.provider.ServiceGAIDProvider", f = "ServiceGAIDProvider.kt", i = {}, l = {19}, m = "provideGAID", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ServiceGAIDProvider.this.provideGAID(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.taptap.sdk.common.gaid.provider.GAIDProvider
    public Object provideGAID(Context context, Continuation<? super GAID> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Object objAwaitBinder;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object $result = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                GoogleAdServiceConnection connection = new GoogleAdServiceConnection();
                boolean bindSuccess = tryBindService(context, createIntent(), connection);
                if (!bindSuccess) {
                    return null;
                }
                anonymousClass2.label = 1;
                objAwaitBinder = connection.awaitBinder(anonymousClass2);
                if (objAwaitBinder == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objAwaitBinder = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IBinder binder = (IBinder) objAwaitBinder;
        GoogleAdServiceConnection.GoogleAdInfo adInfo = new GoogleAdServiceConnection.GoogleAdInfo(binder);
        return new GAID(adInfo.getAdvertiserId(), adInfo.isTrackingLimited());
    }

    private final Intent createIntent() {
        Intent $this$createIntent_u24lambda_u240 = new Intent(ACTION);
        $this$createIntent_u24lambda_u240.setPackage(PACKAGE);
        return $this$createIntent_u24lambda_u240;
    }

    private final boolean tryBindService(Context context, Intent intent, GoogleAdServiceConnection connection) {
        try {
            return context.bindService(intent, connection, 1);
        } catch (SecurityException e) {
            return false;
        }
    }
}
