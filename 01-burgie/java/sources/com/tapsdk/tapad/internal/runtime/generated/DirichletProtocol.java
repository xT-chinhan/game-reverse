package com.tapsdk.tapad.internal.runtime.generated;

/* JADX INFO: loaded from: classes3.dex */
public final class DirichletProtocol {

    public static final class AdFormat {
        public static final int BANNER = 4;
        public static final int FEED_EXPRESS = 6;
        public static final int FEED_NATIVE = 5;
        public static final int INTERSTITIAL = 2;
        public static final int REWARD = 1;
        public static final int SPLASH = 3;
        public static final int UNKNOWN = 0;

        private AdFormat() {
        }
    }

    public static final class AdapterBoundaryOpcode {
        public static final int BATCH = 1;

        private AdapterBoundaryOpcode() {
        }
    }

    public static final class AdapterCommand {
        public static final int CANCEL = 3;
        public static final int COMMIT_TERMINAL = 9;
        public static final int DESTROY = 5;
        public static final int INITIALIZE = 1;
        public static final int LOAD = 2;
        public static final int NOTIFY_LOSS = 7;
        public static final int NOTIFY_WIN = 6;
        public static final int SHOW = 4;
        public static final int TRANSFER = 8;

        private AdapterCommand() {
        }
    }

    public static final class AdapterEvent {
        public static final int CACHED = 5;
        public static final int CLICKED = 8;
        public static final int CLOSED = 10;
        public static final int INITIALIZED = 1;
        public static final int INIT_FAILED = 2;
        public static final int LOAD_FAILED = 4;
        public static final int LOAD_RESULT = 17;
        public static final int LOAD_SUCCEEDED = 3;
        public static final int REWARDED = 9;
        public static final int SHOWN = 6;
        public static final int SHOW_FAILED = 11;
        public static final int SKIPPED = 16;
        public static final int VALID_EXPOSURE = 7;
        public static final int VIDEO_COMPLETED = 14;
        public static final int VIDEO_ERROR = 15;
        public static final int VIDEO_PAUSED = 13;
        public static final int VIDEO_STARTED = 12;

        private AdapterEvent() {
        }
    }

    public static final class AdapterFailurePhase {
        public static final int CACHE = 3;
        public static final int DESTROY = 6;
        public static final int INITIALIZE = 1;
        public static final int INTERACTION = 5;
        public static final int LOAD = 2;
        public static final int SHOW = 4;
        public static final int UNKNOWN = 0;

        private AdapterFailurePhase() {
        }
    }

    public static final class AdapterMessageKind {
        public static final int COMMAND = 1;
        public static final int EVENT = 2;

        private AdapterMessageKind() {
        }
    }

    public static final class AndroidLifecycleFact {
        public static final int ACTIVITY_PRESENT = 1;
        public static final int APP_BACKGROUND = 3;
        public static final int APP_FOREGROUND = 2;
        public static final int DEEPLINK_BEGIN = 4;
        public static final int DEEPLINK_CANCEL = 6;
        public static final int DEEPLINK_CONFIRM = 5;
        public static final int LANDING_CLOSED = 8;
        public static final int LANDING_LOADED = 7;

        private AndroidLifecycleFact() {
        }
    }

    public static final class AndroidTelemetryFact {
        public static final int AD_LOAD_RESULT = 4;
        public static final int ERROR_INTERNAL = 6;
        public static final int FATAL_CRASH = 17;
        public static final int GOOGLE_EXIT_API_CALL = 26;
        public static final int MRAID_API_CALL = 23;
        public static final int MRAID_AUDIO_VOLUME_CHANGE = 25;
        public static final int MRAID_EXPOSURE_CHANGE = 24;
        public static final int MRAID_READY = 22;
        public static final int NATIVE_CRASH = 18;
        public static final int OAID_LOG = 5;
        public static final int PLUGIN_BUNDLE_DOWNLOAD_FAILED = 13;
        public static final int PLUGIN_BUNDLE_DOWNLOAD_INVALID_HASH = 14;
        public static final int PLUGIN_BUNDLE_DOWNLOAD_STARTED = 11;
        public static final int PLUGIN_BUNDLE_DOWNLOAD_SUCCEEDED = 12;
        public static final int PLUGIN_BUNDLE_INSTALL_FAILED = 16;
        public static final int PLUGIN_BUNDLE_INSTALL_SUCCEEDED = 15;
        public static final int PLUGIN_BUNDLE_UPDATE_SKIPPED = 10;
        public static final int SDK_INIT_FAILED = 3;
        public static final int SDK_INIT_START = 1;
        public static final int SDK_INIT_SUCCESS = 2;
        public static final int SHORTCUT_PIN_REQUEST = 7;
        public static final int SHORTCUT_PIN_RESULT = 8;
        public static final int WEBVIEW_ERROR = 21;
        public static final int WEBVIEW_PAGE_FINISHED = 20;
        public static final int WEBVIEW_PAGE_STARTED = 19;

