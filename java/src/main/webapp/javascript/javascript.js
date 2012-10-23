$(document).ready(function(){
	
	/*var table = new Table();
	alert(table.header(["ramon", "ramonox"]));
	
	table.add_atributes({"class":"ramonox", "border":"1"});
		  
	table.add_atributes({"id":"10", "cellpadding":"2"})
	
	var body_content = [['ramon'], ['henrique','gonçalves']];
	
	alert(table.body(body_content));
	
	table.see_atributes();
	*/
	
	//var url = 'http://igorribeirolima.s43.eatj.com/simuladordehomebroker/intraday/ativo/BBAS3/dataInicio/24-01-2011%2016:17/dataFim/24-01-2011%2016:17.json';
	var url = 'http://localhost:8080/simuladordehomebroker/intraday/ativo/BBAS3/dataInicio/24-01-2011%2016:17/dataFim/24-01-2011%2016:17.json';
	
	//$.get("jsonp/request.json", {"url":url}, function(jsonResponse){
	$.get(url, function(jsonResponse){
		var ativo_name, min_value, max_value, abertura;		
		ativo_name = jsonResponse[0].ativo.nome_pregao;
		min_value = jsonResponse[0].minimo;
		max_value = jsonResponse[0].maximo;
		abertura = jsonResponse[0].abertura;
		var table = new Table();
		table.header(["Ativo", "Abertura", "Máximo", "Mínimo"]);
		table.add_atributes({"class":"table", "border":"1", "id":"table_1"});
		table.body([[ativo_name, abertura, min_value, max_value]]); 
		
		$("#quotation").children(".content-box-table").append(table.table_render());				
		
		table.table_add_line([ativo_name+" (outro)", min_value+3.5, max_value+8.21], $("#table_1"));
	}, 'json')			
});	