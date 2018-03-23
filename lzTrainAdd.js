function ajax_init(response) {
	var dataWrap = response.getAjaxDataWrap("dataWrap");
	ajaxgrid.setData(dataWrap);
}

function save(){
	// 获取页面信息
	var tqmc = $("#tqmc").val();
	var gddwmc = $("#gddwmc").val();
	var gddwbm = $("#gddwbm").val();
	var message = "";
	if(tqmc == null || tqmc == ""){
		message += "请填名称<br/>";
	}
	if(gddwmc == null || gddwmc == ""){
		message += "请填供电单位名称<br/>";
	}
	if(gddwbm == null || gddwbm == ""){
		message += "请填写供电单位编码<br/>";
	}
	if(message != "")
    {
        $.alert("温馨提示",message);
        return
    }
	// 传递至后台保存
	var url = $$pageContextPath + "bds/datamining/lzTrainaddAction.do?action=save";
		$.ajax({
			url : url,
			type : 'post',
			dataType : "text",
			data : {
				tqmc:tqmc,
				gddwmc:gddwmc,
				gddwbm:gddwbm				
			},
			success : onsavecomplete

     });	
}
function onsavecomplete(response){
//	$.close(response.getMessage()) ;
	$.close("修改成功");
}