package respository;

import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.dailyactivity.DailyActivity;

public class DailyActivityRepository implements FirestoreOperation<DailyActivity> {

    private CollectionReference ref;

    private DailyActivityRepository(){
        ref = FirebaseFirestore.getInstance().collection("dailyactivity");
    }


    @Override
    public Task<DocumentReference> add(DailyActivity object) {
        return ref.add(object);
    }

    @Override
    public Task<Void> remove(String id) {
        return ref.document(id).delete();
    }

    @Override
    public Task<DocumentSnapshot> get(String id) {
        return ref.document(id).get();
    }

    @Override
    public Task<Void> update(String id, Map<String, Object> updates) {
        return ref.document(id).update(updates);
    }

    @Override
    public Task<QuerySnapshot> list() {
        return ref.get();
    }

    public CollectionReference logRef(String id){
        return ref.document(id).collection("activityLog");
    }

    public Task<QuerySnapshot> getLog(String id){
        return logRef(id).get();
    }

    public Task<List<DocumentReference>> addLog(DailyActivity dailyActivity, ArrayList<Log> logs){

        return add(dailyActivity)
                .continueWithTask(task -> {

                    ArrayList<Task<DocumentReference>> tasks = new ArrayList<>();

                    for(Log log:logs){
                        Task<DocumentReference> t = logRef(task.getResult().getId()).add(log);
                        tasks.add(t);
                    }
                    return Tasks.whenAllSuccess(tasks);
                });
    }



}
