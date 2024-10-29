<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>File Upload</title>
</head>

<body>
<h2>File Upload</h2>

<s:form action="doUpload" namespace="/example" method="post" enctype="multipart/form-data">
    <s:file name="upload" label="File"/>
    <s:submit/>
</s:form>

</body>
</html>
