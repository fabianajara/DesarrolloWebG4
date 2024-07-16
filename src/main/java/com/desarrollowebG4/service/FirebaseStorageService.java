package com.desarrollowebG4.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "homeawaydb-2b02b.appspot.com";

    //Esta es la ruta básica de este proyecto homeaway
    final String rutaSuperiorStorage = "homeAwayDB"; // o solo homeaway o desarrollowebG4 REVISAR LUEGO

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";

    //El nombre del archivo Json
    final String archivoJsonFile = "homeawaydb-2b02b-firebase-adminsdk-1uw3q-8bd111b9e9.json";
}
