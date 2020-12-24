/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karshan.likelyAdmin.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.karshan.likelyAdmin.model.houses;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 *
 * @author Rasa Karshanguna
 */
@Service
public class houseService {
    public static final String COL_NAME="houses";

    public String saveHouseDetails(houses house) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document().set(house);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public houses getHouseDetails(String key) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(key);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();
        System.out.println(document);
        houses house;

        if(document != null){
            if(document.exists()) {
            house = document.toObject(houses.class);
            return house;
        }else {
            return null;
        }
        }
        return null;
        
    }
    
    public List<houses> getAllHouses() throws InterruptedException, ExecutionException{
        List<houses> houseList = new ArrayList<houses>();
        Firestore db = FirestoreClient.getFirestore();
        
        ApiFuture<QuerySnapshot> query = db.collection(COL_NAME).get();
        // ...
        // query.get() blocks on response
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot document : documents) {
          houseList.add(document.toObject(houses.class));
        }
        return houseList;
    }

    public String updateHouseDetails(houses house, String key) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(key).set(house);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteHouse(String key) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(key).delete();
        return writeResult.get().getUpdateTime().toString();
    }
}
