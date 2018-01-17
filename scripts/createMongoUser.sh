#Creates a database and a user

mongo mySportsDB --eval 'db.sample.insert({"name":"test"})'

mongo mySportsDB --eval 'db.createUser(
  {
    user: "mySportsUser",
    pwd: "root.pwd",
    roles: [ { role: "userAdmin", db: "mySportsDB" } ]
  }
)'