        private AndroidTelemetryFact() {
        }
    }

    public static final class AssetFailureCode {
        public static final int CANCELLED = 11;
        public static final int CAPACITY = 3;
        public static final int CORRUPT = 8;
        public static final int DEADLINE = 4;
        public static final int DISK_FULL = 10;
        public static final int EXPIRED = 12;
        public static final int HTTP = 6;
        public static final int INTERNAL = 13;
        public static final int INVALID_SPEC = 1;
        public static final int NONE = 0;
        public static final int PROBE = 9;
        public static final int TOO_LARGE = 7;
        public static final int TRANSPORT = 5;
        public static final int UNSUPPORTED_KIND_OR_SCHEME = 2;

        private AssetFailureCode() {
        }
    }

    public static final class AssetKind {
        public static final int HTML = 5;
        public static final int IMAGE = 1;
        public static final int LOTTIE_JSON = 4;
        public static final int PLAYABLE_ARCHIVE = 6;
        public static final int VIDEO_FILE = 2;
        public static final int VIDEO_STREAM = 3;

        private AssetKind() {
        }
    }

    public static final class AssetReceiptState {
        public static final int CANCELLED = 4;
        public static final int FAILED = 3;
        public static final int PENDING = 1;
        public static final int READY = 2;

        private AssetReceiptState() {
        }
    }

    public static final class AssetRole {
        public static final int AD_LOGO = 4;
        public static final int COVER = 2;
        public static final int ICON = 3;
        public static final int PRIMARY = 1;
        public static final int TEMPLATE_RESOURCE = 5;

        private AssetRole() {
        }
    }

    public static final class AssetTransferOperation {
        public static final int CANCEL = 4;
        public static final int DROP_DECODED = 5;
        public static final int FETCH_AND_PROBE = 1;
        public static final int PROBE_LOCAL = 2;
        public static final int PROBE_STREAM = 3;

        private AssetTransferOperation() {
        }
    }

    public static final class AssetTransferOutcome {
        public static final int CANCELLED = 5;
        public static final int DISK_FULL = 6;
        public static final int HTTP_FAILED = 8;
        public static final int PROBE_FAILED = 4;
        public static final int READY = 1;
        public static final int REDIRECT = 2;
        public static final int TOO_LARGE = 7;
        public static final int TRANSPORT_FAILED = 3;

        private AssetTransferOutcome() {
        }
    }

    public static final class BoundaryDomain {
        public static final int ADAPTER = 3;
        public static final int FALLBACK = 5;
        public static final int HOST = 2;
        public static final int SDK = 1;
        public static final int UI = 4;

        private BoundaryDomain() {
        }
    }

    public static final class BoundaryKind {
        public static final int COMMAND = 1;
        public static final int EVENT = 2;

        private BoundaryKind() {
        }
    }

    public static final class BoundaryWire {
        public static final int ADAPTER_BATCH_PAYLOAD_SCHEMA_V1 = 1;
        public static final int DISPATCH_EVENT_FLAG_STRING_PRESENT = 1;
        public static final int DISPATCH_EVENT_MAX_INT_ARGS = 16;
        public static final int DISPATCH_EVENT_MAX_STRING_BYTES = 65536;
        public static final int DISPATCH_EVENT_PAYLOAD_FIXED_LEN = 8;
        public static final int DISPATCH_EVENT_PAYLOAD_SCHEMA_V1 = 1;
        public static final int HEADER_LEN = 32;
        public static final int HOST_COMMAND_PAYLOAD_SCHEMA_V1 = 1;
        public static final int MAGIC_U32_LE = 1313165892;
        public static final int MAX_PAYLOAD_LEN = 2097152;
        public static final int SCHEMA_VERSION = 1;
        public static final int UI_COMMAND_BATCH_PAYLOAD_SCHEMA_V1 = 1;

        private BoundaryWire() {
        }
    }

    public static final class CapabilityPlatform {
        public static final int ANDROID = 1;
        public static final int IOS = 2;
        public static final int PC = 4;
        public static final int UNKNOWN = 0;
        public static final int WEB = 3;

        private CapabilityPlatform() {
        }
    }

