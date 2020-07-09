[toc]

## 获取前端参数

### get请求参数的获取

* 获取RESTful风格的url参数 localhost:8080/hello/elliot

* "？"后面的参数形式  localhost:8080/getParam?name=elliot&age=20

* 默认参数

* 使用map接收所有参数 localhost:8080/mapParam?name=elliot&age=20

* 接收一个数组 localhost:8080/arrayParam?name=elliot&name=wang

* 使用对象接收参数 localhost:8080/objectParam?name=elliot&age=20


### post请求参数的获取

* controller接收form-data格式的POST数据

* 默认参数

* 使用map接收所有参数

* 接收一个数组

* 使用对象来接收参数

* 接收字符串文本数据

* 接收Json数据

* 使用Bean对象来接收数据