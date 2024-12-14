/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author Sara
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class Database {

    private MongoClient client= new MongoClient("localhost",27017);
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public Database() {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("Gym"); // Database name
        collection = database.getCollection("GymMembers"); // Collection name

    }
    //Question 1

    public void insertMember(Member s) {
        collection.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Member inserted.");
    }

    //Question 2
    public Member getMemberByMail(String email) {
        Document doc = collection.find(Filters.eq("email", email)).first();
        Member result = gson.fromJson(doc.toJson(), Member.class);
        return result;
    }
    
     public Member getMemberByID(int id) {
        Document doc = collection.find(Filters.eq("id", id)).first();
        Member result = gson.fromJson(doc.toJson(), Member.class);
        return result;
    }

    public void updateMember(Member s) {
        Document doc = Document.parse(gson.toJson(s));
        collection.replaceOne(Filters.eq("email", s.getEmail()), doc);
    }

    //Question 3
    public void updateMemberEmail(String name, String newEmail) {

        collection.updateOne(Filters.eq("name", name), Updates.set("email", newEmail));
    }
    
    public void updateMembershipPlan(int usrID, MembershipPlan newPlan) {

        collection.updateOne(Filters.eq("id", usrID), Updates.set("membershipPlan", newPlan));
    }


    //Question 5
    public void deleteMember(String name) {
        collection.deleteOne(Filters.eq("name", name));
    }

    //Question 4
    public ArrayList<Member> getMemberbyAge(int age) {
        ArrayList<Member> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("age", age)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            result.add(gson.fromJson(jsonResult, Member.class));
        }
        return result;
    }

    public void close() {
        client.close();
    }

}
