package com.ebac.modulo60.mongo;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.*;

public class MongoDireccionModel {

    private final MongoClient client;
    private final MongoDatabase db;
    private final MongoCollection<Document> col;

    public MongoDireccionModel() {
        client = MongoClients.create("mongodb://localhost:27017");
        db = client.getDatabase("modulo60");
        col = db.getCollection("direcciones_mongo");
    }

    public void guardar(Document doc) { col.insertOne(doc); }

    public List<Document> obtenerTodos() {
        List<Document> list = new ArrayList<>();
        col.find().into(list);
        return list;
    }

    public Document obtenerPorId(org.bson.types.ObjectId id) {
        return col.find(new Document("_id", id)).first();
    }

    public boolean eliminar(org.bson.types.ObjectId id) {
        return col.deleteOne(new Document("_id", id)).getDeletedCount() > 0;
    }

    public boolean actualizar(org.bson.types.ObjectId id, Document data) {
        return col.updateOne(new Document("_id", id), new Document("$set", data))
                .getModifiedCount() > 0;
    }
}
