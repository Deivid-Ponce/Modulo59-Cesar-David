package com.ebac.modulo60;

import com.ebac.modulo60.dto.DireccionDTO;
import com.ebac.modulo60.model.DireccionModel;
import com.ebac.modulo60.mongo.MongoDireccionModel;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

public class Contexto<Document, ObjectId> {

    private final DireccionModel direccionModel = new DireccionModel();
    private final MongoDireccionModel mongoModel = new MongoDireccionModel();

    // MySQL CRUD
    public DireccionDTO guardarDireccion(DireccionDTO d) { return direccionModel.guardar(d); }
    public DireccionDTO actualizarDireccion(DireccionDTO d) { return direccionModel.actualizar(d); }
    public boolean eliminarDireccion(Integer id) { return direccionModel.eliminar(id); }
    public DireccionDTO obtenerDireccion(Integer id) { return direccionModel.obtener(id); }
    public List<DireccionDTO> obtenerDirecciones() { return direccionModel.obtenerTodos(); }

    // MongoDB CRUD
    public void guardarDireccionMongo(Document d) { mongoModel.guardar(d); }
    public List<Document> obtenerDireccionesMongo() { return mongoModel.obtenerTodos(); }
    public Document obtenerDireccionMongoById(ObjectId id) { return mongoModel.obtenerPorId(id); }
    public boolean eliminarDireccionMongo(ObjectId id) { return mongoModel.eliminar(id); }
    public boolean actualizarDireccionMongo(ObjectId id, Document d) { return mongoModel.actualizar(id, d); }
}
