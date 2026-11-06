#!/usr/bin/env python3
"""Vá chữ Trung hiển thị trong scene/prefab + thay font Fusion Pixel, cho bản CATO hiện tại.

  scene_vi.py <src_root> <out_dir> <font.ttf>

<src_root>: thư mục giải nén APK hiện tại, có m/ (file base Data đã ghép split) và assets/aa/Android/.
Ghi file đã sửa vào <out_dir>/<đường dẫn trong zip> (file base Data bị split thì ghi lại dạng split 1MB).
Chuỗi vá theo khớp TUYỆT ĐỐI cả chuỗi (int32 length + utf-8 + pad 4) trong MonoBehaviour.
"""
import os, struct, sys, zipfile
import UnityPy

VI = {
    '每次开关后会重置计时器': 'Mỗi lần bật/tắt sẽ đặt lại đồng hồ',
    '重置角色': 'Đặt lại nhân vật',
    '手柄震动': 'Rung tay cầm',
    '控制器震动': 'Rung tay cầm',
    '在游戏内可以开关减速按钮来降低游戏难度\n键盘：Left Shift，手柄：R3':
        'Bật nút quay chậm trong game để giảm độ khó\nBàn phím: Left Shift, tay cầm: R3',
    '干净的界面': 'Giao diện gọn',
    '世界1-关卡24': 'Vùng 1 - Màn 24',
    '跳关 (1min)': 'Bỏ qua màn (1 phút)',
    '体验时长已结束，感谢试玩！\n\n[按回车继续游戏]': 'Đã hết thời gian chơi thử, cảm ơn bạn!\n\n[Nhấn Enter để tiếp tục]',
    '返回基地': 'Về căn cứ',
    '= 退出     = 进入': '= Thoát     = Vào',
    '跳：space\n分离：z': 'Nhảy: space\nTách: z',
    '恭喜解锁新成就': 'Mở khóa thành tựu mới!',
    '您已解锁！': 'Bạn đã mở khóa!',
    '提交成功': 'Gửi thành công',
    '解锁完整版！': 'Mở khóa bản đầy đủ!',
    'CATO 向左': 'CATO sang trái',
    'CATO 向右': 'CATO sang phải',
    '单人键盘（方向键）+ 手柄': 'Bàn phím 1 người (phím mũi tên) + tay cầm',
    '小米蓝牙手柄': 'Tay cầm Bluetooth Xiaomi',
    '游戏健康提醒': 'Nhắc nhở chơi game lành mạnh',
    '健康游戏提醒': 'Nhắc nhở chơi game lành mạnh',
    '返回游戏': 'Quay lại game',
    '进入游戏': 'Vào game',
    '切换账号': 'Đổi tài khoản',
    '我知道了': 'Đã hiểu',
    '游戏启动异常提示': 'Lỗi khởi động game',
    '发生未知错误，请从 TapTap 客户端重新启动游戏': 'Có lỗi không xác định, vui lòng mở lại game.',
    '我还没有安装TapTap，点击前往下载安装': 'Chưa cài TapTap? Nhấn để tải về',
}
ENC = {k.encode(): v.encode() for k, v in VI.items()}


def pstr(b):
    return struct.pack('<i', len(b)) + b + b'\0' * ((-len(b)) % 4)


def patch_raw(raw):
    out = bytearray(); i = 0; n = len(raw); hits = 0
    while i < n:
        if i + 4 <= n and i % 4 == 0:
            L = struct.unpack_from('<i', raw, i)[0]
            if 2 <= L <= 4000 and i + 4 + L <= n:
                seg = bytes(raw[i + 4:i + 4 + L])
                if seg in ENC:
                    out += pstr(ENC[seg]); i += 4 + L + ((-L) % 4); hits += 1
                    continue
        out.append(raw[i]); i += 1
    return bytes(out), hits


def process(path, font_bytes):
    env = UnityPy.load(path)
    total = 0; font = 0
    for o in env.objects:
        t = o.type.name
        if t == 'MonoBehaviour':
            raw = o.get_raw_data()
            if not any(k in raw for k in ENC):
                continue
            new, h = patch_raw(raw)
            if h:
                o.set_raw_data(new); total += h
        elif t == 'Font':
            d = o.read()
            if d.m_Name == 'Fusion Pixel':
                d.m_FontData = font_bytes; d.save(); font += 1
    return env, total, font


def main(root, outdir, fontpath):
    font_bytes = open(fontpath, 'rb').read()
    apk = zipfile.ZipFile(os.path.expanduser('~/game/05-cato/original.apk'))
    names = set(apk.namelist())
    jobs = []
    aa = os.path.join(root, 'assets/aa/Android')
    for dp, _, fs in sorted(os.walk(aa)):
        for f in sorted(fs):
            full = os.path.join(dp, f)
            jobs.append((full, 'assets/aa/Android/' + os.path.relpath(full, aa), True))
    for f in sorted(os.listdir(os.path.join(root, 'm'))):
        jobs.append((os.path.join(root, 'm', f), f'assets/bin/Data/{f}', False))
    for src, zpath, is_bundle in jobs:
        raw = open(src, 'rb').read()
        if not any(k in raw for k in ENC) and b'Fusion Pixel' not in raw and not is_bundle:
            continue
        if is_bundle and 'unitybuiltinshaders' in src:
            continue
        try:
            env, h, fnt = process(src, font_bytes)
        except Exception as e:
            print('skip', zpath, e); continue
        if not h and not fnt:
            continue
        f = list(env.files.values())[0]
        data = f.save(packer='lz4') if is_bundle else f.save()
        if zpath in names:
            dst = os.path.join(outdir, zpath); os.makedirs(os.path.dirname(dst), exist_ok=True)
            open(dst, 'wb').write(data)
        else:  # base Data file shipped as .splitN
            old = [n for n in names if n.startswith(zpath + '.split')]
            assert old, zpath
            for k in range(0, (len(data) + 1048575) // 1048576):
                dst = os.path.join(outdir, f'{zpath}.split{k}'); os.makedirs(os.path.dirname(dst), exist_ok=True)
                open(dst, 'wb').write(data[k * 1048576:(k + 1) * 1048576])
        print(f'{zpath}: {h} chuỗi, {fnt} font', flush=True)


if __name__ == '__main__':
    main(*sys.argv[1:4])
