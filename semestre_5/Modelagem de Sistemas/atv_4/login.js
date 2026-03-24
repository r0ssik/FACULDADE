const express = require('express');
const session = require('express-session');
const mysql = require('mysql');
const path = require('path');
const crypto = require('crypto');

const app = express();
const PORT = 1234;

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',         
    database: 'nodelogin' 
});

connection.connect((err) => {
    if (err) {
        console.error('Erro ao conectar ao banco de dados:', err);
        return;
    }
    console.log('Conectado ao banco de dados MySQL!');
});


app.use(express.urlencoded({ extended: true })); 
app.use(express.static(path.join(__dirname, 'static'))); 


app.use(session({
    secret: 'segredo123',
    resave: false,
    saveUninitialized: false
}));


app.get('/', (request, response) => {
    response.sendFile(path.join(__dirname + '/login.html'));
});


app.post('/auth', function(request, response) {

   
    let username = request.body.username;
    let password = request.body.password;

    
    if (username && password) {

        
        const hash = crypto.createHash('sha256').update(password).digest('hex');

        
        
        connection.query(
            'SELECT * FROM accounts WHERE username = ? AND password = ?',
            [username, hash],
            function(error, results, fields) {

                
                if (error) throw error;

                
                if (results.length > 0) {

                    
                    request.session.loggedin = true;
                    request.session.username = username;

                    
                    response.redirect('/home');

                } else {
                    
                    response.send('Usuário e/ou senha incorretos!');
                }

                response.end();
            }
        );

    } else {
        
        response.send('Por favor, informe usuário e senha!');
        response.end();
    }
});


app.get('/home', function(request, response) {

    if (request.session.loggedin) {
        
        response.sendFile(path.join(__dirname + '/static/home.html'));
    } else {
        
        response.redirect('/');
    }
});


app.get('/logout', function(request, response) {
    request.session.destroy((err) => {
        if (err) {
            return response.send('Erro ao encerrar a sessão.');
        }
        response.redirect('/');
    });
});


app.listen(PORT, () => {
    console.log(`Servidor rodando em http://localhost:${PORT}`);
});
