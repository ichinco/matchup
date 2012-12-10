class UrlMappings {

	static mappings = {
		"/$controller/$id?"(parseRequest:true){
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
