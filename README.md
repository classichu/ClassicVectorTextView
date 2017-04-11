# ClassicVectorTextView 

支持像ImageView那样配合Vector设置tint的TextView

因为vector内部的fillColor的值不写死在api21以下会失效
所以有的时候ImageView会使用如下方式处理

     <ImageView
        android:id="@+id/id_iv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_arrow_forward_black_24dp"
        android:tint="@color/colorAccent"
         />


or

           ImageView imageView = (ImageView) findViewById(R.id.id_iv);
        imageView.setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary));


但是TextView想设置drawableRight类型就不行了。。。
所以就有了这个小玩意

     <com.classichu.vectortextview.ClassicVectorTextView
        android:id="@+id/id_cvtv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableRight="@drawable/ic_arrow_back_black_24dp"
        android:text="ClassicVectorTextView"
        app:classic_tint="@color/colorAccent" />


or

       ClassicVectorTextView classicVectorTextView= (ClassicVectorTextView) 	findViewById(R.id.id_cvtv);
       	 classicVectorTextView.setClassicColorFilter(ContextCompat.getColor(this,R.color.colorPrimary));






Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency  [![](https://jitpack.io/v/classichu/ClassicVectorTextView.svg)](https://jitpack.io/#classichu/ClassicVectorTextView)

	dependencies {
	        compile 'com.github.classichu:ClassicVectorTextView:x.x.x'
	}


