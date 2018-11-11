--terminal 
--mongod(servidor)
--terminal
--mongo(banco)
db.cliente.drop();

use banco7;

show dbs;
db;
db.cliente.insert([
{_id:100, nome:"xuma", email:"xuma@gmail.com", idade:27},
{_id:101, nome:"livia", email:"livia@gmail.com", idade:22},
{_id:102, nome:"rodrigo", email:"drigo@gmail.com", idade:25},
{_id:103, nome:"alisson", email:"alisson@gmail.com", idade:26}
]);

--mostra todos
db.cliente.find();

--procura um cliente
db.cliente.find({_id:101});

--mostra os menos de 25 anos
db.cliente.find(
{idade: {$lt:25}}
);

show collections;

db.cliente.update(
{"_id":100}, {$set:{idade:18}}, {multi:true}
);

db.cliente.remove(
{nome:"alisson"}
);

db.cliente.count();


