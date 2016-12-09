<?php
// Routes

$app->get('/receita/list', function ($request, $response) {


	$db = $this->db;
	foreach($db->query('SELECT * FROM receita') as $row){
		//dados da receita
		$result['id']				=$row['id'];
		$result['titulo']			=$row['titulo'];
		$result['ingredientes'] 	=$row['ingredientes'];
		$result['passo_passo']		=$row['passo_passo'];
	
		$return[] = $result;
	};

	return $response->withJson($return);
   	
});

$app->post('/receita/add', function($request, $response){

	$dados = $request->getParsedBody();

	var_dump($dados);

	$db = $this->db;
	$sth = $db->prepare("INSERT INTO receita(titulo, ingredientes, passo_passo) VALUES (?, ?, ?)");

	$insertReceita[0] = $dados['titulo'];
	$insertReceita[1] = $dados['ingredientes'];
	$insertReceita[2] = $dados['passo_passo'];

	$sth->execute($insertReceita);

	return $response->withJson($insertReceita);
});