    public static final class CapabilityQuery {
        public static final int API_LEVEL = 19;
        public static final int ENV_QUERY = 20;
        public static final int FEATURE_BITSET_HI = 2;
        public static final int FEATURE_BITSET_LO = 1;
        public static final int HAPTIC_FEEDBACK = 10;
        public static final int INSTALL_PERMISSION = 17;
        public static final int LOTTIE = 14;
        public static final int MINI_PROGRAM = 16;
        public static final int NOTIFICATION_PERMISSION = 12;
        public static final int PLATFORM = 18;
        public static final int SHAKE = 15;
        public static final int VIBRATE_PERMISSION = 11;
        public static final int WEBVIEW = 13;

        private CapabilityQuery() {
        }
    }

    public static final class DownloadCmd {
        public static final int CANCEL = 4;
        public static final int PAUSE = 2;
        public static final int RESUME = 3;
        public static final int START = 0;
        public static final int START_ADVANCED = 1;

        private DownloadCmd() {
        }
    }

    public static final class EnvCmd {
        public static final int GET = 1;
        public static final int PREFETCH = 0;

        private EnvCmd() {
        }
    }

    public static final class EventTag {
        public static final int TAG_ACTIVITY_RESULT = 9;
        public static final int TAG_ANDROID_WEBVIEW_FACT = 23;
        public static final int TAG_ANIMATION_FRAME = 2;
        public static final int TAG_CLICK = 1;
        public static final int TAG_CONFIGURATION_CHANGED = 13;
        public static final int TAG_CREATIVE_BRIDGE = 18;
        public static final int TAG_CREATIVE_HOST_EVENT = 19;
        public static final int TAG_DESTROY = 8;
        public static final int TAG_DOWNLOAD_EVENT = 3;
        public static final int TAG_INSTALL = 22;
        public static final int TAG_INTERACTION = 16;
        public static final int TAG_MEMORY_PRESSURE = 14;
        public static final int TAG_NEW_INTENT = 10;
        public static final int TAG_OVERLAY_DISMISS = 17;
        public static final int TAG_PAUSE = 6;
        public static final int TAG_PERMISSION_RESULT = 11;
        public static final int TAG_RESUME = 7;
        public static final int TAG_SET_DOWNLOAD_FILE_PATH = 4;
        public static final int TAG_TIMER = 5;
        public static final int TAG_TOUCH = 15;
        public static final int TAG_WINDOW_FOCUS = 12;

        private EventTag() {
        }
    }

    public static final class FallbackCommandOpcode {
        public static final int EFFECT_BATCH = 1;

        private FallbackCommandOpcode() {
        }
    }

    public static final class FallbackEffectOpcode {
        public static final int ARM_WATCHDOG = 1;
        public static final int RENDER_PACKAGE_IMAGE = 2;
        public static final int TERMINAL = 3;

        private FallbackEffectOpcode() {
        }
    }

    public static final class FallbackEventOpcode {
        public static final int CLOSE_REQUESTED = 2;
        public static final int DESTROY = 5;
        public static final int RENDERER_FAILED = 3;
        public static final int START = 1;
        public static final int WATCHDOG = 4;

        private FallbackEventOpcode() {
        }
    }

    public static final class FallbackPresentationState {
        public static final int IDLE = 0;
        public static final int PRESENTING = 1;
        public static final int TERMINAL = 2;

        private FallbackPresentationState() {
        }
    }

    public static final class FallbackTerminalReason {
        public static final int ASSET_UNAVAILABLE = 4;
        public static final int CLOSED = 1;
        public static final int DESTROYED = 6;
        public static final int INVALID_SPEC = 3;
        public static final int RENDERER_FAILED = 5;
        public static final int WATCHDOG = 2;

        private FallbackTerminalReason() {
        }
    }

    public static final class FallbackWire {
        public static final int EFFECT_BATCH_HEADER_LEN = 16;
        public static final int EFFECT_BATCH_MAGIC_U32_LE = 1481003588;
        public static final int EFFECT_BATCH_PAYLOAD_SCHEMA_V1 = 1;
        public static final int EFFECT_BATCH_VERSION_V1 = 1;
        public static final int EFFECT_FRAME_HEADER_LEN = 8;
        public static final int EVENT_PAYLOAD_SCHEMA_V1 = 1;
        public static final int MAX_EFFECT_COUNT = 2;
        public static final int MAX_EFFECT_PAYLOAD_BYTES = 64;

        private FallbackWire() {
        }
    }

    public static final class FileCmd {
        public static final int EXISTS = 0;
        public static final int IS_DIR = 2;
        public static final int IS_FILE = 1;
        public static final int LENGTH = 3;

        private FileCmd() {
        }
    }

    public static final class HapticCmd {
        public static final int FEEDBACK = 0;
        public static final int VIBRATE = 1;
        public static final int VIBRATE_CANCEL = 2;

        private HapticCmd() {
        }
    }

