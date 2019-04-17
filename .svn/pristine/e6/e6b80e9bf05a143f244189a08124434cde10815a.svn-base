(function(global, doc) {
	$.namespace("instagram.PostList");
	
	instagram.PostList = function(){
	};
	
	instagram.PostList.prototype.initialize = function(){
		$("#main-content").empty();
		$("#eventSource").on("instagram.HiddenInsertPostBtn", function(e){
			$('#main-btn-insert').css({'visibility':'hidden'});
			$('#main-btn-insert').attr('disabled', true);
			$('#main-btn-insert-div').css({'visibility':'hidden'});
		});
		$('#main-btn-insert').css({'visibility':'visible'});
		$('#main-btn-insert').attr('disabled', false);
		$('#main-btn-insert-div').css({'visibility':'visible'});
		this.fetchList();
		console.log("PostList initialized");
	};
	
	instagram.PostList.prototype.fetchList = function(value){
		var that = this;
		var searchValue = value || $("#searchValue").val();
		var startRowIndex = $(".rownum").last().data("no") + 1 || 1;
		
		searchValue = encodeURIComponent(searchValue);
		
		$.get(`${_actionUrl}/ajax/list.do?searchValue=${searchValue}&startRowIndex=${startRowIndex}`)
		.done(function(data) {
			if (data.length == 0) {
				$("#btnNextPosts").click(function () {
					$("#nextPosts").remove();
				});
				return;
			}
			
			for (var i = 0; i < data.length; i++) {
				const postDiv = `
					<article class="post-article clearfix" id="post-${data[i].no}"></article>
					`;
				
				$("#main-content").append(postDiv);
				var post = new instagram.Post();
				post.initialize(data[i]);
				post.renderPost();
			}
			
			const nextPosts = `
				<div class="nextPosts" id="nextPosts">
	            	<input type="button" value="더 보기▽" id="btnNextPosts"/>
	            </div>
            `;
			
			$("#main-content").append(nextPosts);
			$("#btnNextPosts").click(function () {
				$("#nextPosts").remove();
				that.fetchList();
			});
			
		})
		.fail(function(e) {
		    console.log("error : " + e);
		});
		
	};
	
}(window, document))