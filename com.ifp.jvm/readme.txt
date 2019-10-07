XX  对虚拟机的设置
xm  对程序的设置


xms  初始化堆的大小(建议是最大内存的80%)
xmx  堆得最大的内存
xmn  设置新生代的大小(建议设置堆得1/3 或者 1/4)



Xss  设置栈大小

默认情况下，永久区是64M(-XX:PermSize)


-XX:MaxTenutingThreshold ,默认值为15，  配置对象从新生代中对象经过几次GC到老年代


大对象(新生代eden区无法装入时，也会直接进入老年代，如果老年代也招不开的话，直接内存溢出)
可配置对象大小超过指定大小后，直接进入老年代
-XX:PretenureSizeThreshold

-XX:PrintGCDetails  打印垃圾回收详情


TLAB 全称 Thread Local Allocation buffernn即线程本地分配的缓存，是一个线程专用的内存分配区域，
是为了加速对象分配而生的