    public static final class HostCommandOpcode {
        public static final int ASSET_ACQUIRE = 26;
        public static final int ASSET_METADATA = 30;
        public static final int ASSET_READ = 31;
        public static final int ASSET_RECEIPT = 27;
        public static final int ASSET_RELEASE = 28;
        public static final int CALLBACK_NATIVE = 16;
        public static final int CAPABILITY = 13;
        public static final int DOWNLOAD = 9;
        public static final int ENV_GET = 15;
        public static final int ENV_PREFETCH = 14;
        public static final int FILE = 10;
        public static final int HAPTIC = 22;
        public static final int HTTP_CANCEL = 25;
        public static final int HTTP_REQUEST = 7;
        public static final int INSTALL = 29;
        public static final int NAVIGATE = 8;
        public static final int OVERLAY = 23;
        public static final int SHAKE = 21;
        public static final int STORAGE_EXEC = 11;
        public static final int STORAGE_GET = 12;
        public static final int SURFACE_ATTACH = 18;
        public static final int SURFACE_CREATE = 17;
        public static final int SURFACE_DESTROY = 20;
        public static final int SURFACE_UPDATE = 19;
        public static final int TRACK = 24;
        public static final int VIDEO_ATTACH = 4;
        public static final int VIDEO_CONTROL = 2;
        public static final int VIDEO_CREATE = 1;
        public static final int VIDEO_DESTROY = 5;
        public static final int VIDEO_ON_EVENT = 3;
        public static final int VIDEO_QUERY = 6;

        private HostCommandOpcode() {
        }
    }

    public static final class HostFeature {
        public static final int CAPABILITY_QUERY = 1;
        public static final int DOWNLOAD = 1024;
        public static final int DOWNLOAD_EXECUTION_PLAN = 32768;
        public static final int DOWNLOAD_MULTI_URL = 16384;
        public static final int ENV_QUERY = 4096;
        public static final int HAPTIC = 32;
        public static final int INTERACTION_SESSION = 16;
        public static final int LIFECYCLE_EVENTS = 8;
        public static final int LOTTIE = 128;
        public static final int MINI_PROGRAM = 2048;
        public static final int OVERLAY = 4;
        public static final int RAW_TOUCH = 2;
        public static final int SHAKE = 64;
        public static final int SURFACE_SESSION = 512;
        public static final int WEBVIEW = 256;

        private HostFeature() {
        }
    }

    public static final class HttpMethod {
        public static final int GET = 0;
        public static final int POST = 1;

        private HttpMethod() {
        }
    }

    public static final class HttpTransport {
        public static final int CANCELLED = 5;
        public static final int DNS = 3;
        public static final int INVALID_REQUEST = 6;
        public static final int NETWORK = 1;
        public static final int RESPONSE = 0;
        public static final int TIMEOUT = 2;
        public static final int TLS = 4;

        private HttpTransport() {
        }
    }

    public static final class InstallCmd {
        public static final int IS_PACKAGE_INSTALLED = 4;
        public static final int REQUEST_APK_INSTALL = 1;
        public static final int UNWATCH_PACKAGE = 3;
        public static final int WATCH_PACKAGE = 2;

        private InstallCmd() {
        }
    }

    public static final class InstallEvent {
        public static final int DOWNLOAD_VERIFIED = 5;
        public static final int HOST_FILE_READY = 4;
        public static final int INSTALLER_FAILED = 2;
        public static final int INSTALLER_LAUNCHED = 1;
        public static final int PACKAGE_CHANGED = 3;

        private InstallEvent() {
        }
    }

    public static final class InstallFailure {
        public static final int CONTAINER_START_FAILED = 7;
        public static final int FILE_NOT_FOUND = 2;
        public static final int INSTALLER_START_FAILED = 6;
        public static final int INSTALLER_UNRESOLVED = 5;
        public static final int INVALID_REQUEST = 1;
        public static final int PERMISSION_NOT_DECLARED = 4;
        public static final int URI_UNAVAILABLE = 3;

        private InstallFailure() {
        }
    }

    public static final class InteractionEvent {
        public static final int BROWSER_DOWNLOAD = 7;
        public static final int BROWSER_NAVIGATION = 6;
        public static final int CANCELED = 5;
        public static final int COMPLETED = 4;
        public static final int FAILED = 1;
        public static final int FALLBACK = 3;
        public static final int FOREGROUNDED = 2;
        public static final int OPENED = 0;

        private InteractionEvent() {
        }
    }

    public static final class InteractionOpenMode {
        public static final int EXTERNAL = 1;
        public static final int LIGHT = 3;
        public static final int MODAL = 2;
        public static final int UNKNOWN = 0;

        private InteractionOpenMode() {
        }
    }

