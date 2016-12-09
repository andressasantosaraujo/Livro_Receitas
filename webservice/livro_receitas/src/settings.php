<?php
return [
    'settings' => [
        
        // Renderer settings
        'renderer' => [
            'template_path' => __DIR__ . '/../templates/',
        ],

        // Monolog settings
        'logger' => [
            'name' => 'slim-app',
            'path' => __DIR__ . '/../logs/app.log',
            'level' => \Monolog\Logger::DEBUG,
        ],

        //database
        'db' => [
        	'host'		=> 'localhost',
        	'dbname'	=> 'livro_receitas',
        	'user'		=> 'postgres',
        	'pass'		=> ''
        ]
    ],
];
