function ajax_init(response) {
	var dataWrap = response.getAjaxDataWrap("dataWrap");
	ajaxgrid.setData(dataWrap);
}
function save(){
	var tqbs = $("#tqbs").val();
	var tqmc = $("#tqmc").val();
	var gddwmc = $("#gddwmc").val();
	var gddwbm = $("#gddwbm").val();
	// 传递至后台保存
	var url = $$pageContextPath + "bds/datamining/lzTrainxgAction.do?action=save";
		$.ajax({
			url : url,
			type : 'post',
			dataType : "text",
			data : {
				tqbs:tqbs,
				tqmc:tqmc,
				gddwmc:gddwmc,
				gddwbm:gddwbm				
			},
			success:onsavecomplete
     });  
}
function onsavecomplete(response){
//	$.close(response.getMessage()) ;
	$.close("修改成功");
}