    public static final class LogLevel {
        public static final int DEBUG = 1;
        public static final int ERROR = 4;
        public static final int INFO = 2;
        public static final int VERBOSE = 0;
        public static final int WARN = 3;

        private LogLevel() {
        }
    }

    public static final class MediationLifecycleFact {
        public static final int ADS_LOAD_AUTO_SHOW = 1;
        public static final int ADS_LOAD_REJECT = 64;
        public static final int ADS_ON_LOAD_FAIL = 2;
        public static final int ADS_ON_LOAD_SUCCESS = 3;
        public static final int ADS_PRELOAD = 4;
        public static final int AD_CODEBIT_BUILD_FAIL = 5;
        public static final int AD_CODEBIT_BUILD_SUCCESS = 6;
        public static final int AD_CODEBIT_GET_VIEW = 7;
        public static final int AD_CODEBIT_LOAD_TIMEOUT = 8;
        public static final int AD_CODEBIT_LOSS = 9;
        public static final int AD_CODEBIT_REQUEST_FAIL = 10;
        public static final int AD_CODEBIT_REQUEST_START = 11;
        public static final int AD_CODEBIT_REQUEST_SUCCESS = 12;
        public static final int AD_CODEBIT_SHOW = 13;
        public static final int AD_CODEBIT_WIN = 14;
        public static final int AD_DESTROY = 15;
        public static final int AD_INVALID_SHOW = 76;
        public static final int AD_LOAD = 16;
        public static final int AD_MEDIA_BUILD_FAIL = 79;
        public static final int AD_MEDIA_BUILD_SUCCESS = 78;
        public static final int AD_MEDIA_REFLECTION_FAIL = 63;
        public static final int AD_MEDIA_REFLECTION_SUCCESS = 17;
        public static final int AD_NETWORK_CONFIG_SKIPPED = 18;
        public static final int AD_NETWORK_SDK_INIT = 19;
        public static final int AD_NETWORK_SDK_INIT_FAIL = 20;
        public static final int AD_NETWORK_SDK_INIT_SUCCESS = 21;
        public static final int AD_SPACE_GET_VIEW = 22;
        public static final int AD_SPACE_SHOW = 23;
        public static final int AD_WIN_LOSS_TRANSMISSION = 24;
        public static final int APP_INTO_BACKGROUND = 25;
        public static final int APP_INTO_BEFORE = 26;
        public static final int BIDDING_LUA_AD_ITEM_FAIL = 75;
        public static final int BIDDING_LUA_FAIL = 74;
        public static final int BIDDING_LUA_SUCCESS = 73;
        public static final int CACHE_AD_INVALID = 27;
        public static final int CLIENT_REWARD_VERIFY = 28;
        public static final int DOWNLOAD_ON_CANCEL = 29;
        public static final int DOWNLOAD_ON_CONFIRM = 30;
        public static final int DOWNLOAD_WINDOW_CONFIRM = 31;
        public static final int LUA_BIDDING_COMPLETE = 66;
        public static final int LUA_BIDDING_START = 65;
        public static final int MEDIA_LOSS = 32;
        public static final int MEDIA_WIN = 33;
        public static final int NATIVE_SPLASH_AUTO_CLOSE = 34;
        public static final int NATIVE_SPLASH_COUNTDOWN_START = 35;
        public static final int NATIVE_SPLASH_RENDER_START = 36;
        public static final int NATIVE_SPLASH_SKIP_CLICK = 37;
        public static final int NATIVE_SPLASH_SKIP_SHOW = 38;
        public static final int ON_CLICK = 39;
        public static final int ON_CLOSE = 40;
        public static final int ON_DOWNLOAD_ERROR = 41;
        public static final int ON_DOWNLOAD_FINISHED = 42;
        public static final int ON_DOWNLOAD_PAUSE = 43;
        public static final int ON_DOWNLOAD_START = 44;
        public static final int ON_INSTALLED = 45;
        public static final int ON_ITEM_CLICK = 46;
        public static final int ON_ITEM_ELSE_CLICK = 47;
        public static final int ON_ITEM_SHOW = 48;
        public static final int ON_RENDER_ERROR = 49;
        public static final int ON_RENDER_SUCCESS = 50;
        public static final int ON_SHOW = 51;
        public static final int ON_SHOW_SCREENSHOT = 52;
        public static final int ON_SKIPPED = 53;
        public static final int ON_VIDEO_COMPLETE = 54;
        public static final int ON_VIDEO_ERROR = 55;
        public static final int ON_VIDEO_PAUSE = 56;
        public static final int ON_VIDEO_PREPARED = 57;
        public static final int ON_VIDEO_RESUME = 58;
        public static final int ON_VIDEO_START = 59;
        public static final int PERMISSION_REQUEST = 77;
        public static final int REVEAL_COMPLETE = 72;
        public static final int REVEAL_START = 71;
        public static final int RTB_COMPLETE = 70;
        public static final int RTB_START = 69;
        public static final int SDK_INIT = 60;
        public static final int SELF_NATIVE_CLICK = 61;
        public static final int THREAD_POOL_EXCEPTION = 62;
        public static final int WATERFALL_COMPLETE = 68;
        public static final int WATERFALL_START = 67;

