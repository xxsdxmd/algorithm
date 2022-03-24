# 数据结构和算法

## 1.介绍

> ​	**这是一个数据结构和算法专题的项目涵盖一些常见的算法题还有对应的模板**

## 2.数据结构和算法

### 2.1数据结构

* 数组 | 链表 | 栈 | 队列 | 树 | 图

### 2.2算法

* 扫描线 | BFS | DFS | 二分 | 分治 | 单调栈 | 单调队列 | 滑动窗口 | 排序算法 | 前缀和 | dp | 并查集 | 贪心 等

#### 2.2.1 排序算法

排序算法 (十大排序算法)

* 冒泡排序
* 选择排序
* 插入排序
* 希尔排序
* **快速排序**
* **归并排序**
* **堆排序**
* 计数排序
* 桶排序
* 基数排序

排序相关题目

* [最小K个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)
* [最大K个数](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)
* [排序链表](https://leetcode-cn.com/problems/sort-list/)
* [数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

#### 2.2.2 扫描线

模板

题目描述: [会议室](https://leetcode-cn.com/problems/meeting-rooms/)

> ​	给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。

```java
public boolean canAttendMeetings(int[][] intervals) {
    if(intervals == null || intervals.length == 0)
        return true;
    Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
    for(int i = 0; i < intervals.length; i++){
        if(i - 1 >= 0 && intervals[i][0] < intervals[i - 1][1])
            return false;
    }
    return true;
}
```

题目描述: [会议室二](https://leetcode-cn.com/problems/meeting-rooms-ii/)

> ​	给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
>
>  输入: [[0, 30],[5, 10],[15, 20]]
>  输出: 2

```java
 public int minMeetingRooms(int[][] intervals) { 
    List<int[]> list = new ArrayList<>();
    for (int[] interval : intervals) {
      list.add(new int[]{interval[0],1});
      list.add(new int[]{interval[1],-1});
    }
   Collections.sort(list,(a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
   int res = 0, cnt = 0;
   for (int[] point : list) {
     cnt += point[1];
     res = Math.max(res, cnt);
   }
   return res;
 }
```

* [合并区间](https://leetcode-cn.com/problems/merge-intervals/)
* [数飞机](https://www.lintcode.com/problem/391/)





