package com.taptap.sdk.common.gaid.helper;

import android.content.Context;
import com.taptap.sdk.common.gaid.data.model.GAID;
import com.taptap.sdk.common.gaid.provider.GAIDProvider;
import com.taptap.sdk.common.gaid.provider.ReflectionGAIDProvider;
import com.umeng.analytics.pro.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: GAIDHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/common/gaid/helper/GAIDHelper;", "", "builder", "Lcom/taptap/sdk/common/gaid/helper/GAIDHelper$Builder;", "(Lcom/taptap/sdk/common/gaid/helper/GAIDHelper$Builder;)V", g.X, "Landroid/content/Context;", "reflectionGAIDProvider", "Lcom/taptap/sdk/common/gaid/provider/GAIDProvider;", "serviceGAIDProvider", "(Landroid/content/Context;Lcom/taptap/sdk/common/gaid/provider/GAIDProvider;Lcom/taptap/sdk/common/gaid/provider/GAIDProvider;)V", "getAndroidId", "Lcom/taptap/sdk/common/gaid/data/model/GAID;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Builder", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GAIDHelper {
    private static final long TIME_OUT = 60000;
    private final Context context;
    private final GAIDProvider reflectionGAIDProvider;
    private final GAIDProvider serviceGAIDProvider;

    /* JADX INFO: renamed from: com.taptap.sdk.common.gaid.helper.GAIDHelper$getAndroidId$1, reason: invalid class name */
    /* JADX INFO: compiled from: GAIDHelper.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.common.gaid.helper.GAIDHelper", f = "GAIDHelper.kt", i = {0}, l = {35, 42}, m = "getAndroidId", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GAIDHelper.this.getAndroidId(this);
        }
    }

    public /* synthetic */ GAIDHelper(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GAIDHelper(Context context, GAIDProvider gAIDProvider, GAIDProvider gAIDProvider2) {
        this.context = context;
        this.reflectionGAIDProvider = gAIDProvider;
        this.serviceGAIDProvider = gAIDProvider2;
    }

    private GAIDHelper(Builder builder) {
        this(builder.getContext(), builder.getReflectionGAIDProvider(), builder.getServiceGAIDProvider());
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0072 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0073 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAndroidId(Continuation<? super GAID> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        GAIDHelper gAIDHelper;
        GAID gaid;
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
        Object objWithTimeoutOrNull = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                gAIDHelper = (GAIDHelper) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
            }
            gaid = (GAID) objWithTimeoutOrNull;
            if (gaid != null) {
                return gaid;
            }
            return null;
        }
        ResultKt.throwOnFailure(objWithTimeoutOrNull);
        GAIDHelper$getAndroidId$reflectionData$1 gAIDHelper$getAndroidId$reflectionData$1 = new GAIDHelper$getAndroidId$reflectionData$1(this, null);
        anonymousClass1.L$0 = this;
        anonymousClass1.label = 1;
        objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(60000L, gAIDHelper$getAndroidId$reflectionData$1, anonymousClass1);
        if (objWithTimeoutOrNull == coroutine_suspended) {
            return coroutine_suspended;
        }
        gAIDHelper = this;
        GAID gaid2 = (GAID) objWithTimeoutOrNull;
        if (gaid2 != null) {
            return gaid2;
        }
        GAIDHelper$getAndroidId$serviceData$1 gAIDHelper$getAndroidId$serviceData$1 = new GAIDHelper$getAndroidId$serviceData$1(gAIDHelper, null);
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 2;
        objWithTimeoutOrNull = TimeoutKt.withTimeoutOrNull(60000L, gAIDHelper$getAndroidId$serviceData$1, anonymousClass1);
        if (objWithTimeoutOrNull == coroutine_suspended) {
            return coroutine_suspended;
        }
        gaid = (GAID) objWithTimeoutOrNull;
        if (gaid != null) {
            return gaid;
        }
        return null;
    }

    /* JADX INFO: compiled from: GAIDHelper.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/taptap/sdk/common/gaid/helper/GAIDHelper$Builder;", "", g.X, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "<set-?>", "Lcom/taptap/sdk/common/gaid/provider/GAIDProvider;", "reflectionGAIDProvider", "getReflectionGAIDProvider$tap_common_release", "()Lcom/taptap/sdk/common/gaid/provider/GAIDProvider;", "serviceGAIDProvider", "getServiceGAIDProvider$tap_common_release", "build", "Lcom/taptap/sdk/common/gaid/helper/GAIDHelper;", "setReflectionGAIDProvider", "setServiceGAIDProvider", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private final Context context;
        private GAIDProvider reflectionGAIDProvider;
        private GAIDProvider serviceGAIDProvider;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.reflectionGAIDProvider = new ReflectionGAIDProvider();
            this.serviceGAIDProvider = new ReflectionGAIDProvider();
        }

        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: renamed from: getReflectionGAIDProvider$tap_common_release, reason: from getter */
        public final GAIDProvider getReflectionGAIDProvider() {
            return this.reflectionGAIDProvider;
        }

        /* JADX INFO: renamed from: getServiceGAIDProvider$tap_common_release, reason: from getter */
        public final GAIDProvider getServiceGAIDProvider() {
            return this.serviceGAIDProvider;
        }

        public final Builder setReflectionGAIDProvider(GAIDProvider reflectionGAIDProvider) {
            Intrinsics.checkNotNullParameter(reflectionGAIDProvider, "reflectionGAIDProvider");
            this.reflectionGAIDProvider = reflectionGAIDProvider;
            return this;
        }

        public final Builder setServiceGAIDProvider(GAIDProvider serviceGAIDProvider) {
            Intrinsics.checkNotNullParameter(serviceGAIDProvider, "serviceGAIDProvider");
            this.serviceGAIDProvider = serviceGAIDProvider;
            return this;
        }

        public final GAIDHelper build() {
            return new GAIDHelper(this, null);
        }
    }
}
