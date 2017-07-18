/**
 * Created by lonecloud on 2017/7/17.
 */
$(document).ready(function() {
	$.jgrid.defaults.styleUI = 'Bootstrap';
	var mydata = {};
	$.ajax({
		url : "getAllUser",
		dataType : "json",
		type : "GET",
		data : {},
		success : function(data) {
			if (ERROR != data.code) {
				mydata = data;
				dataBind();
			} else {

			}
		},
		error : function() {
			alert("请求失败")
		}
	});
	function dataBind() {
		$("#table_list_2").jqGrid({
			data : mydata,
			datatype : "local",
			height : 450,
			autowidth : true,
			shrinkToFit : true,
			rowNum : 20,
			rowList : [ 10, 20, 30 ],
			colNames : [ 'id', '用户名', '真实姓名', '电子邮件', '性别', 'QQ', '电话' ],
			colModel : [ {
				name : 'id',
				index : 'id',
				editable : false,
				width : 20,
				sorttype : "int",
				search : true
			}, {
				name : 'username',
				index : 'username',
				editable : true,
				width : 40,
			}, {
				name : 'fullname',
				index : 'fullname',
				editable : true,
				width : 50
			}, {
				name : 'email',
				index : 'email',
				editable : true,
				width : 60,
				align : "right",
			}, {
				name : 'sex',
				index : 'sex',
				editable : true,
				width : 20,
				align : "right",
				sorttype : "float"
			}, {
				name : 'qq',
				index : 'qq',
				editable : true,
				width : 40,
			}, {
				name : 'tel',
				index : 'tel',
				editable : true,
				width : 60,
				sortable : false
			} ],
			pager : "#pager_list_2",
			viewrecords : true,
			caption : "用户管理",
			add : true,
			edit : true,
			addtext : 'Add',
			edittext : 'Edit',
			hidegrid : false
		});

		// Add selection
		$("#table_list_2").setSelection(4, true);

//		 Setup buttons
		$("#table_list_2").jqGrid('navGrid', '#pager_list_2', {
			edit : true,
			add : true,
			del : true,
			search : true,
			addfunc : addDig,
			editfunc : editDig,
			delfunc : delDig
		}, {
			height : 200,
			reloadAfterSubmit : true,
		});

		// Add responsive to jqGrid
		$(window).bind('resize', function() {
			var width = $('.jqGrid_wrapper').width();
			$('#table_list_2').setGridWidth(width);
		});
	}
	function addDig(){
		$(".modal-title").html("新增用户");
		$("#commit").click(function(){
			$.ajax({
				url : "addUser",
				dataType : "json",
				type : "POST",
				data : $("#userForm").serialize(),
				success : function(data) {
					if (ERROR != data.code) {
                        alert("保存成功！");
						location.reload();
					} else {
						alert("保存失败！")
					}
				},
				error : function() {
					alert("请求失败")
				}
			});
		});
		$('#mymadel').modal({
			  keyboard: false
			})
	}
	function editDig(){
	}
	function delDig(){
	}
	
});