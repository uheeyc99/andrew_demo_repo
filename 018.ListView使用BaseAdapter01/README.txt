List控件使用---SimpleAdapter使用详解（一） - 启舰 - 博客频道 - CSDN.NET
http://blog.csdn.net/harvic880925/article/details/17258789#comments


listView在开始绘制的时候，系统首先调用getCount（）函数，根据他的返回值得到listView的长度，然后根据这个长度，调用getView（）逐一绘制每一行。如果你的getCount（）返回值是0的话，列表将不显示，同样，return 1，就只显示一行。

系统显示列表时，首先实例化一个适配器（这里将实例化自定义的适配器）。当手动完成适配时，必须手动映射数据，这需要重写getView（）方法。系统在绘制列表的每一行的时候将调用此方法。getView()有三个参数，position表示将显示的是第几行，covertView是从布局文件中inflate来的布局。我们用LayoutInflater的方法将定义好的vlist2.xml文件提取成View实例用来显示。然后将xml文件中的各个组件实例化（简单的findViewById()方法）。这样便可以将数据对应到各个组件上了。但是按钮为了响应点击事件，需要为它添加点击监听器，这样就能捕获点击事件。至此一个自定义的listView就完成了，现在让我们回过头从新审视这个过程。系统要绘制ListView了，他首先获得要绘制的这个列表的长度，然后开始绘制第一行，怎么绘制呢？调用getView()函数。在这个函数里面首先获得一个View（实际上是一个ViewGroup），然后再实例并设置各个组件，显示之。好了，绘制完这一行了。那 再绘制下一行，直到绘完为止。