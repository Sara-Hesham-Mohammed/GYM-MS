package rmi;

/**
 *
 * @author a_h_S
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class DataMapper implements Serializable {

    public MongoClient client;
    //new MongoClient("localhost",27017);
    public MongoDatabase database;
    private MongoCollection<Document> member;
    private MongoCollection<Document> trainer;
    private MongoCollection<Document> nutritionist;
    private MongoCollection<Document> locker;
    private MongoCollection<Document> gymclass;
    private MongoCollection<Document> dumdum;

    private Gson gson = new Gson();
    //.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
    //.create();

    public DataMapper() {
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient("localhost", 27017);
        database = client.getDatabase("Gym");
        member = database.getCollection("GymMembers"); // Collection name
        trainer = database.getCollection("GymTrainer");
        nutritionist = database.getCollection("GymNuturionist");
        locker = database.getCollection("GymLocker");
        gymclass = database.getCollection("GymClass");
        dumdum = database.getCollection("DUMMY");

    }

    public void insertMember(Member n) {
        member.insertOne(Document.parse(gson.toJson(n)));
        //member.insertMember(new Member("dummy@example.com", "Dummy User", 30));
        System.out.println("Member inserted.");
    }

    public void insertDummy(WorkoutPlan n) {
        dumdum.insertOne(Document.parse(gson.toJson(n)));
        System.out.println("dummy inserted.");
    }
//     public void insertStaff(Member s) {
//        member.insertOne(Document.parse(gson.toJson(s)));
//        System.out.println("Staff inserted.");
//    }

    public void insertTrainer(Trainer s) {
        trainer.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Trainer inserted.");
    }

    public void insertNutritionist(Nutritionist n) {
        nutritionist.insertOne(Document.parse(gson.toJson(n)));
        System.out.println("Nutritionist inserted.");
    }

    public void insertLocker(Locker n) {
        locker.insertOne(Document.parse(gson.toJson(n)));
        System.out.println("Locker inserted.");
    }

    public void insertGymClass(GymClass n) {
        gymclass.insertOne(Document.parse(gson.toJson(n)));
        System.out.println("GymClass inserted.");
    }

    public Member getMemberByMail(String email) {
        Document doc = member.find(Filters.eq("email", email)).first();
        Member result = gson.fromJson(doc.toJson(), Member.class);
        return result;
    }

    public Trainer getTrainerByMail(String email) {
        Document doc = trainer.find(Filters.eq("email", email)).first();
        Trainer result = gson.fromJson(doc.toJson(), Trainer.class);
        return result;
    }

    public Member getMemberByID(int id) {
        Document doc = member.find(Filters.eq("id", id)).first();
        Member result = gson.fromJson(doc.toJson(), Member.class);
        return result;
    }

    public Locker getLockerByID(int id) {
        Document doc = locker.find(Filters.eq("lockerId", id)).first();
        Locker result = gson.fromJson(doc.toJson(), Locker.class);
        return result;
    }

//    public void updateMember(Member s) {
//        Document doc = Document.parse(gson.toJson(s));
//        member.replaceOne(Filters.eq("email", s.getEmail()), doc);
//    }
    //Question 3
    public void updateMemberEmail(String name, String newEmail) {

        member.updateOne(Filters.eq("name", name), Updates.set("email", newEmail));
    }

    public void updateMembershipPlan(int usrID, MembershipPlan newPlan) {

        member.updateOne(Filters.eq("id", usrID), Updates.set("membershipPlan", newPlan));
    }

    public void updateGymClass(int ID, LocalDateTime starttime, LocalDateTime endtime) {
        gymclass.updateOne(Filters.eq("classID", ID), Updates.set("startTime", starttime));
        gymclass.updateOne(Filters.eq("classID", ID), Updates.set("endTime", endtime));
    }

    public void updateLockermem(int lockID, int usrID) {
        member.updateOne(Filters.eq("lockerId", lockID), Updates.set("userId", usrID));
    }

    //Question 5
    public void deleteMember(String name) {
        member.deleteOne(Filters.eq("name", name));
    }

    //Question 4
    public ArrayList<Member> getMemberbyAge(int age) {
        ArrayList<Member> result = new ArrayList();
        ArrayList<Document> docs = member.find(Filters.eq("age", age)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            result.add(gson.fromJson(jsonResult, Member.class));
        }
        return result;
    }

    public ArrayList<Locker> getAllLockersDB() {
        ArrayList<Locker> result = new ArrayList();
        ArrayList<Document> docs = locker.find(Filters.eq("isOccupied", 0)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            result.add(gson.fromJson(jsonResult, Locker.class));
        }
        return result;
    }

    public boolean requestLockerDB(int lockID) {
        boolean bool = false;
        Locker locker1 = getLockerByID(lockID);
        if (!locker1.isIsOccupied()) { //if locker is empty , requestlocker should return true
            return true;
        }
        return bool;
    }

    public void assignLockerDB(int lockID, int usrID) {
        Locker locker1 = getLockerByID(lockID);
        if (requestLockerDB(locker1.getLockerId())) { //if locker is empty, means admin assigns it now
            updateLockermem(lockID, usrID);
        }
        locker1.setUserId(usrID);
        locker1.setIsOccupied(true);
    }

    public String TrackProgress(int memID) {
        Member mem = getMemberByID(memID);
        String progress = "";
        progress = mem.getMemprogress();
        return progress;
    }

    public void close() {
        client.close();
    }

}
