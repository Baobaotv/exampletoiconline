<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%-- <c:url value="/admin/listen-guide/list" var="listenGuidelineListUrl">
    <c:param name="urlType" value="url_list"/>
</c:url> --%>
<c:url value="/admin/user/list" var="userListUrl">
    <c:param name="urlType" value="url_list"/>
</c:url>

<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <div class="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>
        <div class="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div>
    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
             <fmt:message key="label.guideline.listen" bundle="${lang}"/>
             
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href='${listenGuidelineListUrl}'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        <%-- <fmt:bundle basename="ApplicationResources">
                        <fmt:message key="label.guideline.listen.list"></fmt:message>
                        </fmt:bundle> --%>
                      <fmt:message key="label.guideline.listen.list" bundle="${lang}"/> 
                    
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <!--Begin user  -->
    <ul class="nav nav-list">
        <li >
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-list"></i>
                <span class="menu-text"></span>
             <fmt:message key="label.dashboard" bundle="${lang}"/>
             
                <b class="arrow fa fa-angle-down"></b>
            </a>
            <b class="arrow"></b>
            <ul class="submenu">
                <li>
                    <a href='${userListUrl}'>
                        <i class="menu-icon fa fa-caret-right"></i>
                        <%-- <fmt:bundle basename="ApplicationResources">
                        <fmt:message key="label.guideline.listen.list"></fmt:message>
                        </fmt:bundle> --%>
                      <fmt:message key="label.user.list" bundle="${lang}"/> 
                    
                    </a>
                    <b class="arrow"></b>
                </li>
            </ul>
        </li>
    </ul>
    <!--End user  -->
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>