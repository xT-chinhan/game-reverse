# Burgie 1.0.4 — Cách 1: Patch tĩnh libil2cpp.so rồi repack APK

Chốt với chinhan: dùng **Cách 1** để ăn gian coin/unlock (không cần Android, không cần giả lập).
Nạp tiền thật (IAP) không bẻ được — xác thực ở server MARSDK.

## Ý tưởng
Sửa vài byte trong `lib/arm64-v8a/libil2cpp.so` (và armeabi-v7a nếu cần) tại RVA đã biết, rồi đóng gói + ký lại APK.

## Mục tiêu patch (RVA trong libil2cpp.so, lấy từ dump IL2CPP)
- `UnlockableSystem.SustractCoins` @ `0x16d2bb0` → tiêu tiền không bị trừ (ret sớm / nop phần trừ).
- `UnlockableSystem.IsUnlocked` @ `0x16d31bc` → luôn trả true.
- `UnlockableSystem.HasUnlockedEverything` @ `0x16d3864` → luôn trả true.
- (tuỳ chọn) `AdRewardSystem.get_IsAdFreeUnlocked` @ `0x1642be0` → true (bỏ quảng cáo).
- (tuỳ chọn) ép `AddCoins` cộng nhiều: `AddCoins` @ `0x16d34f4`.

> Lưu ý: coin là int thường trong RAM (field offset 0x40), nên chỉ cần chặn trừ + mở khoá là đủ. Cần đọc lại assembly từng hàm trước khi sửa để nop/patch đúng.

## Quy trình thực hiện (khi làm)
1. Giải nén APK: `unzip` vào thư mục sạch (đã có `~/game/01-burgie/extract`).
2. Đọc assembly hàm cần sửa bằng REA/rizin tại RVA, xác định chỗ patch (ret true / nop branch trừ coin).
3. Sửa byte bằng rizin (`~/tools/re/rizin/bin/rizin -w`) trên cả arm64-v8a; làm armeabi-v7a nếu thiết bị đích 32-bit.
4. Repack: `apktool b` HOẶC thay thẳng file .so trong zip (`zip -0`), rồi:
   - zipalign
   - ký lại: apksigner/jarsigner (APK gốc chỉ v1). Cần tạo keystore debug.
5. Cài thử trên máy Android ARM của chinhan.

## Tài nguyên có sẵn
- Dump IL2CPP + RVA: `~/game/01-burgie/out/Assembly-CSharp.cs`, `script.json`
- Bộ giải tên pseudocode: `~/game/_tools/resolve.py` (+ `names.pkl`)
- Java jadx: `~/game/01-burgie/java/sources/`
- .so đã trích: `~/game/01-burgie/extract/lib/arm64-v8a/libil2cpp.so`
- Toolchain RE: `~/tools/re` (rizin, apktool, ghidra, kuna...), env `source ~/tools/re/rea-env.sh`

## Trạng thái
Mới CHỐT cách làm. Chưa patch. Chờ chinhan giao nhiệm vụ tiếp theo.
