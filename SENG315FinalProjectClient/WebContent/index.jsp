<%@include file=".\includes\clientHeader.jsp" %>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

<%
	if(view == null){
		view = "";
	}

	if(view.equals("articlelist")){%>
		<%@include file=".\includes\articleList.jsp"%>
	<%}else if(view.equals("article")){ %>
		<%@include file=".\includes\article.jsp"%>
	<%}else if(view.equals("categorylist")){ %>
		<%@include file=".\includes\categoryList.jsp"%>
	<%}else{%>
	<%@include file=".\includes\articleList.jsp" %>
		<%}%>


<%@include file=".\includes\clientSideBar.jsp" %>

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

<%@include file=".\includes\clientFooter.jsp" %>