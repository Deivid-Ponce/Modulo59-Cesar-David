package com.ebac.modulo60;

import com.ebac.modulo60.dto.DireccionDTO;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Main {
    public static <Document, ObjectId> void main(String[] args) {

        Contexto ctx = new Contexto();

        System.out.println("===== MySQL (JPA) =====");

        DireccionDTO d = new DireccionDTO();
        d.setIdUsuario(1);
        d.setCalle("Av. Central");
        d.setNumero("101");
        d.setCiudad("CDMX");
        d.setEstado("CDMX");
        d.setPais("México");
        d.setCodigoPostal("01010");

        DireccionDTO guardada = ctx.guardarDireccion(d);
        System.out.println("Guardada MySQL: " + guardada.getIdDireccion());

        guardada.setCalle("Av. Central Actualizada");
        DireccionDTO actualizada = ctx.actualizarDireccion(guardada);
        System.out.println("Actualizada MySQL: " + actualizada.getCalle());

        System.out.println("Listado MySQL:");
        ctx.obtenerDirecciones().forEach(x ->
                System.out.println(x.getIdDireccion() + " | " + x.getCalle())
        );

        System.out.println("Eliminar MySQL...");
        ctx.eliminarDireccion(guardada.getIdDireccion());
        System.out.println("Eliminada.");

        System.out.println("===== MongoDB =====");

        Document doc = new Document()
                .append("calle", "Calle Mongo")
                .append("numero", "55")
                .append("ciudad", "CDMX");

        ctx.guardarDireccionMongo(doc);
        System.out.println("Guardada en Mongo.");

        System.out.println("Listado Mongo:");
        ctx.obtenerDireccionesMongo().forEach(System.out::println);

        if (!ctx.obtenerDireccionesMongo().isEmpty()) {
            Document uno = ctx.obtenerDireccionesMongo().get(0);
            ObjectId id = uno.getClass("_id");
            System.out.println("Actualizando Mongo...");
            ctx.actualizarDireccionMongo(id, new Document("ciudad", "Ciudad Nueva"));
            System.out.println("Eliminando Mongo...");
            ctx.eliminarDireccionMongo(id);
        }

        System.out.println("FIN DE PRUEBA.");
    }
}
