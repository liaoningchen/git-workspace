XX  对虚拟机的设置  + 表示启用  - 表示禁用
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
是为了加速对象分配而生的，当大对象无法在TLAB上分配时候，则会分配到堆中
-XX:+UseTLAB 使用TLAB
-XX:TLABSize 设置TLAB大小
-XX:TLABRefillWasteFraction 设置维护进入TLAB空间的单个对象大小，它是一个比例值，默认是64
                            即如果对象大于整个空间的1/64 ，则在堆中创建对象

-XX:+PrintTLAB 查看TLAB信息
-XX:ResizeTLAB 自动调整 TLABRefillWasteFraction 阀值
