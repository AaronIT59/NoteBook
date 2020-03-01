<%@page import="util.StringUtil"%>
<%@page import="com.mysql.cj.util.Util"%>
<%@page import="entity.tbl_profile"%>
<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>

	<jsp:include page="/WEB-INF/head_tag.jsp">
			<jsp:param value="Profile" name="title"/>
	</jsp:include>

<body>
	<%@include file="/WEB-INF/top_nav.jspf"%>
		
    <section class="container-fluid" id="main-body">
        <div class="row no-pad">
            <div class="col-md-8 no-pad">
                <div class="profile-header">
                    <div class="profile-header-top">
                        <span id="profile-button-add-cover"><i class="fa fa-camera" aria-hidden="true"></i> Add Cover Photo</span>
                        <img src="resources/img/${user.getAvata()}">
                        <h3>${user.getLast_name()} ${user.getFirst_name()}</h3>
                        <a href="" id="profile-button-update-info">Update Info <span>1</span></a>
                        <a href="" id="profile-button-view-log">View Activity Log <span>5</span></a>
                    </div>
                    <ul class="profile-header-nav">
                        <li></li>
                        <li><a href="/">Timeline</a></li>
                        <li><a href="/">About</a></li>
                        <li><a href="/">Friends</a></li>
                        <li><a href="/">Photos</a></li>
                        <li><a href="/">More <i class="fa fa-caret-down" aria-hidden="true"></i></a></li>
                    </ul>
                </div>
                <div class="profile-body">
                    <div class="profile-body-header">
                        <h3><i class="fa fa-user" aria-hidden="true"></i> About</h3>
                    </div>
                    <div class="profile-body-content">
                        <div class="row no-pad">
                            <div class="col-md-4 profile-body-content-tool no-pad">
                                <a href="/" class="active">Overview</a>
                                <a href="/">Work and education</a>
                                <a href="/">Places you've lived</a>
                                <a href="/">Contact information</a>
                                <a href="/">Family and relationship</a>
                                <a href="/">Detailed about you</a>
                                <a href="/">Life events</a>
                            </div>
                            <div class="col-md-8 profile-body-content-editing">
                                <h4>Overview</h4>
                                <div class="overview-form">
                                
                                  <form action="changeProfile" method="post">
                                  			<p style="color: green;">${status1}</p>
                                  			<p style="color: red;">${status2}</p>
                                          <label>First Name:</label>
                                          <input required type="text" name="first-name" maxlength="30" value="${user.getFirst_name()}" />

                                          <label>Last Name:</label>
                                          <input required type="text" name="last-name" maxlength="30" value="${user.getLast_name()}" />
										
                                          <label>Email/Mobile:</label>
                                          <input required type="text" name="mobile-or-email" value="${user.getEmail_mobile()}" />
											
										  <label>Password:</label>
                                          <input type="text" name="user-password" value="" />	
											
                                          <label>Sex:</label>
                                          <input  type="radio" name="sex" value="male" id="male"> <label class="light" for="male" >Male</label>
                                          <input  type="radio" name="sex" value="female" id="female"> <label class="light" for="female" >Female</label>

                                          <label style="display:block;">Birthday</label>
                                          <div class="reg-input">
                                              <select name="day" id="days" >
                                                  <option value="day" >Day</option>
                                              </select>
                                              <select name="month" id="months">
                                                  <option value="month" >Month</option>
                                              </select>
                                              <select name="year" id="years">
                                                  <option value="year" >Year</option>
                                              </select>
                                          </div>

                                          <button type="submit">Save Changes</button>
                                      </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-2">
                <div class="middle-right-ads">
                    <h4>Sponsored</h4>
                    <div class="ads-item">
                        <img src="resources/img/ad1.jpg">
                        <a href="">ABC Banking</a>
                        <p>
                            ACB PRIVILEGE BANKING – TRỌN VẸN ĐẲNG CẤP Đồng hành cùng đẳng cấp và vị thế của bạn, phải...
                        </p>
                    </div>
                    <div class="ads-item">
                        <img src="resources/img/ad2.jpg">
                        <a href="">ABC Banking</a>
                        <p>
                            ACB PRIVILEGE BANKING – TRỌN VẸN ĐẲNG CẤP Đồng hành cùng đẳng cấp và vị thế của bạn, phải...
                        </p>
                    </div>
                    <div class="ads-item">
                        <img src="resources/img/ad3.png">
                        <a href="">ABC Banking</a>
                        <p>
                            ACB PRIVILEGE BANKING – TRỌN VẸN ĐẲNG CẤP Đồng hành cùng đẳng cấp và vị thế của bạn, phải...
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-2 no-pad">
                <div id="online-list">
                    <ul>
                        <li>
                            <img src="resources/img/friend1.jpg">
                            <span>Trung Hiếu</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/friend2.jpg">
                            <span>Hồng Ngọc</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/friend3.jpg">
                            <span>Ca Chua</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/avatar.jpg">
                            <span>Hà An</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/user-comment1.jpg">
                            <span>Hồng Ngọc</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/user_comment2.jpg">
                            <span>Hải Sơn</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/user-comment3.jpg">
                            <span>Hà Giang</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/friend1.jpg">
                            <span>Trung Hiếu</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/friend2.jpg">
                            <span>Hồng Ngọc</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/friend3.jpg">
                            <span>Ca Chua</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/avatar.jpg">
                            <span>Hà An</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/user-comment1.jpg">
                            <span>Hồng Ngọc</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/user_comment2.jpg">
                            <span>Hải Sơn</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/user-comment3.jpg">
                            <span>Hà Giang</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/friend1.jpg">
                            <span>Trung Hiếu</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/friend2.jpg">
                            <span>Hồng Ngọc</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/friend3.jpg">
                            <span>Ca Chua</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/avatar.jpg">
                            <span>Hà An</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/user-comment1.jpg">
                            <span>Hồng Ngọc</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/user_comment2.jpg">
                            <span>Hải Sơn</span>
                            <span></span>
                        </li>
                        <li>
                            <img src="resources/img/user-comment3.jpg">
                            <span>Hà Giang</span>
                            <span></span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    	<%
    		tbl_profile user = (tbl_profile)session.getAttribute("user");   	
    		String[] birth = user.getBirthday().split("-");
    		String d = birth[0];
    		String m = birth[1];
    		String y = birth[2];
    		String s = user.getSex();
    	%>


    <script>
        $(function() {
        	
        	var day = "<%= StringUtil.getString(d) %>";
        	var month = "<%= StringUtil.getString(m) %> ";
        	var year = "<%= StringUtil.getString(y) %> ";
        	
            for (var i = 1; i <= 31; i++) {
            	if(i==day) $("#days").append("<option selected>" + i + "</option>"); 
            	else $("#days").append("<option>" + i + "</option>");    
            }
            
            for (var i = 1; i <= 12; i++) {
            	if(i==month) $("#months").append("<option selected>" + i + "</option>"); 
            	else $("#months").append("<option>" + i + "</option>");    
            }
            
            for (var i = 2016; i >= 1905; i--) {
            	if(i==year) $("#years").append("<option selected>" + i + "</option>"); 
            	else $("#years").append("<option>" + i + "</option>");    
            }
           
            var selectedSex = "<%= StringUtil.getString(user.getSex()) %>";	
            $("input[name=sex][value=" + selectedSex +"]").prop('checked',true);
            
            var viewportHeight = $(window).height();
            $("#online-list").css("max-height", viewportHeight);
        });
    </script>
    <script src="resources/js/app.js"></script>
</body>

</html>
