/**
 * Created by lonecloud on 2017/7/17.
 */
$(document).ready(
		function() {
			//以下代码就是动态生成数据表的代码
			$.jgrid.defaults.styleUI = 'Bootstrap';
			var mydata = {};
			//获取所有的用户
			$.ajax({
				url : "getAllUser",
				dataType : "json",
				type : "GET",
				data : {},
				success : function(data) {//成功返回函数
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
			function dataBind() {//数据绑定
				$("#table_list_2").jqGrid(//数据表初始化函数
						
						{
							data : mydata,
							datatype : "local",
							height : 450,
							autowidth : true,
							shrinkToFit : true,
							rowNum : 20,
							rowList : [ 10, 20, 30 ],
							colNames : [ 'id', '用户名', '真实姓名','昵称', '电子邮件', '性别',
									'QQ', '电话','地址' ],
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
								width : 30,
							}, {
								name : 'fullname',
								index : 'fullname',
								editable : true,
								width : 30
							},  {
								name : 'nickname',
								index : 'nickname',
								editable : true,
								width : 30
							},{
								name : 'email',
								index : 'email',
								editable : true,
								width : 50,
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
								width : 50,
								sortable : false
							}, {
								name : 'address',
								index : 'address',
								editable : true,
								width : 50,
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

				// Setup buttons
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
			/**
			 * 添加显示框
			 * @returns
			 */
			function addDig() {
				$(".modal-title").html("新增用户");//标题行
				$("#commit").click(function() {//提交按钮
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
				$('#mymadel').modal({//显示框
					keyboard : false
				});
			}
			/**
			 * 编辑按钮弹出函数
			 * @returns
			 */
			function editDig() {
				$(".modal-title").html("修改用户");
				var selectedRowId = $("#table_list_2").jqGrid("getGridParam",
						"selrow");
				// 获得当前行各项属性
				var rowData = $("#table_list_2").jqGrid("getRowData",
						selectedRowId);
				if (!selectedRowId) {
					alert("请先选择需要编辑的行!");
					return false;
				} else {
					var consoleDlg = $("#mymadel");

					consoleDlg.find("#id").val(rowData.id);
					consoleDlg.find("#username").val(rowData.username);
					consoleDlg.find("#fullname").val(rowData.fullname);
					consoleDlg.find("#nickname").val(rowData.nickname);
					consoleDlg.find("#email").val(rowData.email);
					consoleDlg.find(".sex").val(rowData.sex);
					consoleDlg.find("#qq").val(rowData.qq);
					consoleDlg.find("#tel").val(rowData.tel);
					consoleDlg.find("#address").val(rowData.address);
				}
				$("#commit").click(function() {
					$.ajax({
						url : "updateUser",
						dataType : "json",
						type : "POST",
						data : $("#userForm").serialize(),
						success : function(data) {
							if (ERROR != data.code) {
								alert(data.message);
								location.reload();
							} else {
								alert(data.message);
							}
						},
						error : function() {
							alert("请求失败")
						}
					});
				});
				$('#mymadel').modal({
					keyboard : false
				});
			}
			/**
			 * 删除显示框
			 * @returns
			 */
			function delDig() {
				$(".modal-title").html("删除用户");
				var selectedRowId = $("#table_list_2").jqGrid("getGridParam",
						"selrow");
				if (!selectedRowId) {
					alert("请先选择需要删除的行!");
					return false;
				}
				$.ajax({
					url : "delUser",//后台url
					dataType : "json",//后台返回数据类型（xml/text/json）
					type : "GET",//请求类型
					data : {//前台向后台发送的参数
						id : selectedRowId
					},
					success : function(data) {//成功回调函数
						if (ERROR != data.code) {
							alert(data.message);
							location.reload();
						} else {
							alert(data.message);
						}
					},
					error : function() {//失败回调函数
						alert("请求失败")
					}
				});
			}

		});