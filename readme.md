# CounterDemo

`Jetpack Compose`的学习项目，用`Hilt`实现`MVVM`、依赖注入。



* `build.gradle`配置：

    * `project`中：

        ```kotlin
        plugins {
        	...
            id("com.google.dagger.hilt.android") version "2.44" apply false
        }
        ```

    * `app`中：

        ```kotlin
        plugins {
        	...
            kotlin("kapt")
            id("com.google.dagger.hilt.android")
        }
        
        android {
        	...
            compileSdk = 34
            
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }
        
        dependencies {
            ...
            // 导航
            val nav_version = "2.7.5"
            implementation("androidx.navigation:navigation-compose:$nav_version")
            // Hilt
            implementation("com.google.dagger:hilt-android:2.44")
            kapt("com.google.dagger:hilt-android-compiler:2.44")
            implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
        }
        
        kapt {
            correctErrorTypes = true
        }
        ```

        

* 踩坑记录：
    1. `di`目录下的`MyApp`类是必需的；在`AndroidManifest.xml`的`application`里添加`android:name=".di.MyApp"`
    2. `MainActivity`添加`@AndroidEntryPoint`
    3. `stateFlow`用`update`进行更新；在`view`中：`val state by viewModel.stateFlow.collectAsState()`

