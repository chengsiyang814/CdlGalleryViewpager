# CdlGalleryViewpager
#Android 使用ViewPager打造3D画廊效果。
##主要实现思路是设置PageTransformer

PageTransformer是ViewPager的一个公共成员接口，用于设置当一个页面滑入和滑出的过度特效，当然，由于是通过属性动画来设置的，所以设置的pagetransformer在Android3.0以下会被忽略。

关于实现该接口，只需要实现一个方法即可：
```
　　public void transformPage(View page, float position);
```

对于参数position，需要好好说明一下：

position的取值有如下说明：

position是指的是页面相对于中间页面的位置参数，根据位置不同，0的时候在中间最前面，1的时候页面完全在右边，-1的时候页面完全在左边。如下图所示：

 

关于该接口的更多知识可以看鸿洋大大的这篇博客：http://blog.csdn.net/lmj623565791/article/details/40411921/