        private MediationLifecycleFact() {
        }
    }

    public static final class NavigateCmd {
        public static final int GET_FEATURE_FLAG_I32 = 8;
        public static final int IS_INSTALLED = 5;
        public static final int OPEN_AD_INTERACTION = 6;
        public static final int OPEN_APP = 4;
        public static final int OPEN_APP_STORE = 1;
        public static final int OPEN_DEEP_LINK = 2;
        public static final int OPEN_MINI_PROGRAM = 9;
        public static final int OPEN_URL = 0;
        public static final int PIN_SHORTCUT = 10;
        public static final int SHOW_TOAST = 7;

        private NavigateCmd() {
        }
    }

    public static final class Opcode {
        public static final int CALLBACK_NATIVE = 70;
        public static final int CAPABILITY = 76;
        public static final int CREATIVE_HOST = 79;
        public static final int DOWNLOAD = 60;
        public static final int ENV = 78;
        public static final int FILE = 74;
        public static final int HTTP_REQUEST = 30;
        public static final int LOG = 73;
        public static final int NAVIGATE = 50;
        public static final int OVERLAY = 77;
        public static final int POPUP = 72;
        public static final int SHAKE = 71;
        public static final int STORAGE = 75;
        public static final int TIMER_CANCEL = 41;
        public static final int TIMER_SET = 40;
        public static final int VIDEO_ATTACH = 23;
        public static final int VIDEO_CONTROL = 21;
        public static final int VIDEO_CREATE = 20;
        public static final int VIDEO_DESTROY = 24;
        public static final int VIDEO_ON_EVENT = 22;
        public static final int VIEW_ADD_CHILD = 9;
        public static final int VIEW_CLICK = 8;
        public static final int VIEW_CREATE = 1;
        public static final int VIEW_DESTROY = 12;
        public static final int VIEW_HIDE = 13;
        public static final int VIEW_IMAGE = 7;
        public static final int VIEW_LAYOUT = 2;
        public static final int VIEW_PADDING = 11;
        public static final int VIEW_SET_PROP = 14;
        public static final int VIEW_SHOW = 10;
        public static final int VIEW_STYLE_BOOL = 5;
        public static final int VIEW_STYLE_F32 = 4;
        public static final int VIEW_STYLE_STR = 3;
        public static final int VIEW_TEXT = 6;
        public static final int VIEW_TOUCH = 15;

        private Opcode() {
        }
    }

    public static final class OverlayCmd {
        public static final int CREATE = 0;
        public static final int DESTROY = 4;
        public static final int DISMISS = 3;
        public static final int SHOW = 1;
        public static final int UPDATE = 2;

        private OverlayCmd() {
        }
    }

    public static final class OverlayDismissReason {
        public static final int BACK = 1;
        public static final int DESTROY = 4;
        public static final int LIFECYCLE = 3;
        public static final int OUTSIDE = 2;
        public static final int PROGRAMMATIC = 0;

        private OverlayDismissReason() {
        }
    }

    public static final class PopupCmd {
        public static final int DISMISS = 1;
        public static final int SHOW = 0;

        private PopupCmd() {
        }
    }

    public static final class SdkCallbackEvent {
        public static final int AD_CHANGED = 30;
        public static final int AD_CHANGE_FAILED = 31;
        public static final int CACHED = 3;
        public static final int CANCELLED = 34;
        public static final int CLICKED = 6;
        public static final int CLOSED = 7;
        public static final int CREATIVE_CLICKED = 28;
        public static final int DISTINCT_SHOWN = 35;
        public static final int DOWNLOAD_CANCELLED = 36;
        public static final int DOWNLOAD_COMPLETED = 23;
        public static final int DOWNLOAD_CONFIRMED = 37;
        public static final int DOWNLOAD_FAILED = 24;
        public static final int DOWNLOAD_IDLE = 40;
        public static final int DOWNLOAD_PAUSED = 22;
        public static final int DOWNLOAD_PROGRESS = 21;
        public static final int DOWNLOAD_STARTED = 20;
        public static final int INIT_FAILED = 33;
        public static final int INIT_SUCCEEDED = 32;
        public static final int INSTALLED = 25;
        public static final int INVALID_EXPOSURE = 29;
        public static final int ITEM_CLICKED = 27;
        public static final int ITEM_SHOWN = 26;
        public static final int LOAD_FAILED = 2;
        public static final int LOAD_SUCCEEDED = 1;
        public static final int RENDER_FAILED = 12;
        public static final int RENDER_SUCCEEDED = 11;
        public static final int REWARDED = 9;
        public static final int SHOWN = 4;
        public static final int SHOW_FAILED = 8;
        public static final int SKIPPED = 10;
        public static final int TIME_OVER = 19;
        public static final int VALID_EXPOSURE = 5;
        public static final int VIDEO_CACHED = 13;
        public static final int VIDEO_COMPLETED = 17;
        public static final int VIDEO_FAILED = 18;
        public static final int VIDEO_PAUSED = 15;
        public static final int VIDEO_PREPARED = 41;
        public static final int VIDEO_RESUMED = 16;
        public static final int VIDEO_STARTED = 14;
        public static final int VIDEO_VOLUME_CLOSED = 39;
        public static final int VIDEO_VOLUME_OPENED = 38;

