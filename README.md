### Executar o MongoDB via Docker
```
docker run --name mongodb-fiap -d \
	--network fiap \
	-p 27017:27017 \
	-e MONGO_INITDB_ROOT_USERNAME=root \
	-e MONGO_INITDB_ROOT_PASSWORD=root \
	mongo
```

### Executar o Mongo-Express via Docker
```
docker run --name mongodb-express-fiap -d \
	--network fiap \
	-p 8081:8081 \
	-e ME_CONFIG_MONGODB_SERVER=mongodb-fiap \
	-e ME_CONFIG_BASICAUTH_USERNAME=root \
	-e ME_CONFIG_BASICAUTH_PASSWORD=root \
	-e ME_CONFIG_MONGODB_ADMINUSERNAME=root \
	-e ME_CONFIG_MONGODB_ADMINPASSWORD=root \
	-e ME_CONFIG_MONGODB_ENABLE_ADMIN=true \
	mongo-express
```
