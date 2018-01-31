import os
import subprocess, signal


def useCMD():
    """
    当前进程调用cmd命令，属于阻塞式
    :return:
    """
    print('一般os.system运行后不返回值')
    print(os.system("ipconfig"))

    print('使用os.open可以获取返回值')
    b = os.popen('ipconfig')
    print(b.read())


def my_subprocess():
    print('产生子进程运行命令，属于阻塞式')
    cmd = 'ping www.baidu.com'
    a = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE)
    print(a.args)
    a.send_signal(signal.CTRL_C_EVENT)
    print(a.returncode)


def vpn_reconnect(timeForOtherThread = 60):
    """
    断开再连接 L2TP-VPN
    :param timeForOtherThread:
    :return:
    """
    print('当前线程sleep {}秒，以等待其他线程都sleep'.format(timeForOtherThread))
    print('使用os.open调用cmd模块')
    b = os.popen('rasdial VPNckcest6 /disconnect')
    print(b.read())
    time.sleep(3)
    c = os.popen('rasdial VPNckcest6 vpn_username vpn_password ')
    print(c.read())

if __name__ == '__main__':
    print('>>>>>>  os ')
    useCMD()
    my_subprocess()
    print('<<<<<<  os ')
