<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@page import="util.Constant" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
//out.print(path);
request.setAttribute("path", path);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<div class="main wrap">
	<s:div id="houseArea">
		<table class="house-list">
		<s:if test="null == page || null == page.list || page.list.size<1">
	   		<tr>
	    		<td colspan="11"><center>无租房信息</center></td>
	    	</tr>
	   	</s:if>
	    <s:else>
		<s:iterator value="page.list" status="status">
			<tr <s:if test="#status.count%2 == 0"> class="odd"</s:if>>
				<td class="house-thumb">
					<span>
						<s:a href="house!show.action?house.id=%{id}">
						
							<s:if test='picture.url!=null && picture.url !=""'>
								<img src='<%=path%><s:property value="picture.url"/>' width="90" height="60" />
							</s:if><s:else>
								<img src="../images/thumb_house.gif" />
							</s:else>
						</s:a>
					</span>
				</td>
				<td>
					<dl>
						<dt>
							<s:a href="house!show.action?house.id=%{id}">
								<s:property value="title"/>
							</s:a>
						</dt>
						<dd>
							<s:if test="street != null">
								<s:property value="street.district.name"/>区
								<s:property value="street.name"/>,
							</s:if>
							<s:property value="floorage"/>平米<br />
							联系方式：<s:property value="contact"/>
						</dd>
					</dl>
				</td>
					<td class="house-type">
						<label class="ui-green">
							<input type="button" onclick='update(<s:property value="id"/>)' name="search" value="修    改" />
						</label>
					</td>
					<td class="house-price">
						<label class="ui-green">
							<input type="button" class="deleteButton" onclick='deleteHouse(<s:property value="id"/>)' name="search" value="删    除" />
						</label>
					</td>
			</tr>
	    </s:iterator>
	    </s:else>
		</table>
	</s:div>
	
	<s:include value="/page.jsp"></s:include>
</div>