        private SdkCallbackEvent() {
        }
    }

    public static final class ShakeCmd {
        public static final int CONFIG = 0;
        public static final int IS_ACTIVE = 4;
        public static final int RESET = 3;
        public static final int START = 1;
        public static final int STOP = 2;

        private ShakeCmd() {
        }
    }

    public static final class ShowAdmissionResult {
        public static final int ADMITTED = 1;
        public static final int REJECT_ALREADY_CLAIMED = -9354;
        public static final int REJECT_BACKGROUND = -9357;
        public static final int REJECT_EXPIRED = -9352;
        public static final int REJECT_FORMAT_MISMATCH = -9359;
        public static final int REJECT_INVALID_CLOCK = -9358;
        public static final int REJECT_INVALID_HOST_FACTS = -9360;
        public static final int REJECT_NOT_PRESENTABLE = -9356;
        public static final int REJECT_NOT_READY = -9351;
        public static final int REJECT_OWNER_DESTROYED = -9355;
        public static final int REJECT_UNSUPPORTED_MATERIAL = -9353;

        private ShowAdmissionResult() {
        }
    }

    public static final class ShowHostFact {
        public static final int APP_FOREGROUND = 4;
        public static final int MASK = 7;
        public static final int OWNER_ALIVE = 1;
        public static final int PRESENTABLE = 2;

        private ShowHostFact() {
        }
    }

    public static final class StorageCmd {
        public static final int CLEAR_NAMESPACE = 4;
        public static final int CONTAINS = 0;
        public static final int GET_STRING = 1;
        public static final int REMOVE = 3;
        public static final int SET_STRING = 2;

        private StorageCmd() {
        }
    }

    public static final class TouchAction {
        public static final int CANCEL = 3;
        public static final int DOWN = 0;
        public static final int MOVE = 1;
        public static final int UP = 2;

        private TouchAction() {
        }
    }

    public static final class TouchMode {
        public static final int CONSUMING = 1;
        public static final int PASSIVE = 0;

        private TouchMode() {
        }
    }

    public static final class TraceCallbackFact {
        public static final int KNOWN_MASK = 3;
        public static final int SUCCESS = 1;
        public static final int VERIFIED = 2;

        private TraceCallbackFact() {
        }
    }

    public static final class TraceCallbackThread {
        public static final int BACKGROUND = 2;
        public static final int MAIN = 1;
        public static final int UNKNOWN = 0;

        private TraceCallbackThread() {
        }
    }

    public static final class TraceDomain {
        public static final int ADAPTER = 3;
        public static final int FALLBACK = 5;
        public static final int HOST = 2;
        public static final int SDK = 1;
        public static final int UI = 4;

        private TraceDomain() {
        }
    }

    public static final class TraceExecutionFact {
        public static final int RANDOM_DRAW = 1;

        private TraceExecutionFact() {
        }
    }

    public static final class TraceFakeCapability {
        public static final int ADAPTER = 5;
        public static final int HTTP = 1;
        public static final int MEDIA = 3;
        public static final int STORAGE = 2;
        public static final int VIEW = 4;

        private TraceFakeCapability() {
        }
    }

    public static final class TraceFakeObservation {
        public static final int DUPLICATE_DROPPED = 1;
        public static final int KNOWN_MASK = 7;
        public static final int LATE_DROPPED = 4;
        public static final int OUT_OF_ORDER = 2;

        private TraceFakeObservation() {
        }
    }

    public static final class TraceFakeTerminal {
        public static final int CANCELLED = 5;
        public static final int FAILURE = 2;
        public static final int SUCCESS = 1;
        public static final int TIMED_OUT = 4;
        public static final int TRAPPED = 3;

