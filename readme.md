踩坑记录：

1. `di`目录下的`MyApp`类是必需的；在`AndroidManifest.xml`的`application`里添加`android:name=".di.MyApp"`
2. `MainActivity`添加`@AndroidEntryPoint`
3. `stateFlow`用`update`进行更新；在`view`中：`val state by viewModel.stateFlow.collectAsState()`

