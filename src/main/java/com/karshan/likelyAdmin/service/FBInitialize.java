/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karshan.likelyAdmin.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Rasa Karshanguna
 */
@Service
public class FBInitialize {
    @PostConstruct
    public void initialize() throws IOException {
            InputStream serviceAccount = this.getClass().getClassLoader().getResourceAsStream("./serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
              .setCredentials(GoogleCredentials.fromStream(serviceAccount))
              .setDatabaseUrl("https://likely-b96b4.firebaseio.com")
              .build();

            if (FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(options);
		}
       

    }
    public Firestore getFirebase() {
		return FirestoreClient.getFirestore();
	}
}
