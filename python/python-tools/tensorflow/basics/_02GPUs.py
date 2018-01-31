'''
# 指定session图使用的cpu和gpu，图形默认会转换成分布式执行以加速计算。目前看来tf默认占用所有gpu但是真正只用上1块，不知为何，所以不要占用多块。
*. 下面的这种方法好像不行
    with tf.device('/cpu:0'):
        print(sess.run(product))
    with tf.device('/gpu:0'):
        print(sess.run(product))
*. 在环境变量（系统或者ide）中添加
    CUDA_VISIBLE_DEVICES = 0,1
    如pycharm中添加environment variables的k/v为 CUDA_VISIBLE_DEVICES = 0, 2, 3
*. 程序中设置
    import os
    os.environ["CUDA_DEVICE_ORDER"] = "PCI_BUS_ID"
    os.environ["CUDA_VISIBLE_DEVICES"] = "0,1"
'''

import tensorflow as tf
import os

print(__doc__)

os.environ["CUDA_DEVICE_ORDER"] = "PCI_BUS_ID"
os.environ["CUDA_VISIBLE_DEVICES"] = "2,3"


def get_available_devices(only_gpu=False):
    """
    获取当前可用的所有cpu和gpu列表，支持是否只返回gpu
    :param only_gpu:
    :return:
    """
    from tensorflow.python.client import device_lib
    local_device_protos = device_lib.list_local_devices()
    devices = [x.name for x in local_device_protos if x.device_type == 'GPU']
    if not only_gpu:
        devices.extend([x.name for x in local_device_protos if x.device_type == 'CPU'])
    return devices


if __name__ == '__main__':
    var1 = tf.Variable(initial_value=0, name='counter')  # 创建一个变量

    cons_one = tf.constant(1)
    res = tf.add(var1, cons_one)  # 用add将两个数值相加的操作op
    update = tf.assign(var1, res)  # 用assign进行变量的赋值操作op

    # Var变量必须先经过初始化操作op，进行初始化赋值
    init_op = tf.global_variables_initializer()

    with tf.Session() as sess:
        sess.run(init_op)  # 初始化op

        print(sess.run(var1))  # 变量初始化op

        for i in range(0, 20001):
            print(sess.run(update))

    print(get_available_devices(only_gpu=False))
    print(get_available_devices(only_gpu=1))
