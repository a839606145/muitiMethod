线程安全的类：
Vector
Statck
HashTable
Enumeraton
StringBuffer
CopyOnWriteArraySet
CopyOnWriteArrayList
ConcurrentLinkedQueue
BlockingQueue
ArrayBlockingQueue
LinkedBlockingQueue
PriorityBlockingQueue
SynchronousQueue
ConncurrentHashMap
Arrays方法：
 1.Arrays.copyOf()
 2.System.arraycopy
并发集合框架：
1.最上层是接口Iterable---只有一个方法 iterator()
2.接口Collection 接口继承了Iterable，提供了增删改查 功能,toArray()方法返回数组
3.接口List 继承Collection，根据索引操作数据
4.类ArrayList是非并发的，Vector是线程安全的，当使用Iteraotr进行删除时会报错，因此不能并发删除;
5.Vector源代码分析：
  Object[] 存放对象，elementCount 存放数据的个数
   内部含有一个可返回Enumeration的elements方法 已经被Iterator代替了 elements不能快速失败。
  clone()是深复制,但是hashCode是一样的
6.Vector 子类Stack
  增加方法 pop push  实现堆（同步堆）
7.LinkedList 链表（非同步）
  	使用transient Entry<E> header 表头；
 	Entry 是一个内部类含有E element;Entry<E> next;Entry<E> previous;是一个双向链表
       含有pop push方法可以作为队列或者栈。
8.set接口，特点是不允许重复，防止元素重复的原理是重写hashCode 和 equals 方法
9.HashSet 实现set接口，不安全
  内部使用HashMap<E,Object> map 来进行数据存储,HashMap 使用内部类Entry<K,V>[] 实现数据存储。
 HashMap中只有next 节点 是单向的。
 HashSet中提供了使用LinkedHashMap 创建的Map，来实现 LinkedHashSet.只是一个构造方法是default的，只能同包访问。
10.LinkedHashSet,继承了Hashset。使用hashset的default构造方法进行构造。
11.LinkedHashMap 继承了HashMap，里面多了一个头节点，使用双向链表进行组织数据在显示数据加入的顺序，数据的存储仍然使用HashMap中的table数组。
12.TreeSet 实现了HashSet 然后同时实现了SortedSet 和 NavigableSet接口。
13.Queue接口 实现了Collection接口.AbstractQueue实现了该接口。PriorityQueue实现了AbstractQueue,是一个非安全的类.对表头进行操作
14.Deque继承了Queue接口，添加对队尾的处理。LinkedList实现了Deque，ArrayDeque也实现了Deque。
15.HashMap 不是线程安全的，HashTable是线程安全的，Collection类都不支持多线程删除。
非阻塞队列：
ConcurrentHashMap：线程安全的 支持remove
ConcurrentSkipListMap：支持排序的线程安全的 remove Map
ConcurrentSkipListSet:支持排序的线程安全的 remove Set(不能重复)
ConcurrentLinkedQueue
ConcurrentLinkedDeque
CopyOnWriteArrayList
CopyOnWriteArraySet

阻塞队列：
ArrayBlockingQueue:阻塞等待，有界
PriorityBlockingQueue：含有排序功能的队列
LinkedBlockingQueue：无界的阻塞队列
LinkedBlockingDeque：对两端进行操作
SynchronousQueue：异步的队列，只能一个使用注意：take先启动
DelayQueue：队列中存放的数据 含有delay标注，根据标注进行执行
LinkedTransferQueue:1.7中才有


 


