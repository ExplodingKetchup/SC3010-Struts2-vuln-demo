<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Result</title>
</head>

<body>
<h2><s:property value="message"/></h2>
<div>Hash: <s:property value="filehash"/></div>
<div>File name: <s:property value="filenameMsg"/></div>
<div>ContentType: <s:property value="contentTypeMsg"/></div>
</body>
</html>
