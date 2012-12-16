class UrlMappings {

	static mappings = {
		"/$controller/$id?"(parseRequest:true){
            action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
		}

		"/$controller/list"(parseRequest:true){
            action = "list"
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
