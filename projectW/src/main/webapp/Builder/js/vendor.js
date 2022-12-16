function loadVendorOrderdetail(orderId) {
	$.ajax({
		url: "/ProjecltW/Vendor/ShowOrderDetail",
		type: "get",
		data: {
			exist: orderId      
		},
		success: function(data) {
			var row = document.getElementById("content");
			row.innerHTML += data;
			$(".closed-dongs").click(function() {
				$("div").remove(".showed");
			});

		},
		error: function(xhr) { }
	})
};