        private TraceFakeTerminal() {
        }
    }

    public static final class TraceFaultCode {
        public static final int CANCEL = 6;
        public static final int CAPACITY_EXCEEDED = 3;
        public static final int DUPLICATE_CALLBACK = 7;
        public static final int LATE_CALLBACK = 1;
        public static final int OUT_OF_ORDER_CALLBACK = 2;
        public static final int TIMEOUT = 5;
        public static final int TRAP = 4;

        private TraceFaultCode() {
        }
    }

    public static final class TraceKind {
        public static final int COMMAND = 1;
        public static final int EVENT = 2;
        public static final int FAULT = 3;

        private TraceKind() {
        }
    }

    public static final class TraceLifecycle {
        public static final int ATTEMPT_CLOSE = 4;
        public static final int ATTEMPT_OPEN = 3;
        public static final int FACT = 0;
        public static final int FAULT_APPLIED = 9;
        public static final int REQUEST_CLOSE = 2;
        public static final int REQUEST_OPEN = 1;
        public static final int SURFACE_CLOSE = 6;
        public static final int SURFACE_OPEN = 5;
        public static final int TIMER_FIRED = 8;
        public static final int TIMER_SCHEDULED = 7;

        private TraceLifecycle() {
        }
    }

    public static final class TracePayloadMode {
        public static final int NONE = 0;
        public static final int REDACTED_HMAC_SHA256 = 2;
        public static final int REPLAY_SAFE = 1;

        private TracePayloadMode() {
        }
    }

    public static final class TracePayloadSchema {
        public static final int BOOL_V1 = 1;
        public static final int FAKE_CAPABILITY_V1 = 10;
        public static final int FAULT_INJECTION_V1 = 9;
        public static final int FAULT_V1 = 6;
        public static final int I64_V1 = 3;
        public static final int NONE = 0;
        public static final int RANDOM_V1 = 8;
        public static final int REDACTED_HMAC_SHA256_V1 = 255;
        public static final int SDK_CALLBACK_V1 = 7;
        public static final int STATUS_V1 = 4;
        public static final int TIMER_V1 = 5;
        public static final int U64_V1 = 2;

        private TracePayloadSchema() {
        }
    }

    public static final class TraceProductMode {
        public static final int ADN = 1;
        public static final int MEDIATION = 2;

        private TraceProductMode() {
        }
    }

    public static final class TrackProvider {
        public static final int STANDARD = 0;

        private TrackProvider() {
        }
    }

    public static final class UiBoundaryOpcode {
        public static final int EXECUTE_BATCH = 1;

        private UiBoundaryOpcode() {
        }
    }

    public static final class VideoCmd {
        public static final int PAUSE = 1;
        public static final int PLAY = 0;
        public static final int SEEK = 3;
        public static final int SET_LOOP = 6;
        public static final int SET_MUTED = 5;
        public static final int SET_VOLUME = 4;
        public static final int STOP = 2;

        private VideoCmd() {
        }
    }

    public static final class VideoEvent {
        public static final int COMPLETE = 1;
        public static final int ERROR = 2;
        public static final int FIRST_FRAME = 4;
        public static final int PROGRESS = 0;
        public static final int READY = 3;
        public static final int SIZE_CHANGED = 5;

        private VideoEvent() {
        }
    }

    public static final class VideoQueryProp {
        public static final int DURATION = 0;
        public static final int HEIGHT = 3;
        public static final int POSITION = 1;
        public static final int WIDTH = 2;

        private VideoQueryProp() {
        }
    }

    public static final class VideoViewType {
        public static final int SURFACE = 0;
        public static final int TEXTURE = 1;

        private VideoViewType() {
        }
    }

    public static final class ViewQueryProp {
        public static final int AD_AREA_PERCENT = 4;
        public static final int COUNT = 7;
        public static final int HEIGHT_PX = 1;
        public static final int IS_SHOWN = 6;
        public static final int SCREEN_AREA_PERCENT = 5;
        public static final int VISIBLE_HEIGHT_PX = 3;
        public static final int VISIBLE_WIDTH_PX = 2;
        public static final int WIDTH_PX = 0;

        private ViewQueryProp() {
        }
    }

    public static final class ViewType {
        public static final int CANVAS = 6;
        public static final int CONTAINER = 0;
        public static final int IMAGE = 2;
        public static final int LINEAR = 103;
        public static final int LOTTIE = 5;
        public static final int TEXT = 1;
        public static final int VIDEO = 3;
        public static final int WEB_CREATIVE = 106;
        public static final int WEB_VIEW = 105;

        private ViewType() {
        }
    }

    private DirichletProtocol() {
    }
}
