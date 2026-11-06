package com.efs.sdk.memleaksdk.monitor.shark;

import com.taptap.sdk.compliance.constants.BundleKey;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak, reason: from Kotlin metadata */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\bE\b\u0086\u0001\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001KB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H ¢\u0006\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJ¨\u0006L"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidReferenceMatchers;", "", "(Ljava/lang/String;I)V", "add", "", "references", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "add$memleaksdk_release", "IREQUEST_FINISH_CALLBACK", "ACTIVITY_CLIENT_RECORD__NEXT_IDLE", "SPAN_CONTROLLER", "MEDIA_SESSION_LEGACY_HELPER__SINSTANCE", "TEXT_LINE__SCACHED", "BLOCKING_QUEUE", "INPUT_METHOD_MANAGER_IS_TERRIBLE", "LAYOUT_TRANSITION", "SPELL_CHECKER_SESSION", "SPELL_CHECKER", "ACTIVITY_CHOOSE_MODEL", "MEDIA_PROJECTION_CALLBACK", "SPEECH_RECOGNIZER", "ACCOUNT_MANAGER", "MEDIA_SCANNER_CONNECTION", "USER_MANAGER__SINSTANCE", "APP_WIDGET_HOST_CALLBACKS", "AUDIO_MANAGER", "EDITTEXT_BLINK_MESSAGEQUEUE", "CONNECTIVITY_MANAGER__SINSTANCE", "ACCESSIBILITY_NODE_INFO__MORIGINALTEXT", "ASSIST_STRUCTURE", "ACCESSIBILITY_ITERATORS", "BIOMETRIC_PROMPT", "MAGNIFIER", "BACKDROP_FRAME_RENDERER__MDECORVIEW", "VIEWLOCATIONHOLDER_ROOT", "ACCESSIBILITY_NODE_ID_MANAGER", "TEXT_TO_SPEECH", "CONTROLLED_INPUT_CONNECTION_WRAPPER", "TOAST_TN", "APPLICATION_PACKAGE_MANAGER__HAS_SYSTEM_FEATURE_QUERY", "SPEN_GESTURE_MANAGER", "CLIPBOARD_UI_MANAGER__SINSTANCE", "SEM_CLIPBOARD_MANAGER__MCONTEXT", "CLIPBOARD_EX_MANAGER", "SEM_EMERGENCY_MANAGER__MCONTEXT", "SEM_PERSONA_MANAGER", "SEM_APP_ICON_SOLUTION", "AW_RESOURCE__SRESOURCES", "TEXT_VIEW__MLAST_HOVERED_VIEW", "PERSONA_MANAGER", "RESOURCES__MCONTEXT", "VIEW_CONFIGURATION__MCONTEXT", "AUDIO_MANAGER__MCONTEXT_STATIC", "ACTIVITY_MANAGER_MCONTEXT", "STATIC_MTARGET_VIEW", "MULTI_WINDOW_DECOR_SUPPORT__MWINDOW", "GESTURE_BOOST_MANAGER", "BUBBLE_POPUP_HELPER__SHELPER", "LGCONTEXT__MCONTEXT", "SMART_COVER_MANAGER", "MAPPER_CLIENT", "SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL", "INSTRUMENTATION_RECOMMEND_ACTIVITY", "DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER", "EXTENDED_STATUS_BAR_MANAGER", "OEM_SCENE_CALL_BLOCKER", "RAZER_TEXT_KEY_LISTENER__MCONTEXT", "REFERENCES", "FINALIZER_WATCHDOG_DAEMON", "MAIN", "LEAK_CANARY_THREAD", "LEAK_CANARY_HEAP_DUMPER", "LEAK_CANARY_INTERNAL", "EVENT_RECEIVER__MMESSAGE_QUEUE", "Companion", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
public abstract class AndroidReferenceMatchers {
    public static final AndroidReferenceMatchers A;
    public static final AndroidReferenceMatchers B;
    public static final AndroidReferenceMatchers C;
    public static final AndroidReferenceMatchers D;
    public static final AndroidReferenceMatchers E;
    public static final AndroidReferenceMatchers F;
    public static final AndroidReferenceMatchers G;
    public static final AndroidReferenceMatchers H;
    public static final AndroidReferenceMatchers I;
    public static final AndroidReferenceMatchers J;
    public static final AndroidReferenceMatchers K;
    public static final AndroidReferenceMatchers L;
    public static final AndroidReferenceMatchers M;
    public static final AndroidReferenceMatchers N;
    public static final AndroidReferenceMatchers O;
    public static final AndroidReferenceMatchers P;
    public static final AndroidReferenceMatchers Q;
    public static final AndroidReferenceMatchers R;
    public static final AndroidReferenceMatchers S;
    public static final AndroidReferenceMatchers T;
    public static final AndroidReferenceMatchers U;
    public static final AndroidReferenceMatchers V;
    public static final AndroidReferenceMatchers W;
    public static final AndroidReferenceMatchers X;
    public static final AndroidReferenceMatchers Y;
    public static final AndroidReferenceMatchers Z;
    public static final AndroidReferenceMatchers a;
    public static final AndroidReferenceMatchers aa;
    public static final AndroidReferenceMatchers ab;
    public static final AndroidReferenceMatchers ac;
    public static final AndroidReferenceMatchers ad;
    public static final AndroidReferenceMatchers ae;
    public static final AndroidReferenceMatchers af;
    public static final AndroidReferenceMatchers ag;
    public static final AndroidReferenceMatchers ah;
    public static final AndroidReferenceMatchers ai;
    public static final AndroidReferenceMatchers aj;
    public static final AndroidReferenceMatchers ak;
    public static final AndroidReferenceMatchers al;
    public static final AndroidReferenceMatchers am;
    public static final AndroidReferenceMatchers an;
    public static final v ao;
    private static final /* synthetic */ AndroidReferenceMatchers[] ap;
    private static final Function1<AndroidBuildMirror, Boolean> aq;
    public static final AndroidReferenceMatchers b;
    public static final AndroidReferenceMatchers c;
    public static final AndroidReferenceMatchers d;
    public static final AndroidReferenceMatchers e;
    public static final AndroidReferenceMatchers f;
    public static final AndroidReferenceMatchers g;
    public static final AndroidReferenceMatchers h;
    public static final AndroidReferenceMatchers i;
    public static final AndroidReferenceMatchers j;
    public static final AndroidReferenceMatchers k;
    public static final AndroidReferenceMatchers l;
    public static final AndroidReferenceMatchers m;
    public static final AndroidReferenceMatchers n;
    public static final AndroidReferenceMatchers o;
    public static final AndroidReferenceMatchers p;
    public static final AndroidReferenceMatchers q;
    public static final AndroidReferenceMatchers r;
    public static final AndroidReferenceMatchers s;
    public static final AndroidReferenceMatchers t;
    public static final AndroidReferenceMatchers u;
    public static final AndroidReferenceMatchers v;
    public static final AndroidReferenceMatchers w;
    public static final AndroidReferenceMatchers x;
    public static final AndroidReferenceMatchers y;
    public static final AndroidReferenceMatchers z;

    public static final List<ReferenceMatcher> b() {
        return ao.a();
    }

    public static AndroidReferenceMatchers valueOf(String str) {
        return (AndroidReferenceMatchers) Enum.valueOf(AndroidReferenceMatchers.class, str);
    }

    public static AndroidReferenceMatchers[] values() {
        return (AndroidReferenceMatchers[]) ap.clone();
    }

    public abstract void a(List<ReferenceMatcher> list);

    private AndroidReferenceMatchers(String str, int i2) {
        super(str, i2);
    }

