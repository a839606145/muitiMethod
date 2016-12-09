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

  


