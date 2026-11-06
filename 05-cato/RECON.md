# 05 — CATO (黄油猫 / Butter Cat)  `com.teamwoll.cato.taptap` v1.3

## Engine
**Unity IL2CPP**, metadata **v31 KHÔNG mã hoá**. arm64-v8a (103MB libil2cpp.so). 2D platformer.
- Frameworks: **MoreMountains Corgi Engine** (2D platformer), Rewired (input), UniTask, Cinemachine, Dreamteck Splines, Deform, Shapes, **Wwise** audio (libAkSoundEngine), **Easy Save 3 (ES3)** cho save, Addressables (assets/aa).
- Thanh toán đa vùng: alipay, stripe, braintree, Google Play, TapTap → bản build quốc tế. Đây là **bản dùng thử miễn phí**, mở full = IAP (`CatoFullGameUnlockPriceConfig`, `UnlockFullVersionPrompt`, `EntitlementChecking…`).

## Dump (REA inspect_il2cpp_metadata)
- 147 assembly, 19.127 type, **148.967 method** (131.808 có RVA), 20.790 string literal.
- `evidence.json` (139MB). `out/`: `dump.cs`, `Assembly-CSharp.cs`, `script.json` (nạp IDA/Ghidra), `strings.txt`.
- Resolver cache `evidence.names.pkl` đã dựng → annotate pseudocode qua `../_tools/resolve.py`.
- Java (jadx): `java/sources/` (682 class SDK: taptap, stripe, braintree, google play, lofelt haptics).

## ⭐ Việt hóa — THUẬN LỢI
Game **đã hỗ trợ sẵn tiếng Việt**: trong string literals có `'Vietnamese'`, `'vi'` cùng en/zh-Hans/zh-Hant/ja/ko.
- Hệ localization riêng: **`CatoLocalizedCopy.Terms`** — struct chứa các khoá chữ (`DialogClose`, `PurchaseFailed`, `EntitlementCheckingTitle`…).
- Chữ dịch nhiều khả năng nằm trong **Addressables bundle** (`assets/aa/Android/*.bundle`) hoặc string table; cần mở bundle bằng AssetStudio/UnityPy để lấy bảng `vi`.
- **Font:** 6 file `res/*.otf` (55/AR/G6/TC/nK/ub) — vì game đã có tiếng Việt nên gần như chắc một trong số đó phủ dấu Việt. Chỉ cần dịch nội dung, không cần thay font.
- Hướng Việt hóa: bổ sung/sửa bảng `vi` trong Addressables, hoặc sửa text trực tiếp. Dễ nhất trong 5 game.

## Sửa nội dung game (coin/unlock…)
- Save = **ES3 / Easy Save 3** (`AutoSave.es3`) — có thể mã hoá AES; `CatoPlayerProgressSaveProvider` quản lý. Sửa save offline được nếu biết/không có mật khẩu ES3 (cần đọc `ES3Settings` trong code).
- Mở full game = **IAP server-side** (entitlement check) → không bẻ bằng sửa client; bản thử giới hạn màn.
- Logic game trong `Assembly-CSharp.dll` + `Woll.LD.Runtime` + `BlasinRunTime` → decompile hàm cụ thể bằng Kuna/Ghidra tại RVA trong `out/script.json`.

## Trạng thái
Reverse xong, đủ dữ liệu Việt hóa. Chưa sửa gì.
