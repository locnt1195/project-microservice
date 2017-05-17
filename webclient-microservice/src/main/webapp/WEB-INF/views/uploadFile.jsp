<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html 
     PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
     "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="<c:url value="resources/styles/bootstrap/3.3.5/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/styles/bootstrap/3.3.5/css/bootstrap-theme.min.css" />" />
    <link rel="stylesheet" href="<c:url value="resources/styles/pivotal.css" />" />
	<title>spring-microservices: Upload File</title>
</head>

<body>

	<div class="container">
		<div class="row">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
						<a title="Spring IO" href="http://www.spring.io"> 
							<img src="<c:url value="resources/images/spring-trans-dark.png"/>" height="50"/>
						</a>
					</div>
					<div>
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a href="http://www.pivotal.io">
									<img alt="Pivotal" title="Pivotal" height="20" src="<c:url value="resources/images/pivotal-logo-600.png" />" />
								</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
			<div style="text-align: right">[ <a href="/">Home</a> ]</div>
		</div>
		
		<div class="row">
			
			<h1>Upload File</h1>
			<div>
	        	<h2>${message}</h2>
		    </div>
	 
	    <div>
	        <form enctype="multipart/form-data" action="uploadFile" method="post">
	            <table>
	                <tr><td>File to upload:</td><td><input type="file" name="file" id="files" accept="image/*,video/*"/></td></tr>
	                <tr><td></td><td><input type="submit" id="uploadButton" value="Upload" /></td></tr>
	            </table>
	        </form>
	        <div id='progressBar' style='height: 20px; border: 2px solid green; margin-bottom: 20px'>
	            <div id='bar' style='height: 100%; background: #33dd33; width: 0%'>
	            </div>
	        </div>
	    </div>
	     
	    <a href="uploadFileList">Get List Files</a>
					
		</div>
		
	</div>

	<script>
	    var totalFileLength, totalUploaded, fileCount, filesUploaded;
	 
	    //To log everything on console
	    function debug(s) {
	        var debug = document.getElementById('debug');
	        if (debug) {
	            debug.innerHTML = debug.innerHTML + '<br/>' + s;
	        }
	    }
	 
	    //Will be called when upload is completed
	    function onUploadComplete(e) {
	        totalUploaded += document.getElementById('files').files[filesUploaded].size;
	        filesUploaded++;
	        debug('complete ' + filesUploaded + " of " + fileCount);
	        debug('totalUploaded: ' + totalUploaded);
	        if (filesUploaded < fileCount) {
	            uploadNext();
	        } else {
	            var bar = document.getElementById('bar');
	            bar.style.width = '100%';
	            bar.innerHTML = '100% complete';
	            //alert('Finished uploading file(s)');
	        }
	    }
	 
	    //Will be called when user select the files in file control
	    function onFileSelect(e) {
	        var files = e.target.files; // FileList object
	        var output = [];
	        fileCount = files.length;
	        totalFileLength = 0;
	        for (var i = 0; i < fileCount; i++) {
	            var file = files[i];
	            output.push(file.name, ' (', file.size, ' bytes, ', file.lastModifiedDate.toLocaleDateString(), ')');
	            output.push('<br/>');
	            debug('add ' + file.size);
	            totalFileLength += file.size;
	        }
	        document.getElementById('selectedFiles').innerHTML = output.join('');
	        debug('totalFileLength:' + totalFileLength);
	    }
	 
	    //This will continueously update the progress bar
	    function onUploadProgress(e) {
	        if (e.lengthComputable) {
	            var percentComplete = parseInt((e.loaded + totalUploaded) * 100 / totalFileLength);
	            var bar = document.getElementById('bar');
	            bar.style.width = percentComplete + '%';
	            bar.innerHTML = percentComplete + ' % complete';
	        } else {
	            debug('unable to compute');
	        }
	    }
	 
	    //the Ouchhh !! moments will be captured here
	    function onUploadFailed(e) {
	        //alert("Error uploading file");
	    }
	 
	    //Pick the next file in queue and upload it to remote server
	    function uploadNext() {
	        var xhr = new XMLHttpRequest();
	        var fd = new FormData();
	        var file = document.getElementById('files').files[filesUploaded];
	        fd.append("multipartFile", file);
	        xhr.upload.addEventListener("progress", onUploadProgress, false);
	        xhr.addEventListener("load", onUploadComplete, false);
	        xhr.addEventListener("error", onUploadFailed, false);
	        xhr.open("POST", "save-product");
	        debug('uploading ' + file.name);
	        xhr.send(fd);
	    }
	 
	    //Let's begin the upload process
	    function startUpload() {
	        totalUploaded = filesUploaded = 0;
	        uploadNext();
	    }
	 
	    //Event listeners for button clicks
	    window.onload = function() {
	        document.getElementById('files').addEventListener('change', onFileSelect, false);
	        document.getElementById('uploadButton').addEventListener('click', startUpload, false);
	    }
	</script>

</body>

</html>