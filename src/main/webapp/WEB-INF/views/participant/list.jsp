<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title><s:text name="application.title"/></title>
</head>
<body>
	<a href="<s:url action='inputParticipant' />"><s:text name="label.participant.add"/></a>
	<s:if test="!participants.isEmpty()">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th><s:text name="label.firstName"/></th>
					<th><s:text name="label.lastName"/></th>
					<th><s:text name="label.gender"/></th>
					<th><s:text name="label.email"/></th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="participants">
					<tr>
						<td class="nowrap"><s:property value="firstName" /></td>
						<td class="nowrap"><s:property value="lastName" /></td>
						<td class="nowrap"><s:property value="gender" /></td>
						<td class="nowrap"><s:property value="email" /></td>
						<td class="nowrap"><s:url var="inputUrl"
								action="inputParticipant">
								<s:param name="participant.id" value="id" />
							</s:url> <a href="<s:property value="#inputUrl"/>"><s:text name="label.edit"/></a>
							&nbsp;&nbsp;&nbsp; <s:url action="deleteParticipant"
								var="deleteUrl">
								<s:param name="participant.id" value="id" />
							</s:url><a href="<s:property value="#deleteUrl"/>"><s:text name="label.delete"/></a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>
</body>
</html>
