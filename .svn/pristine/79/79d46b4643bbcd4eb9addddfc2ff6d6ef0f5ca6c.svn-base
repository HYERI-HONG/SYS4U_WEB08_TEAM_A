(function(global, doc) {
	$.namespace("instagram.PostLike");
	
	instagram.PostLike = function(vo) {
		this.vo = vo;
	};
	
	instagram.PostLike.prototype.initialize = function() {
		
	};
	
	instagram.PostLike.prototype.destroyFunction = function(){
		
	};
	
	instagram.PostLike.prototype.like = function(){
		var post = new instagram.Post();
		var that = this;
		var param = {
				"memberNo" : _memberNo,
				"postNo" : this.vo.no
		};

		$.post(_actionUrl + "/ajax/like.do", param)
		.done(function(data) {
			post.initialize(data);
			post.renderPost();
		})
		.fail(function(e) {
		    console.log("error : " + e);
		});
	};
	
}(window, document))