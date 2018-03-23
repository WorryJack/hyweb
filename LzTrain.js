function ajax_init(response) {
	var dataWrap = response.getAjaxDataWrap("dataWrap");
	ajaxgrid.setData(dataWrap);
}
function retrieve() {
	var currentTime = getCurrentTime()
	var startTime = start.getMask()
	var endTime = end.getValue()
	if(endTime > currentTime)
		{
			$.alert("温馨提示","不能选择未来时间")
			return 
		}
	if(startTime > currentTime)
		{
			$.alert("温馨提示","不能选择未来时间")
			return 
		}	
	if(startTime != "" && startTime != null && endTime != "" && endTime != null)
	{
		if(startTime > endTime)
		{
			$.alert("温馨提示","结束时间不能小于开始时间")
			return
		}
	}
	var data = ajaxgrid.collectData(true);
	var dataArr = [];
	dataArr.push(data);
	$.request({
		action : "retrieve",
		data : dataArr,
		success : ajax_init
	});
}
function getCurrentTime(){
	var myDate = new Date()
	var y = myDate.getFullYear();  
    var m = myDate.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;  
    var d = myDate.getDate(); 
    d = d < 10 ? ('0' + d) : d;
    var h = myDate.getHours();  
    var minute = myDate.getMinutes();  
    minute = minute < 10 ? ('0' + minute) : minute; 
    var seconds = myDate.getSeconds(); 
    seconds = seconds < 10 ? ('0' + seconds) : seconds;
    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+seconds;  
}
function onRestC(){
	$("#TQBHid").val("");
	start.setValue("");
	end.setValue("");
	var data = ajaxgrid.collectData(true) ;
	var dataArr = [] ;
	dataArr.push(data);
	$.request({
		action:"retrieve",
		data : dataArr,
		success:ajax_init
	}) ;
}

// 添加
function add(){
	
	$.showModalDialog({url:"lzTrainAdd.jsp"},
			"数据添加",
			onAddSuc,
			null,
			500,200,0);
/*	  $.request({
			action : "retrieve",
			data : dataArr,
			success : ajax_init
		});*/
}

// 双击时修改
function gridDblClick(index){
	var numIndex = index.rowIndex;  
	var record = ajaxgrid.getRecord(numIndex);
	var tqbs = record.get("tqbs");
	var tqmc = record.get("tqmc");
	var gddwmc = record.get("gddwmc");
	var gddwbm = record.get("gddwbm");
	var url = $$pageContextPath+'bds/datamining/lzTrainxg.jsp';
    $.showModalDialog({url:url,param:{tqbs:tqbs,tqmc:tqmc,gddwmc:gddwmc,gddwbm:gddwbm}},
			"数据修改",
			onAddSuc,
			null,
			500,250,0);
}
function onAddSuc(str){
	retrieve();//刷新上面的grid
	$.tips("温馨提示",str,2000);
	var dataWrap=new AjaxDataWrap("dataWrap");
	ajaxgrid1.setData(dataWrap) ;//将下面的grid清空
}
// 删除数据
function deleteRecords(){
	var records = ajaxgrid.collectData(false,"checked");
	var records1 = ajaxgrid.getCheckedRecords();
	if(records1 != null && records1 != ""){
		var checkedData = [];
		checkedData.push(records);
		$.confirm("提示信息","您确定删除选中数据吗？",
				function(){delRecords(checkedData)},null,null,null,{yes:"是",no:"否"});}
	else{
		$.alert("请先选择数据");
	}
}

// 删除数据
function delRecords(checkedData){
	$.request({
		action:"delete",
		data : checkedData,
		success:function(response){
			if(response.getErrorMessage() != ""){
				$.alert(response.getErrorMessage());
			}else{
				$.tips("提示信息","删除成功！",2000);
			}
			retrieve();
		}
	}) ;
}