    public /* synthetic */ AndroidReferenceMatchers(String str, int i2, byte b2) {
        this(str, i2);
    }

    /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$v */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0007J\u0010\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020\tH\u0007J=\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\b\b\u0002\u0010*\u001a\u00020\t2\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007J1\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.2\u0006\u0010*\u001a\u00020\t2\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0002J5\u0010/\u001a\u00020)2\u0006\u0010$\u001a\u00020\t2\b\b\u0002\u0010*\u001a\u00020\t2\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007J=\u00100\u001a\u00020)2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\b\b\u0002\u0010*\u001a\u00020\t2\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007R\u001f\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u001a¨\u00061"}, d2 = {"Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidReferenceMatchers$Companion;", "", "()V", "ALWAYS", "Lkotlin/Function1;", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "", "Lkotlin/ExtensionFunctionType;", "HUAWEI", "", "LEAK_CANARY_THREAD_NAME", "LENOVO", "LG", "MEIZU", "MOTOROLA", "NVIDIA", "ONE_PLUS", "RAZER", "SAMSUNG", "SHARP", "VIVO", "appDefaults", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferenceMatcher;", "getAppDefaults$annotations", "getAppDefaults", "()Ljava/util/List;", "ignoredReferencesOnly", "getIgnoredReferencesOnly$annotations", "getIgnoredReferencesOnly", "buildKnownReferences", "referenceMatchers", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidReferenceMatchers;", "ignoredInstanceField", "Lcom/efs/sdk/memleaksdk/monitor/shark/IgnoredReferenceMatcher;", "className", "fieldName", "ignoredJavaLocal", "threadName", "instanceFieldLeak", "Lcom/efs/sdk/memleaksdk/monitor/shark/LibraryLeakReferenceMatcher;", BundleKey.DESCRIPTION, "patternApplies", "libraryLeak", "referencePattern", "Lcom/efs/sdk/memleaksdk/monitor/shark/ReferencePattern;", "nativeGlobalVariableLeak", "staticFieldLeak", "memleaksdk_release"}, k = 1, mv = {1, 4, 1})
    public static final class v {

        /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$v$a */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "graph", "Lcom/efs/sdk/memleaksdk/monitor/shark/HeapGraph;", "invoke"}, k = 3, mv = {1, 4, 1})
        static final class a extends Lambda implements Function1<HeapGraph, Boolean> {
            final /* synthetic */ Function1 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Function1 function1) {
                super(1);
                this.a = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Boolean invoke(HeapGraph heapGraph) {
                return Boolean.valueOf(a(heapGraph));
            }

            public final boolean a(HeapGraph graph) {
                Intrinsics.checkNotNullParameter(graph, "graph");
                return ((Boolean) this.a.invoke(AndroidBuildMirror.c.a(graph))).booleanValue();
            }
        }

        private v() {
        }

        public /* synthetic */ v(byte b) {
            this();
        }

        public final List<ReferenceMatcher> a() {
            v vVar = AndroidReferenceMatchers.ao;
            EnumSet enumSetAllOf = EnumSet.allOf(AndroidReferenceMatchers.class);
            Intrinsics.checkNotNullExpressionValue(enumSetAllOf, "EnumSet.allOf(AndroidRef…enceMatchers::class.java)");
            return vVar.a(enumSetAllOf);
        }

        @JvmStatic
        public final List<ReferenceMatcher> a(Set<? extends AndroidReferenceMatchers> referenceMatchers) {
            Intrinsics.checkNotNullParameter(referenceMatchers, "referenceMatchers");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = referenceMatchers.iterator();
            while (it.hasNext()) {
                ((AndroidReferenceMatchers) it.next()).a(arrayList);
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LibraryLeakReferenceMatcher a(v vVar, String str, String str2, String str3, Function1 function1, int i) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            if ((i & 8) != 0) {
                function1 = AndroidReferenceMatchers.aq;
            }
            return vVar.a(str, str2, str3, function1);
        }

        @JvmStatic
        public final LibraryLeakReferenceMatcher a(String className, String fieldName, String description, Function1<? super AndroidBuildMirror, Boolean> patternApplies) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(patternApplies, "patternApplies");
            return a(new ReferencePattern.e(className, fieldName), description, patternApplies);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LibraryLeakReferenceMatcher b(v vVar, String str, String str2, String str3, Function1 function1, int i) {
            if ((i & 4) != 0) {
                str3 = "";
            }
            if ((i & 8) != 0) {
                function1 = AndroidReferenceMatchers.aq;
            }
            return vVar.b(str, str2, str3, function1);
        }

        @JvmStatic
        public final LibraryLeakReferenceMatcher b(String className, String fieldName, String description, Function1<? super AndroidBuildMirror, Boolean> patternApplies) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(patternApplies, "patternApplies");
            return a(new ReferencePattern.b(className, fieldName), description, patternApplies);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LibraryLeakReferenceMatcher a(v vVar, String str, String str2, Function1 function1, int i) {
            if ((i & 2) != 0) {
                str2 = "";
            }
            if ((i & 4) != 0) {
                function1 = AndroidReferenceMatchers.aq;
            }
            return vVar.a(str, str2, (Function1<? super AndroidBuildMirror, Boolean>) function1);
        }

        @JvmStatic
        public final LibraryLeakReferenceMatcher a(String className, String description, Function1<? super AndroidBuildMirror, Boolean> patternApplies) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(patternApplies, "patternApplies");
            return a(new ReferencePattern.d(className), description, patternApplies);
        }

        private final LibraryLeakReferenceMatcher a(ReferencePattern referencePattern, String str, Function1<? super AndroidBuildMirror, Boolean> function1) {
            return new LibraryLeakReferenceMatcher(referencePattern, str, new a(function1));
        }

        @JvmStatic
        public final IgnoredReferenceMatcher a(String className, String fieldName) {
            Intrinsics.checkNotNullParameter(className, "className");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            return new IgnoredReferenceMatcher(new ReferencePattern.b(className, fieldName));
        }

        @JvmStatic
        public final IgnoredReferenceMatcher a(String threadName) {
            Intrinsics.checkNotNullParameter(threadName, "threadName");
            return new IgnoredReferenceMatcher(new ReferencePattern.c(threadName));
        }
    }

    static {
        byte b2 = 0;
        AndroidReferenceMatchers androidReferenceMatchers = new AndroidReferenceMatchers("IREQUEST_FINISH_CALLBACK", b2) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.af

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$af$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 29;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.app.Activity$1", "this$0", "Android Q added a new android.app.IRequestFinishCallback$Stub class. android.app.Activity creates an implementation of that interface as an anonymous subclass. That anonymous subclass has a reference to the activity. Another process is keeping the android.app.IRequestFinishCallback$Stub reference alive long after Activity.onDestroyed() has been called, causing the activity to leak. Fix: You can \"fix\" this leak by overriding Activity.onBackPressed() and calling Activity.finishAfterTransition(); instead of super if the activity is task root and the fragment stack is empty. Tracked here: https://issuetracker.google.com/issues/139738913", a.a));
            }
        };
        a = androidReferenceMatchers;
        AndroidReferenceMatchers androidReferenceMatchers2 = new AndroidReferenceMatchers("ACTIVITY_CLIENT_RECORD__NEXT_IDLE", 1) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.f

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$f$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 19 <= i && 27 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.app.ActivityThread$ActivityClientRecord", "nextIdle", "Android AOSP sometimes keeps a reference to a destroyed activity as a nextIdle client record in the android.app.ActivityThread.mActivities map. Not sure what's going on there, input welcome.", a.a));
            }
        };
        b = androidReferenceMatchers2;
        AndroidReferenceMatchers androidReferenceMatchers3 = new AndroidReferenceMatchers("SPAN_CONTROLLER", 2) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bc

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bc$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b <= 19;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bc$b */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class b extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final b a = new b();

                b() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b <= 19;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                List<ReferenceMatcher> list = references;
                list.add(AndroidReferenceMatchers.ao.b("android.widget.Editor$SpanController", "this$0", "Editor inserts a special span, which has a reference to the EditText. That span is a NoCopySpan, which makes sure it gets dropped when creating a new SpannableStringBuilder from a given CharSequence. TextView.onSaveInstanceState() does a copy of its mText before saving it in the bundle. Prior to KitKat, that copy was done using the SpannableString constructor, instead of SpannableStringBuilder. The SpannableString constructor does not drop NoCopySpan spans. So we end up with a saved state that holds a reference to the textview and therefore the entire view hierarchy & activity context. Fix: https://github.com/android/platform_frameworks_base/commit/af7dcdf35a37d7a7dbaad7d9869c1c91bce2272b . To fix this, you could override TextView.onSaveInstanceState(), and then use reflection to access TextView.SavedState.mText and clear the NoCopySpan spans.", a.a));
                list.add(AndroidReferenceMatchers.ao.b("android.widget.Editor$EasyEditSpanController", "this$0", "Editor inserts a special span, which has a reference to the EditText. That span is a NoCopySpan, which makes sure it gets dropped when creating a new SpannableStringBuilder from a given CharSequence. TextView.onSaveInstanceState() does a copy of its mText before saving it in the bundle. Prior to KitKat, that copy was done using the SpannableString constructor, instead of SpannableStringBuilder. The SpannableString constructor does not drop NoCopySpan spans. So we end up with a saved state that holds a reference to the textview and therefore the entire view hierarchy & activity context. Fix: https://github.com/android/platform_frameworks_base/commit/af7dcdf35a37d7a7dbaad7d9869c1c91bce2272b . To fix this, you could override TextView.onSaveInstanceState(), and then use reflection to access TextView.SavedState.mText and clear the NoCopySpan spans.", b.a));
            }
        };
        c = androidReferenceMatchers3;
        AndroidReferenceMatchers androidReferenceMatchers4 = new AndroidReferenceMatchers("MEDIA_SESSION_LEGACY_HELPER__SINSTANCE", 3) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.aq

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$aq$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 21;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.media.session.MediaSessionLegacyHelper", "sInstance", "MediaSessionLegacyHelper is a static singleton that is lazily instantiated and keeps a reference to the context it's given the first time MediaSessionLegacyHelper.getHelper() is called. This leak was introduced in android-5.0.1_r1 and fixed in Android 5.1.0_r1 by calling context.getApplicationContext(). Fix: https://github.com/android/platform_frameworks_base/commit/9b5257c9c99c4cb541d8e8e78fb04f008b1a9091 To fix this, you could call MediaSessionLegacyHelper.getHelper() early in Application.onCreate() and pass it the application context.", a.a));
            }
        };
        d = androidReferenceMatchers4;
        AndroidReferenceMatchers androidReferenceMatchers5 = new AndroidReferenceMatchers("TEXT_LINE__SCACHED", 4) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bj

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bj$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b <= 22;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.text.TextLine", "sCached", "TextLine.sCached is a pool of 3 TextLine instances. TextLine.recycle() has had at least two bugs that created memory leaks by not correctly clearing the recycled TextLine instances. The first was fixed in android-5.1.0_r1: https://github.com/android/platform_frameworks_base/commit/893d6fe48d37f71e683f722457bea646994a10 The second was fixed, not released yet: https://github.com/android/platform_frameworks_base/commit/b3a9bc038d3a218b1dbdf7b5668e3d6c12be5e To fix this, you could access TextLine.sCached and clear the pool every now and then (e.g. on activity destroy).", a.a));
            }
        };
        e = androidReferenceMatchers5;
        AndroidReferenceMatchers androidReferenceMatchers6 = new AndroidReferenceMatchers("BLOCKING_QUEUE", 5) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.p
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(v.b(AndroidReferenceMatchers.ao, "android.os.Message", "obj", "A thread waiting on a blocking queue will leak the last dequeued object as a stack local reference. So when a HandlerThread becomes idle, it keeps a local reference to the last message it received. That message then gets recycled and can be used again. As long as all messages are recycled after being used, this won't be a problem, because these references are cleared when being recycled. However, dialogs create template Message instances to be copied when a message needs to be sent. These Message templates holds references to the dialog listeners, which most likely leads to holding a reference onto the activity in some way. Dialogs never recycle their template Message, assuming these Message instances will get GCed when the dialog is GCed. The combination of these two things creates a high potential for memory leaks as soon as you use dialogs. These memory leaks might be temporary, but some handler threads sleep for a long time. To fix this, you could post empty messages to the idle handler threads from time to time. This won't be easy because you cannot access all handler threads, but a library that is widely used should consider doing this for its own handler threads. This leaks has been shown to happen in both Dalvik and ART.", null, 8));
            }
        };
        f = androidReferenceMatchers6;
        AndroidReferenceMatchers androidReferenceMatchers7 = new AndroidReferenceMatchers("INPUT_METHOD_MANAGER_IS_TERRIBLE", 6) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ad

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ad$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 15 <= i && 27 >= i;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ad$b */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class b extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final b a = new b();

                b() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 15 <= i && 27 >= i;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ad$c */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class c extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final c a = new c();

                c() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 15 <= i && 27 >= i;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ad$d */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class d extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final d a = new d();

                d() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "HUAWEI") && 23 <= (i = receiver.b) && 28 >= i;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ad$e */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class e extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final e a = new e();

                e() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 15 <= i && 28 >= i;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ad$f */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class f extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final f a = new f();

                f() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 28;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ad$g */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class g extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final g a = new g();

                g() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 28 <= i && 29 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                List<ReferenceMatcher> list = references;
                list.add(AndroidReferenceMatchers.ao.b("android.view.inputmethod.InputMethodManager", "mNextServedView", "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", a.a));
                list.add(AndroidReferenceMatchers.ao.b("android.view.inputmethod.InputMethodManager", "mServedView", "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", b.a));
                list.add(AndroidReferenceMatchers.ao.b("android.view.inputmethod.InputMethodManager", "mServedInputConnection", "When we detach a view that receives keyboard input, the InputMethodManager leaks a reference to it until a new view asks for keyboard input. Tracked here: https://code.google.com/p/android/issues/detail?id=171190 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", c.a));
                list.add(AndroidReferenceMatchers.ao.b("android.view.inputmethod.InputMethodManager", "mLastSrvView", "HUAWEI added a mLastSrvView field to InputMethodManager that leaks a reference to the last served view.", d.a));
                list.add(AndroidReferenceMatchers.ao.b("android.view.inputmethod.InputMethodManager", "mCurRootView", "The singleton InputMethodManager is holding a reference to mCurRootView long after the activity has been destroyed. Observed on ICS MR1: https://github.com/square/leakcanary/issues/1#issuecomment-100579429 Hack: https://gist.github.com/pyricau/4df64341cc978a7de414", e.a));
                list.add(AndroidReferenceMatchers.ao.b("android.view.inputmethod.InputMethodManager", "mImeInsetsConsumer", "Android Q Beta has a leak where InputMethodManager.mImeInsetsConsumer isn't set to\nnull when the activity is destroyed.", f.a));
                list.add(AndroidReferenceMatchers.ao.b("android.view.inputmethod.InputMethodManager", "mCurrentInputConnection", "In Android Q Beta InputMethodManager keeps its EditableInputConnection after the\nactivity has been destroyed.", g.a));
            }
        };
        g = androidReferenceMatchers7;
        AndroidReferenceMatchers androidReferenceMatchers8 = new AndroidReferenceMatchers("LAYOUT_TRANSITION", 7) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ag

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ag$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 14 <= i && 22 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.animation.LayoutTransition$1", "val$parent", "LayoutTransition leaks parent ViewGroup through ViewTreeObserver.OnPreDrawListener When triggered, this leaks stays until the window is destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=171830", a.a));
            }
        };
        h = androidReferenceMatchers8;
        AndroidReferenceMatchers androidReferenceMatchers9 = new AndroidReferenceMatchers("SPELL_CHECKER_SESSION", 8) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bf

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bf$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 16 <= i && 24 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.view.textservice.SpellCheckerSession$1", "this$0", "SpellCheckerSessionListenerImpl.mHandler is leaking destroyed Activity when the SpellCheckerSession is closed before the service is connected. Tracked here: https://code.google.com/p/android/issues/detail?id=172542", a.a));
            }
        };
        i = androidReferenceMatchers9;
        AndroidReferenceMatchers androidReferenceMatchers10 = new AndroidReferenceMatchers("SPELL_CHECKER", 9) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.be

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$be$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 22;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.widget.SpellChecker$1", "this$0", "SpellChecker holds on to a detached view that points to a destroyed activity. mSpellRunnable is being enqueued, and that callback should be removed when  closeSession() is called. Maybe closeSession() wasn't called, or maybe it was  called after the view was detached.", a.a));
            }
        };
        j = androidReferenceMatchers10;
        AndroidReferenceMatchers androidReferenceMatchers11 = new AndroidReferenceMatchers("ACTIVITY_CHOOSE_MODEL", 10) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.e

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$e$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 15 <= i && 22 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                List<ReferenceMatcher> list = references;
                list.add(AndroidReferenceMatchers.ao.b("androidx.appcompat.internal.widget.ActivityChooserModel", "mActivityChoserModelPolicy", "ActivityChooserModel holds a static reference to the last set ActivityChooserModelPolicy which can be an activity context. Tracked here: https://code.google.com/p/android/issues/detail?id=172659 Hack: https://gist.github.com/andaag/b05ab66ed0f06167d6e0", a.a));
                list.add(v.b(AndroidReferenceMatchers.ao, "android.widget.ActivityChooserModel", "mActivityChoserModelPolicy", "ActivityChooserModel holds a static reference to the last set ActivityChooserModelPolicy which can be an activity context. Tracked here: https://code.google.com/p/android/issues/detail?id=172659 Hack: https://gist.github.com/andaag/b05ab66ed0f06167d6e0", null, 8));
            }
        };
        k = androidReferenceMatchers11;
        AndroidReferenceMatchers androidReferenceMatchers12 = new AndroidReferenceMatchers("MEDIA_PROJECTION_CALLBACK", 11) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ao

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ao$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 22 <= i && 28 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.media.projection.MediaProjection$MediaProjectionCallback", "this$0", "MediaProjectionCallback is held by another process, and holds on to MediaProjection\nwhich has an activity as its context.", a.a));
            }
        };
        l = androidReferenceMatchers12;
        AndroidReferenceMatchers androidReferenceMatchers13 = new AndroidReferenceMatchers("SPEECH_RECOGNIZER", 12) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bd

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bd$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b < 21;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.speech.SpeechRecognizer$InternalListener", "this$0", "Prior to Android 5, SpeechRecognizer.InternalListener was a non static inner class and leaked the SpeechRecognizer which leaked an activity context. Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit /b37866db469e81aca534ff6186bdafd44352329b", a.a));
            }
        };
        m = androidReferenceMatchers13;
        AndroidReferenceMatchers androidReferenceMatchers14 = new AndroidReferenceMatchers("ACCOUNT_MANAGER", 13) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.d

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$d$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b <= 27;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.accounts.AccountManager$AmsTask$Response", "this$1", "AccountManager$AmsTask$Response is a stub and is held in memory by native code, probably because the reference to the response in the other process hasn't been cleared. AccountManager$AmsTask is holding on to the activity reference to use for launching a new sub- Activity. Tracked here: https://code.google.com/p/android/issues/detail?id=173689 Fix: Pass a null activity reference to the AccountManager methods and then deal with the returned future to to get the result and correctly start an activity when it's available.", a.a));
            }
        };
        n = androidReferenceMatchers14;
        AndroidReferenceMatchers androidReferenceMatchers15 = new AndroidReferenceMatchers("MEDIA_SCANNER_CONNECTION", 14) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ap

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ap$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b <= 22;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.media.MediaScannerConnection", "mContext", "The static method MediaScannerConnection.scanFile() takes an activity context but the service might not disconnect after the activity has been destroyed. Tracked here: https://code.google.com/p/android/issues/detail?id=173788 Fix: Create an instance of MediaScannerConnection yourself and pass in the application context. Call connect() and disconnect() manually.", a.a));
            }
        };
        o = androidReferenceMatchers15;
        AndroidReferenceMatchers androidReferenceMatchers16 = new AndroidReferenceMatchers("USER_MANAGER__SINSTANCE", 15) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bn

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bn$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 18 <= i && 25 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.os.UserManager", "mContext", "UserManager has a static sInstance field that creates an instance and caches it the first time UserManager.get() is called. This instance is created with the outer context (which is an activity base context). Tracked here: https://code.google.com/p/android/issues/detail?id=173789 Introduced by: https://github.com/android/platform_frameworks_base/commit/27db46850b708070452c0ce49daf5f79503fbde6 Fix: trigger a call to UserManager.get() in Application.onCreate(), so that the UserManager instance gets cached with a reference to the application context.", a.a));
            }
        };
        p = androidReferenceMatchers16;
        AndroidReferenceMatchers androidReferenceMatchers17 = new AndroidReferenceMatchers("APP_WIDGET_HOST_CALLBACKS", 16) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.i

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$i$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b < 22;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.appwidget.AppWidgetHost$Callbacks", "this$0", "android.appwidget.AppWidgetHost$Callbacks is a stub and is held in memory native code. The reference to the `mContext` was not being cleared, which caused the Callbacks instance to retain this reference Fixed in AOSP: https://github.com/android/platform_frameworks_base/commit/7a96f3c917e0001ee739b65da37b2fadec7d7765", a.a));
            }
        };
        q = androidReferenceMatchers17;
        AndroidReferenceMatchers androidReferenceMatchers18 = new AndroidReferenceMatchers("AUDIO_MANAGER", 17) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.k

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$k$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b <= 22;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.media.AudioManager$1", "this$0", "Prior to Android M, VideoView required audio focus from AudioManager and never abandoned it, which leaks the Activity context through the AudioManager. The root of the problem is that AudioManager uses whichever context it receives, which in the case of the VideoView example is an Activity, even though it only needs the application's context. The issue is fixed in Android M, and the AudioManager now uses the application's context. Tracked here: https://code.google.com/p/android/issues/detail?id=152173 Fix: https://gist.github.com/jankovd/891d96f476f7a9ce24e2", a.a));
            }
        };
        r = androidReferenceMatchers18;
        AndroidReferenceMatchers androidReferenceMatchers19 = new AndroidReferenceMatchers("EDITTEXT_BLINK_MESSAGEQUEUE", 18) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.y

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$y$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b <= 23;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.widget.Editor$Blink", "this$0", "The EditText Blink of the Cursor is implemented using a callback and Messages, which trigger the display of the Cursor. If an AlertDialog or DialogFragment that contains a blinking cursor is detached, a message is posted with a delay after the dialog has been closed and as a result leaks the Activity. This can be fixed manually by calling TextView.setCursorVisible(false) in the dismiss() method of the dialog. Tracked here: https://code.google.com/p/android/issues/detail?id=188551 Fixed in AOSP: https://android.googlesource.com/platform/frameworks/base/+/5b734f2430e9f26c769d6af8ea5645e390fcf5af%5E%21/", a.a));
            }
        };
        s = androidReferenceMatchers19;
        AndroidReferenceMatchers androidReferenceMatchers20 = new AndroidReferenceMatchers("CONNECTIVITY_MANAGER__SINSTANCE", 19) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.t

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$t$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b <= 23;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.net.ConnectivityManager", "sInstance", "ConnectivityManager has a sInstance field that is set when the first ConnectivityManager instance is created. ConnectivityManager has a mContext field. When calling activity.getSystemService(Context.CONNECTIVITY_SERVICE) , the first ConnectivityManager instance is created with the activity context and stored in sInstance. That activity context then leaks forever. Until this is fixed, app developers can prevent this leak by making sure the ConnectivityManager is first created with an App Context. E.g. in some static init do: context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) Tracked here: https://code.google.com/p/android/issues/detail?id=198852 Introduced here: https://github.com/android/platform_frameworks_base/commit/e0bef71662d81caaaa0d7214fb0bef5d39996a69", a.a));
            }
        };
        t = androidReferenceMatchers20;
        AndroidReferenceMatchers androidReferenceMatchers21 = new AndroidReferenceMatchers("ACCESSIBILITY_NODE_INFO__MORIGINALTEXT", 20) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.c

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$c$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 26 <= i && 27 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.view.accessibility.AccessibilityNodeInfo", "mOriginalText", "AccessibilityNodeInfo has a static sPool of AccessibilityNodeInfo. When AccessibilityNodeInfo instances are released back in the pool, AccessibilityNodeInfo.clear() does not clear the mOriginalText field, which causes spans to leak which in turns causes TextView.ChangeWatcher to leak and the whole view hierarchy. Introduced here: https://android.googlesource.com/platform/frameworks/base/+/193520e3dff5248ddcf8435203bf99d2ba667219%5E%21/core/java/android/view/accessibility/AccessibilityNodeInfo.java", a.a));
            }
        };
        u = androidReferenceMatchers21;
        AndroidReferenceMatchers androidReferenceMatchers22 = new AndroidReferenceMatchers("ASSIST_STRUCTURE", 21) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.j

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$j$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 24 <= i && 29 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.app.assist.AssistStructure$ViewNodeText", "mText", "AssistStructure (google assistant / autofill) holds on to text spannables on the screen. TextView.ChangeWatcher and android.widget.Editor end up in spans and typically hold on to the view hierarchy", a.a));
            }
        };
        v = androidReferenceMatchers22;
        AndroidReferenceMatchers androidReferenceMatchers23 = new AndroidReferenceMatchers("ACCESSIBILITY_ITERATORS", 22) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.a

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$a$a, reason: collision with other inner class name */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class C0348a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final C0348a a = new C0348a();

                C0348a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 27;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.widget.AccessibilityIterators$LineTextSegmentIterator", "mLayout", "AccessibilityIterators holds on to text layouts which can hold on to spans TextView.ChangeWatcher and android.widget.Editor end up in spans and typically hold on to the view hierarchy", C0348a.a));
            }
        };
        w = androidReferenceMatchers23;
        AndroidReferenceMatchers androidReferenceMatchers24 = new AndroidReferenceMatchers("BIOMETRIC_PROMPT", 23) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.o

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$o$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 28;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.hardware.biometrics.BiometricPrompt", "mFingerprintManager", "BiometricPrompt holds on to a FingerprintManager which holds on to a destroyed activity.", a.a));
            }
        };
        x = androidReferenceMatchers24;
        AndroidReferenceMatchers androidReferenceMatchers25 = new AndroidReferenceMatchers("MAGNIFIER", 24) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.al

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$al$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 28;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.widget.Magnifier$InternalPopupWindow", "mCallback", "android.widget.Magnifier.InternalPopupWindow registers a frame callback on android.view.ThreadedRenderer.SimpleRenderer which holds it as a native reference. android.widget.Editor$InsertionHandleView registers an OnOperationCompleteCallback on Magnifier.InternalPopupWindow. These references are held after the activity has been destroyed.", a.a));
            }
        };
        y = androidReferenceMatchers25;
        AndroidReferenceMatchers androidReferenceMatchers26 = new AndroidReferenceMatchers("BACKDROP_FRAME_RENDERER__MDECORVIEW", 25) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.n

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$n$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 24 <= i && 26 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("com.android.internal.policy.BackdropFrameRenderer", "mDecorView", "When BackdropFrameRenderer.releaseRenderer() is called, there's an unknown case where mRenderer becomes null but mChoreographer doesn't and the thread doesn't stop and ends up leaking mDecorView which itself holds on to a destroyed activity", a.a));
            }
        };
        z = androidReferenceMatchers26;
        AndroidReferenceMatchers androidReferenceMatchers27 = new AndroidReferenceMatchers("VIEWLOCATIONHOLDER_ROOT", 26) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bo

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bo$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 28;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.view.ViewGroup$ViewLocationHolder", "mRoot", "In Android P, ViewLocationHolder has an mRoot field that is not cleared in its clear() method. Introduced in https://github.com/aosp-mirror/platform_frameworks_base/commit/86b326012813f09d8f1de7d6d26c986a909d Bug report: https://issuetracker.google.com/issues/112792715", a.a));
            }
        };
        A = androidReferenceMatchers27;
        AndroidReferenceMatchers androidReferenceMatchers28 = new AndroidReferenceMatchers("ACCESSIBILITY_NODE_ID_MANAGER", 27) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.b

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$b$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    int i = receiver.b;
                    return 28 <= i && 29 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.view.accessibility.AccessibilityNodeIdManager", "mIdsToViews", "Android Q Beta added AccessibilityNodeIdManager which stores all views from their\nonAttachedToWindow() call, until detached. Unfortunately it's possible to trigger\nthe view framework to call detach before attach (by having a view removing itself\nfrom its parent in onAttach, which then causes AccessibilityNodeIdManager to keep\nchildren view forever. Future releases of Q will hold weak references.", a.a));
            }
        };
        B = androidReferenceMatchers28;
        AndroidReferenceMatchers androidReferenceMatchers29 = new AndroidReferenceMatchers("TEXT_TO_SPEECH", 28) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bk

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bk$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 24;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bk$b */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class b extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final b a = new b();

                b() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 24;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                List<ReferenceMatcher> list = references;
                list.add(AndroidReferenceMatchers.ao.b("android.speech.tts.TextToSpeech", "mContext", "TextToSpeech.shutdown() does not release its references to context objects. Furthermore, TextToSpeech instances cannot be garbage collected due to other process keeping the references, resulting the context objects leaked. Developers might be able to mitigate the issue by passing application context to TextToSpeech constructor. Tracked at: https://github.com/square/leakcanary/issues/1210 and https://issuetracker.google.com/issues/129250419", a.a));
                list.add(AndroidReferenceMatchers.ao.b("android.speech.tts.TtsEngines", "mContext", "TextToSpeech.shutdown() does not release its references to context objects. Furthermore, TextToSpeech instances cannot be garbage collected due to other process keeping the references, resulting the context objects leaked. Developers might be able to mitigate the issue by passing application context to TextToSpeech constructor. Tracked at: https://github.com/square/leakcanary/issues/1210 and https://issuetracker.google.com/issues/129250419", b.a));
            }
        };
        C = androidReferenceMatchers29;
        AndroidReferenceMatchers androidReferenceMatchers30 = new AndroidReferenceMatchers("CONTROLLED_INPUT_CONNECTION_WRAPPER", 29) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.u
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(v.a(AndroidReferenceMatchers.ao, "android.view.inputmethod.InputMethodManager$ControlledInputConnectionWrapper", "ControlledInputConnectionWrapper is held by a global variable in native code. ", null, 4));
            }
        };
        D = androidReferenceMatchers30;
        AndroidReferenceMatchers androidReferenceMatchers31 = new AndroidReferenceMatchers("TOAST_TN", 30) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bm
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(v.a(AndroidReferenceMatchers.ao, "android.widget.Toast$TN", "Toast.TN is held by a global variable in native code due to an IPC call to show the toast.", null, 4));
            }
        };
        E = androidReferenceMatchers31;
        AndroidReferenceMatchers androidReferenceMatchers32 = new AndroidReferenceMatchers("APPLICATION_PACKAGE_MANAGER__HAS_SYSTEM_FEATURE_QUERY", 31) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.h

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$h$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return receiver.b == 29;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.app.ApplicationPackageManager$HasSystemFeatureQuery", "this$0", "In Android 11 DP 2 ApplicationPackageManager.HasSystemFeatureQuery was an inner class.\nIntroduced in https://cs.android.com/android/_/android/platform/frameworks/base/+/89608118192580ffca026b5dacafa637a556d578\nFixed in https://cs.android.com/android/_/android/platform/frameworks/base/+/1f771846c51148b7cb6283e6dc82a216ffaa5353\nRelated blog: https://dev.to/pyricau/beware-packagemanager-leaks-223g", a.a));
            }
        };
        F = androidReferenceMatchers32;
        AndroidReferenceMatchers androidReferenceMatchers33 = new AndroidReferenceMatchers("SPEN_GESTURE_MANAGER", 32) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bg

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bg$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 19;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("com.samsung.android.smartclip.SpenGestureManager", "mContext", "SpenGestureManager has a static mContext field that leaks a reference to the activity. Yes, a STATIC mContext field.", a.a));
            }
        };
        G = androidReferenceMatchers33;
        AndroidReferenceMatchers androidReferenceMatchers34 = new AndroidReferenceMatchers("CLIPBOARD_UI_MANAGER__SINSTANCE", 33) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.s

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$s$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && 19 <= (i = receiver.b) && 21 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.sec.clipboard.ClipboardUIManager", "mContext", "ClipboardUIManager is a static singleton that leaks an activity context. Fix: trigger a call to ClipboardUIManager.getInstance() in Application.onCreate() , so that the ClipboardUIManager instance gets cached with a reference to the application context. Example: https://gist.github.com/cypressious/91c4fb1455470d803a602838dfcd5774", a.a));
            }
        };
        H = androidReferenceMatchers34;
        AndroidReferenceMatchers androidReferenceMatchers35 = new AndroidReferenceMatchers("SEM_CLIPBOARD_MANAGER__MCONTEXT", 34) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ay

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ay$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && 19 <= (i = receiver.b) && 28 >= i;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ay$b */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class b extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final b a = new b();

                b() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && 19 <= (i = receiver.b) && 28 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                List<ReferenceMatcher> list = references;
                list.add(AndroidReferenceMatchers.ao.a("com.samsung.android.content.clipboard.SemClipboardManager$1", "SemClipboardManager inner classes are held by native references due to IPC calls ", a.a));
                list.add(AndroidReferenceMatchers.ao.a("com.samsung.android.content.clipboard.SemClipboardManager$3", "SemClipboardManager inner classes are held by native references due to IPC calls ", b.a));
            }
        };
        I = androidReferenceMatchers35;
        AndroidReferenceMatchers androidReferenceMatchers36 = new AndroidReferenceMatchers("CLIPBOARD_EX_MANAGER", 35) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.r

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$r$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 23;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$r$b */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class b extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final b a = new b();

                b() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 23;
                }
            }

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$r$c */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class c extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final c a = new c();

                c() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 22;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                List<ReferenceMatcher> list = references;
                list.add(AndroidReferenceMatchers.ao.b("android.sec.clipboard.ClipboardExManager", "mContext", "android.sec.clipboard.ClipboardExManager$IClipboardDataPasteEventImpl$1 is a native callback that holds IClipboardDataPasteEventImpl which holds ClipboardExManager which has a destroyed activity as mContext", a.a));
                list.add(AndroidReferenceMatchers.ao.b("android.sec.clipboard.ClipboardExManager", "mPersonaManager", "android.sec.clipboard.ClipboardExManager$IClipboardDataPasteEventImpl$1 is a native callback that holds IClipboardDataPasteEventImpl which holds ClipboardExManager which holds PersonaManager which has a destroyed activity as mContext", b.a));
                list.add(AndroidReferenceMatchers.ao.b("android.widget.TextView$IClipboardDataPasteEventImpl", "this$0", "TextView$IClipboardDataPasteEventImpl$1 is held by a native ref, and IClipboardDataPasteEventImpl ends up leaking a detached textview", c.a));
            }
        };
        J = androidReferenceMatchers36;
        AndroidReferenceMatchers androidReferenceMatchers37 = new AndroidReferenceMatchers("SEM_EMERGENCY_MANAGER__MCONTEXT", 36) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.az

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$az$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && 19 <= (i = receiver.b) && 24 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("com.samsung.android.emergencymode.SemEmergencyManager", "mContext", "SemEmergencyManager is a static singleton that leaks a DecorContext. Fix: https://gist.github.com/jankovd/a210460b814c04d500eb12025902d60d", a.a));
            }
        };
        K = androidReferenceMatchers37;
        AndroidReferenceMatchers androidReferenceMatchers38 = new AndroidReferenceMatchers("SEM_PERSONA_MANAGER", 37) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ba

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ba$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 24;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(v.b(AndroidReferenceMatchers.ao, "com.samsung.android.knox.SemPersonaManager", "mContext", null, a.a, 4));
            }
        };
        L = androidReferenceMatchers38;
        AndroidReferenceMatchers androidReferenceMatchers39 = new AndroidReferenceMatchers("SEM_APP_ICON_SOLUTION", 38) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ax

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ax$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && 28 <= (i = receiver.b) && 29 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(v.b(AndroidReferenceMatchers.ao, "android.app.SemAppIconSolution", "mContext", null, a.a, 4));
            }
        };
        M = androidReferenceMatchers39;
        AndroidReferenceMatchers androidReferenceMatchers40 = new AndroidReferenceMatchers("AW_RESOURCE__SRESOURCES", 39) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.m

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$m$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 19;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(v.a(AndroidReferenceMatchers.ao, "com.android.org.chromium.android_webview.AwResource", "sResources", null, a.a, 4));
            }
        };
        N = androidReferenceMatchers40;
        AndroidReferenceMatchers androidReferenceMatchers41 = new AndroidReferenceMatchers("TEXT_VIEW__MLAST_HOVERED_VIEW", 40) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bl

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bl$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && 19 <= (i = receiver.b) && 29 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.widget.TextView", "mLastHoveredView", "mLastHoveredView is a static field in TextView that leaks the last hovered view.", a.a));
            }
        };
        O = androidReferenceMatchers41;
        AndroidReferenceMatchers androidReferenceMatchers42 = new AndroidReferenceMatchers("PERSONA_MANAGER", 41) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.at

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$at$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 19;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.os.PersonaManager", "mContext", "android.app.LoadedApk.mResources has a reference to android.content.res.Resources.mPersonaManager which has a reference to android.os.PersonaManager.mContext which is an activity.", a.a));
            }
        };
        P = androidReferenceMatchers42;
        AndroidReferenceMatchers androidReferenceMatchers43 = new AndroidReferenceMatchers("RESOURCES__MCONTEXT", 42) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.aw

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$aw$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 19;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.content.res.Resources", "mContext", "In AOSP the Resources class does not have a context. Here we have ZygoteInit.mResources (static field) holding on to a Resources instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issue-74450184", a.a));
            }
        };
        Q = androidReferenceMatchers43;
        AndroidReferenceMatchers androidReferenceMatchers44 = new AndroidReferenceMatchers("VIEW_CONFIGURATION__MCONTEXT", 43) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bp

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bp$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 19;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.view.ViewConfiguration", "mContext", "In AOSP the ViewConfiguration class does not have a context. Here we have ViewConfiguration.sConfigurations (static field) holding on to a ViewConfiguration instance that has a context that is the activity. Observed here: https://github.com/square/leakcanary/issues/1#issuecomment-100324683", a.a));
            }
        };
        R = androidReferenceMatchers44;
        AndroidReferenceMatchers androidReferenceMatchers45 = new AndroidReferenceMatchers("AUDIO_MANAGER__MCONTEXT_STATIC", 44) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.l

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$l$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 19;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.media.AudioManager", "mContext_static", "Samsung added a static mContext_static field to AudioManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/32", a.a));
            }
        };
        S = androidReferenceMatchers45;
        AndroidReferenceMatchers androidReferenceMatchers46 = new AndroidReferenceMatchers("ACTIVITY_MANAGER_MCONTEXT", 45) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.g

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$g$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && 22 <= (i = receiver.b) && 23 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.app.ActivityManager", "mContext", "Samsung added a static mContext field to ActivityManager, holds a reference to the activity. Observed here: https://github.com/square/leakcanary/issues/177 Fix in comment: https://github.com/square/leakcanary/issues/177#issuecomment-222724283", a.a));
            }
        };
        T = androidReferenceMatchers46;
        AndroidReferenceMatchers androidReferenceMatchers47 = new AndroidReferenceMatchers("STATIC_MTARGET_VIEW", 46) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bh

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bh$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && receiver.b == 27;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.widget.TextView", "mTargetView", "Samsung added a static mTargetView field to TextView which holds on to detached views.", a.a));
            }
        };
        U = androidReferenceMatchers47;
        AndroidReferenceMatchers androidReferenceMatchers48 = new AndroidReferenceMatchers("MULTI_WINDOW_DECOR_SUPPORT__MWINDOW", 47) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ar

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ar$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "samsung") && 26 <= (i = receiver.b) && 29 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("com.android.internal.policy.MultiWindowDecorSupport", "mWindow", "DecorView isn't leaking but its mDecorViewSupport field holds\na MultiWindowDecorSupport which has a mWindow field which holds a leaking PhoneWindow.\nDecorView.mDecorViewSupport doesn't exist in AOSP.\nFiled here: https://github.com/square/leakcanary/issues/1819", a.a));
            }
        };
        V = androidReferenceMatchers48;
        AndroidReferenceMatchers androidReferenceMatchers49 = new AndroidReferenceMatchers("GESTURE_BOOST_MANAGER", 48) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ac

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ac$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "HUAWEI") && 24 <= (i = receiver.b) && 25 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.gestureboost.GestureBoostManager", "mContext", "GestureBoostManager is a static singleton that leaks an activity context. Fix: https://github.com/square/leakcanary/issues/696#issuecomment-296420756", a.a));
            }
        };
        W = androidReferenceMatchers49;
        AndroidReferenceMatchers androidReferenceMatchers50 = new AndroidReferenceMatchers("BUBBLE_POPUP_HELPER__SHELPER", 49) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.q

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$q$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "LGE") && 19 <= (i = receiver.b) && 22 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.widget.BubblePopupHelper", "sHelper", "A static helper for EditText bubble popups leaks a reference to the latest focused view.", a.a));
            }
        };
        X = androidReferenceMatchers50;
        AndroidReferenceMatchers androidReferenceMatchers51 = new AndroidReferenceMatchers("LGCONTEXT__MCONTEXT", 50) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ak

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ak$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "LGE") && receiver.b == 21;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("com.lge.systemservice.core.LGContext", "mContext", "LGContext is a static singleton that leaks an activity context.", a.a));
            }
        };
        Y = androidReferenceMatchers51;
        AndroidReferenceMatchers androidReferenceMatchers52 = new AndroidReferenceMatchers("SMART_COVER_MANAGER", 51) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bb

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bb$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "LGE") && receiver.b == 27;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("com.lge.systemservice.core.SmartCoverManager", "mContext", "SmartCoverManager$CallbackRegister is a callback held by a native ref, and SmartCoverManager ends up leaking an activity context.", a.a));
            }
        };
        Z = androidReferenceMatchers52;
        AndroidReferenceMatchers androidReferenceMatchers53 = new AndroidReferenceMatchers("MAPPER_CLIENT", 52) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.an

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$an$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "NVIDIA") && receiver.b == 19;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("com.nvidia.ControllerMapper.MapperClient$ServiceClient", "this$0", "Not sure exactly what ControllerMapper is about, but there is an anonymous Handler in ControllerMapper.MapperClient.ServiceClient, which leaks ControllerMapper.MapperClient which leaks the activity context.", a.a));
            }
        };
        aa = androidReferenceMatchers53;
        AndroidReferenceMatchers androidReferenceMatchers54 = new AndroidReferenceMatchers("SYSTEM_SENSOR_MANAGER__MAPPCONTEXTIMPL", 53) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.bi

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$bi$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return (Intrinsics.areEqual(receiver.a, "LENOVO") && receiver.b == 19) || (Intrinsics.areEqual(receiver.a, "vivo") && receiver.b == 22);
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.hardware.SystemSensorManager", "mAppContextImpl", "SystemSensorManager stores a reference to context in a static field in its constructor. Fix: use application context to get SensorManager", a.a));
            }
        };
        ab = androidReferenceMatchers54;
        AndroidReferenceMatchers androidReferenceMatchers55 = new AndroidReferenceMatchers("INSTRUMENTATION_RECOMMEND_ACTIVITY", 54) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ae

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$ae$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "Meizu") && 21 <= (i = receiver.b) && 22 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.app.Instrumentation", "mRecommendActivity", "Instrumentation would leak com.android.internal.app.RecommendActivity (in framework.jar) in Meizu FlymeOS 4.5 and above, which is based on Android 5.0 and  above", a.a));
            }
        };
        ac = androidReferenceMatchers55;
        AndroidReferenceMatchers androidReferenceMatchers56 = new AndroidReferenceMatchers("DEVICE_POLICY_MANAGER__SETTINGS_OBSERVER", 55) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.x

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$x$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    int i;
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "motorola") && 19 <= (i = receiver.b) && 22 >= i;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.app.admin.DevicePolicyManager$SettingsObserver", "this$0", "DevicePolicyManager keeps a reference to the context it has been created with instead of extracting the application context. In this Motorola build, DevicePolicyManager has an inner SettingsObserver class that is a content observer, which is held into memory by a binder transport object.", a.a));
            }
        };
        ad = androidReferenceMatchers56;
        AndroidReferenceMatchers androidReferenceMatchers57 = new AndroidReferenceMatchers("EXTENDED_STATUS_BAR_MANAGER", 56) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.aa

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$aa$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "SHARP") && receiver.b == 29;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.app.ExtendedStatusBarManager", "sInstance", "ExtendedStatusBarManager is held in a static sInstance field and has a mContext\nfield which references a decor context which references a destroyed activity.", a.a));
            }
        };
        ae = androidReferenceMatchers57;
        AndroidReferenceMatchers androidReferenceMatchers58 = new AndroidReferenceMatchers("OEM_SCENE_CALL_BLOCKER", 57) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.as

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$as$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "OnePlus") && receiver.b == 28;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("com.oneplus.util.OemSceneCallBlocker", "sContext", "OemSceneCallBlocker has a sContext static field which holds on to an activity instance.", a.a));
            }
        };
        af = androidReferenceMatchers58;
        AndroidReferenceMatchers androidReferenceMatchers59 = new AndroidReferenceMatchers("RAZER_TEXT_KEY_LISTENER__MCONTEXT", 58) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.au

            /* JADX INFO: renamed from: com.efs.sdk.memleaksdk.monitor.internal.ak$au$a */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/efs/sdk/memleaksdk/monitor/shark/AndroidBuildMirror;", "invoke"}, k = 3, mv = {1, 4, 1})
            static final class a extends Lambda implements Function1<AndroidBuildMirror, Boolean> {
                public static final a a = new a();

                a() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                    return Boolean.valueOf(a(androidBuildMirror));
                }

                public final boolean a(AndroidBuildMirror receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    return Intrinsics.areEqual(receiver.a, "Razer") && receiver.b == 28;
                }
            }

            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.b("android.text.method.TextKeyListener", "mContext", "In AOSP, TextKeyListener instances are held in a TextKeyListener.sInstances static\narray. The Razer implementation added a mContext field, creating activity leaks.", a.a));
            }
        };
        ag = androidReferenceMatchers59;
        AndroidReferenceMatchers androidReferenceMatchers60 = new AndroidReferenceMatchers("REFERENCES", 59) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.av
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                List<ReferenceMatcher> list = references;
                v vVar = AndroidReferenceMatchers.ao;
                String name = WeakReference.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "WeakReference::class.java.name");
                list.add(vVar.a(name, "referent"));
                list.add(AndroidReferenceMatchers.ao.a("leakcanary.KeyedWeakReference", "referent"));
                v vVar2 = AndroidReferenceMatchers.ao;
                String name2 = SoftReference.class.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "SoftReference::class.java.name");
                list.add(vVar2.a(name2, "referent"));
                v vVar3 = AndroidReferenceMatchers.ao;
                String name3 = PhantomReference.class.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "PhantomReference::class.java.name");
                list.add(vVar3.a(name3, "referent"));
                list.add(AndroidReferenceMatchers.ao.a("java.lang.ref.Finalizer", "prev"));
                list.add(AndroidReferenceMatchers.ao.a("java.lang.ref.Finalizer", "element"));
                list.add(AndroidReferenceMatchers.ao.a("java.lang.ref.Finalizer", "next"));
                list.add(AndroidReferenceMatchers.ao.a("java.lang.ref.FinalizerReference", "prev"));
                list.add(AndroidReferenceMatchers.ao.a("java.lang.ref.FinalizerReference", "element"));
                list.add(AndroidReferenceMatchers.ao.a("java.lang.ref.FinalizerReference", "next"));
                list.add(AndroidReferenceMatchers.ao.a("sun.misc.Cleaner", "prev"));
                list.add(AndroidReferenceMatchers.ao.a("sun.misc.Cleaner", "next"));
            }
        };
        ah = androidReferenceMatchers60;
        AndroidReferenceMatchers androidReferenceMatchers61 = new AndroidReferenceMatchers("FINALIZER_WATCHDOG_DAEMON", 60) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ab
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("FinalizerWatchdogDaemon"));
            }
        };
        ai = androidReferenceMatchers61;
        AndroidReferenceMatchers androidReferenceMatchers62 = new AndroidReferenceMatchers("MAIN", 61) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.am
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("main"));
            }
        };
        aj = androidReferenceMatchers62;
        AndroidReferenceMatchers androidReferenceMatchers63 = new AndroidReferenceMatchers("LEAK_CANARY_THREAD", 62) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.aj
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("LeakCanary-Heap-Dump"));
            }
        };
        ak = androidReferenceMatchers63;
        AndroidReferenceMatchers androidReferenceMatchers64 = new AndroidReferenceMatchers("LEAK_CANARY_HEAP_DUMPER", 63) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ah
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("leakcanary.internal.AndroidHeapDumper", "resumedActivity"));
            }
        };
        al = androidReferenceMatchers64;
        AndroidReferenceMatchers androidReferenceMatchers65 = new AndroidReferenceMatchers("LEAK_CANARY_INTERNAL", 64) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.ai
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("leakcanary.internal.InternalLeakCanary", com.anythink.basead.exoplayer.k.o.d));
            }
        };
        am = androidReferenceMatchers65;
        AndroidReferenceMatchers androidReferenceMatchers66 = new AndroidReferenceMatchers("EVENT_RECEIVER__MMESSAGE_QUEUE", 65) { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.z
            {
                byte b3 = 0;
            }

            @Override // com.efs.sdk.memleaksdk.monitor.shark.AndroidReferenceMatchers
            public void a(List<ReferenceMatcher> references) {
                Intrinsics.checkNotNullParameter(references, "references");
                references.add(AndroidReferenceMatchers.ao.a("android.view.Choreographer$FrameDisplayEventReceiver", "mMessageQueue"));
            }
        };
        an = androidReferenceMatchers66;
        ap = new AndroidReferenceMatchers[]{androidReferenceMatchers, androidReferenceMatchers2, androidReferenceMatchers3, androidReferenceMatchers4, androidReferenceMatchers5, androidReferenceMatchers6, androidReferenceMatchers7, androidReferenceMatchers8, androidReferenceMatchers9, androidReferenceMatchers10, androidReferenceMatchers11, androidReferenceMatchers12, androidReferenceMatchers13, androidReferenceMatchers14, androidReferenceMatchers15, androidReferenceMatchers16, androidReferenceMatchers17, androidReferenceMatchers18, androidReferenceMatchers19, androidReferenceMatchers20, androidReferenceMatchers21, androidReferenceMatchers22, androidReferenceMatchers23, androidReferenceMatchers24, androidReferenceMatchers25, androidReferenceMatchers26, androidReferenceMatchers27, androidReferenceMatchers28, androidReferenceMatchers29, androidReferenceMatchers30, androidReferenceMatchers31, androidReferenceMatchers32, androidReferenceMatchers33, androidReferenceMatchers34, androidReferenceMatchers35, androidReferenceMatchers36, androidReferenceMatchers37, androidReferenceMatchers38, androidReferenceMatchers39, androidReferenceMatchers40, androidReferenceMatchers41, androidReferenceMatchers42, androidReferenceMatchers43, androidReferenceMatchers44, androidReferenceMatchers45, androidReferenceMatchers46, androidReferenceMatchers47, androidReferenceMatchers48, androidReferenceMatchers49, androidReferenceMatchers50, androidReferenceMatchers51, androidReferenceMatchers52, androidReferenceMatchers53, androidReferenceMatchers54, androidReferenceMatchers55, androidReferenceMatchers56, androidReferenceMatchers57, androidReferenceMatchers58, androidReferenceMatchers59, androidReferenceMatchers60, androidReferenceMatchers61, androidReferenceMatchers62, androidReferenceMatchers63, androidReferenceMatchers64, androidReferenceMatchers65, androidReferenceMatchers66};
        ao = new v(b2);
        aq = new Function1<AndroidBuildMirror, Boolean>() { // from class: com.efs.sdk.memleaksdk.monitor.internal.ak.w
            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Boolean invoke(AndroidBuildMirror androidBuildMirror) {
                AndroidBuildMirror receiver = androidBuildMirror;
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                return true;
            }
        };
    }
}
