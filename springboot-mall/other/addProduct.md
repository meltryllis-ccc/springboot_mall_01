```html
<form class="form-horizontal" id="edit_reimburseRequest" th:action="@{/addpruduct}" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="pName" class="col-sm-2 control-label">商品名</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="pName" placeholder="商品名" name="pName" value="">
        </div>
    </div>
    <div class="form-group">
        <label for="info" class="col-sm-2 control-label">商品信息</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="info" placeholder="商品信息" name="info">
        </div>
    </div>
    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">价格</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="price" placeholder="价格" name="price">
        </div>
    </div>
    <div class="form-group">
        <label for="pic" class="col-sm-2 control-label">商品图片</label>
        <div class="col-sm-5">
            请上传足够清晰的照片            <br>
            <input type="file" id="pic" name="pic"/>
        </div>
    </div>
    <div class="form-group">
        <label for="pic" class="col-sm-2 control-label">商品详情</label>
        <div class="col-sm-5">
            <!-- 加载编辑器的容器 -->
            <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>        
        </div>
    </div>
    <p style="color: red" th:text="${msg}" th:if="${not #strings.isEmpty(msg)}"></p>    	<div class="modal-footer" style="text-align: center">
    	<input class="btn btn-primary" type="submit" value="提交申请">
    </div>
</form>
```



```html
<table>    <tr>        <td>商品名称</td>        <td><input class="easyui-textbox" name="pName" data-options="required:true" style="width:300px"></td>    </tr>    <tr>        <td>商品分类</td>        <td>            <select id="cc" class="easyui-combobox" name="category" style="width:300px;">            <option value="aa">aitem1</option>            <option>bitem2</option>            <option>bitem3</option>            <option>ditem4</option>            <option>eitem5</option>            </select>        </td>    </tr></table>
```

​	[thymeleaf循环遍历](https://www.cnblogs.com/xy888/p/9067286.html)