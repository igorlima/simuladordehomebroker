Table = function(){
	this._init();
}
Table.prototype = {
	
	thead: null,
	tbody: null,
	table_dom: null,
	atributes: null,
	
	_init: function(){
		this.atributes = new Array();	
	}, 	
	
	add_atributes: function(atts){		
		for(var i in atts){
			this.atributes[i] = atts[i];						
		}					
	},
	
	see_atributes: function(){		
		for(var key in this.atributes){
			alert("key = "+key+"; value = "+this.atributes[key]);
		}
	},
		
	header: function(properties){		
		this.thead = "<thead>";
		this.thead += "<tr>";
		var contentHead = "";
		$(properties).each(function(i, val){					
			contentHead += "<th>";
			contentHead += val;
			contentHead += "</th>";			
		});
		this.thead += contentHead;
		this.thead += "</tr>";
		this.thead += "</thead>";			
		return this.thead;
	},
			
	body: function(content){
		this.tbody = "<tbody>";
		for(var i in content){
			this.tbody += "<tr>";
			for(var j in content[i]){
				this.tbody += 	"<td>" + content[i][j] + "</td>";
			}			
			this.tbody += "</tr>";
		}
		this.tbody += "</tbody>";
		return this.tbody;
	},
	
	
	footer: function(){
		
	},
	
	table_add_line: function(content, table){
		var line = "<tr>";
		for(var i in content){
			line += "<td>"+content[i]+"</td>";
		}
		line += "</tr>";
		table.children("tbody").append(line);
	},
	
	table_render: function(){		
		this.table_dom = "<table ";
		for(var key in this.atributes){
			this.table_dom += key + "='"+this.atributes[key]+"' ";
		}									
		this.table_dom += ">";
		this.table_dom += this.thead;
		this.table_dom += this.tbody;
		this.table_dom += "</table>";
		return this.table_dom;
	}		
}