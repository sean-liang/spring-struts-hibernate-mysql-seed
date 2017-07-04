<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title><s:text name="label.participant.edit"/></title>
</head>
<body>
	<s:actionerror />
	<s:actionmessage />
	<s:form action="saveParticipant" method="post">
		<s:textfield name="participant.firstName"
			value="%{participant.firstName}" label="%{getText('label.firstName')}" size="20"
			requiredLabel="true" />
		<s:textfield name="participant.lastName"
			value="%{participant.lastName}" label="%{getText('label.lastName')}" size="20"
			requiredLabel="true" />
		<s:select name="participant.gender" value="%{participant.gender}"
			label="%{getText('label.gender')}" list="genderOptions" />
		<s:textfield name="participant.email" value="%{participant.email}"
			label="%{getText('label.email')}" size="40" requiredLabel="true" />
		<s:hidden name="participant.id" value="%{participant.id}" />
		<s:submit value="%{getText('button.label.submit')}" />
		<s:submit type="cancel" value="%{getText('button.label.cancel')}" action="redirect-action:index" />
	</s:form>
</body>
</html>