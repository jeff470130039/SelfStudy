app
		.controller(
				'UserInfoController',
				function() {
					jQuery(function($) {
						$(document).ready(
								function() {

									$.ajax({
										url : "./api/user/getUserInfo",
										type : "GET",
										dataType : "json",
										data : {},
										success : function(data) {

											$("#firstName")
													.text(data.firstName);
											$("#lastName").text(data.lastName);
											$("#name").text(data.fullName);
											$("#email").text(data.email);
											$("#joinDate").text(data.joinDate);
											$("#employeeId").text(data.employeeId);
											$("#phone").text(data.phone);
											$("#manager").text(data.manager);
											if(data.chineseName!="null"&&data.chineseName!=null){
												$("#ChineseName").text(data.chineseName);
											}											
											
											if(data.mobile!="null"&&data.mobile!=null){
												$("#mobile").text(data.mobile);
											}
											
											if(data.homeAddress!="null"&&data.homeAddress!=null){
												$("#homeAddress").text(data.homeAddress);
											}
											
											if(data.econtactName!="null"&&data.econtactName!=null){
												$("#contaceName").text(data.econtactName);
											}
											
											
											if(data.econtactNumber!="null"&&data.econtactNumber!=null){
												$("#contactNumber").text(data.econtactNumber);
											}
											
											var fileName=data.facePic;
											$("#facePic").attr("src","http://10.61.213.114:8083/DrmsStaticResource/images/"+fileName);
											animate();
											/* clickEven(); */
											clickEven2();
											picChange();

										},

									});
								});

						var animate = function() {
							var t, tt;
							var _div = document.getElementById("showChange");
							var obj = _div.getElementsByTagName('h2')[0];
							obj.style.bottom = "-50px";
							var change = function() {
								var obj_h = parseInt(obj.style.bottom);
								if (obj_h < 0) {
									obj.style.bottom = (obj_h + Math
											.floor((0 - obj_h) * 0.1))
											+ "px"
								}// if
								else {
									clearInterval(t)
								}
							}
							var back = function() {
								var obj_hh = parseInt(obj.style.bottom);
								if (obj_hh > -50) {
									obj.style.bottom = (obj_hh + Math
											.floor((-50 - obj_hh) * 0.1))
											+ "px"
								} else {
									clearInterval(tt)
								}
							}
							_div.onmouseover = function() {
								clearInterval(tt);
								t = setInterval(change, 10);
							}
							_div.onmouseout = function() {
								clearInterval(t);
								tt = setInterval(back, 10)
							}
						};
						var clickEven = function() {

							$("input:button")
									.click(
											function() {

												var str = $(this).val() == "Edit" ? "Save"
														: "Edit";
												$(this).val(str);
												$(this)
														.parent()
														.siblings(".changable")
														.each(
																function() {

																	obj_text = $(
																			this)
																			.find(
																					"input:text");

																	if (!obj_text.length) {
																		$(this)
																				.html(
																						"<input type='text' style='width:88%; margin:0; pandding:0;' value='"
																								+ $(
																										this)
																										.text()
																								+ "'>");
																	} else {
																		$(this)
																				.html(
																						obj_text
																								.val());
																	}
																});
												if ($(this).val() == "Edit") {
													saveEven();
												}
											});

						};
						var saveEven = function() {
							$.ajax({

								url : "./api/user/updateUserInfo",
								type : "GET",
								dataType : "json",
								data : {
									employeeId : $("#employeeId").text(),
									chineseName : $("#ChineseName").text(),
									mobile : $("#mobile").text(),
									homeAddress : $("#homeAddress").text(),
									econtactName : $("#contaceName").text(),
									econtactNumber : $("#contactNumber").text()
								},
								contentType : "application/json;charset=utf-8"
							});
						}

						/*
						 * var optionButtonHover= function(){
						 * 
						 * var picDom =$(".optionButton"); picDom.mouseover
						 * (function() {
						 * $(this).attr("src","images/btnfaqrename_focus.png");
						 * }).mouseout (function() {
						 * $(this).attr("src","images/btnfaqrename.png"); }); };
						 */
						var clickEven2 = function() {

							$(".optionButton")
									.click(
											function() {

												var str = $(this).attr("src") == "images/edit.jpg" ? "images/save.jpg"
														: "images/edit.jpg";
												$(this).attr("src", str);
												$(this)
														.parent()
														.siblings(".changable")
														.each(
																function() {

																	obj_text = $(
																			this)
																			.find(
																					"input:text");

																	if (!obj_text.length) {
																		$(this)
																				.html(
																						"<input type='text'  style='width:88%; margin:0; pandding:0;text-align:left' value='"
																								+ $(
																										this)
																										.text()
																								+ "'>");
																	} else {

																		$(this)
																				.html(
																						obj_text
																								.val());
																	}
																});
												if ($(this).attr("src") == "images/edit.jpg") {

													saveEven();
												}
											});

						};

						var picChange = function() {
							$("#facePicId")
									.change(
											function() {

												var $file = $(this);
												var fileObj = $file[0];
												var windowURL = window.URL
														|| window.webkitURL;
												var dataURL;
												var $img = $("#facePic");

												if (fileObj && fileObj.files
														&& fileObj.files[0]) {

													dataURL = windowURL
															.createObjectURL(fileObj.files[0]);
													$img.attr('src', dataURL);
												} else {

													dataURL = $file.val();
													var imgObj = document
															.getElementById("preview");
													imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
													imgObj.filters
															.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

												}
												ajaxFileUpload();
											});
						};

						var ajaxFileUpload = function() {
							alert("uploade");
							$.ajaxFileUpload({
								url : "./api/user/uploadFacePic",
								secureuri : false,
								fileElementId : 'facePicId',
								dataType : 'string',
								success : function(data) {
									window.location.reload();
								}
							})
						};

					});
				});
