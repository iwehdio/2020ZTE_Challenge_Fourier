import csv
import time

# 记录程序开始的时间，读取csv数据
# 全局变量定义在函数下方
time0 = time.time()
file_path = r"G:\Part One+\Part14 傅里叶派\part2\5.8\Example.csv"
table = []
with open(file_path, 'r') as f:
    reader = csv.reader(f)
    for row in reader:
        table.append(row)

global number  # 所要搜索的环的长度的一半
global head  # 头节点编号
global interval
global l  # 存储头结点中找到的环
global s  # 用字典存储当前头节点下搜索到的半路径，键为半路径的尾节点编号，值为存储以该尾节点结束的半路径数组
aims = [2, 3, 4, 5, 6, 7]  # 所要存储的环的数量目标
countall = []  # 记录不同长度的环的数量
l, s = {}, {}

# 将邻接矩阵转换为邻接表，sourceA存储A部落中村民在B部落中的朋友编号，sourceB同理
# 按编号正负分辨村民是来自A还是B，A为正，B为负。同时为了避免0重复，编号的绝对值都加一
# 用一个数组存储会变快，而且索引少了判断
source = [[] for i in range(len(table) + len(table[0]) + 1)]
for i in range(len(table)):
    for j, v in enumerate(table[i]):
        if v == '1':
            source[i + 1].append(-j - 1)
            source[-j - 1].append(i + 1)


# 判断两个数组中是否有重复元素
def repeat(m, n):
    for i in m:
        if i in n:
            return False
    return True


def checkdiff(c, p1, p2):  # 判断这个环能衍生出多少有效环
    max_num = p1 - 1
    for i in c[number:]:  # 排序好的数组，前半部分是负的，不需要比较
        if i > max_num:  # 判断是否在范围中，越过右边界则不再比较
            if i > p2:
                break
            max_num = i
    return p2 - max_num


# 将所有环按其标准化排序的字符串为键，存储到字典并进行校验
def checkIn(c, p1, p2):
    if c not in l.keys():
        l[c] = ""
        return checkdiff(c, p1, p2) + 1
    return 0


# 对编号为 num 的村民的礼物进行传递
def convert(num, p2):  # A:1  B:-1
    thiscount = 0   # 遍历该节点所有的长度为环长一半的路径，下称半路径
    path = [num]  # 初始化路径
    DFS(num, number, 0, path)  # 开始搜索
    for k in s.keys():  # 遍历存储半路径的 s 字典
        for i, m in enumerate(s[k]):  # 字典的键为半路径的最后一个节点编号
            for n in s[k][i + 1:]:  # 在同一个键内部的数组进行匹配
                if repeat(m, n):  # 二者的交集只能为半路径的头尾
                    c = m + n + [head, k]  # 拼接
                    c.sort()  # 排序标准化
                    thiscount += checkIn(tuple(c), num, p2)  # 校验该环是否已经找到
    s.clear()  # 遍历完从一个节点出发的半路径后清空 s，更换头节点
    l.clear()
    return thiscount


# 深度优先搜索，传入遍历的节点、期望的路径长度、当前路径长度和半路径数组
def DFS(num, length, depth, path):
    if depth == length:  # 如果达到期望的路径数组，将其排序标准化后，
        # print(number*2, " ", path)  # 存入 s 字典，键为半路径的尾节点（如果该半路径未被找到）
        tr0 = path[-1]
        temppath = path[1:-1] + []
        temppath.sort()
        if tr0 in s.keys():  # 判断该半路径是否已经被找到
            if temppath not in s[tr0]:
                s[tr0].append(temppath)
        else:
            s[tr0] = [temppath]
        return
    for j in source[num]:  # 向下搜索
        if (j < 0 or j > head) and (j not in path):  # 去除半路径中已有的和编号大于头节点的数据
            DFS(j, length, depth + 1, path + [j])


if len(table) == 1344:
    interval = 192
elif len(table) == 256:
    interval = 64
index = [1]
for i in range(1, int(len(table) / interval)):
    index.append(interval * i + 1)

for x in aims:
    count = 0  # 初始化不同长度的环的数量
    for p1 in index:  # 不同区域的起始点
        p2 = p1 + interval - 1  # 不同区域的终点
        number = x  # 设置环长度、头节点，并进行传递
        head = p1
        count += convert(p1, p2)
    countall.append(count)

# 打印和输出结果
with open('result.txt', 'w') as res:
    for x, y in enumerate(aims):
        print('{:<18} {:<18}'.format(y*2, str(countall[x])))
        res.write(str(y*2) + "\t\t" + str(countall[x]) + "\n")
    # 总时间
    res.write("\n")
    print("time", time.time() - time0, " s")
    res.write("time: " + str(time.time() - time0) + " s")
