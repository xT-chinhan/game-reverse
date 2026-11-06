package com.taptap.sdk.initializer.di;

import com.taptap.sdk.initializer.api.ModuleFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joor.Reflect;

/* JADX INFO: compiled from: ModuleFactories.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/taptap/sdk/initializer/di/ModuleFactories;", "", "(Ljava/lang/String;I)V", "factory", "Lcom/taptap/sdk/initializer/api/ModuleFactory;", "getFactory", "()Lcom/taptap/sdk/initializer/api/ModuleFactory;", "INITIALIZER", "OPENLOG", "GID", "DB", "CORE", "SHARE", "REVIEW", "LOGIN", "ACHIEVEMENT", "COMPLIANCE", "LICENSE", "MOMENT", "UPDATE", "PAYMENT_BASE", "PAYMENT_ALIPAY_PLUS_METHOD", "PAYMENT_BRAIN_TREE_METHOD", "PAYMENT_STRIPE_METHOD", "PAYMENT_ALIPAY_CN_METHOD", "PAYMENT_WECHAT_CN_METHOD", "PAYMENT_CHECKOUT", "PAYMENT_IAP", "PAYMENT_CORE", "tap-initializer_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum ModuleFactories {
    INITIALIZER { // from class: com.taptap.sdk.initializer.di.ModuleFactories.INITIALIZER
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.initializer.di.InitializerModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    OPENLOG { // from class: com.taptap.sdk.initializer.di.ModuleFactories.OPENLOG
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.openlog.di.OpenLogModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    GID { // from class: com.taptap.sdk.initializer.di.ModuleFactories.GID
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.gid.di.GidModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    DB { // from class: com.taptap.sdk.initializer.di.ModuleFactories.DB
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.db.event.di.DBModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    CORE { // from class: com.taptap.sdk.initializer.di.ModuleFactories.CORE
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.core.di.CoreModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    SHARE { // from class: com.taptap.sdk.initializer.di.ModuleFactories.SHARE
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.share.di.ShareModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    REVIEW { // from class: com.taptap.sdk.initializer.di.ModuleFactories.REVIEW
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.review.di.ReviewModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    LOGIN { // from class: com.taptap.sdk.initializer.di.ModuleFactories.LOGIN
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.login.internal.di.LoginModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    ACHIEVEMENT { // from class: com.taptap.sdk.initializer.di.ModuleFactories.ACHIEVEMENT
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.achievement.di.AchievementModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    COMPLIANCE { // from class: com.taptap.sdk.initializer.di.ModuleFactories.COMPLIANCE
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.compilance.di.ComplianceModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    LICENSE { // from class: com.taptap.sdk.initializer.di.ModuleFactories.LICENSE
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.license.di.LicenseModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    MOMENT { // from class: com.taptap.sdk.initializer.di.ModuleFactories.MOMENT
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.moment.di.MomentModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    UPDATE { // from class: com.taptap.sdk.initializer.di.ModuleFactories.UPDATE
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.sdk.update.di.UpdateModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.sdk.…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    PAYMENT_BASE { // from class: com.taptap.sdk.initializer.di.ModuleFactories.PAYMENT_BASE
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.payment.protocol.di.PaymentBaseModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.paym…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    PAYMENT_ALIPAY_PLUS_METHOD { // from class: com.taptap.sdk.initializer.di.ModuleFactories.PAYMENT_ALIPAY_PLUS_METHOD
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.payment.alipay.di.AlipayPlusModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.paym…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    PAYMENT_BRAIN_TREE_METHOD { // from class: com.taptap.sdk.initializer.di.ModuleFactories.PAYMENT_BRAIN_TREE_METHOD
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.payment.braintree.di.BraintreeModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.paym…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    PAYMENT_STRIPE_METHOD { // from class: com.taptap.sdk.initializer.di.ModuleFactories.PAYMENT_STRIPE_METHOD
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.payment.stripe.di.StripeModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.paym…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    PAYMENT_ALIPAY_CN_METHOD { // from class: com.taptap.sdk.initializer.di.ModuleFactories.PAYMENT_ALIPAY_CN_METHOD
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.payment.alipaycn.di.AlipayCNModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.paym…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    PAYMENT_WECHAT_CN_METHOD { // from class: com.taptap.sdk.initializer.di.ModuleFactories.PAYMENT_WECHAT_CN_METHOD
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.payment.wechat.di.WechatModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.paym…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    PAYMENT_CHECKOUT { // from class: com.taptap.sdk.initializer.di.ModuleFactories.PAYMENT_CHECKOUT
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.payment.checkout.di.PaymentCheckoutModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.paym…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    PAYMENT_IAP { // from class: com.taptap.sdk.initializer.di.ModuleFactories.PAYMENT_IAP
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.payment.iap.di.PaymentIAPModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.paym…()\n                .get()");
            return (ModuleFactory) obj;
        }
    },
    PAYMENT_CORE { // from class: com.taptap.sdk.initializer.di.ModuleFactories.PAYMENT_CORE
        @Override // com.taptap.sdk.initializer.di.ModuleFactories
        public ModuleFactory getFactory() {
            Object obj = Reflect.onClass("com.taptap.payment.core.di.PaymentCoreModuleFactory").create().get();
            Intrinsics.checkNotNullExpressionValue(obj, "onClass(\"com.taptap.paym…()\n                .get()");
            return (ModuleFactory) obj;
        }
    };

    /* synthetic */ ModuleFactories(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract ModuleFactory getFactory();
}
